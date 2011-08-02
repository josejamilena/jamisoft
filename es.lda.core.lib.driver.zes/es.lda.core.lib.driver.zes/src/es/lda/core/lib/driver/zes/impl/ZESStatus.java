package es.lda.core.lib.driver.zes.impl;

import es.lda.core.network.CommunicationStatus;

/**
 *
 * @author Jose Antonio
 */
public class ZESStatus implements CommunicationStatus {

    /**
     *  finalante que muestra el estado de las comunicaciones.
     *  
     *  La comunicacion es correctas, esta OK. */
    public static final int OK = 1;
    /**
     *  finalante que muestra el estado de las comunicaciones. 
     *  
     *  La comunicacion es incorrecta, el equipo conectado no es el correcto. */
    public static final int ER_EQUIPO = 2;
    /**
     *  finalante que muestra el estado de las comunicaciones.
     *  
     *  La comunicacion es incorrecta,se ha producido un error en la comunicacion con el equipo. */
    public static final int ER_CONEXION = 3;
    /**
     *  finalante que muestra el estado de las comunicaciones.
     *  
     *  La comunicacion se ha perdido, es decir, se ha producido una desconexion con el equipo. */
    public static final int ER_PERDIDA_CONEXION = 4;
    /**
     *  finalante que muestra el estado de las comunicaciones. 
     *  
     *  La hay comunicacion con el equipo. */
    public static final int ER_SIN_CONEXION = 5;
    /**
     *  finalante que muestra el estado de las comunicaciones.
     *  
     *  El protocolo de comunicaciones se esta conectando al equipo */
    public static final int CONECTANDO = 6;
    /**
     *  finalant que muestra el estado de las comunicicaciones.
     *  
     *  El protocolo de comunicaciones no esta activo. */
    public static final int SIN_CONEXION = 7;
    /**
     *  finalante que nos dice que los parametros son incorrectos
     */
    public static final int PARAMETROS_INCORRECTOS = 8;

    /**
     * Obtain a message string from a status number.
     * @param i status.
     * @return msg.
     */
    public static String status2String(int i) {
        String res = null;
        switch (i) {
            case OK:
                res = "OK";
                break;
            case ER_EQUIPO:
                res = "DEVICE ERROR";
                break;
            case ER_CONEXION:
                res = "CONNECTION ERROR";
                break;
            case ER_PERDIDA_CONEXION:
                res = "LOST CONNECTION ERROR";
                break;
            case ER_SIN_CONEXION:
                res = "NOT CONNECTION ERROR";
                break;
            case CONECTANDO:
                res = "CONNECTING";
                break;
            case SIN_CONEXION:
                res = "WITHOUT CONNECTION";
                break;
            case PARAMETROS_INCORRECTOS:
                res = "WRONG PARAMETERS";
                break;
            default:
                res = "";
                break;
        }
        return res;
    }

    /**
     * Obtain a message string from a status number.
     * @param i status.
     * @return msg.
     */
    public static String return2String(int i) {
//    '''  1 OK.
//    '''  2 ERROR EN LOS PARAMETROS.
//    '''  3 ERROR EQUIPO DESCONECTADO.
//    '''  4 EL EQUIPO SE ESTA SINCRONIZANDO CON LA DLL.
        String res = null;
        switch (i) {
            case 1:
                res = "OK";
                break;
            case 2:
                res = "ERROR EN LOS PARAMETROS";
                break;
            case 3:
                res = "ERROR EQUIPO DESCONECTADO";
                break;
            case 4:
                res = "EL EQUIPO SE ESTA SINCRONIZANDO CON EL DRIVER";
                break;
            default:
                res = "";
                break;
        }
        return res;
    }
}
