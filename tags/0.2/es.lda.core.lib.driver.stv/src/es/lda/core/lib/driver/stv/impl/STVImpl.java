package es.lda.core.lib.driver.stv.impl;

import es.lda.core.event.interfaces.DataEvent;
import es.lda.core.exception.DriverException;
import es.lda.core.lib.driver.stv.STV;
import es.lda.core.network.Udp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import javax.swing.Timer;
import org.apache.log4j.Logger;

public class STVImpl implements STV {

    /**
     * Return Device Name.
     * @return Device Name.
     */
    @Override
    public String getDevice() {
        return config.getString("DEVICE");
    }

    /**
     * Return Device Id.
     * @return Device Id.
     */
    @Override
    public String getDeviceId() {
        return config.getString("DEVICE_ID");
    }

    /**
     * Return Device Version.
     * @return Device Version.
     */
    @Override
    public String getVersion() {
        return config.getString("VERSION");
    }

    /** 
     * Execute command:<code>cmd</code> with arguments<code>args</code> and return the result. 
     *  </p>
     * Available Commands: </p> </p>
     * <code>
     * byte connect(String IP); </p>
     * void dispose(); </p>
     * boolean getAsyncConnect(); </p>
     * STVInfo getInfo(); </p>
     * byte[] getNSource(int i, int j); </p>
     * byte[] getNZone(int i, int j); </p>
     * String getSTVLog(); </p>
     * boolean getSyncConnect(); </p>
     * boolean isIp(String ip); </p>
     * byte setAmpAllMute(boolean mute); </p>
     * byte setAmpChMute(byte channel, boolean mute); </p>
     * byte setAmpCobraNetPrio(int addr_bundle, byte input_ch); </p>
     * byte setAmpCobraNetPrioModeEnable(boolean enable); </p>
     * byte setAmpDC(byte channel, short dc); </p>
     * byte setAmpDecayLimiter(byte channel, byte decay); </p>
     * byte setAmpEqualizer(byte channel, byte band, byte boost, int frec, int q_slope, byte gain); </p>
     * byte setAmpEqualizerEnable(byte channel, boolean enable); </p>
     * byte setAmpFilter(byte channel, int Frec, byte Gain); </p>
     * byte setAmpFilterEnable(byte channel, boolean enable); </p>
     * byte setAmpFilterPrio(byte boost, int frec, int q_slope, byte gain); </p>
     * byte setAmpFrecTone(byte channel, int frec); </p>
     * byte setAmpGain(byte channel, boolean e_s, byte gain); </p>
     * byte setAmpGainLinearInput(byte channel, short gain); </p>
     * byte setAmpGainLinearPrioInput(short gain); </p>
     * byte setAmpGainPrio(byte gain); </p>
     * byte setAmpGainTone(byte channel, byte gain); </p>
     * byte setAmpLevelPrioActive(boolean High); </p>
     * byte setAmpLimiterEnable(byte channel, boolean enable); </p>
     * byte setAmpLoudnessEnable(byte channel, boolean enable); </p>
     * byte setAmpModeAudioInput(boolean digital_input); </p>
     * byte setAmpModePrioActive(boolean signal_presense); </p>
     * byte setAmpPresets(byte channel, byte action); </p>
     * byte setAmpTCLimiter(byte channel, int tc); </p>
     * byte setAmpThresHoldActivePrio(byte threshold); </p>
     * byte setAmpThresholdLimiter(byte channel, byte threshold); </p>
     * byte setAmpToneEnable(byte channel, boolean enable); </p>
     * byte setCM2Enable(boolean enable); </p>
     * byte setCobraNet(byte channel, int addr_bundle, byte input_ch); </p>
     * byte setCobraNetSourceName(byte channel, String nombre); </p>
     * byte setCobraNetZoneName(byte channel, String nombre); </p>
     * byte setDelayBootSource(byte delay); </p>
     * byte setDeleteFrontalLogo(); </p>
     * byte setEtherNetEnable(boolean enable); </p>
     * byte setFrontalLogo(byte[] logo); </p>
     * byte setPowerOn(boolean power_on); </p>
     * byte setSDCardEnable(boolean enable); </p>
     * byte setSTVModeLimiter(byte mode); </p>
     * byte setSTVModel(byte model); </p>
     * byte setSettingSource(boolean enable); </p>
     * byte setSoftwareReset(); </p>
     * </code>
     */
    @Override
    public Object[] exec(String cmd, String[] args, byte[] argsBytes) {
        List<Object> res = new LinkedList<Object>();
        
        try {
            if (cmd.equalsIgnoreCase("connect")) {
                res.add(connect(args[0]));
            } else if (cmd.equalsIgnoreCase("dispose")) {
                dispose();
            } else if (cmd.equalsIgnoreCase("getAsyncConnect")) {
                getAsyncConnect();
            } else if (cmd.equalsIgnoreCase("getInfo")) {
                res.add(getInfo());
            } else if (cmd.equalsIgnoreCase("getNSource")) {
                res.add(getNSource(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
            } else if (cmd.equalsIgnoreCase("getNZone")) {
                res.add(getNZone(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
            } else if (cmd.equalsIgnoreCase("getSTVLog")) {
                res.add(getSTVLog());
            } else if (cmd.equalsIgnoreCase("getSyncConnect")) {
                res.add(getSyncConnect());
            } else if (cmd.equalsIgnoreCase("isIp")) {
                res.add(isIp(args[0]));
            } else if (cmd.equalsIgnoreCase("setAmpAllMute")) {
                res.add(setAmpAllMute(Boolean.parseBoolean(args[0])));
            } else if (cmd.equalsIgnoreCase("setAmpChMute")) {
                res.add(setAmpChMute(Byte.parseByte(args[0]), Boolean.parseBoolean(args[1])));
            } else if (cmd.equalsIgnoreCase("setAmpCobraNetPrio")) {
                res.add(setAmpCobraNetPrio(Integer.parseInt(args[0]), Byte.parseByte(args[1])));
            } else if (cmd.equalsIgnoreCase("setAmpCobraNetPrioModeEnable")) {
                res.add(setAmpCobraNetPrioModeEnable(Boolean.parseBoolean(args[0])));
            } else if (cmd.equalsIgnoreCase("setAmpDC")) {
                res.add(setAmpDC(Byte.parseByte(args[0]), Short.parseShort(args[1])));
            } else if (cmd.equalsIgnoreCase("setAmpDecayLimiter")) {
                res.add(setAmpDecayLimiter(Byte.parseByte(args[0]), Byte.parseByte(args[1])));
            } else if (cmd.equalsIgnoreCase("setAmpEqualizer")) {
                res.add(setAmpEqualizer(Byte.parseByte(args[0]), Byte.parseByte(args[1]), Byte.parseByte(args[2]),
                        Integer.parseInt(args[3]), Integer.parseInt(args[4]), Byte.parseByte(args[5])));
            } else if (cmd.equalsIgnoreCase("setAmpEqualizerEnable")) {
                res.add(setAmpEqualizerEnable(Byte.parseByte(args[0]), Boolean.parseBoolean(args[0])));
            } else if (cmd.equalsIgnoreCase("setAmpFilter")) {
                res.add(setAmpFilter(Byte.parseByte(args[0]), Integer.parseInt(args[1]), Byte.parseByte(args[2])));
            } else if (cmd.equalsIgnoreCase("setAmpFilterEnable")) {
                res.add(setAmpFilterEnable(Byte.parseByte(args[0]), Boolean.parseBoolean(args[0])));
            } else if (cmd.equalsIgnoreCase("setAmpFilterPrio")) {
                res.add(setAmpFilterPrio(Byte.parseByte(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Byte.parseByte(args[3])));
            } else if (cmd.equalsIgnoreCase("setAmpFrecTone")) {
                res.add(setAmpFrecTone(Byte.parseByte(args[0]), Integer.parseInt(args[1])));
            } else if (cmd.equalsIgnoreCase("setAmpGain")) {
                res.add(setAmpGain(Byte.parseByte(args[0]), Boolean.parseBoolean(args[1]), Byte.parseByte(args[2])));
            } else if (cmd.equalsIgnoreCase("setAmpGainLinearInput")) {
                res.add(setAmpGainLinearInput(Byte.parseByte(args[0]), Short.parseShort(args[1])));
            } else if (cmd.equalsIgnoreCase("setAmpGainLinearPrioInput")) {
                res.add(setAmpGainLinearPrioInput(Short.parseShort(args[0])));
            } else if (cmd.equalsIgnoreCase("setAmpGainPrio")) {
                res.add(setAmpGainPrio(Byte.parseByte(args[0])));
            } else if (cmd.equalsIgnoreCase("setAmpGainTone")) {
                res.add(setAmpGainTone(Byte.parseByte(args[0]), Byte.parseByte(args[1])));
            } else if (cmd.equalsIgnoreCase("setAmpLevelPrioActive")) {
                res.add(setAmpLevelPrioActive(Boolean.parseBoolean(args[0])));
            } else if (cmd.equalsIgnoreCase("setAmpLimiterEnable")) {
                res.add(setAmpLimiterEnable(Byte.parseByte(args[0]), Boolean.parseBoolean(args[1])));
            } else if (cmd.equalsIgnoreCase("setAmpLoudnessEnable")) {
                res.add(setAmpLoudnessEnable(Byte.parseByte(args[0]), Boolean.parseBoolean(args[1])));
            } else if (cmd.equalsIgnoreCase("setAmpModeAudioInput")) {
                res.add(setAmpModeAudioInput(Boolean.parseBoolean(args[0])));
            } else if (cmd.equalsIgnoreCase("setAmpModePrioActive")) {
                res.add(setAmpModePrioActive(Boolean.parseBoolean(args[0])));
            } else if (cmd.equalsIgnoreCase("setAmpPresets")) {
                res.add(setAmpPresets(Byte.parseByte(args[0]), Byte.parseByte(args[1])));
            } else if (cmd.equalsIgnoreCase("setAmpTCLimiter")) {
                res.add(setAmpTCLimiter(Byte.parseByte(args[0]), Integer.parseInt(args[1])));
            } else if (cmd.equalsIgnoreCase("setAmpThresHoldActivePrio")) {
                res.add(setAmpThresHoldActivePrio(Byte.parseByte(args[0])));
            } else if (cmd.equalsIgnoreCase("setAmpThresholdLimiter")) {
                res.add(setAmpThresholdLimiter(Byte.parseByte(args[0]), Byte.parseByte(args[1])));
            } else if (cmd.equalsIgnoreCase("setAmpToneEnable")) {
                res.add(setAmpToneEnable(Byte.parseByte(args[0]), Boolean.parseBoolean(args[1])));
            } else if (cmd.equalsIgnoreCase("setCM2Enable")) {
                res.add(setCM2Enable(Boolean.parseBoolean(args[0])));
            } else if (cmd.equalsIgnoreCase("setCobraNet")) {
                res.add(setCobraNet(Byte.parseByte(args[0]), Integer.parseInt(args[1]), Byte.parseByte(args[2])));
            } else if (cmd.equalsIgnoreCase("setCobraNetSourceName")) {
                res.add(setCobraNetSourceName(Byte.parseByte(args[0]), args[1]));
            } else if (cmd.equalsIgnoreCase("setCobraNetZoneName")) {
                res.add(setCobraNetZoneName(Byte.parseByte(args[0]), args[1]));
            } else if (cmd.equalsIgnoreCase("setDelayBootSource")) {
                res.add(setDelayBootSource(Byte.parseByte(args[0])));
            } else if (cmd.equalsIgnoreCase("setDeleteFrontalLogo")) {
                res.add(setDeleteFrontalLogo());
            } else if (cmd.equalsIgnoreCase("setEtherNetEnable")) {
                res.add(setEtherNetEnable(Boolean.parseBoolean(args[0])));
            } else if (cmd.equalsIgnoreCase("setFrontalLogo")) {
                res.add(setFrontalLogo(argsBytes));
            } else if (cmd.equalsIgnoreCase("setPowerOn")) {
                res.add(setPowerOn(Boolean.parseBoolean(args[0])));
            } else if (cmd.equalsIgnoreCase("setSDCardEnable")) {
                res.add(setSDCardEnable(Boolean.parseBoolean(args[0])));
            } else if (cmd.equalsIgnoreCase("setSTVModeLimiter")) {
                res.add(setSTVModeLimiter(Byte.parseByte(args[0])));
            } else if (cmd.equalsIgnoreCase("setSTVModel")) {
                res.add(setSTVModel(Byte.parseByte(args[0])));
            } else if (cmd.equalsIgnoreCase("setSettingSource")) {
                res.add(setSettingSource(Boolean.parseBoolean(args[0])));
            } else if (cmd.equalsIgnoreCase("setSettingSource")) {
                res.add(setSoftwareReset());
            }                        
        } catch (DriverException ex) {
            ex.printStackTrace();
        } finally {
            return res.toArray();
        }
    }
    
    /** Logger. */
    private static Logger logger = Logger.getLogger(STVImpl.class);
    /** Load properties. */
    private static final ResourceBundle config = ResourceBundle.getBundle("es/lda/core/lib/driver/stv/config/config");
    /** Constants. */
    public final byte STV_ERR_GENERICO = new Byte(config.getString("STV_ERR_GENERICO"));
    public final byte STV_ERR_OK = new Byte(config.getString("STV_ERR_OK"));
    public final byte STV_ERR_PARAM = new Byte(config.getString("STV_ERR_PARAM"));
    private final short STV_COMMAND_GET_INFO = Short.parseShort(config.getString("STV_COMMAND_GET_INFO"));
    private final short STV_COMMAND_GET_LOG = Short.parseShort(config.getString("STV_COMMAND_GET_LOG"));
    private final int STV_COMMAND_SET_ASINC = Integer.parseInt(config.getString("STV_COMMAND_SET_ASINC"));
    private final int STV_COMMAND_SET_AMP_GAIN = Integer.parseInt(config.getString("STV_COMMAND_SET_AMP_GAIN"));
    private final int STV_COMMAND_SET_AMP_ENABLE_FILTER = Integer.parseInt(config.getString("STV_COMMAND_SET_AMP_ENABLE_FILTER"));
    private final int STV_COMMAND_SET_AMP_FILTER = Integer.parseInt(config.getString("STV_COMMAND_SET_AMP_FILTER"));
    private final int STV_COMMAND_SET_AMP_ENABLE_LIMITER = Integer.parseInt(config.getString("STV_COMMAND_SET_AMP_ENABLE_LIMITER"));
    private final int STV_COMMAND_SET_AMP_THRESHOLD_LIMITER = Integer.parseInt(config.getString("STV_COMMAND_SET_AMP_THRESHOLD_LIMITER"));
    private final int STV_COMMAND_SET_AMP_TC_LIMITER = Integer.parseInt(config.getString("STV_COMMAND_SET_AMP_TC_LIMITER"));
    private final int STV_COMMAND_SET_AMP_DECAY_LIMITER = Integer.parseInt(config.getString("STV_COMMAND_SET_AMP_DECAY_LIMITER"));
    private final int STV_COMMAND_SET_AMP_ENABLE_EQUALIZER = Integer.parseInt(config.getString("STV_COMMAND_SET_AMP_ENABLE_EQUALIZER"));
    private final int STV_COMMAND_SET_AMP_EQUALIZER = Integer.parseInt(config.getString("STV_COMMAND_SET_AMP_EQUALIZER"));
    private final int STV_COMMAND_SET_AMP_ENABLE_TONE = Integer.parseInt(config.getString("STV_COMMAND_SET_AMP_ENABLE_TONE"));
    private final int STV_COMMAND_SET_AMP_GAIN_TONE = Integer.parseInt(config.getString("STV_COMMAND_SET_AMP_GAIN_TONE"));
    private final int STV_COMMAND_SET_AMP_FREC_TONE = Integer.parseInt(config.getString("STV_COMMAND_SET_AMP_FREC_TONE"));
    private final int STV_COMMAND_SET_AMP_DC = Integer.parseInt(config.getString("STV_COMMAND_SET_AMP_DC"));
    private final int STV_COMMAND_SET_AMP_GAIN_INPUT_LINEAR = Integer.parseInt(config.getString("STV_COMMAND_SET_AMP_GAIN_INPUT_LINEAR"));
    private final int STV_COMMAND_SET_AMP_ENABLE_LOUDNESS = Integer.parseInt(config.getString("STV_COMMAND_SET_AMP_ENABLE_LOUDNESS"));
    private final int STV_COMMAND_SET_AMP_FILTER_PRIO = Integer.parseInt(config.getString("STV_COMMAND_SET_AMP_FILTER_PRIO"));
    private final int STV_COMMAND_SET_AMP_GAIN_INPUT_LINEAR_PRIO = Integer.parseInt(config.getString("STV_COMMAND_SET_AMP_GAIN_INPUT_LINEAR_PRIO"));
    private final int STV_COMMAND_SET_AMP_GAIN_PRIO = Integer.parseInt(config.getString("STV_COMMAND_SET_AMP_GAIN_PRIO"));
    private final int STV_COMMAND_SET_AMP_MUTE_CH = Integer.parseInt(config.getString("STV_COMMAND_SET_AMP_MUTE_CH"));
    private final int STV_COMMAND_SET_AMP_MUTE_ALL = Integer.parseInt(config.getString("STV_COMMAND_SET_AMP_MUTE_ALL"));
    private final int STV_COMMAND_SET_COBRANET_PRIO = Integer.parseInt(config.getString("STV_COMMAND_SET_COBRANET_PRIO"));
    private final int STV_COMMAND_SET_COBRANET = Integer.parseInt(config.getString("STV_COMMAND_SET_COBRANET"));
    private final int STV_COMMAND_SET_AMP_MODE_AUDIO_INPUT = Integer.parseInt(config.getString("STV_COMMAND_SET_AMP_MODE_AUDIO_INPUT"));
    private final int STV_COMMAND_SET_AMP_ENABLE_COBRANET_PRIO = Integer.parseInt(config.getString("STV_COMMAND_SET_AMP_ENABLE_COBRANET_PRIO"));
    private final int STV_COMMAND_SET_AMP_MODE_ACTIVE_PRIO = Integer.parseInt(config.getString("STV_COMMAND_SET_AMP_MODE_ACTIVE_PRIO"));
    private final int STV_COMMAND_SET_AMP_LEVEL_ACTIVE_PRIO = Integer.parseInt(config.getString("STV_COMMAND_SET_AMP_LEVEL_ACTIVE_PRIO"));
    private final int STV_COMMAND_SET_AMP_THRESHOLD_ACTIVE_PRIO = Integer.parseInt(config.getString("STV_COMMAND_SET_AMP_THRESHOLD_ACTIVE_PRIO"));
    private final int STV_COMMAND_SET_AMP_PRESETS = Integer.parseInt(config.getString("STV_COMMAND_SET_AMP_PRESETS"));
    private final int STV_COMMAND_SET_COBRANET_NOMBRE_FUENTE = Integer.parseInt(config.getString("STV_COMMAND_SET_COBRANET_NOMBRE_FUENTE"));
    private final int STV_COMMAND_SET_COBRANET_NOMBRE_ZONA = Integer.parseInt(config.getString("STV_COMMAND_SET_COBRANET_NOMBRE_ZONA"));
    private final int STV_COMMAND_SET_MODEL_STV = Integer.parseInt(config.getString("STV_COMMAND_SET_MODEL_STV"));
    private final int STV_COMMAND_SET_MODE_LIMITER = Integer.parseInt(config.getString("STV_COMMAND_SET_MODE_LIMITER"));
    private final int STV_COMMAND_SET_ENABLE_CM2 = Integer.parseInt(config.getString("STV_COMMAND_SET_ENABLE_CM2"));
    private final int STV_COMMAND_SET_ENABLE_SDCARD = Integer.parseInt(config.getString("STV_COMMAND_SET_ENABLE_SDCARD"));
    private final int STV_COMMAND_SET_POWER_ON = Integer.parseInt(config.getString("STV_COMMAND_SET_POWER_ON"));
    private final int STV_COMMAND_SET_SOFTWARE_RESET = Integer.parseInt(config.getString("STV_COMMAND_SET_SOFTWARE_RESET"));
    private final int STV_COMMAND_SET_ENABLE_ETHERNET = Integer.parseInt(config.getString("STV_COMMAND_SET_ENABLE_ETHERNET"));
    private final int STV_COMMAND_SET_FRONTAL_LOGO = Integer.parseInt(config.getString("STV_COMMAND_SET_FRONTAL_LOGO"));
    private final int STV_COMMAND_SET_FRONTAL_BORRAR_LOGO = Integer.parseInt(config.getString("STV_COMMAND_SET_FRONTAL_BORRAR_LOGO"));
    private final int STV_COMMAND_SET_DELAY_ARRANQUE = Integer.parseInt(config.getString("STV_COMMAND_SET_DELAY_ARRANQUE"));
    private final int STV_COMMAND_SET_SENSADO_FUENTE = Integer.parseInt(config.getString("STV_COMMAND_SET_SENSADO_FUENTE"));
    private final byte UDP_GET = new Byte(config.getString("UDP_GET"));
    private final byte UDP_SET = new Byte(config.getString("UDP_SET"));
    private final int REFRESCO = Integer.parseInt(config.getString("REFRESCO"));
    private final int TIMEOUT = Integer.parseInt(config.getString("TIMEOUT"));
    private final int MAX_REINTENTOS = Integer.parseInt(config.getString("MAX_REINTENTOS"));
    private final int CHECK_ASINCRONO = Integer.parseInt(config.getString("CHECK_ASINCRONO"));
    private final int MAX_DESCONEXION = Integer.parseInt(config.getString("MAX_DESCONEXION"));
    private final int NUM_STV_ERR = Integer.parseInt(config.getString("NUM_STV_ERR"));
    private final int SIZE_LOG_STV = Integer.parseInt(config.getString("SIZE_LOG_STV"));

    public class main extends Thread {

        public void run() {
            while (!Abort) {
                try {
                    sendSTVCommand();
                } catch (NullPointerException e) {
                    Abort = true;
                    logger.error(e);
                } catch (Exception e) {
                    Abort = true;
                    logger.error(e);
                }
            }
        }

        public void Abort() {
            Abort = true;
        }
        boolean Abort;
        final STVImpl this$0;

        public main() {
            this$0 = STVImpl.this;
            Abort = false;
        }
    }

    public STVImpl() {
        STV_Info = new STVInfo();
        STV_COMANDO = new STVComm();
        STV_CONECTADO = false;
        STV_ASINC_CONECTADO = false;
        STV_ASINC_INTENTOS = 0;
        STV_STRING_ERR = new String[9][9];
        Procesandosend = false;
        for (int i = 0; i <= 1; i++) {
            STV_Info.modAmp[i] = new STVModAmp();
            for (int j = 0; j <= 1; j++) {
                STV_Info.modAmp[i].Canal[j] = new STVCanal();
            }

        }

        STV_STRING_ERR[0][1] = config.getString("RAM_ERROR");
        STV_STRING_ERR[1][1] = config.getString("COBRANET_ERROR");
        STV_STRING_ERR[2][1] = config.getString("POWER_ERROR");
        STV_STRING_ERR[3][1] = config.getString("ETX_TEMP_RANGE_ERROR");
        STV_STRING_ERR[4][1] = config.getString("SETTING_POWER_230V_ERROR");
        STV_STRING_ERR[4][2] = config.getString("SETTING_POWER_230i_ERROR");
        STV_STRING_ERR[4][3] = config.getString("SETTING_POWER_VP1_ERROR");
        STV_STRING_ERR[4][4] = config.getString("SETTING_POWER_VP2_ERROR");
        STV_STRING_ERR[4][5] = config.getString("SETTING_POWER_12V_ERROR");
        STV_STRING_ERR[4][6] = config.getString("POWER_LOAD_ERROR");
        STV_STRING_ERR[4][7] = config.getString("POWER_CONTROL_ERROR");
        STV_STRING_ERR[5][1] = config.getString("CONTROL_CHANNEL_1_2_WO_COMM");
        STV_STRING_ERR[6][1] = config.getString("CONTROL_CHANNEL_3_4_WO_COMM");
        STV_STRING_ERR[7][1] = config.getString("FRONT_CONTROL_WO_COMM");
        STV_STRING_ERR[8][1] = config.getString("HIGH_ETX_TEMP");
    }

    @Override
    public void dispose()
            throws DriverException, InterruptedException {
        STV_ASINC_CONECTADO = false;
        STV_CONECTADO = false;
        STV_STRING_ERR = (String[][]) null;
        if (Hebra != null) {
            Hebra.Abort();
        }
        if (tmrRefresco != null) {
            tmrRefresco.stop();
        }
        if (tmrTimeOut != null) {
            tmrTimeOut.stop();
        }
        if (tmrCheckPortAsinc != null) {
            tmrCheckPortAsinc.stop();
        }
        if (tmrInfoDesconexion != null) {
            tmrInfoDesconexion.stop();
        }
        if (tmrInfoDesconexionAsinc != null) {
            tmrInfoDesconexion.stop();
        }
        if (sckSinc != null) {
            sckSinc.close();
            sckSinc = null;
        }
        if (sckAsinc != null) {
            sckAsinc.close();
            sckAsinc = null;
        }
        if (tmrRefresco != null) {
            tmrRefresco = null;
        }
        if (tmrTimeOut != null) {
            tmrTimeOut = null;
        }
        if (tmrCheckPortAsinc != null) {
            tmrCheckPortAsinc = null;
        }
        if (tmrInfoDesconexion != null) {
            tmrInfoDesconexion = null;
        }
        if (tmrInfoDesconexionAsinc != null) {
            tmrInfoDesconexionAsinc = null;
        }
        list_Command_STV = null;
        Semaforo_Lista_STV = null;
        if (Hebra != null) {
            Thread.sleep(1L);
            Hebra = null;
        }
    }

    @Override
    public boolean getSyncConnect()
            throws DriverException {
        return STV_CONECTADO;
    }

    @Override
    public boolean getAsyncConnect()
            throws DriverException {
        return STV_ASINC_CONECTADO;
    }

    @Override
    public STVInfo getInfo()
            throws DriverException {
        return STV_Info;
    }

    @Override
    public byte[] getNSource(int i, int j) {
        int lon = cont(STV_Info.modAmp[i].Canal[j].Nombre_Fuente_Cobranet);
        byte aux[] = new byte[lon];
        System.arraycopy(STV_Info.modAmp[i].Canal[j].Nombre_Fuente_Cobranet, 0, aux, 0, lon);
        return aux;
    }

    @Override
    public byte[] getNZone(int i, int j) {
        int lon = cont(STV_Info.modAmp[i].Canal[j].Nombre_Zona_Cobranet);
        byte aux[] = new byte[lon];
        System.arraycopy(STV_Info.modAmp[i].Canal[j].Nombre_Zona_Cobranet, 0, aux, 0, lon);
        return aux;
    }

    @Override
    public byte connect(String IP)
            throws DriverException {
        byte r = 0;
        if (isIp(IP)) {
            if (Semaforo_Lista_STV == null) {
                Semaforo_Lista_STV = new Semaphore(1);
            }
            if (sckSinc == null) {
                sckSinc = new Udp();
                sckSinc.setRemotePort(60000);
                sckSinc.setRemoteHost(IP);
                sckSinc.bind();
                sckAsinc = new Udp();
                sckAsinc.setRemotePort(61000);
                sckAsinc.setRemoteHost(IP);
                sckAsinc.bind();
                DataEvent data = new DataEvent() {

                    public void dataArrival(short Bytestotal) {
                        if (Bytestotal == 0) {
                            return;
                        }
                        if (Procesando) {
                            return;
                        }
                        byte comando[];
                        Procesando = true;
                        comando = new byte[Bytestotal];
                        sckSinc.getDataByte(comando);
                        if (comando.length < 8 || STV_COMANDO.Comando == null) {
                            comando = null;
                            Procesando = false;
                            return;
                        }
                        if (comando.length != bv(comando[0]) * pow(2, 8) + bv(comando[1]) + 8) {
                            comando = null;
                            Procesando = false;
                            return;
                        }
                        if (comando[2] != STV_COMANDO.Comando[2] || comando[3] != STV_COMANDO.Comando[3]) {
                            comando = null;
                            Procesando = false;
                            return;
                        }
                        if (comando[4] != STV_COMANDO.Comando[4]) {
                            comando = null;
                            Procesando = false;
                            return;
                        }
                        if (comando[4] != 1 && comando[4] != 2) {
                            comando = null;
                            Procesando = false;
                            return;
                        }
                        if (comando[4] == 2 && (comando[6] != 79 || comando[7] != 75)) {
                            comando = null;
                            Procesando = false;
                            return;
                        }
                        try {
                            if (!checkSTVCheckSum(comando)) {
                                Procesando = false;
                                comando = null;
                                return;
                            }
                        } catch (Exception ex) {
                            logger.error(ex);
                        }
                        try {
                            if (tmrInfoDesconexion.isRunning()) {
                                tmrInfoDesconexion.stop();
                            }
                            tmrTimeOut.stop();
                            STV_CONECTADO = true;
                            if (STV_COMANDO.Comando[4] == 1) {
                                processSTVSyncCommand(comando);
                            }
                            clearSTVCommand();
                            comando = null;
                            Procesando = false;
                        } catch (Exception e) {
                        }
                        return;
                    }
                    boolean Procesando;
                    final STVImpl this$0;

                    {
                        this$0 = STVImpl.this;

                        Procesando = false;
                    }
                };
                DataEvent data2 = new DataEvent() {

                    public void dataArrival(short Bytestotal) {
                        if (Bytestotal == 0) {
                            return;
                        }
                        if (Procesando) {
                            return;
                        }
                        byte comando[];
                        Procesando = true;
                        comando = new byte[Bytestotal];
                        sckAsinc.getDataByte(comando);
                        if (comando.length < 8) {
                            comando = null;
                            Procesando = false;
                            return;
                        }
                        if (comando.length != bv(comando[0]) * pow(2, 8) + bv(comando[1]) + 8) {
                            comando = null;
                            Procesando = false;
                            return;
                        }
                        if (comando[4] != 1 && comando[4] != 2) {
                            comando = null;
                            Procesando = false;
                            return;
                        }
                        if (comando[4] == 2 && (comando[6] != 79 || comando[7] != 75)) {
                            comando = null;
                            Procesando = false;
                            return;
                        }
                        try {
                            if (!checkSTVCheckSum(comando)) {
                                comando = null;
                                Procesando = false;
                                return;
                            }
                        } catch (Exception ex) {
                            logger.error(ex);
                        }
                        try {
                            if (tmrInfoDesconexionAsinc.isRunning()) {
                                tmrInfoDesconexionAsinc.stop();
                            }
                            STV_ASINC_CONECTADO = true;
                            STV_ASINC_INTENTOS = 0;
                            if (comando[4] == 1) {
                                processSTVASyncCommand(comando);
                            }
                            comando = null;
                            Procesando = false;
                        } catch (Exception e) {
                            logger.error(e);
                        }
                        return;
                    }
                    boolean Procesando;
                    final STVImpl this$0;

                    {
                        this$0 = STVImpl.this;

                        Procesando = false;
                    }
                };
                sckSinc.setListener(data);
                sckAsinc.setListener(data2);
                clearSTVCommand();
            }
            if (tmrTimeOut == null) {
                tmrTimeOut = new Timer(TIMEOUT, new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        if (Procesando) {
                            return;
                        }
                        Procesando = true;
                        if (STV_COMANDO.Busy) {
                            if (STV_COMANDO.nIntentos > 12) {
                                tmrTimeOut.stop();
                                try {
                                    clearSTVCommand();
                                } catch (Exception ex) {
                                    logger.error(ex);
                                }
                                if (!tmrInfoDesconexion.isRunning()) {
                                    tmrInfoDesconexion.start();
                                }
                            } else {
                                STV_COMANDO.nIntentos++;
                                logger.warn((new StringBuilder()).append("Timeout = ").append(STV_COMANDO.nIntentos).toString());
                                sckSinc.sendData(STV_COMANDO.Comando);
                            }
                        }
                        Procesando = false;
                    }
                    boolean Procesando;
                    final STVImpl this$0;

                    {
                        this$0 = STVImpl.this;

                        Procesando = false;
                    }
                });
                tmrRefresco = new Timer(10, new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        if (Procesando) {
                            return;
                        }
                        Procesando = true;
                        try {
                            STVInfoRefresh();
                            STVLogRefresh();
                        } catch (Exception ex) {
                            logger.error(ex);
                        }
                        Procesando = false;
                    }
                    boolean Procesando;
                    final STVImpl this$0;

                    {
                        this$0 = STVImpl.this;

                        Procesando = false;
                    }
                });
                tmrCheckPortAsinc = new Timer(CHECK_ASINCRONO, new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        if (Procesando) {
                            return;
                        }
                        try {
                            Procesando = true;
                            setAsync();
                            Procesando = false;
                        } catch (Exception ex) {
                            logger.error(ex);
                        }
                        return;
                    }
                    boolean Procesando;
                    final STVImpl this$0;

                    {
                        this$0 = STVImpl.this;

                        Procesando = false;
                    }
                });
                tmrInfoDesconexion = new Timer(MAX_DESCONEXION, new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        if (Procesando) {
                            return;
                        } else {
                            Procesando = true;
                            tmrInfoDesconexion.stop();
                            STV_CONECTADO = false;
                            Procesando = false;
                            return;
                        }
                    }
                    boolean Procesando;
                    final STVImpl this$0;

                    {
                        this$0 = STVImpl.this;

                        Procesando = false;
                    }
                });
                tmrInfoDesconexionAsinc = new Timer(MAX_DESCONEXION, new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        if (Procesando) {
                            return;
                        }
                        Procesando = true;
                        try {
                            tmrInfoDesconexionAsinc.stop();
                        } catch (NullPointerException er) {
                            logger.error(er);
                        } finally {
                            STV_ASINC_CONECTADO = false;
                            Procesando = false;
                        }
                    }
                    boolean Procesando;
                    final STVImpl this$0;

                    {
                        this$0 = STVImpl.this;

                        Procesando = false;
                    }
                });
                tmrRefresco.start();
                tmrCheckPortAsinc.start();
            }
            if (list_Command_STV == null) {
                list_Command_STV = new ArrayList();
            } else {
                list_Command_STV.clear();
            }
            if (Hebra == null) {
                Hebra = new main();
                Hebra.start();
            }
            r = 1;
        } else {
            r = 2;
        }
        return r;
    }

    private byte setAsync()
            throws DriverException {
        if (STV_ASINC_INTENTOS <= 12) {
            STV_ASINC_INTENTOS++;
            tmrCheckPortAsinc.setDelay(TIMEOUT);
        } else {
            tmrCheckPortAsinc.setDelay(CHECK_ASINCRONO);
            if (!tmrInfoDesconexionAsinc.isRunning()) {
                tmrInfoDesconexionAsinc.start();
            }
        }
        byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_ASINC, UDP_SET, null);
        sckAsinc.sendData(STV_Command);
        STV_Command = null;
        return 1;
    }

    @Override
    public byte setAmpGain(byte channel, boolean e_s, byte gain)
            throws DriverException {
        if (channel < 1 || channel > STV_Info.num_canales) {
            return 2;
        }
        if (gain > 0 || gain < -100) {
            return 2;
        } else {
            byte bA_channel[] = new byte[1];
            byte bA_e_s[] = new byte[1];
            byte bA_gain[] = new byte[1];
            bA_channel[0] = channel;
            bA_e_s[0] = myCByte(e_s);
            bA_gain[0] = gain;
            byte bA_Params[] = new byte[bA_channel.length + bA_e_s.length + bA_gain.length];
            System.arraycopy(bA_channel, 0, bA_Params, 0, bA_channel.length);
            System.arraycopy(bA_e_s, 0, bA_Params, bA_channel.length, bA_e_s.length);
            System.arraycopy(bA_gain, 0, bA_Params, bA_channel.length + bA_e_s.length, bA_gain.length);
            byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_AMP_GAIN, UDP_SET, bA_Params);
            addSTVCommandGain(STV_Command);
            bA_e_s = null;
            bA_channel = null;
            bA_gain = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    @Override
    public byte setAmpFilterEnable(byte channel, boolean enable)
            throws DriverException {
        if (channel < 1 || channel > STV_Info.num_canales) {
            return 2;
        } else {
            byte bA_channel[] = new byte[1];
            byte bA_enable[] = new byte[1];
            bA_channel[0] = channel;
            bA_enable[0] = myCByte(enable);
            byte bA_Params[] = new byte[bA_channel.length + bA_enable.length];
            System.arraycopy(bA_channel, 0, bA_Params, 0, bA_channel.length);
            System.arraycopy(bA_enable, 0, bA_Params, bA_channel.length, bA_enable.length);
            byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_AMP_ENABLE_FILTER, UDP_SET, bA_Params);
            addSTVCommandChannel(STV_Command);
            bA_enable = null;
            bA_channel = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    @Override
    public byte setAmpFilter(byte channel, int Frec, byte Gain)
            throws DriverException {
        if (channel < 1 || channel > STV_Info.num_canales) {
            return 2;
        }
        if (Frec < 3 || Frec > 60000) {
            return 2;
        }
        if (Gain < -15 || Gain > 15) {
            return 2;
        } else {
            byte bA_channel[] = new byte[1];
            byte bA_ganancia[] = new byte[1];
            bA_channel[0] = channel;
            byte bA_frecuencia[] = getByteUshort(Frec);
            invertir(bA_frecuencia);
            bA_ganancia[0] = Gain;
            byte bA_Params[] = new byte[bA_channel.length + bA_frecuencia.length + bA_ganancia.length];
            System.arraycopy(bA_channel, 0, bA_Params, 0, bA_channel.length);
            System.arraycopy(bA_frecuencia, 0, bA_Params, bA_channel.length, bA_frecuencia.length);
            System.arraycopy(bA_ganancia, 0, bA_Params, bA_channel.length + bA_frecuencia.length, bA_ganancia.length);
            byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_AMP_FILTER, UDP_SET, bA_Params);
            addSTVCommandChannel(STV_Command);
            bA_channel = null;
            bA_frecuencia = null;
            bA_ganancia = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    @Override
    public byte setAmpLimiterEnable(byte channel, boolean enable)
            throws DriverException {
        if (channel < 1 || channel > STV_Info.num_canales) {
            return 2;
        } else {
            byte bA_channel[] = new byte[1];
            byte bA_enable[] = new byte[1];
            bA_channel[0] = channel;
            bA_enable[0] = myCByte(enable);
            byte bA_Params[] = new byte[bA_channel.length + bA_enable.length];
            System.arraycopy(bA_channel, 0, bA_Params, 0, bA_channel.length);
            System.arraycopy(bA_enable, 0, bA_Params, bA_channel.length, bA_enable.length);
            byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_AMP_ENABLE_LIMITER, UDP_SET, bA_Params);
            addSTVCommandChannel(STV_Command);
            bA_enable = null;
            bA_channel = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    @Override
    public byte setAmpThresholdLimiter(byte channel, byte threshold)
            throws DriverException {
        if (channel < 1 || channel > STV_Info.num_canales) {
            return 2;
        }
        if (threshold < -24 || threshold > 24) {
            return 2;
        } else {
            byte bA_channel[] = new byte[1];
            byte bA_threshold[] = new byte[1];
            bA_channel[0] = channel;
            bA_threshold[0] = threshold;
            byte bA_Params[] = new byte[bA_channel.length + bA_threshold.length];
            System.arraycopy(bA_channel, 0, bA_Params, 0, bA_channel.length);
            System.arraycopy(bA_threshold, 0, bA_Params, bA_channel.length, bA_threshold.length);
            byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_AMP_THRESHOLD_LIMITER, UDP_SET, bA_Params);
            addSTVCommandChannel(STV_Command);
            bA_threshold = null;
            bA_channel = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    @Override
    public byte setAmpTCLimiter(byte channel, int tc)
            throws DriverException {
        if (channel < 1 || channel > STV_Info.num_canales) {
            return 2;
        }
        if (tc < 1 || tc > 10000) {
            return 2;
        } else {
            byte bA_channel[] = new byte[1];
            bA_channel[0] = channel;
            byte bA_tc[] = getByteUshort(tc);
            invertir(bA_tc);
            byte bA_Params[] = new byte[bA_channel.length + bA_tc.length];
            System.arraycopy(bA_channel, 0, bA_Params, 0, bA_channel.length);
            System.arraycopy(bA_tc, 0, bA_Params, bA_channel.length, bA_tc.length);
            byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_AMP_TC_LIMITER, UDP_SET, bA_Params);
            addSTVCommandChannel(STV_Command);
            bA_tc = null;
            bA_channel = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    @Override
    public byte setAmpDecayLimiter(byte channel, byte decay)
            throws DriverException {
        if (channel < 1 || channel > STV_Info.num_canales) {
            return 2;
        }
        if (decay < 5 || decay > 23) {
            return 2;
        } else {
            byte bA_channel[] = new byte[1];
            byte bA_decay[] = new byte[1];
            bA_channel[0] = channel;
            bA_decay[0] = decay;
            byte bA_Params[] = new byte[bA_channel.length + bA_decay.length];
            System.arraycopy(bA_channel, 0, bA_Params, 0, bA_channel.length);
            System.arraycopy(bA_decay, 0, bA_Params, bA_channel.length, bA_decay.length);
            byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_AMP_DECAY_LIMITER, UDP_SET, bA_Params);
            addSTVCommandChannel(STV_Command);
            bA_decay = null;
            bA_channel = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    @Override
    public byte setAmpEqualizerEnable(byte channel, boolean enable)
            throws DriverException {
        if (channel < 1 || channel > STV_Info.num_canales) {
            return 2;
        } else {
            byte bA_channel[] = new byte[1];
            byte bA_enable[] = new byte[1];
            bA_channel[0] = channel;
            bA_enable[0] = myCByte(enable);
            byte bA_Params[] = new byte[bA_channel.length + bA_enable.length];
            System.arraycopy(bA_channel, 0, bA_Params, 0, bA_channel.length);
            System.arraycopy(bA_enable, 0, bA_Params, bA_channel.length, bA_enable.length);
            byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_AMP_ENABLE_EQUALIZER, UDP_SET, bA_Params);
            addSTVCommandChannel(STV_Command);
            bA_enable = null;
            bA_channel = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    @Override
    public byte setAmpEqualizer(byte channel, byte band, byte boost, int frec, int q_slope, byte gain)
            throws DriverException {
        if (channel < 1 || channel > STV_Info.num_canales) {
            return 2;
        }
        if (band < 1 || band > 7) {
            return 2;
        }
        if (boost < -10 || boost > 10) {
            return 2;
        }
        if (frec < 3 || frec > 60000) {
            return 2;
        }
        if (q_slope > 5100) {
            return 2;
        }
        if (gain < -15 || gain > 15) {
            return 2;
        } else {
            byte bA_channel[] = new byte[1];
            byte bA_band[] = new byte[1];
            byte bA_boost[] = new byte[1];
            byte bA_gain[] = new byte[1];
            bA_channel[0] = channel;
            bA_band[0] = band;
            bA_boost[0] = boost;
            byte bA_frec[] = getByteUshort(frec);
            invertir(bA_frec);
            byte bA_q_slope[] = getByteUshort(q_slope);
            invertir(bA_q_slope);
            bA_gain[0] = gain;
            byte bA_Params[] = new byte[bA_channel.length + bA_band.length + bA_boost.length + bA_frec.length + bA_q_slope.length + bA_gain.length];
            System.arraycopy(bA_channel, 0, bA_Params, 0, bA_channel.length);
            System.arraycopy(bA_band, 0, bA_Params, bA_channel.length, bA_band.length);
            System.arraycopy(bA_boost, 0, bA_Params, bA_channel.length + bA_band.length, bA_boost.length);
            System.arraycopy(bA_frec, 0, bA_Params, bA_channel.length + bA_band.length + bA_boost.length, bA_frec.length);
            System.arraycopy(bA_q_slope, 0, bA_Params, bA_channel.length + bA_band.length + bA_boost.length + bA_frec.length, bA_q_slope.length);
            System.arraycopy(bA_gain, 0, bA_Params, bA_channel.length + bA_band.length + bA_boost.length + bA_frec.length + bA_q_slope.length, bA_gain.length);
            byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_AMP_EQUALIZER, UDP_SET, bA_Params);
            addSTVCommandChannel(STV_Command);
            bA_channel = null;
            bA_band = null;
            bA_boost = null;
            bA_frec = null;
            bA_q_slope = null;
            bA_gain = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    @Override
    public byte setAmpToneEnable(byte channel, boolean enable)
            throws DriverException {
        if (channel < 1 || channel > STV_Info.num_canales) {
            return 2;
        } else {
            byte bA_channel[] = new byte[1];
            byte bA_enable[] = new byte[1];
            bA_channel[0] = channel;
            bA_enable[0] = myCByte(enable);
            byte bA_Params[] = new byte[bA_channel.length + bA_enable.length];
            System.arraycopy(bA_channel, 0, bA_Params, 0, bA_channel.length);
            System.arraycopy(bA_enable, 0, bA_Params, bA_channel.length, bA_enable.length);
            byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_AMP_ENABLE_TONE, UDP_SET, bA_Params);
            addSTVCommandChannel(STV_Command);
            bA_enable = null;
            bA_channel = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    @Override
    public byte setAmpGainTone(byte channel, byte gain)
            throws DriverException {
        if (channel < 1 || channel > STV_Info.num_canales) {
            return 2;
        }
        if (gain < -100 || gain > 0) {
            return 2;
        } else {
            byte bA_channel[] = new byte[1];
            byte bA_gain[] = new byte[1];
            bA_channel[0] = channel;
            bA_gain[0] = gain;
            byte bA_Params[] = new byte[bA_channel.length + bA_gain.length];
            System.arraycopy(bA_channel, 0, bA_Params, 0, bA_channel.length);
            System.arraycopy(bA_gain, 0, bA_Params, bA_channel.length, bA_gain.length);
            byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_AMP_GAIN_TONE, UDP_SET, bA_Params);
            addSTVCommandChannel(STV_Command);
            bA_gain = null;
            bA_channel = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    @Override
    public byte setAmpFrecTone(byte channel, int frec)
            throws DriverException {
        if (channel < 1 || channel > STV_Info.num_canales) {
            return 2;
        }
        if (frec < 1 || frec > 24000) {
            return 2;
        } else {
            byte bA_channel[] = new byte[1];
            bA_channel[0] = channel;
            byte bA_frec[] = getByteUshort(frec);
            invertir(bA_frec);
            byte bA_Params[] = new byte[bA_channel.length + bA_frec.length];
            System.arraycopy(bA_channel, 0, bA_Params, 0, bA_channel.length);
            System.arraycopy(bA_frec, 0, bA_Params, bA_channel.length, bA_frec.length);
            byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_AMP_FREC_TONE, UDP_SET, bA_Params);
            addSTVCommandChannel(STV_Command);
            bA_frec = null;
            bA_channel = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    @Override
    public byte setAmpDC(byte channel, short dc)
            throws DriverException {
        if (channel < 1 || channel > STV_Info.num_canales) {
            return 2;
        }
        if (dc < -1600 || dc > 1600) {
            return 2;
        } else {
            byte bA_channel[] = new byte[1];
            bA_channel[0] = channel;
            byte bA_dc[] = getByteShort(dc);
            invertir(bA_dc);
            byte bA_Params[] = new byte[bA_channel.length + bA_dc.length];
            System.arraycopy(bA_channel, 0, bA_Params, 0, bA_channel.length);
            System.arraycopy(bA_dc, 0, bA_Params, bA_channel.length, bA_dc.length);
            byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_AMP_DC, UDP_SET, bA_Params);
            addSTVCommandChannel(STV_Command);
            bA_dc = null;
            bA_channel = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    @Override
    public byte setAmpGainLinearInput(byte channel, short gain)
            throws DriverException {
        if (channel < 1 || channel > STV_Info.num_canales) {
            return 2;
        }
        if (gain < -1500 || gain > 1200) {
            return 2;
        } else {
            byte bA_channel[] = new byte[1];
            bA_channel[0] = channel;
            byte bA_gain[] = getByteShort(gain);
            invertir(bA_gain);
            byte bA_Params[] = new byte[bA_channel.length + bA_gain.length];
            System.arraycopy(bA_channel, 0, bA_Params, 0, bA_channel.length);
            System.arraycopy(bA_gain, 0, bA_Params, bA_channel.length, bA_gain.length);
            byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_AMP_GAIN_INPUT_LINEAR, UDP_SET, bA_Params);
            addSTVCommandChannel(STV_Command);
            bA_gain = null;
            bA_channel = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    @Override
    public byte setAmpLoudnessEnable(byte channel, boolean enable)
            throws DriverException {
        if (channel < 1 || channel > STV_Info.num_canales) {
            return 2;
        } else {
            byte bA_channel[] = new byte[1];
            byte bA_enable[] = new byte[1];
            bA_channel[0] = channel;
            bA_enable[0] = myCByte(enable);
            byte bA_Params[] = new byte[bA_channel.length + bA_enable.length];
            System.arraycopy(bA_channel, 0, bA_Params, 0, bA_channel.length);
            System.arraycopy(bA_enable, 0, bA_Params, bA_channel.length, bA_enable.length);
            byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_AMP_ENABLE_LOUDNESS, UDP_SET, bA_Params);
            addSTVCommandChannel(STV_Command);
            bA_enable = null;
            bA_channel = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    @Override
    public byte setAmpChMute(byte channel, boolean mute)
            throws DriverException {
        if (channel < 1 || channel > STV_Info.num_canales) {
            return 2;
        } else {
            byte bA_channel[] = new byte[1];
            byte bA_mute[] = new byte[1];
            bA_channel[0] = channel;
            bA_mute[0] = myCByte(mute);
            byte bA_Params[] = new byte[bA_channel.length + bA_mute.length];
            System.arraycopy(bA_channel, 0, bA_Params, 0, bA_channel.length);
            System.arraycopy(bA_mute, 0, bA_Params, bA_channel.length, bA_mute.length);
            byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_AMP_MUTE_CH, UDP_SET, bA_Params);
            addSTVCommandChannel(STV_Command);
            bA_channel = null;
            bA_mute = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    @Override
    public byte setCobraNet(byte channel, int addr_bundle, byte input_ch)
            throws DriverException {
        if (channel < 1 || channel > STV_Info.num_canales) {
            return 2;
        }
        if (input_ch > 8) {
            return 2;
        }
        if (input_ch == 0) {
            input_ch = 1;
        }
        byte ba_channel[] = new byte[1];
        byte bA_input_ch[] = new byte[1];
        ba_channel[0] = channel;
        byte bA_addr_bundle[] = getByteUshort(addr_bundle);
        invertir(bA_addr_bundle);
        bA_input_ch[0] = input_ch;
        byte bA_Params[] = new byte[ba_channel.length + bA_addr_bundle.length + bA_input_ch.length];
        System.arraycopy(ba_channel, 0, bA_Params, 0, ba_channel.length);
        System.arraycopy(bA_addr_bundle, 0, bA_Params, ba_channel.length, bA_addr_bundle.length);
        System.arraycopy(bA_input_ch, 0, bA_Params, ba_channel.length + bA_addr_bundle.length, bA_input_ch.length);
        byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_COBRANET, UDP_SET, bA_Params);
        addSTVCommandChannel(STV_Command);
        ba_channel = null;
        bA_addr_bundle = null;
        bA_input_ch = null;
        bA_Params = null;
        STV_Command = null;
        return 1;
    }

    @Override
    public byte setAmpPresets(byte channel, byte action)
            throws DriverException {
        if ((channel < 1 || channel > STV_Info.num_canales) && channel != 80) {
            return 2;
        }
        if (action < 1 || action > 3) {
            return 2;
        } else {
            byte bA_channel[] = new byte[1];
            byte bA_action[] = new byte[1];
            bA_channel[0] = channel;
            bA_action[0] = action;
            byte bA_Params[] = new byte[bA_channel.length + bA_action.length];
            System.arraycopy(bA_channel, 0, bA_Params, 0, bA_channel.length);
            System.arraycopy(bA_action, 0, bA_Params, bA_action.length, bA_action.length);
            byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_AMP_PRESETS, UDP_SET, bA_Params);
            addSTVCommandChannel(STV_Command);
            bA_Params = null;
            bA_channel = null;
            bA_action = null;
            STV_Command = null;
            return 1;
        }
    }

    @Override
    public byte setCobraNetSourceName(byte channel, String nombre)
            throws DriverException, UnsupportedEncodingException {
        if (channel < 1 || channel > STV_Info.num_canales) {
            return 2;
        }
        nombre = nombre.trim();
        if (nombre.length() > 19) {
            return 2;
        } else {
            byte ba_channel[] = new byte[1];
            byte bA_nombre[] = new byte[nombre.length() + 1];
            ba_channel[0] = channel;
            System.arraycopy(nombre.getBytes(config.getString("PAGE_CODE")), 0, bA_nombre, 0, nombre.length());
            bA_nombre[nombre.length()] = 0;
            byte bA_Params[] = new byte[ba_channel.length + bA_nombre.length];
            System.arraycopy(ba_channel, 0, bA_Params, 0, ba_channel.length);
            System.arraycopy(bA_nombre, 0, bA_Params, ba_channel.length, bA_nombre.length);
            byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_COBRANET_NOMBRE_FUENTE, UDP_SET, bA_Params);
            addSTVCommandChannel(STV_Command);
            ba_channel = null;
            bA_nombre = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    @Override
    public byte setCobraNetZoneName(byte channel, String nombre)
            throws DriverException, UnsupportedEncodingException {
        if (channel < 1 || channel > STV_Info.num_canales) {
            return 2;
        }
        nombre = nombre.trim();
        if (nombre.length() > 19) {
            return 2;
        } else {
            byte ba_channel[] = new byte[1];
            byte bA_nombre[] = new byte[nombre.length() + 1];
            ba_channel[0] = channel;
            System.arraycopy(nombre.getBytes(config.getString("PAGE_CODE")), 0, bA_nombre, 0, nombre.length());
            bA_nombre[nombre.length()] = 0;
            byte bA_Params[] = new byte[ba_channel.length + bA_nombre.length];
            System.arraycopy(ba_channel, 0, bA_Params, 0, ba_channel.length);
            System.arraycopy(bA_nombre, 0, bA_Params, ba_channel.length, bA_nombre.length);
            byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_COBRANET_NOMBRE_ZONA, UDP_SET, bA_Params);
            addSTVCommandChannel(STV_Command);
            ba_channel = null;
            bA_nombre = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    @Override
    public byte setSTVModel(byte model)
            throws DriverException {
        if (model < 1 || model > 5) {
            return 2;
        } else {
            byte bA_model[] = new byte[1];
            bA_model[0] = model;
            byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_MODEL_STV, UDP_SET, bA_model);
            addSTVCommand(STV_Command);
            bA_model = null;
            STV_Command = null;
            return 1;
        }
    }

    @Override
    public byte setSTVModeLimiter(byte mode)
            throws DriverException {
        if (mode > 1) {
            return 2;
        } else {
            byte bA_mode[] = new byte[1];
            bA_mode[0] = mode;
            byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_MODE_LIMITER, UDP_SET, bA_mode);
            addSTVCommand(STV_Command);
            bA_mode = null;
            STV_Command = null;
            return 1;
        }
    }

    @Override
    public byte setCM2Enable(boolean enable)
            throws DriverException {
        byte bA_enable[] = new byte[1];
        bA_enable[0] = myCByte(enable);
        byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_ENABLE_CM2, UDP_SET, bA_enable);
        addSTVCommand(STV_Command);
        bA_enable = null;
        STV_Command = null;
        return 1;
    }

    @Override
    public byte setSDCardEnable(boolean enable)
            throws DriverException {
        byte bA_enable[] = new byte[1];
        bA_enable[0] = myCByte(enable);
        byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_ENABLE_SDCARD, UDP_SET, bA_enable);
        addSTVCommand(STV_Command);
        bA_enable = null;
        STV_Command = null;
        return 1;
    }

    @Override
    public byte setPowerOn(boolean power_on)
            throws DriverException {
        byte bA_power_on[] = new byte[1];
        bA_power_on[0] = myCByte(power_on);
        byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_POWER_ON, UDP_SET, bA_power_on);
        addSTVCommand(STV_Command);
        bA_power_on = null;
        STV_Command = null;
        return 1;
    }

    @Override
    public byte setSoftwareReset()
            throws DriverException {
        byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_SOFTWARE_RESET, UDP_SET, null);
        addSTVCommand(STV_Command);
        STV_Command = null;
        return 1;
    }

    @Override
    public byte setEtherNetEnable(boolean enable)
            throws DriverException {
        byte bA_enable[] = new byte[1];
        bA_enable[0] = myCByte(enable);
        byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_ENABLE_ETHERNET, UDP_SET, bA_enable);
        addSTVCommand(STV_Command);
        bA_enable = null;
        STV_Command = null;
        return 1;
    }

    @Override
    public byte setFrontalLogo(byte logo[])
            throws DriverException {
        byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_FRONTAL_LOGO, UDP_SET, logo);
        addSTVCommand(STV_Command);
        STV_Command = null;
        return 1;
    }

    @Override
    public byte setDeleteFrontalLogo()
            throws DriverException {
        byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_FRONTAL_BORRAR_LOGO, UDP_SET, null);
        addSTVCommand(STV_Command);
        STV_Command = null;
        return 1;
    }

    @Override
    public byte setDelayBootSource(byte delay)
            throws DriverException {
        byte bA_delay[] = new byte[1];
        bA_delay[0] = delay;
        byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_DELAY_ARRANQUE, UDP_SET, bA_delay);
        addSTVCommand(STV_Command);
        bA_delay = null;
        STV_Command = null;
        return 1;
    }

    @Override
    public byte setSettingSource(boolean enable)
            throws DriverException {
        byte bA_enable[] = new byte[1];
        bA_enable[0] = myCByte(enable);
        byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_SENSADO_FUENTE, UDP_SET, bA_enable);
        addSTVCommand(STV_Command);
        bA_enable = null;
        STV_Command = null;
        return 1;
    }

    @Override
    public byte setAmpFilterPrio(byte boost, int frec, int q_slope, byte gain)
            throws DriverException {
        if (boost < -10 || boost > 10) {
            return 2;
        }
        if (frec < 3 || frec > 60000) {
            return 2;
        }
        if (q_slope > 5100) {
            return 2;
        }
        if (gain < -15 || gain > 15) {
            return 2;
        } else {
            byte bA_boost[] = new byte[1];
            byte bA_gain[] = new byte[1];
            bA_boost[0] = boost;
            byte bA_frec[] = getByteUshort(frec);
            invertir(bA_frec);
            byte bA_q_slope[] = getByteUshort(q_slope);
            invertir(bA_q_slope);
            bA_gain[0] = gain;
            byte bA_Params[] = new byte[bA_boost.length + bA_frec.length + bA_q_slope.length + bA_gain.length];
            System.arraycopy(bA_boost, 0, bA_Params, 0, bA_boost.length);
            System.arraycopy(bA_frec, 0, bA_Params, bA_boost.length, bA_frec.length);
            System.arraycopy(bA_q_slope, 0, bA_Params, bA_boost.length + bA_frec.length, bA_q_slope.length);
            System.arraycopy(bA_gain, 0, bA_Params, bA_boost.length + bA_frec.length + bA_q_slope.length, bA_gain.length);
            byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_AMP_FILTER_PRIO, UDP_SET, bA_Params);
            addSTVCommand(STV_Command);
            bA_boost = null;
            bA_frec = null;
            bA_q_slope = null;
            bA_gain = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    @Override
    public byte setAmpGainLinearPrioInput(short gain)
            throws DriverException {
        if (gain < -1500 || gain > 1200) {
            return 2;
        } else {
            byte bA_gain[] = getByteShort(gain);
            invertir(bA_gain);
            byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_AMP_GAIN_INPUT_LINEAR_PRIO, UDP_SET, bA_gain);
            addSTVCommand(STV_Command);
            bA_gain = null;
            STV_Command = null;
            return 1;
        }
    }

    @Override
    public byte setAmpGainPrio(byte gain)
            throws DriverException {
        if (gain < -100 || gain > 0) {
            return 2;
        } else {
            byte bA_gain[] = new byte[1];
            bA_gain[0] = gain;
            byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_AMP_GAIN_PRIO, UDP_SET, bA_gain);
            addSTVCommand(STV_Command);
            bA_gain = null;
            STV_Command = null;
            return 1;
        }
    }

    @Override
    public byte setAmpAllMute(boolean mute)
            throws DriverException {
        byte bA_mute[] = new byte[1];
        bA_mute[0] = myCByte(mute);
        byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_AMP_MUTE_ALL, UDP_SET, bA_mute);
        addSTVCommand(STV_Command);
        bA_mute = null;
        STV_Command = null;
        return 1;
    }

    @Override
    public byte setAmpCobraNetPrio(int addr_bundle, byte input_ch)
            throws DriverException {
        if (input_ch > 8) {
            return 2;
        } else {
            byte bA_input_ch[] = new byte[1];
            byte bA_addr_bundle[] = getByteUshort(addr_bundle);
            invertir(bA_addr_bundle);
            bA_input_ch[0] = input_ch;
            byte bA_Params[] = new byte[bA_addr_bundle.length + bA_input_ch.length];
            System.arraycopy(bA_addr_bundle, 0, bA_Params, 0, bA_addr_bundle.length);
            System.arraycopy(bA_input_ch, 0, bA_Params, bA_addr_bundle.length, bA_input_ch.length);
            byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_COBRANET_PRIO, UDP_SET, bA_Params);
            addSTVCommand(STV_Command);
            bA_addr_bundle = null;
            bA_input_ch = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    @Override
    public byte setAmpModeAudioInput(boolean digital_input)
            throws DriverException {
        byte bA_digital_input[] = new byte[1];
        bA_digital_input[0] = myCByte(digital_input);
        byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_AMP_MODE_AUDIO_INPUT, UDP_SET, bA_digital_input);
        addSTVCommand(STV_Command);
        bA_digital_input = null;
        STV_Command = null;
        return 1;
    }

    @Override
    public byte setAmpCobraNetPrioModeEnable(boolean enable)
            throws DriverException {
        byte bA_enable[] = new byte[1];
        bA_enable[0] = myCByte(enable);
        byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_AMP_ENABLE_COBRANET_PRIO, UDP_SET, bA_enable);
        addSTVCommand(STV_Command);
        bA_enable = null;
        STV_Command = null;
        return 1;
    }

    @Override
    public byte setAmpModePrioActive(boolean signal_presense)
            throws DriverException {
        byte bA_signal_presense[] = new byte[1];
        bA_signal_presense[0] = myCByte(signal_presense);
        byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_AMP_MODE_ACTIVE_PRIO, UDP_SET, bA_signal_presense);
        addSTVCommand(STV_Command);
        bA_signal_presense = null;
        STV_Command = null;
        return 1;
    }

    @Override
    public byte setAmpLevelPrioActive(boolean High)
            throws DriverException {
        byte bA_High[] = new byte[1];
        bA_High[0] = myCByte(High);
        byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_AMP_LEVEL_ACTIVE_PRIO, UDP_SET, bA_High);
        addSTVCommand(STV_Command);
        bA_High = null;
        STV_Command = null;
        return 1;
    }

    @Override
    public byte setAmpThresHoldActivePrio(byte threshold)
            throws DriverException {
        if (threshold < -100 || threshold > 20) {
            return 2;
        } else {
            byte bA_threshold[] = new byte[1];
            bA_threshold[0] = threshold;
            byte STV_Command[] = convertCommand2STVProtocol(STV_COMMAND_SET_AMP_THRESHOLD_ACTIVE_PRIO, UDP_SET, bA_threshold);
            addSTVCommand(STV_Command);
            bA_threshold = null;
            STV_Command = null;
            return 1;
        }
    }

    @Override
    public String getSTVLog()
            throws DriverException {
        String Cadena = "";
        String aux = "";
        for (byte i = 0; i <= 49 && bv(STV_Info.Log[i][0]) != 255; i++) {
            if (STV_Info.Log[i][0] == 4) {
                if ((bv(STV_Info.Log[i][1]) & 1) == 1) {
                    aux = (new StringBuilder()).append(STV_STRING_ERR[STV_Info.Log[i][0]][1]).append("\n").toString();
                    if (Cadena.toLowerCase().indexOf(aux.toLowerCase()) == -1) {
                        Cadena = (new StringBuilder()).append(Cadena).append(aux).toString();
                    }
                }
                if ((bv(STV_Info.Log[i][1]) & 2) == 2) {
                    aux = (new StringBuilder()).append(STV_STRING_ERR[STV_Info.Log[i][0]][2]).append("\n").toString();
                    if (Cadena.toLowerCase().indexOf(aux.toLowerCase()) == -1) {
                        Cadena = (new StringBuilder()).append(Cadena).append(aux).toString();
                    }
                }
                if ((bv(STV_Info.Log[i][1]) & 4) == 4) {
                    aux = (new StringBuilder()).append(STV_STRING_ERR[STV_Info.Log[i][0]][3]).append("\n").toString();
                    if (Cadena.toLowerCase().indexOf(aux.toLowerCase()) == -1) {
                        Cadena = (new StringBuilder()).append(Cadena).append(aux).toString();
                    }
                }
                if ((bv(STV_Info.Log[i][1]) & 8) == 8) {
                    aux = (new StringBuilder()).append(STV_STRING_ERR[STV_Info.Log[i][0]][4]).append("\n").toString();
                    if (Cadena.toLowerCase().indexOf(aux.toLowerCase()) == -1) {
                        Cadena = (new StringBuilder()).append(Cadena).append(aux).toString();
                    }
                }
                if ((bv(STV_Info.Log[i][1]) & 0x10) == 16) {
                    aux = (new StringBuilder()).append(STV_STRING_ERR[STV_Info.Log[i][0]][5]).append("\n").toString();
                    if (Cadena.toLowerCase().indexOf(aux.toLowerCase()) == -1) {
                        Cadena = (new StringBuilder()).append(Cadena).append(aux).toString();
                    }
                }
                if ((bv(STV_Info.Log[i][1]) & 0x20) == 32) {
                    aux = (new StringBuilder()).append(STV_STRING_ERR[STV_Info.Log[i][0]][6]).append("\n").toString();
                    if (Cadena.toLowerCase().indexOf(aux.toLowerCase()) == -1) {
                        Cadena = (new StringBuilder()).append(Cadena).append(aux).toString();
                    }
                }
                if ((bv(STV_Info.Log[i][1]) & 0x40) != 64) {
                    continue;
                }
                aux = (new StringBuilder()).append(STV_STRING_ERR[STV_Info.Log[i][0]][7]).append("\n").toString();
                if (Cadena.toLowerCase().indexOf(aux.toLowerCase()) == -1) {
                    Cadena = (new StringBuilder()).append(Cadena).append(aux).toString();
                }
                continue;
            }
            aux = (new StringBuilder()).append(STV_STRING_ERR[STV_Info.Log[i][0]][STV_Info.Log[i][1]]).append("\n").toString();
            if (Cadena.toLowerCase().indexOf(aux.toLowerCase()) == -1) {
                Cadena = (new StringBuilder()).append(Cadena).append(aux).toString();
            }
        }

        return Cadena;
    }

    private void processSTVSyncCommand(byte comando[])
            throws DriverException {
        byte backup[] = new byte[comando.length + 1];
        byte numComando[] = new byte[2];
        System.arraycopy(comando, 0, backup, 0, comando.length);
        numComando[0] = backup[3];
        numComando[1] = backup[2];
        if (compareByteArray(getByteUshort(STV_COMMAND_GET_INFO), numComando)) {
            processSTVInfo(backup);
        } else if (compareByteArray(getByteUshort(STV_COMMAND_GET_LOG), numComando)) {
            processSTVLog(backup);
        }
        numComando = null;
    }

    private void processSTVASyncCommand(byte comando[])
            throws DriverException {
        byte numComando[] = new byte[2];
        numComando[0] = comando[3];
        numComando[1] = comando[2];
        numComando = null;
    }

    private void processSTVInfo(byte Comando[])
            throws DriverException {
        int aux = 0;
        int k = 8;
        byte arrayAux[] = new byte[4];
        if (Comando[6] == 79 && Comando[7] == 75) {
            for (int i = 0; i <= 3; i++) {
                aux = bv(Comando[k]) * pow(2, 8) + bv(Comando[k + 1]);
                STV_Info.usCM2_TxBundle[i] = aux;
                k += 2;
            }

            for (int i = 0; i <= 7; i++) {
                aux = bv(Comando[k]) * pow(2, 8) + bv(Comando[k + 1]);
                STV_Info.usCM2_RxBundle[i] = aux;
                k += 2;
            }

            for (int i = 0; i <= 3; i++) {
                for (int j = 0; j <= 7; j++) {
                    STV_Info.ucCM2_TxSubMap[i][j] = Comando[k];
                    k++;
                }

            }

            for (int i = 0; i <= 7; i++) {
                for (int j = 0; j <= 7; j++) {
                    STV_Info.ucCM2_RxSubMap[i][j] = Comando[k];
                    k++;
                }

            }

            for (int i = 0; i <= 15; i++) {
                STV_Info.ucCM2_Salida[i] = Comando[k];
                k++;
            }

            STV_Info.errF_ALIM_180 = Comando[k];
            k++;
            STV_Info.errF_ALIM_240 = Comando[k];
            k++;
            STV_Info.nArranques = (long) (bv(Comando[k]) * pow(2, 24) + bv(Comando[k + 1]) * pow(2, 16) + bv(Comando[k + 2]) * pow(2, 8) + bv(Comando[k + 3])) & Long.valueOf("4294967295").longValue();
            k += 4;
            STV_Info.lenguaje_ES = cbool(Comando[k]);
            k++;
            STV_Info.num_canales = Comando[k];
            k++;
            STV_Info.hay_SD = cbool(Comando[k]);
            k++;
            STV_Info.hay_EtherNet = cbool(Comando[k]);
            k++;
            STV_Info.hay_CobraNet = cbool(Comando[k]);
            k++;
            STV_Info.tipo_Puerto_Serie = Comando[k];
            k++;
            STV_Info.dos_canales_por_dis = cbool(Comando[k]);
            k++;
            STV_Info.pot_canal = Comando[k];
            k++;
            STV_Info.tension_nominal = Comando[k];
            k++;
            STV_Info.corriente_nominal = Comando[k];
            k++;
            STV_Info.impedancia_nominal = Comando[k];
            k++;
            STV_Info.Entrada_Digital = cbool(Comando[k]);
            k++;
            for (int i = 0; i <= 1; i++) {
                for (int j = 0; j <= 1; j++) {
                    k++;
                }

            }

            for (int i = 0; i <= 1; i++) {
                for (int j = 0; j <= 1; j++) {
                    STV_Info.modAmp[i].Canal[j].Impedancia_Configurada = Comando[k];
                    k++;
                }

            }

            for (int i = 0; i <= 1; i++) {
                for (int j = 0; j <= 1; j++) {
                    STV_Info.modAmp[i].Canal[j].Limite_Corto = Comando[k];
                    k++;
                }

            }

            for (int i = 0; i <= 1; i++) {
                for (int j = 0; j <= 1; j++) {
                    STV_Info.modAmp[i].Canal[j].Limite_Abierto = Comando[k];
                    k++;
                }

            }

            for (int i = 0; i <= 1; i++) {
                for (int j = 0; j <= 1; j++) {
                    STV_Info.modAmp[i].Canal[j].Limitador_Modo = Comando[k];
                    k++;
                }

            }

            for (int i = 0; i <= 1; i++) {
                for (int j = 0; j <= 1; j++) {
                    for (int l = 0; l <= 19; l++) {
                        STV_Info.modAmp[i].Canal[j].Nombre_Fuente_Cobranet[l] = Comando[k];
                        k++;
                    }

                    k++;
                }

            }

            for (int i = 0; i <= 1; i++) {
                for (int j = 0; j <= 1; j++) {
                    for (int l = 0; l <= 19; l++) {
                        STV_Info.modAmp[i].Canal[j].Nombre_Zona_Cobranet[l] = Comando[k];
                        k++;
                    }

                    k++;
                }

            }

            STV_Info.Prioridad_CobraNet_Habilitada = cbool(Comando[k]);
            k++;
            STV_Info.Trasera_Habilitada = cbool(Comando[k]);
            k++;
            k += 4;
            for (int i = 0; i <= 1; i++) {
                for (int j = 0; j <= 1; j++) {
                    STV_Info.modAmp[i].Canal[j].PresetFabrica = !cbool(Comando[k]);
                    k++;
                    STV_Info.modAmp[i].Canal[j].GainOutput = Comando[k];
                    k++;
                    STV_Info.modAmp[i].Canal[j].GainInput = Comando[k];
                    k += 2;
                    STV_Info.modAmp[i].Canal[j].EnableFilter = cbool(Comando[k]);
                    k++;
                    STV_Info.modAmp[i].Canal[j].FrecFilter = bv(Comando[k]) * pow(2, 8) + bv(Comando[k + 1]);
                    k += 2;
                    STV_Info.modAmp[i].Canal[j].GainFilter = Comando[k];
                    k++;
                    STV_Info.modAmp[i].Canal[j].EnableLimiter = cbool(Comando[k]);
                    k++;
                    STV_Info.modAmp[i].Canal[j].ThresHoldLimiter = Comando[k];
                    k++;
                    STV_Info.modAmp[i].Canal[j].TCLimiter = bv(Comando[k]) * pow(2, 8) + bv(Comando[k + 1]);
                    k += 2;
                    STV_Info.modAmp[i].Canal[j].Decaylimiter = Comando[k];
                    k++;
                    STV_Info.modAmp[i].Canal[j].EnableEq = cbool(Comando[k]);
                    k++;
                    for (int l = 0; l <= 6; l++) {
                        STV_Info.modAmp[i].Canal[j].BoostEq[l] = Comando[k];
                        k++;
                        STV_Info.modAmp[i].Canal[j].FreqEq[l] = bv(Comando[k]) * pow(2, 8) + bv(Comando[k + 1]);
                        k += 2;
                        STV_Info.modAmp[i].Canal[j].Q_SlopeEq[l] = bv(Comando[k]) * pow(2, 8) + bv(Comando[k + 1]);
                        k += 2;
                        STV_Info.modAmp[i].Canal[j].GainEq[l] = Comando[k];
                        k++;
                    }

                    STV_Info.modAmp[i].Canal[j].EnableTone = cbool(Comando[k]);
                    k++;
                    STV_Info.modAmp[i].Canal[j].GainTone = Comando[k];
                    k++;
                    STV_Info.modAmp[i].Canal[j].FreqTone = bv(Comando[k]) * pow(2, 8) + bv(Comando[k + 1]);
                    k += 2;
                    STV_Info.modAmp[i].Canal[j].DC = myCShort(bv(Comando[k]) * pow(2, 8) + bv(Comando[k + 1]));
                    k += 2;
                    STV_Info.modAmp[i].Canal[j].GainLinearInput = myCShort(bv(Comando[k]) * pow(2, 8) + bv(Comando[k + 1]));
                    k += 2;
                    STV_Info.modAmp[i].Canal[j].EnableLoudNess = cbool(Comando[k]);
                    k += 7;
                    STV_Info.modAmp[i].Canal[j].Autotest_Habilitado = cBooltoByte(cbool(Comando[k]));
                    k++;
                    getCM2StateByChannel((byte) (2 * i + j + 1), (byte) i, (byte) j);
                }

                STV_Info.modAmp[i].Prio.PresetFabrica = !cbool(Comando[k]);
                k++;
                STV_Info.modAmp[i].Prio.BoostFilterPrio = Comando[k];
                k++;
                STV_Info.modAmp[i].Prio.FrecFilterPrio = bv(Comando[k]) * pow(2, 8) + bv(Comando[k + 1]);
                k += 2;
                STV_Info.modAmp[i].Prio.Q_SlopeFilterPrio = bv(Comando[k]) * pow(2, 8) + bv(Comando[k + 1]);
                k += 2;
                STV_Info.modAmp[i].Prio.GainFilterPrio = Comando[k];
                k++;
                STV_Info.modAmp[i].Prio.GainLinearInputPrio = myCShort(bv(Comando[k]) * pow(2, 8) + bv(Comando[k + 1]));
                k += 2;
                STV_Info.modAmp[i].Prio.GainPrio = Comando[k];
                k++;
                STV_Info.modAmp[i].Prio.Activacion_5V = cbool(Comando[k]);
                if (i == 0) {
                    STV_Info.Prioridad_Activacion_5V = STV_Info.modAmp[i].Prio.Activacion_5V;
                }
                k++;
                STV_Info.modAmp[i].Prio.Detec19KHzHabilitado = cbool(Comando[k]);
                k++;
                STV_Info.modAmp[i].Prio.UmbralTension19Khz = bv(Comando[k]) * pow(2, 8) + bv(Comando[k + 1]);
                k += 2;
                k++;
                if (i == 0) {
                    STV_Info.Prioridad_Modo_Presencia = cbool(Comando[k]);
                }
                k++;
                if (i == 0) {
                    STV_Info.Prioridad_Umbral_activacion = Comando[k];
                }
                k++;
                STV_Info.modAmp[i].Prio.Direccion_Bundle_Cobranet = STV_Info.usCM2_RxBundle[7];
                STV_Info.modAmp[i].Prio.Canal_Bundle_Cobranet = 0;
                for (int j = 0; j <= 7; j++) {
                    if (STV_Info.ucCM2_RxSubMap[7][j] == 40) {
                        STV_Info.modAmp[i].Prio.Canal_Bundle_Cobranet = j + 1;
                    }
                }

            }

            for (int i = 0; i <= 1; i++) {
                STV_Info.modAmp[i].Canal[0].Sense.tensionRamaPositiva = bytesToUInt32(Comando, k);
                k += 4;
                STV_Info.modAmp[i].Canal[0].Sense.tensionRamaNegativa = bytesToUInt32(Comando, k);
                k += 4;
                STV_Info.modAmp[i].Canal[0].Sense.corrienteRamaPositiva = bytesToUInt32(Comando, k);
                k += 4;
                STV_Info.modAmp[i].Canal[0].Sense.corrienteRamaNegativa = bytesToUInt32(Comando, k);
                k += 4;
                STV_Info.modAmp[i].Canal[1].Sense.tensionRamaPositiva = bytesToUInt32(Comando, k);
                k += 4;
                STV_Info.modAmp[i].Canal[1].Sense.tensionRamaNegativa = bytesToUInt32(Comando, k);
                k += 4;
                STV_Info.modAmp[i].Canal[1].Sense.corrienteRamaPositiva = bytesToUInt32(Comando, k);
                k += 4;
                STV_Info.modAmp[i].Canal[1].Sense.corrienteRamaNegativa = bytesToUInt32(Comando, k);
                k += 4;
                STV_Info.modAmp[i].Canal[0].Sense.tensionVpp = bytesToUInt32(Comando, k);
                k += 4;
                STV_Info.modAmp[i].Canal[1].Sense.tensionVpp = bytesToUInt32(Comando, k);
                k += 4;
                STV_Info.modAmp[i].Canal[0].Sense.corrienteVpp = bytesToUInt32(Comando, k);
                k += 4;
                STV_Info.modAmp[i].Canal[1].Sense.corrienteVpp = bytesToUInt32(Comando, k);
                k += 4;
                STV_Info.modAmp[i].Canal[0].Sense.clipRamaPositiva = Comando[k];
                k++;
                STV_Info.modAmp[i].Canal[0].Sense.clipRamaNegativa = Comando[k];
                k++;
                STV_Info.modAmp[i].Canal[1].Sense.clipRamaPositiva = Comando[k];
                k++;
                STV_Info.modAmp[i].Canal[1].Sense.clipRamaNegativa = Comando[k];
                k++;
                STV_Info.modAmp[i].Canal[0].Sense.dc = Comando[k];
                k++;
                STV_Info.modAmp[i].Canal[1].Sense.dc = Comando[k];
                k++;
                STV_Info.modAmp[i].Canal[0].Sense.vumetroEntradaRMS = bytesToInt16(Comando, k);
                if (STV_Info.modAmp[i].Canal[0].Sense.vumetroEntradaRMS < -40) {
                    STV_Info.modAmp[i].Canal[0].Sense.vumetroEntradaRMS = -40;
                } else if (STV_Info.modAmp[i].Canal[0].Sense.vumetroEntradaRMS > 0) {
                    STV_Info.modAmp[i].Canal[0].Sense.vumetroEntradaRMS = 0;
                }
                k += 2;
                STV_Info.modAmp[i].Canal[1].Sense.vumetroEntradaRMS = bytesToInt16(Comando, k);
                if (STV_Info.modAmp[i].Canal[1].Sense.vumetroEntradaRMS < -40) {
                    STV_Info.modAmp[i].Canal[1].Sense.vumetroEntradaRMS = -40;
                } else if (STV_Info.modAmp[i].Canal[1].Sense.vumetroEntradaRMS > 0) {
                    STV_Info.modAmp[i].Canal[1].Sense.vumetroEntradaRMS = 0;
                }
                k += 2;
                STV_Info.modAmp[i].Canal[0].Sense.vumetroEntradaPEAK = bytesToInt16(Comando, k);
                if (STV_Info.modAmp[i].Canal[0].Sense.vumetroEntradaPEAK < -40) {
                    STV_Info.modAmp[i].Canal[0].Sense.vumetroEntradaPEAK = -40;
                } else if (STV_Info.modAmp[i].Canal[0].Sense.vumetroEntradaPEAK > 0) {
                    STV_Info.modAmp[i].Canal[0].Sense.vumetroEntradaPEAK = 0;
                }
                k += 2;
                STV_Info.modAmp[i].Canal[1].Sense.vumetroEntradaPEAK = bytesToInt16(Comando, k);
                if (STV_Info.modAmp[i].Canal[1].Sense.vumetroEntradaPEAK < -40) {
                    STV_Info.modAmp[i].Canal[1].Sense.vumetroEntradaPEAK = -40;
                } else if (STV_Info.modAmp[i].Canal[1].Sense.vumetroEntradaPEAK > 0) {
                    STV_Info.modAmp[i].Canal[1].Sense.vumetroEntradaPEAK = 0;
                }
                k += 2;
                STV_Info.modAmp[i].Canal[0].Sense.vumetroSalidaRMS = bytesToInt16(Comando, k);
                if (STV_Info.modAmp[i].Canal[0].Sense.vumetroSalidaRMS < -40) {
                    STV_Info.modAmp[i].Canal[0].Sense.vumetroSalidaRMS = -40;
                } else if (STV_Info.modAmp[i].Canal[0].Sense.vumetroSalidaRMS > 0) {
                    STV_Info.modAmp[i].Canal[0].Sense.vumetroSalidaRMS = 0;
                }
                k += 2;
                STV_Info.modAmp[i].Canal[1].Sense.vumetroSalidaRMS = bytesToInt16(Comando, k);
                if (STV_Info.modAmp[i].Canal[1].Sense.vumetroSalidaRMS < -40) {
                    STV_Info.modAmp[i].Canal[1].Sense.vumetroSalidaRMS = -40;
                } else if (STV_Info.modAmp[i].Canal[1].Sense.vumetroSalidaRMS > 0) {
                    STV_Info.modAmp[i].Canal[1].Sense.vumetroSalidaRMS = 0;
                }
                k += 2;
                STV_Info.modAmp[i].Canal[0].Sense.vumetroSalidaPEAK = bytesToInt16(Comando, k);
                if (STV_Info.modAmp[i].Canal[0].Sense.vumetroSalidaPEAK < -40) {
                    STV_Info.modAmp[i].Canal[0].Sense.vumetroSalidaPEAK = -40;
                } else if (STV_Info.modAmp[i].Canal[0].Sense.vumetroSalidaPEAK > 0) {
                    STV_Info.modAmp[i].Canal[0].Sense.vumetroSalidaPEAK = 0;
                }
                k += 2;
                STV_Info.modAmp[i].Canal[1].Sense.vumetroSalidaPEAK = bytesToInt16(Comando, k);
                if (STV_Info.modAmp[i].Canal[1].Sense.vumetroSalidaPEAK < -40) {
                    STV_Info.modAmp[i].Canal[1].Sense.vumetroSalidaPEAK = -40;
                } else if (STV_Info.modAmp[i].Canal[1].Sense.vumetroSalidaPEAK > 0) {
                    STV_Info.modAmp[i].Canal[1].Sense.vumetroSalidaPEAK = 0;
                }
                k += 2;
                STV_Info.modAmp[i].Canal[0].Sense.tensionRMSdB = bytesToInt16(Comando, k);
                if (STV_Info.modAmp[i].Canal[0].Sense.tensionRMSdB < -40) {
                    STV_Info.modAmp[i].Canal[0].Sense.tensionRMSdB = -40;
                } else if (STV_Info.modAmp[i].Canal[0].Sense.tensionRMSdB > 0) {
                    STV_Info.modAmp[i].Canal[0].Sense.tensionRMSdB = 0;
                }
                k += 2;
                STV_Info.modAmp[i].Canal[1].Sense.tensionRMSdB = bytesToInt16(Comando, k);
                if (STV_Info.modAmp[i].Canal[1].Sense.tensionRMSdB < -40) {
                    STV_Info.modAmp[i].Canal[1].Sense.tensionRMSdB = -40;
                } else if (STV_Info.modAmp[i].Canal[1].Sense.tensionRMSdB > 0) {
                    STV_Info.modAmp[i].Canal[1].Sense.tensionRMSdB = 0;
                }
                k += 2;
                STV_Info.modAmp[i].NewSense = Comando[k];
                k++;
            }

            for (int i = 0; i <= 1; i++) {
                for (int j = 0; j <= 1; j++) {
                    STV_Info.modAmp[i].Canal[j].Temp.temp = Comando[k];
                    k++;
                    STV_Info.modAmp[i].Canal[j].Temp.stateVent = Comando[k];
                    k++;
                    STV_Info.modAmp[i].Canal[j].Temp.tempPlaca = Comando[k];
                    k++;
                }

                STV_Info.modAmp[i].tempAmb = Comando[k];
                k++;
                STV_Info.modAmp[i].StateVentAmb = Comando[k];
                k++;
                STV_Info.modAmp[i].Canal[0].Mute = Comando[k];
                k++;
                STV_Info.modAmp[i].Canal[1].Mute = Comando[k];
                k++;
                STV_Info.modAmp[i].Prio.Detect19Khz = cbool(Comando[k]);
                k++;
                STV_Info.modAmp[i].Prio.PrioActiva = cbool(Comando[k]);
                k++;
                STV_Info.modAmp[i].stateInfo = bytesToUInt32(Comando, k);
                k += 4;
                STV_Info.modAmp[i].Canal[0].Protect = cInttoBool(STV_Info.modAmp[i].stateInfo & 64L);
                STV_Info.modAmp[i].Canal[1].Protect = cInttoBool(STV_Info.modAmp[i].stateInfo & 128L);
                if (Comando[k] == 2 || Comando[k] == 5 || Comando[k] == 6) {
                    STV_Info.modAmp[i].Canal[0].State_Line = Comando[k];
                }
                k++;
                if (Comando[k] == 2 || Comando[k] == 5 || Comando[k] == 6) {
                    STV_Info.modAmp[i].Canal[1].State_Line = Comando[k];
                }
                k++;
            }

            STV_Info.Power_On = cbool(Comando[k]);
            k++;
            STV_Info.Prioridad_CobraNet_Activa = cbool(Comando[k]);
            k++;
            STV_Info.Clave = bv(Comando[k]) * pow(2, 8) + bv(Comando[k + 1]);
            k += 2;
            for (int i = 0; i <= 3; i++) {
                STV_Info.bCM2_Status_Bundle_Ch[i] = cbool(Comando[k]);
                k++;
            }

            for (int i = 0; i <= 31; i++) {
                STV_Info.Errores[i] = Comando[k];
                k++;
            }

            STV_Info.Version = (new StringBuilder()).append(Character.toString((char) bv(Comando[k]))).append(Character.toString((char) bv(Comando[k + 1]))).append(Character.toString((char) bv(Comando[k + 2]))).append(Character.toString((char) bv(Comando[k + 3]))).append(Character.toString((char) bv(Comando[k + 4]))).toString();
            k += 5;
            STV_Info.Hay_Logo = Comando[k] == 0;
            k++;
            arrayAux[3] = Comando[k];
            arrayAux[2] = Comando[k + 1];
            arrayAux[1] = Comando[k + 2];
            arrayAux[0] = Comando[k + 3];
            STV_Info.FNTE_ALIM_12V = toSingle(arrayAux, 0);
            k += 4;
            arrayAux[3] = Comando[k];
            arrayAux[2] = Comando[k + 1];
            arrayAux[1] = Comando[k + 2];
            arrayAux[0] = Comando[k + 3];
            STV_Info.FNTE_ALIM_12V_ = toSingle(arrayAux, 0);
            k += 4;
            arrayAux[3] = Comando[k];
            arrayAux[2] = Comando[k + 1];
            arrayAux[1] = Comando[k + 2];
            arrayAux[0] = Comando[k + 3];
            STV_Info.FNTE_ALIM_75VD = toSingle(arrayAux, 0);
            k += 4;
            arrayAux[3] = Comando[k];
            arrayAux[2] = Comando[k + 1];
            arrayAux[1] = Comando[k + 2];
            arrayAux[0] = Comando[k + 3];
            STV_Info.FNTE_ALIM_75VD_ = toSingle(arrayAux, 0);
            k += 4;
            arrayAux[3] = Comando[k];
            arrayAux[2] = Comando[k + 1];
            arrayAux[1] = Comando[k + 2];
            arrayAux[0] = Comando[k + 3];
            STV_Info.FNTE_ALIM_75VI = toSingle(arrayAux, 0);
            k += 4;
            arrayAux[3] = Comando[k];
            arrayAux[2] = Comando[k + 1];
            arrayAux[1] = Comando[k + 2];
            arrayAux[0] = Comando[k + 3];
            STV_Info.FNTE_ALIM_75VI_ = toSingle(arrayAux, 0);
            k += 4;
            arrayAux[3] = Comando[k];
            arrayAux[2] = Comando[k + 1];
            arrayAux[1] = Comando[k + 2];
            arrayAux[0] = Comando[k + 3];
            STV_Info.FNTE_ALIM_230V = toSingle(arrayAux, 0);
            k += 4;
            arrayAux[3] = Comando[k];
            arrayAux[2] = Comando[k + 1];
            arrayAux[1] = Comando[k + 2];
            arrayAux[0] = Comando[k + 3];
            STV_Info.FNTE_ALIM_230I = toSingle(arrayAux, 0);
            k += 4;
            STV_Info.Temp_ETX = Comando[k];
            k++;
            STV_Info.State_Fan_ETX = Comando[k];
            k++;
            STV_Info.modAmp[0].Reintentos_Comunicaciones = bv(Comando[k]) * pow(2, 8) + bv(Comando[k + 1]);
            k += 2;
            STV_Info.modAmp[1].Reintentos_Comunicaciones = bv(Comando[k]) * pow(2, 8) + bv(Comando[k + 1]);
            k += 2;
            STV_Info.DelayArranque = Comando[k];
            k++;
        }
        Comando = null;
        arrayAux = null;
    }

    private void processSTVLog(byte Comando[])
            throws DriverException {
        byte k = 8;
        if (Comando[6] == 79 && Comando[7] == 75) {
            for (byte i = 0; i <= 49; i++) {
                STV_Info.Log[i][0] = Comando[k];
                k++;
                STV_Info.Log[i][1] = Comando[k];
                k++;
            }

        }
        Comando = null;
    }

    private void sendSTVCommand()
            throws DriverException, InterruptedException {
        if (Procesandosend) {
            return;
        }
        Procesandosend = true;
        if (!STV_COMANDO.Busy && list_Command_STV.size() > 0) {
            Semaforo_Lista_STV.acquire();
            STV_COMANDO.Busy = true;
            STV_COMANDO.Comando = new byte[((byte[]) (byte[]) list_Command_STV.get(0)).length];
            System.arraycopy((byte[]) (byte[]) list_Command_STV.get(0), 0, STV_COMANDO.Comando, 0, ((byte[]) (byte[]) list_Command_STV.get(0)).length);
            list_Command_STV.remove(0);
            sckSinc.sendData(STV_COMANDO.Comando);
            tmrTimeOut.start();
            Semaforo_Lista_STV.release();
        } else {
            Thread.sleep(1L);
        }
        Procesandosend = false;
    }

    private void STVInfoRefresh()
            throws DriverException {
        byte STV_Command[] = convertCommand2STVProtocol(1, UDP_GET, null);
        addSTVCommand(STV_Command);
        STV_Command = null;
    }

    private void STVLogRefresh()
            throws DriverException {
        byte STV_Command[] = convertCommand2STVProtocol(2, UDP_GET, null);
        addSTVCommand(STV_Command);
        STV_Command = null;
    }

    private boolean compareByteArray(byte array1[], byte array2[])
            throws DriverException {
        if (array1 == null || array2 == null) {
            return false;
        }
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i <= array1.length - 1; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }

        return true;
    }

    private void clearSTVCommand() {
        STV_COMANDO.Comando = null;
        STV_COMANDO.Busy = false;
        STV_COMANDO.nIntentos = 0;
    }

    private byte[] convertCommand2STVProtocol(int Command, byte RW, byte Param[])
            throws DriverException {
        STVProtocolo trama = new STVProtocolo();
        byte cabecera[] = new byte[6];
        trama.Size = 0;
        if (Param != null) {
            trama.Size += Param.length;
        }
        trama.Command = Command;
        trama.RW = RW;
        byte aux[] = getByteUshort(Command);
        invertir(aux);
        byte aux1[] = getByteUshort(trama.Size);
        invertir(aux1);
        long checksum = aux1[0];
        checksum += aux1[1];
        checksum += aux[0];
        checksum += aux[1];
        checksum += trama.RW;
        if (Param != null) {
            trama.Data = Param;
            for (int i = 0; i <= Param.length - 1; i++) {
                checksum += trama.Data[i];
            }

        }
        checksum %= 256L;
        trama.CheckSum = (byte) (int) checksum;
        cabecera[0] = aux1[0];
        cabecera[1] = aux1[1];
        cabecera[2] = aux[0];
        cabecera[3] = aux[1];
        cabecera[4] = trama.RW;
        cabecera[5] = trama.CheckSum;
        trama = null;
        aux = null;
        aux1 = null;
        if (Param != null) {
            byte bAParams[] = new byte[cabecera.length + Param.length];
            System.arraycopy(cabecera, 0, bAParams, 0, cabecera.length);
            System.arraycopy(Param, 0, bAParams, cabecera.length, Param.length);
            cabecera = null;
            return bAParams;
        } else {
            return cabecera;
        }
    }

    private void addSTVCommand(byte command[]) {
        int Pos = 0;
        try {
            Semaforo_Lista_STV.acquire();
            int N = list_Command_STV.size();
            if (N > 0) {
                for (int i = N - 1; i >= 0; i--) {
                    if (compareByteArray((byte[]) (byte[]) list_Command_STV.get(i), command)) {
                        list_Command_STV.remove(i);
                        if (Pos == 0) {
                            Pos = i;
                        }
                    } else if (((byte[]) (byte[]) list_Command_STV.get(i))[2] == command[2] && ((byte[]) (byte[]) list_Command_STV.get(i))[3] == command[3]) {
                        list_Command_STV.remove(i);
                    }
                }

            }
        } catch (Exception e) {
            logger.error(e);
        }
        if (Pos != 0 && list_Command_STV.size() >= Pos) {
            list_Command_STV.add(Pos, command);
        } else {
            list_Command_STV.add(command);
        }
        Semaforo_Lista_STV.release();
    }

    private void addSTVCommandGain(byte command[]) {
        int Pos = 0;
        try {
            Semaforo_Lista_STV.acquire();
            int N = list_Command_STV.size();
            if (N > 0) {
                for (int i = N - 1; i >= 0; i--) {
                    if (compareByteArray((byte[]) (byte[]) list_Command_STV.get(i), command)) {
                        list_Command_STV.remove(i);
                        if (Pos == 0) {
                            Pos = i;
                        }
                    } else {
                        byte array[] = (byte[]) (byte[]) list_Command_STV.get(i);
                        if (array.length == 9 && ((byte[]) (byte[]) list_Command_STV.get(i))[2] == command[2] && ((byte[]) (byte[]) list_Command_STV.get(i))[3] == command[3] && ((byte[]) (byte[]) list_Command_STV.get(i))[6] == command[6] && ((byte[]) (byte[]) list_Command_STV.get(i))[7] == command[7]) {
                            list_Command_STV.remove(i);
                        }
                    }
                }

            }
        } catch (Exception e) {
            logger.error(e);
        }
        if (Pos != 0 && list_Command_STV.size() >= Pos) {
            list_Command_STV.add(Pos, command);
        } else {
            list_Command_STV.add(command);
        }
        Semaforo_Lista_STV.release();
    }

    private void addSTVCommandChannel(byte command[]) {
        int Pos = 0;
        try {
            Semaforo_Lista_STV.acquire();
            int N = list_Command_STV.size();
            if (N > 0) {
                for (int i = N - 1; i >= 0; i--) {
                    if (compareByteArray((byte[]) (byte[]) list_Command_STV.get(i), command)) {
                        list_Command_STV.remove(i);
                        if (Pos == 0) {
                            Pos = i;
                        }
                    } else {
                        byte array[] = (byte[]) (byte[]) list_Command_STV.get(i);
                        if (array.length > 6 && ((byte[]) (byte[]) list_Command_STV.get(i))[2] == command[2] && ((byte[]) (byte[]) list_Command_STV.get(i))[3] == command[3] && ((byte[]) (byte[]) list_Command_STV.get(i))[6] == command[6]) {
                            list_Command_STV.remove(i);
                        }
                    }
                }

            }
        } catch (Exception e) {
            logger.error(e);
        }
        if (Pos != 0 && list_Command_STV.size() >= Pos) {
            list_Command_STV.add(Pos, command);
        } else {
            list_Command_STV.add(command);
        }
        Semaforo_Lista_STV.release();
    }

    private boolean checkSTVCheckSum(byte Command[])
            throws DriverException {
        byte checksum = Command[5];
        int size = bv(Command[0]) * pow(2, 8) + bv(Command[1]);
        long sum = bv(Command[0]);
        sum += bv(Command[1]);
        sum += bv(Command[2]);
        sum += bv(Command[3]);
        sum += bv(Command[4]);
        sum += bv(Command[6]);
        sum += bv(Command[7]);
        if (size != 0) {
            for (int i = 0; i <= size - 1; i++) {
                sum += bv(Command[8 + i]);
            }

        }
        return (long) bv(checksum) == sum % 256L;
    }

    private byte myCByte(boolean a)
            throws DriverException {
        return (byte) (a ? 1 : 0);
    }

    private int myCUShort(short a)
            throws DriverException {
        return a >= 0 ? a : 0x10000 + a;
    }

    private short myCShort(int a)
            throws DriverException {
        return (short) (a <= 32767 ? a : a - 0x10000);
    }

    private long bytesToUInt32(byte Array[], int Offset)
            throws DriverException {
        long r = 0L;
        byte aux[] = new byte[4];
        if (Array == null) {
            return r;
        }
        if (Array.length < Offset + 4) {
            return r;
        } else {
            System.arraycopy(Array, Offset, aux, 0, 4);
            invertir(aux);
            r = toUInt32(aux, 0);
            aux = null;
            return r;
        }
    }

    private short bytesToInt16(byte Array[], int Offset)
            throws DriverException {
        short r = 0;
        byte aux[] = new byte[2];
        if (Array == null) {
            return r;
        }
        if (Array.length < Offset + 2) {
            return r;
        } else {
            System.arraycopy(Array, Offset, aux, 0, 2);
            invertir(aux);
            r = toInt16(aux, 0);
            aux = null;
            return r;
        }
    }

    private byte getCM2StateByChannel(byte channel, byte ab, byte ic)
            throws DriverException {
        if (channel < 1 || channel > STV_Info.num_canales) {
            return 0;
        }
        STV_Info.modAmp[ab].Canal[ic].Direccion_Bundle_Cobranet = 0;
        STV_Info.modAmp[ab].Canal[ic].Canal_Bundle_Cobranet = 0;
        byte cnl = channel;
        short k = (short) (bv(STV_Info.ucCM2_Salida[cnl - 1]) - 9);
        if (k < 0) {
            return 0;
        }
        for (int i = 0; i <= STV_Info.num_canales - 1; i++) {
            for (int j = 0; j <= 7; j++) {
                if (bv(STV_Info.ucCM2_RxSubMap[i][j]) == k + 33) {
                    STV_Info.modAmp[ab].Canal[ic].Canal_Bundle_Cobranet = j + 1;
                    STV_Info.modAmp[ab].Canal[ic].Direccion_Bundle_Cobranet = STV_Info.usCM2_RxBundle[i];
                    return 1;
                }
            }

        }

        return 1;
    }

    @Override
    public boolean isIp(String ip) {
        String n = "\\.(([1-9]?[0-9])|(1[0-9]{2})|(2([0-4][0-9]|5[0-5])))";
        String m = "\\.((1[6-9])|(2[0-9])|(3[01]))";
        if (ip.matches((new StringBuilder()).append("^192\\.168(").append(n).append("){2}$").toString())) {
            return true;
        }
        if (ip.matches((new StringBuilder()).append("^10(").append(n).append("){3}$").toString())) {
            return true;
        }
        if (ip.matches((new StringBuilder()).append("^172").append(m).append("(").append(n).append("){2}$").toString())) {
            return true;
        }
        return ip.equals("127.0.0.1");
    }

    private void invertir(byte vector[]) {
        for (int i = 0; i < vector.length / 2; i++) {
            byte aux = vector[i];
            vector[i] = vector[vector.length - 1 - i];
            vector[vector.length - 1 - i] = aux;
        }

    }

    private long toUInt32(byte v[], int index) {
        byte cop[] = new byte[4];
        System.arraycopy(v, index, cop, 0, 4);
        invertir(cop);
        return (long) (bv(cop[0]) * pow(2, 24) + bv(cop[1]) * pow(2, 16) + bv(cop[2]) * pow(2, 8) + bv(cop[3])) & Long.valueOf("4294967295").longValue();
    }

    private short toInt16(byte v[], int index) {
        byte cop[] = new byte[2];
        System.arraycopy(v, index, cop, 0, 2);
        invertir(cop);
        return (short) (bv(cop[0]) * pow(2, 8) + bv(cop[1]));
    }

    private float toSingle(byte v[], int index) {
        byte cop[] = new byte[4];
        System.arraycopy(v, index, cop, 0, 4);
        invertir(cop);
        return (float) Math.round(Float.intBitsToFloat(bv(cop[0]) * pow(2, 24) + bv(cop[1]) * pow(2, 16) + bv(cop[2]) * pow(2, 8) + bv(cop[3])));
    }

    private byte[] getByteShort(short a) {
        byte v[] = new byte[2];
        int r = a & 0xffff;
        v[0] = (byte) (r < 256 ? r : r % 256);
        v[1] = (byte) (r / 256 < 256 ? r / 256 : (r / 256) % 256);
        return v;
    }

    private byte[] getByteUshort(int a) {
        byte v[] = new byte[2];
        a &= 0xffff;
        v[0] = (byte) (a < 256 ? a : a % 256);
        v[1] = (byte) (a / 256 < 256 ? a / 256 : (a / 256) % 256);
        return v;
    }

    private int pow(int base, int ex) {
        int r = 1;
        if (ex == 0) {
            return r;
        }
        for (int i = 1; i <= ex; i++) {
            r *= base;
        }

        return r;
    }

    private boolean cbool(byte n) {
        return n != 0;
    }

    private byte cBooltoByte(boolean a) {
        return ((byte) (!a ? 0 : -1));
    }

    private boolean cInttoBool(long a) {
        return a != 0L;
    }

    private short bv(short a) {
        return (short) (a & 0xff);
    }

    private int cont(byte v[]) {
        for (int i = 0; i <= v.length; i++) {
            if (v[i] == 0) {
                return i;
            }
        }

        return v.length;
    }
    private Semaphore Semaforo_Lista_STV;
    private Udp sckSinc;
    private Udp sckAsinc;
    private Timer tmrTimeOut;
    private Timer tmrRefresco;
    private Timer tmrCheckPortAsinc;
    private Timer tmrInfoDesconexion;
    private Timer tmrInfoDesconexionAsinc;
    private main Hebra;
    private ArrayList list_Command_STV;
    private STVInfo STV_Info;
    private STVComm STV_COMANDO;
    private boolean STV_CONECTADO;
    private boolean STV_ASINC_CONECTADO;
    private byte STV_ASINC_INTENTOS;
    private String STV_STRING_ERR[][];
    boolean Procesandosend;
}
