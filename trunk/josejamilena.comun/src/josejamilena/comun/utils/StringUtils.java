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



package josejamilena.comun.utils;

/**
 * Clases de utilidad para la manipulacion de Strings
 *
 * @author
 *
 */
public final class StringUtils {

    /**
     * <code>LINE_SEPARATOR</code> almacena el separador de lineas para formatear la salida
     */
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    //~--- constructors -------------------------------------------------------

    private StringUtils() {
        throw new AssertionError("Do not instantiate utility class");
    }

    //~--- get methods --------------------------------------------------------

    /**
     * Comprueba que una cadena tiene contenido (no es null y tiene caracteres diferentes a espacios en blanco).
     * @param tested cadena que se desea comprobar
     * @return true si la cadena tiene caracteres
     */
    public static boolean hasText(String tested) {
        return (tested != null) && (tested.trim().length() > 0);
    }
}
