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

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;

//~--- JDK imports ------------------------------------------------------------

import java.awt.Color;

import java.io.Serializable;

import java.util.StringTokenizer;

//~--- classes ----------------------------------------------------------------

/**
 * Esta clase contiene las propiedades con las que se creara un fichero Excel.
 *
 * @author IBM
 *
 */
public class ExcelProperties implements Serializable {
    private static final long serialVersionUID = -4579320003535684058L;

    //~--- fields -------------------------------------------------------------

    /**
     * Es el color por default de MAPFRE.
     */
    private String fontColorHeaderDefault = "209,0,0";
    private Logger logger                 = Logger.getLogger(ExcelProperties.class);

    /**
     * M�ximo de registros que se llenar�n en una p�gina de Excel. Valor por defecto 65534. Puede ser sobrescrito.
     */
    private int totalRowsPerSheet = 65534;

    // property adjust column

    /**
     * Variable que indica si las celdas se ajustar�n al tama�o del contenido.
     */
    private boolean adjust;

    /**
     * Estilo de la celda de la lista que se cargar� en Excel.
     */
    private HSSFCellStyle bodyStyle;

    // properties of border

    /**
     * Ancho del borde de las celdas.
     */
    private short border;

    // properties of fill

    /**
     * Color de fondo que se asignara a los t�tulos de las cabeceras.
     *
     * java.awt.Color
     *
     */
    private Color colorMapfre;

    /**
     * Color de la letra con el que se crear� la lista de elementos en Excel.
     */
    private short fillFontColorBody;

    /**
     * Color de la letra con el que se crear�n las cabeceras en Excel.
     */
    private short fillFontColorHeader;

    /**
     * Si se desea cambiar el color por defaul de MAPFRE asignado a las cabeceras de las
     * celdas, ser� necesario asignar el valor del color que se desea en RGB separado por
     * comas.
     *
     * Por ejemplo: "209,100,100"
     *
     */
    private String fontColorHeader;

    /**
     * Tipo de letra con el que se crear� el fichero Excel.
     */
    private String fontName;

    /**
     * Estilo de la celda de cabecera que se cargar� en Excel.
     */
    private HSSFCellStyle headerStyle;

    // properties of font

    /**
     * Tama�o de letra con el que se crear� el fichero Excel.
     */
    private short sizeFont;

    //~--- constructors -------------------------------------------------------

    /**
     * Constructor por default de la clase ExcelProperties.
     */
    public ExcelProperties() {
        this.fillFontColorHeader = HSSFColor.WHITE.index;
        this.fillFontColorBody   = HSSFColor.BLACK.index;

        // properties of fill
        this.colorMapfre = calculateColor(fontColorHeader);
    }

    //~--- methods ------------------------------------------------------------

    // Identifica el color que se desea mostrar en el header

    /**
     * Este m�todo convierte el parametro fontColorHeader en un java.awt.Color.
     *
     * @param fontColorHeader
     * @return
     * @throws ExcelRuntimeException
     */
    private Color calculateColor(String fontColorHeader) throws ExcelRuntimeException {
        String fch = fontColorHeader;
        Color  c;
        int    arrayColor[] = { 0, 0, 0 };
        int    i            = 0;

        try {
            if ((fch == null) || fch.equals("")) {
                fch = fontColorHeaderDefault;
            }

            StringTokenizer tokens = new StringTokenizer(fch, ",");

            while (tokens.hasMoreTokens()) {
                arrayColor[i] = Integer.valueOf(tokens.nextToken());
                i++;
            }

            c = new Color(arrayColor[0], arrayColor[1], arrayColor[2]);
        } catch (Exception e) {
            logger.error(
                "Est� mal formada la cadena correspondiente al color que se desea mostrar en el header del fichero Excel.");

            throw new ExcelRuntimeException(e.getMessage());
        }

        return c;
    }

    //~--- get methods --------------------------------------------------------

    // M�todos seter y geter.

    /**
     * @return Devuelve el estilo creado por el componente para las cabeceras
     *         que se mostrara en Excel.
     */
    public HSSFCellStyle getHeaderStyle() {
        return headerStyle;
    }

    //~--- set methods --------------------------------------------------------

    /**
     * @param headerStyle El nuevo estilo creado por el componente para las cabeceras
     *                    que se mostrara en Excel.
     */
    public void setHeaderStyle(HSSFCellStyle headerStyle) {
        this.headerStyle = headerStyle;
    }

    //~--- get methods --------------------------------------------------------

    /**
     * @return Devuelve el estilo creado por el componente para las celdas que se
     *         mostrara de la lista de elementos en Excel.
     */
    public HSSFCellStyle getBodyStyle() {
        return bodyStyle;
    }

    //~--- set methods --------------------------------------------------------

    /**
     * @param bodyStyle El nuevo estilo creado por el componente para las celdas
     *                                      que se mostrara de la lista de elementos en Excel.
     */
    public void setBodyStyle(HSSFCellStyle bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    //~--- get methods --------------------------------------------------------

    /**
     * @return Devuelve el tama�o de border de las celdas.
     */
    public short getBorder() {
        return border;
    }

    //~--- set methods --------------------------------------------------------

    /**
     * @param border El nuevo tama�o de border de las celdas.
     */
    public void setBorder(short border) {
        this.border = border;
    }

    //~--- get methods --------------------------------------------------------

    /**
     * @return Devuelve el color de fondo de las celdas de las cabeceras de para las
     *         celdas de Excel.
     */
    public Color getColorMapfre() {
        return colorMapfre;
    }

    //~--- set methods --------------------------------------------------------

    /**
     * @param colorMapfre El nuevo color de fondo de las celdas de las cabeceras de
     *                    para las celdas de Excel.
     *
     */
    public void setColorMapfre(Color colorMapfre) {
        this.colorMapfre = colorMapfre;
    }

    //~--- get methods --------------------------------------------------------

    /**
     * @return Devuelve el tama�o de letra que se utilizara para las celdas de Excel.
     */
    public short getSizeFont() {
        return sizeFont;
    }

    //~--- set methods --------------------------------------------------------

    /**
     * @param sizeFont El nuevo tama�o de letra que se utilizara para las celdas de
     *                 Excel.
     */
    public void setSizeFont(short sizeFont) {
        this.sizeFont = sizeFont;
    }

    //~--- get methods --------------------------------------------------------

    /**
     * @return Devuelve el nombre del tipo de letra que se utilizara para las celdas
     *         de Excel.
     */
    public String getFontName() {
        return fontName;
    }

    //~--- set methods --------------------------------------------------------

    /**
     * @param fontName El nuevo nombre del tipo de letra que se utilizara para las
     *                 celdas de Excel.
     */
    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    //~--- get methods --------------------------------------------------------

    /**
     * @return Devuelve el color de la letra de las celdas de la cabecera de las
     *         columnas de Excel.
     */
    public short getFillFontColorHeader() {
        return fillFontColorHeader;
    }

    //~--- set methods --------------------------------------------------------

    /**
     * @param fillFontColorHeader El nuevo color de la letra de las celdas de
     *                            la cabecera de las columnas de Excel.
     */
    public void setFillFontColorHeader(short fillFontColorHeader) {
        this.fillFontColorHeader = fillFontColorHeader;
    }

    //~--- get methods --------------------------------------------------------

    /**
     * @return Devuelve el color de la letra de las celdas de las columnas de la lista
     *         con la que se generara el Excel.
     */
    public short getFillFontColorBody() {
        return fillFontColorBody;
    }

    //~--- set methods --------------------------------------------------------

    /**
     * @param fillFontColorBody El nuevo color de la letra de las celdas de las
     *                          columnas de la lista con la que se generara el Excel.
     */
    public void setFillFontColorBody(short fillFontColorBody) {
        this.fillFontColorBody = fillFontColorBody;
    }

    //~--- get methods --------------------------------------------------------

    /**
     * @return Devuelve el valor para decidir si ajusta las columnas al tama�o del
     *         conternido.
     */
    public boolean isAdjust() {
        return adjust;
    }

    //~--- set methods --------------------------------------------------------

    /**
     * @param adjust El nuevo valor para decidir si ajusta las columnas al tama�o del
     *               conternido.
     */
    public void setAdjust(boolean adjust) {
        this.adjust = adjust;
    }

    /**
     * @param totalRowsPerSheet El nuevo total registros que se desplegaran por p�gina.
     */
    public void setTotalRowsPerSheet(int totalRowsPerSheet) {
        this.totalRowsPerSheet = totalRowsPerSheet;
    }

    //~--- get methods --------------------------------------------------------

    /**
     * @return Devuelve el total registros que se desplegaran por p�gina.
     */
    public int getTotalRowsPerSheet() {
        return totalRowsPerSheet;
    }

    //~--- set methods --------------------------------------------------------

    /**
     * @param fontColorHeader El nuevo color de las cabeceras de las columnas de Excel
     *                        en RGB.
     */
    public void setFontColorHeader(String fontColorHeader) {
        this.fontColorHeader = fontColorHeader;
    }

    //~--- get methods --------------------------------------------------------

    /**
     * @return Devuelve el color de las cabeceras de las columnas de Excel en RGB.
     */
    public String getFontColorHeader() {
        return fontColorHeader;
    }
}
