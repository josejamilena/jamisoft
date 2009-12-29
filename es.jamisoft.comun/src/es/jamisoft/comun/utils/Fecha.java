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



package es.jamisoft.comun.utils;

//~--- non-JDK imports --------------------------------------------------------

import org.apache.log4j.Logger;

//~--- JDK imports ------------------------------------------------------------

import java.sql.Time;
import java.sql.Timestamp;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

//~--- classes ----------------------------------------------------------------

public class Fecha {
    private static final int   DIAS_30                          = 30;
    private static final int   DIAS_31                          = 31;
    private static final int   DIAS_FEBRERO_BISIESTO            = 29;
    private static final int   DIAS_FEBRERO_NO_BISIESTO         = 28;
    public static final String FORMATO_FECHA                    = "dd/MM/yyyy";
    public static final String FORMATO_HORA                     = "HH:mm";
    private static final int   HORAS_EN_UN_DIA                  = 24;
    private static final int   MESES_EN_UN_ANYO                 = 12;
    private static final int   MILESIMAS_EN_UN_SEGUNDO          = 1000;
    private static final int   MINUTOS_EN_UNA_HORA              = 60;
    private static final int   NUM_DIAS_SEMANA                  = 7;
    public static final long   ONE_HOUR                         = 0x36ee80L;
    private static final int   PERIODICIDAD_ANIOS_BISIESTOS_200 = 200;
    private static final int   PERIODICIDAD_ANIOS_BISIESTOS_4   = 4;
    private static final int   SEGUNDOS_EN_UN_MINUTO            = 60;
    private static Calendar    scCalendarioAuxiliar1            = Calendar.getInstance();
    private static Calendar    scCalendarioAuxiliar2            = Calendar.getInstance();
    private static ThreadLocal sthThreadDateFormat              = new ThreadLocal() {
        protected synchronized Object initialValue() {
            return new SimpleDateFormat();
        }
    };
    private static Logger slogLogger = Logger.getLogger(Fecha.class);

    //~--- constructors -------------------------------------------------------

    public Fecha() {}

    //~--- methods ------------------------------------------------------------

    public boolean esMesCorrecto(int aiMes) {
        return (aiMes >= 0) && (aiMes <= 11);
    }

    public static boolean esValida(int aiDia, int aiMes) {
        int liAnyo = getAnyoActual();

        return esValida(aiDia, aiMes, liAnyo);
    }

    public static boolean esValida(int aiDia, int aiMes, int aiAnyo) {
        boolean lbCorrecta = false;

        if ((aiAnyo > 0) && (aiMes <= 11) && (aiMes >= 0)) {
            int liDias = getDiasDelMes(aiMes, aiAnyo);

            if ((aiDia <= liDias) && (aiDia >= 1)) {
                lbCorrecta = true;
            }
        }

        return lbCorrecta;
    }

    public static boolean esValida(String asFecha) {
        try {
            stringToDate(asFecha);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean esValida(String asFecha, String asFormato) {
        try {
            stringToDate(asFecha, asFormato);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //~--- get methods --------------------------------------------------------

    public static int getDiasDelMes(int aiMes) {
        return getDiasDelMes(aiMes, getAnyoActual());
    }

    public static int getDiasDelMes(int aiMes, int aiAnyo) {
        int liMes = aiMes - 1;
        int liDias;

        switch (liMes) {
        case 3 :     // '\003'
        case 5 :     // '\005'
        case 8 :     // '\b'
        case 10 :    // '\n'
            liDias = 30;

            break;

        case 1 :     // '\001'
            liDias = ((aiAnyo % 4 != 0) && (aiAnyo % 200 != 0))
                     ? 28
                     : 29;

            break;

        case 2 :     // '\002'
        case 4 :     // '\004'
        case 6 :     // '\006'
        case 7 :     // '\007'
        case 9 :     // '\t'
        default :
            liDias = 31;

            break;
        }

        return liDias;
    }

    public static int getDiaNumeroDeLaSemana(Date adFecha) {
        Calendar lcalCalendario = Calendar.getInstance();

        lcalCalendario.setTime(adFecha);

        return lcalCalendario.get(7);
    }

    //~--- methods ------------------------------------------------------------

    public static int compararFecha(Date adFecha1, Date adFecha2) {
        int liComparacion = 0;

        if ((adFecha1 == null) && (adFecha2 == null)) {
            return 0;
        }

        if (adFecha1 == null) {
            return -1;
        }

        if (adFecha2 == null) {
            return 1;
        }

        synchronized (es.jamisoft.comun.utils.Fecha.class) {
            try {
                scCalendarioAuxiliar1.setTime(adFecha1);
                scCalendarioAuxiliar1.set(10, 0);
                scCalendarioAuxiliar1.set(12, 0);
                scCalendarioAuxiliar1.set(14, 0);
                scCalendarioAuxiliar1.set(13, 0);
                scCalendarioAuxiliar1.set(9, 9);

                Date ldFechaAux1 = scCalendarioAuxiliar1.getTime();

                scCalendarioAuxiliar2.setTime(adFecha2);
                scCalendarioAuxiliar2.set(10, 0);
                scCalendarioAuxiliar2.set(12, 0);
                scCalendarioAuxiliar2.set(14, 0);
                scCalendarioAuxiliar2.set(13, 0);
                scCalendarioAuxiliar2.set(9, 9);

                Date ldFechaAux2 = scCalendarioAuxiliar2.getTime();

                liComparacion = ldFechaAux1.compareTo(ldFechaAux2);
            } catch (Throwable lth) {
                slogLogger.error("Error comparando fechas, fecha1 ", lth);
            }
        }

        return liComparacion;
    }

    public static boolean menor(Date adFecha1, Date adFecha2) {
        return (adFecha1 != null) && (adFecha2 != null) && (compararFecha(adFecha1, adFecha2) < 0);
    }

    public static boolean igual(Date adFecha1, Date adFecha2) {
        return (adFecha1 != null) && (adFecha2 != null) && (compararFecha(adFecha1, adFecha2) == 0);
    }

    public static boolean menorIgual(Date adFecha1, Date adFecha2) {
        return (adFecha1 != null) && (adFecha2 != null) && (compararFecha(adFecha1, adFecha2) <= 0);
    }

    public static boolean mayor(Date adFecha1, Date adFecha2) {
        return (adFecha1 != null) && (adFecha2 != null) && (compararFecha(adFecha1, adFecha2) > 0);
    }

    public static boolean mayorIgual(Date adFecha1, Date adFecha2) {
        return (adFecha1 != null) && (adFecha2 != null) && (compararFecha(adFecha1, adFecha2) >= 0);
    }

    public static int compararHora(Date adFecha1, Date adFecha2) {
        int liReturn  = 0;
        int liHora1   = getHora(adFecha1);
        int liMinuto1 = getMinuto(adFecha1);
        int liHora2   = getHora(adFecha2);
        int liMinuto2 = getMinuto(adFecha2);

        if (liHora1 > liHora2) {
            liReturn = 1;
        } else if (liHora1 < liHora2) {
            liReturn = -1;
        } else if (liHora1 == liHora2) {
            if (liMinuto1 > liMinuto2) {
                liReturn = 1;
            } else if (liMinuto1 < liMinuto2) {
                liReturn = -1;
            } else {
                liReturn = 0;
            }
        }

        return liReturn;
    }

    public static int compararHoraCompleta(Date adFecha1, Date adFecha2) {
        int liReturn   = 0;
        int liHora1    = getHora(adFecha1);
        int liMinuto1  = getMinuto(adFecha1);
        int liSegundo1 = getSegundo(adFecha1);
        int liHora2    = getHora(adFecha2);
        int liMinuto2  = getMinuto(adFecha2);
        int liSegundo2 = getSegundo(adFecha2);

        if (liHora1 > liHora2) {
            liReturn = 1;
        } else if (liHora1 < liHora2) {
            liReturn = -1;
        } else if (liHora1 == liHora2) {
            if (liMinuto1 > liMinuto2) {
                liReturn = 1;
            } else if (liMinuto1 < liMinuto2) {
                liReturn = -1;
            } else if (liMinuto1 == liMinuto2) {
                if (liSegundo1 > liSegundo2) {
                    liReturn = 1;
                } else if (liSegundo1 < liSegundo2) {
                    liReturn = -1;
                } else {
                    liReturn = 0;
                }
            }
        }

        return liReturn;
    }

    public static boolean horaMenor(Date adFecha1, Date adFecha2) {
        return (adFecha1 != null) && (adFecha2 != null) && (compararHora(adFecha1, adFecha2) < 0);
    }

    public static boolean horaIgual(Date adFecha1, Date adFecha2) {
        return (adFecha1 != null) && (adFecha2 != null) && (compararHora(adFecha1, adFecha2) == 0);
    }

    public static boolean horaMenorIgual(Date adFecha1, Date adFecha2) {
        return (adFecha1 != null) && (adFecha2 != null) && (compararHora(adFecha1, adFecha2) <= 0);
    }

    public static boolean horaMayor(Date adFecha1, Date adFecha2) {
        return (adFecha1 != null) && (adFecha2 != null) && (compararHora(adFecha1, adFecha2) > 0);
    }

    public static boolean horaMayorIgual(Date adFecha1, Date adFecha2) {
        return (adFecha1 != null) && (adFecha2 != null) && (compararHora(adFecha1, adFecha2) >= 0);
    }

    public static int compararFechayHora(Date adFecha1, Date adFecha2) {
        Date ldFecha1 = adFecha1;
        Date ldFecha2 = adFecha2;

        if (ldFecha1 instanceof Timestamp) {
            ldFecha1 = new Date(((Timestamp) ldFecha1).getTime());
        }

        if (ldFecha2 instanceof Timestamp) {
            ldFecha2 = new Date(((Timestamp) ldFecha2).getTime());
        }

        return ldFecha1.compareTo(ldFecha2);
    }

    public static Date hoy() {
        return new Date();
    }

    public static Date hoySinHora() {
        Calendar lcCalendario = Calendar.getInstance();

        lcCalendario.set(10, 0);
        lcCalendario.set(12, 0);
        lcCalendario.set(13, 0);
        lcCalendario.set(9, 0);

        return lcCalendario.getTime();
    }

    public static String hoyTexto() {
        Date ldHoy = new Date();

        return dateToString(ldHoy);
    }

    public static String hoyTexto(String asFormato) {
        Date ldHoy = new Date();

        return dateToString(ldHoy, asFormato);
    }

    //~--- get methods --------------------------------------------------------

    public static int getAnyoActual() {
        Calendar lcCalendario = Calendar.getInstance();

        return lcCalendario.get(1);
    }

    public static int getMesActual() {
        Calendar lcCalendario = Calendar.getInstance();

        return lcCalendario.get(2) + 1;
    }

    public static int getDiaActual() {
        Calendar lcCalendario = Calendar.getInstance();

        return lcCalendario.get(5);
    }

    public static int getHoraActual() {
        Calendar lcCalendario = Calendar.getInstance();

        return lcCalendario.get(11);
    }

    public static int getMinutoActual() {
        Calendar lcCalendario = Calendar.getInstance();

        return lcCalendario.get(12);
    }

    public static int getSegundoActual() {
        Calendar lcCalendario = Calendar.getInstance();

        return lcCalendario.get(13);
    }

    public static int getHora(Time atHora) {
        long llValor = atHora.getTime();
        Date ldFecha = new Date(llValor);

        return getHora(ldFecha);
    }

    public static int getMinuto(Time atHora) {
        long llValor = atHora.getTime();
        Date ldFecha = new Date(llValor);

        return getMinuto(ldFecha);
    }

    public static int getSegundo(Time atHora) {
        long llValor = atHora.getTime();
        Date ldFecha = new Date(llValor);

        return getSegundo(ldFecha);
    }

    public static int getHora(Date adFecha) {
        Calendar lcCalendario = Calendar.getInstance();

        lcCalendario.clear();
        lcCalendario.setTime(adFecha);

        return lcCalendario.get(11);
    }

    public static Date getFormatoFecha(Date adFecha) {
        Calendar lcCalendario = Calendar.getInstance();

        lcCalendario.setTime(adFecha);
        lcCalendario.set(10, 0);
        lcCalendario.set(12, 0);
        lcCalendario.set(13, 0);

        return lcCalendario.getTime();
    }

    public static int getMinuto(Date adFecha) {
        Calendar lcCalendario = Calendar.getInstance();

        lcCalendario.clear();
        lcCalendario.setTime(adFecha);

        return lcCalendario.get(12);
    }

    public static int getSegundo(Date adFecha) {
        Calendar lcCalendario = Calendar.getInstance();

        lcCalendario.clear();
        lcCalendario.setTime(adFecha);

        return lcCalendario.get(13);
    }

    public static int getMilesimas(Date adFecha) {
        Calendar lcCalendario = Calendar.getInstance();

        lcCalendario.clear();
        lcCalendario.setTime(adFecha);

        return lcCalendario.get(14);
    }

    public static int getDia(Date adFecha) {
        Calendar lcCalendario = Calendar.getInstance();

        lcCalendario.clear();
        lcCalendario.setTime(adFecha);

        return lcCalendario.get(5);
    }

    public static int getMes(Date adFecha) {
        Calendar lcCalendario = Calendar.getInstance();

        lcCalendario.clear();
        lcCalendario.setTime(adFecha);

        return lcCalendario.get(2) + 1;
    }

    public static int getAnyo(Date adFecha) {
        Calendar lcCalendario = Calendar.getInstance();

        lcCalendario.clear();
        lcCalendario.setTime(adFecha);

        return lcCalendario.get(1);
    }

    public static int getSemana(Date adFecha) {
        Calendar lcCalendario = Calendar.getInstance();

        lcCalendario.clear();
        lcCalendario.setTime(adFecha);

        return lcCalendario.get(3);
    }

    public static Date[] getDiasSemana(Date adFecha) {
        Date     ldDiasSemana[] = new Date[7];
        Calendar lcCalendario   = Calendar.getInstance();

        lcCalendario.clear();
        lcCalendario.setTime(adFecha);

        int li = lcCalendario.get(7) - lcCalendario.getFirstDayOfWeek();

        if (li < 0) {
            li = 7 + li;
        }

        Date ldPrimerDiaSemana = sumaDia(adFecha, -li);

        for (int lj = 0; lj < 7; lj++) {
            ldDiasSemana[lj] = sumaDia(ldPrimerDiaSemana, lj);
        }

        return ldDiasSemana;
    }

    //~--- methods ------------------------------------------------------------

    public static String dateToString(Date adFecha) {
        return dateToString(adFecha, "dd/MM/yyyy");
    }

    public static String dateToString(Date adFecha, String asFormato) {
        if (adFecha != null) {
            get().applyLocalizedPattern(asFormato);

            return get().format(adFecha);
        } else {
            return "";
        }
    }

    //~--- get methods --------------------------------------------------------

    public static SimpleDateFormat get() {
        return (SimpleDateFormat) (SimpleDateFormat) sthThreadDateFormat.get();
    }

    //~--- methods ------------------------------------------------------------

    public static String horaToString(Date adFecha) {
        return dateToString(adFecha, "HH:mm");
    }

    public static Date stringToDate(String asFecha) throws ParseException {
        return stringToDate(asFecha, "dd/MM/yyyy");
    }

    public static Date stringToDate(String asFecha, String asFormato) throws ParseException {
        ParsePosition    lppPos       = new ParsePosition(0);
        SimpleDateFormat lsdfFormatea = new SimpleDateFormat(asFormato);

        lsdfFormatea.setLenient(false);

        return lsdfFormatea.parse(asFecha);
    }

    public static Date sumaDia(Date adFecha, int aiNum) {
        GregorianCalendar lgcFecha = new GregorianCalendar();

        lgcFecha.setTime(adFecha);
        lgcFecha.add(5, aiNum);

        return lgcFecha.getTime();
    }

    public static Date sumaMes(Date adFecha, int aiNum) {
        GregorianCalendar lgcFecha = new GregorianCalendar();

        if (adFecha != null) {
            lgcFecha.setTime(adFecha);
            lgcFecha.add(2, aiNum);

            return lgcFecha.getTime();
        } else {
            return null;
        }
    }

    public static Date sumaAnyo(Date adFecha, int aiNum) {
        GregorianCalendar lgcFecha = new GregorianCalendar();

        lgcFecha.setTime(adFecha);
        lgcFecha.add(1, aiNum);

        return lgcFecha.getTime();
    }

    public static Date sumaSemana(Date adFecha, int aiNum) {
        GregorianCalendar lgcFecha = new GregorianCalendar();

        lgcFecha.setTime(adFecha);
        lgcFecha.add(4, aiNum);

        return lgcFecha.getTime();
    }

    public static Date sumaHora(Date adFecha, int aiNum) {
        GregorianCalendar lgcFecha = new GregorianCalendar();

        lgcFecha.setTime(adFecha);
        lgcFecha.add(11, aiNum);

        return lgcFecha.getTime();
    }

    public static Date sumaHoraSinCambioHorario(Date adFecha, int aiNum) {
        GregorianCalendar lgcFecha = new GregorianCalendar();

        lgcFecha.setTime(adFecha);

        int liOffset1 = lgcFecha.get(16) / 0x36ee80;

        lgcFecha.add(11, aiNum);

        int liOffset2 = lgcFecha.get(16) / 0x36ee80;

        lgcFecha.add(11, liOffset1 - liOffset2);

        return lgcFecha.getTime();
    }

    public static Date sumaMinuto(Date adFecha, int aiNum) {
        GregorianCalendar lgcFecha = new GregorianCalendar();

        lgcFecha.setTime(adFecha);
        lgcFecha.add(12, aiNum);

        return lgcFecha.getTime();
    }

    public static Date sumaSegundo(Date adFecha, int aiNum) {
        GregorianCalendar lgcFecha = new GregorianCalendar();

        lgcFecha.setTime(adFecha);
        lgcFecha.add(13, aiNum);

        return lgcFecha.getTime();
    }

    public static long diferenciaSegundosSinFecha(Date adFecha1, Date adFecha2) {
        if ((adFecha1 == null) || (adFecha2 == null)) {
            return -1L;
        }

        GregorianCalendar ldFecha1 = new GregorianCalendar();
        GregorianCalendar ldFecha2 = new GregorianCalendar();

        ldFecha1.setTime(adFecha1);
        ldFecha2.setTime(adFecha2);
        ldFecha1.set(5, getDiaActual());
        ldFecha1.set(2, getMesActual());
        ldFecha1.set(1, getAnyoActual());
        ldFecha2.set(5, getDiaActual());
        ldFecha2.set(2, getMesActual());
        ldFecha2.set(1, getAnyoActual());

        long llMiliSegundos;

        if (compararHoraCompleta(adFecha1, adFecha2) < 0) {
            llMiliSegundos = ldFecha2.getTime().getTime() - ldFecha1.getTime().getTime();
        } else {
            llMiliSegundos = ldFecha1.getTime().getTime() - ldFecha2.getTime().getTime();
        }

        return llMiliSegundos / 1000L;
    }

    public static long diferenciaMinutosSinFecha(Date adFecha1, Date adFecha2) {
        if ((adFecha1 == null) || (adFecha2 == null)) {
            return -1L;
        } else {
            long llSegundos = diferenciaSegundosSinFecha(adFecha1, adFecha2);

            return llSegundos / 60L;
        }
    }

    public static long diferenciaHorasSinFecha(Date adFecha1, Date adFecha2) {
        if ((adFecha1 == null) || (adFecha2 == null)) {
            return -1L;
        } else {
            long llMinutos = diferenciaMinutosSinFecha(adFecha1, adFecha2);

            return llMinutos / 60L;
        }
    }

    public static long diferenciaSegundosConFecha(Date adFecha1, Date adFecha2) {
        if ((adFecha1 == null) || (adFecha2 == null)) {
            return -1L;
        }

        GregorianCalendar ldFecha1 = new GregorianCalendar();
        GregorianCalendar ldFecha2 = new GregorianCalendar();

        ldFecha1.setTime(adFecha1);
        ldFecha2.setTime(adFecha2);

        long llMiliSegundos;

        if (compararFechayHora(adFecha1, adFecha2) < 0) {
            llMiliSegundos = ldFecha2.getTime().getTime() - ldFecha1.getTime().getTime();
        } else {
            llMiliSegundos = ldFecha1.getTime().getTime() - ldFecha2.getTime().getTime();
        }

        return llMiliSegundos / 1000L;
    }

    public static long diferenciaMinutosConFecha(Date adFecha1, Date adFecha2) {
        if ((adFecha1 == null) || (adFecha2 == null)) {
            return -1L;
        } else {
            long llSegundos = diferenciaSegundosConFecha(adFecha1, adFecha2);

            return llSegundos / 60L;
        }
    }

    public static long diferenciaHorasConFecha(Date adFecha1, Date adFecha2) {
        if ((adFecha1 == null) || (adFecha2 == null)) {
            return -1L;
        } else {
            long llMinutos = diferenciaMinutosConFecha(adFecha1, adFecha2);

            return llMinutos / 60L;
        }
    }

    public static Date construirFecha(Date adFecha, Date adHora) {
        GregorianCalendar ldFecha         = new GregorianCalendar();
        Date              ldFechaDevolver = null;

        if (adFecha != null) {
            ldFecha.setTime(adFecha);

            if (adHora != null) {
                ldFecha.set(11, getHora(adHora));
                ldFecha.set(12, getMinuto(adHora));
                ldFecha.set(13, getSegundo(adHora));
            } else {
                ldFecha.set(11, 0);
                ldFecha.set(12, 0);
                ldFecha.set(13, 0);
            }

            ldFechaDevolver = ldFecha.getTime();
        }

        return ldFechaDevolver;
    }

    public static int diferenciaDia(Date adFecha1, Date adFecha2) {
        GregorianCalendar ldFecha1 = new GregorianCalendar();
        GregorianCalendar ldFecha2 = new GregorianCalendar();

        ldFecha1.setTime(adFecha1);
        ldFecha2.setTime(adFecha2);
        ldFecha1.set(10, 0);
        ldFecha1.set(12, 0);
        ldFecha1.set(13, 0);
        ldFecha2.set(10, 0);
        ldFecha2.set(12, 0);
        ldFecha2.set(13, 0);

        long llMiliSegundos;

        if (compararFecha(adFecha1, adFecha2) < 0) {
            llMiliSegundos = ldFecha2.getTime().getTime() - ldFecha1.getTime().getTime();
        } else {
            llMiliSegundos = ldFecha1.getTime().getTime() - ldFecha2.getTime().getTime();
        }

        int liValor = (int) ((llMiliSegundos + 0x36ee80L) / 0x5265c00L);

        return liValor;
    }

    public static int diferenciaMes(Date adFecha1, Date adFecha2) {
        int liDiferenciaMeses = 0;
        int liAnyos           = 0;

        if ((adFecha1 != null) && (adFecha2 != null)) {
            int  liValor = compararFecha(adFecha1, adFecha2);
            Date ldFechaMayor;
            Date ldFechaMenor;

            if (liValor > 0) {
                ldFechaMayor = adFecha1;
                ldFechaMenor = adFecha2;
            } else {
                ldFechaMayor = adFecha2;
                ldFechaMenor = adFecha1;
            }

            liAnyos = diferenciaAnyo(ldFechaMayor, ldFechaMenor);

            int liAnyoFechaMayor = getAnyo(ldFechaMayor);
            int liMesFechaMayor  = getMes(ldFechaMayor);
            int liDiaFechaMayor  = getDia(ldFechaMayor);
            int liAnyoFechaMenor = getAnyo(ldFechaMenor);
            int liMesFechaMenor  = getMes(ldFechaMenor);
            int liDiaFechaMenor  = getDia(ldFechaMenor);

            liDiferenciaMeses = liMesFechaMayor - liMesFechaMenor;

            int liDiferenciaAnyos = liAnyoFechaMayor - liAnyoFechaMenor;

            if ((liDiferenciaMeses < 0) || ((liDiferenciaMeses == 0) && (liDiferenciaAnyos > liAnyos))) {
                liDiferenciaMeses += 12;
            }

            if (liDiaFechaMayor < liDiaFechaMenor) {
                liDiferenciaMeses--;
            }

            liDiferenciaMeses = 12 * liAnyos + liDiferenciaMeses;
        }

        return liDiferenciaMeses;
    }

    public static int diferenciaAnyo(Date adFecha1, Date adFecha2) {
        Date ldFechaMayor = null;
        Date ldFechaMenor = null;
        int  liAnyos      = 0;

        if ((adFecha1 != null) && (adFecha2 != null)) {
            if (compararFecha(adFecha1, adFecha2) > 0) {
                ldFechaMayor = adFecha1;
                ldFechaMenor = adFecha2;
            } else {
                ldFechaMayor = adFecha2;
                ldFechaMenor = adFecha1;
            }

            int liAnyoMayor     = getAnyo(ldFechaMayor);
            int liMesFechaMayor = getMes(ldFechaMayor);
            int liDiaFechaMayor = getDia(ldFechaMayor);
            int liAnyoMenor     = getAnyo(ldFechaMenor);
            int liMesFechaMenor = getMes(ldFechaMenor);
            int liDiaFechaMenor = getDia(ldFechaMenor);

            liAnyos = liAnyoMayor - liAnyoMenor;

            if ((liMesFechaMayor < liMesFechaMenor)
                    || ((liMesFechaMayor == liMesFechaMenor) && (liDiaFechaMayor < liDiaFechaMenor))) {
                liAnyos--;
            }
        }

        return liAnyos;
    }

    public static boolean estaFechaEnRango(Date adFecha, Date adFechaDesde, Date adFechaHasta, boolean abIguales) {
        if (abIguales) {
            return mayorIgual(adFecha, adFechaDesde) && menorIgual(adFecha, adFechaHasta);
        } else {
            return mayor(adFecha, adFechaDesde) && menor(adFecha, adFechaHasta);
        }
    }

    public static boolean solapamientoHoras(Date adHoraIni1, Date adHoraFin1, Date adHoraIni2, Date adHoraFin2) {
        boolean lbSolapado = false;

        if ((horaMayorIgual(adHoraFin1, adHoraIni2) && horaMenorIgual(adHoraIni1, adHoraIni2))
                || (horaMayorIgual(adHoraFin1, adHoraFin2) && horaMenorIgual(adHoraIni1, adHoraFin2))
                || (horaMayorIgual(adHoraIni1, adHoraIni2) && horaMenorIgual(adHoraFin1, adHoraFin2))) {
            lbSolapado = true;
        }

        return lbSolapado;
    }

    public static boolean existeFechaEnLista(Date adFecha, Date aadFechas[]) {
        boolean lbExiste = false;

        if (aadFechas != null) {
            int li = 0;

            do {
                if (li >= aadFechas.length) {
                    break;
                }

                if (igual(adFecha, aadFechas[li])) {
                    lbExiste = true;

                    break;
                }

                li++;
            } while (true);
        }

        return lbExiste;
    }

    //~--- get methods --------------------------------------------------------

    public static int getDiaJuliano(Date adFecha) {
        Calendar lcCalendario = Calendar.getInstance();

        lcCalendario.clear();
        lcCalendario.setTime(adFecha);

        return lcCalendario.get(6);
    }

    //~--- methods ------------------------------------------------------------

    public static boolean cumpleFechaDiaSemana(Date adFecha, boolean abL, boolean abM, boolean abX, boolean abJ,
            boolean abV, boolean abS, boolean abD) {
        Calendar lcCalendario = Calendar.getInstance();

        lcCalendario.setTime(adFecha);

        int liNumeroDia = lcCalendario.get(7);

        switch (liNumeroDia) {
        case 1 :    // '\001'
            if (abD) {
                return true;
            }

            break;

        case 2 :    // '\002'
            if (abL) {
                return true;
            }

            break;

        case 3 :    // '\003'
            if (abM) {
                return true;
            }

            break;

        case 4 :    // '\004'
            if (abX) {
                return true;
            }

            break;

        case 5 :    // '\005'
            if (abJ) {
                return true;
            }

            break;

        case 6 :    // '\006'
            if (abV) {
                return true;
            }

            break;

        case 7 :    // '\007'
            if (abS) {
                return true;
            }

            break;

        default :
            return false;
        }

        return false;
    }

    public static int[] diferenciaAnioMes(Date adFecha1, Date adFecha2) {
        int    liMesesTotales = diferenciaMes(adFecha1, adFecha2);
        String lsCadena       = "";
        int    liAnios        = liMesesTotales / 12;
        int    liMeses        = liMesesTotales % 12;

        return (new int[] { liMeses, liAnios });
    }

    public static Date primerDiaMes(Date adFecha) {
        Date ldFechaDevolver = null;

        if (adFecha != null) {
            int liDia = getDia(adFecha) - 1;

            ldFechaDevolver = sumaDia(adFecha, -liDia);
        }

        return ldFechaDevolver;
    }

    public static Date ultimoDiaMes(Date adFecha) {
        Date   ldFechaDevolver = null;
        String lsFecha         = null;

        if (adFecha != null) {
            int liMes  = getMes(adFecha);
            int liAnyo = getAnyo(adFecha);
            int liDia  = getDiasDelMes(liMes, liAnyo);

            lsFecha = liDia + "/" + liMes + "/" + liAnyo;

            try {
                ldFechaDevolver = stringToDate(lsFecha);
            } catch (Exception e) {
                slogLogger.error("Error formateando la fecha: " + lsFecha, e);
            }
        }

        return ldFechaDevolver;
    }

    public static Date primerDiaSemana(Date adFecha) {
        Calendar lcalTmpCal = Calendar.getInstance();

        lcalTmpCal.setTime(adFecha);

        int liResta0    = 0;
        int liResta1    = 1;
        int liResta2    = 2;
        int liResta3    = 3;
        int liResta4    = 4;
        int liResta5    = 5;
        int liResta6    = 6;
        int liDiaSemana = lcalTmpCal.get(7);
        int liResta     = 0;

        switch (liDiaSemana) {
        case 2 :    // '\002'
            liResta = 0;

            break;

        case 3 :    // '\003'
            liResta = 1;

            break;

        case 4 :    // '\004'
            liResta = 2;

            break;

        case 5 :    // '\005'
            liResta = 3;

            break;

        case 6 :    // '\006'
            liResta = 4;

            break;

        case 7 :    // '\007'
            liResta = 5;

            break;

        case 1 :    // '\001'
            liResta = 6;

            break;

        default :
            liResta = 0;

            break;
        }

        lcalTmpCal.add(5, -liResta);

        return lcalTmpCal.getTime();
    }

    public static Date ultimoDiaSemana(Date adFecha) {
        Calendar lcalTmpCal = Calendar.getInstance();

        lcalTmpCal.setTime(adFecha);

        int liDiaSemana = lcalTmpCal.get(7);
        int liSuma0     = 0;
        int liSuma1     = 1;
        int liSuma2     = 2;
        int liSuma3     = 3;
        int liSuma4     = 4;
        int liSuma5     = 5;
        int liSuma6     = 6;
        int liSuma      = 0;

        switch (liDiaSemana) {
        case 2 :    // '\002'
            liSuma = 6;

            break;

        case 3 :    // '\003'
            liSuma = 5;

            break;

        case 4 :    // '\004'
            liSuma = 4;

            break;

        case 5 :    // '\005'
            liSuma = 3;

            break;

        case 6 :    // '\006'
            liSuma = 2;

            break;

        case 7 :    // '\007'
            liSuma = 1;

            break;

        case 1 :    // '\001'
            liSuma = 0;

            break;

        default :
            liSuma = 0;

            break;
        }

        lcalTmpCal.add(5, liSuma);

        return lcalTmpCal.getTime();
    }

    //~--- set methods --------------------------------------------------------

    public static Date setHora(Date adFecha, int aiHora) {
        Calendar lcCalendario = Calendar.getInstance();

        lcCalendario.clear();
        lcCalendario.setTime(adFecha);
        lcCalendario.set(11, aiHora);

        return lcCalendario.getTime();
    }

    //~--- get methods --------------------------------------------------------

    public static Date getFechaMayor(Date adFecha1, Date adFecha2) {
        if (mayorIgual(adFecha1, adFecha2)) {
            return adFecha1;
        } else {
            return adFecha2;
        }
    }

    public static Date getFechaMenor(Date adFecha1, Date adFecha2) {
        if (menorIgual(adFecha1, adFecha2)) {
            return adFecha1;
        } else {
            return adFecha2;
        }
    }

    //~--- methods ------------------------------------------------------------

    public static void main(String args[]) {
        Date ldHoy = hoy();
    }
}
