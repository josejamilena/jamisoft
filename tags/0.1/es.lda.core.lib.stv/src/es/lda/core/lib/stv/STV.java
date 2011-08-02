package es.lda.core.lib.stv;

import es.lda.core.event.interfaces.DataEvent;
import es.lda.core.network.Udp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import javax.swing.Timer;

public class STV {

    public class principal extends Thread {

        public void run() {
            while (!Abort) {
                try {
                    send_Command_STV();
                } catch (NullPointerException e) {
                    Abort = true;
                } catch (Exception e) {
                    Abort = true;
                }
            }
        }

        public void Abort() {
            Abort = true;
        }
        boolean Abort;
        final STV this$0;

        public principal() {
            this$0 = STV.this;
            Abort = false;
        }
    }

//    public class sSTV_INFO {
//
//        public int usCM2_TxBundle[];
//        public int usCM2_RxBundle[];
//        public byte ucCM2_TxSubMap[][];
//        public byte ucCM2_RxSubMap[][];
//        public boolean bCM2_Status_Bundle_Ch[];
//        public byte ucCM2_Salida[];
//        public byte errF_ALIM_180;
//        public byte errF_ALIM_240;
//        public long nArranques;
//        public boolean lenguaje_ES;
//        public byte num_canales;
//        public boolean hay_SD;
//        public boolean hay_EtherNet;
//        public boolean hay_CobraNet;
//        public byte tipo_Puerto_Serie;
//        public boolean dos_canales_por_dis;
//        public byte pot_canal;
//        public byte tension_nominal;
//        public byte corriente_nominal;
//        public byte impedancia_nominal;
//        public sSTV_ModAmp modAmp[];
//        public boolean Entrada_Digital;
//        public boolean Power_On;
//        public boolean Prioridad_CobraNet_Activa;
//        public boolean Prioridad_Modo_Presencia;
//        public byte Prioridad_Umbral_activacion;
//        public boolean Prioridad_Activacion_5V;
//        public boolean Prioridad_CobraNet_Habilitada;
//        public boolean Trasera_Habilitada;
//        public int Clave;
//        public byte Errores[];
//        public byte Log[][];
//        public String Version;
//        public boolean Hay_Logo;
//        public byte State_Fan_ETX;
//        public byte Temp_ETX;
//        public float FNTE_ALIM_12V;
//        public float FNTE_ALIM_12V_;
//        public float FNTE_ALIM_75VD;
//        public float FNTE_ALIM_75VD_;
//        public float FNTE_ALIM_75VI;
//        public float FNTE_ALIM_75VI_;
//        public float FNTE_ALIM_230V;
//        public float FNTE_ALIM_230I;
//        public byte DelayArranque;
//        final STV this$0;
//
//        public sSTV_INFO() {
//            this$0 = STV.this;
//            usCM2_TxBundle = new int[5];
//            usCM2_RxBundle = new int[9];
//            ucCM2_TxSubMap = new byte[5][9];
//            ucCM2_RxSubMap = new byte[9][9];
//            bCM2_Status_Bundle_Ch = new boolean[4];
//            ucCM2_Salida = new byte[17];
//            modAmp = new sSTV_ModAmp[2];
//            Errores = new byte[33];
//            Log = new byte[51][2];
//        }
//    }
//
//    public class sSTV_ModAmp {
//
//        public sSTV_CANAL Canal[];
//        public byte NewSense;
//        public sSTV_PRIO Prio;
//        public byte tempAmb;
//        public byte StateVentAmb;
//        public long stateInfo;
//        public int Reintentos_Comunicaciones;
//        final STV this$0;
//
//        public sSTV_ModAmp() {
//            this$0 = STV.this;
//            Canal = new sSTV_CANAL[2];
//            Prio = new sSTV_PRIO();
//        }
//    }
//
//    public class sSTV_PRIO {
//
//        public byte BoostFilterPrio;
//        public int FrecFilterPrio;
//        public int Q_SlopeFilterPrio;
//        public byte GainFilterPrio;
//        public short GainLinearInputPrio;
//        public byte GainPrio;
//        public boolean Activacion_5V;
//        public boolean Detec19KHzHabilitado;
//        public boolean Detect19Khz;
//        public boolean PrioActiva;
//        public int UmbralTension19Khz;
//        public boolean PresetFabrica;
//        public int Direccion_Bundle_Cobranet;
//        public int Canal_Bundle_Cobranet;
//        final STV this$0;
//
//        public sSTV_PRIO() {
//            this$0 = STV.this;
//
//        }
//    }
//
//    public class sSTV_CANAL {
//
//        public byte GainInput;
//        public byte GainOutput;
//        public boolean EnableFilter;
//        public int FrecFilter;
//        public byte GainFilter;
//        public boolean EnableLimiter;
//        public byte ThresHoldLimiter;
//        public int TCLimiter;
//        public byte Decaylimiter;
//        public boolean EnableEq;
//        public byte BoostEq[];
//        public int FreqEq[];
//        public int Q_SlopeEq[];
//        public byte GainEq[];
//        public boolean EnableTone;
//        public byte GainTone;
//        public int FreqTone;
//        public short DC;
//        public short GainLinearInput;
//        public boolean EnableLoudNess;
//        public sSTV_SENSE Sense;
//        public sSTV_TEMP Temp;
//        public boolean PresetFabrica;
//        public byte Mute;
//        public byte Impedancia_Configurada;
//        public byte Limite_Corto;
//        public byte Limite_Abierto;
//        public byte Autotest_Habilitado;
//        public byte Limitador_Modo;
//        public byte Nombre_Fuente_Cobranet[];
//        public byte Nombre_Zona_Cobranet[];
//        public int Direccion_Bundle_Cobranet;
//        public int Canal_Bundle_Cobranet;
//        public byte State_Line;
//        public boolean Protect;
//        final STV this$0;
//
//        public sSTV_CANAL() {
//            this$0 = STV.this;
//
//            BoostEq = new byte[7];
//            FreqEq = new int[7];
//            Q_SlopeEq = new int[7];
//            GainEq = new byte[7];
//            Sense = new sSTV_SENSE();
//            Temp = new sSTV_TEMP();
//            Nombre_Fuente_Cobranet = new byte[20];
//            Nombre_Zona_Cobranet = new byte[20];
//            State_Line = 2;
//        }
//    }
//
//    public class sSTV_TEMP {
//
//        public byte temp;
//        public byte stateVent;
//        public byte tempPlaca;
//        final STV this$0;
//
//        public sSTV_TEMP() {
//            this$0 = STV.this;
//
//        }
//    }
//
//    public class sSTV_SENSE {
//
//        public long tensionRamaPositiva;
//        public long tensionRamaNegativa;
//        public long corrienteRamaPositiva;
//        public long corrienteRamaNegativa;
//        public long tensionVpp;
//        public long corrienteVpp;
//        public byte clipRamaPositiva;
//        public byte clipRamaNegativa;
//        public byte dc;
//        public short vumetroEntradaRMS;
//        public short vumetroEntradaPEAK;
//        public short vumetroSalidaRMS;
//        public short vumetroSalidaPEAK;
//        public short tensionRMSdB;
//        final STV this$0;
//
//        public sSTV_SENSE() {
//            this$0 = STV.this;
//
//        }
//    }
//
//    private class sSTV_COMM {
//
//        byte Comando[];
//        byte nIntentos;
//        boolean Busy;
//        final STV this$0;
//
//        private sSTV_COMM() {
//            this$0 = STV.this;
//
//        }
//    }
//
//    private class sSTV_Protocolo {
//
//        int Size;
//        int Command;
//        byte RW;
//        byte CheckSum;
//        byte Data[];
//        final STV this$0;
//
//        private sSTV_Protocolo() {
//            this$0 = STV.this;
//
//        }
//    }

    public STV() {
        STV_Info = new sSTV_INFO();
        STV_COMANDO = new sSTV_COMM();
        STV_CONECTADO = false;
        STV_ASINC_CONECTADO = false;
        STV_ASINC_INTENTOS = 0;
        STV_STRING_ERR = new String[9][9];
        Procesandosend = false;
        for (int i = 0; i <= 1; i++) {
            STV_Info.modAmp[i] = new sSTV_ModAmp();
            for (int j = 0; j <= 1; j++) {
                STV_Info.modAmp[i].Canal[j] = new sSTV_CANAL();
            }

        }

        STV_STRING_ERR[0][1] = "RAM no encontrada \363 corrupta";
        STV_STRING_ERR[1][1] = "Interfaz CobraNet sin comunicaci\363n";
        STV_STRING_ERR[2][1] = "Sensado fuente alimentaci\363n sin comunicaci\363n";
        STV_STRING_ERR[3][1] = "Sensado temperatura ETX error de rango";
        STV_STRING_ERR[4][1] = "Sensado fuente alimentacion 230 V error";
        STV_STRING_ERR[4][2] = "Sensado fuente alimentacion 230 I error";
        STV_STRING_ERR[4][3] = "Sensado fuente alimentacion VP1 error";
        STV_STRING_ERR[4][4] = "Sensado fuente alimentacion VP2 error";
        STV_STRING_ERR[4][5] = "Sensado fuente alimentacion 12 V error";
        STV_STRING_ERR[4][6] = "Sensado fuente alimentacion carga error";
        STV_STRING_ERR[4][7] = "Sensado fuente alimentacion error de control";
        STV_STRING_ERR[5][1] = "Control Canales 1 y 2 sin comunicaci\363n";
        STV_STRING_ERR[6][1] = "Control Canales 3 y 4 sin comunicaci\363n";
        STV_STRING_ERR[7][1] = "Control Frontal sin comunicaci\363n";
        STV_STRING_ERR[8][1] = "Temperatura ETX excesiva";
    }

    public void Dispose()
            throws Exception {
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

    public boolean GetSinc_Connect()
            throws Exception {
        return STV_CONECTADO;
    }

    public boolean GetAsinc_Connect()
            throws Exception {
        return STV_ASINC_CONECTADO;
    }

    public sSTV_INFO GetInfo()
            throws Exception {
        return STV_Info;
    }

    public byte[] GetN_Fuente(int i, int j) {
        int lon = cont(STV_Info.modAmp[i].Canal[j].Nombre_Fuente_Cobranet);
        byte aux[] = new byte[lon];
        System.arraycopy(STV_Info.modAmp[i].Canal[j].Nombre_Fuente_Cobranet, 0, aux, 0, lon);
        return aux;
    }

    public byte[] GetN_Zona(int i, int j) {
        int lon = cont(STV_Info.modAmp[i].Canal[j].Nombre_Zona_Cobranet);
        byte aux[] = new byte[lon];
        System.arraycopy(STV_Info.modAmp[i].Canal[j].Nombre_Zona_Cobranet, 0, aux, 0, lon);
        return aux;
    }

    public byte Connect(String IP)
            throws Exception {
        byte r = 0;
        if (IsIp(IP)) {
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
                            if (!check_STV_CheckSum(comando)) {
                                Procesando = false;
                                comando = null;
                                return;
                            }
                        } catch (Exception ex) {
                            System.err.println(ex);
                        }
                        try {
                            if (tmrInfoDesconexion.isRunning()) {
                                tmrInfoDesconexion.stop();
                            }
                            tmrTimeOut.stop();
                            STV_CONECTADO = true;
                            if (STV_COMANDO.Comando[4] == 1) {
                                procesa_STV_Sinc_Command(comando);
                            }
                            clear_STV_COMMAND();
                            comando = null;
                            Procesando = false;
                        } catch (Exception e) {
                        }
                        return;
                    }
                    boolean Procesando;
                    final STV this$0;

                    {
                        this$0 = STV.this;

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
                            if (!check_STV_CheckSum(comando)) {
                                comando = null;
                                Procesando = false;
                                return;
                            }
                        } catch (Exception ex) {
                            System.err.println(ex);
                        }
                        try {
                            if (tmrInfoDesconexionAsinc.isRunning()) {
                                tmrInfoDesconexionAsinc.stop();
                            }
                            STV_ASINC_CONECTADO = true;
                            STV_ASINC_INTENTOS = 0;
                            if (comando[4] == 1) {
                                procesa_STV_Asinc_Command(comando);
                            }
                            comando = null;
                            Procesando = false;
                        } catch (Exception e) {
                        }
                        return;
                    }
                    boolean Procesando;
                    final STV this$0;

                    {
                        this$0 = STV.this;

                        Procesando = false;
                    }
                };
                sckSinc.setListener(data);
                sckAsinc.setListener(data2);
                clear_STV_COMMAND();
            }
            if (tmrTimeOut == null) {
                tmrTimeOut = new Timer(50, new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        if (Procesando) {
                            return;
                        }
                        Procesando = true;
                        if (STV_COMANDO.Busy) {
                            if (STV_COMANDO.nIntentos > 12) {
                                tmrTimeOut.stop();
                                try {
                                    clear_STV_COMMAND();
                                } catch (Exception ex) {
                                }
                                if (!tmrInfoDesconexion.isRunning()) {
                                    tmrInfoDesconexion.start();
                                }
                            } else {
                                STV_COMANDO.nIntentos++;
                                System.out.println((new StringBuilder()).append("Timeout = ").append(STV_COMANDO.nIntentos).toString());
                                sckSinc.sendData(STV_COMANDO.Comando);
                            }
                        }
                        Procesando = false;
                    }
                    boolean Procesando;
                    final STV this$0;

                    {
                        this$0 = STV.this;

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
                            STV_Refresh_Info();
                            STV_Refresh_Log();
                        } catch (Exception ex) {
                        }
                        Procesando = false;
                    }
                    boolean Procesando;
                    final STV this$0;

                    {
                        this$0 = STV.this;

                        Procesando = false;
                    }
                });
                tmrCheckPortAsinc = new Timer(500, new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        if (Procesando) {
                            return;
                        }
                        try {
                            Procesando = true;
                            set_Asincrono();
                            Procesando = false;
                        } catch (Exception ex) {
                        }
                        return;
                    }
                    boolean Procesando;
                    final STV this$0;

                    {
                        this$0 = STV.this;

                        Procesando = false;
                    }
                });
                tmrInfoDesconexion = new Timer(333, new ActionListener() {

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
                    final STV this$0;

                    {
                        this$0 = STV.this;

                        Procesando = false;
                    }
                });
                tmrInfoDesconexionAsinc = new Timer(333, new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        if (Procesando) {
                            return;
                        }
                        Procesando = true;
                        try {
                            tmrInfoDesconexionAsinc.stop();
                        } catch (NullPointerException er) {
                        }
                        STV_ASINC_CONECTADO = false;
                        Procesando = false;
                    }
                    boolean Procesando;
                    final STV this$0;

                    {
                        this$0 = STV.this;

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
                Hebra = new principal();
                Hebra.start();
            }
            r = 1;
        } else {
            r = 2;
        }
        return r;
    }

    private byte set_Asincrono()
            throws Exception {
        if (STV_ASINC_INTENTOS <= 12) {
            STV_ASINC_INTENTOS++;
            tmrCheckPortAsinc.setDelay(50);
        } else {
            tmrCheckPortAsinc.setDelay(500);
            if (!tmrInfoDesconexionAsinc.isRunning()) {
                tmrInfoDesconexionAsinc.start();
            }
        }
        byte STV_Command[] = convert_Command_To_STV_Protocol(65535, (byte) 2, null);
        sckAsinc.sendData(STV_Command);
        STV_Command = null;
        return 1;
    }

    public byte set_Amp_Gain(byte channel, boolean e_s, byte gain)
            throws Exception {
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
            byte STV_Command[] = convert_Command_To_STV_Protocol(65534, (byte) 2, bA_Params);
            add_Command_STV_Gain(STV_Command);
            bA_e_s = null;
            bA_channel = null;
            bA_gain = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    public byte set_Amp_Enable_Filter(byte channel, boolean enable)
            throws Exception {
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
            byte STV_Command[] = convert_Command_To_STV_Protocol(65533, (byte) 2, bA_Params);
            add_Command_STV_Channel(STV_Command);
            bA_enable = null;
            bA_channel = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    public byte set_Amp_Filter(byte channel, int Frec, byte Gain)
            throws Exception {
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
            byte bA_frecuencia[] = getbyteUshort(Frec);
            invertir(bA_frecuencia);
            bA_ganancia[0] = Gain;
            byte bA_Params[] = new byte[bA_channel.length + bA_frecuencia.length + bA_ganancia.length];
            System.arraycopy(bA_channel, 0, bA_Params, 0, bA_channel.length);
            System.arraycopy(bA_frecuencia, 0, bA_Params, bA_channel.length, bA_frecuencia.length);
            System.arraycopy(bA_ganancia, 0, bA_Params, bA_channel.length + bA_frecuencia.length, bA_ganancia.length);
            byte STV_Command[] = convert_Command_To_STV_Protocol(65532, (byte) 2, bA_Params);
            add_Command_STV_Channel(STV_Command);
            bA_channel = null;
            bA_frecuencia = null;
            bA_ganancia = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    public byte set_Amp_Enable_Limiter(byte channel, boolean enable)
            throws Exception {
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
            byte STV_Command[] = convert_Command_To_STV_Protocol(65531, (byte) 2, bA_Params);
            add_Command_STV_Channel(STV_Command);
            bA_enable = null;
            bA_channel = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    public byte set_Amp_Threshold_Limiter(byte channel, byte threshold)
            throws Exception {
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
            byte STV_Command[] = convert_Command_To_STV_Protocol(65530, (byte) 2, bA_Params);
            add_Command_STV_Channel(STV_Command);
            bA_threshold = null;
            bA_channel = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    public byte set_Amp_TC_Limiter(byte channel, int tc)
            throws Exception {
        if (channel < 1 || channel > STV_Info.num_canales) {
            return 2;
        }
        if (tc < 1 || tc > 10000) {
            return 2;
        } else {
            byte bA_channel[] = new byte[1];
            bA_channel[0] = channel;
            byte bA_tc[] = getbyteUshort(tc);
            invertir(bA_tc);
            byte bA_Params[] = new byte[bA_channel.length + bA_tc.length];
            System.arraycopy(bA_channel, 0, bA_Params, 0, bA_channel.length);
            System.arraycopy(bA_tc, 0, bA_Params, bA_channel.length, bA_tc.length);
            byte STV_Command[] = convert_Command_To_STV_Protocol(65529, (byte) 2, bA_Params);
            add_Command_STV_Channel(STV_Command);
            bA_tc = null;
            bA_channel = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    public byte set_Amp_Decay_Limiter(byte channel, byte decay)
            throws Exception {
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
            byte STV_Command[] = convert_Command_To_STV_Protocol(65528, (byte) 2, bA_Params);
            add_Command_STV_Channel(STV_Command);
            bA_decay = null;
            bA_channel = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    public byte set_Amp_Enable_Equalizer(byte channel, boolean enable)
            throws Exception {
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
            byte STV_Command[] = convert_Command_To_STV_Protocol(65527, (byte) 2, bA_Params);
            add_Command_STV_Channel(STV_Command);
            bA_enable = null;
            bA_channel = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    public byte set_Amp_Equalizer(byte channel, byte band, byte boost, int frec, int q_slope, byte gain)
            throws Exception {
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
            byte bA_frec[] = getbyteUshort(frec);
            invertir(bA_frec);
            byte bA_q_slope[] = getbyteUshort(q_slope);
            invertir(bA_q_slope);
            bA_gain[0] = gain;
            byte bA_Params[] = new byte[bA_channel.length + bA_band.length + bA_boost.length + bA_frec.length + bA_q_slope.length + bA_gain.length];
            System.arraycopy(bA_channel, 0, bA_Params, 0, bA_channel.length);
            System.arraycopy(bA_band, 0, bA_Params, bA_channel.length, bA_band.length);
            System.arraycopy(bA_boost, 0, bA_Params, bA_channel.length + bA_band.length, bA_boost.length);
            System.arraycopy(bA_frec, 0, bA_Params, bA_channel.length + bA_band.length + bA_boost.length, bA_frec.length);
            System.arraycopy(bA_q_slope, 0, bA_Params, bA_channel.length + bA_band.length + bA_boost.length + bA_frec.length, bA_q_slope.length);
            System.arraycopy(bA_gain, 0, bA_Params, bA_channel.length + bA_band.length + bA_boost.length + bA_frec.length + bA_q_slope.length, bA_gain.length);
            byte STV_Command[] = convert_Command_To_STV_Protocol(65526, (byte) 2, bA_Params);
            add_Command_STV_Channel(STV_Command);
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

    public byte set_Amp_Enable_Tone(byte channel, boolean enable)
            throws Exception {
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
            byte STV_Command[] = convert_Command_To_STV_Protocol(65525, (byte) 2, bA_Params);
            add_Command_STV_Channel(STV_Command);
            bA_enable = null;
            bA_channel = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    public byte set_Amp_Gain_Tone(byte channel, byte gain)
            throws Exception {
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
            byte STV_Command[] = convert_Command_To_STV_Protocol(65524, (byte) 2, bA_Params);
            add_Command_STV_Channel(STV_Command);
            bA_gain = null;
            bA_channel = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    public byte set_Amp_Frec_Tone(byte channel, int frec)
            throws Exception {
        if (channel < 1 || channel > STV_Info.num_canales) {
            return 2;
        }
        if (frec < 1 || frec > 24000) {
            return 2;
        } else {
            byte bA_channel[] = new byte[1];
            bA_channel[0] = channel;
            byte bA_frec[] = getbyteUshort(frec);
            invertir(bA_frec);
            byte bA_Params[] = new byte[bA_channel.length + bA_frec.length];
            System.arraycopy(bA_channel, 0, bA_Params, 0, bA_channel.length);
            System.arraycopy(bA_frec, 0, bA_Params, bA_channel.length, bA_frec.length);
            byte STV_Command[] = convert_Command_To_STV_Protocol(65523, (byte) 2, bA_Params);
            add_Command_STV_Channel(STV_Command);
            bA_frec = null;
            bA_channel = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    public byte set_Amp_DC(byte channel, short dc)
            throws Exception {
        if (channel < 1 || channel > STV_Info.num_canales) {
            return 2;
        }
        if (dc < -1600 || dc > 1600) {
            return 2;
        } else {
            byte bA_channel[] = new byte[1];
            bA_channel[0] = channel;
            byte bA_dc[] = getbyteShort(dc);
            invertir(bA_dc);
            byte bA_Params[] = new byte[bA_channel.length + bA_dc.length];
            System.arraycopy(bA_channel, 0, bA_Params, 0, bA_channel.length);
            System.arraycopy(bA_dc, 0, bA_Params, bA_channel.length, bA_dc.length);
            byte STV_Command[] = convert_Command_To_STV_Protocol(65522, (byte) 2, bA_Params);
            add_Command_STV_Channel(STV_Command);
            bA_dc = null;
            bA_channel = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    public byte set_Amp_Gain_Input_linear(byte channel, short gain)
            throws Exception {
        if (channel < 1 || channel > STV_Info.num_canales) {
            return 2;
        }
        if (gain < -1500 || gain > 1200) {
            return 2;
        } else {
            byte bA_channel[] = new byte[1];
            bA_channel[0] = channel;
            byte bA_gain[] = getbyteShort(gain);
            invertir(bA_gain);
            byte bA_Params[] = new byte[bA_channel.length + bA_gain.length];
            System.arraycopy(bA_channel, 0, bA_Params, 0, bA_channel.length);
            System.arraycopy(bA_gain, 0, bA_Params, bA_channel.length, bA_gain.length);
            byte STV_Command[] = convert_Command_To_STV_Protocol(65521, (byte) 2, bA_Params);
            add_Command_STV_Channel(STV_Command);
            bA_gain = null;
            bA_channel = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    public byte set_Amp_Enable_Loudness(byte channel, boolean enable)
            throws Exception {
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
            byte STV_Command[] = convert_Command_To_STV_Protocol(65520, (byte) 2, bA_Params);
            add_Command_STV_Channel(STV_Command);
            bA_enable = null;
            bA_channel = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    public byte set_Amp_Mute_Ch(byte channel, boolean mute)
            throws Exception {
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
            byte STV_Command[] = convert_Command_To_STV_Protocol(65515, (byte) 2, bA_Params);
            add_Command_STV_Channel(STV_Command);
            bA_channel = null;
            bA_mute = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    public byte set_CobraNet(byte channel, int addr_bundle, byte input_ch)
            throws Exception {
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
        byte bA_addr_bundle[] = getbyteUshort(addr_bundle);
        invertir(bA_addr_bundle);
        bA_input_ch[0] = input_ch;
        byte bA_Params[] = new byte[ba_channel.length + bA_addr_bundle.length + bA_input_ch.length];
        System.arraycopy(ba_channel, 0, bA_Params, 0, ba_channel.length);
        System.arraycopy(bA_addr_bundle, 0, bA_Params, ba_channel.length, bA_addr_bundle.length);
        System.arraycopy(bA_input_ch, 0, bA_Params, ba_channel.length + bA_addr_bundle.length, bA_input_ch.length);
        byte STV_Command[] = convert_Command_To_STV_Protocol(65512, (byte) 2, bA_Params);
        add_Command_STV_Channel(STV_Command);
        ba_channel = null;
        bA_addr_bundle = null;
        bA_input_ch = null;
        bA_Params = null;
        STV_Command = null;
        return 1;
    }

    public byte set_Amp_Presets(byte channel, byte action)
            throws Exception {
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
            byte STV_Command[] = convert_Command_To_STV_Protocol(65506, (byte) 2, bA_Params);
            add_Command_STV_Channel(STV_Command);
            bA_Params = null;
            bA_channel = null;
            bA_action = null;
            STV_Command = null;
            return 1;
        }
    }

    public byte set_CobraNet_Nombre_Fuente(byte channel, String nombre)
            throws Exception {
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
            System.arraycopy(nombre.getBytes("UTF-8"), 0, bA_nombre, 0, nombre.length());
            bA_nombre[nombre.length()] = 0;
            byte bA_Params[] = new byte[ba_channel.length + bA_nombre.length];
            System.arraycopy(ba_channel, 0, bA_Params, 0, ba_channel.length);
            System.arraycopy(bA_nombre, 0, bA_Params, ba_channel.length, bA_nombre.length);
            byte STV_Command[] = convert_Command_To_STV_Protocol(65505, (byte) 2, bA_Params);
            add_Command_STV_Channel(STV_Command);
            ba_channel = null;
            bA_nombre = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    public byte set_CobraNet_Nombre_Zona(byte channel, String nombre)
            throws Exception {
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
            System.arraycopy(nombre.getBytes("UTF-8"), 0, bA_nombre, 0, nombre.length());
            bA_nombre[nombre.length()] = 0;
            byte bA_Params[] = new byte[ba_channel.length + bA_nombre.length];
            System.arraycopy(ba_channel, 0, bA_Params, 0, ba_channel.length);
            System.arraycopy(bA_nombre, 0, bA_Params, ba_channel.length, bA_nombre.length);
            byte STV_Command[] = convert_Command_To_STV_Protocol(65504, (byte) 2, bA_Params);
            add_Command_STV_Channel(STV_Command);
            ba_channel = null;
            bA_nombre = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    public byte set_Model_STV(byte model)
            throws Exception {
        if (model < 1 || model > 5) {
            return 2;
        } else {
            byte bA_model[] = new byte[1];
            bA_model[0] = model;
            byte STV_Command[] = convert_Command_To_STV_Protocol(65503, (byte) 2, bA_model);
            add_Command_STV(STV_Command);
            bA_model = null;
            STV_Command = null;
            return 1;
        }
    }

    public byte set_Mode_Limiter_STV(byte mode)
            throws Exception {
        if (mode > 1) {
            return 2;
        } else {
            byte bA_mode[] = new byte[1];
            bA_mode[0] = mode;
            byte STV_Command[] = convert_Command_To_STV_Protocol(65502, (byte) 2, bA_mode);
            add_Command_STV(STV_Command);
            bA_mode = null;
            STV_Command = null;
            return 1;
        }
    }

    public byte set_Enable_CM2(boolean enable)
            throws Exception {
        byte bA_enable[] = new byte[1];
        bA_enable[0] = myCByte(enable);
        byte STV_Command[] = convert_Command_To_STV_Protocol(65501, (byte) 2, bA_enable);
        add_Command_STV(STV_Command);
        bA_enable = null;
        STV_Command = null;
        return 1;
    }

    public byte set_Enable_SDCard(boolean enable)
            throws Exception {
        byte bA_enable[] = new byte[1];
        bA_enable[0] = myCByte(enable);
        byte STV_Command[] = convert_Command_To_STV_Protocol(65500, (byte) 2, bA_enable);
        add_Command_STV(STV_Command);
        bA_enable = null;
        STV_Command = null;
        return 1;
    }

    public byte set_Power_On(boolean power_on)
            throws Exception {
        byte bA_power_on[] = new byte[1];
        bA_power_on[0] = myCByte(power_on);
        byte STV_Command[] = convert_Command_To_STV_Protocol(65499, (byte) 2, bA_power_on);
        add_Command_STV(STV_Command);
        bA_power_on = null;
        STV_Command = null;
        return 1;
    }

    public byte set_Software_Reset()
            throws Exception {
        byte STV_Command[] = convert_Command_To_STV_Protocol(65498, (byte) 2, null);
        add_Command_STV(STV_Command);
        STV_Command = null;
        return 1;
    }

    public byte set_Enable_EtherNet(boolean enable)
            throws Exception {
        byte bA_enable[] = new byte[1];
        bA_enable[0] = myCByte(enable);
        byte STV_Command[] = convert_Command_To_STV_Protocol(65497, (byte) 2, bA_enable);
        add_Command_STV(STV_Command);
        bA_enable = null;
        STV_Command = null;
        return 1;
    }

    public byte set_Frontal_Logo(byte logo[])
            throws Exception {
        byte STV_Command[] = convert_Command_To_STV_Protocol(65496, (byte) 2, logo);
        add_Command_STV(STV_Command);
        STV_Command = null;
        return 1;
    }

    public byte set_Frontal_Borrar_Logo()
            throws Exception {
        byte STV_Command[] = convert_Command_To_STV_Protocol(65495, (byte) 2, null);
        add_Command_STV(STV_Command);
        STV_Command = null;
        return 1;
    }

    public byte set_Delay_Arranque_Fuente(byte delay)
            throws Exception {
        byte bA_delay[] = new byte[1];
        bA_delay[0] = delay;
        byte STV_Command[] = convert_Command_To_STV_Protocol(65494, (byte) 2, bA_delay);
        add_Command_STV(STV_Command);
        bA_delay = null;
        STV_Command = null;
        return 1;
    }

    public byte set_Sensado_Fuente(boolean enable)
            throws Exception {
        byte bA_enable[] = new byte[1];
        bA_enable[0] = myCByte(enable);
        byte STV_Command[] = convert_Command_To_STV_Protocol(65493, (byte) 2, bA_enable);
        add_Command_STV(STV_Command);
        bA_enable = null;
        STV_Command = null;
        return 1;
    }

    public byte set_Amp_Filter_Prio(byte boost, int frec, int q_slope, byte gain)
            throws Exception {
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
            byte bA_frec[] = getbyteUshort(frec);
            invertir(bA_frec);
            byte bA_q_slope[] = getbyteUshort(q_slope);
            invertir(bA_q_slope);
            bA_gain[0] = gain;
            byte bA_Params[] = new byte[bA_boost.length + bA_frec.length + bA_q_slope.length + bA_gain.length];
            System.arraycopy(bA_boost, 0, bA_Params, 0, bA_boost.length);
            System.arraycopy(bA_frec, 0, bA_Params, bA_boost.length, bA_frec.length);
            System.arraycopy(bA_q_slope, 0, bA_Params, bA_boost.length + bA_frec.length, bA_q_slope.length);
            System.arraycopy(bA_gain, 0, bA_Params, bA_boost.length + bA_frec.length + bA_q_slope.length, bA_gain.length);
            byte STV_Command[] = convert_Command_To_STV_Protocol(65518, (byte) 2, bA_Params);
            add_Command_STV(STV_Command);
            bA_boost = null;
            bA_frec = null;
            bA_q_slope = null;
            bA_gain = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    public byte set_Amp_Gain_Input_Linear_Prio(short gain)
            throws Exception {
        if (gain < -1500 || gain > 1200) {
            return 2;
        } else {
            byte bA_gain[] = getbyteShort(gain);
            invertir(bA_gain);
            byte STV_Command[] = convert_Command_To_STV_Protocol(65517, (byte) 2, bA_gain);
            add_Command_STV(STV_Command);
            bA_gain = null;
            STV_Command = null;
            return 1;
        }
    }

    public byte set_Amp_Gain_Prio(byte gain)
            throws Exception {
        if (gain < -100 || gain > 0) {
            return 2;
        } else {
            byte bA_gain[] = new byte[1];
            bA_gain[0] = gain;
            byte STV_Command[] = convert_Command_To_STV_Protocol(65516, (byte) 2, bA_gain);
            add_Command_STV(STV_Command);
            bA_gain = null;
            STV_Command = null;
            return 1;
        }
    }

    public byte set_Amp_Mute_All(boolean mute)
            throws Exception {
        byte bA_mute[] = new byte[1];
        bA_mute[0] = myCByte(mute);
        byte STV_Command[] = convert_Command_To_STV_Protocol(65514, (byte) 2, bA_mute);
        add_Command_STV(STV_Command);
        bA_mute = null;
        STV_Command = null;
        return 1;
    }

    public byte set_Amp_CobraNet_Prio(int addr_bundle, byte input_ch)
            throws Exception {
        if (input_ch > 8) {
            return 2;
        } else {
            byte bA_input_ch[] = new byte[1];
            byte bA_addr_bundle[] = getbyteUshort(addr_bundle);
            invertir(bA_addr_bundle);
            bA_input_ch[0] = input_ch;
            byte bA_Params[] = new byte[bA_addr_bundle.length + bA_input_ch.length];
            System.arraycopy(bA_addr_bundle, 0, bA_Params, 0, bA_addr_bundle.length);
            System.arraycopy(bA_input_ch, 0, bA_Params, bA_addr_bundle.length, bA_input_ch.length);
            byte STV_Command[] = convert_Command_To_STV_Protocol(65513, (byte) 2, bA_Params);
            add_Command_STV(STV_Command);
            bA_addr_bundle = null;
            bA_input_ch = null;
            bA_Params = null;
            STV_Command = null;
            return 1;
        }
    }

    public byte set_Amp_Mode_Audio_Input(boolean digital_input)
            throws Exception {
        byte bA_digital_input[] = new byte[1];
        bA_digital_input[0] = myCByte(digital_input);
        byte STV_Command[] = convert_Command_To_STV_Protocol(65511, (byte) 2, bA_digital_input);
        add_Command_STV(STV_Command);
        bA_digital_input = null;
        STV_Command = null;
        return 1;
    }

    public byte set_Amp_Mode_Enable_CobraNet_Prio(boolean enable)
            throws Exception {
        byte bA_enable[] = new byte[1];
        bA_enable[0] = myCByte(enable);
        byte STV_Command[] = convert_Command_To_STV_Protocol(65510, (byte) 2, bA_enable);
        add_Command_STV(STV_Command);
        bA_enable = null;
        STV_Command = null;
        return 1;
    }

    public byte set_Amp_Mode_Active_Prio(boolean signal_presense)
            throws Exception {
        byte bA_signal_presense[] = new byte[1];
        bA_signal_presense[0] = myCByte(signal_presense);
        byte STV_Command[] = convert_Command_To_STV_Protocol(65509, (byte) 2, bA_signal_presense);
        add_Command_STV(STV_Command);
        bA_signal_presense = null;
        STV_Command = null;
        return 1;
    }

    public byte set_Amp_Level_Active_Prio(boolean High)
            throws Exception {
        byte bA_High[] = new byte[1];
        bA_High[0] = myCByte(High);
        byte STV_Command[] = convert_Command_To_STV_Protocol(65508, (byte) 2, bA_High);
        add_Command_STV(STV_Command);
        bA_High = null;
        STV_Command = null;
        return 1;
    }

    public byte set_Amp_ThresHold_Active_Prio(byte threshold)
            throws Exception {
        if (threshold < -100 || threshold > 20) {
            return 2;
        } else {
            byte bA_threshold[] = new byte[1];
            bA_threshold[0] = threshold;
            byte STV_Command[] = convert_Command_To_STV_Protocol(65507, (byte) 2, bA_threshold);
            add_Command_STV(STV_Command);
            bA_threshold = null;
            STV_Command = null;
            return 1;
        }
    }

    public String get_STV_Log()
            throws Exception {
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

    private void procesa_STV_Sinc_Command(byte comando[])
            throws Exception {
        byte backup[] = new byte[comando.length + 1];
        byte numComando[] = new byte[2];
        System.arraycopy(comando, 0, backup, 0, comando.length);
        numComando[0] = backup[3];
        numComando[1] = backup[2];
        if (compare_Byte_Array(getbyteUshort(1), numComando)) {
            procesa_STV_Info(backup);
        } else if (compare_Byte_Array(getbyteUshort(2), numComando)) {
            procesa_STV_Log(backup);
        }
        numComando = null;
    }

    private void procesa_STV_Asinc_Command(byte comando[])
            throws Exception {
        byte numComando[] = new byte[2];
        numComando[0] = comando[3];
        numComando[1] = comando[2];
        numComando = null;
    }

    private void procesa_STV_Info(byte Comando[])
            throws Exception {
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
                    get_CM2_State_By_Channel((byte) (2 * i + j + 1), (byte) i, (byte) j);
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
            STV_Info.FNTE_ALIM_12V = ToSingle(arrayAux, 0);
            k += 4;
            arrayAux[3] = Comando[k];
            arrayAux[2] = Comando[k + 1];
            arrayAux[1] = Comando[k + 2];
            arrayAux[0] = Comando[k + 3];
            STV_Info.FNTE_ALIM_12V_ = ToSingle(arrayAux, 0);
            k += 4;
            arrayAux[3] = Comando[k];
            arrayAux[2] = Comando[k + 1];
            arrayAux[1] = Comando[k + 2];
            arrayAux[0] = Comando[k + 3];
            STV_Info.FNTE_ALIM_75VD = ToSingle(arrayAux, 0);
            k += 4;
            arrayAux[3] = Comando[k];
            arrayAux[2] = Comando[k + 1];
            arrayAux[1] = Comando[k + 2];
            arrayAux[0] = Comando[k + 3];
            STV_Info.FNTE_ALIM_75VD_ = ToSingle(arrayAux, 0);
            k += 4;
            arrayAux[3] = Comando[k];
            arrayAux[2] = Comando[k + 1];
            arrayAux[1] = Comando[k + 2];
            arrayAux[0] = Comando[k + 3];
            STV_Info.FNTE_ALIM_75VI = ToSingle(arrayAux, 0);
            k += 4;
            arrayAux[3] = Comando[k];
            arrayAux[2] = Comando[k + 1];
            arrayAux[1] = Comando[k + 2];
            arrayAux[0] = Comando[k + 3];
            STV_Info.FNTE_ALIM_75VI_ = ToSingle(arrayAux, 0);
            k += 4;
            arrayAux[3] = Comando[k];
            arrayAux[2] = Comando[k + 1];
            arrayAux[1] = Comando[k + 2];
            arrayAux[0] = Comando[k + 3];
            STV_Info.FNTE_ALIM_230V = ToSingle(arrayAux, 0);
            k += 4;
            arrayAux[3] = Comando[k];
            arrayAux[2] = Comando[k + 1];
            arrayAux[1] = Comando[k + 2];
            arrayAux[0] = Comando[k + 3];
            STV_Info.FNTE_ALIM_230I = ToSingle(arrayAux, 0);
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

    private void procesa_STV_Log(byte Comando[])
            throws Exception {
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

    private void send_Command_STV()
            throws Exception {
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

    private void STV_Refresh_Info()
            throws Exception {
        byte STV_Command[] = convert_Command_To_STV_Protocol(1, (byte) 1, null);
        add_Command_STV(STV_Command);
        STV_Command = null;
    }

    private void STV_Refresh_Log()
            throws Exception {
        byte STV_Command[] = convert_Command_To_STV_Protocol(2, (byte) 1, null);
        add_Command_STV(STV_Command);
        STV_Command = null;
    }

    private boolean compare_Byte_Array(byte array1[], byte array2[])
            throws Exception {
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

    private void clear_STV_COMMAND() {
        STV_COMANDO.Comando = null;
        STV_COMANDO.Busy = false;
        STV_COMANDO.nIntentos = 0;
    }

    private byte[] convert_Command_To_STV_Protocol(int Command, byte RW, byte Param[])
            throws Exception {
        sSTV_Protocolo trama = new sSTV_Protocolo();
        byte cabecera[] = new byte[6];
        trama.Size = 0;
        if (Param != null) {
            trama.Size += Param.length;
        }
        trama.Command = Command;
        trama.RW = RW;
        byte aux[] = getbyteUshort(Command);
        invertir(aux);
        byte aux1[] = getbyteUshort(trama.Size);
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

    private void add_Command_STV(byte command[]) {
        int Pos = 0;
        try {
            Semaforo_Lista_STV.acquire();
            int N = list_Command_STV.size();
            if (N > 0) {
                for (int i = N - 1; i >= 0; i--) {
                    if (compare_Byte_Array((byte[]) (byte[]) list_Command_STV.get(i), command)) {
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
        }
        if (Pos != 0 && list_Command_STV.size() >= Pos) {
            list_Command_STV.add(Pos, command);
        } else {
            list_Command_STV.add(command);
        }
        Semaforo_Lista_STV.release();
    }

    private void add_Command_STV_Gain(byte command[]) {
        int Pos = 0;
        try {
            Semaforo_Lista_STV.acquire();
            int N = list_Command_STV.size();
            if (N > 0) {
                for (int i = N - 1; i >= 0; i--) {
                    if (compare_Byte_Array((byte[]) (byte[]) list_Command_STV.get(i), command)) {
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
        }
        if (Pos != 0 && list_Command_STV.size() >= Pos) {
            list_Command_STV.add(Pos, command);
        } else {
            list_Command_STV.add(command);
        }
        Semaforo_Lista_STV.release();
    }

    private void add_Command_STV_Channel(byte command[]) {
        int Pos = 0;
        try {
            Semaforo_Lista_STV.acquire();
            int N = list_Command_STV.size();
            if (N > 0) {
                for (int i = N - 1; i >= 0; i--) {
                    if (compare_Byte_Array((byte[]) (byte[]) list_Command_STV.get(i), command)) {
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
        }
        if (Pos != 0 && list_Command_STV.size() >= Pos) {
            list_Command_STV.add(Pos, command);
        } else {
            list_Command_STV.add(command);
        }
        Semaforo_Lista_STV.release();
    }

    private boolean check_STV_CheckSum(byte Command[])
            throws Exception {
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
            throws Exception {
        return (byte) (a ? 1 : 0);
    }

    private int myCUShort(short a)
            throws Exception {
        return a >= 0 ? a : 0x10000 + a;
    }

    private short myCShort(int a)
            throws Exception {
        return (short) (a <= 32767 ? a : a - 0x10000);
    }

    private long bytesToUInt32(byte Array[], int Offset)
            throws Exception {
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
            r = ToUInt32(aux, 0);
            aux = null;
            return r;
        }
    }

    private short bytesToInt16(byte Array[], int Offset)
            throws Exception {
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
            r = ToInt16(aux, 0);
            aux = null;
            return r;
        }
    }

    private byte get_CM2_State_By_Channel(byte channel, byte ab, byte ic)
            throws Exception {
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

    public boolean IsIp(String ip) {
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

    private long ToUInt32(byte v[], int index) {
        byte cop[] = new byte[4];
        System.arraycopy(v, index, cop, 0, 4);
        invertir(cop);
        return (long) (bv(cop[0]) * pow(2, 24) + bv(cop[1]) * pow(2, 16) + bv(cop[2]) * pow(2, 8) + bv(cop[3])) & Long.valueOf("4294967295").longValue();
    }

    private short ToInt16(byte v[], int index) {
        byte cop[] = new byte[2];
        System.arraycopy(v, index, cop, 0, 2);
        invertir(cop);
        return (short) (bv(cop[0]) * pow(2, 8) + bv(cop[1]));
    }

    private float ToSingle(byte v[], int index) {
        byte cop[] = new byte[4];
        System.arraycopy(v, index, cop, 0, 4);
        invertir(cop);
        return (float) Math.round(Float.intBitsToFloat(bv(cop[0]) * pow(2, 24) + bv(cop[1]) * pow(2, 16) + bv(cop[2]) * pow(2, 8) + bv(cop[3])));
    }

    private byte[] getbyteShort(short a) {
        byte v[] = new byte[2];
        int r = a & 0xffff;
        v[0] = (byte) (r < 256 ? r : r % 256);
        v[1] = (byte) (r / 256 < 256 ? r / 256 : (r / 256) % 256);
        return v;
    }

    private byte[] getbyteUshort(int a) {
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
    public final byte STV_ERR_GENERICO = 0;
    public final byte STV_ERR_OK = 1;
    public final byte STV_ERR_PARAM = 2;
    private final short STV_COMMAND_GET_INFO = 1;
    private final short STV_COMMAND_GET_LOG = 2;
    private final int STV_COMMAND_SET_ASINC = 65535;
    private final int STV_COMMAND_SET_AMP_GAIN = 65534;
    private final int STV_COMMAND_SET_AMP_ENABLE_FILTER = 65533;
    private final int STV_COMMAND_SET_AMP_FILTER = 65532;
    private final int STV_COMMAND_SET_AMP_ENABLE_LIMITER = 65531;
    private final int STV_COMMAND_SET_AMP_THRESHOLD_LIMITER = 65530;
    private final int STV_COMMAND_SET_AMP_TC_LIMITER = 65529;
    private final int STV_COMMAND_SET_AMP_DECAY_LIMITER = 65528;
    private final int STV_COMMAND_SET_AMP_ENABLE_EQUALIZER = 65527;
    private final int STV_COMMAND_SET_AMP_EQUALIZER = 65526;
    private final int STV_COMMAND_SET_AMP_ENABLE_TONE = 65525;
    private final int STV_COMMAND_SET_AMP_GAIN_TONE = 65524;
    private final int STV_COMMAND_SET_AMP_FREC_TONE = 65523;
    private final int STV_COMMAND_SET_AMP_DC = 65522;
    private final int STV_COMMAND_SET_AMP_GAIN_INPUT_LINEAR = 65521;
    private final int STV_COMMAND_SET_AMP_ENABLE_LOUDNESS = 65520;
    private final int STV_COMMAND_SET_AMP_FILTER_PRIO = 65518;
    private final int STV_COMMAND_SET_AMP_GAIN_INPUT_LINEAR_PRIO = 65517;
    private final int STV_COMMAND_SET_AMP_GAIN_PRIO = 65516;
    private final int STV_COMMAND_SET_AMP_MUTE_CH = 65515;
    private final int STV_COMMAND_SET_AMP_MUTE_ALL = 65514;
    private final int STV_COMMAND_SET_COBRANET_PRIO = 65513;
    private final int STV_COMMAND_SET_COBRANET = 65512;
    private final int STV_COMMAND_SET_AMP_MODE_AUDIO_INPUT = 65511;
    private final int STV_COMMAND_SET_AMP_ENABLE_COBRANET_PRIO = 65510;
    private final int STV_COMMAND_SET_AMP_MODE_ACTIVE_PRIO = 65509;
    private final int STV_COMMAND_SET_AMP_LEVEL_ACTIVE_PRIO = 65508;
    private final int STV_COMMAND_SET_AMP_THRESHOLD_ACTIVE_PRIO = 65507;
    private final int STV_COMMAND_SET_AMP_PRESETS = 65506;
    private final int STV_COMMAND_SET_COBRANET_NOMBRE_FUENTE = 65505;
    private final int STV_COMMAND_SET_COBRANET_NOMBRE_ZONA = 65504;
    private final int STV_COMMAND_SET_MODEL_STV = 65503;
    private final int STV_COMMAND_SET_MODE_LIMITER = 65502;
    private final int STV_COMMAND_SET_ENABLE_CM2 = 65501;
    private final int STV_COMMAND_SET_ENABLE_SDCARD = 65500;
    private final int STV_COMMAND_SET_POWER_ON = 65499;
    private final int STV_COMMAND_SET_SOFTWARE_RESET = 65498;
    private final int STV_COMMAND_SET_ENABLE_ETHERNET = 65497;
    private final int STV_COMMAND_SET_FRONTAL_LOGO = 65496;
    private final int STV_COMMAND_SET_FRONTAL_BORRAR_LOGO = 65495;
    private final int STV_COMMAND_SET_DELAY_ARRANQUE = 65494;
    private final int STV_COMMAND_SET_SENSADO_FUENTE = 65493;
    private final int UDP_GET = 1;
    private final int UDP_SET = 2;
    private final int REFRESCO = 10;
    private final int TIMEOUT = 50;
    private final int MAX_REINTENTOS = 12;
    private final int CHECK_ASINCRONO = 500;
    private final int MAX_DESCONEXION = 333;
    private final int NUM_STV_ERR = 32;
    private final int SIZE_LOG_STV = 50;
    private Semaphore Semaforo_Lista_STV;
    private Udp sckSinc;
    private Udp sckAsinc;
    private Timer tmrTimeOut;
    private Timer tmrRefresco;
    private Timer tmrCheckPortAsinc;
    private Timer tmrInfoDesconexion;
    private Timer tmrInfoDesconexionAsinc;
    private principal Hebra;
    private ArrayList list_Command_STV;
    private sSTV_INFO STV_Info;
    private sSTV_COMM STV_COMANDO;
    private boolean STV_CONECTADO;
    private boolean STV_ASINC_CONECTADO;
    private byte STV_ASINC_INTENTOS;
    private String STV_STRING_ERR[][];
    boolean Procesandosend;
}
