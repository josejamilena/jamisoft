package es.lda.core.lib.driver.zes.impl;

import es.lda.core.event.interfaces.DataEvent;
import es.lda.core.event.interfaces.GUIEvent;
import es.lda.core.exception.DriverException;
import es.lda.core.exception.UnsupportedDriverOperation;
import es.lda.core.exception.ZESException;
import es.lda.core.lib.util.LdaUtils;
import es.lda.core.lib.driver.zes.ZES;
import es.lda.core.network.IUdp;
import es.lda.core.network.UdpException;
import es.lda.core.network.UdpFactory;
import es.lda.core.network.UdpType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javax.swing.Timer;
import org.apache.log4j.Logger;

/**
 *
 * @author Jose Antonio
 */
public class ZESImpl implements ZES {

    private static final ResourceBundle config = ResourceBundle.getBundle("es/lda/core/lib/driver/zes/config/config");

    /**
     * Return Device Name.
     * @return Device Name.
     */
    public String getDevice() {
        return config.getString("DEVICE");
    }

    /**
     * Return Device Id.
     * @return Device Id.
     */
    public String getDeviceId() {
        return config.getString("DEVICE_ID");
    }

    /**
     * Return Device Version.
     * @return Device Version.
     */
    public String getVersion() {
        if (zes != null) {
            return zes.getVersionEquipo();
        } else {
            return config.getString("ERROR_UNINITIALIZED_DEVICE");
        }
    }

    /** 
     * Execute command:<code>cmd</code> with arguments<code>args</code> and return the result. 
     *  </p>
     * Available Commands: </p> </p>
     * <code>
     *    void Close();
     *    void Dispose();
     *    boolean FbDSPActivo(int Estado);
     *    void PFinish();
     *    int PGetAmplificador(boolean Estado);
     *    int PGetAtenuador24V(boolean Estado);
     *    int PGetBundleEntrada(int Bundle, int Dato);
     *    int PGetBundleSalida(int Bundle, int Dato);
     *    int PGetCierre(int Cierre, boolean Act);
     *    int PGetCompresorAttack(int Entrada, int Valor);
     *    int PGetCompresorBypass(int Entrada, int Valor);
     *    int PGetCompresorRatio(int Entrada, int Valor);
     *    int PGetCompresorRelease(int Entrada, int Valor);
     *    int PGetCompresorSoftknee(int Entrada, int Valor);
     *    int PGetCompresorThreshold(int Entrada, int Valor);
     *    int PGetComunicaciones485(boolean Act);
     *    int PGetConfigAtenuadores(boolean Act);
     *    int PGetConfigCierres(int Indice, boolean Sal, boolean Alt);
     *    int PGetConfigGestionAutomaticaMicrofonos(boolean Act);
     *    int PGetDatoDSP(String AddressHMI, int Dato);
     *    int PGetGananciaCFE(int Entrada, int Ganancia);
     *    int PGetGananciaCFS(int Salida, int Ganancia);
     *    int PGetLimitadorAttack(int Salida, int Valor);
     *    int PGetLimitadorBypass(int Salida, int Valor);
     *    int PGetLimitadorRatio(int Salida, int Valor);
     *    int PGetLimitadorRelease(int Salida, int Valor);
     *    int PGetLimitadorSoftknee(int Salida, int Valor);
     *    int PGetLimitadorThreshold(int Salida, int Valor);
     *    int PGetMP3(boolean Reproduciendo, int Pista, int NumPistas);
     *    int PGetMP3In(boolean Existe);
     *    int PGetModExpansionIn(boolean Existe);
     *    int PGetRxSubMap(int Bundle, int Canal, int Dato);
     *    int PGetSDIn(boolean Existe);
     *    int PGetSDProtect(boolean Protegida);
     *    void PGetSalida(int Salida, int Ok, int Entrada);
     *    int PGetTemperatura(int Temp1, boolean Vent1, int Temp2, boolean Vent2);
     *    int PGetTono(int Salida, int Valor);
     *    int PGetTonoFrec(int Valor);
     *    int PGetTonoMaster(int Valor);
     *    int PGetTxSubMap(int Bundle, int Canal, int Dato);
     *    int PGetVumetroCE(int Entrada, int Valor);
     *    int PGetVumetroCS(int Salida, int Valor);
     *    int PSetAmplificador(boolean Estado);
     *    int PSetAtenuador24V(boolean Estado);
     *    int PSetBundleEntrada(int BundleEntrada, int vBundle);
     *    int PSetBundleSalida(int BundleSalida, int vBundle);
     *    int PSetCierre(int Indice, boolean Activar);
     *    int PSetComunicaciones485(boolean Act);
     *    int PSetConfigAtenuadores(boolean Act);
     *    int PSetConfigCierres(int Indice, boolean Salida, boolean Alto);
     *    int PSetConfigGestionAutomaticaMicrofonos(boolean Act);
     *    int PSetDatoDSP(String AddressHMI, int Dato);
     *    int PSetGananciaCFE(int Entrada, int Ganancia);
     *    int PSetGananciaCFS(int Salida, int Ganancia);
     *    int PSetMP3(boolean Play, int Pista, boolean Looping);
     *    int PSetPreset(boolean Accion);
     *    int PSetReset();
     *    int PSetRxSubMap(int Bundle, int Canal, int Vcanal);
     *    int PSetSalida(int Salida, int Entrada);
     *    int PSetTono(int Salida, int Valor);
     *    int PSetTonoFrec(int Valor);
     *    int PSetTonoMaster(int Valor);
     *    int PSetTxSubMap(int Bundle, int Canal, int Vcanal);
     *    void PStart(String dir_ip, String puerto);
     * </code>
     * 
     * @param cmd
     * @param args
     * @param argsBytes
     * @return
     * @throws DriverException
     * @throws UnsupportedDriverOperation 
     */
    public Object[] exec(String cmd, String[] args, byte[] argsBytes) throws DriverException, UnsupportedDriverOperation {
        List<Object> res = new LinkedList<Object>();

        logger.info("EXEC");
        logger.info("\tcmd:  " + cmd);
        logger.info("\targs: " + args);
        logger.info("\targsBytes: " + argsBytes);

        if (cmd.equalsIgnoreCase("Close")) {
            Close();
        } else if (cmd.equalsIgnoreCase("Dispose")) {
            Dispose();
        } else if (cmd.equalsIgnoreCase("FbDSPActivo")) {
            res.add(FbDSPActivo()); // TODO
        } else if (cmd.equalsIgnoreCase("PFinish")) {
            PFinish();
        } else if (cmd.equalsIgnoreCase("PGetAmplificador")) {
            res.add(PGetAmplificador(Boolean.parseBoolean(args[0])));
        } else if (cmd.equalsIgnoreCase("PGetAtenuador24V")) {
            res.add(PGetAtenuador24V(Boolean.parseBoolean(args[0])));
        } else if (cmd.equalsIgnoreCase("PGetBundleEntrada")) {
            res.add(PGetBundleEntrada(Integer.parseInt(args[0])));
        } else if (cmd.equalsIgnoreCase("PGetBundleSalida")) {
            res.add(PGetBundleSalida(Integer.parseInt(args[0])));
        } else if (cmd.equalsIgnoreCase("PGetCierre")) {
            res.add(PGetCierre(Integer.parseInt(args[0])));
        } else if (cmd.equalsIgnoreCase("PGetCompresorAttack")) {
            res.add(PGetCompresorAttack(Integer.parseInt(args[0])));
        } else if (cmd.equalsIgnoreCase("PGetCompresorBypass")) {
            res.add(PGetCompresorBypass(Integer.parseInt(args[0])));
        } else if (cmd.equalsIgnoreCase("PGetCompresorRatio")) {
            res.add(PGetCompresorRatio(Integer.parseInt(args[0])));
        } else if (cmd.equalsIgnoreCase("PGetCompresorRelease")) {
            res.add(PGetCompresorRelease(Integer.parseInt(args[0])));
        } else if (cmd.equalsIgnoreCase("PGetCompresorSoftknee")) {
            res.add(PGetCompresorSoftknee(Integer.parseInt(args[0])));
        } else if (cmd.equalsIgnoreCase("PGetCompresorThreshold")) {
            res.add(PGetCompresorThreshold(Integer.parseInt(args[0])));
        } else if (cmd.equalsIgnoreCase("PGetComunicaciones485")) {
            res.add(PGetComunicaciones485());
        } else if (cmd.equalsIgnoreCase("PGetConfigAtenuadores")) {
            res.add(PGetConfigAtenuadores());
        } else if (cmd.equalsIgnoreCase("PGetConfigCierres")) {
            res.add(PGetConfigCierres(Integer.parseInt(args[0])));
        } else if (cmd.equalsIgnoreCase("PGetConfigGestionAutomaticaMicrofonos")) {
            res.add(PGetConfigGestionAutomaticaMicrofonos());
        } else if (cmd.equalsIgnoreCase("PGetDatoDSP")) {
            res.add(PGetDatoDSP(args[0]));
        } else if (cmd.equalsIgnoreCase("PGetGananciaCFE")) {
            res.add(PGetGananciaCFE(Integer.parseInt(args[0])));
        } else if (cmd.equalsIgnoreCase("PGetGananciaCFS")) {
            res.add(PGetGananciaCFS(Integer.parseInt(args[0])));
        } else if (cmd.equalsIgnoreCase("PGetLimitadorAttack")) {
            res.add(PGetLimitadorAttack(Integer.parseInt(args[0])));
        } else if (cmd.equalsIgnoreCase("PGetLimitadorBypass")) {
            res.add(PGetLimitadorBypass(Integer.parseInt(args[0])));
        } else if (cmd.equalsIgnoreCase("PGetLimitadorRatio")) {
            res.add(PGetLimitadorRatio(Integer.parseInt(args[0])));
        } else if (cmd.equalsIgnoreCase("PGetLimitadorRelease")) {
            res.add(PGetLimitadorRelease(Integer.parseInt(args[0])));
        } else if (cmd.equalsIgnoreCase("PGetLimitadorSoftknee")) {
            res.add(PGetLimitadorSoftknee(Integer.parseInt(args[0])));
        } else if (cmd.equalsIgnoreCase("PGetLimitadorThreshold")) {
            res.add(PGetLimitadorThreshold(Integer.parseInt(args[0])));
        } else if (cmd.equalsIgnoreCase("PGetMP3")) {
            res.add(PGetMP3(Boolean.parseBoolean(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])));
        } else if (cmd.equalsIgnoreCase("PGetMP3In")) {
            res.add(PGetMP3In(Boolean.parseBoolean(args[0])));
        } else if (cmd.equalsIgnoreCase("PGetModExpansionIn")) {
            res.add(PGetModExpansionIn());
        } else if (cmd.equalsIgnoreCase("PGetRxSubMap")) {
            res.add(PGetRxSubMap(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
        } else if (cmd.equalsIgnoreCase("PGetSDIn")) {
            res.add(PGetSDIn());
        } else if (cmd.equalsIgnoreCase("PGetSDProtect")) {
            res.add(PGetSDProtect());
        } else if (cmd.equalsIgnoreCase("PGetSalida")) {
            res.add(PGetSalida(Integer.parseInt(args[0])));
        } else if (cmd.equalsIgnoreCase("PGetTemperatura")) {
            res.add(PGetTemperatura());
        } else if (cmd.equalsIgnoreCase("PGetTono")) {
            res.add(PGetTono(Integer.parseInt(args[0])));
        } else if (cmd.equalsIgnoreCase("PGetTonoFrec")) {
            res.add(PGetTonoFrec());
        } else if (cmd.equalsIgnoreCase("PGetTonoMaster")) {
            res.add(PGetTonoMaster());
        } else if (cmd.equalsIgnoreCase("PGetTxSubMap")) {
            res.add(PGetTxSubMap(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
        } else if (cmd.equalsIgnoreCase("PGetVumetroCE")) {
            res.add(PGetVumetroCE(Integer.parseInt(args[0])));
        } else if (cmd.equalsIgnoreCase("PGetVumetroCS")) {
            res.add(PGetVumetroCS(Integer.parseInt(args[0])));
        } else if (cmd.equalsIgnoreCase("PSetAmplificador")) {
            res.add(PSetAmplificador(Boolean.parseBoolean(args[0])));
        } else if (cmd.equalsIgnoreCase("PSetAtenuador24V")) {
            res.add(PSetAtenuador24V(Boolean.parseBoolean(args[0])));
        } else if (cmd.equalsIgnoreCase("PSetBundleEntrada")) {
            res.add(PSetBundleEntrada(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
        } else if (cmd.equalsIgnoreCase("PSetBundleSalida")) {
            res.add(PSetBundleSalida(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
        } else if (cmd.equalsIgnoreCase("PSetCierre")) {
            res.add(PSetCierre(Integer.parseInt(args[0]), Boolean.parseBoolean(args[1])));
        } else if (cmd.equalsIgnoreCase("PSetComunicaciones485")) {
            res.add(PSetComunicaciones485(Boolean.parseBoolean(args[0])));
        } else if (cmd.equalsIgnoreCase("PSetConfigAtenuadores")) {
            res.add(PSetConfigAtenuadores(Boolean.parseBoolean(args[0])));
        } else if (cmd.equalsIgnoreCase("PSetConfigCierres")) {
            res.add(PSetConfigCierres(Integer.parseInt(args[0]), Boolean.parseBoolean(args[1]), Boolean.parseBoolean(args[2])));
        } else if (cmd.equalsIgnoreCase("PSetConfigGestionAutomaticaMicrofonos")) {
            res.add(PSetConfigGestionAutomaticaMicrofonos(Boolean.parseBoolean(args[0])));
        } else if (cmd.equalsIgnoreCase("PSetDatoDSP")) {
            res.add(PSetDatoDSP(args[0], Integer.parseInt(args[1])));
        } else if (cmd.equalsIgnoreCase("PSetGananciaCFE")) {
            res.add(PSetGananciaCFE(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
        } else if (cmd.equalsIgnoreCase("PSetGananciaCFS")) {
            res.add(PSetGananciaCFS(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
        } else if (cmd.equalsIgnoreCase("PSetMP3")) {
            res.add(PSetMP3(Boolean.parseBoolean(args[0]), Integer.parseInt(args[1]), Boolean.parseBoolean(args[2])));
        } else if (cmd.equalsIgnoreCase("PSetPreset")) {
            res.add(PSetPreset(Boolean.parseBoolean(args[0])));
        } else if (cmd.equalsIgnoreCase("PSetReset")) {
            PSetReset();
        } else if (cmd.equalsIgnoreCase("PSetRxSubMap")) {
            res.add(PSetRxSubMap(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])));
        } else if (cmd.equalsIgnoreCase("PSetSalida")) {
            res.add(PSetSalida(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
        } else if (cmd.equalsIgnoreCase("PSetTono")) {
            res.add(PSetTono(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
        } else if (cmd.equalsIgnoreCase("PSetTonoFrec")) {
            res.add(PSetTonoFrec(Integer.parseInt(args[0])));
        } else if (cmd.equalsIgnoreCase("PSetTonoMaster")) {
            res.add(PSetTonoMaster(Integer.parseInt(args[0])));
        } else if (cmd.equalsIgnoreCase("PSetTxSubMap")) {
            res.add(PSetTxSubMap(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])));
        } else if (cmd.equalsIgnoreCase("PStart")) {
            try {
                PStart(args[0], args[1]);
            } catch (UdpException ex) {
                throw new DriverException(ex.getMessage());
            }
        } else if (cmd.equalsIgnoreCase("EstadoConexionEquipo")) {
            res.add(zes.EstadoConexionEquipo());
        } else {
            throw new UnsupportedDriverOperation(cmd, Arrays.asList(args));
        }

        logger.info("\tres: " + res);
        logger.info("EXEC_END");

        return res.toArray();
    }
    /** Logger. */
    private static Logger logger = Logger.getLogger(ZESImpl.class);
    //  "Variables de la clase"
    private boolean bDispose = false;
    /**
     *  Es la variable que controla la conexion del equipo y sus funciones
     */
    private ProtocoloComunicacion zes = null; //new ProtocoloComunicacion();
    /**
     *  Flag de estado del equipo.
     *  
     *  Si el equipo esta conectado correctamente el flag esta TRUE, en caso contrario esta el flag a FALSE */
    private boolean EstadoEquipo;
    /**
     *  Flag que controla la sincronización de las variables Read-Only
     *  
     *   */
    private boolean SncRo;
    /**
     *  Flag que controla la sincronización de las variables Read-Write 
     *  
     *   */
    private boolean SncRw;
    /**
     *  Flag que nos dice el estado del Amplificador-Monitor del equipo
     *  
     *  True equivale a 1 y que esta activo, False equivale a 0 y que esta desactivo. */
    private boolean StateAmpl;
    /**
     *  Es la temperatura 1 del equipo.
     *  
     *   */
    private int Temperatura1;
    /**
     *  Es el flag de ventilacion del ventilador 1
     *  
     *   */
    private boolean Ventilacion1;
    /**
     *  Es la temperatura 1 del equipo.
     *  
     *   */
    private int Temperatura2;
    /**
     *  Es el flag de ventilacion del ventilador 2
     *  
     *   */
    private boolean Ventilacion2;
    /**
     *  Es el flag de existencia del Modulo de expansion
     *  
     *   */
    private boolean ModExpansion;
    /**
     *  Es el flag de existencia del MP3
     *  
     *   */
    private boolean MP3;
    /**
     *  Es el flag de configuración del cierre (~Entrada/Salida)
     *  
     *   */
    private boolean[] Salida = new boolean[CobraNetUtil.NUMERO_CIERRES + 1];
    /**
     *  Es el flag de configuración del cierre (Alto/~Bajo)
     *  
     *   */
    private boolean[] Alto = new boolean[CobraNetUtil.NUMERO_CIERRES + 1];
    /**
     *  Es el flag de Estado del cierre (Alto/~Bajo)
     *  
     *   */
    private boolean[] Estado = new boolean[CobraNetUtil.NUMERO_CIERRES + 1];
    /**
     *  Es el flag de Estado del cierre (Activo/~Desactivo)
     *  
     *   */
    private boolean[] Activo = new boolean[CobraNetUtil.NUMERO_CIERRES + 1];
    /**
     *  Es el flag de Estado del amplificador
     *  
     *   */
    private boolean stateAmp;
    /**
     *  Es el flag de Estado de reproducción del mp3
     *  
     *   */
    private boolean stateMP3;
    /**
     *  Es el numero de pista que actualmente se está reproduciendo
     *  
     *   */
    private int MP3Song;
    /**
     *  Es el numero de pistas que hay actualmente en la SD
     *  
     *   */
    private int MP3NFiles;
    /**
     *  Flag que indica si la SD está insertada
     *  
     *   */
    private boolean SDIN;
    /**
     *  Flag que indica si la SD está protegida
     *  
     *   */
    private boolean SDPROTECT;
    /**
     *  Es el flag de estado del atenuador de 24v
     *  
     *   */
    private boolean stateATT;
    /**
     *  Flag que controla si esta activo o no las comunicaciones 485
     *  
     *  Si es TRUE el Rs485 esta activado y si es FALSE lo que esta activo es el RS-232 */
    private boolean Rs485;
    /**
     *  Flag que controla si esta activo o no la gestion automatica de microfonos.
     *  
     *   */
    private boolean AutoMic;
    /**
     *  Flag que controla si esta activo o no los atenuadores para la gestión automática de micrófonos.
     *  
     *   */
    //  "Variables donde se guardan los datos del HMI"
    private boolean cnfAtenuadores;
    /**
     *  Variable donde se guardan todas los Valores de la variables Read-Only de las Direcciones HMI
     */
    private double[] varRo = new double[CobraNetUtil.TAM_RO + 1];
    /**
     *  Variable donde se guardan todas los valores de las variables Read-Write de las direccines HMI
     */
    private double[] varRw = new double[CobraNetUtil.TAM_RW + 1];
    /**
     *  Variable donde se guardan todos los valores de las variables de los Rx Bundles
     *  
     *   */
    private double[] varBundleRx = new double[CobraNetUtil.TMN_BUNDLE + 1];
    /**
     *  Variable donde se guardan todos los valores de las variables de los Tx Bundles
     *  
     *   */
    private double[] varBundleTx = new double[CobraNetUtil.TMN_BUNDLE + 1];
    /**
     *  Variable donde se guardan todos los valores de las variables de los Canales del Bundle 1 de Rx
     *  
     *   */
    private double[] varRxSubMapB1 = new double[CobraNetUtil.TMN_CANALES_BUNDLE + 1];
    /**
     *  Variable donde se guardan todos los valores de las variables de los Canales del Bundle 2 de Rx
     *  
     *   */
    private double[] varRxSubMapB2 = new double[CobraNetUtil.TMN_CANALES_BUNDLE + 1];
    /**
     *  Variable donde se guardan todos los valores de las variables de los Canales del Bundle 3 de Rx
     *  
     *   */
    private double[] varRxSubMapB3 = new double[CobraNetUtil.TMN_CANALES_BUNDLE + 1];
    /**
     *  Variable donde se guardan todos los valores de las variables de los Canales del Bundle 4 de Rx
     *  
     *   */
    private double[] varRxSubMapB4 = new double[CobraNetUtil.TMN_CANALES_BUNDLE + 1];
    /**
     *  Variable donde se guardan todos los valores de las varialbe de los Canalaes del Bundle 5  de Rx
     *  
     *   */
    private double[] varRxSubMapB5 = new double[CobraNetUtil.TMN_CANALES_BUNDLE + 1];
    /**
     *  Variable donde se guardan todos los valores de las varialbe de los Canalaes del Bundle 6  de Rx
     *  
     *   */
    private double[] varRxSubMapB6 = new double[CobraNetUtil.TMN_CANALES_BUNDLE + 1];
    /**
     *  Variable donde se guardan todos los valores de las varialbe de los Canalaes del Bundle 7  de Rx
     *  
     *   */
    private double[] varRxSubMapB7 = new double[CobraNetUtil.TMN_CANALES_BUNDLE + 1];
    /**
     *  Variable donde se guardan todos los valores de las varialbe de los Canalaes del Bundle 8  de Rx
     *  
     *   */
    private double[] varRxSubMapB8 = new double[CobraNetUtil.TMN_CANALES_BUNDLE + 1];
    /**
     *  Variable donde se guardan todos los valores de las variables de los Canales del Bundle 1 de Tx
     *  
     *   */
    private double[] varTxSubMapB1 = new double[CobraNetUtil.TMN_CANALES_BUNDLE + 1];
    /**
     *  Variable donde se guardan todos los valores de las variables de los Canales del Bundle 2 de Tx
     *  
     *   */
    private double[] varTxSubMapB2 = new double[CobraNetUtil.TMN_CANALES_BUNDLE + 1];
    /**
     *  Variable donde se guardan todos los valores de las variables de los Canales del Bundle 3 de Tx
     *  
     *   */
    private double[] varTxSubMapB3 = new double[CobraNetUtil.TMN_CANALES_BUNDLE + 1];
    /**
     *  Variable donde se guardan todos los valores de las variables de los Canales del Bundle 4 de TX
     *  
     *   */
    private double[] varTxSubMapB4 = new double[CobraNetUtil.TMN_CANALES_BUNDLE + 1];

    //  "Eventos_Clase"
    /**
     *  Evento que se produce cuando hay un cierre de entrada activo
     *  
     *  @param Cierre Es el cierre que se ha activado. 
     *   */
//    public event CierreEntradaActivoEventHandler CierreEntradaActivo ;
//    public delegate void CierreEntradaActivoEventHandler(int Cierre, boolean Activo);
    //  "Constructor, Destructor y sus sobrecargas"
    /**
     *  Constructor de la clase 
     */
    public ZESImpl() {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        //zes.refresh();
        zes = new ProtocoloComunicacion();
        //Iniciazliazamos las variables, flag y demas cosas necesarias para arrancar el protocolo         
        InicializaVariables();
    }

    /**
     *  Destructor de la clase
     *  
     *   */
    public void Dispose() throws ZESException {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        //LLamamos al destructor para liberar la memoria del protocolo de comunicaciones con el equipo 
        zes.dispose();
        //Limpiamos los demas flags
        EstadoEquipo = false;
        bDispose = true;
    }

    //  "Propiedades publicas de la clase"
    /**
     *  Propiedad que asigna la direccion ip que tiene el equipo.
     *  
     *  
     *  @return
     *   */
//    public String DireccionIpEquipo
//
//    {
//        get {
//            return zes.DireccionIP;
//        }
//        set {
//            zes.DireccionIP = value;
//        }
//    }
    public String getDireccionIpEquipo() {
        return zes.DireccionIP;
    }

    public void setDireccionIpEquipo(String value) {
        zes.DireccionIP = value;
    }

    /**
     *  Propiedad que asigna el puerto que tiene el equipo
     *  
     *  
     *  @return
     *   */
//    public String Puerto
//
//    {
//        get {
//            return zes.Puerto;
//        }
//        set {
//            zes.Puerto = value;
//        }
//    }
    public int getPuerto() {
        return zes.Puerto;
    }

    public void setPuerto(int value) {
        zes.Puerto = value;
    }

    /**
     *  Propiedad que asigna el tiempo que tarda la libraria en notificar la desconexion del equipo.
     *  
     *  
     *  @return
     *  Por defecto esta a 30 segundos aproximadamente. */
//    public int TiempoDesconexionDelEquipo
//
//    {
//        get {
//            return zes.TiempoDesconexionEquipo;
//        }
//        set {
//            zes.TiempoDesconexionEquipo = value;
//        }
//    }
    public int getTiempoDesconexionEquipo() {
        return zes.TiempoDesconexionEquipo;
    }

    public void setTiempoDesconexionEquipo(int value) {
        zes.TiempoDesconexionEquipo = value;
    }

    //  "Procedimientos y funciones Publicas"
    /**
     *  Procedimiento que activa las comunicaciones con el equipo.
     *  
     *  @param dir_ip Es la direccion ip del equipo. 
     *  @param puerto Es el puerto del equipo. 
     *   */
    public void PStart(String dir_ip, String puerto) throws UdpException {

        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        ValidezEquipo eq = new ValidezEquipo();
        //Comprobamos que el equipo este sin conexion, para poder conectarnos

        if (zes.EstadoConexionEquipo() == ZESStatus.SIN_CONEXION) {
//            //Configuramos la direccion IP que va a tener el equipo.
//            zes.setDireccionIP(dir_ip);
//            //Configuramos el puerto al que nos vamos a conectar.
//            zes.setPuerto(Integer.parseInt(puerto));
//            // ?¿?¿?
//            zes.refresh();

            //Creamos e inicializamos el socket
            zes.sckUDP = UdpFactory.getInstance(UdpType.UDP_SINGLETON);
            zes.sckUDP.setRemoteHost(dir_ip);
            zes.sckUDP.setRemotePort(Integer.parseInt(puerto));
            //sckUDP.DataArrival += socket_DataArrival;
            zes.sckUDP.setListener(zes.deo);
//            zes.sckUDP.bind();                  

            //Configuramos el comando de conexion para que sepa a que equipo nos estamos conectando 
            //Asignamos el comando que queremos que pregunte
            eq.Comando = "e@";
            //Asignamos la respuesta que nos va a devolver.
            eq.Respuesta = "eFirmware ZES80s02 v1.0.2@";
            //"eFirmware base v1.0.0@"
            //Le decimos el principio del intervalo que va a comparar, la respuesta asignada con la respuesta devuelta del equipo.
            eq.PrincipioRespuesta = 1;
            //Le decimos el final del intervalo que va a comparar, la respuesta asignada con la respuesta devuelta del equipo.
            eq.FinalRespuesta = 18;
            //Tamaño hasta la Palabra ZES80s02'Len(eq.Respuesta)
            //Por ultimo le asignamos todos los datos al equipo.
            zes.configComandoConexion(eq);

            logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
            zes.comandoActual = eq.Comando;
            zes.sckUDP.sendData(zes.START_TX + eq.Comando + zes.END_TX);
            zes.sckUDP.bind();

            if (bDispose) {
                zes.iniciaColas();
                zes.iniciaComandoEquipoCorrecto();
                zes.InicializaVariablesFlag(dir_ip, puerto, zes.TIMEOUT_POR_DEFECTO);
            }

            //Cargamos las variables HMI de comunicaciones esto solo se hace una vez porque se quedan guardadas en el modulo 
            InicializaVariablesHmiComunicaciones();
            //Arrancamos el protolo de comunicacion
            zes.Conectar();
        }
    }

    /**
     *  Procedimiento de desactiva las comunicaciones con el equipo
     *  
     *   */
    public void PFinish() {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //Comprobamos que el equipo esta activo para poder desconectarlo
        //If EstadoEquipo Then
        if (zes.EstadoConexionEquipo() != ZESStatus.SIN_CONEXION) {
            //Desconectados el protocolo de comunicaciones
            zes.Desconectar();
            //Ponemos el Flag de estado del equipo ha desconectado
            EstadoEquipo = false;
            SncRo = false;
            SncRw = false;
        }
    }

    /**
     *  Procedimiento que cierra las conexiones del equipo.
     *  
     *  Libera la memoria del equipo */
    public void Close() throws ZESException {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //Llamamos al destructor de la clase para liberar la memoria
        zes.dispose();
    }

    /**
     *  Procedimiento que devuelve el estado del equipo 
     *  
     *   */
    public int FbDSPActivo() {
        int res;
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        //Devolvemos el flag de estado del equipo
        if (EstadoEquipo) {
            if (SncRo && SncRw) {
                res = CobraNetUtil.OK;
            } else {
                res = CobraNetUtil.EQUIPO_SINCRONIZANDOSE;
            }
        } else {
            res = CobraNetUtil.ER_EQUIPO_DESCONECTADO;
        }
        return res;
    }

    /**
     *  Procedimiento que te devuelve la entrada asignada que tiene la salida dada
     *  
     *  @param Salida Es la salida que se desea saber cual es la entrada asignada 
     *  @param Entrada Es la entrada que tiene asignada 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *   1  ok.
     *   2 Error en los parametros.
     *   3 Error equipo desconectado.
     *   4 El equipo se esta sincronizando con la dll. 
     *  Las salida se dividen de la 1 a la 8 en salidas fisicas y de la 9 a la 16 son salidas CobraNet */
    public double PGetSalida(int Salida) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        //Inicializamos la varible donde vamos a guardar el resultado 
        double Entrada = 0;
        //Ejecutamos el Procedimiento Get del dato.
        Entrada = EjecutaProcedimientoGet(CobraNetUtil.P_GETSALIDA, Salida, CobraNetUtil.MIN_SALIDA, CobraNetUtil.MAX_SALIDA);
        //Miramos que tipo de error nos ha generado la libreria
        return Entrada;
    }

    /**
     * Procedimiento que devuelve la ganancia de entrada 
     * @param Entrada Es la entrada de la que se quiere saber su ganancia 
     * @param Ganancia Es la ganancia del canal fisico de entrada que tiene asignada. 
     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *  1  ok.
     *  2 Error en los parametros.
     *  3 Error equipo desconectado.
     *   4 El equipo se esta sincronizando con la dll. 
     * El valor de la ganancia va de -100 a  12
     */
    public double PGetGananciaCFE(int Entrada) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        //Inicializamos la variable donde vamos a guardar el resultado
        double Ganancia = 0;
        //Ejecutamos el procedimiento Get del dato.
        Ganancia = EjecutaProcedimientoGet(CobraNetUtil.P_GETGANANCIACFE, Entrada, 1, 8);
        //Miramos que tipo de error nos ha generado la libreria
        return Ganancia;
    }

    /**
     * Procedimiento que devuelve la ganancia de la salida fisica.
     * 
     *  @param Salida Es la salida donde se quiere saber su ganancia 
     *  @param Ganancia Es la ganancia del canal fisico de salida que tiene asignada. 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *   1  ok.
     *   2 Error en los parametros.
     *   3 Error equipo desconectado.
     *   4 El equipo se esta sincronizando con la dll. 
     *  El valor de la ganancia va de -100 a 12
     */
    public double PGetGananciaCFS(int Salida) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean r = false;
        //Inicializamos la variable donde vamos a guardar el resultado 
        double Ganancia = 0;
        //Ejecutamos el procedimiento Get del Dato
        Ganancia = EjecutaProcedimientoGet(CobraNetUtil.P_GETGANANCIACFS, Salida, 1, 8);
        //Miramos que tipo de error nos ha generado la libreria
        return Ganancia;
    }

    /**
     * Obtiene el valor asignado a un Bundle de entrada 
     * 
     *  @param Bundle Es el bundle del que se quiere saber su valor 
     *  @param Dato Es el valor del bundle que tienes asignado, El Rango del valor del Bundle va del 0 al 65535 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *   1  ok.
     *   2 Error en los parametros.
     *   3 Error equipo desconectado.
     *   4 El equipo se esta sincronizando con la dll. 
     */
    public double PGetBundleEntrada(int Bundle) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //Inicializamos la variable donde vamos a guardar el resultado
        double Dato = 0.0;
        //Ejecutamos el procedimiento Get del dato 
        Dato = EjecutaProcedimientoGet(CobraNetUtil.P_GETBUNDLEENTRADA, Bundle, CobraNetUtil.MIN_BUNDLE, CobraNetUtil.MAX_BUNDLE);
        //Miramos que tipo de error nos ha generado la libreria
        return Dato;
    }

    /**
     *  Obtiene el valor asignado de un Bundle de salida
     *  
     *  @param Bundle Es el bundle del que se quiere saber su valor 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *    1  ok.
     *    2 Error en los parametros.
     *    3 Error equipo desconectado.
     *    4 El equipo se esta sincronizando con la dll. 
     *   @param Dato Es el valor del bundle que tienes asignado, El Rango del valor del Bundle va del 0 al 65535 
     */
    public double PGetBundleSalida(int Bundle) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //Inicializamos la variable donde vamos a guardar el resultado
        double Dato = 0;
        //Ejecutamos el procedimiento Get del dato 
        Dato = EjecutaProcedimientoGet(CobraNetUtil.P_GETBUNDLESALIDA, Bundle, CobraNetUtil.MIN_BUNDLE, CobraNetUtil.MAX_BUNDLE);
        //Miramos que tipo de error nos ha generado la libreria
        return Dato;
    }

    /**
     * Devuelve el valor del TxSubMap
     *
     * @param Bundle El Bundle del que se quiere saber el TxSubMap 
     * @param canal Es el Sub-canal del Bundle  
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *  1  ok.
     *  2 Error en los parametros.
     *  3 Error equipo desconectado.
     *  4 El equipo se esta sincronizando con la dll. 
     * @param Dato Es el valor que tiene asignado 
     *  Los posibles valores pueden se enre 1 y 8
     */
    public double PGetTxSubMap(int Bundle, int Canal) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //Inicializamos la variable donde vamos a guardar el resultado
        double res = 0;
        //Ejecutamos el procedimiento Get del dato 
        res = EjecutaProcedimientoSetSubCanal(CobraNetUtil.P_GETTXSUBMAP, Bundle, Canal);
        //Miramos que tipo de error nos ha generado la libreria
        return res;
    }

    /**
     * Devuelve el valor del RxSubMap
     * 
     * @param Bundle El Bundle del que se quiere saber el TxSubMap 
     * @param canal Es el Sub-canal del Bundle  
     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *  1  ok.
     *  2 Error en los parametros.
     *  3 Error equipo desconectado.
     *  4 El equipo se esta sincronizando con la dll. 
     * @param Dato Es el valor que tiene asignado 
     * Los posibles valores pueden se enre 1 y 8
     */
    public double PGetRxSubMap(int Bundle, int Canal) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //Inicializamos la variable donde vamos a guardar el resultado
        double Dato = 0;
        //Ejecutamos el procedimiento Get del dato 
        Dato = EjecutaProcedimientoSetSubCanal(CobraNetUtil.P_GETRXSUBMAP, Bundle, Canal);
        //Miramos que tipo de error nos ha generado la libreria
        return Dato;
    }

    /**
     * Devuelve el nivel dB de un canal de entrada dado, ya se canal fisico ó canal cobranet
     *
     *  @param Entrada Es la entrada que se quiere saber el nivel dB. 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *  1  ok.
     *  2 Error en los parametros.
     *  3 Error equipo desconectado.
     *  4 El equipo se esta sincronizando con la dll. 
     * @param Valor El valor devuelto va ente -100 y 12 
     */
    public double PGetVumetroCE(int Entrada) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //Inicializamos la variable donde vamos a guardar el resultado
        double Valor = 0;
        //Ejecutamos el procedimiento Get del dato 
        Valor = EjecutaProcedimientoGet(CobraNetUtil.P_GETVUMETROCE, Entrada, CobraNetUtil.MIN_ENTRADA, CobraNetUtil.MAX_ENTRADA);
        //Miramos que tipo de error nos ha generado la libreria
        return Valor;
    }

    /**
     * Devuelve el nivel dB de un canal de salida dado, ya se canal fisico ó canal cobranet.
     *
     * @param Salida Es la salida que se quiere saber el nivel dB. 
     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *  1  ok.
     *  2 Error en los parametros.
     *  3 Error equipo desconectado.
     *  4 El equipo se esta sincronizando con la dll.  
     * @param Valor El valor devuelto va entre -100 y 12 
     */
    public double PGetVumetroCS(int Salida) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //Inicializamos la variable donde vamos a guardar el resultado
        double Valor = 0;
        //Ejecutamos el procedimiento Get del dato 
        Valor = EjecutaProcedimientoGet(CobraNetUtil.P_GETVUMETROCS, Salida, CobraNetUtil.MIN_SALIDA, CobraNetUtil.MAX_SALIDA);
        //Miramos que tipo de error nos ha generado la libreria
        return Valor;
    }

    /** 
     * @param Salida  
     * @param Valor  
     * @return Ok  
     */
    public double PGetTono(int Salida) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //Inicializamos la variable donde vamos a guardar el resultado
        double Valor = 0;
        //Ejecutamos el procedimiento Get del dato 
        Valor = EjecutaProcedimientoGet(CobraNetUtil.P_GETTONO, Salida, CobraNetUtil.MIN_SALIDA, CobraNetUtil.MAX_SALIDA);
        //Miramos que tipo de error nos ha generado la libreria
        return Valor;
    }

    public double PGetTonoMaster() {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //Inicializamos la variable donde vamos a guardar el resultado
        double Valor = 0;
        //Ejecutamos el procedimiento Get del dato 
        Valor = EjecutaProcedimientoGet(CobraNetUtil.P_GET_TONO_MASTER, 0, 0, 0);
        //Miramos que tipo de error nos ha generado la libreria
        return Valor;
    }

    public double PGetTonoFrec() {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //Inicializamos la variable donde vamos a guardar el resultado
        double Valor = 0;
        //Ejecutamos el procedimiento Get del dato 
        Valor = EjecutaProcedimientoGet(CobraNetUtil.P_GET_TONO_FREC, 0, 0, 0);
        //Miramos que tipo de error nos ha generado la libreria
        return Valor;
    }

    public double PGetCompresorThreshold(int Entrada) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //Inicializamos la variable donde vamos a guardar el resultado
        double Valor = 0;
        //Ejecutamos el procedimiento Get del dato 
        Valor = EjecutaProcedimientoGet(CobraNetUtil.P_GET_COMPRESOR_THRESHOLD, Entrada, 1, 8);
        //Miramos que tipo de error nos ha generado la libreria
        return Valor;
    }

    public double PGetCompresorRatio(int Entrada) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //Inicializamos la variable donde vamos a guardar el resultado
        double Valor = 0;
        //Ejecutamos el procedimiento Get del dato 
        Valor = EjecutaProcedimientoGet(CobraNetUtil.P_GET_COMPRESOR_RATIO, Entrada, 1, 8);
        //Miramos que tipo de error nos ha generado la libreria
        return Valor;
    }

    public double PGetCompresorAttack(int Entrada) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //Inicializamos la variable donde vamos a guardar el resultado
        double Valor = 0;
        //Ejecutamos el procedimiento Get del dato 
        Valor = EjecutaProcedimientoGet(CobraNetUtil.P_GET_COMPRESOR_ATTACK, Entrada, 1, 8);
        //Miramos que tipo de error nos ha generado la libreria
        return Valor;
    }

    public double PGetCompresorRelease(int Entrada) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //Inicializamos la variable donde vamos a guardar el resultado
        double Valor = 0;
        //Ejecutamos el procedimiento Get del dato 
        Valor = EjecutaProcedimientoGet(CobraNetUtil.P_GET_COMPRESOR_RELEASE, Entrada, 1, 8);
        //Miramos que tipo de error nos ha generado la libreria
        return Valor;
    }

    public double PGetCompresorSoftknee(int Entrada) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //Inicializamos la variable donde vamos a guardar el resultado
        double Valor = 0;
        //Ejecutamos el procedimiento Get del dato 
        Valor = EjecutaProcedimientoGet(CobraNetUtil.P_GET_COMPRESOR_SOFTKNEE, Entrada, 1, 8);
        //Miramos que tipo de error nos ha generado la libreria
        return Valor;
    }

    public double PGetCompresorBypass(int Entrada) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //Inicializamos la variable donde vamos a guardar el resultado
        double Valor = 0;
        //Ejecutamos el procedimiento Get del dato 
        Valor = EjecutaProcedimientoGet(CobraNetUtil.P_GET_COMPRESOR_BYPASS, Entrada, 1, 8);
        //Miramos que tipo de error nos ha generado la libreria
        return Valor;
    }

    public double PGetLimitadorThreshold(int Salida) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //Inicializamos la variable donde vamos a guardar el resultado
        double Valor = 0;
        //Ejecutamos el procedimiento Get del dato 
        Valor = EjecutaProcedimientoGet(CobraNetUtil.P_GET_LIMITADOR_THRESHOLD, Salida, 1, 8);
        //Miramos que tipo de error nos ha generado la libreria
        return Valor;
    }

    public double PGetLimitadorRatio(int Salida) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //Inicializamos la variable donde vamos a guardar el resultado
        double Valor = 0;
        //Ejecutamos el procedimiento Get del dato 
        Valor = EjecutaProcedimientoGet(CobraNetUtil.P_GET_LIMITADOR_RATIO, Salida, 1, 8);
        //Miramos que tipo de error nos ha generado la libreria
        return Valor;
    }

    public double PGetLimitadorAttack(int Salida) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //Inicializamos la variable donde vamos a guardar el resultado
        double Valor = 0;
        //Ejecutamos el procedimiento Get del dato 
        Valor = EjecutaProcedimientoGet(CobraNetUtil.P_GET_LIMITADOR_ATTACK, Salida, 1, 8);
        //Miramos que tipo de error nos ha generado la libreria
        return Valor;
    }

    public double PGetLimitadorRelease(int Salida) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //Inicializamos la variable donde vamos a guardar el resultado
        double Valor = 0;
        //Ejecutamos el procedimiento Get del dato 
        Valor = EjecutaProcedimientoGet(CobraNetUtil.P_GET_LIMITADOR_RELEASE, Salida, 1, 8);
        //Miramos que tipo de error nos ha generado la libreria
        return Valor;
    }

    public double PGetLimitadorSoftknee(int Salida) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //Inicializamos la variable donde vamos a guardar el resultado
        double Valor = 0;
        //Ejecutamos el procedimiento Get del dato 
        Valor = EjecutaProcedimientoGet(CobraNetUtil.P_GET_LIMITADOR_SOFTKNEE, Salida, 1, 8);
        //Miramos que tipo de error nos ha generado la libreria
        return Valor;
    }

    public double PGetLimitadorBypass(int Salida) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //Inicializamos la variable donde vamos a guardar el resultado
        double Valor = 0;
        //Ejecutamos el procedimiento Get del dato 
        Valor = EjecutaProcedimientoGet(CobraNetUtil.P_GET_LIMITADOR_BYPASS, Salida, 1, 8);
        //Miramos que tipo de error nos ha generado la libreria
        return Valor;
    }

    /**
     * Asigna la Ganancia de un canal fisico de entrada.
     *
     * @param Entrada Es el canal fisico que se desea asignar la ganancia. 
     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *  1  ok.
     *  2 Error en los parametros.
     *  3 Error equipo desconectado.
     *  4 El equipo se esta sincronizando con la dll. 
     * @param Ganancia Es la ganancia que se desea asignar. 
     * El valor de la ganancia oscila entre -100 a 12.
     */
    public int PSetGananciaCFE(int Entrada, int Ganancia) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean r = false;
        r = EjecutaProcedimientoSet(CobraNetUtil.P_SETGANANCIACFE, Entrada, 1, 8, Ganancia, CobraNetUtil.MIN_GANANCIA, CobraNetUtil.MAX_GANANCIA);
        //Miramos que tipo de error nos ha generado la libreria
        return DiTipoDeError(r);
    }

    /**
     * Asigna la Ganancia de un canal fisico de salida.
     *
     * @param Salida Es el canal de fisico de salida que se desea asignar la ganancia. 
     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *  1  ok.
     *  2 Error en los parametros.
     *  3 Error equipo desconectado.
     *  4 El equipo se esta sincronizando con la dll. 
     * @param Ganancia Es la ganancia que se desea asignar. 
     * El valor de la ganancia oscila entre -100 a 12.
     */
    public int PSetGananciaCFS(int Salida, int Ganancia) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean r = false;
        r = EjecutaProcedimientoSet(CobraNetUtil.P_SETGANANCIACFS, Salida, 1, 8, Ganancia, CobraNetUtil.MIN_GANANCIA, CobraNetUtil.MAX_GANANCIA);
        //Miramos que tipo de error nos ha generado la libreria
        return DiTipoDeError(r);
    }

    /**  
     *  Asigna el valor de un Bundle de entrada dado.
     *  
     *  @param BundleEntrada Es el Bundle al que queremos asignar un valor. Los Bundle de entradas van del 1 al 4. 
     *  @param vBundle Es el valor del Bundle. Su valor va del 0 al 65535. 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *  1  ok.
     *  2 Error en los parametros.
     *  3 Error equipo desconectado.
     *  4 El equipo se esta sincronizando con la dll. 
     */
    public int PSetBundleEntrada(int BundleEntrada, int vBundle) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean r = false;
        r = EjecutaProcedimientoSet(CobraNetUtil.P_SETBUNDLEENTRADA, BundleEntrada, CobraNetUtil.MIN_RX_BUNDLE, CobraNetUtil.MAX_RX_BUNDLE, vBundle, CobraNetUtil.MIN_VALOR_BUNDLE, CobraNetUtil.MAX_VALOR_BUNDLE);
        //Miramos que tipo de error nos ha generado la libreria
        return DiTipoDeError(r);
    }

    /**  
     *  Asigna el valor de un Bundle de salida dado.
     *  
     *  @param BundleSalida Es el Bundle al que queremos asignar un valor. Los Bundle de salida van del 1 al 4. 
     *  @param vBundle Es el valor del Bundle. Su valor va del 0 al 65535. 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *  1  ok.
     *  2 Error en los parametros.
     *  3 Error equipo desconectado.
     *  4 El equipo se esta sincronizando con la dll. 
     */
    public int PSetBundleSalida(int BundleSalida, int vBundle) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean r = false;
        r = EjecutaProcedimientoSet(CobraNetUtil.P_SETBUNDLESALIDA, BundleSalida, CobraNetUtil.MIN_TX_BUNDLE, CobraNetUtil.MAX_TX_BUNDLE, vBundle, CobraNetUtil.MIN_VALOR_BUNDLE, CobraNetUtil.MAX_VALOR_BUNDLE);
        //Miramos que tipo de error nos ha generado la libreria
        return DiTipoDeError(r);
    }

    /**  
     *  Asigna una Salida a una entrada
     *  
     *  @param Salida Es la salida a la que se le quiere asignar una entrada 
     *  @param Entrada Es valor de la entrada que se quiere asignar. 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *  1  ok.
     *  2 Error en los parametros.
     *  3 Error equipo desconectado.
     *  4 El equipo se esta sincronizando con la dll. 
     */
    public int PSetSalida(int Salida, int Entrada) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean r = false;
        //CobraNetUtil.MIN_ENTRADA - CobraNetUtil.MIN_ENTRADA ES PARA PODER MUTEARLA SALIDA
        r = EjecutaProcedimientoSet(CobraNetUtil.P_SETSALIDA, Salida, CobraNetUtil.MIN_SALIDA, CobraNetUtil.MAX_SALIDA, Entrada, 0, 22);
        //Miramos que tipo de error nos ha generado la libreria
        return DiTipoDeError(r);
    }

    /**  
     *  Asigna el valor del TxSubMap.
     *  
     *  @param Bundle Es el Bundle de salida del que se quiere asignar el valor del Sub-canal. Los posibles valores del bundle pueden ser entre 1 y 4. 
     *  @param Canal Es el Sub-Canal que se quiere asignar un valor. Los posibles valores del Sub-canal pueden ser entre 1 y 8. 
     *  @param Vcanal Es el valor del Sub-Canal que se quiere asignar. El valor del sub-canal puede ser entre 1 y 8 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *  1  ok.
     *  2 Error en los parametros.
     *  3 Error equipo desconectado.
     *  4 El equipo se esta sincronizando con la dll.  
     */
    public int PSetTxSubMap(int Bundle, int Canal, int Vcanal) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean r = false;
        r = EjecutaProcedimientoSetSubCanal(CobraNetUtil.P_SETTXSUBMAP, Bundle, Canal, Vcanal, CobraNetUtil.MIN_VALOR_TX_SUB_CANAL, CobraNetUtil.MAX_VALOR_TX_SUB_CANAL);
        //Miramos que tipo de error nos ha generado la libreria
        return DiTipoDeError(r);
    }

    /** 
     *  Asigna el valor del RxSubMap.
     *  
     *  @param Bundle Es el Bundle de salida del que se quiere asignar el valor del Sub-canal. Los posibles valores del bundle pueden ser entre 1 y 4. 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *   1  ok.
     *   2 Error en los parametros.
     *   3 Error equipo desconectado.
     *   4 El equipo se esta sincronizando con la dll. 
     *  @param Canal Es el Sub-Canal que se quiere asignar un valor. Los posibles valores del Sub-canal pueden ser entre 1 y 8. 
     *  @param Vcanal Es el valor del Sub-Canal que se quiere asignar. El valor del sub-canal puede ser entre 1 y 8 
     */
    public int PSetRxSubMap(int Bundle, int Canal, int Vcanal) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean r = false;
        r = EjecutaProcedimientoSetSubCanal(CobraNetUtil.P_SETRXSUBMAP, Bundle, Canal, Vcanal, CobraNetUtil.MIN_VALOR_RX_SUB_CANAL, CobraNetUtil.MAX_VALOR_RX_SUB_CANAL);
        //Miramos que tipo de error nos ha generado la libreria
        return DiTipoDeError(r);
    }

    /**
     * 
     * @param Salida
     * @param Valor
     * @return 
     */
    public int PSetTono(int Salida, int Valor) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean r = false;
        r = EjecutaProcedimientoSet(CobraNetUtil.P_SETTONO, Salida, 1, 8, Valor, CobraNetUtil.MIN_TONO, CobraNetUtil.MAX_TONO);
        //Miramos que tipo de error nos ha generado la libreria
        return DiTipoDeError(r);
    }

    /**
     * 
     * @param Valor
     * @return Ok
     * @return 
     */
    public int PSetTonoMaster(int Valor) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean r = false;
        r = EjecutaProcedimientoSet(CobraNetUtil.P_SET_TONO_MASTER, 0, 0, 0, Valor, CobraNetUtil.MIN_TONO_MASTER, CobraNetUtil.MAX_TONO_MASTER);
        //Miramos que tipo de error nos ha generado la libreria
        return DiTipoDeError(r);
    }

    public int PSetTonoFrec(int Valor) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean r = false;
        r = EjecutaProcedimientoSet(CobraNetUtil.P_SET_TONO_FREC, 0, 0, 0, Valor, CobraNetUtil.MIN_TONO_FREC, CobraNetUtil.MAX_TONO_FREC);
        //Miramos que tipo de error nos ha generado la libreria
        return DiTipoDeError(r);
    }

    /**
     * Devuelve un dato de una direccion HMI
     *
     * @param AddressHMI Es la direccion HMI que se quiere consultar 
     * @param Dato Es el valor del dato que hay en la direccion HMI 
     * @return Ok 
     *  1  ok.
     *  2 Error en los parametros.
     *  3 Error equipo desconectado.
     *  4 El equipo se esta sincronizando con la dll. 
     */
    public double PGetDatoDSP(String AddressHMI) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //Inicializamos la variable donde vamos a guardar el resultado 
        double Dato = 0;
        //Ejecutamos el procedimiento Get del Dato
        Dato = EjecutaProcedimientoGetHMI(CobraNetUtil.P_GET_DATO_HMI, AddressHMI);
        //Miramos que tipo de error nos ha generado la libreria
        return Dato;
    }

    /**
     * Asigna un dato al DSP
     * 
     * @param AddressHMI Es la direccion del HMI. es un String en base Hexadecimal. 
     * @param Dato Es el valor del dato que se va a enviar o asignar. 
     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *  1  ok.
     *  2 Error en los parametros.
     *  3 Error equipo desconectado.
     *  4 El equipo se esta sincronizando con la dll. 
     */
    public int PSetDatoDSP(String AddressHMI, int Dato) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean r = false;
        //Ejecutamos el procedimiento Set del Dato 
        r = EjecutaProcedimientoSetComandosHMI(CobraNetUtil.P_SET_DATO_HMI, AddressHMI, Dato);
        //Miramos que tipo de error nos ha generado la libreria
        return DiTipoDeError(r);
    }

    /**
     *  Guarda o Borra un preset al equipo.
     *  
     *  @param Accion Es la accion que se va ha realizar. Si es TRUE va a guardar un preset y Si es un FALSE va a borrar el preset 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *   1  ok.
     *   2 Error en los parametros.
     *   3 Error equipo desconectado.
     *   4 El equipo se esta sincronizando con la dll. 
     *   */
    public int PSetPreset(boolean Accion) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean r = false;
        String dato = null;
        //Comprobamos que tipo de accion es
        if (Accion) {
            dato = "1";
            //Se va a guardar un preset
        } else {
            dato = "0";
            //Se va a borrar un preset
        }
        //Ejecutamos el procedimiento Set del Dato
        r = EjecutaProcedimientoSetComandos(CobraNetUtil.P_SET_PRESET, dato);
        //Miramos que tipo de error nos ha generado la libreria
        return DiTipoDeError(r);
    }

    /**
     *  Procedimiento que cambia la direccion Ip del quipo 
     *  
     *  @param AddressIp Es la nueva direccion Ip del equipo  
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *   1  ok.
     *   2 Error en los parametros.
     *   3 Error equipo desconectado.
     *   4 El equipo se esta sincronizando con la dll. 
     *   */
    private int PSetDireccionIP(String AddressIp) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean r = false;
        r = EjecutaProcedimientoSetComandos(CobraNetUtil.P_ADDRESS_IP, AddressIp);
        //Miramos que tipo de error nos ha generado la libreria
        return DiTipoDeError(r);
    }

    /**
     *  Procedimiento que cambia la direccion MAC del Equipo 
     *  
     *  @param AddressMac Es la nueva direccion MAC del equipo. 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *   1  ok.
     *   2 Error en los parametros.
     *   3 Error equipo desconectado.
     *   4 El equipo se esta sincronizando con la dll. 
     *   */
    private int PSetDireccionMac(String AddressMac) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean r = false;
        r = EjecutaProcedimientoSetComandos(CobraNetUtil.P_ADDRES_MAC, AddressMac);
        //Miramos que tipo de error nos ha generado la libreria
        return DiTipoDeError(r);
    }

    /**
     *  Procedimiento que cambia la Puerta de enlace del equipo
     *  
     *  @param Gateway Es la nueva Puerta de enlace del equipo. 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *   1  ok.
     *   2 Error en los parametros.
     *   3 Error equipo desconectado.
     *   4 El equipo se esta sincronizando con la dll. 
     *   */
    private int PSetPuertaEnlace(String Gateway) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean r = false;
        r = EjecutaProcedimientoSetComandos(CobraNetUtil.P_PUERTA_ENLACE, Gateway);
        //Miramos que tipo de error nos ha generado la libreria
        return DiTipoDeError(r);
    }

    /**
     *  Procedimiento que cambia la Mascara de SubRed del equipo. 
     *  
     *  @param MaskAddress Es la nueva mascara de subred del equipo. 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *   1  ok.
     *   2 Error en los parametros.
     *   3 Error equipo desconectado.
     *   4 El equipo se esta sincronizando con la dll. 
     *   */
    private int PSetMascaraSubRed(String MaskAddress) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean r = false;
        r = EjecutaProcedimientoSetComandos(CobraNetUtil.P_SUBRED, MaskAddress);
        //Miramos que tipo de error nos ha generado la libreria
        return DiTipoDeError(r);
    }

    /**
     *  Procedimiento que cambia el estado del amplificador, es decir, Activa o Desactiva el amplificador del equipo.
     *  
     *  @param Estado Es el nuevo estado del amplificador, es decir, Si es TRUE el amplificador se va a activar, Si es FALSE el amplificador se va a desactivar 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *   1  ok.
     *   2 Error en los parametros.
     *   3 Error equipo desconectado.
     *   4 El equipo se esta sincronizando con la dll. 
     *   */
    public int PSetAmplificador(boolean Estado) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean r = false;
        String dato = null;
        if (Estado) {
            dato = "1";
            //Se va activar el amplificador
        } else {
            dato = "0";
            //Se va a desactivar el amplificador
        }
        r = EjecutaProcedimientoSetComandos(CobraNetUtil.P_SET_AMPLIFICADOR, dato);
        //Miramos que tipo de error nos ha generado la libreria.
        return DiTipoDeError(r);
    }

    /**
     *  Procedimiento que cambia el estado del atenuador, es decir, Activa o Desactiva el atenuador del equipo.
     *  
     *  @param Estado Es el nuevo estado del atenuador, es decir, Si es TRUE el atenuador se va a activar, Si es FALSE el atenuador se va a desactivar 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *   1  ok.
     *   2 Error en los parametros.
     *   3 Error equipo desconectado.
     *   4 El equipo se esta sincronizando con la dll. 
     *   */
    public int PSetAtenuador24V(boolean Estado) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean r = false;
        String dato = null;
        if (Estado) {
            dato = "1";
            //Se va activar el amplificador
        } else {
            dato = "0";
            //Se va a desactivar el amplificador
        }
        r = EjecutaProcedimientoSetComandos(CobraNetUtil.P_SET_ATENUADOR, dato);
        //Miramos que tipo de error nos ha generado la libreria.
        return DiTipoDeError(r);
    }

    /**
     *  Procedimiento que maneja el MP3.
     *  
     *  @param Play Si true inicia el mp3, si false lo para.  
     *  @param Pista Si 0, reproduce todas las pistas de la SD, en este caso el valor de looping no se tiene en cuenta. Sino, reproduce la pista seleccionada y despues para 
     *  @param Looping Si 1 y pista es distinto de 0, se reproduce el mensaje indefinidamente. Si 0 y pista distinta de x. Al terminar la pista se para el mp3 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *   1  ok.
     *   2 Error en los parametros.
     *   3 Error equipo desconectado.
     *   4 El equipo se esta sincronizando con la dll. 
     *   */
    /* TODO */
    public int PSetMP3(boolean Play, int Pista, boolean Looping) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean r = false;
        String dato = null;
        dato = "";
        if (Play) {
            if (Pista == 0) {
                dato = "000000";
            } else if (Pista > 0 & Pista < 65535) {
                dato = String.valueOf(Pista);
                while (dato.length() < 5) {
                    dato = "0" + dato;
                }
                if (Looping) {
                    dato = dato + "1";
                } else {
                    dato = dato + "0";
                }
            }
        } else {
            dato = "655350";
        }
        r = EjecutaProcedimientoSetComandos(CobraNetUtil.P_SET_MP3, dato);
        //Miramos que tipo de error nos ha generado la libreria.
        return DiTipoDeError(r);
    }

    /**
     *  Procedimiento que lee el estado del mp3.
     *  
     *  @param Reproduciendo Indica sie el mp3 está reproduciendo  o no.  
     *  @param Pista Pista que actualmente se está reproduciendo 
     *  @param NumPistas Número de pistas contenidas enb la sd 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *   1  ok.
     *   2 Error en los parametros.
     *   3 Error equipo desconectado.
     *   4 El equipo se esta sincronizando con la dll. 
     *   */
    public int PGetMP3(boolean Reproduciendo, int Pista, int NumPistas) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean r = false;
        String dato = null;
        if (MP3Song != 0) {
            Reproduciendo = true;
        } else {
            Reproduciendo = false;
        }
        Pista = MP3Song;
        NumPistas = MP3NFiles;
        //Miramos que tipo de error nos ha generado la libreria.
        return DiTipoDeError(true);
        //Siempre es true porque leemos directamente desde la variable.
    }

    /**
     *  Envia un reset al equipo
     *  
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *   1  ok.
     *   2 Error en los parametros.
     *   3 Error equipo desconectado. 
     *  El equipo se va a resetear */
    public int PSetReset() {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean r = false;
        String dato = null;
        //Es el comando de reset del equipo
        dato = "";
        //Ejecutamos el procedimiento Set del dato
        r = EjecutaProcedimientoSetComandos(CobraNetUtil.P_SET_RESET, dato);
        //Mira que tipo de error nos ha generado la libreria
        return DiTipoDeError(r);
    }

    /**
     *  Procedimiento que consulta el estado del amplificador, es decir, te dice si el amplificador del equipo esta Activo o Desactivo.
     *  
     *  @param Estado Es el estado del amplificador, es decir, Si es TRUE el amplificador esta activo, Si es FALSE el amplificador esta desactivo. 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *   1  ok.
     *   2 Error en los parametros.
     *   3 Error equipo desconectado.
     *   4 El equipo se esta sincronizando con la dll. 
     *   */
    public int PGetAmplificador(boolean Estado) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //Volcamos el estado del amplificador
        Estado = stateAmp;
        //Miramos que tipo de error nos ha generado la libreria.
        return DiTipoDeError(true);
        //Siempre es true porque leemos directamente desde la variable.
    }

    /**
     *  Procedimiento que consulta el estado del atenuador, es decir, te dice si el atenuador del equipo esta Activo o Desactivo.
     *  
     *  @param Estado Es el estado del atenuador, es decir, Si es TRUE el atenuador esta activo, Si es FALSE el atenuador esta desactivo. 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *   1  ok.
     *   2 Error en los parametros.
     *   3 Error equipo desconectado.
     *   4 El equipo se esta sincronizando con la dll. 
     *   */
    public int PGetAtenuador24V(boolean Estado) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //Volcamos el estado del atenuador
        Estado = stateATT;
        //Miramos que tipo de error nos ha generado la libreria.
        return DiTipoDeError(true);
        //Siempre es true porque leemos directamente desde la variable.
    }

    /**
     *  Procedimiento que comprueba si el modulo de expansión del zes existe.
     *  
     *  @param Existe Si 1 el modulo de expansion existe 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *   1  ok.
     *   2 Error en los parametros.
     *   3 Error equipo desconectado.
     *   4 El equipo se esta sincronizando con la dll. 
     *   */
    public boolean PGetModExpansionIn() {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean Existe;
        Existe = ModExpansion;
        //Miramos que tipo de error nos ha generado la libreria.
        return Existe;
        //Siempre es true porque leemos directamente desde la variable.
    }

    /**
     *  Procedimiento que comprueba si el mp3 del zes existe.
     *  
     *  @param Existe Si 1 el mp3 existe 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *   1  ok.
     *   2 Error en los parametros.
     *   3 Error equipo desconectado.
     *   4 El equipo se esta sincronizando con la dll. 
     *   */
    public int PGetMP3In(boolean Existe) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        Existe = MP3;
        //Miramos que tipo de error nos ha generado la libreria.
        return DiTipoDeError(true);
        //Siempre es true porque leemos directamente desde la variable.
    }

    /**
     *  Procedimiento que comprueba si la sd del zes existe.
     *  
     *  @param Existe Si 1 la sd existe 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *   1  ok.
     *   2 Error en los parametros.
     *   3 Error equipo desconectado.
     *   4 El equipo se esta sincronizando con la dll. 
     *   */
    public boolean PGetSDIn() {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean Existe;
        Existe = SDIN;
        //Miramos que tipo de error nos ha generado la libreria.
        return Existe;
        //Siempre es true porque leemos directamente desde la variable.
    }

    /**
     *  Procedimiento que comprueba si la sd del zes está protegida.
     *  
     *  @param Protegida Si 1 la sd está protegida 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *   1  ok.
     *   2 Error en los parametros.
     *   3 Error equipo desconectado.
     *   4 El equipo se esta sincronizando con la dll. 
     *   */
    public boolean PGetSDProtect() {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean Protegida;
        Protegida = SDPROTECT;
        //Miramos que tipo de error nos ha generado la libreria.
        return Protegida;
        //Siempre es true porque leemos directamente desde la variable.
    }

    /**
     *  Procedimiento que consulta el estado de la temperatura del equipo y su ventilacion.
     *  
     *  @param Temp1 Es la temperatura del primer sensor, en grados centigrador. 
     *  @param Vent1 Es el flag de si esta o no activo la ventilacion. 
     *  @param Temp2 Es la temperatura del segundo sensor, en grados centigrador. 
     *  @param Vent2 Es el flag de si esta o no activo la ventilacion. 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *   1  ok.
     *   2 Error en los parametros.
     *   3 Error equipo desconectado.
     *   4 El equipo se esta sincronizando con la dll. 
     *   */
    public Map<String, String> PGetTemperatura() {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        Map<String, String> res = new Hashtable<String, String>();

        //Volcamos los datos a sus correspondientes variables.
        res.put("Temp1",Temperatura1+"");
        res.put("Vent1",Ventilacion1+"");
        res.put("Temp2",Temperatura2+"");        
        res.put("Vent2",Ventilacion2+"");
        //Miramos que tipo de error nos ha generado la libreria.
        return res;
        //Siempre es true porque leemos directamente desde la variable.
    }

    /**
     *  Procedimiento que activa o desactiva un cierre
     *  
     *  @param Indice Es el Indice que se quiere enviar el busy 
     *  @param Activar Es el valor del busy. Si es 1 se activa el cierre y si es 0 se desactiva. 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *   1  ok.
     *   2 Error en los parametros.
     *   3 Error equipo desconectado.
     *   4 El equipo se esta sincronizando con la dll. 
     *   */
    public int PSetCierre(int Indice, boolean Activar) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());



        boolean r = false;
        String dato = null;
        int i = 0;
        dato = "";
        if ((Indice >= CobraNetUtil.CIERRE1 & Indice <= CobraNetUtil.CIERRE16)) {
            if (Indice < CobraNetUtil.CIERRE10) {
                dato = "0" + String.valueOf(Indice);
            } else {
                dato = String.valueOf(Indice);
            }
            if (Activar) {
                dato = dato + "1";
            } else {
                dato = dato + "0";
            }
            r = EjecutaProcedimientoSetComandos(CobraNetUtil.P_SET_CIERRE, dato);
        } else {
            r = false;
        }
        //Miramos  que tipo de error nos ha generado la libreria.
        return DiTipoDeError(r);
    }

    /**
     *  Procedimiento que devuelve el estado de los busy.
     *  
     *  @param Cierre Indice del cierre a consultar 
     *  @param Act Indica si el cierre está activo o no 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *   1  ok.
     *   2 Error en los parametros.
     *   3 Error equipo desconectado.
     *   4 El equipo se esta sincronizando con la dll. 
     *   */
    public boolean PGetCierre(int Cierre) throws DriverException {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean Act;
        boolean r = false;
        if (Cierre >= CobraNetUtil.CIERRE1 & Cierre <= CobraNetUtil.CIERRE16) {
            Act = Activo[Cierre];
            //Miramos que tipo de error nos ha generado la libreria.
            return Act;
            // Le pasamos True porque solo leemos los datos guardados.
        } else {
            throw new DriverException("PARAM " + Cierre);
        }
    }

    /**
     *  Procedimiento que configura un cierre.
     *  
     *  @param Indice Es el indice del cierre que se quiere configurar. 
     *  @param Salida Si es 1, configura el cierre como salida, sino como entrada. 
     *  @param Alto Si es 1, configura el cierre a nivel alto, sino a nivel bajo. 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *   1  ok.
     *   2 Error en los parametros.
     *   3 Error equipo desconectado.
     *   4 El equipo se esta sincronizando con la dll. 
     *   */
    public int PSetConfigCierres(int Indice, boolean Salida, boolean Alto) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean r = false;
        String dato = null;
        int i = 0;
        dato = "";
        if ((Indice >= CobraNetUtil.CIERRE1 & Indice <= CobraNetUtil.CIERRE16)) {
            if (Indice < CobraNetUtil.CIERRE10) {
                dato = "0" + Indice;
            } else {
                dato = String.valueOf(Indice);
            }
            if (Salida) {
                dato = dato + "1";
            } else {
                dato = dato + "0";
            }
            if (Alto) {
                dato = dato + "1";
            } else {
                dato = dato + "0";
            }
            r = EjecutaProcedimientoSetComandos(CobraNetUtil.P_SET_CONFIG_CIERRE, dato);
        } else {
            r = false;
        }
        //Miramos  que tipo de error nos ha generado la libreria.
        return DiTipoDeError(r);
    }

    /**
     *  Procedimiento que configura un cierre.
     *  
     *  @param Indice Es el indice del cierre que se quiere configurar. 
     *  @param Sal Si es 1, está configurado el cierre como salida, sino como entrada. 
     *  @param Alt Si es 1, está configurado el cierre a nivel alto, sino a nivel bajo. 
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *   1  ok.
     *   2 Error en los parametros.
     *   3 Error equipo desconectado.
     *   4 El equipo se esta sincronizando con la dll. 
     *   */
    public Map<String,Boolean> PGetConfigCierres(int Indice) throws DriverException {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean Alt;
        boolean Sal;
        Map<String,Boolean> res = new HashMap<String, Boolean>();
        
        if (Indice >= CobraNetUtil.CIERRE1 & Indice <= CobraNetUtil.CIERRE16) {
            Sal = Salida[Indice];
            Alt = Alto[Indice];
            res.put("SAL", Sal);
            res.put("ALT", Alt);
            //Miramos que tipo de error nos ha generado la libreria.
            return res;
            // Le pasamos True porque solo leemos los datos guardados.
        } else {
           throw new DriverException(ZESStatus.status2String(CobraNetUtil.ER_VERSION));
        }
    }

    /**
     *  Procedimiento que configura la gestiion automatica de microfonos.
     *  
     *  @param Act 
     *  TRUE Activa la gestion automatica de microfonos.
     *  FALSE Desactiva la gestion automatica de microfonos.
     *   
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *  1 Ok.
     *  2 Error en los parametros.
     *  3 Error Equipo desconectado.
     *  4 El equipo se esta Sincronizando con la dll.
     *  5 La versión de firmware no es compatible con la funcion.
     *   
     *   */
    public int PSetConfigGestionAutomaticaMicrofonos(boolean Act) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean r = false;
        String Dato = null;
        //Comprobamos que la versión es la correcta, la gestión automatica de microfonos esta implementada a partir de la versión 2.3.0 de firmware.
        if (compruebaVersionSuperior2_3_0()) {
            if (Act) {
                //Gestion automatica de microfonos activa.
                Dato = "1";
                AutoMic = true;
            } else {
                //Gestion automatica de microfonos Desactiva.
                Dato = "0";
                AutoMic = false;
            }
            r = EjecutaProcedimientoSetComandos(CobraNetUtil.P_SET_MIC, Dato);
            //Miramos que tipo de error nos ha generado la libreria.
            return DiTipoDeError(r);
        } else {
            return CobraNetUtil.ER_VERSION;
        }
    }

    /**
     *  Procedimiento que devuelve si esta activo o no la gestion automatica de Microfonos.
     *  
     *  @param Act 
     *  TRUE Esta activo la gestion automatica de microfonos.
     *  FALSE Esta desactivo la gestion automatica de microfonos.
     *   
     *  @param ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *  1 Ok.
     *  2 Error en los parametros.
     *  3 Error Equipo desconectado.
     *  4 El equipo se esta sincronizando con la dll.
     *  5 La versión de firmware no es compatible con la funcion.
     *   
     *   */
    public boolean PGetConfigGestionAutomaticaMicrofonos() throws DriverException {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean Act;
        //Comprobamos que la versión es la correcta, la gestión automatica de microfonos esta implementada a partir de la versión 2.3.0 de firmware.
        if (compruebaVersionSuperior2_3_0()) {
            //Devolvemos el estado del flag de la gestion automatica de microfonos
            Act = AutoMic;
            //Miramos que tipo de error nos ha generado la libreria.
            return Act;
            // Siempre es true porque leemos directamente desde la variable.
        } else {
            throw new DriverException(ZESStatus.status2String(CobraNetUtil.ER_VERSION));
        }
    }

    /**
     *  Procedimiento que activa / desactiva las comunicaciones Rs-485
     *  
     *  @param Act 
     *  TRUE Activa las comunicaciones 485.
     *  FALSE Desactiva las comunicaciones 485.
     *   
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *  1 Ok.
     *  2 Error en los parametros.
     *  3 Error Equipo desconectado.
     *  4 El equipo se esta sincronizando con la dll.
     *  5 La versión de firmware no es compatible con la funcion.
     *   
     *   */
    public int PSetComunicaciones485(boolean Act) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean r = false;
        String Dato = null;
        //comprobamos que la versión es la correcta, las comunicaciones Rs485 estan implementadas a partir de la versión 2.1.0 de firmware.
        if (compruebaVersion()) {
            if (Act) {
                //Comunicaciones 485 activas, Comunicaciones 232 desactivados
                Dato = "10";
                Rs485 = true;
            } else {
                //Comunicaciones 485 desactivadas, Comunicaciones 232 activadas.
                Dato = "00";
                Rs485 = false;
            }
            r = EjecutaProcedimientoSetComandos(CobraNetUtil.P_SET_UART1, Dato);
            //Miramos que tipo de error nos ha generado la libreria.
            return DiTipoDeError(r);
        } else {
            return CobraNetUtil.ER_VERSION;
        }
    }

    /**
     *  Procedimiento que devuelve si esta configurado las comunicaciones Rs-485.
     *  
     *  @param Act 
     *  TRUE Esta activa las comunicaciones 485.
     *  FALSE Esta desactiva las comunicaciones 485.
     *   
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *  1 Ok.
     *  2 Error en los parametros.
     *  3 Error Equipo desconectado.
     *  4 El equipo se esta sincronizando con la dll.
     *  5 La versión de firmware no es compatible con la funcion.
     *   
     *   */
    public boolean PGetComunicaciones485() throws DriverException {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean Act = false;
        //Comprobamos que la versión es la correcta, las comunicaciones Rs485 estan implementadas a partir de la versión 2.1.0 de firmware
        if (compruebaVersion()) {
            //Devolvemos el estado del Rs485
            Act = Rs485;
            //Miramos que tipo de error nos ha generado la libreria.
            return Act;
            //Siempre es true porque leemos directamente desde la variable.
        } else {
            throw new DriverException(ZESStatus.status2String(CobraNetUtil.ER_VERSION));
        }
    }

    /**
     *  Procedimiento que devuelve si esta configurado los atenuadores para la gestión automática de micrófonos.
     *  
     *  @param Act 
     *  TRUE Esta activa los atenuadores para la gestión automática de micrófonos.
     *  FALSE Esta desactiva los atenuadores para la gestión automática de micrófonos.
     *   
     *  @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
     *  1 Ok.
     *  2 Error en los parametros.
     *  3 Error Equipo desconectado.
     *  4 El equipo se esta sincronizando con la dll.
     *  5 La versión de firmware no es compatible con la funcion.
     *   
     *   */
    public boolean PGetConfigAtenuadores() throws DriverException {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean Act = false;
        //Comprobamos que la versión es la correcta, la configuración de atenuadores es a partir de la versión 2.3.0 de firmware.
        if (compruebaVersionSuperior2_3_0()) {
            //Devolvemos el estado del Flag
            Act = cnfAtenuadores;
            //Miramos que tipo de error nos ha generado la libreria.
            return Act;
            //Siempre es true porque leemos directamoente desde la variable.
        } else {
            throw new DriverException(ZESStatus.status2String(CobraNetUtil.ER_VERSION));
        }
    }

    /**
     *  Procedimiento que configura si los atenuadores se activan para la gestión automática de micrófonos.
     *  
     *  @param Act 
     *  TRUE Esta activa los atenuadores para la gestión automática de micrófonos.
     *  FALSE Esta desactiva los atenuadores para la gestión automática de micrófonos.
     *   
     *  @return Ok 
     *  1 Ok.
     *  2 Error en los parametros.
     *  3 Error Equipo desconectado.
     *  4 El equipo se esta sincronizando con la dll.
     *  5 La versión de firmware no es compatible con la funcion.
     *   
     *   */
    public int PSetConfigAtenuadores(boolean Act) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean r = false;
        String Dato = null;
        //Comprobamos que la versión es la correcta, la configuración de atenuadores es a partir de la versión 2.3.0 de firmware.
        if (compruebaVersionSuperior2_3_0()) {
            if (Act) {
                //Los atenuadores se activan si esta configurado la gestión automática de micrófonos.
                Dato = "1";
                cnfAtenuadores = true;
            } else {
                //Los atenuadores estan desactivado si esta configurado la gestión automática de micrófonos.
                Dato = "0";
                cnfAtenuadores = false;
            }
            r = EjecutaProcedimientoSetComandos(CobraNetUtil.P_SET_ATEN, Dato);
            //Miramos que tipo de error nos ha generado la libreria.
            return DiTipoDeError(r);
        } else {
            return CobraNetUtil.ER_VERSION;
        }
    }

    //  "Funciones y Procedimientos Privados"
    /**
     *  Procedimiento que inicializa las variables, flag de la clase.
     */
    private void InicializaVariables() {
        logger.debug("START : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        Collection comandoRefresco = new LinkedList();
//        zes = new ProtocoloComunicacion();
        //Inicializamos el flag de estado del equipo
        EstadoEquipo = false;
        //Inicializamos las datos donde se van a guardar los datos del HMI
        InicializaDatosHMI();
        //comandoRefresco.add("l@")   'Comando para saber el nivel dB de las entradas y de las salidas.
        //comandoRefresco.add("j@")   'Comando para saber si esta sincronizado las variables del HMI(ya sean Read-Only ó Read-Write)

        //Comando para ver
        comandoRefresco.add("m@");

        //Vúmetro de Salida
        comandoRefresco.add("f7A118@");
        comandoRefresco.add("f7A11C@");
        comandoRefresco.add("f7A120@");
        comandoRefresco.add("f7A124@");
        comandoRefresco.add("f7A128@");
        comandoRefresco.add("f7A12C@");
        comandoRefresco.add("f7A130@");
        comandoRefresco.add("f7A134@");
        comandoRefresco.add("f7A138@");
        comandoRefresco.add("f7A13C@");
        comandoRefresco.add("f7A140@");
        comandoRefresco.add("f7A144@");
        comandoRefresco.add("f7A148@");
        comandoRefresco.add("f7A14C@");
        comandoRefresco.add("f7A150@");
        comandoRefresco.add("f7A154@");

        comandoRefresco.add("m@");
        //Vúmetro de entrada        
        comandoRefresco.add("f7A04A@");
        comandoRefresco.add("f7A04E@");
        comandoRefresco.add("f7A052@");
        comandoRefresco.add("f7A056@");
        comandoRefresco.add("f7A05A@");
        comandoRefresco.add("f7A05E@");
        comandoRefresco.add("f7A062@");
        comandoRefresco.add("f7A066@");
        comandoRefresco.add("f7A06A@");
        comandoRefresco.add("f7A06E@");
        comandoRefresco.add("f7A072@");
        comandoRefresco.add("f7A076@");
        comandoRefresco.add("f7A07A@");
        comandoRefresco.add("f7A07E@");
        comandoRefresco.add("f7A082@");
        comandoRefresco.add("f7A086@");

        zes.AgregaComando(comandoRefresco);
        logger.debug("END : " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     *  Procedimiento que inicizaliza los datos HMI 
     */
    private void InicializaDatosHMI() {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        int i = 0;
        //Inicializamos las variables Read-Only 
        for (i = 0; i <= CobraNetUtil.TAM_RO; i++) {
            varRo[i] = 0;
        }
        //Inicializamos las variables Read-Write
        for (i = 0; i <= CobraNetUtil.TAM_RW; i++) {
            varRw[i] = 0;
        }
        //Inicializamos las variables Bundles Rx y Tx
        for (i = 0; i <= CobraNetUtil.TMN_BUNDLE; i++) {
            varBundleRx[i] = 0;
            varBundleTx[i] = 0;
        }
        //Inicializamos las variables subMap de lo bundles de los canales Tx y Rx
        for (i = 0; i <= CobraNetUtil.TMN_CANALES_BUNDLE; i++) {
            // Los SubMap de los Rx
            varRxSubMapB1[i] = 0;
            varRxSubMapB2[i] = 0;
            varRxSubMapB3[i] = 0;
            varRxSubMapB4[i] = 0;
            varRxSubMapB5[i] = 0;
            varRxSubMapB6[i] = 0;
            varRxSubMapB7[i] = 0;
            varRxSubMapB8[i] = 0;
            // los SubMap de los Tx
            varTxSubMapB1[i] = 0;
            varTxSubMapB2[i] = 0;
            varTxSubMapB3[i] = 0;
            varTxSubMapB4[i] = 0;
        }
    }

    /**
     *  Procedimiento que carga las Variables HMI que sirve para configurar la transmision del audio por CobraNet
     */
    private void InicializaVariablesHmiComunicaciones() {
        logger.debug("START : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        int i = 0;
        String comando = null;
        zes.AgregaComandoPrio("m@");
        // Address rxBundle 1
        zes.AgregaComandoPrio("f40100@");
        // Address rxBundle 2
        zes.AgregaComandoPrio("f41100@");
        // Address rxBundle 3
        zes.AgregaComandoPrio("f42100@");
        // Address rxBundle 4
        zes.AgregaComandoPrio("f43100@");
        //Address rxBundle 5
        zes.AgregaComandoPrio("f44100@");
        //Address rxBundle 6
        zes.AgregaComandoPrio("f45100@");
        //Address rxBundle 7
        zes.AgregaComandoPrio("f46100@");
        //Address rxBundle 8
        zes.AgregaComandoPrio("f47100@");
        // Address txBundle 1
        zes.AgregaComandoPrio("f50100@");
        // Address txBundle 2
        zes.AgregaComandoPrio("f51100@");
        // Address txBundle 3
        zes.AgregaComandoPrio("f52100@");
        // Address txBundle 4
        zes.AgregaComandoPrio("f53100@");
        // Address rxSubMap 1 Bundle 1
        zes.AgregaComandoPrio("f40200@");
        // Address rxSubMap 2 Bundle 1
        zes.AgregaComandoPrio("f40201@");
        // Address rxSubMap 3 Bundle 1
        zes.AgregaComandoPrio("f40202@");
        // Address rxSubMap 4 Bundle 1
        zes.AgregaComandoPrio("f40203@");
        // Address rxSubMap 5 Bundle 1
        zes.AgregaComandoPrio("f40204@");
        // Address rxSubMap 6 Bundle 1
        zes.AgregaComandoPrio("f40205@");
        // Address rxSubMap 7 Bundle 1
        zes.AgregaComandoPrio("f40206@");
        // Address rxSubMap 8 Bundle 1
        zes.AgregaComandoPrio("f40207@");
        // Address rxSubMap 1 Bundle 2
        zes.AgregaComandoPrio("f41200@");
        // Address rxSubMap 2 Bundle 2
        zes.AgregaComandoPrio("f41201@");
        // Address rxSubMap 3 Bundle 2
        zes.AgregaComandoPrio("f41202@");
        // Address rxSubMap 4 Bundle 2
        zes.AgregaComandoPrio("f41203@");
        // Address rxSubMap 5 Bundle 2
        zes.AgregaComandoPrio("f41204@");
        // Address rxSubMap 6 Bundle 2
        zes.AgregaComandoPrio("f41205@");
        // Address rxSubMap 7 Bundle 2
        zes.AgregaComandoPrio("f41206@");
        // Address rxSubMap 8 Bundle 2
        zes.AgregaComandoPrio("f41207@");
        // Address rxSubMap 1 Bundle 3
        zes.AgregaComandoPrio("f42200@");
        // Address rxSubMap 2 Bundle 3
        zes.AgregaComandoPrio("f42201@");
        // Address rxSubMap 3 Bundle 3
        zes.AgregaComandoPrio("f42202@");
        // Address rxSubMap 4 Bundle 3
        zes.AgregaComandoPrio("f42203@");
        // Address rxSubMap 5 Bundle 3
        zes.AgregaComandoPrio("f42204@");
        // Address rxSubMap 6 Bundle 3
        zes.AgregaComandoPrio("f42205@");
        // Address rxSubMap 7 Bundle 3
        zes.AgregaComandoPrio("f42206@");
        // Address rxSubMap 8 Bundle 3
        zes.AgregaComandoPrio("f42207@");
        // Address rxSubMap 1 Bundle 4
        zes.AgregaComandoPrio("f43200@");
        // Address rxSubMap 2 Bundle 4
        zes.AgregaComandoPrio("f43201@");
        // Address rxSubMap 3 Bundle 4
        zes.AgregaComandoPrio("f43202@");
        // Address rxSubMap 4 Bundle 4
        zes.AgregaComandoPrio("f43203@");
        // Address rxSubMap 5 Bundle 4
        zes.AgregaComandoPrio("f43204@");
        // Address rxSubMap 6 Bundle 4
        zes.AgregaComandoPrio("f43205@");
        // Address rxSubMap 7 Bundle 4
        zes.AgregaComandoPrio("f43206@");
        // Address rxSubMap 8 Bundle 4
        zes.AgregaComandoPrio("f43207@");

        // Address rxSubMap 1 Bundle 5
        zes.AgregaComandoPrio("f44200@");
        // Address rxSubMap 2 Bundle 5
        zes.AgregaComandoPrio("f44201@");
        // Address rxSubMap 3 Bundle 5
        zes.AgregaComandoPrio("f44202@");
        // Address rxSubMap 4 Bundle 5
        zes.AgregaComandoPrio("f44203@");
        // Address rxSubMap 5 Bundle 5
        zes.AgregaComandoPrio("f44204@");
        // Address rxSubMap 6 Bundle 5
        zes.AgregaComandoPrio("f44205@");
        // Address rxSubMap 7 Bundle 5
        zes.AgregaComandoPrio("f44206@");
        // Address rxSubMap 8 Bundle 5
        zes.AgregaComandoPrio("f44207@");

        // Address rxSubMap 1 Bundle 6
        zes.AgregaComandoPrio("f45200@");
        // Address rxSubMap 2 Bundle 6
        zes.AgregaComandoPrio("f45201@");
        // Address rxSubMap 3 Bundle 6
        zes.AgregaComandoPrio("f45202@");
        // Address rxSubMap 4 Bundle 6
        zes.AgregaComandoPrio("f45203@");
        // Address rxSubMap 5 Bundle 6
        zes.AgregaComandoPrio("f45204@");
        // Address rxSubMap 6 Bundle 6
        zes.AgregaComandoPrio("f45205@");
        // Address rxSubMap 7 Bundle 6
        zes.AgregaComandoPrio("f45206@");
        // Address rxSubMap 8 Bundle 6
        zes.AgregaComandoPrio("f45207@");

        // Address rxSubMap 1 Bundle 7
        zes.AgregaComandoPrio("f46200@");
        // Address rxSubMap 2 Bundle 7
        zes.AgregaComandoPrio("f46201@");
        // Address rxSubMap 3 Bundle 7
        zes.AgregaComandoPrio("f46202@");
        // Address rxSubMap 4 Bundle 7
        zes.AgregaComandoPrio("f46203@");
        // Address rxSubMap 5 Bundle 7
        zes.AgregaComandoPrio("f46204@");
        // Address rxSubMap 6 Bundle 7
        zes.AgregaComandoPrio("f46205@");
        // Address rxSubMap 7 Bundle 7
        zes.AgregaComandoPrio("f46206@");
        // Address rxSubMap 8 Bundle 7
        zes.AgregaComandoPrio("f46207@");

        // Address rxSubMap 1 Bundle 8
        zes.AgregaComandoPrio("f47200@");
        // Address rxSubMap 2 Bundle 8
        zes.AgregaComandoPrio("f47201@");
        // Address rxSubMap 3 Bundle 8
        zes.AgregaComandoPrio("f47202@");
        // Address rxSubMap 4 Bundle 8
        zes.AgregaComandoPrio("f47203@");
        // Address rxSubMap 5 Bundle 8
        zes.AgregaComandoPrio("f47204@");
        // Address rxSubMap 6 Bundle 8
        zes.AgregaComandoPrio("f47205@");
        // Address rxSubMap 7 Bundle 8
        zes.AgregaComandoPrio("f47206@");
        // Address rxSubMap 8 Bundle 8
        zes.AgregaComandoPrio("f47207@");

        // Address txSubMap 1 Bundle 1
        zes.AgregaComandoPrio("f50200@");
        // Address txSubMap 2 Bundle 1
        zes.AgregaComandoPrio("f50201@");
        // Address txSubMap 3 Bundle 1
        zes.AgregaComandoPrio("f50202@");
        // Address txSubMap 4 Bundle 1
        zes.AgregaComandoPrio("f50203@");
        // Address txSubMap 5 Bundle 1
        zes.AgregaComandoPrio("f50204@");
        // Address txSubMap 6 Bundle 1
        zes.AgregaComandoPrio("f50205@");
        // Address txSubMap 7 Bundle 1
        zes.AgregaComandoPrio("f50206@");
        // Address txSubMap 8 Bundle 1
        zes.AgregaComandoPrio("f50207@");

        //Address txSubMap 1 Bundle 2
        zes.AgregaComandoPrio("f51200@");
        //Address txSubMap 2 Bundle 2
        zes.AgregaComandoPrio("f51201@");
        //Address txSubMap 3 Bundle 2
        zes.AgregaComandoPrio("f51202@");
        //Address txSubMap 4 Bundle 2
        zes.AgregaComandoPrio("f51203@");
        //Address txSubMap 5 Bundle 2
        zes.AgregaComandoPrio("f51204@");
        //Address txSubMap 6 Bundle 2
        zes.AgregaComandoPrio("f51205@");
        //Address txSubMap 7 Bundle 2
        zes.AgregaComandoPrio("f51206@");
        //Address txSubMap 8 Bundle 2
        zes.AgregaComandoPrio("f51207@");

        // Address txSubMap 1 Bundle 3
        zes.AgregaComandoPrio("f52200@");
        // Address txSubMap 2 Bundle 3
        zes.AgregaComandoPrio("f52201@");
        // Address txSubMap 3 Bundle 3
        zes.AgregaComandoPrio("f52202@");
        // Address txSubMap 4 Bundle 3
        zes.AgregaComandoPrio("f52203@");
        // Address txSubMap 5 Bundle 3
        zes.AgregaComandoPrio("f52204@");
        // Address txSubMap 6 Bundle 3
        zes.AgregaComandoPrio("f52205@");
        // Address txSubMap 7 Bundle 3
        zes.AgregaComandoPrio("f52206@");
        // Address txSubMap 8 Bundle 3
        zes.AgregaComandoPrio("f52207@");

        // Address txSubMap 1 Bundle 4
        zes.AgregaComandoPrio("f53200@");
        // Address txSubMap 2 Bundle 4
        zes.AgregaComandoPrio("f53201@");
        // Address txSubMap 3 Bundle 4
        zes.AgregaComandoPrio("f53202@");
        // Address txSubMap 4 Bundle 4
        zes.AgregaComandoPrio("f53203@");
        // Address txSubMap 5 Bundle 4
        zes.AgregaComandoPrio("f53204@");
        // Address txSubMap 6 Bundle 4
        zes.AgregaComandoPrio("f53205@");
        // Address txSubMap 7 Bundle 4
        zes.AgregaComandoPrio("f53206@");
        // Address txSubMap 8 Bundle 4
        zes.AgregaComandoPrio("f53207@");

        for (i = 0; i <= 1025; i++) {
            comando = "f" + Integer.toHexString(0x76000 + i) + "@";
            zes.AgregaComandoPrio(comando);
        }

        //'Comprobamos si tiene cargada la versión 2.3.0 y asi sincronizar los comandos que tiene este version y las anteriores no.
        //If compruebaVersionSuperior2_3_0() Then
        //    zes.AgregaComandoPrio(CobraNetUtil.COMANDO_SET_MIC & CobraNetUtil.FIN_COMANDO)
        //End If

        logger.debug("STOP: " + Thread.currentThread().getStackTrace()[1].getMethodName());

    }

    /**
     *  Funcion que ejecuta un procedimiento Get 
     *  
     *  @param Procedimiento Identificador del procedimiento 
     *  @param Ent_Sal Es dato que se quiere saber su valor 
     *  @param V_Min Es el valor minimo correcto del dato que se desea consultar 
     *  @param V_Max Es el valor maximo correcto del dato que se desea consultar 
     *  @param ResultadoDato Es el resultado del dato que se desea consultar 
     *  @returnDevuelve TRUE si el dato que se quiere consultar es correcto y FALSE si no lo es.
     *   */
    private double EjecutaProcedimientoGet(int Procedimiento, int Ent_Sal, int V_Min, int V_Max) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        double ResultadoDato = 0.0;
        Parametros paramDato = new Parametros(this);
        //Asignamos el parametro para pasarlo a la funcion 
        paramDato.Parametros = Ent_Sal;
        paramDato.VParametrosS = "";
        //Llamamos al gestor de funciones para que nos devuelva el resultado de la consulta                
        ResultadoDato = GestorFunciones(Procedimiento, paramDato);
        return ResultadoDato;
    }

    /**
     *  Funcion que ejecuta un procedimiento Get especial para los procedimientos HMI
     *  
     *  @param Procedimiento Identificador del Procedimiento. 
     *  @param Address Direccion HMI que se quiere consultar. 
     *  @param ResultadoDato Valor o resultado de la consulta. 
     *  @returnDevuelve TRUE si el dato que se quiere consultar es correcto y FALSE si no lo es.
     *   */
    private double EjecutaProcedimientoGetHMI(int Procedimiento, String Address) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        double ResultadoDato;
        Parametros paramDato = new Parametros(this);

        //Se pone el Flag de dato correcto 

        //Asignamos el parametro para pasarlo a la funcion 
        paramDato.Parametros = LdaUtils.string2int(Address, 16);
        paramDato.VParametrosS = "";
        //Llamamos al gestor de funciones para que nos devuelva el resultado de la consulta
        ResultadoDato = GestorFunciones(Procedimiento, paramDato);

        return ResultadoDato;
    }

    /**
     *  Comprueba si los parametros son validos para ejecutar un procedimiento SET par los subcanales.
     *  
     *  @param Procedimiento Identificador del procedimiento. 
     *  @param Bundle Es el Bundle al que queremos cambiar el subcanal. 
     *  @param Canal Es el canal del que queremos cambiar su subcanal. 
     *  Es una sobrecarga de la funcion. */
    private double EjecutaProcedimientoSetSubCanal(int Procedimiento, int Bundle, int Canal) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        double ResultadoDato = 0.0;
        Parametros ParamDat = new Parametros(this);
        if (EstadoEquipo) {
            if ((Bundle >= CobraNetUtil.MIN_BUNDLE & Bundle <= CobraNetUtil.MAX_BUNDLE) & (Canal >= CobraNetUtil.MIN_SUB_CANAL & Canal <= CobraNetUtil.MAX_SUB_CANAL)) {
                //Se pone el Flag de dato Correcto 
                //Cargamos los parametros para pasarselos a la funcion 
                ParamDat.Parametros = Bundle;
                ParamDat.Parametros2 = Canal;
                ParamDat.VParametrosS = "";
                //Llamamos al gestor de funciones par que nos devuelve el resultado de la consulta 
                ResultadoDato = GestorFunciones(Procedimiento, ParamDat);
            }
        }
        return ResultadoDato;
    }

    /**
     *  Comprueba si los parametros son validos para ejecutar un procedimiento SET par los subcanales.
     *  
     *  @param Procedimiento Identificador del procedimiento. 
     *  @param Bundle Es el Bundle al que queremos cambiar el subcanal. 
     *  @param Canal Es el canal del que queremos cambiar su subcanal. 
     *  @param V_canal Es el nuevo valor del subcanal. 
     *  @param V_Min Rango Minimo del valor del subcanal. 
     *  @param V_Max Rango Maximo del valor del subcanal. 
     *   */
    private boolean EjecutaProcedimientoSetSubCanal(int Procedimiento, int Bundle, int Canal, int V_canal, int V_Min, int V_Max) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        boolean resul = false;
        Parametros ParamDat = new Parametros(this);
        double dummy = 0;
        if (EstadoEquipo) {
            if ((Bundle >= CobraNetUtil.MIN_BUNDLE & Bundle <= CobraNetUtil.MAX_BUNDLE) & (Canal >= CobraNetUtil.MIN_SUB_CANAL & Canal <= CobraNetUtil.MAX_SUB_CANAL)) {
                if (V_canal >= V_Min & V_canal <= V_Max) {
                    resul = true;
                    ParamDat.Parametros = Bundle;
                    ParamDat.Parametros2 = Canal;
                    ParamDat.VParametros = V_canal;
                    ParamDat.VParametrosS = "";
                    dummy = GestorFunciones(Procedimiento, ParamDat);
                } else {
                    resul = false;
                }
            } else {
                resul = false;
            }
        } else {
            resul = false;
        }
        return resul;
    }

    /**
     *  Comprueba si los parametros son validos para ejecutar un procedimiento Set.
     *  
     *  @param Procedimiento Identificador del procedimiento. 
     *  @param Valor_Dato1 Primer dato ó parametro que utiliza el procedimiento. 
     *  @param V_Min1 Rango Minimo del primer dato ó parametro. 
     *  @param V_Max1 Rango Maximo del primer dato ó Parametro. 
     *  @param Valor_Dato2 Segundo dato ó parametro que utiliza el procedimiento. 
     *  @param V_Min2 Rango Minimo del segundo dato ó parametro. 
     *  @param V_Max2 Rango Maximo del segundo dato ó parametro. 
     *   */
    private boolean EjecutaProcedimientoSet(int Procedimiento, int Valor_Dato1, int V_Min1, int V_Max1, int Valor_Dato2, int V_Min2, int V_Max2) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        Parametros Param = new Parametros(this);
        double dummy = 0;
        boolean resul = false;
        //Comprobamos que el equipo esta activo 
        if (EstadoEquipo) {
            //Comprobamos que no nos salgamos del intervalo 
            if ((Valor_Dato1 < V_Min1 & Valor_Dato1 > V_Max1) & (Valor_Dato2 < V_Min2 & Valor_Dato2 > V_Max2)) {
                resul = false;
            } else {
                //Inicializamos y cargamos los datos 
                resul = true;
                dummy = 0;
                Param.Parametros = Valor_Dato1;
                Param.VParametros = Valor_Dato2;
                Param.VParametrosS = "";
                //Llamamos al gestor de funciones para que 
                dummy = GestorFunciones(Procedimiento, Param);
            }
        } else {
            resul = false;
        }
        return resul;
    }

    /**
     *  Comprueba si los parametro son validos para ejecutar un procedimiento de Set Comando 
     *  
     *  @param Procedimiento  
     *  @param AddresIp  
     *  @return
     *   */
    private boolean EjecutaProcedimientoSetComandos(int Procedimiento, String AddresIp) {
        logger.debug("START : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        boolean resul = false;
        double dummy = 0;
        Parametros datos = new Parametros(this);
        //Comprobamos que el equipo esta conectado 
        if (EstadoEquipo) {
            resul = true;
            switch (Procedimiento) {
                case CobraNetUtil.P_ADDRESS_IP:
                case CobraNetUtil.P_SUBRED:
                case CobraNetUtil.P_PUERTA_ENLACE:
                    datos.VParametrosS = AddresIp;
                    break;
                case CobraNetUtil.P_ADDRES_MAC:
                    datos.VParametrosS = AddresIp;
                    break;
                case CobraNetUtil.P_SET_PRESET:
                    datos.VParametrosS = AddresIp;
                    break;
                case CobraNetUtil.P_SET_AMPLIFICADOR:
                    datos.VParametrosS = AddresIp;
                    break;
                case CobraNetUtil.P_SET_ATENUADOR:
                    datos.VParametrosS = AddresIp;
                    break;
                case CobraNetUtil.P_SET_CIERRE:
                    datos.VParametrosS = AddresIp;
                    break;
                case CobraNetUtil.P_SET_CONFIG_CIERRE:
                    datos.VParametrosS = AddresIp;
                    break;
                case CobraNetUtil.P_SET_RESET:
                    datos.VParametrosS = AddresIp;
                    break;
                case CobraNetUtil.P_SET_MP3:
                    datos.VParametrosS = AddresIp;
                    break;
                case CobraNetUtil.P_SET_MIC:
                    datos.VParametrosS = AddresIp;
                    break;
                case CobraNetUtil.P_SET_UART1:
                    datos.VParametrosS = AddresIp;
                    break;
                case CobraNetUtil.P_SET_ATEN:
                    datos.VParametrosS = AddresIp;
                    break;
                default:
                    datos.VParametrosS = "";
                    break;
            }
            dummy = GestorFunciones(Procedimiento, datos);
        } else {
            resul = false;
        }
        logger.debug("END : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        return resul;
    }

    /**
     *  Comprueba si los parametro son validos para ejecutar un procedimiento de Set Comando HMI
     *  
     *  @param Procedimiento  
     *  @param AddressHMI  
     *  @param Dato  
     *  @return
     *   */
    private boolean EjecutaProcedimientoSetComandosHMI(int Procedimiento, String AddressHMI, int Dato) {
        boolean resul = false;
        double dummy = 0;
        Parametros datos = new Parametros(this);
        //Comprobamos que el equipo esta conectado
        if (EstadoEquipo) {
            resul = true;
            datos.VParametrosS = AddressHMI + "|" + Dato;
            datos.ParametrosSNMP = Dato;
            datos.Parametros = LdaUtils.string2int(AddressHMI, 16);
            dummy = GestorFunciones(Procedimiento, datos);
        } else {
            resul = false;
        }
        return resul;
    }

    /**
     *  Funcion Gestiona y controla todas la funciones que se van ejecutando(va asignando las hebras y demas historias)
     *  
     *  @param dato Son los parametros de las funciones que se van a ejecutar. 
     *  @param Proc Es el identificador del proceso que se esta consultando. 
     */
    private double GestorFunciones(int Proc, Parametros dato) {
        double resultado = 0;
        double auxResul = 0;
        int direccion = 0;
        String CadenaEnviar = null;
        switch (Proc) {
            case CobraNetUtil.P_START:
                break;
            case CobraNetUtil.P_FINISH:
                break;
            case CobraNetUtil.P_DSPACTIVO:
                break;
            case CobraNetUtil.P_SETBUNDLEENTRADA:
                //Buscamos y formateamos la direccion 
                direccion = LdaUtils.string2int(CobraNetUtil.OID_rxBundle(dato.Parametros), 16);
                dato.ParametrosSNMP = dato.VParametros;
                if (compruebaDatoAEnviar(dato.ParametrosSNMP, direccion)) {
                    CadenaEnviar = EmpaquetaComandoHMI(dato.ParametrosSNMP, CobraNetUtil.OID_rxBundle(dato.Parametros));
                    //Agregamos el comando para que sea enviado
                    zes.AgregaComandoPrio(CadenaEnviar);
                }
                break;
            case CobraNetUtil.P_SETBUNDLESALIDA:
                //Buscamos y formateamos la direccion 
                direccion = LdaUtils.string2int(CobraNetUtil.OID_txBundle(dato.Parametros), 16);
                dato.ParametrosSNMP = dato.VParametros;
                if (compruebaDatoAEnviar(dato.ParametrosSNMP, direccion)) {
                    CadenaEnviar = EmpaquetaComandoHMI(dato.ParametrosSNMP, CobraNetUtil.OID_txBundle(dato.Parametros));
                    //Agregamos el comando para que sea enviado
                    zes.AgregaComandoPrio(CadenaEnviar);
                }
                break;
            case CobraNetUtil.P_GETBUNDLEENTRADA:
                //Buscamos y formateamos la direccion 
                direccion = LdaUtils.string2int(CobraNetUtil.OID_rxBundle(dato.Parametros), 16);
                //Recogemos el dato Correspondiente
                auxResul = DevuelveDatosHMI(direccion);
                //No aplicamos ninguna funcion de conversion porque a los bundle no les hace falta
                resultado = auxResul;
                break;
            case CobraNetUtil.P_GETBUNDLESALIDA:
                //Buscamos y formateamos la direccion 
                direccion = LdaUtils.string2int(CobraNetUtil.OID_txBundle(dato.Parametros), 16);
                //Recogemos el dato Correspondiente
                auxResul = DevuelveDatosHMI(direccion);
                //No aplicamos ninguna funcion de conversion porque a los bundle no les hace falta
                resultado = auxResul;
                break;
            case CobraNetUtil.P_GETCLIPCFE:
                break;
            case CobraNetUtil.P_GETGANANCIACFE:
                //Buscamos y formateamos la direccion
                direccion = LdaUtils.string2int(CobraNetUtil.OID_GananciaE(dato.Parametros), 16);
                //Recogemos el Dato correspondiente
                auxResul = DevuelveDatosHMI(direccion);
                //Aplicamos la funcion para pasar a puntos de decibelio
                resultado = CobraNetUtil.adB2(auxResul);
                break;
            case CobraNetUtil.P_SETGANANCIACFE:
                //Buscamos y formateamos la direccion    
                direccion = LdaUtils.string2int(CobraNetUtil.OID_GananciaE(dato.Parametros), 16);
                //Calculamos el parametro en su formato y lo guardamos 
                dato.ParametrosSNMP = CobraNetUtil.aPV(dato.VParametros);
                if (compruebaDatoAEnviar(dato.ParametrosSNMP, direccion)) {
                    CadenaEnviar = EmpaquetaComandoHMI(dato.ParametrosSNMP, CobraNetUtil.OID_GananciaE(dato.Parametros));
                    //Agregamos el Comando para que sea enviado
                    zes.AgregaComandoPrio(CadenaEnviar);
                }
                break;
            case CobraNetUtil.P_GETCLIPCFS:
                break;
            case CobraNetUtil.P_GETGANANCIACFS:
                //Buscamos y formateamos la direccion
                direccion = LdaUtils.string2int(CobraNetUtil.OID_GananciaS(dato.Parametros), 16);
                //Recogemos el Dato correspondiente
                auxResul = DevuelveDatosHMI(direccion);
                //Aplicamos la funcion para pasar a puntos de decibelio
                resultado = CobraNetUtil.adB2(auxResul);
                break;
            case CobraNetUtil.P_SETGANANCIACFS:
                //Buscamos y formateamos la direccion 
                direccion = LdaUtils.string2int(CobraNetUtil.OID_GananciaS(dato.Parametros), 16);
                //Calculamos el parametro en su formato y lo guardamos
                dato.ParametrosSNMP = CobraNetUtil.aPV(dato.VParametros);
                if (compruebaDatoAEnviar(dato.ParametrosSNMP, direccion)) {
                    CadenaEnviar = EmpaquetaComandoHMI(dato.ParametrosSNMP, CobraNetUtil.OID_GananciaS(dato.Parametros));
                    //Agregamos el Comando para que sea enviado
                    zes.AgregaComandoPrio(CadenaEnviar);
                }
                break;
            case CobraNetUtil.P_SETGANANCIAIFS:
                break;
            case CobraNetUtil.P_SETSALIDAFISICA:
                break;
            case CobraNetUtil.P_SETSALIDA:
                //Buscamos y formateamos la direccion 
                direccion = LdaUtils.string2int(CobraNetUtil.OID_Router(dato.Parametros), 16);
                //Guardamos el parametro para que sea enviado, est parametro no necesita ser formateado para el envio
                dato.ParametrosSNMP = dato.VParametros;
                //Comprobamos que el dato que tenemos guardado no es igual al que vamos a enviar
                if (compruebaDatoAEnviar(dato.ParametrosSNMP, direccion)) {
                    CadenaEnviar = EmpaquetaComandoHMI(dato.ParametrosSNMP, CobraNetUtil.OID_Router(dato.Parametros));
                    //Agregamos el comando para que sea enviado
                    zes.AgregaComandoPrio(CadenaEnviar);
                }
                break;
            case CobraNetUtil.P_GETSALIDA:
                //Buscamos y formateamos la direccion 
                direccion = LdaUtils.string2int(CobraNetUtil.OID_Router(dato.Parametros), 16);
                //Recogemos el dato correspondiente
                auxResul = DevuelveDatosHMI(direccion);
                resultado = auxResul;
                break;
            case CobraNetUtil.P_GETSALIDAFISICA:
                break;
            case CobraNetUtil.P_SETSALIDACOBRANET:
                break;
            case CobraNetUtil.P_GETSALIDACOBRANET:
                break;
            case CobraNetUtil.P_SETTONO:
                //Buscamos y formateamos la direccion en base decimal
                direccion = LdaUtils.string2int(CobraNetUtil.OID_Tono_Gain(dato.Parametros, 2), 16);
                //Calculamos el parametro en su formato y lo guardamos
                dato.ParametrosSNMP = CobraNetUtil.aLevelTonoPuntoFijo(dato.VParametros);
                if (compruebaDatoAEnviar(dato.ParametrosSNMP, direccion)) {
                    CadenaEnviar = EmpaquetaComandoHMI(dato.ParametrosSNMP, CobraNetUtil.OID_Tono_Gain(dato.Parametros, 2));
                    //Agregamos el Comando para que sea enviado
                    zes.AgregaComandoPrio(CadenaEnviar);
                }
                break;
            case CobraNetUtil.P_GETTONO:
                //Buscamos y formateamos la direccion en base decimal
                direccion = LdaUtils.string2int(CobraNetUtil.OID_Tono_Gain(dato.Parametros, 2), 16);
                //Recogemos el dato correspondiente
                auxResul = DevuelveDatosHMI(direccion);
                //Aplicamos la funcion para pasar a puntos de decibelio
                resultado = CobraNetUtil.aLevelTono(auxResul);

                break;
            case CobraNetUtil.P_GETTXSUBMAP:
                //Buscamos y formateamos la direccion en base decimal
                direccion = LdaUtils.string2int(CobraNetUtil.OID_txSubMap(dato.Parametros, dato.Parametros2), 16);
                //Recogemos el dato correspondiente
                auxResul = DevuelveDatosHMI(direccion);
                //No aplicamos ninguna funcion para formatear el dato, porque no hace falta 
                resultado = auxResul;
                break;
            case CobraNetUtil.P_GETRXSUBMAP:
                //Buscamos y formateamos la direccion en base decimal
                direccion = LdaUtils.string2int(CobraNetUtil.OID_rxSubMap(dato.Parametros, dato.Parametros2), 16);
                //Recogemos el dato correspondiente
                auxResul = DevuelveDatosHMI(direccion);
                //No aplicamos ninguna funcion para formatear el dato, porque no hace falta 
                resultado = auxResul;
                break;
            case CobraNetUtil.P_SETTXSUBMAP:
                //Buscamos y formateamos la direccion en base decimal
                direccion = LdaUtils.string2int(CobraNetUtil.OID_txSubMap(dato.Parametros, dato.Parametros2), 16);
                //Guardamos el parametro para que sea enviado, este parametro no necesita ser formateado para el envio
                dato.ParametrosSNMP = dato.VParametros;
                //Comprobamos que el datos que tenemos guardado no es igual al que vamos a enviar
                if (compruebaDatoAEnviar(dato.ParametrosSNMP, direccion)) {
                    CadenaEnviar = EmpaquetaComandoHMI(dato.ParametrosSNMP, CobraNetUtil.OID_txSubMap(dato.Parametros, dato.Parametros2));
                    //Agregamos el comando para que sea enviado
                    zes.AgregaComandoPrio(CadenaEnviar);
                }
                break;
            case CobraNetUtil.P_SETRXSUBMAP:
                //Buscamos y formateamos la direccion en base decimal
                direccion = LdaUtils.string2int(CobraNetUtil.OID_rxSubMap(dato.Parametros, dato.Parametros2), 16);
                //Guardamos el parametro para que sea enviado,este parametro no necesita ser formateado para el envio 
                dato.ParametrosSNMP = dato.VParametros;
                //Comprobamos que el datos que tenemos guardado no es igual al que vamos a enviar
                if (compruebaDatoAEnviar(dato.ParametrosSNMP, direccion)) {
                    CadenaEnviar = EmpaquetaComandoHMI(dato.ParametrosSNMP, CobraNetUtil.OID_rxSubMap(dato.Parametros, dato.Parametros2));
                    //Agregamos el comando para que sea enviado
                    zes.AgregaComandoPrio(CadenaEnviar);
                }
                break;
            case CobraNetUtil.P_GETPRESENCIACE:
                break;
            case CobraNetUtil.P_GETVUMETROCE:
                //Buscamos y formateamos la direccion en base decimal
                direccion = LdaUtils.string2int(CobraNetUtil.OID_VolumenE(dato.Parametros), 16);
                //Recogemos el dato correspondiente
                auxResul = DevuelveDatosHMI(direccion);
                resultado = CobraNetUtil.adB3(auxResul);

                if (resultado < -35) {
                    resultado = -35;
                }

                break;
            case CobraNetUtil.P_GETPRESENCIACS:
                break;
            case CobraNetUtil.P_GETVUMETROCS:
                //Buscamos y formateamos la direccino en base decimal
                direccion = LdaUtils.string2int(CobraNetUtil.OID_VolumenS(dato.Parametros), 16);
                //Recogemos el dato correspondiente
                auxResul = DevuelveDatosHMI(direccion);
                resultado = CobraNetUtil.adB3(auxResul);

                if (resultado < -35) {
                    resultado = -35;
                }

                break;
            case CobraNetUtil.P_ADDRES_MAC:
                //Montamos el comando 
                CadenaEnviar = EmpaquetaComando(Proc, dato.VParametrosS);
                zes.AgregaComandoPrio(CadenaEnviar);
                break;
            case CobraNetUtil.P_ADDRESS_IP:
                //Montamos el comando 
                CadenaEnviar = EmpaquetaComando(Proc, dato.VParametrosS);
                zes.AgregaComandoPrio(CadenaEnviar);
                break;
            case CobraNetUtil.P_PUERTA_ENLACE:
                //Montamos el comando 
                CadenaEnviar = EmpaquetaComando(Proc, dato.VParametrosS);
                zes.AgregaComandoPrio(CadenaEnviar);
                break;
            case CobraNetUtil.P_SUBRED:
                //Montamos el comando 
                CadenaEnviar = EmpaquetaComando(Proc, dato.VParametrosS);
                zes.AgregaComandoPrio(CadenaEnviar);
                break;
            case CobraNetUtil.P_GET_DATO_HMI:
                //Recogemos el dato Correspondiente
                resultado = DevuelveDatosHMI(dato.Parametros);
                break;
            case CobraNetUtil.P_SET_DATO_HMI:
                //Montamos el comando 
                direccion = dato.Parametros;

                if (compruebaDatoAEnviar(dato.ParametrosSNMP, direccion)) {
                    CadenaEnviar = EmpaquetaComando(Proc, dato.VParametrosS);
                    zes.AgregaComandoPrio(CadenaEnviar);
                }
                break;
            case CobraNetUtil.P_SET_PRESET:
                //Montamos el comando 
                CadenaEnviar = EmpaquetaComando(Proc, dato.VParametrosS);
                zes.AgregaComandoPrio(CadenaEnviar);
                break;
            case CobraNetUtil.P_SET_AMPLIFICADOR:
                //Montamos el comando
                CadenaEnviar = EmpaquetaComando(Proc, dato.VParametrosS);
                zes.AgregaComandoPrio(CadenaEnviar);
                break;
            case CobraNetUtil.P_SET_MP3:
                //Montamos el comando
                CadenaEnviar = EmpaquetaComando(Proc, dato.VParametrosS);
                zes.AgregaComandoPrio(CadenaEnviar);
                break;
            case CobraNetUtil.P_SET_RESET:
                //Montamos el comando
                CadenaEnviar = EmpaquetaComando(Proc, dato.VParametrosS);
                zes.AgregaComandoPrio(CadenaEnviar);
                break;
            case CobraNetUtil.P_SET_ATENUADOR:
                //Montamos el comando
                CadenaEnviar = EmpaquetaComando(Proc, dato.VParametrosS);
                zes.AgregaComandoPrio(CadenaEnviar);
                break;
            case CobraNetUtil.P_SET_CIERRE:
                //Montamos el comando 
                CadenaEnviar = EmpaquetaComando(Proc, dato.VParametrosS);
                zes.AgregaComandoPrio(CadenaEnviar);
                break;
            case CobraNetUtil.P_SET_CONFIG_CIERRE:
                //Montamos el comando 
                CadenaEnviar = EmpaquetaComando(Proc, dato.VParametrosS);
                zes.AgregaComandoPrio(CadenaEnviar);
                break;
            case CobraNetUtil.P_SET_TONO_MASTER:
                //Buscamos y formateamos la direccion en base decimal
                direccion = LdaUtils.string2int(CobraNetUtil.OID_GananciaTono(), 16);
                //Calculamos el parametro en su formato y lo guardamos
                //dato.ParametrosSNMP = 2 ^ 31 - aLevelTonoMasterPuntoFijo(dato.VParametros)


                dato.ParametrosSNMP = CobraNetUtil.aLevelTonoMasterPuntoFijo(dato.VParametros);

                if (compruebaDatoAEnviar(dato.ParametrosSNMP, direccion)) {
                    CadenaEnviar = EmpaquetaComandoHMI(dato.ParametrosSNMP, CobraNetUtil.OID_GananciaTono());
                    //Agregamos el Comando para que sea enviado
                    zes.AgregaComandoPrio(CadenaEnviar);
                }
                break;
            case CobraNetUtil.P_SET_MIC:
                //Montamos el comando 
                CadenaEnviar = EmpaquetaComando(Proc, dato.VParametrosS);
                zes.AgregaComandoPrio(CadenaEnviar);
                break;
            case CobraNetUtil.P_SET_UART1:
                //Montaomos el comando
                CadenaEnviar = EmpaquetaComando(Proc, dato.VParametrosS);
                zes.AgregaComandoPrio(CadenaEnviar);
                break;
            case CobraNetUtil.P_SET_ATEN:
                //Montamos el comando
                CadenaEnviar = EmpaquetaComando(Proc, dato.VParametrosS);
                zes.AgregaComandoPrio(CadenaEnviar);
                break;
            case CobraNetUtil.P_GET_TONO_MASTER:
                //Buscamos y formateamos la direccion en base decimal
                direccion = LdaUtils.string2int(CobraNetUtil.OID_GananciaTono(), 16);
                //Recogemos el dato correspondiente
                auxResul = Double.parseDouble(String.valueOf(DevuelveDatosHMI(direccion)));
                //Aplicamos la funcion para pasar a puntos de decibelio
                resultado = CobraNetUtil.aLevelTonoMaster(auxResul);

                break;
            case CobraNetUtil.P_SET_TONO_FREC:
                //Buscamos y formateamos la direccion en base decimal
                direccion = LdaUtils.string2int(CobraNetUtil.OID_FrecuenciaTono(), 16);
                //Calculamos el parametro en su formato y lo guardamos
                dato.ParametrosSNMP = CobraNetUtil.aFreqTonoPuntoFijo(dato.VParametros);
                if (compruebaDatoAEnviar(dato.ParametrosSNMP, direccion)) {
                    CadenaEnviar = EmpaquetaComandoHMI(dato.ParametrosSNMP, CobraNetUtil.OID_FrecuenciaTono());
                    //Agregamos el Comando para que sea enviado
                    zes.AgregaComandoPrio(CadenaEnviar);
                }

                break;
            case CobraNetUtil.P_GET_TONO_FREC:
                //Buscamos y formateamos la direccion en base decimal
                direccion = LdaUtils.string2int(CobraNetUtil.OID_FrecuenciaTono(), 16);
                //Recogemos el dato correspondiente
                auxResul = DevuelveDatosHMI(direccion);
                //Aplicamos la funcion para pasar a puntos de decibelio
                resultado = CobraNetUtil.aFreqTono(auxResul);

                break;
            default:
                resultado = 0;
                break;
        }
        return resultado;
    }

    /**
     *  Procedimiento que Procesa lo que nos ha llegado del protocolo
     *  
     *  @param Cmd Es el comando que se ha solicitado. 
     *  @param Respuesta Es la respuesta que nos ha llegado. 
     *   */
    private void procesaComandos(String Cmd, String Respuesta) throws GUIEvent {
        logger.debug("START : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        String Cadena = null;
        String cadAux = null;
        int pos = 0;
        int pos1 = 0;
        int addrHMI = 0;
        int param = 0;

        //Vamos procesando la cadena que nos ha respondido el equipo hasta que este vacia
        while (!Respuesta.isEmpty()) {
            //Buscamos un comando en la cadena que hemos recibido
            pos = Respuesta.indexOf(CobraNetUtil.FIN_COMANDO);
            //Comprobamos que tenemos un formato de comando valido
            if (pos > 1) {
                //Cogemos el comando para tratarlo
                Cadena = Respuesta.substring(0, pos);
                //quitamos el comando de la cadena que hemos recibido
                Respuesta = Respuesta.substring(pos + 1);
            } else {
                //No tenemos un formato de comando valido
                break; // TODO: might not be correct. Was : Exit While
            }
            //Comprobamos que no nos ha mandado algun comando de error
            if (!Cadena.substring(0, CobraNetUtil.COMANDO_ERR.length()).equals(CobraNetUtil.COMANDO_ERR)) {
                //Cogemos el primer caracter que es el que te dice que tipo de comando es 
                if (Cadena.substring(0, 1).equals(CobraNetUtil.COMANDO_HMI)) {
                    //Buscamos la posicion del serparador para trocear al direccion                        
                    pos = Cadena.indexOf(CobraNetUtil.SEPARADOR); //Strings.InStr(Cadena, CobraNetUtil.SEPARADOR);
                    //Troceamos la respuesta para quedarnos solo con al direccion HMI 
                    cadAux = Cadena.substring(1, pos - 2); //Strings.Mid(Cadena, 2, pos - 2);
                    //Calculamos la direcion en base decimal
                    addrHMI = LdaUtils.string2int(cadAux, 16);
                    //Buscamos el Fin del comando para para trocear el parametro 
                    pos1 = Cadena.indexOf(CobraNetUtil.FIN_COMANDO); //Strings.InStr(Cadena, CobraNetUtil.FIN_COMANDO);
                    //Troceamos la respuesta para quedarnos solo con el parametro 
                    cadAux = Cadena.substring(pos + 1, pos1 - pos - 1); //Strings.Mid(Cadena, pos + 1, pos1 - pos - 1);
                    //Calculamos el dato en base decimal
                    param = Integer.parseInt(cadAux); //Convert.ToInt32(cadAux);
                    //Guardamos los datos que se han Recibido del HMI 
                    if (!SncRo || !SncRw || (Cadena.substring(0, 1).equals(CobraNetUtil.COMANDO_HMI))) {
                        GuardaDatosHMI(addrHMI, param);
                    }
                    if (Cadena.contains("f76401")/*Strings.InStr(Cadena, "f76401", CompareMethod.Text)*/) {
                        SncRw = true;
                        SncRo = true;
                    }
                } else if (Cadena.substring(0, 1).equals(CobraNetUtil.COMANDO_IP)) {
                } else if (Cadena.substring(0, 1).equals(CobraNetUtil.COMANDO_MAC)) {
                } else if (Cadena.substring(0, 1).equals(CobraNetUtil.COMANDO_PUERTA_ENLACE)) {
                } else if (Cadena.substring(0, 1).equals(CobraNetUtil.COMANDO_SUBRED)) {
                } else if (Cadena.substring(0, 1).equals(CobraNetUtil.COMANDO_FLAG_SINCRONIZACION)) {
                    ProcesaComandoFlagSincronizacion(Cadena);
                } else if (Cadena.substring(0, 1).equals(CobraNetUtil.COMANDO_PETICION_SINCRONIZACION)) {
                    if (Cadena.substring(1, 1).equals("1")) {
                        SncRw = true;
                    } else if (Cadena.substring(1, 1).equals("2")) {
                        SncRo = true;
                    }
                } else if (Cadena.substring(0, 1).equals(CobraNetUtil.COMANDO_RESET)) {
                    PFinish();
                } else if (Cadena.substring(0, 1).equals(CobraNetUtil.COMANDO_MONITOR)) {
                    ProcesComandoMonitor(Cadena.substring(1)/*Strings.Mid(Cadena, 2)*/);
                } else if (Cadena.substring(0, 1).equals(CobraNetUtil.COMANDO_UART1)) {
                } else if (Cadena.substring(0, 1).equals(CobraNetUtil.COMANDO_SET_MIC)) {
                    //No hacemos nada, lo lee en el comando monitor "m"
                    if (Cadena.equals(CobraNetUtil.COMANDO_SET_MIC + "1" + CobraNetUtil.FIN_COMANDO)) {
                        AutoMic = true;
                    } else {
                        AutoMic = false;
                    }
                } else if (Cadena.substring(0, 1).equals(CobraNetUtil.COMANDO_SET_ATEN)) {
                    if (Cadena.equals(CobraNetUtil.COMANDO_SET_ATEN + "1" + CobraNetUtil.FIN_COMANDO)) {
                        cnfAtenuadores = true;
                    } else {
                        cnfAtenuadores = false;
                    }
                }
            }
        }
        logger.debug("END : " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     *  Procedimiento que guarda en memoria los datos del HMI 
     *  
     *  @param Direccion Es la direccion HMI de la variable 
     *  @param Param Es el parametro que nos ha devuelto la direccion HMI. 
     *   */
    private void GuardaDatosHMI(int Direccion, double Param) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        int tipoDireccion = 0;
        int pos = 0;
        //A partir de la direccion Calculamos que tipo de variable es y su posicion(para despues guardarlo en su correspondiente sitio)
        pos = calculaDirHMI(Direccion,
                tipoDireccion);
        //Era solo una prueba para ver lo que me mandaba. Hay que quitarlo 
        //If Direccion >= 262400 And Direccion <= 274688 Then
        //    MsgBox("Ha llegado la respuesta")
        //End If
        //Segun el tipo de direccion que sea lo guardamos en un sito ó en otro
        switch (tipoDireccion) {
            case CobraNetUtil.TIPO_RO:
                varRo[pos] = Param;
                break;
            case CobraNetUtil.TIPO_RW:
                varRw[pos] = Param;
                break;
            case CobraNetUtil.TIPO_RX:
                varBundleRx[pos] = Param;
                break;
            case CobraNetUtil.TIPO_TX:
                varBundleTx[pos] = Param;
                break;
            case CobraNetUtil.TIPO_RXSUBMAPB1:
                varRxSubMapB1[pos] = Param;
                break;
            case CobraNetUtil.TIPO_RXSUBMAPB2:
                varRxSubMapB2[pos] = Param;
                break;
            case CobraNetUtil.TIPO_RXSUBMAPB3:
                varRxSubMapB3[pos] = Param;
                break;
            case CobraNetUtil.TIPO_RXSUBMAPB4:
                varRxSubMapB4[pos] = Param;
                break;
            case CobraNetUtil.TIPO_RXSUBMAPB5:
                varRxSubMapB5[pos] = Param;
                break;
            case CobraNetUtil.TIPO_RXSUBMAPB6:
                varRxSubMapB6[pos] = Param;
                break;
            case CobraNetUtil.TIPO_RXSUBMAPB7:
                varRxSubMapB7[pos] = Param;
                break;
            case CobraNetUtil.TIPO_RXSUBMAPB8:
                varRxSubMapB8[pos] = Param;
                break;
            case CobraNetUtil.TIPO_TXSUBMAPB1:
                varTxSubMapB1[pos] = Param;
                break;
            case CobraNetUtil.TIPO_TXSUBMAPB2:
                varTxSubMapB2[pos] = Param;
                break;
            case CobraNetUtil.TIPO_TXSUBMAPB3:
                varTxSubMapB3[pos] = Param;
                break;
            case CobraNetUtil.TIPO_TXSUBMAPB4:
                varTxSubMapB4[pos] = Param;
                break;
        }
    }

    /**
     *  Funcion que devuelve los datos guardados del HMI 
     *  
     *  @param TipoDireccion Es el tipo de direccion HMI que se quieres consultar ó saber su valor 
     *  @param Pos Es la posicion donde se guarda el valor 
     *  @return
     *   */
    private double DevuelveDatosHMI(int TipoDireccion, int Pos) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        double functionReturnValue = 0;
        switch (TipoDireccion) {
            case CobraNetUtil.TIPO_RO:
                functionReturnValue = varRo[Pos];
                break;
            case CobraNetUtil.TIPO_RW:
                functionReturnValue = varRw[Pos];
                break;
            case CobraNetUtil.TIPO_RX:
                functionReturnValue = varBundleRx[Pos];
                break;
            case CobraNetUtil.TIPO_TX:
                functionReturnValue = varBundleTx[Pos];
                break;
            case CobraNetUtil.TIPO_RXSUBMAPB1:
                functionReturnValue = varRxSubMapB1[Pos];
                break;
            case CobraNetUtil.TIPO_RXSUBMAPB2:
                functionReturnValue = varRxSubMapB2[Pos];
                break;
            case CobraNetUtil.TIPO_RXSUBMAPB3:
                functionReturnValue = varRxSubMapB3[Pos];
                break;
            case CobraNetUtil.TIPO_RXSUBMAPB4:
                functionReturnValue = varRxSubMapB4[Pos];
                break;
            case CobraNetUtil.TIPO_RXSUBMAPB5:
                functionReturnValue = varRxSubMapB5[Pos];
                break;
            case CobraNetUtil.TIPO_RXSUBMAPB6:
                functionReturnValue = varRxSubMapB6[Pos];
                break;
            case CobraNetUtil.TIPO_RXSUBMAPB7:
                functionReturnValue = varRxSubMapB7[Pos];
                break;
            case CobraNetUtil.TIPO_RXSUBMAPB8:
                functionReturnValue = varRxSubMapB8[Pos];
                break;
            case CobraNetUtil.TIPO_TXSUBMAPB1:
                functionReturnValue = varTxSubMapB1[Pos];
                break;
            case CobraNetUtil.TIPO_TXSUBMAPB2:
                functionReturnValue = varTxSubMapB2[Pos];
                break;
            case CobraNetUtil.TIPO_TXSUBMAPB3:
                functionReturnValue = varTxSubMapB3[Pos];
                break;
            case CobraNetUtil.TIPO_TXSUBMAPB4:
                functionReturnValue = varTxSubMapB4[Pos];
                break;
        }
        return functionReturnValue;
    }

    /**
     *  Funcion que devuelve los datos guardados HMI 
     *  
     *  @param direccion Es la direccion HMI del valor que vamos a devolver 
     *  @return
     *  Es una sobrecarga */
    private double DevuelveDatosHMI(int direccion) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        int Tipo = 0;
        int Pos = 0;
        //Calculamos la direcion y el tipo de variable que vamos a leer
        Pos = calculaDirHMI(direccion, Tipo);
        return DevuelveDatosHMI(Tipo, Pos);
    }

    /**
     *  Funcion que devuelve el indice para recoger el dato de una direccion HMI dada
     *  
     *  @param addrHMI Es la direccion HMI en formato decimal 
     *  @returnDevuelve el indice para leer el dato desde los array que guardan los datos HMI
     *   */
    private int calculaDirHMI(int addrHMI) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        int resul = 0;
        //Si entra dentro de este intervalo es porque la direccion HMI es de Read-Only
        if (addrHMI >= (CobraNetUtil.BASE_RO + CobraNetUtil.OFFSET_RO) & addrHMI <= (CobraNetUtil.BASE_RO + CobraNetUtil.MAX_RO)) {
            resul = addrHMI - (CobraNetUtil.BASE_RO + CobraNetUtil.OFFSET_RO);
            //Si entra dentro de este intervalo es porque la direccion HMI es de Read-Write
        } else if (addrHMI >= (CobraNetUtil.BASE_RW + CobraNetUtil.OFFSET_RW) & addrHMI <= (CobraNetUtil.BASE_RW + CobraNetUtil.MAX_RW)) {
            resul = addrHMI - (CobraNetUtil.BASE_RW + CobraNetUtil.OFFSET_RW);
        }
        return resul;
    }

    /**
     *  Funcion que devuelve el indice para recoger el dato de una direccion HMI dada
     *  
     *  @param addrHMI Es la direccion HMI en formato decimal 
     *  @param tipo Es el tipo de direccion si es Read-Only ó Read-Write. 
     *  @return
     *  Es una sobrecarga de la función. */
    private int calculaDirHMI(int addrHMI, int tipo) { //TODO ¿?¿?¿?¿?¿
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        int resul = 0;
        //Si entra dentro de este intervalo es porque la direccion HMI es de Read-Only
        if (addrHMI >= (CobraNetUtil.BASE_RO + CobraNetUtil.OFFSET_RO) & addrHMI <= (CobraNetUtil.BASE_RO + CobraNetUtil.MAX_RO)) {
            resul = addrHMI - (CobraNetUtil.BASE_RO + CobraNetUtil.OFFSET_RO);
            tipo = CobraNetUtil.TIPO_RO;
            //Si entra dentro de este intervalo es porque la direccion HMI es de Read-Write
        } else if (addrHMI >= (CobraNetUtil.BASE_RW + CobraNetUtil.OFFSET_RW) & addrHMI <= (CobraNetUtil.BASE_RW + CobraNetUtil.MAX_RW)) {
            resul = addrHMI - (CobraNetUtil.BASE_RW + CobraNetUtil.OFFSET_RW);
            tipo = CobraNetUtil.TIPO_RW;
            //Si entra dentro de este intevalo es porque la direccion HMi es es un bundle Rx, el 1000 es para calcular la ultima direccion 
        } else if (addrHMI == CobraNetUtil.BUNDLERX1_ADDR | addrHMI == CobraNetUtil.BUNDLERX2_ADDR | addrHMI == CobraNetUtil.BUNDLERX3_ADDR | addrHMI == CobraNetUtil.BUNDLERX4_ADDR | addrHMI == CobraNetUtil.BUNDLERX5_ADDR | addrHMI == CobraNetUtil.BUNDLERX6_ADDR | addrHMI == CobraNetUtil.BUNDLERX7_ADDR | addrHMI == CobraNetUtil.BUNDLERX8_ADDR) {
            resul = (addrHMI - CobraNetUtil.BASE_BUNDLERX) / 4096;
            //Se divide por 4096,porque al restarlo se queda un numero multiplo de 4096 y al dividirlo dejo el numero comprendido entre 0 y X (en nuestro caso es 3)
            tipo = CobraNetUtil.TIPO_RX;
            //Si entra dentro de este intervalo es porque la direccion HMI es un SubMapRx del Bundle 1
        } else if (addrHMI >= CobraNetUtil.BASE_RXSUBMAPB1 & addrHMI <= (CobraNetUtil.BASE_RXSUBMAPB1 + CobraNetUtil.TMN_CANALES_BUNDLE)) {
            resul = addrHMI - CobraNetUtil.BASE_RXSUBMAPB1;
            tipo = CobraNetUtil.TIPO_RXSUBMAPB1;
            //Si entra dentro de este intervalo es porque la direccion HMI es un SubMapRx del Bundle 2
        } else if (addrHMI >= CobraNetUtil.BASE_RXSUBMAPB2 & addrHMI <= (CobraNetUtil.BASE_RXSUBMAPB2 + CobraNetUtil.TMN_CANALES_BUNDLE)) {
            resul = addrHMI - CobraNetUtil.BASE_RXSUBMAPB2;
            tipo = CobraNetUtil.TIPO_RXSUBMAPB2;
            //Si entra dentro de este intervalo es porque la direccion HMI es un SubMapRx del Bundle 3
        } else if (addrHMI >= CobraNetUtil.BASE_RXSUBMAPB3 & addrHMI <= (CobraNetUtil.BASE_RXSUBMAPB3 + CobraNetUtil.TMN_CANALES_BUNDLE)) {
            resul = addrHMI - CobraNetUtil.BASE_RXSUBMAPB3;
            tipo = CobraNetUtil.TIPO_RXSUBMAPB3;
            //Si entra dentro de este intervalo es porque la direccion HMI es un SubMapRx del Bundle 4
        } else if (addrHMI >= CobraNetUtil.BASE_RXSUBMAPB4 & addrHMI <= (CobraNetUtil.BASE_RXSUBMAPB4 + CobraNetUtil.TMN_CANALES_BUNDLE)) {
            resul = addrHMI - CobraNetUtil.BASE_RXSUBMAPB4;
            tipo = CobraNetUtil.TIPO_RXSUBMAPB4;
            //Si entra dentro de este intervalo es porque la direccin HMI es un SubMapRx del Bundle 5
        } else if (addrHMI >= CobraNetUtil.BASE_RXSUBMAPB5 & addrHMI <= (CobraNetUtil.BASE_RXSUBMAPB5 + CobraNetUtil.TMN_CANALES_BUNDLE)) {
            resul = addrHMI - CobraNetUtil.BASE_RXSUBMAPB5;
            tipo = CobraNetUtil.TIPO_RXSUBMAPB5;
            //Si entra dentro de este intervalo es porque la direccino HMI es un SubMapRx del Bundle 6
        } else if (addrHMI >= CobraNetUtil.BASE_RXSUBMAPB6 & addrHMI <= (CobraNetUtil.BASE_RXSUBMAPB6 + CobraNetUtil.TMN_CANALES_BUNDLE)) {
            resul = addrHMI - CobraNetUtil.BASE_RXSUBMAPB6;
            tipo = CobraNetUtil.TIPO_RXSUBMAPB6;
            //Si entra dentro de este intervalo es porque la direccion HMI es un SubMapRx del Bundle 7
        } else if (addrHMI >= CobraNetUtil.BASE_RXSUBMAPB7 & addrHMI <= (CobraNetUtil.BASE_RXSUBMAPB7 + CobraNetUtil.TMN_CANALES_BUNDLE)) {
            resul = addrHMI - CobraNetUtil.BASE_RXSUBMAPB7;
            tipo = CobraNetUtil.TIPO_RXSUBMAPB7;
            //Si entra dentro de este intervalo es porque la direccion HMI es un SubMaprx del Bundle 8
        } else if (addrHMI >= CobraNetUtil.BASE_RXSUBMAPB8 & addrHMI <= (CobraNetUtil.BASE_RXSUBMAPB8 + CobraNetUtil.TMN_CANALES_BUNDLE)) {
            resul = addrHMI - CobraNetUtil.BASE_RXSUBMAPB8;
            tipo = CobraNetUtil.TIPO_RXSUBMAPB8;
            //Si entra dentro de este intevalo es porque la direccion HMi es es un bundle Tx, el 1000 es para calcular la ultima direccion 
        } else if (addrHMI == CobraNetUtil.BUNDLETX1_ADDR | addrHMI == CobraNetUtil.BUNDLETX2_ADDR | addrHMI == CobraNetUtil.BUNDLETX3_ADDR | addrHMI == CobraNetUtil.BUNDLETX4_ADDR) {
            tipo = CobraNetUtil.TIPO_TX;
            resul = (addrHMI - CobraNetUtil.BASE_BUNDLETX) / 4096;
            //Se divide por 4096,porque al restarlo se queda un numero multiplo de 4096 y al dividirlo dejo el numero comprendido entre 0 y X (en nuestro caso es 3)
            //Si entra dentro de este intervalo es porque la direccion HMI es un SubMapTx del Bundle 1
        } else if (addrHMI >= CobraNetUtil.BASE_TXSUBMAPB1 & addrHMI <= (CobraNetUtil.BASE_TXSUBMAPB1 + CobraNetUtil.TMN_CANALES_BUNDLE)) {
            resul = addrHMI - CobraNetUtil.BASE_TXSUBMAPB1;
            tipo = CobraNetUtil.TIPO_TXSUBMAPB1;
            //Si entra dentro de este intervalo es porque la direccion HMI es un SubMapTx del Bundle 2
        } else if (addrHMI >= CobraNetUtil.BASE_TXSUBMAPB2 & addrHMI <= (CobraNetUtil.BASE_TXSUBMAPB2 + CobraNetUtil.TMN_CANALES_BUNDLE)) {
            resul = addrHMI - CobraNetUtil.BASE_TXSUBMAPB2;
            tipo = CobraNetUtil.TIPO_TXSUBMAPB2;
            //Si entra dentro de este intervalo es porque la direccion HMI es un SubMapTx del Bundle 3
        } else if (addrHMI >= CobraNetUtil.BASE_TXSUBMAPB3 & addrHMI <= (CobraNetUtil.BASE_TXSUBMAPB3 + CobraNetUtil.TMN_CANALES_BUNDLE)) {
            resul = addrHMI - CobraNetUtil.BASE_TXSUBMAPB3;
            tipo = CobraNetUtil.TIPO_TXSUBMAPB3;
            //Si entra dentro de este intervalo es porque la direccion HMI es un SubMaptx del Bundle 4
        } else if (addrHMI >= CobraNetUtil.BASE_TXSUBMAPB4 & addrHMI <= (CobraNetUtil.BASE_TXSUBMAPB4 + CobraNetUtil.TMN_CANALES_BUNDLE)) {
            resul = addrHMI - CobraNetUtil.BASE_TXSUBMAPB4;
            tipo = CobraNetUtil.TIPO_TXSUBMAPB4;
        }
        return resul;
    }

    /**
     *  Funcion que comprueba que el nuevo dato que se va asignar es distinto al que ya hay
     *  
     *  @param Num  
     *  @returnDevuelve TRUE si el dato es distinto y FALSE si no lo es
     *   */
    private boolean compruebaDatoAEnviar(double Num, int Addr) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        boolean functionReturnValue = false;
        //Comprobamos si el dato que tenemos guardado en memoria es distinto al nuevo 
        if (Num != DevuelveDatosHMI(Addr)) {
            GuardaDatosHMI(Addr, Num);
            functionReturnValue = true;
        } else {
            functionReturnValue = false;
        }
        return functionReturnValue;
    }

    /**
     *  Montamos el comando para que se pueda mandar por ethernet
     *  
     *  @param Parametro Es el parametro ó el nuevo valor que se va asignar 
     *  @param Addr Es la direccion a donde va el nuevo parametro 
     *  @return
     *   */
    private String EmpaquetaComandoHMI(double Parametro, String Addr) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        String Cmd = null;
        Cmd = CobraNetUtil.COMANDO_HMI.toUpperCase() + Addr + CobraNetUtil.SEPARADOR + Parametro + CobraNetUtil.FIN_COMANDO;
        //If Parametro < 0 Then
        //Dim aux As UInteger
        //aux = CUInt(CLng(Parametro) + 2 ^ 32)
        //'aux = "134217727"
        //'MsgBox("negative: " & CStr(aux))
        //Cmd = CobraNetUtil.COMANDO_HMI.ToUpper & Addr & CobraNetUtil.SEPARADOR & CStr(aux) & CobraNetUtil.FIN_COMANDO
        //Else
        //'MsgBox("positive: " & CStr(Parametro))
        //Cmd = CobraNetUtil.COMANDO_HMI.ToUpper & Addr & CobraNetUtil.SEPARADOR & CStr(Parametro) & CobraNetUtil.FIN_COMANDO
        //End If
        return Cmd;
    }

    /**
     *  Funcion que Montamos el comando para que se pueda mandar por ethernet
     *  
     *  @param Comando Es el identificador del comando 
     *  @param Dato Dato que vamos asignar 
     *  @return
     *   */
    private String EmpaquetaComando(int Comando, String Dato) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        String Cmd = null;
        //aqui Montamos la cabecera ó identificador del comando 
        switch (Comando) {
            case CobraNetUtil.P_ADDRES_MAC:
                Cmd = CobraNetUtil.COMANDO_MAC.toUpperCase();
                break;
            case CobraNetUtil.P_ADDRESS_IP:
                Cmd = CobraNetUtil.COMANDO_IP.toUpperCase();
                break;
            case CobraNetUtil.P_SUBRED:
                Cmd = CobraNetUtil.COMANDO_SUBRED.toUpperCase();
                break;
            case CobraNetUtil.P_PUERTA_ENLACE:
                Cmd = CobraNetUtil.COMANDO_PUERTA_ENLACE.toUpperCase();
                break;
            case CobraNetUtil.P_SET_DATO_HMI:
                Cmd = CobraNetUtil.COMANDO_HMI.toUpperCase();
                break;
            case CobraNetUtil.P_SET_PRESET:
                Cmd = CobraNetUtil.COMANDO_PRESET.toUpperCase();
                break;
            case CobraNetUtil.P_SET_AMPLIFICADOR:
                Cmd = CobraNetUtil.COMANDO_AMP.toUpperCase();
                break;
            case CobraNetUtil.P_SET_MP3:
                Cmd = CobraNetUtil.COMANDO_MP3.toUpperCase();
                break;
            case CobraNetUtil.P_SET_ATENUADOR:
                Cmd = CobraNetUtil.COMANDO_ATENUADOR.toUpperCase();
                break;
            case CobraNetUtil.P_SET_CIERRE:
                Cmd = CobraNetUtil.COMANDO_CIERRE.toUpperCase();
                break;
            case CobraNetUtil.P_SET_RESET:
                Cmd = CobraNetUtil.COMANDO_RESET.toUpperCase();
                break;
            case CobraNetUtil.P_SET_CONFIG_CIERRE:
                Cmd = CobraNetUtil.COMANDO_CONFIG_CIERRE.toUpperCase();
                break;
            case CobraNetUtil.P_SET_MIC:
                Cmd = CobraNetUtil.COMANDO_SET_MIC.toUpperCase();
                break;
            case CobraNetUtil.P_SET_UART1:
                Cmd = CobraNetUtil.COMANDO_UART1.toUpperCase();
                break;
            case CobraNetUtil.P_SET_ATEN:
                Cmd = CobraNetUtil.COMANDO_SET_ATEN.toUpperCase();
                break;
            default:
                Cmd = "";
                break;
        }
        //Montamos el comando 
        Cmd = Cmd + Dato + CobraNetUtil.FIN_COMANDO;
        return Cmd;
    }

    /**
     *  Procedimiento que se le pasa el comando de Flag de sincronizacion
     *  
     *  Recepciona y mira si le hace falta sincronizarce con el equipo y en caso afirmativo empieza el procedimiento. */
//    boolean static_ProcesaComandoFlagSincronizacion_EnProceso;
    private void ProcesaComandoFlagSincronizacion(String Comand) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        boolean EnProceso = false;
        //Le quitamos la cabecera y fin del comando 
        Comand = Comand.substring(2, Comand.length() - 2); //Strings.Mid(Comand, 2, Strings.Len(Comand) - 2);
        //Comprobamos el valor de los flag 
        if (Comand.equals("00")) {
            // No hay ninguna variable sincronizada
            // Empezamos solicitando las variables Read-Write
            zes.AgregaComandoPrio("H1@");
        } else if (Comand.equals("01")) {
            // Decimos que esta sincronizado las variables Read-Write
            SncRw = true;
            // Se ha terminado de sincronizar las Variables Read-Write
            // Solicitamos ahora las Variables Read-Only
            zes.AgregaComandoPrio("H2@");
        } else if (Comand.equals("10")) {
            // Teoricamente este caso no se puede dar pero por si acaso  lo contemplamos tambien
            // Solicitamos las variables Read-Write
            zes.AgregaComandoPrio("H1@");
        } else if (Comand.equals("11")) {
            // Comprobamos si se ha sincronizado las variables Read-Write 
            if (!SncRw) {
                // Agregamos el comando de peticion de sincronizacion de las variables Read-Write
                zes.AgregaComandoPrio("H1@");
                //Quitamos el flag de estamos EnProceso 
//                    static_ProcesaComandoFlagSincronizacion_EnProceso = false;
            } else if (!SncRo) {
                // Agregamos el comando de peticion de sincronizacion de las variables Read-Only
                if (!EnProceso) {
                    zes.AgregaComandoPrio("H2@");
                }
            } else if (!SncRo & SncRw) {
                // Quiere decir que se acaba de sincronizar la variable Read-Only 
                // Y por lo tanto se ha sincronizado las variables Read-Only y las Read-Write
                SncRo = true;
            }
        } else if (Comand.equals("21")) {
            //Quiere decir esta en proceso de sincronización de las variables Read-Only
            //Decimos que estamos en proceso de sincronización 
            EnProceso = true;
//                break;
        }
    }

    /**
     *  Funcion que devuelve el tipo de error que ha generado dependiendo del parametro pasado
     *  
     *  @param valor  
     *  @return
     *   */
    private int DiTipoDeError(boolean valor) {
        logger.debug("START : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        int resul = 0;
        if (EstadoEquipo) {
            if (SncRo & SncRw) {
                if (valor) {
                    resul = CobraNetUtil.OK;
                } else {
                    resul = CobraNetUtil.ER_PARAMETROS;
                }
            } else {
                resul = CobraNetUtil.EQUIPO_SINCRONIZANDOSE;
            }
        } else {
            resul = CobraNetUtil.ER_EQUIPO_DESCONECTADO;
        }
        logger.debug("END : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        return resul;
    }

    /**
     *  Procesa los datos del comando Monitor
     *  
     *  @param Cadena  
     *   */
    private void ProcesComandoMonitor(String Cadena) throws CierreEntradaActivo {
        logger.debug("START : " + Thread.currentThread().getStackTrace()[1].getMethodName());

        boolean ActivoAux;
        boolean bCierreEntradaActivo = false; //CierreEntradaActivo(i, Activo[i]);
        Map<Integer, Boolean> mapa = new HashMap<Integer, Boolean>();

        String[] args = Cadena.split(",");

        System.err.println("Monitor:: " + Cadena);
        System.err.println("Num Ite:: " + args.length);

        //Troceamos o cogemos la Temperatura 1
        Temperatura1 = Integer.parseInt(args[0]);
        System.err.println("Temperatura1:: " + Temperatura1);
        logger.debug("Temperatura1:: " + Temperatura1);
        //Troceamos o cogemos la Ventilacion 1
        Ventilacion1 = args[1].equals("0") ? false : true;
        System.err.println("Ventilacion2:: " + Ventilacion2);
        logger.debug("Ventilacion2:: " + Ventilacion2);
        //Troceamos o cogemos la Temperatura 2
        Temperatura2 = Integer.parseInt(args[2]);
        System.err.println("Temperatura2:: " + Temperatura2);
        logger.debug("Temperatura2:: " + Temperatura2);
        //Troceamos o cogemos la Ventilacion 2
        Ventilacion2 = args[3].equals("0") ? false : true;
        System.err.println("Ventilacion2:: " + Ventilacion2);
        logger.debug("Ventilacion2:: " + Ventilacion2);
        //Troceamos o cogemos si existe el modulo de expansión   
        ModExpansion = args[4].equals("0") ? false : true;
        System.err.println("ModExpansion:: " + ModExpansion);
        logger.debug("ModExpansion:: " + ModExpansion);
        //Troceamos o cogemos si existe el mp3
        MP3 = args[5].equals("0") ? false : true;
        System.err.println("MP3:: " + MP3);
        logger.debug("MP3:: " + MP3);
        //Troceamos o cogemos los valores de los cierres.
        String cierres = args[6]; // 16x4 carácteres
        String AuxCad = cierres;
        System.err.println("cierres:: " + cierres);
        logger.debug("cierres:: " + cierres);
        for (int i = CobraNetUtil.CIERRE1 - 1; i <= CobraNetUtil.CIERRE16 - 1; i++) {
            ActivoAux = Activo[i];
//            System.err.println(AuxCad.substring(0, 4));
            Salida[i] = LdaUtils.toBoolean(AuxCad.substring(0, 1));
            Alto[i] = LdaUtils.toBoolean(AuxCad.substring(1, 2));
            Estado[i] = LdaUtils.toBoolean(AuxCad.substring(2, 3));
            Activo[i] = LdaUtils.toBoolean(AuxCad.substring(3, 4));
            if (!Salida[i] & (Activo[i] != ActivoAux)) {
                bCierreEntradaActivo = true;
                mapa.put(i, Activo[i]);
            }
            AuxCad = AuxCad.substring(4);
        }
        //Troceamos o cogemos si está activo el amplificador
        stateAmp = args[7].equals("0") ? false : true;
        System.err.println("stateAmp:: " + stateAmp);
        logger.debug("stateAmp:: " + stateAmp);
        //Troceamos o cogemos si está activo el mp3
        stateMP3 = args[8].equals("0") ? false : true;
        System.err.println("stateMP3:: " + stateMP3);
        logger.debug("stateMP3:: " + stateMP3);
        //Troceamos o cogemos el numero de pista actual del mp3
        MP3Song = Integer.parseInt(args[9]);
        System.err.println("MP3Song:: " + MP3Song);
        logger.debug("MP3Song:: " + MP3Song);
        //Troceamos o cogemos el número de pistas de la sd
        MP3NFiles = Integer.parseInt(args[10]);
        System.err.println("MP3NFiles:: " + MP3NFiles);
        logger.debug("MP3NFiles:: " + MP3NFiles);
        //Troceamos o cogemos si está la sd insertada
        SDIN = args[11].equals("0") ? false : true;
        System.err.println("SDIN:: " + SDIN);
        logger.debug("SDIN:: " + SDIN);
        //Troceamos o cogemos si la sd está protegida
        SDPROTECT = args[12].equals("0") ? false : true;
        System.err.println("SDPROTECT:: " + SDPROTECT);
        logger.debug("SDPROTECT:: " + SDPROTECT);
        if (compruebaVersion()) {
            //Troceamos o cogemos el flag del atenuador  
            stateATT = args[13].equals("0") ? false : true;
            System.err.println("stateATT:: " + stateATT);
            logger.debug("stateATT:: " + stateATT);
            //Troceamos o cogemos el flag del RS-485 o RS-232
            Rs485 = args[14].equals("0") ? false : true;
            System.err.println("Rs485:: " + Rs485);
            logger.debug("Rs485:: " + Rs485);
        } else {
            //Troceamos o cogemos el flag del atenuador        
            stateATT = args[13].equals("0") ? false : true;
            System.err.println("stateATT:: " + stateATT);
            logger.debug("stateATT:: " + stateATT);
        }
        if (bCierreEntradaActivo) {
            throw new CierreEntradaActivo(mapa);
        }
        logger.debug("END : " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     *  Procedimiento que comprueba si la version de firmware es la correcta para que funcione el RS-485
     *  
     *  Devuelve TRUE si la version es igual o superior a la 2.1.0 y FALSE sino lo es. */
    private boolean compruebaVersion() {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        String cad = null;
        boolean resul = false;

        cad = zes.getVersionEquipo();
        v1 = Integer.parseInt(cad.charAt(20) + "");
        v2 = Integer.parseInt(cad.charAt(22) + "");
        v3 = Integer.parseInt(cad.charAt(24) + "");

        //Comprobamos que la version del equipo es igual o superior a la 2.1.0
        if (v1 > CobraNetUtil.VERSION1) {
            resul = true;
        } else if (v1 == CobraNetUtil.VERSION1) {
            if (v2 > CobraNetUtil.VERSION2) {
                resul = true;
            } else if (v2 == CobraNetUtil.VERSION2) {
                if (v3 >= CobraNetUtil.VERSION3) {
                    resul = true;
                } else {
                    resul = false;
                }
            } else {
                resul = false;
            }
        } else {
            resul = false;
        }
        return resul;
    }

    /**
     *  Funcion que devuelve si la version es igual o superior a la 2.3.0.
     *  
     *  @return
     *  TRUE La version es igual o superior a la 2.3.0
     *  FALSE La version es inferior a la 2.3.0
     *  
     *  
     *  En esta versión se ha añadido el control automatico de microfonos al zes.
     *   */
    private boolean compruebaVersionSuperior2_3_0() {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        //On Error Resume Next
        String cad = null;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        boolean Resul = false;
        cad = zes.getVersionEquipo();
        v1 = Integer.parseInt(cad.charAt(20) + "");
        v2 = Integer.parseInt(cad.charAt(22) + "");
        v3 = Integer.parseInt(cad.charAt(24) + "");

        //Comprobamos que la version del equipo es igual o superior a la 2.3.0
        if (v1 > CobraNetUtil.VERSION1_CMD_N) {
            Resul = true;
        } else if (v1 == CobraNetUtil.VERSION1_CMD_N) {
            if (v2 > CobraNetUtil.VERSION2_CMD_N) {
                Resul = true;
            } else if (v2 == CobraNetUtil.VERSION2_CMD_N) {
                if (v3 >= CobraNetUtil.VERSION3_CMD_N) {
                    Resul = true;
                } else {
                    Resul = false;
                }
            } else {
                Resul = false;
            }
        } else {
            Resul = false;
        }
        return Resul;
    }

    /**
     *  Evento del protocolo de comunicacion que dice el estado de las comunicaciones 
     *  
     *  @param Estado  
     *   */
    private void EstadoComunicacion(int Estado) {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        switch (Estado) {
            case ZESStatus.OK:
                EstadoEquipo = true;
                if (compruebaVersionSuperior2_3_0()) {
                    zes.AgregaComandoPrio(CobraNetUtil.COMANDO_SET_MIC + CobraNetUtil.FIN_COMANDO);
                    zes.AgregaComandoPrio(CobraNetUtil.COMANDO_SET_ATEN + CobraNetUtil.FIN_COMANDO);
                }
                break;
            case ZESStatus.PARAMETROS_INCORRECTOS:
                break;
            //Solo filtro no hago nada
            case ZESStatus.ER_EQUIPO:
                break;
            //Solo filtro no hago nada
            case ZESStatus.CONECTANDO:
                if (EstadoEquipo) {
                    EstadoEquipo = false;
                    InicializaVariablesHmiComunicaciones();
                }
                // Decimos que el equipo esta sin sincronizar y agregamos las variables HMI que sirve para las comunicaciones del audio por cobranet                 
                SncRo = false;
                SncRw = false;
                break;
            default:
                if (EstadoEquipo) {
                    EstadoEquipo = false;
                    InicializaVariablesHmiComunicaciones();
                }
                // Decimos que el equipo esta sin sincronizar y agregamos las variables HMI que sirve para las comunicaciones del audio por cobranet 
                SncRo = false;
                SncRw = false;
                break;
        }
    }

    /**
     *  Evento del protocolo de comunicacion que nos devuelve los datos procedente del equipo
     *  
     *  @param Estado  
     *  @param Datos  
     *  @param Comando  
     *   */
    private void RecepcionDatos(int Estado, String Datos, String Comando) throws GUIEvent {
        logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        //Si no hemos recepcionado un dato quiere decir que el equipo esta activo        
        if (Estado == ZESStatus.OK) {
            EstadoEquipo = true;
            //Procedimiento que procesa los datos que se ha recibido por medio de Ethernet        
            procesaComandos(Comando, Datos);
        }
    }

    public class ProtocoloComunicacion {

        //  "finalantes y Definicion de tipos"
        /**
         *  Es la finalante de comienzo de texto
         */
        private final int STX = 2;
        public final static char START_TX = (char) 2;
        /**
         *  Es la finalante de fin de texto
         */
        private final int ETX = 3;
        public final static char END_TX = (char) 3;
        /**
         *  Tiempo de refresco del timer para saber si el equipo es el correcto
         */
        private final int REFRESCO_TIMER_EQUIPO = 500;
        /**
         *  Es el indice por donde se van a ir insertando los parametros en la coleccion de objetos
         */
//        public int INDICE_INSERCION = 0;
        /**
         *  finalante con el valor por defecto del TimeOut. 
         *  
         *  El timeOut va en Milisegundos. */
        public static final int TIMEOUT_POR_DEFECTO = 200;
        /**
         *  finalante con el valor por defecto de desconexion del equipo
         *  
         *   */
        public static final int TIEMPODESCONEXION_POR_DEFECTO = 10000;
        /**
         *  finalante con el valor por defecto de la Ip del equipo.
         */
        public static final String IP_POR_DEFECTO = "127.0.0.1";
        /**
         *  finalante con el valor por defecto del puerto del Equipo.
         *  
         *   */
        public static final String PUERTO_POR_DEFECTO = "2000";
        /**
         *  Numero maximo de reintentos antes de desechar la comunicacion con el equipo
         *  
         *   */
        public static final int MAX_INTENTOS = 50;
        /**
         *  finalante con el valor por defecto del tiempo que va a intentar preguntar cada comando 
         *  
         *  El tiempo es de unos 100 milisegundos aproximadamente. */
        private final int TIEMPO_ENVIO = 1;
        /**
         *  finalante con el valor del numero de espera del protocolo de envio maximo
         *  
         *  Se ultiliza para el timer de envio de comandos, Si no ha enviado ningun comando en este tiempo resetea el protocolo de envios. */
        private final int NUM_ESPERA_ENVIO_MAX = 1000;
        //  "Variables y flags utilizadas en las comunicaciones"
        /**
         *  Socket UDP para la comunicacion con el equipo
         */
        private IUdp sckUDP;
        /**
         *  Flag de estado que te dice el estado de la comunicacion 
         */
        private int estadoComunicaciones;
        /**
         *  Variable donde se guardan todas las peticiones de refresco de envio por el socket UDP.
         */
        private LinkedList<String> colaEnvio = new LinkedList<String>();
        /**
         *  Variable donde se guarda las peticiones prioritarias del envio por el socket UDP.
         *  
         *   */
        private LinkedList<String> colaEnvioPrio = new LinkedList<String>();

        public List<String> getColaEnvio() {
            return colaEnvio;
        }

        public List<String> getColaEnvioPrio() {
            return colaEnvioPrio;
        }

        public void iniciaColas() {
            if (colaEnvio == null) {
                colaEnvio = new LinkedList<String>();
            }
            if (colaEnvioPrio == null) {
                colaEnvioPrio = new LinkedList<String>();
            }
        }

        public void iniciaComandoEquipoCorrecto() {
            if (comandoEquipoCorrecto == null) {
                comandoEquipoCorrecto = new ValidezEquipo();
            }
        }
        /**
         *  Flag para la ejecucion de la hebra.
         *  
         *  Si es True la hebra esta en ejecucion y si por el contrario es False la hebra no se esta ejecutando. */
        private boolean libreriaActiva;
        /**
         *  Es el comando que sirve para conectarse y validar el equipo que nos estamos conectando
         */
        private ValidezEquipo comandoEquipoCorrecto;
        /**
         *  Temporizador para saber si el equipo es correcto
         *  
         *  Solo envia el comando de conexion */
        private Timer tmrEquipo;
        /**
         *  Temporizador para saber si ha expirado el timeOut
         */
        private Timer tmrTimeOut;
        /**
         *  Temporizador para saber si el equipo se ha desconectado
         */
        private Timer tmrEquipoDesconectado;
        /**
         *  Es el comando utilizado para volver a reintentar el envio, antes de que se de por perdida la comunicacion con el equipo
         *  
         *   */
        private String comandoActual;
        private int nIntentos;
        /**
         *  Es el indice del refresco para la cola de refresco de los datos 
         *  
         *   */
//        private int Indice_Refresco;
        private boolean Enviando;
        /**
         *  Temporizador de envio de comandos
         *  
         *   */
        private Timer TmrEnvio;
        /**
         *  Variable que guarda la version del ZES80s02
         *  
         *   */
        private String versionEquipo;
        //  "Eventos de la clase"
        private DataEvent deo = new DataArrival();

        public ProtocoloComunicacion() {
            logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
            //Inicializamos las variables y los flag con los valores por defecto 
            InicializaVariablesFlag(IP_POR_DEFECTO, PUERTO_POR_DEFECTO, TIMEOUT_POR_DEFECTO);
        }

        /**
         *  finalructor de la clase.
         *  
         *  @param Ip Direccion IP del equipo al que nos queremos conectar. 
         *  @param Puerto Puerto del equipo al que nos queremos conectar. 
         *  @param timeOut TimeOut del equipo al que nos queremos conectar. 
         *  Este finalructor inicializa el objeto con los valores que le pasamos con los parametros  */
        public ProtocoloComunicacion(String Ip, String Puerto, int timeOut) {
            //Inicializamos las variables y los flag con los valores que el usuario quiere
            InicializaVariablesFlag(Ip, Puerto, timeOut);
        }

        /**
         *  Destructor de la clase.
         */
        public void dispose() throws ZESException {
            logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
            //Reseteamos todos los flag de estados y variables.
            estadoComunicaciones = ZESStatus.SIN_CONEXION;
//            Indice_Refresco = 0;
            libreriaActiva = false;
            try {
                //Eliminamos la timer de TimeOut, Equipo y Desconexion del equipo
//                tmrEquipo.Enabled = false;
//                tmrEquipo = null;
                tmrEquipo.stop();
                tmrEquipo = null;

                //tmrEquipoDesconectado.Enabled = False
                //tmrEquipoDesconectado = Nothing
//                tmrTimeOut.Enabled = false;
//                tmrTimeOut = null;
                tmrTimeOut.stop();
                tmrTimeOut = null;

                //Comprobamos de que no hayamos eliminado el recurso antes
                if ((colaEnvio != null)) {
                    //Borramos la coleccion y liberamos memoria
                    colaEnvio.clear();
                    colaEnvio = null;
                }
                //Comprobamos de que no hayamos eliminado el recurso antes
                if ((colaEnvioPrio != null)) {
                    //Borramos la coleccion y leberamos memoria
                    colaEnvioPrio.clear();
                    colaEnvioPrio = null;
                }
                //Comprobamso de que no hayamos eliminado el recurso antes
                if ((sckUDP != null)) {
                    //Cerramos el socket y liberamos memoria
                    sckUDP.close();
                    sckUDP = null;
                }

                //Eliminamos el Timer que va enviando los datos por el Socket UDP
//                TmrEnvio.Enabled = false;
//                TmrEnvio = null;
                TmrEnvio.stop();
                TmrEnvio = null;
            } catch (NullPointerException ex) {
                logger.error("ALREADY DISPOSE " + ex);
            } catch (Exception ex) {
                //Filtramos alguna posible excepcion que se pude dar 
                //MsgBox("Error:" & ex.ToString)
                System.err.println("Error: " + ex.getMessage());
                logger.error(ex);
                throw new ZESException("DRIVER ERROR");
            }
        }
        /**
         *  Propiedad que asigna ó devuelve la direccion IP del equipo que vamos a conectarnos.
         */
        public String DireccionIP;

        public String getDireccionIP() {
            return sckUDP.getRemoteHost();
        }

        public void setDireccionIP(String DireccionIP) {
            this.DireccionIP = DireccionIP;
            sckUDP.setRemoteHost(DireccionIP);
        }
        /**
         *  Propiedad que asigna ó devuelve el puerto del equipo que vamos a conectarnos.
         */
        public int Puerto;

        public int getPuerto() {
            return sckUDP.getRemotePort();
        }

        public void setPuerto(int Puerto) {
            this.Puerto = Puerto;
            sckUDP.setPortNum(Puerto);
        }

        public void refresh() {
            sckUDP.setRemoteHost(DireccionIP);
            sckUDP.setRemotePortNum(Puerto);
            sckUDP.setListener(deo);
//            sckUDP.bind();            
        }

        public void refresh(String dIP, String puerto) {
            sckUDP.setRemoteHost(DireccionIP);
            sckUDP.setRemotePortNum(Puerto);
            sckUDP.setListener(deo);
//            sckUDP.bind();            
        }
        /**
         *  Propiedad que asigna ó devuelve el timeOut del equipo al que vamos a conectarnos.
         */
        public Object TimeOut;

        public Object getTimeOut() {
            //return tmrTimeOut.Interval;
            return tmrTimeOut.getDelay();
        }

        public void setTimeOut(Object TimeOut) {
            this.TimeOut = TimeOut;
        }
        /**
         *  Propiedad que asigna ó devuelve el tiempo que tiene configurado para que de un equipo por desconectado
         */
        public int TiempoDesconexionEquipo;

        public int getTiempoDesconexionEquipo() {
            //return tmrEquipoDesconectado.Interval;
            return tmrEquipoDesconectado.getDelay();
        }

        public void setTiempoDesconexionEquipo(int TiempoDesconexionEquipo) {
            //tmrEquipoDesconectado.Interval = TiempoDesconexionEquipo;
            tmrEquipoDesconectado.setDelay(TiempoDesconexionEquipo);
        }

        //  "Procedimientos y funciones publicas"
        /**
         *  Procedimiento que ejecuta ó arranca el protocolo de comunicaciones
         *  
         *   */
        public void Conectar() {
            logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
            //Comprobamos que no hay ningun timpo de conexion 
            if (estadoComunicaciones == ZESStatus.SIN_CONEXION) {
                //Comprobamos que se ha configurado el comando de conexion del equipo 
                //Para saber si el equipo es el correcto ó no 
                if (!(comandoEquipoCorrecto.Comando == null) && !(comandoEquipoCorrecto.Respuesta == null)
                        && (!((comandoEquipoCorrecto.Comando).trim()).isEmpty() && !((comandoEquipoCorrecto.Respuesta).trim()).isEmpty())) {
                    //Activamos el protocolo de conexion
                    //tmrEquipo.Enabled = true;
                    tmrEquipo.start();
                    estadoComunicaciones = ZESStatus.CONECTANDO;
                    //Inicializamos las variables de control para la conexion del equipo
//                    Indice_Refresco = 0;
                    //Inicializamos la version del Equipo.
                    versionEquipo = "";
                } else {
                    //Lanzamos el evento que los parametros necesarios para arrancar el protocolo son incorrectos
                    EstadoComunicacion(ZESStatus.PARAMETROS_INCORRECTOS);
                }
            }
        }

        /**
         *  Procedimiento que para el protocolo de comunicaciones
         *  
         *   */
        public void Desconectar() {
            logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
            //comprobamos que hay algun tipo de conexion 
            if (estadoComunicaciones != ZESStatus.SIN_CONEXION) {
                //Quitamos la conexion
                estadoComunicaciones = ZESStatus.SIN_CONEXION;
                //Reseteamos el indice para que empieze desde el primer  
//                Indice_Refresco = 0;
                //Reseteamos la version del equipo.
                versionEquipo = "";
            }
        }

        /**
         *  Funcion que te devuelte el Flag de estado de las comunicaciones del equipo
         *  
         *   */
        public int EstadoConexionEquipo() {
            return estadoComunicaciones;
        }

        /**
         *  Procedimiento que carga el comando para saber si el equipo es el correcto ó no
         *  
         *  @param Cmd Es el comando que vamos a preguntar. 
         *  @param RespuestaCmd Es la respuesta que vamos a obtener si es correcto el equipo. 
         *  @param InicioRsp Es el inicio de lar respuesta,Por si nos interesa quedarnos con solo una parte de la respuesta. 
         *  @param TopeRsp Es el final de la respuesta, Por si nos interasa quedarnos con solo una parte de la respuesta. 
         *   */
        public void configComandoConexion(String Cmd, String RespuestaCmd, int InicioRsp, int TopeRsp) {
            logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
            //Comprobamos que los parametros son correctos 
            if (!(Cmd.trim().isEmpty()) && !(RespuestaCmd.trim().isEmpty()) && (InicioRsp < TopeRsp)) {
                comandoEquipoCorrecto.Comando = Cmd;
                comandoEquipoCorrecto.Respuesta = RespuestaCmd;
                comandoEquipoCorrecto.PrincipioRespuesta = InicioRsp;
                comandoEquipoCorrecto.FinalRespuesta = TopeRsp;
            } else {
                //Lanzamos el evento diciendo que la comunicacion no se puede iniciar xq los parametros son incorrectos
                EstadoComunicacion(ZESStatus.PARAMETROS_INCORRECTOS);
            }
        }

        /**
         *  Procedimiento que carga el comando para saber si el equipo es el correcto ó no
         *  
         *  @param Cmd Es el comando que vamos a preguntar. 
         *  @param RespuestaCmd Es la respuesta que vamos a obtener si es correcto el equipo. 
         *  Es una sobrecarga. */
        public void configComandoConexion(String cmd, String RespuestaCmd) {
            configComandoConexion(cmd, RespuestaCmd, 1, RespuestaCmd.length());
        }

        /**
         *  Procedimiento que carga el comando para saber si el equipo es el correcto ó no.
         *  
         *  @param cmd son los datos en formato estructura. 
         *  Es una sobre carga de la funcion. */
        public void configComandoConexion(ValidezEquipo cmd) {
            configComandoConexion(cmd.Comando, cmd.Respuesta, cmd.PrincipioRespuesta, cmd.FinalRespuesta);
        }

        /**
         *  Procedimiento que agrega un Comando a la cola de Prioridad
         *  
         *  @param comand Es un comando nuevo que vamos a consultar */
        public void AgregaComandoPrio(String comand) {
            logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
            int i = 0;
            int pos1 = 0;
            int pos2 = 0;
            String patron1 = null;
            String patron2 = null;
            int numComandos = 0;
            try {
                if (comand.toUpperCase().startsWith("F")) {
                    pos1 = comand.indexOf("|"); //Strings.InStr(comand, "|", CompareMethod.Text);
                    if (pos1 > 0) {
                        patron1 = comand.substring(1, pos1 - 1); //Strings.Mid(comand, 1, pos1 - 1);
                        numComandos = colaEnvioPrio.size(); //colaEnvioPrio.Count;
                        i = 0;
                        while (i <= numComandos) {
                            pos2 = colaEnvioPrio.get(i).indexOf("|"); //Strings.InStr(colaEnvioPrio[i], "|", CompareMethod.Text);
                            if (pos2 > 0) {
                                patron2 = colaEnvioPrio.get(i).substring(1, pos2 - 1); //Strings.Mid(colaEnvioPrio[i], 1, pos2 - 1);
                                if (patron1.equalsIgnoreCase(patron2)) {
                                    //colaEnvioPrio.Remove(i);
                                    colaEnvioPrio.remove(i);
                                    i--;
                                    numComandos--;
                                }
                            }
                            i++;
                        }
                    }
                } else {
                    numComandos = colaEnvioPrio.size(); //colaEnvioPrio.Count;
                    i = 0;
                    while (i <= numComandos) {
                        if (/*comand == colaEnvioPrio[i]*/colaEnvioPrio.get(i).equalsIgnoreCase(comand)) {
                            //colaEnvioPrio.Remove(i);
                            colaEnvioPrio.remove(i);
                            i--;
                            numComandos--;
                        }
                        i++;
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                colaEnvioPrio.add(comand);
            }
        }

        /**
         *  Procemiento que agrega un Comando a la cola de comandos de refresco.
         *  
         *  @param comand Es el comando que vamos a agregar. */
        public void AgregaComando(String comand) {
            logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
            //colaEnvio.add(INDICE_INSERCION, comand);
            colaEnvio.add(comand);
        }

        /**
         *  Procedimiento que agrega una coleccion a la cola de comandos de refresco.
         *  
         *  @param comand Es una coleccion de comandos. 
         *  Es una sobrecarga de la funcion */
        public void AgregaComando(Collection comand) {
            logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
            //colaEnvio = comand;
            colaEnvio.addAll(comand);
        }

        /**
         *  Funcion que devuelve la version del equipo que 
         *  
         *  @return
         *   */
        public String getVersionEquipo() {
            logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
            return versionEquipo;
        }

        //  "Procedimientos y funciones privadas"
        /**
         *  Procedimiento que inicializa las variables y los flag del protocolo
         */
        private void InicializaVariablesFlag(String ip, String puerto, int timeout) {
            logger.debug("START : " + Thread.currentThread().getStackTrace()[1].getMethodName());
            //Configuramos los flag de control
            estadoComunicaciones = ZESStatus.SIN_CONEXION;
            libreriaActiva = true;
//            colaEnvio = new LinkedList<String>(); //new Collection();
//            colaEnvioPrio = new LinkedList<String>(); //new Collection();
            comandoEquipoCorrecto = new ValidezEquipo();
//            Indice_Refresco = 0;
            nIntentos = 0;
            comandoActual = "";
            Enviando = true;
            /* TODO */
//            //Creamos e inicializamos el socket
//            sckUDP = new Udp();
//            sckUDP.setRemoteHost(ip);
//            sckUDP.setRemotePort(Integer.parseInt(puerto));
//            //sckUDP.DataArrival += socket_DataArrival;
//            sckUDP.setListener(deo);            
//            sckUDP.bind();            

            //Configuracion del timer para el timeOut
            tmrTimeOut = new Timer(timeout, new TimeOut_Elapsed());
            tmrTimeOut.stop();
//            tmrTimeOut.Interval = timeout;
//            tmrTimeOut.Elapsed += TimeOut_Elapsed;
//            tmrTimeOut.Enabled = false;


            //Configuracion del timer para saber si el equipo conectado es el correcto
            tmrEquipo = new Timer(REFRESCO_TIMER_EQUIPO, new RefrescoEquipo_Elapsed());
//            tmrEquipo.start();
            tmrEquipo.stop();
//            tmrEquipo.Elapsed += RefrescoEquipo_Elapsed;
//            tmrEquipo.Interval = REFRESCO_TIMER_EQUIPO;
//            tmrEquipo.Enabled = false;

            //Configuramos el timer que va ir preguntando cada X tiempo un comando 
            TmrEnvio = new Timer(TIEMPO_ENVIO, new TmrEnvio_Elapsed());
            TmrEnvio.stop();
//            TmrEnvio.Elapsed += TmrEnvio_Elapsed;
//            TmrEnvio.Interval = TIEMPO_ENVIO;
//            //Es el tiempo que va a ir preguntando
//            TmrEnvio.Enabled = false;

            //Inicializamos la version del Equipo
            versionEquipo = "";
            logger.debug("END : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        }

        /**
         *  Procedimiento que se ejecuta cuando ha terminado el timer del TimeOut
         *  
         *   */
        private class TimeOut_Elapsed implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
                if (nIntentos > MAX_INTENTOS) {
                    //Paramos el timer
//                tmrTimeOut.Enabled = false;
//                    tmrTimeOut.stop();
//                TmrEnvio.Enabled = false;
                    tmrTimeOut.stop();
                    nIntentos = 0;
                    comandoActual = "";
                    estadoComunicaciones = ZESStatus.CONECTANDO;
                    //Lanzamos el evento ya sea Error u Ok
                    EstadoComunicacion(estadoComunicaciones);
//                tmrEquipo.Enabled = true;
                    tmrTimeOut.start();
                } else {
                    //Incrementamos el contador de reintentos, porque se ha producido un TimeOut.
                    nIntentos += 1;
                    //Volvemos a enviar el comando 
                    EnviaPorUDP(comandoActual);
                }
            }
        }

        /**
         *  Procedimiento que se ejecuta para poder saber si el equipo que se esta intentado conectar es el correcto ó no
         */
        private class RefrescoEquipo_Elapsed implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
//            tmrEquipo.Enabled = false;
                tmrEquipo.stop();
                if (!(comandoEquipoCorrecto.Comando).isEmpty()) {
                    comandoActual = comandoEquipoCorrecto.Comando;
                    sckUDP.sendData(zes.START_TX + comandoEquipoCorrecto.Comando + zes.END_TX);
                    sckUDP.bind();
//                tmrTimeOut.Enabled = true;
                    tmrEquipo.start();
                }
//            tmrEquipo.Enabled = true;
                tmrEquipo.start();
            }
        }

        /**
         *  Procedimiento que se ejecuta para poder saber si el equipo se ha desconectado 
         *  
         *   */
        private void DesconexionEquipo_Elapsed() {
            //Lanzamos el nuevo estado de la comunicacion
            EstadoComunicacion(estadoComunicaciones);
        }

        /**
         *  Procedimiento que envia una cadena de caracteres por UDP al equipo
         *  
         *  @param cadena  
         *   */
        private void EnviaPorUDP(String cadena) {
            logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
            //Enviamos los datos por el socket y actimos timer del TimeOut
            comandoActual = cadena;
            //Enviamos la cadena junto con el STX y ETX, es decir, con las finalantes de principio y final de texto                    
            sckUDP.sendData(zes.START_TX + cadena + zes.END_TX);
            sckUDP.bind();
        }

        /**
         *  Funcion que te dice si el equipo que esta conectado es el correcto ó no.
         *  
         *  @param Cad Respuesta que vamos a comprobar si es la correcta ó no. 
         *  Devuelve True si el equipo es el correcto y False si no lo es. */
        private boolean compruebaEquipoCorrecto(String Cad) {
            return (comandoEquipoCorrecto.Respuesta.substring(comandoEquipoCorrecto.PrincipioRespuesta, comandoEquipoCorrecto.PrincipioRespuesta + comandoEquipoCorrecto.FinalRespuesta).equalsIgnoreCase(
                    Cad.substring(comandoEquipoCorrecto.PrincipioRespuesta, comandoEquipoCorrecto.PrincipioRespuesta + comandoEquipoCorrecto.FinalRespuesta)));
        }

        /**
         *  Funcion que se encarga de devolver el comando que se va a enviar
         *  
         *  @param cmd Es el comando que se va a enviar 
         *  @return si hay un comando lo devuelve, sino lo hay null
         *   */
        private String HayComandoParaEnviar() {
            logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
            String cmd;
//            boolean functionReturnValue = false;
            //Comprobamos si hay comandos que tienen mas prioridad para enviarlos antes
            if (colaEnvioPrio.size() > 0) {
                //Cogemos el primero comando de la coleccion 
//                cmd = colaEnvioPrio.get(INDICE_INSERCION);
                cmd = colaEnvioPrio.getFirst();
                //Una vez cogido el comando lo eliminamos para que la proxima vez pase al siguiente comando
                colaEnvioPrio.remove(cmd);
                //Decimos que hay un comando listo para enviar
//                functionReturnValue = true;
            } else {
                //Comprobamos que hay comando para enviar 
                if (colaEnvio.size() > 0) {
                    //Si por el contrario no hay comando con prioridad cogemos el de refresco
                    cmd = colaEnvio.getFirst(); //colaEnvio.get(Indice_Refresco);
                    colaEnvio.remove(cmd);
                    //Incrementamos el Indice para seguir con el siguiente comando 
//                    Indice_Refresco = Indice_Refresco + 1;
                    //Comprobamos que el indice no se nos sale del intervalo 
//                    if (Indice_Refresco > colaEnvio.size()) {
//                        //Se nos ha salido del Indice reseteamos el Indice al primer valor posible 
//                        Indice_Refresco = 0;
//                    }
                    //Decimos que hay un comando listo para enviar
//                    functionReturnValue = true;
                } else {
                    //Decimos que no hay ningun comando para ser enviado
//                    functionReturnValue = false;
                    cmd = null;
                }
            }
            return cmd;

        }

        /**
         *  Procedimiento que controla el envio de los comandos 
         *  
         *   */
        private class TmrEnvio_Elapsed implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
                String cadEnvio = "";
//            TmrEnvio.Enabled = false;
                TmrEnvio.stop();
                if (!Enviando) {
                    //Comprobamos que el estado de las comunicaciones 
                    if (estadoComunicaciones == ZESStatus.OK) {
                        //Miramos si hay un comando para enviar y en caso afirmativo lo enviamos
                        cadEnvio = HayComandoParaEnviar();
                        if (cadEnvio != null) {
                            Enviando = true;
                            //Enviamos el comando
                            EnviaPorUDP(cadEnvio);
                            //Activamos el TimeOut                        
//                        tmrTimeOut.Enabled = true;
                            TmrEnvio.start();
                        }
                    }
                }
//            TmrEnvio.Enabled = true;
                TmrEnvio.start();
            }
        }

        private class DataArrival implements DataEvent {

            /**
             *  Funcion que recepciona los datos recepcionados del winsock
             *  
             *  @param bytesTotal Numero todal de bytes de la respuesta 
             */
            public void dataArrival(short size) throws GUIEvent {
//            logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
//            this.socket_DataArrival(Integer.parseInt(Short.toString(size)));                              
                logger.debug("START : " + Thread.currentThread().getStackTrace()[1].getMethodName());
                String cadena = "";
                int pos = 0;
                //Recogemos los datos del socket
                cadena = sckUDP.getData();
//                System.err.println(cadena);
                //Comprobación de que cadena es la respuesta a comando actual
//                pos = cadena.indexOf(comandoActual.substring(0, comandoActual.length() - 1));
                if ((cadena.charAt(0) == comandoActual.charAt(0))
                        && (cadena.charAt(cadena.length() - 1) == comandoActual.charAt(comandoActual.length() - 1))) {
//                if (pos != 0) {
                    //Si es la respuesta, desactivamos el timeOut
//                tmrTimeOut.Enabled = false;
                    tmrTimeOut.stop();
                    nIntentos = 0;
                } else {
                    return;
                }
                //Comprobamos el estado de la comunicacion        
                if (estadoComunicaciones == ZESStatus.CONECTANDO) {
                    //Comprobamos que el equipo es el correcto
                    if (compruebaEquipoCorrecto(cadena)) {
                        //Refrescamos el flag de estado de las comunicaciones
                        Enviando = false;
                        estadoComunicaciones = ZESStatus.OK;
                        //Deshabilitamos el timer del reconocimiento del equipo
//                    tmrEquipo.Enabled = false;
                        tmrEquipo.stop();
                        //Guardamos la version del equipo.
                        versionEquipo = cadena.trim();
                    } else {
                        Enviando = true;
                        //El equipo no es correcto lanzamos un error de equipo incorrecto
                        estadoComunicaciones = ZESStatus.CONECTANDO;
                    }
                    //Lanzamos el evento ya sea Error u Ok
                    EstadoComunicacion(estadoComunicaciones);
                } else {
                    //Ante de nada comprobamos que el equipo esta ok
                    //, es decir que el equipo es el correcto y demas
                    if (estadoComunicaciones == ZESStatus.OK) {
                        //Lanzamos el Evento de Recepcion de datos para recoger los datos en el nivel superior
                        //Si la CadenaReintentos esta vacia quiere decir que hemos recepcionado un dato que no hemos consultado previamente
                        RecepcionDatos(estadoComunicaciones, cadena, comandoActual);
                    }
                }
                if (estadoComunicaciones == ZESStatus.OK) {
                    Enviando = false;
//                TmrEnvio.Enabled = true;
                    TmrEnvio.start();
                }
                logger.debug("END : " + Thread.currentThread().getStackTrace()[1].getMethodName());
            }
        }
    }
}
