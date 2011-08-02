package es.lda.core.lib.stv;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jose Antonio
 */
public class sSTV_CANAL {

    public byte GainInput;
    public byte GainOutput;
    public boolean EnableFilter;
    public int FrecFilter;
    public byte GainFilter;
    public boolean EnableLimiter;
    public byte ThresHoldLimiter;
    public int TCLimiter;
    public byte Decaylimiter;
    public boolean EnableEq;
    public byte[] BoostEq = new byte[7];
    public int[] FreqEq = new int[7];
    public int[] Q_SlopeEq = new int[7];
    public byte[] GainEq = new byte[7];
    public boolean EnableTone;
    public byte GainTone;
    public int FreqTone;
    public short DC;
    public short GainLinearInput;
    public boolean EnableLoudNess;
    public sSTV_SENSE Sense = new sSTV_SENSE();
    public sSTV_TEMP Temp = new sSTV_TEMP();
    public boolean PresetFabrica;
    public byte Mute;
    public byte Impedancia_Configurada;
    public byte Limite_Corto;
    public byte Limite_Abierto;
    public byte Autotest_Habilitado;
    public byte Limitador_Modo;
    public byte[] Nombre_Fuente_Cobranet = new byte[20];
    public byte[] Nombre_Zona_Cobranet = new byte[20];
    public int Direccion_Bundle_Cobranet;
    public int Canal_Bundle_Cobranet;
    public byte State_Line = 2;
    public boolean Protect;
}
