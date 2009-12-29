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



package josejamilena.comun.io.excel;

//~--- JDK imports ------------------------------------------------------------

import java.io.Serializable;

//~--- classes ----------------------------------------------------------------

/**
 * Clase que contiene el mapa entre las columnas y el t�tulo de las cabeceras que
 * se cargar�n en Excel.
 *
 * @author IBM
 *
 */
public class Header implements Serializable {
    private static final long serialVersionUID = -3185112888258384614L;

    //~--- fields -------------------------------------------------------------

    /**
     * Este atributo es el identificador de la lista de la cual se generar� el
     * fichero Excel.
     */
    private String idColumn;

    /**
     * Este atributo es el titulo de las cabeceras de las celdas del fichero Excel.
     */
    private String title;

    //~--- constructors -------------------------------------------------------

    /**
     * Constructor por default de la clase Header.
     */
    public Header() {}

    /**
     * Constructor de la clase Header que recibe el nuevo identificador de la columna.
     *
     * @param idColumn El nuevo t�tulo de la cabecera de la columna de Excel.
     */
    public Header(String idColumn) {
        this.idColumn = idColumn;
    }

    /**
     * Constructor de la clase Header que recibe el nuevo identificador de la columna
     * y el nuevo titulo de la columna.
     *
     * @param idColumn El nuevo identificador de la columna de Excel.
     * @param title El nuevo t�tulo de la cabecera de la columna de Excel.
     */
    public Header(String idColumn, String title) {
        this.idColumn = idColumn;
        this.title    = title;
    }

    //~--- methods ------------------------------------------------------------

    /*
     *  (sin Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime  = 31;
        int       result = 1;

        result = prime * result + ((idColumn == null)
                                   ? 0
                                   : idColumn.hashCode());

        return result;
    }

    /*
     *  (sin Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Header other = (Header) obj;

        if (idColumn == null) {
            if (other.idColumn != null) {
                return false;
            }
        } else if (!idColumn.equals(other.idColumn)) {
            return false;
        }

        return true;
    }

    //~--- set methods --------------------------------------------------------

    /**
     * @param title El nuevo t�tulo de la cabecera de la columna de Excel.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @param idColumn El nuevo identificador de la columna de Excel.
     */
    public void setIdColumn(String idColumn) {
        this.idColumn = idColumn;
    }

    //~--- get methods --------------------------------------------------------

    /**
     * @return Devuelve el t�tulo de la cabecera de la columna de Excel.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return Devuelve el identificador de la columna de la columna de Excel.
     */
    public String getIdColumn() {
        return idColumn;
    }
}
