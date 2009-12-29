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

//~--- JDK imports ------------------------------------------------------------

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

//~--- classes ----------------------------------------------------------------

/**
 * Clase de utilidades con formateadores de fechas.
 * <p>
 * Version 28/11/2008 Descripcion: Verision inicial
 *
 * @author
 * @version Entrega_28/11/2008
 */
public class DateFormater {

    /**
     * Constructor privado para instancia del Singleton
     */
    private DateFormater() {}

    //~--- get methods --------------------------------------------------------

    /**
     * Retorna una �nica instancia de la clase DateFormater, accediendo al
     * m�todo DateFormaterHolder Implementaci�n SingleTon
     *
     * @return DateFormater
     */
    public static DateFormater getInstance() {
        return DateFormaterHolder.instance;
    }

    //~--- methods ------------------------------------------------------------

    /**
     * Metodo de utilidad que cambia el formato de una fecha de entrada,
     * String, en formato "ddMMyyyy" para retornarla a formato
     * "yyyy-MM-dd" XSD SOA
     * @param date -Fecha de entrada en formato "ddMMyyyy"
     * @return fechaFinal - Fecha con el formateo realizado a "yyyy-MM-dd"
     * @throws ParseException
     */
    public String dateString2XSDDate(String date) throws ParseException {

        // recibe un string que represente una fecha y lo convierte en el tipo
        // xsd:Date
        // espera recibir un string del tipo ddMMyyyy
        DateFormat formatoString   = new SimpleDateFormat("ddMMyyyy");
        DateFormat formatoXsd_date = new SimpleDateFormat("yyyy-MM-dd");
        Date       fecha           = formatoString.parse(date);
        String     fechaFinal      = formatoXsd_date.format(fecha);

        return fechaFinal;
    }

    /**
     * Metodo de utilidad que cambia el formato de una fecha con tiempo,
     * String, en formato "ddMMyyyy HH:mm:ss" para retornarla a
     * formato "yyyy-MM-ddTHH:mm:ss" XSD SOA
     * @param date - Fecha de entrada en formato "ddMMyyyy HH:mm:ss"
     * @return fechaFinal - Fecha con el formateo realizado a "yyyy-MM-ddTHH:mm:ss"
     * @throws ParseException
     */
    public String dateTimeString2XSDDateTime(String date) throws ParseException {

        // recibe un string que represente una fecha con tiempo y lo convierte
        // en el tipo xsd:DateTime
        // espera recibir un string del tipo ddMMyyyy HH:mm:ss
        DateFormat formatoString   = new SimpleDateFormat("ddMMyyyy HH:mm:ss");
        DateFormat formatoXsd_date = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat formatoXsd_time = new SimpleDateFormat("HH:mm:ss");
        Date       fecha           = formatoString.parse(date);
        String     fechaFinal      = new StringBuffer(formatoXsd_date.format(fecha)).append('T').append(
                                         formatoXsd_time.format(fecha)).toString();

        return fechaFinal;
    }

    /**
     * Metodo de utilidad que cambia el formato de una fecha SOA XSD
     * "yyyy-MM-dd", a fecha en formato "ddMMyyyy"
     * @deprecated Usar el metodo {@link DateFormater#xSDDate2DateString(Date)}
     * @param date - Fecha de entrada en formato "yyyy-MM-dd"
     * @return fechaFinal - Fecha con el formateo realizado a "ddMMyyyy"
     * @throws ParseException
     */
    public String xSDDate2DateString(String date) throws ParseException {

        // recibe un string que represente un xsd:Date y retorna el formato date
        // espera recibir un string del tipo yyyy-MM-dd
        DateFormat formatoXsd_date = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat formatoString   = new SimpleDateFormat("ddMMyyyy");
        Date       fecha           = formatoXsd_date.parse(date);
        String     fechaFinal      = formatoString.format(fecha);

        return fechaFinal;
    }

    /**
     * Metodo de utilidad que cambia el formato de una fecha SOA xsd:date o xsd:datetime
     *  a fecha date o datetime en formato "ddMMyyyy" - "ddMMyyyy HH:mm:ss" respectivamente.
     *  Por la limitacion Java de no disponer de tipo de Dato DateTime se evaluan las horas:minutos:segundos
     *  y en caso de ser "00:00:00" se asume que el dato recibido es de tipo date y no datetime, con lo que
     *  se hace un substring para retornar solo la fecha en formato "ddMMyyyy"
     * @param date - Fecha de entrada
     * @return fechaFinal - Fecha con el formateo realizado a "ddMMyyyy" para date o "ddMMyyyy HH:mm:ss" para datetime
     * @throws ParseException
     */
    public String xSDDate2DateString(Date date) throws ParseException {

        // recibe un Date que representa un xsd:Date y retorna el formato date
        // SimpleDateFormat para formato
        // DateFormat formatoString = new SimpleDateFormat("ddMMyyyy");
        DateFormat formatoString = new SimpleDateFormat("ddMMyyyy HH:mm:ss");

        // Formateo de la fecha aplicando el patron
        String fechaFinal = formatoString.format(date);

        // Por la limitacion Java de no disponer de tipo de Dato DateTime se evaluan las horas:minutos:segundos
        // y en caso de ser "00:00:00" se asumira que el dato recibido es de date y no datetime, con lo que
        // se hara un substring para retornar solo la fecha en formato "ddMMyyyy"
        int iHoursPos = fechaFinal.indexOf("00:00:00");

        // Si es != -1 es que es Date y no DateTime
        if (iHoursPos != -1) {
            fechaFinal = fechaFinal.substring(0, (iHoursPos - 1));
        }

        return fechaFinal;
    }

    /**
     * Metodo de utilidad que cambia el formato de una fecha con tiempo SOA
     * XSD "yyyy-MM-ddTHH:mm:ss", a fecha con tiempo en formato
     * "ddMMyyyy HH:mm:ss"
     * @deprecated Usar el metodo {@link DateFormater#xSDDate2DateString(Date)}
     * @param date - Fecha de entrada en formato "yyyy-MM-ddTHH:mm:ss"
     * @return fechaFinal - Fecha con el formateo realizado a "ddMMyyyy HH:mm:ss"
     * @throws ParseException
     */
    public String xSDDateTime2DateTimeString(String date) throws ParseException {

        // recibe un string que represente un xsd:DateTime y lo convierte al
        // tipo dateTime
        // espera recibir un string del tipo yyyy-MM-ddTHH:mm:ss
        String sDateAux = "";

        sDateAux = date.replace('T', ' ');    // Le quito la T

        DateFormat formatoXsd    = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat formatoString = new SimpleDateFormat("ddMMyyyy HH:mm:ss");
        Date       fecha         = formatoXsd.parse(sDateAux);
        String     fechaFinal    = formatoString.format(fecha);

        return fechaFinal;
    }

    /**
     * Metodo de utilidad que cambia el formato de una fecha con tiempo SOA
     * XSD "yyyy-MM-ddTHH:mm:ss", a fecha con tiempo en formato
     * "ddMMyyyy HH:mm:ss"
     * @deprecated Usar el metodo {@link DateFormater#xSDDate2DateString(Date)}
     * @param date - Fecha de entrada
     * @return fechaFinal - Fecha con el formateo realizado a "ddMMyyyy HH:mm:ss"
     * @throws ParseException
     */
    public String xSDDateTime2DateTimeString(Date date) throws ParseException {

        // recibe un Date que representa un xsd:Date y retorna el formato date
        // SimpleDateFormat para formato
        DateFormat formatoString = new SimpleDateFormat("ddMMyyyy HH:mm:ss");

        // Formateo de la fecha aplicando el patron
        String fechaFinal = formatoString.format(date);

        return fechaFinal;
    }

    //~--- inner classes ------------------------------------------------------

    /**
     * Implementaci�n SingleTon
     *
     * @return DateFormater
     */
    private static class DateFormaterHolder {
        private static DateFormater instance = new DateFormater();
    }
}
