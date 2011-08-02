package es.lda.core.lib.stv;

/**
 *
 * @author Jose Antonio
 */
public class sSTV_INFO {

    public int[] usCM2_TxBundle = new int[5];
    public int[] usCM2_RxBundle = new int[9];
    public byte[][] ucCM2_TxSubMap = new byte[5][9];
    public byte[][] ucCM2_RxSubMap = new byte[9][9];
    public boolean[] bCM2_Status_Bundle_Ch = new boolean[4];
    public byte[] ucCM2_Salida = new byte[17];
    public byte errF_ALIM_180;
    public byte errF_ALIM_240;
    public long nArranques;
    public boolean lenguaje_ES;
    public byte num_canales;
    public boolean hay_SD;
    public boolean hay_EtherNet;
    public boolean hay_CobraNet;
    public byte tipo_Puerto_Serie;
    public boolean dos_canales_por_dis;
    public byte pot_canal;
    public byte tension_nominal;
    public byte corriente_nominal;
    public byte impedancia_nominal;
    public sSTV_ModAmp[] modAmp = new sSTV_ModAmp[2];
    public boolean Entrada_Digital;
    public boolean Power_On;
    public boolean Prioridad_CobraNet_Activa;
    public boolean Prioridad_Modo_Presencia;
    public byte Prioridad_Umbral_activacion;
    public boolean Prioridad_Activacion_5V;
    public boolean Prioridad_CobraNet_Habilitada;
    public boolean Trasera_Habilitada;
    public int Clave;
    public byte[] Errores = new byte[33];
    public byte[][] Log = new byte[51][2];
    public String Version;
    public boolean Hay_Logo;
    public byte State_Fan_ETX;
    public byte Temp_ETX;
    public float FNTE_ALIM_12V;
    public float FNTE_ALIM_12V_;
    public float FNTE_ALIM_75VD;
    public float FNTE_ALIM_75VD_;
    public float FNTE_ALIM_75VI;
    public float FNTE_ALIM_75VI_;
    public float FNTE_ALIM_230V;
    public float FNTE_ALIM_230I;
    public byte DelayArranque;
}
