package es.lda.core.lib.driver.stv.impl;

/**
 *
 * @author Jose Antonio
 */
public class STVModAmp {

    public STVCanal[] Canal = new STVCanal[2];
    public byte NewSense;
    public STVPrio Prio = new STVPrio();
    public byte tempAmb;
    public byte StateVentAmb;
    public long stateInfo;
    public int Reintentos_Comunicaciones;
}
