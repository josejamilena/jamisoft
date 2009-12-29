/*
 *   Copyright 2010 Jose Antonio Jamilena Daza
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */



package es.jamisoft.comun.io.excel;

//~--- non-JDK imports --------------------------------------------------------

import es.jamisoft.comun.io.excel.exceptions.ExcelRuntimeException;
import es.jamisoft.comun.utils.StringUtils;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

//~--- JDK imports ------------------------------------------------------------

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import java.io.ByteArrayOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

//~--- classes ----------------------------------------------------------------

/**
 * Esta Clase se encarga de gestionar la creaci�n de un fichero Excel, su m�todo principal
 * es createExcelFile.
 *
 * Las propiedades con las que se generara el fichero est�n contenidas en ExcelProperties,
 * esta clase tiene una configuraci�n por default, pero est�s pueden ser modificadas.
 *
 * Ejemlo:
 *      String columns = "dni=DNI;nombre=NOMBRE;apellidos=APELLIDO";
 *              ByteArrayOutputStream baos = excel.createExcelFile(commandData.getClientes(), columns);
 *
 * donde:
 *      commandData contendr�a la colecci�n de la cual se desea generar el fichero Excel.
 *
 * @author
 *
 */
public class ExcelGenerator {
    private static final String BEAN_INFO_TYPE_CLASS = "class";
    private static Logger       logger               = Logger.getLogger(ExcelGenerator.class);

    //~--- fields -------------------------------------------------------------

    /**
     * Contiene las propiedades que dar�n formato al crear el fichero Excel.
     */
    ExcelProperties ep;

    //~--- constructors -------------------------------------------------------

    /**
     * Constructor por default de la Clase ExcelGenerator.
     */
    public ExcelGenerator() {}

    //~--- methods ------------------------------------------------------------

    /**
     * Es el m�todo principal del componente y gestiona la creaci�n del fichero.
     *
     * @param data Colecci�n con la que se desea crear  el fichero Excel.
     * @param mapColumns Mapa con la relaci�n de los elementos de la colecci�n que
     *                   se desean mostrar y el titulo que tendr�n las cabeceras.
     *
     *                   Por ejemplo:
     *                   String mapColumns = "dni=DNI;nombre=NOMBRE;apellidos=APELLIDO";
     *
     *                   donde:
     *                   dni, nombre y apellidos, serian elementos de la colecci�n.
     *
     *                   y:
     *                   DNI, NOMBRE y APELLIDO, serian los t�tulos de las cabeceras.
     *
     * @return Devuelve un objeto ByteArrayOutputStream.
     */
    public ByteArrayOutputStream createExcelFile(List<?> data, String mapColumns) {
        HSSFWorkbook wb      = new HSSFWorkbook();
        List<Header> columns = new ArrayList<Header>();

        initStylesHeader(wb);
        initStylesBody(wb);

        List<List<?>> elements = createElementsForPages(data);

        if (StringUtils.hasText(mapColumns)) {
            columns = createHeader(mapColumns);
        } else {
            columns = createHeader(data.get(0));
        }

        Map<String, Method>   getterMethods = initMappings(data.get(0), columns);
        Iterator<List<?>>     pagesIterator = elements.iterator();
        int                   pageNumber    = 0;
        ByteArrayOutputStream baos          = new ByteArrayOutputStream();

        try {
            while (pagesIterator.hasNext()) {
                procesPage(pagesIterator.next(), wb, columns, getterMethods, pageNumber++);
            }

            wb.write(baos);
        } catch (Throwable e) {
            logger.error(e);
        }

        return baos;
    }

    /**
     * Este m�todo se encarga de generar las cabeceras y validar que los identificadores
     * de la colecci�n sean validos.
     *
     * @param mapColumns Mapa con la relaci�n de los elementos de la colecci�n que
     *                   se desean mostrar y el titulo que tendr�n las cabeceras.
     * @return Devuelve las cabeceras formadas ya con formato.
     * @throws ExcelRuntimeException
     */
    private List<Header> createHeader(String mapColumns) throws ExcelRuntimeException {
        List<Header> columns        = new ArrayList<Header>();
        List<String> listColumns    = new ArrayList<String>();
        String       columnSelected = "";

        try {
            StringTokenizer tokens = new StringTokenizer(mapColumns, ";");

            while (tokens.hasMoreTokens()) {
                listColumns.add(tokens.nextToken().trim());
            }

            for (int j = 0; j < listColumns.size(); j++) {
                String          column[]     = new String[2];
                int             i            = 0;
                StringTokenizer tokensColumn = new StringTokenizer(listColumns.get(j), "=");

                columnSelected = "";

                while (tokensColumn.hasMoreTokens()) {
                    columnSelected = tokensColumn.nextToken().trim();
                    column[i]      = columnSelected;
                    i++;
                }

                columns.add(new Header(column[0], column[1]));
            }
        } catch (Exception e) {
            logger.error("Est� mal formada la relaci�n de las columnas " + columnSelected
                         + " que se desean mostrar y el Nombre asignado al header del fichero Excel.");

            throw new RuntimeException(e);
        }

        return columns;
    }

    /**
     * Este m�todo se encarga de generar las cabeceras cuando el par�metro mapColumns es null.
     *
     * Crea la lista de tipo Header con todos los atributos del Bean.
     *
     * @param item Elemento que contiene la colecci�n, de �ste se obtendr�n sus elementos.
     * @return Devuelve las cabeceras formadas ya con formato.
     * @throws ExcelRuntimeException
     */
    private List<Header> createHeader(Object item) throws ExcelRuntimeException {
        List<Header> columns = new ArrayList<Header>();
        BeanInfo     beanInfo;

        try {
            beanInfo = Introspector.getBeanInfo(item.getClass());
        } catch (IntrospectionException e) {
            throw new ExcelRuntimeException(e.getMessage());
        }

        for (PropertyDescriptor p : beanInfo.getPropertyDescriptors()) {
            String beanPropertyName = p.getName();

            if (!BEAN_INFO_TYPE_CLASS.equals(p.getName())) {
                columns.add(new Header(beanPropertyName, beanPropertyName));
            }
        }

        return columns;
    }

    /**
     * Este m�todo gestiona el estilo que se proporcionar� a las cabeceras.
     *
     * @param wb Objeto Excel.
     */
    private void initStylesHeader(HSSFWorkbook wb) {

        // create instance of HSSFCellStyle
        HSSFCellStyle headerStyle = wb.createCellStyle();

        // Create Font Header
        createFontCell(wb, headerStyle, ep.getFillFontColorHeader());
        headerStyle.getFont(wb).setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        // Create style of header cell
        HSSFPalette palette         = wb.getCustomPalette();
        HSSFColor   colorMapfreHSSF = palette.findColor((byte) ep.getColorMapfre().getRed(),
                                          (byte) ep.getColorMapfre().getGreen(), (byte) ep.getColorMapfre().getBlue());

        if (colorMapfreHSSF == null) {
            palette.setColorAtIndex(HSSFColor.LAVENDER.index, (byte) ep.getColorMapfre().getRed(),
                                    (byte) ep.getColorMapfre().getGreen(), (byte) ep.getColorMapfre().getBlue());
            colorMapfreHSSF = palette.getColor(HSSFColor.LAVENDER.index);
        }

        short fillBGColor = colorMapfreHSSF.getIndex();

        headerStyle.setFillForegroundColor(fillBGColor);
        headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        // create border of header cell
        createBorderCells(headerStyle);

        // set
        ep.setHeaderStyle(headerStyle);
    }

    /**
     * Este m�todo gestiona el estilo que se proporcionar� a las celdas de la colecci�n.
     *
     * @param wb Objeto Excel.
     */
    private void initStylesBody(HSSFWorkbook wb) {

        // Create Font body
        HSSFCellStyle bodyStyle = wb.createCellStyle();

        createFontCell(wb, bodyStyle, ep.getFillFontColorBody());

        // create border of header body
        createBorderCells(bodyStyle);
        ep.setBodyStyle(bodyStyle);
    }

    /**
     * Este m�todo asigna el formato a los caracteres.
     *
     * @param wb Objeto Excel.
     * @param cellStyle Estilo de celda para crearl� formato a los caracteres.
     * @param fillFontColor Color que se asignara a los cartares.
     */
    private void createFontCell(HSSFWorkbook wb, HSSFCellStyle cellStyle, short fillFontColor) {

        // create instance of HSSFCellStyle
        HSSFFont fontHead = wb.createFont();

        // Create Font Header
        fontHead.setFontHeightInPoints(ep.getSizeFont());

        if (ep.getFontName() != null) {
            fontHead.setFontName(ep.getFontName());
        }

        fontHead.setColor(fillFontColor);

        // Fonts are set into a style so create a new one to use.
        cellStyle.setFont(fontHead);
    }

    /**
     * Este m�todo crea el border para una celda.
     *
     * @param cellStyle Estilo de celda para crearl� el border.
     */
    private void createBorderCells(HSSFCellStyle cellStyle) {

        // create border
        cellStyle.setBorderBottom(ep.getBorder());
        cellStyle.setBorderLeft(ep.getBorder());
        cellStyle.setBorderRight(ep.getBorder());
        cellStyle.setBorderTop(ep.getBorder());
    }

    /**
     * Este m�todo se encargara de rellenar las celdas con las columnas identificadas.
     *
     * @param data Colecci�n con la que se desea crear  el fichero Excel.
     * @param wb Objeto Excel.
     * @param columns Mapa con las cabeceras que se mostrar�n en el fichero Excel.
     * @param getterMethods Elementos identificados con los que se rellenar�n las celdas.
     * @param pageNumber N�mero de pagina que se generar�.
     * @throws Exception
     */
    private void procesPage(List<?> data, HSSFWorkbook wb, List<Header> columns, Map<String, Method> getterMethods,
                            int pageNumber)
            throws Exception {
        HSSFSheet sheet = wb.createSheet("Sheet " + pageNumber);

        createHeader(sheet, columns);

        for (int i = 1; i <= data.size(); i++) {

            // Create a row and put some cells in it. Rows are 0 based.
            HSSFRow row  = sheet.createRow(i);
            Object  item = data.get(i - 1);

            // Iterar sobre los elementos y en funcion de los mapeos generar la
            // cell
            for (int j = 0; j < columns.size(); j++) {
                HSSFCell           cell   = row.createCell(j);
                Method             getter = getterMethods.get(columns.get(j).getIdColumn());
                HSSFRichTextString v      = new HSSFRichTextString(String.valueOf(getter.invoke(item,
                                                (Object[]) null)));

                cell.setCellValue(v);
                cell.setCellStyle(ep.getBodyStyle());
            }

            // Adjust column with the content
            if (ep.isAdjust()) {
                for (int k = 0; k < columns.size(); k++) {
                    sheet.autoSizeColumn((short) k);
                }
            }
        }
    }

    /**
     * Este m�todo se encargar� de colocar la cabecera a la p�gina.
     *
     * @param sheet P�gina de Excel a la que se le tiene que crear la cabecera.
     * @param columns Mapa con las cabeceras que se mostrar�n en el fichero Excel.
     */
    private void createHeader(HSSFSheet sheet, List<Header> columns) {
        HSSFRow header = sheet.createRow(0);

        for (int i = 0; i < columns.size(); i++) {
            HSSFCell           c = header.createCell(i);
            HSSFRichTextString t = new HSSFRichTextString(columns.get(i).getTitle());

            c.setCellValue(t);
            c.setCellStyle(ep.getHeaderStyle());
        }
    }

    /**
     * Este m�todo calcula la cantidad de p�ginas que ser� necesario crea con base a
     * la tama�o de la colecci�n y el limite de registros por p�gina establecido.
     *
     * @param data Colecci�n con la que se desea crear  el fichero Excel.
     * @return Devuelve la lista con las p�ginas de Excel que ser� necesario crear.
     */
    private List<List<?>> createElementsForPages(List<?> data) {
        List<List<?>> pages             = new ArrayList<List<?>>();
        int           totalRowsPerSheet = ep.getTotalRowsPerSheet();
        int           pagesPerSheet     = data.size() / totalRowsPerSheet;

        for (int i = 0; i < pagesPerSheet; i++) {
            pages.add(data.subList(totalRowsPerSheet * i, totalRowsPerSheet * (i + 1)));
        }

        if (pagesPerSheet == 0) {
            pages.add(data.subList(0, data.size()));
        } else {
            pages.add(data.subList(pagesPerSheet * totalRowsPerSheet, data.size()));
        }

        return pages;
    }

    /**
     * Este m�todo identifica las columnas de la colecci�n que se desea mostrar
     *
     * @param item Elemento que contiene la colecci�n, de �ste se obtendr�n sus elementos.
     * @param columns Mapa con las cabeceras que se mostrar�n en el fichero Excel.
     * @return
     * @throws ArcException
     */
    private Map<String, Method> initMappings(Object item, List<Header> columns) {
        HashMap<String, Method> getterMethodsTemp = new HashMap<String, Method>();
        HashMap<String, Method> getterMethods     = new HashMap<String, Method>();
        BeanInfo                beanInfo;

        try {
            beanInfo = Introspector.getBeanInfo(item.getClass());
        } catch (IntrospectionException e) {
            throw new ExcelRuntimeException(e.getMessage());
        }

        for (PropertyDescriptor p : beanInfo.getPropertyDescriptors()) {
            String beanPropertyName = p.getName();

            if (!BEAN_INFO_TYPE_CLASS.equals(p.getName())) {
                getterMethodsTemp.put(beanPropertyName, p.getReadMethod());
            }
        }

        // si no se especifican columnas se muestran todos
        if ((columns == null) || columns.isEmpty()) {
            getterMethods = getterMethodsTemp;
        } else {

            // solo se mostrara si esta listado
            for (int i = 0; i < columns.size(); i++) {
                String idColumn = columns.get(i).getIdColumn();

                if (getterMethodsTemp.containsKey(idColumn)) {
                    getterMethods.put(idColumn, getterMethodsTemp.get(idColumn));
                } else {
                    throw new IllegalArgumentException("El objeto de la colecci�n no contiene el atributo "
                                                       + idColumn);
                }
            }
        }

        return getterMethods;
    }

    //~--- get methods --------------------------------------------------------

    /**
     * @return Devuelve las propiedades con las que se creara el fichero Excel.
     */
    public ExcelProperties getEp() {
        return ep;
    }

    //~--- set methods --------------------------------------------------------

    /**
     * @param ep Son las nuevas propiedades con las que se creara el fichero Excel.
     */
    public void setEp(ExcelProperties ep) {
        this.ep = ep;
    }
}
