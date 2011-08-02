package es.lda.core.lib.driver.stv;

import es.lda.core.exception.STVException;
import es.lda.core.lib.driver.IDriver;
import es.lda.core.lib.driver.stv.impl.STVInfo;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author Jose Antonio
 */
public interface STV extends IDriver{            
    
    /*byte connect(String IP) throws STVException;

    void dispose() throws STVException, InterruptedException;

    boolean getAsyncConnect() throws STVException;

    STVInfo getInfo() throws STVException;

    byte[] getNSupply(int i, int j);

    byte[] getNZone(int i, int j);

    String getSTVLog() throws STVException;

    boolean getSyncConnect() throws STVException;

    boolean isIp(String ip);

    byte setAmpAllMute(boolean mute) throws STVException;

    byte setAmpChMute(byte channel, boolean mute) throws STVException;

    byte setAmpCobraNetPrio(int addr_bundle, byte input_ch) throws STVException;

    byte setAmpCobraNetPrioModeEnable(boolean enable) throws STVException;

    byte setAmpDC(byte channel, short dc) throws STVException;

    byte setAmpDecayLimiter(byte channel, byte decay) throws STVException;

    byte setAmpEqualizer(byte channel, byte band, byte boost, int frec, int q_slope, byte gain) throws STVException;

    byte setAmpEqualizerEnable(byte channel, boolean enable) throws STVException;

    byte setAmpFilter(byte channel, int Frec, byte Gain) throws STVException;

    byte setAmpFilterEnable(byte channel, boolean enable) throws STVException;

    byte setAmpFilterPrio(byte boost, int frec, int q_slope, byte gain) throws STVException;

    byte setAmpFrecTone(byte channel, int frec) throws STVException;

    byte setAmpGain(byte channel, boolean e_s, byte gain) throws STVException;

    byte setAmpGainLinearInput(byte channel, short gain) throws STVException;

    byte setAmpGainLinearPrioInput(short gain) throws STVException;

    byte setAmpGainPrio(byte gain) throws STVException;

    byte setAmpGainTone(byte channel, byte gain) throws STVException;

    byte setAmpLevelPrioActive(boolean High) throws STVException;

    byte setAmpLimiterEnable(byte channel, boolean enable) throws STVException;

    byte setAmpLoudnessEnable(byte channel, boolean enable) throws STVException;

    byte setAmpModeAudioInput(boolean digital_input) throws STVException;

    byte setAmpModePrioActive(boolean signal_presense) throws STVException;

    byte setAmpPresets(byte channel, byte action) throws STVException;

    byte setAmpTCLimiter(byte channel, int tc) throws STVException;

    byte setAmpThresHoldActivePrio(byte threshold) throws STVException;

    byte setAmpThresholdLimiter(byte channel, byte threshold) throws STVException;

    byte setAmpToneEnable(byte channel, boolean enable) throws STVException;

    byte setCM2Enable(boolean enable) throws STVException;

    byte setCobraNet(byte channel, int addr_bundle, byte input_ch) throws STVException;

    byte setCobraNetSupplyName(byte channel, String nombre) throws STVException, UnsupportedEncodingException;

    byte setCobraNetZoneName(byte channel, String nombre) throws STVException, UnsupportedEncodingException;

    byte setDelayBootSupply(byte delay) throws STVException;

    byte setDeleteFrontalLogo() throws STVException;

    byte setEtherNetEnable(boolean enable) throws STVException;

    byte setFrontalLogo(byte[] logo) throws STVException;

    byte setPowerOn(boolean power_on) throws STVException;

    byte setSDCardEnable(boolean enable) throws STVException;

    byte setSTVModeLimiter(byte mode) throws STVException;

    byte setSTVModel(byte model) throws STVException;

    byte setSensingSupply(boolean enable) throws STVException;

    byte setSoftwareReset() throws STVException;*/
   
}
