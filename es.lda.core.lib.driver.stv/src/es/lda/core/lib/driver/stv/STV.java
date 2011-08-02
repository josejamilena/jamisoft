package es.lda.core.lib.driver.stv;

import es.lda.core.exception.DriverException;
import es.lda.core.lib.driver.IDriver;
import es.lda.core.lib.driver.stv.impl.STVInfo;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author Jose Antonio
 */
public interface STV extends IDriver{            
    
    byte connect(String IP) throws DriverException;

    void dispose() throws DriverException, InterruptedException;

    boolean getAsyncConnect() throws DriverException;

    STVInfo getInfo() throws DriverException;

    byte[] getNSource(int i, int j);

    byte[] getNZone(int i, int j);

    String getSTVLog() throws DriverException;

    boolean getSyncConnect() throws DriverException;

    boolean isIp(String ip);

    byte setAmpAllMute(boolean mute) throws DriverException;

    byte setAmpChMute(byte channel, boolean mute) throws DriverException;

    byte setAmpCobraNetPrio(int addr_bundle, byte input_ch) throws DriverException;

    byte setAmpCobraNetPrioModeEnable(boolean enable) throws DriverException;

    byte setAmpDC(byte channel, short dc) throws DriverException;

    byte setAmpDecayLimiter(byte channel, byte decay) throws DriverException;

    byte setAmpEqualizer(byte channel, byte band, byte boost, int frec, int q_slope, byte gain) throws DriverException;

    byte setAmpEqualizerEnable(byte channel, boolean enable) throws DriverException;

    byte setAmpFilter(byte channel, int Frec, byte Gain) throws DriverException;

    byte setAmpFilterEnable(byte channel, boolean enable) throws DriverException;

    byte setAmpFilterPrio(byte boost, int frec, int q_slope, byte gain) throws DriverException;

    byte setAmpFrecTone(byte channel, int frec) throws DriverException;

    byte setAmpGain(byte channel, boolean e_s, byte gain) throws DriverException;

    byte setAmpGainLinearInput(byte channel, short gain) throws DriverException;

    byte setAmpGainLinearPrioInput(short gain) throws DriverException;

    byte setAmpGainPrio(byte gain) throws DriverException;

    byte setAmpGainTone(byte channel, byte gain) throws DriverException;

    byte setAmpLevelPrioActive(boolean High) throws DriverException;

    byte setAmpLimiterEnable(byte channel, boolean enable) throws DriverException;

    byte setAmpLoudnessEnable(byte channel, boolean enable) throws DriverException;

    byte setAmpModeAudioInput(boolean digital_input) throws DriverException;

    byte setAmpModePrioActive(boolean signal_presense) throws DriverException;

    byte setAmpPresets(byte channel, byte action) throws DriverException;

    byte setAmpTCLimiter(byte channel, int tc) throws DriverException;

    byte setAmpThresHoldActivePrio(byte threshold) throws DriverException;

    byte setAmpThresholdLimiter(byte channel, byte threshold) throws DriverException;

    byte setAmpToneEnable(byte channel, boolean enable) throws DriverException;

    byte setCM2Enable(boolean enable) throws DriverException;

    byte setCobraNet(byte channel, int addr_bundle, byte input_ch) throws DriverException;

    byte setCobraNetSourceName(byte channel, String nombre) throws DriverException, UnsupportedEncodingException;

    byte setCobraNetZoneName(byte channel, String nombre) throws DriverException, UnsupportedEncodingException;

    byte setDelayBootSource(byte delay) throws DriverException;

    byte setDeleteFrontalLogo() throws DriverException;

    byte setEtherNetEnable(boolean enable) throws DriverException;

    byte setFrontalLogo(byte[] logo) throws DriverException;

    byte setPowerOn(boolean power_on) throws DriverException;

    byte setSDCardEnable(boolean enable) throws DriverException;

    byte setSTVModeLimiter(byte mode) throws DriverException;

    byte setSTVModel(byte model) throws DriverException;

    byte setSettingSource(boolean enable) throws DriverException;

    byte setSoftwareReset() throws DriverException;
    
}
