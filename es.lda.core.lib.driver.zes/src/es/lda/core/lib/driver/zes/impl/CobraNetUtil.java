package es.lda.core.lib.driver.zes.impl;

import java.util.ResourceBundle;

/**
 *
 * @author Jose Antonio
 */
public class CobraNetUtil {

    private static final ResourceBundle config = ResourceBundle.getBundle("es/lda/core/lib/driver/zes/config/cobranet");    
    
    // #region "listado de Variables HMI "
    //*****************************************************'
    //*****************Direcciones HMI*********************'
    //*****************************************************'
    // Address rxBundle1
    public static final String rxBundle1 = config.getString("rxBundle1");
    // Address rxBundle2
    public static final String rxBundle2 = config.getString("rxBundle2");
    // Address rxBundle3
    public static final String rxBundle3 = config.getString("rxBundle3");
    // Address rxBundle4
    public static final String rxBundle4 = config.getString("rxBundle4");
    // Address rxBundle5
    public static final String rxBundle5 = config.getString("rxBundle5");
    // Address rxBundle6
    public static final String rxBundle6 = config.getString("rxBundle6");
    // Address rxBundle7
    public static final String rxBundle7 = config.getString("rxBundle7");
    // Address rxBundle8
    public static final String rxBundle8 = config.getString("rxBundle8");
    // Address txBundle1
    public static final String txBundle1 = config.getString("txBundle1");
    // Address txBundle2
    public static final String txBundle2 = config.getString("txBundle2");
    // Address txBundle3
    public static final String txBundle3 = config.getString("txBundle3");
    // Address txBundle4
    public static final String txBundle4 = config.getString("txBundle4");
    // Address rxSubMap 1 Bundle 1
    public static final String rxSubMap1B1 = config.getString("rxSubMap1B1");
    // Address rxSubMap 2 Bundle 1
    public static final String rxSubMap2B1 = config.getString("rxSubMap2B1");
    // Address rxSubMap 3 Bundle 1
    public static final String rxSubMap3B1 = config.getString("rxSubMap3B1");
    // Address rxSubMap 4 Bundle 1
    public static final String rxSubMap4B1 = config.getString("rxSubMap4B1");
    // Address rxSubMap 5 Bundle 1
    public static final String rxSubMap5B1 = config.getString("rxSubMap5B1");
    // Address rxSubMap 6 Bundle 1
    public static final String rxSubMap6B1 = config.getString("rxSubMap6B1");
    // Address rxSubMap 7 Bundle 1
    public static final String rxSubMap7B1 = config.getString("rxSubMap7B1");
    // Address rxSubMap 8 Bundle 1
    public static final String rxSubMap8B1 = config.getString("rxSubMap8B1");
    // Address rxSubMap 1 Bundle 2
    public static final String rxSubMap1B2 = config.getString("rxSubMap1B2");
    // Address rxSubMap 2 Bundle 2
    public static final String rxSubMap2B2 = config.getString("rxSubMap2B2");
    // Address rxSubMap 3 Bundle 2
    public static final String rxSubMap3B2 = config.getString("rxSubMap3B2");
    // Address rxSubMap 4 Bundle 2
    public static final String rxSubMap4B2 = config.getString("rxSubMap4B2");
    // Address rxSubMap 5 Bundle 2
    public static final String rxSubMap5B2 = config.getString("rxSubMap5B2");
    // Address rxSubMap 6 Bundle 2
    public static final String rxSubMap6B2 = config.getString("rxSubMap6B2");
    // Address rxSubMap 7 Bundle 2
    public static final String rxSubMap7B2 = config.getString("rxSubMap7B2");
    // Address rxSubMap 8 Bundle 2
    public static final String rxSubMap8B2 = config.getString("rxSubMap8B2");
    // Address rxSubMap 1 Bundle 3
    public static final String rxSubMap1B3 = config.getString("rxSubMap1B3");
    // Address rxSubMap 2 Bundle 3
    public static final String rxSubMap2B3 = config.getString("rxSubMap2B3");
    // Address rxSubMap 3 Bundle 3
    public static final String rxSubMap3B3 = config.getString("rxSubMap3B3");
    // Address rxSubMap 4 Bundle 3
    public static final String rxSubMap4B3 = config.getString("rxSubMap4B3");
    // Address rxSubMap 5 Bundle 3
    public static final String rxSubMap5B3 = config.getString("rxSubMap5B3");
    // Address rxSubMap 6 Bundle 3
    public static final String rxSubMap6B3 = config.getString("rxSubMap6B3");
    // Address rxSubMap 7 Bundle 3
    public static final String rxSubMap7B3 = config.getString("rxSubMap7B3");
    // Address rxSubMap 8 Bundle 3
    public static final String rxSubMap8B3 = config.getString("rxSubMap8B3");
    // Address rxSubMap 1 Bundle 4
    public static final String rxSubMap1B4 = config.getString("rxSubMap1B4");
    // Address rxSubMap 2 Bundle 4
    public static final String rxSubMap2B4 = config.getString("rxSubMap2B4");
    // Address rxSubMap 3 Bundle 4
    public static final String rxSubMap3B4 = config.getString("rxSubMap3B4");
    // Address rxSubMap 4 Bundle 4
    public static final String rxSubMap4B4 = config.getString("rxSubMap4B4");
    // Address rxSubMap 5 Bundle 4
    public static final String rxSubMap5B4 = config.getString("rxSubMap5B4");
    // Address rxSubMap 6 Bundle 4
    public static final String rxSubMap6B4 = config.getString("rxSubMap6B4");
    // Address rxSubMap 7 Bundle 4
    public static final String rxSubMap7B4 = config.getString("rxSubMap7B4");
    // Address rxSubMap 8 Bundle 4
    public static final String rxSubMap8B4 = config.getString("rxSubMap8B4");
    // Address rxSubMap 1 Bundle 5
    public static final String rxSubMap1B5 = config.getString("rxSubMap1B5");
    // Address rxSubMap 2 Bundle 5
    public static final String rxSubMap2B5 = config.getString("rxSubMap2B5");
    // Address rxSubMap 3 Bundle 5
    public static final String rxSubMap3B5 = config.getString("rxSubMap3B5");
    // Address rxSubMap 4 Bundle 5
    public static final String rxSubMap4B5 = config.getString("rxSubMap4B5");
    // Address rxSubMap 5 Bundle 5
    public static final String rxSubMap5B5 = config.getString("rxSubMap5B5");
    // Address rxSubMap 6 Bundle 5
    public static final String rxSubMap6B5 = config.getString("rxSubMap6B5");
    // Address rxSubMap 7 Bundle 5
    public static final String rxSubMap7B5 = config.getString("rxSubMap7B5");
    // Address rxSubMap 8 Bundle 5
    public static final String rxSubMap8B5 = config.getString("rxSubMap8B5");
    // Address rxSubMap 1 Bundle 6
    public static final String rxSubMap1B6 = config.getString("rxSubMap1B6");
    // Address rxSubMap 2 Bundle 6
    public static final String rxSubMap2B6 = config.getString("rxSubMap2B6");
    // Address rxSubMap 3 Bundle 6
    public static final String rxSubMap3B6 = config.getString("rxSubMap3B6");
    // Address rxSubMap 4 Bundle 6
    public static final String rxSubMap4B6 = config.getString("rxSubMap4B6");
    // Address rxSubMap 5 Bundle 6
    public static final String rxSubMap5B6 = config.getString("rxSubMap5B6");
    // Address rxSubMap 6 Bundle 6
    public static final String rxSubMap6B6 = config.getString("rxSubMap6B6");
    // Address rxSubMap 7 Bundle 6
    public static final String rxSubMap7B6 = config.getString("rxSubMap7B6");
    // Address rxSubMap 8 Bundle 6
    public static final String rxSubMap8B6 = config.getString("rxSubMap8B6");
    // Address rxSubMap 1 Bundle 7
    public static final String rxSubMap1B7 = config.getString("rxSubMap1B7");
    // Address rxSubMap 2 Bundle 7
    public static final String rxSubMap2B7 = config.getString("rxSubMap2B7");
    // Address rxSubMap 3 Bundle 7
    public static final String rxSubMap3B7 = config.getString("rxSubMap3B7");
    // Address rxSubMap 4 Bundle 7
    public static final String rxSubMap4B7 = config.getString("rxSubMap4B7");
    // Address rxSubMap 5 Bundle 7
    public static final String rxSubMap5B7 = config.getString("rxSubMap5B7");
    // Address rxSubMap 6 Bundle 7
    public static final String rxSubMap6B7 = config.getString("rxSubMap6B7");
    // Address rxSubMap 7 Bundle 7
    public static final String rxSubMap7B7 = config.getString("rxSubMap7B7");
    // Address rxSubMap 8 Bundle 7
    public static final String rxSubMap8B7 = config.getString("rxSubMap8B7");
    // Address rxSubMap 1 Bundle 8
    public static final String rxSubMap1B8 = config.getString("rxSubMap1B8");
    // Address rxSubMap 2 Bundle 8
    public static final String rxSubMap2B8 = config.getString("rxSubMap2B8");
    // Address rxSubMap 3 Bundle 8
    public static final String rxSubMap3B8 = config.getString("rxSubMap3B8");
    // Address rxSubMap 4 Bundle 8
    public static final String rxSubMap4B8 = config.getString("rxSubMap4B8");
    // Address rxSubMap 5 Bundle 8
    public static final String rxSubMap5B8 = config.getString("rxSubMap5B8");
    // Address rxSubMap 6 Bundle 8
    public static final String rxSubMap6B8 = config.getString("rxSubMap6B8");
    // Address rxSubMap 7 Bundle 8
    public static final String rxSubMap7B8 = config.getString("rxSubMap7B8");
    // Address rxSubMap 8 Bundle 8
    public static final String rxSubMap8B8 = config.getString("rxSubMap8B8");
    // Address txSubMap 1 Bundle 1
    public static final String txSubMap1B1 = config.getString("txSubMap1B1");
    // Address txSubMap 2 Bundle 1
    public static final String txSubMap2B1 = config.getString("txSubMap2B1");
    // Address txSubMap 3 Bundle 1
    public static final String txSubMap3B1 = config.getString("txSubMap3B1");
    // Address txSubMap 4 Bundle 1
    public static final String txSubMap4B1 = config.getString("txSubMap4B1");
    // Address txSubMap 5 Bundle 1
    public static final String txSubMap5B1 = config.getString("txSubMap5B1");
    // Address txSubMap 6 Bundle 1
    public static final String txSubMap6B1 = config.getString("txSubMap6B1");
    // Address txSubMap 7 Bundle 1
    public static final String txSubMap7B1 = config.getString("txSubMap7B1");
    // Address txSubMap 8 Bundle 1
    public static final String txSubMap8B1 = config.getString("txSubMap8B1");
    // Address txSubMap 1 Bundle 2
    public static final String txSubMap1B2 = config.getString("txSubMap1B2");
    // Address txSubMap 2 Bundle 2
    public static final String txSubMap2B2 = config.getString("txSubMap2B2");
    // Address txSubMap 3 Bundle 2
    public static final String txSubMap3B2 = config.getString("txSubMap3B2");
    // Address txSubMap 4 Bundle 2
    public static final String txSubMap4B2 = config.getString("txSubMap4B2");
    // Address txSubMap 5 Bundle 2
    public static final String txSubMap5B2 = config.getString("txSubMap5B2");
    // Address txSubMap 6 Bundle 2
    public static final String txSubMap6B2 = config.getString("txSubMap6B2");
    // Address txSubMap 7 Bundle 2
    public static final String txSubMap7B2 = config.getString("txSubMap7B2");
    // Address txSubMap 8 Bundle 2
    public static final String txSubMap8B2 = config.getString("txSubMap8B2");
    // Address txSubMap 1 Bundle 3
    public static final String txSubMap1B3 = config.getString("txSubMap1B3");
    // Address txSubMap 2 Bundle 3
    public static final String txSubMap2B3 = config.getString("txSubMap2B3");
    // Address txSubMap 3 Bundle 3
    public static final String txSubMap3B3 = config.getString("txSubMap3B3");
    // Address txSubMap 4 Bundle 3
    public static final String txSubMap4B3 = config.getString("txSubMap4B3");
    // Address txSubMap 5 Bundle 3
    public static final String txSubMap5B3 = config.getString("txSubMap5B3");
    // Address txSubMap 6 Bundle 3
    public static final String txSubMap6B3 = config.getString("txSubMap6B3");
    // Address txSubMap 7 Bundle 3
    public static final String txSubMap7B3 = config.getString("txSubMap7B3");
    // Address txSubMap 8 Bundle 3
    public static final String txSubMap8B3 = config.getString("txSubMap8B3");
    // Address txSubMap 1 Bundle 4
    public static final String txSubMap1B4 = config.getString("txSubMap1B4");
    // Address txSubMap 2 Bundle 4
    public static final String txSubMap2B4 = config.getString("txSubMap2B4");
    // Address txSubMap 3 Bundle 4
    public static final String txSubMap3B4 = config.getString("txSubMap3B4");
    // Address txSubMap 4 Bundle 4
    public static final String txSubMap4B4 = config.getString("txSubMap4B4");
    // Address txSubMap 5 Bundle 4
    public static final String txSubMap5B4 = config.getString("txSubMap5B4");
    // Address txSubMap 6 Bundle 4
    public static final String txSubMap6B4 = config.getString("txSubMap6B4");
    // Address txSubMap 7 Bundle 4
    public static final String txSubMap7B4 = config.getString("txSubMap7B4");
    // Address txSubMap 8 Bundle 4
    public static final String txSubMap8B4 = config.getString("txSubMap8B4");
    //gain_down_24dB_multi_channel: NetRX Levels
    public static final String CS496122_NetRXLevels_g1 = config.getString("CS496122_NetRXLevels_g1");
    public static final String CS496122_NetRXLevels_g2 = config.getString("CS496122_NetRXLevels_g2");
    public static final String CS496122_NetRXLevels_g3 = config.getString("CS496122_NetRXLevels_g3");
    public static final String CS496122_NetRXLevels_g4 = config.getString("CS496122_NetRXLevels_g4");
    public static final String CS496122_NetRXLevels_g5 = config.getString("CS496122_NetRXLevels_g5");
    public static final String CS496122_NetRXLevels_g6 = config.getString("CS496122_NetRXLevels_g6");
    public static final String CS496122_NetRXLevels_g7 = config.getString("CS496122_NetRXLevels_g7");
    public static final String CS496122_NetRXLevels_g8 = config.getString("CS496122_NetRXLevels_g8");
    public static final String CS496122_NetRXLevels_ramp = config.getString("CS496122_NetRXLevels_ramp");
    //gain_down_24dB_multi_channel: DAI Levels
    public static final String CS496122_DAILevels_g1 = config.getString("CS496122_DAILevels_g1");
    public static final String CS496122_DAILevels_g2 = config.getString("CS496122_DAILevels_g2");
    public static final String CS496122_DAILevels_g3 = config.getString("CS496122_DAILevels_g3");
    public static final String CS496122_DAILevels_g4 = config.getString("CS496122_DAILevels_g4");
    public static final String CS496122_DAILevels_g5 = config.getString("CS496122_DAILevels_g5");
    public static final String CS496122_DAILevels_g6 = config.getString("CS496122_DAILevels_g6");
    public static final String CS496122_DAILevels_g7 = config.getString("CS496122_DAILevels_g7");
    public static final String CS496122_DAILevels_g8 = config.getString("CS496122_DAILevels_g8");
    public static final String CS496122_DAILevels_ramp = config.getString("CS496122_DAILevels_ramp");
    //generator_sine_wave: SNG
    public static final String DSP_TNO8_SNG_gain = config.getString("DSP_TNO8_SNG_gain");
    public static final String DSP_TNO8_SNG_omega = config.getString("DSP_TNO8_SNG_omega");
    public static final String DSP_TNO8_SNG_ramp = config.getString("DSP_TNO8_SNG_ramp");
    //detector_mean_square: Mean Square Detector
    public static final String DSP_CSI8_8_MeanSquareDetector_inputdisable1 = config.getString("DSP_CSI8_8_MeanSquareDetector_inputdisable1");
    public static final String DSP_CSI8_8_MeanSquareDetector_maxrms = config.getString("DSP_CSI8_8_MeanSquareDetector_maxrms");
    public static final String DSP_CSI8_8_MeanSquareDetector_tc = config.getString("DSP_CSI8_8_MeanSquareDetector_tc");
    //dynamic_compressor: Compressor
    public static final String DSP_CSI8_8_Compressor_dspattack = config.getString("DSP_CSI8_8_Compressor_dspattack");
    public static final String DSP_CSI8_8_Compressor_dspbypass = config.getString("DSP_CSI8_8_Compressor_dspbypass");
    public static final String DSP_CSI8_8_Compressor_dspratio = config.getString("DSP_CSI8_8_Compressor_dspratio");
    public static final String DSP_CSI8_8_Compressor_dspreduction = config.getString("DSP_CSI8_8_Compressor_dspreduction");
    public static final String DSP_CSI8_8_Compressor_dsprelease = config.getString("DSP_CSI8_8_Compressor_dsprelease");
    public static final String DSP_CSI8_8_Compressor_region = config.getString("DSP_CSI8_8_Compressor_region");
    public static final String DSP_CSI8_8_Compressor_softknee = config.getString("DSP_CSI8_8_Compressor_softknee");
    public static final String DSP_CSI8_8_Compressor_threshold = config.getString("DSP_CSI8_8_Compressor_threshold");
    //equalizer_parametric_transposed_direct_II: B1
    public static final String DSP_EQI8_8_B1_a = config.getString("DSP_EQI8_8_B1_a");
    public static final String DSP_EQI8_8_B1_b = config.getString("DSP_EQI8_8_B1_b");
    public static final String DSP_EQI8_8_B1_clip = config.getString("DSP_EQI8_8_B1_clip");
    public static final String DSP_EQI8_8_B1_g = config.getString("DSP_EQI8_8_B1_g");
    public static final String DSP_EQI8_8_B1_holdcount = config.getString("DSP_EQI8_8_B1_holdcount");
    public static final String DSP_EQI8_8_B1_minusone = config.getString("DSP_EQI8_8_B1_minusone");
    public static final String DSP_EQI8_8_B1_ramp = config.getString("DSP_EQI8_8_B1_ramp");
    //equalizer_parametric_transposed_direct_II: B2
    public static final String DSP_EQI8_8_B2_a = config.getString("DSP_EQI8_8_B2_a");
    public static final String DSP_EQI8_8_B2_b = config.getString("DSP_EQI8_8_B2_b");
    public static final String DSP_EQI8_8_B2_clip = config.getString("DSP_EQI8_8_B2_clip");
    public static final String DSP_EQI8_8_B2_g = config.getString("DSP_EQI8_8_B2_g");
    public static final String DSP_EQI8_8_B2_holdcount = config.getString("DSP_EQI8_8_B2_holdcount");
    public static final String DSP_EQI8_8_B2_minusone = config.getString("DSP_EQI8_8_B2_minusone");
    public static final String DSP_EQI8_8_B2_ramp = config.getString("DSP_EQI8_8_B2_ramp");
    //equalizer_parametric_transposed_direct_II: B3
    public static final String DSP_EQI8_8_B3_a = config.getString("DSP_EQI8_8_B3_a");
    public static final String DSP_EQI8_8_B3_b = config.getString("DSP_EQI8_8_B3_b");
    public static final String DSP_EQI8_8_B3_clip = config.getString("DSP_EQI8_8_B3_clip");
    public static final String DSP_EQI8_8_B3_g = config.getString("DSP_EQI8_8_B3_g");
    public static final String DSP_EQI8_8_B3_holdcount = config.getString("DSP_EQI8_8_B3_holdcount");
    public static final String DSP_EQI8_8_B3_minusone = config.getString("DSP_EQI8_8_B3_minusone");
    public static final String DSP_EQI8_8_B3_ramp = config.getString("DSP_EQI8_8_B3_ramp");
    //equalizer_parametric_transposed_direct_II: B4
    public static final String DSP_EQI8_8_B4_a = config.getString("DSP_EQI8_8_B4_a");
    public static final String DSP_EQI8_8_B4_b = config.getString("DSP_EQI8_8_B4_b");
    public static final String DSP_EQI8_8_B4_clip = config.getString("DSP_EQI8_8_B4_clip");
    public static final String DSP_EQI8_8_B4_g = config.getString("DSP_EQI8_8_B4_g");
    public static final String DSP_EQI8_8_B4_holdcount = config.getString("DSP_EQI8_8_B4_holdcount");
    public static final String DSP_EQI8_8_B4_minusone = config.getString("DSP_EQI8_8_B4_minusone");
    public static final String DSP_EQI8_8_B4_ramp = config.getString("DSP_EQI8_8_B4_ramp");
    //equalizer_parametric_transposed_direct_II: B5
    public static final String DSP_EQI8_8_B5_a = config.getString("DSP_EQI8_8_B5_a");
    public static final String DSP_EQI8_8_B5_b = config.getString("DSP_EQI8_8_B5_b");
    public static final String DSP_EQI8_8_B5_clip = config.getString("DSP_EQI8_8_B5_clip");
    public static final String DSP_EQI8_8_B5_g = config.getString("DSP_EQI8_8_B5_g");
    public static final String DSP_EQI8_8_B5_holdcount = config.getString("DSP_EQI8_8_B5_holdcount");
    public static final String DSP_EQI8_8_B5_minusone = config.getString("DSP_EQI8_8_B5_minusone");
    public static final String DSP_EQI8_8_B5_ramp = config.getString("DSP_EQI8_8_B5_ramp");
    //equalizer_parametric_transposed_direct_II: B6
    public static final String DSP_EQI8_8_B6_a = config.getString("DSP_EQI8_8_B6_a");
    public static final String DSP_EQI8_8_B6_b = config.getString("DSP_EQI8_8_B6_b");
    public static final String DSP_EQI8_8_B6_clip = config.getString("DSP_EQI8_8_B6_clip");
    public static final String DSP_EQI8_8_B6_g = config.getString("DSP_EQI8_8_B6_g");
    public static final String DSP_EQI8_8_B6_holdcount = config.getString("DSP_EQI8_8_B6_holdcount");
    public static final String DSP_EQI8_8_B6_minusone = config.getString("DSP_EQI8_8_B6_minusone");
    public static final String DSP_EQI8_8_B6_ramp = config.getString("DSP_EQI8_8_B6_ramp");
    //equalizer_parametric_transposed_direct_II: B7
    public static final String DSP_EQI8_8_B7_a = config.getString("DSP_EQI8_8_B7_a");
    public static final String DSP_EQI8_8_B7_b = config.getString("DSP_EQI8_8_B7_b");
    public static final String DSP_EQI8_8_B7_clip = config.getString("DSP_EQI8_8_B7_clip");
    public static final String DSP_EQI8_8_B7_g = config.getString("DSP_EQI8_8_B7_g");
    public static final String DSP_EQI8_8_B7_holdcount = config.getString("DSP_EQI8_8_B7_holdcount");
    public static final String DSP_EQI8_8_B7_minusone = config.getString("DSP_EQI8_8_B7_minusone");
    public static final String DSP_EQI8_8_B7_ramp = config.getString("DSP_EQI8_8_B7_ramp");
    //detector_mean_square: Mean Square Detector
    public static final String DSP_CSI8_7_MeanSquareDetector_inputdisable1 = config.getString("DSP_CSI8_7_MeanSquareDetector_inputdisable1");
    public static final String DSP_CSI8_7_MeanSquareDetector_maxrms = config.getString("DSP_CSI8_7_MeanSquareDetector_maxrms");
    public static final String DSP_CSI8_7_MeanSquareDetector_tc = config.getString("DSP_CSI8_7_MeanSquareDetector_tc");
    //dynamic_compressor: Compressor
    public static final String DSP_CSI8_7_Compressor_dspattack = config.getString("DSP_CSI8_7_Compressor_dspattack");
    public static final String DSP_CSI8_7_Compressor_dspbypass = config.getString("DSP_CSI8_7_Compressor_dspbypass");
    public static final String DSP_CSI8_7_Compressor_dspratio = config.getString("DSP_CSI8_7_Compressor_dspratio");
    public static final String DSP_CSI8_7_Compressor_dspreduction = config.getString("DSP_CSI8_7_Compressor_dspreduction");
    public static final String DSP_CSI8_7_Compressor_dsprelease = config.getString("DSP_CSI8_7_Compressor_dsprelease");
    public static final String DSP_CSI8_7_Compressor_region = config.getString("DSP_CSI8_7_Compressor_region");
    public static final String DSP_CSI8_7_Compressor_softknee = config.getString("DSP_CSI8_7_Compressor_softknee");
    public static final String DSP_CSI8_7_Compressor_threshold = config.getString("DSP_CSI8_7_Compressor_threshold");
    //equalizer_parametric_transposed_direct_II: B1
    public static final String DSP_EQI8_7_B1_a = config.getString("DSP_EQI8_7_B1_a");
    public static final String DSP_EQI8_7_B1_b = config.getString("DSP_EQI8_7_B1_b");
    public static final String DSP_EQI8_7_B1_clip = config.getString("DSP_EQI8_7_B1_clip");
    public static final String DSP_EQI8_7_B1_g = config.getString("DSP_EQI8_7_B1_g");
    public static final String DSP_EQI8_7_B1_holdcount = config.getString("DSP_EQI8_7_B1_holdcount");
    public static final String DSP_EQI8_7_B1_minusone = config.getString("DSP_EQI8_7_B1_minusone");
    public static final String DSP_EQI8_7_B1_ramp = config.getString("DSP_EQI8_7_B1_ramp");
    //equalizer_parametric_transposed_direct_II: B2
    public static final String DSP_EQI8_7_B2_a = config.getString("DSP_EQI8_7_B2_a");
    public static final String DSP_EQI8_7_B2_b = config.getString("DSP_EQI8_7_B2_b");
    public static final String DSP_EQI8_7_B2_clip = config.getString("DSP_EQI8_7_B2_clip");
    public static final String DSP_EQI8_7_B2_g = config.getString("DSP_EQI8_7_B2_g");
    public static final String DSP_EQI8_7_B2_holdcount = config.getString("DSP_EQI8_7_B2_holdcount");
    public static final String DSP_EQI8_7_B2_minusone = config.getString("DSP_EQI8_7_B2_minusone");
    public static final String DSP_EQI8_7_B2_ramp = config.getString("DSP_EQI8_7_B2_ramp");
    //equalizer_parametric_transposed_direct_II: B3
    public static final String DSP_EQI8_7_B3_a = config.getString("DSP_EQI8_7_B3_a");
    public static final String DSP_EQI8_7_B3_b = config.getString("DSP_EQI8_7_B3_b");
    public static final String DSP_EQI8_7_B3_clip = config.getString("DSP_EQI8_7_B3_clip");
    public static final String DSP_EQI8_7_B3_g = config.getString("DSP_EQI8_7_B3_g");
    public static final String DSP_EQI8_7_B3_holdcount = config.getString("DSP_EQI8_7_B3_holdcount");
    public static final String DSP_EQI8_7_B3_minusone = config.getString("DSP_EQI8_7_B3_minusone");
    public static final String DSP_EQI8_7_B3_ramp = config.getString("DSP_EQI8_7_B3_ramp");
    //equalizer_parametric_transposed_direct_II: B4
    public static final String DSP_EQI8_7_B4_a = config.getString("DSP_EQI8_7_B4_a");
    public static final String DSP_EQI8_7_B4_b = config.getString("DSP_EQI8_7_B4_b");
    public static final String DSP_EQI8_7_B4_clip = config.getString("DSP_EQI8_7_B4_clip");
    public static final String DSP_EQI8_7_B4_g = config.getString("DSP_EQI8_7_B4_g");
    public static final String DSP_EQI8_7_B4_holdcount = config.getString("DSP_EQI8_7_B4_holdcount");
    public static final String DSP_EQI8_7_B4_minusone = config.getString("DSP_EQI8_7_B4_minusone");
    public static final String DSP_EQI8_7_B4_ramp = config.getString("DSP_EQI8_7_B4_ramp");
    //equalizer_parametric_transposed_direct_II: B5
    public static final String DSP_EQI8_7_B5_a = config.getString("DSP_EQI8_7_B5_a");
    public static final String DSP_EQI8_7_B5_b = config.getString("DSP_EQI8_7_B5_b");
    public static final String DSP_EQI8_7_B5_clip = config.getString("DSP_EQI8_7_B5_clip");
    public static final String DSP_EQI8_7_B5_g = config.getString("DSP_EQI8_7_B5_g");
    public static final String DSP_EQI8_7_B5_holdcount = config.getString("DSP_EQI8_7_B5_holdcount");
    public static final String DSP_EQI8_7_B5_minusone = config.getString("DSP_EQI8_7_B5_minusone");
    public static final String DSP_EQI8_7_B5_ramp = config.getString("DSP_EQI8_7_B5_ramp");
    //equalizer_parametric_transposed_direct_II: B6
    public static final String DSP_EQI8_7_B6_a = config.getString("DSP_EQI8_7_B6_a");
    public static final String DSP_EQI8_7_B6_b = config.getString("DSP_EQI8_7_B6_b");
    public static final String DSP_EQI8_7_B6_clip = config.getString("DSP_EQI8_7_B6_clip");
    public static final String DSP_EQI8_7_B6_g = config.getString("DSP_EQI8_7_B6_g");
    public static final String DSP_EQI8_7_B6_holdcount = config.getString("DSP_EQI8_7_B6_holdcount");
    public static final String DSP_EQI8_7_B6_minusone = config.getString("DSP_EQI8_7_B6_minusone");
    public static final String DSP_EQI8_7_B6_ramp = config.getString("DSP_EQI8_7_B6_ramp");
    //equalizer_parametric_transposed_direct_II: B7
    public static final String DSP_EQI8_7_B7_a = config.getString("DSP_EQI8_7_B7_a");
    public static final String DSP_EQI8_7_B7_b = config.getString("DSP_EQI8_7_B7_b");
    public static final String DSP_EQI8_7_B7_clip = config.getString("DSP_EQI8_7_B7_clip");
    public static final String DSP_EQI8_7_B7_g = config.getString("DSP_EQI8_7_B7_g");
    public static final String DSP_EQI8_7_B7_holdcount = config.getString("DSP_EQI8_7_B7_holdcount");
    public static final String DSP_EQI8_7_B7_minusone = config.getString("DSP_EQI8_7_B7_minusone");
    public static final String DSP_EQI8_7_B7_ramp = config.getString("DSP_EQI8_7_B7_ramp");
    //detector_mean_square: Mean Square Detector
    public static final String DSP_CSI8_6_MeanSquareDetector_inputdisable1 = config.getString("DSP_CSI8_6_MeanSquareDetector_inputdisable1");
    public static final String DSP_CSI8_6_MeanSquareDetector_maxrms = config.getString("DSP_CSI8_6_MeanSquareDetector_maxrms");
    public static final String DSP_CSI8_6_MeanSquareDetector_tc = config.getString("DSP_CSI8_6_MeanSquareDetector_tc");
    //dynamic_compressor: Compressor
    public static final String DSP_CSI8_6_Compressor_dspattack = config.getString("DSP_CSI8_6_Compressor_dspattack");
    public static final String DSP_CSI8_6_Compressor_dspbypass = config.getString("DSP_CSI8_6_Compressor_dspbypass");
    public static final String DSP_CSI8_6_Compressor_dspratio = config.getString("DSP_CSI8_6_Compressor_dspratio");
    public static final String DSP_CSI8_6_Compressor_dspreduction = config.getString("DSP_CSI8_6_Compressor_dspreduction");
    public static final String DSP_CSI8_6_Compressor_dsprelease = config.getString("DSP_CSI8_6_Compressor_dsprelease");
    public static final String DSP_CSI8_6_Compressor_region = config.getString("DSP_CSI8_6_Compressor_region");
    public static final String DSP_CSI8_6_Compressor_softknee = config.getString("DSP_CSI8_6_Compressor_softknee");
    public static final String DSP_CSI8_6_Compressor_threshold = config.getString("DSP_CSI8_6_Compressor_threshold");
    //equalizer_parametric_transposed_direct_II: B1
    public static final String DSP_EQI8_6_B1_a = config.getString("DSP_EQI8_6_B1_a");
    public static final String DSP_EQI8_6_B1_b = config.getString("DSP_EQI8_6_B1_b");
    public static final String DSP_EQI8_6_B1_clip = config.getString("DSP_EQI8_6_B1_clip");
    public static final String DSP_EQI8_6_B1_g = config.getString("DSP_EQI8_6_B1_g");
    public static final String DSP_EQI8_6_B1_holdcount = config.getString("DSP_EQI8_6_B1_holdcount");
    public static final String DSP_EQI8_6_B1_minusone = config.getString("DSP_EQI8_6_B1_minusone");
    public static final String DSP_EQI8_6_B1_ramp = config.getString("DSP_EQI8_6_B1_ramp");
    //equalizer_parametric_transposed_direct_II: B2
    public static final String DSP_EQI8_6_B2_a = config.getString("DSP_EQI8_6_B2_a");
    public static final String DSP_EQI8_6_B2_b = config.getString("DSP_EQI8_6_B2_b");
    public static final String DSP_EQI8_6_B2_clip = config.getString("DSP_EQI8_6_B2_clip");
    public static final String DSP_EQI8_6_B2_g = config.getString("DSP_EQI8_6_B2_g");
    public static final String DSP_EQI8_6_B2_holdcount = config.getString("DSP_EQI8_6_B2_holdcount");
    public static final String DSP_EQI8_6_B2_minusone = config.getString("DSP_EQI8_6_B2_minusone");
    public static final String DSP_EQI8_6_B2_ramp = config.getString("DSP_EQI8_6_B2_ramp");
    //equalizer_parametric_transposed_direct_II: B3
    public static final String DSP_EQI8_6_B3_a = config.getString("DSP_EQI8_6_B3_a");
    public static final String DSP_EQI8_6_B3_b = config.getString("DSP_EQI8_6_B3_b");
    public static final String DSP_EQI8_6_B3_clip = config.getString("DSP_EQI8_6_B3_clip");
    public static final String DSP_EQI8_6_B3_g = config.getString("DSP_EQI8_6_B3_g");
    public static final String DSP_EQI8_6_B3_holdcount = config.getString("DSP_EQI8_6_B3_holdcount");
    public static final String DSP_EQI8_6_B3_minusone = config.getString("DSP_EQI8_6_B3_minusone");
    public static final String DSP_EQI8_6_B3_ramp = config.getString("DSP_EQI8_6_B3_ramp");
    //equalizer_parametric_transposed_direct_II: B4
    public static final String DSP_EQI8_6_B4_a = config.getString("DSP_EQI8_6_B4_a");
    public static final String DSP_EQI8_6_B4_b = config.getString("DSP_EQI8_6_B4_b");
    public static final String DSP_EQI8_6_B4_clip = config.getString("DSP_EQI8_6_B4_clip");
    public static final String DSP_EQI8_6_B4_g = config.getString("DSP_EQI8_6_B4_g");
    public static final String DSP_EQI8_6_B4_holdcount = config.getString("DSP_EQI8_6_B4_holdcount");
    public static final String DSP_EQI8_6_B4_minusone = config.getString("DSP_EQI8_6_B4_minusone");
    public static final String DSP_EQI8_6_B4_ramp = config.getString("DSP_EQI8_6_B4_ramp");
    //equalizer_parametric_transposed_direct_II: B5
    public static final String DSP_EQI8_6_B5_a = config.getString("DSP_EQI8_6_B5_a");
    public static final String DSP_EQI8_6_B5_b = config.getString("DSP_EQI8_6_B5_b");
    public static final String DSP_EQI8_6_B5_clip = config.getString("DSP_EQI8_6_B5_clip");
    public static final String DSP_EQI8_6_B5_g = config.getString("DSP_EQI8_6_B5_g");
    public static final String DSP_EQI8_6_B5_holdcount = config.getString("DSP_EQI8_6_B5_holdcount");
    public static final String DSP_EQI8_6_B5_minusone = config.getString("DSP_EQI8_6_B5_minusone");
    public static final String DSP_EQI8_6_B5_ramp = config.getString("DSP_EQI8_6_B5_ramp");
    //equalizer_parametric_transposed_direct_II: B6
    public static final String DSP_EQI8_6_B6_a = config.getString("DSP_EQI8_6_B6_a");
    public static final String DSP_EQI8_6_B6_b = config.getString("DSP_EQI8_6_B6_b");
    public static final String DSP_EQI8_6_B6_clip = config.getString("DSP_EQI8_6_B6_clip");
    public static final String DSP_EQI8_6_B6_g = config.getString("DSP_EQI8_6_B6_g");
    public static final String DSP_EQI8_6_B6_holdcount = config.getString("DSP_EQI8_6_B6_holdcount");
    public static final String DSP_EQI8_6_B6_minusone = config.getString("DSP_EQI8_6_B6_minusone");
    public static final String DSP_EQI8_6_B6_ramp = config.getString("DSP_EQI8_6_B6_ramp");
    //equalizer_parametric_transposed_direct_II: B7
    public static final String DSP_EQI8_6_B7_a = config.getString("DSP_EQI8_6_B7_a");
    public static final String DSP_EQI8_6_B7_b = config.getString("DSP_EQI8_6_B7_b");
    public static final String DSP_EQI8_6_B7_clip = config.getString("DSP_EQI8_6_B7_clip");
    public static final String DSP_EQI8_6_B7_g = config.getString("DSP_EQI8_6_B7_g");
    public static final String DSP_EQI8_6_B7_holdcount = config.getString("DSP_EQI8_6_B7_holdcount");
    public static final String DSP_EQI8_6_B7_minusone = config.getString("DSP_EQI8_6_B7_minusone");
    public static final String DSP_EQI8_6_B7_ramp = config.getString("DSP_EQI8_6_B7_ramp");
    //detector_mean_square: Mean Square Detector
    public static final String DSP_CSI8_5_MeanSquareDetector_inputdisable1 = config.getString("DSP_CSI8_5_MeanSquareDetector_inputdisable1");
    public static final String DSP_CSI8_5_MeanSquareDetector_maxrms = config.getString("DSP_CSI8_5_MeanSquareDetector_maxrms");
    public static final String DSP_CSI8_5_MeanSquareDetector_tc = config.getString("DSP_CSI8_5_MeanSquareDetector_tc");
    //dynamic_compressor: Compressor
    public static final String DSP_CSI8_5_Compressor_dspattack = config.getString("DSP_CSI8_5_Compressor_dspattack");
    public static final String DSP_CSI8_5_Compressor_dspbypass = config.getString("DSP_CSI8_5_Compressor_dspbypass");
    public static final String DSP_CSI8_5_Compressor_dspratio = config.getString("DSP_CSI8_5_Compressor_dspratio");
    public static final String DSP_CSI8_5_Compressor_dspreduction = config.getString("DSP_CSI8_5_Compressor_dspreduction");
    public static final String DSP_CSI8_5_Compressor_dsprelease = config.getString("DSP_CSI8_5_Compressor_dsprelease");
    public static final String DSP_CSI8_5_Compressor_region = config.getString("DSP_CSI8_5_Compressor_region");
    public static final String DSP_CSI8_5_Compressor_softknee = config.getString("DSP_CSI8_5_Compressor_softknee");
    public static final String DSP_CSI8_5_Compressor_threshold = config.getString("DSP_CSI8_5_Compressor_threshold");
    //equalizer_parametric_transposed_direct_II: B1
    public static final String DSP_EQI8_5_B1_a = config.getString("DSP_EQI8_5_B1_a");
    public static final String DSP_EQI8_5_B1_b = config.getString("DSP_EQI8_5_B1_b");
    public static final String DSP_EQI8_5_B1_clip = config.getString("DSP_EQI8_5_B1_clip");
    public static final String DSP_EQI8_5_B1_g = config.getString("DSP_EQI8_5_B1_g");
    public static final String DSP_EQI8_5_B1_holdcount = config.getString("DSP_EQI8_5_B1_holdcount");
    public static final String DSP_EQI8_5_B1_minusone = config.getString("DSP_EQI8_5_B1_minusone");
    public static final String DSP_EQI8_5_B1_ramp = config.getString("DSP_EQI8_5_B1_ramp");
    //equalizer_parametric_transposed_direct_II: B2
    public static final String DSP_EQI8_5_B2_a = config.getString("DSP_EQI8_5_B2_a");
    public static final String DSP_EQI8_5_B2_b = config.getString("DSP_EQI8_5_B2_b");
    public static final String DSP_EQI8_5_B2_clip = config.getString("DSP_EQI8_5_B2_clip");
    public static final String DSP_EQI8_5_B2_g = config.getString("DSP_EQI8_5_B2_g");
    public static final String DSP_EQI8_5_B2_holdcount = config.getString("DSP_EQI8_5_B2_holdcount");
    public static final String DSP_EQI8_5_B2_minusone = config.getString("DSP_EQI8_5_B2_minusone");
    public static final String DSP_EQI8_5_B2_ramp = config.getString("DSP_EQI8_5_B2_ramp");
    //equalizer_parametric_transposed_direct_II: B3
    public static final String DSP_EQI8_5_B3_a = config.getString("DSP_EQI8_5_B3_a");
    public static final String DSP_EQI8_5_B3_b = config.getString("DSP_EQI8_5_B3_b");
    public static final String DSP_EQI8_5_B3_clip = config.getString("DSP_EQI8_5_B3_clip");
    public static final String DSP_EQI8_5_B3_g = config.getString("DSP_EQI8_5_B3_g");
    public static final String DSP_EQI8_5_B3_holdcount = config.getString("DSP_EQI8_5_B3_holdcount");
    public static final String DSP_EQI8_5_B3_minusone = config.getString("DSP_EQI8_5_B3_minusone");
    public static final String DSP_EQI8_5_B3_ramp = config.getString("DSP_EQI8_5_B3_ramp");
    //equalizer_parametric_transposed_direct_II: B4
    public static final String DSP_EQI8_5_B4_a = config.getString("DSP_EQI8_5_B4_a");
    public static final String DSP_EQI8_5_B4_b = config.getString("DSP_EQI8_5_B4_b");
    public static final String DSP_EQI8_5_B4_clip = config.getString("DSP_EQI8_5_B4_clip");
    public static final String DSP_EQI8_5_B4_g = config.getString("DSP_EQI8_5_B4_g");
    public static final String DSP_EQI8_5_B4_holdcount = config.getString("DSP_EQI8_5_B4_holdcount");
    public static final String DSP_EQI8_5_B4_minusone = config.getString("DSP_EQI8_5_B4_minusone");
    public static final String DSP_EQI8_5_B4_ramp = config.getString("DSP_EQI8_5_B4_ramp");
    //equalizer_parametric_transposed_direct_II: B5
    public static final String DSP_EQI8_5_B5_a = config.getString("DSP_EQI8_5_B5_a");
    public static final String DSP_EQI8_5_B5_b = config.getString("DSP_EQI8_5_B5_b");
    public static final String DSP_EQI8_5_B5_clip = config.getString("DSP_EQI8_5_B5_clip");
    public static final String DSP_EQI8_5_B5_g = config.getString("DSP_EQI8_5_B5_g");
    public static final String DSP_EQI8_5_B5_holdcount = config.getString("DSP_EQI8_5_B5_holdcount");
    public static final String DSP_EQI8_5_B5_minusone = config.getString("DSP_EQI8_5_B5_minusone");
    public static final String DSP_EQI8_5_B5_ramp = config.getString("DSP_EQI8_5_B5_ramp");
    //equalizer_parametric_transposed_direct_II: B6
    public static final String DSP_EQI8_5_B6_a = config.getString("DSP_EQI8_5_B6_a");
    public static final String DSP_EQI8_5_B6_b = config.getString("DSP_EQI8_5_B6_b");
    public static final String DSP_EQI8_5_B6_clip = config.getString("DSP_EQI8_5_B6_clip");
    public static final String DSP_EQI8_5_B6_g = config.getString("DSP_EQI8_5_B6_g");
    public static final String DSP_EQI8_5_B6_holdcount = config.getString("DSP_EQI8_5_B6_holdcount");
    public static final String DSP_EQI8_5_B6_minusone = config.getString("DSP_EQI8_5_B6_minusone");
    public static final String DSP_EQI8_5_B6_ramp = config.getString("DSP_EQI8_5_B6_ramp");
    //equalizer_parametric_transposed_direct_II: B7
    public static final String DSP_EQI8_5_B7_a = config.getString("DSP_EQI8_5_B7_a");
    public static final String DSP_EQI8_5_B7_b = config.getString("DSP_EQI8_5_B7_b");
    public static final String DSP_EQI8_5_B7_clip = config.getString("DSP_EQI8_5_B7_clip");
    public static final String DSP_EQI8_5_B7_g = config.getString("DSP_EQI8_5_B7_g");
    public static final String DSP_EQI8_5_B7_holdcount = config.getString("DSP_EQI8_5_B7_holdcount");
    public static final String DSP_EQI8_5_B7_minusone = config.getString("DSP_EQI8_5_B7_minusone");
    public static final String DSP_EQI8_5_B7_ramp = config.getString("DSP_EQI8_5_B7_ramp");
    //detector_mean_square: Mean Square Detector
    public static final String DSP_CSI8_4_MeanSquareDetector_inputdisable1 = config.getString("DSP_CSI8_4_MeanSquareDetector_inputdisable1");
    public static final String DSP_CSI8_4_MeanSquareDetector_maxrms = config.getString("DSP_CSI8_4_MeanSquareDetector_maxrms");
    public static final String DSP_CSI8_4_MeanSquareDetector_tc = config.getString("DSP_CSI8_4_MeanSquareDetector_tc");
    //dynamic_compressor: Compressor
    public static final String DSP_CSI8_4_Compressor_dspattack = config.getString("DSP_CSI8_4_Compressor_dspattack");
    public static final String DSP_CSI8_4_Compressor_dspbypass = config.getString("DSP_CSI8_4_Compressor_dspbypass");
    public static final String DSP_CSI8_4_Compressor_dspratio = config.getString("DSP_CSI8_4_Compressor_dspratio");
    public static final String DSP_CSI8_4_Compressor_dspreduction = config.getString("DSP_CSI8_4_Compressor_dspreduction");
    public static final String DSP_CSI8_4_Compressor_dsprelease = config.getString("DSP_CSI8_4_Compressor_dsprelease");
    public static final String DSP_CSI8_4_Compressor_region = config.getString("DSP_CSI8_4_Compressor_region");
    public static final String DSP_CSI8_4_Compressor_softknee = config.getString("DSP_CSI8_4_Compressor_softknee");
    public static final String DSP_CSI8_4_Compressor_threshold = config.getString("DSP_CSI8_4_Compressor_threshold");
    //equalizer_parametric_transposed_direct_II: B1
    public static final String DSP_EQI8_4_B1_a = config.getString("DSP_EQI8_4_B1_a");
    public static final String DSP_EQI8_4_B1_b = config.getString("DSP_EQI8_4_B1_b");
    public static final String DSP_EQI8_4_B1_clip = config.getString("DSP_EQI8_4_B1_clip");
    public static final String DSP_EQI8_4_B1_g = config.getString("DSP_EQI8_4_B1_g");
    public static final String DSP_EQI8_4_B1_holdcount = config.getString("DSP_EQI8_4_B1_holdcount");
    public static final String DSP_EQI8_4_B1_minusone = config.getString("DSP_EQI8_4_B1_minusone");
    public static final String DSP_EQI8_4_B1_ramp = config.getString("DSP_EQI8_4_B1_ramp");
    //equalizer_parametric_transposed_direct_II: B2
    public static final String DSP_EQI8_4_B2_a = config.getString("DSP_EQI8_4_B2_a");
    public static final String DSP_EQI8_4_B2_b = config.getString("DSP_EQI8_4_B2_b");
    public static final String DSP_EQI8_4_B2_clip = config.getString("DSP_EQI8_4_B2_clip");
    public static final String DSP_EQI8_4_B2_g = config.getString("DSP_EQI8_4_B2_g");
    public static final String DSP_EQI8_4_B2_holdcount = config.getString("DSP_EQI8_4_B2_holdcount");
    public static final String DSP_EQI8_4_B2_minusone = config.getString("DSP_EQI8_4_B2_minusone");
    public static final String DSP_EQI8_4_B2_ramp = config.getString("DSP_EQI8_4_B2_ramp");
    //equalizer_parametric_transposed_direct_II: B3
    public static final String DSP_EQI8_4_B3_a = config.getString("DSP_EQI8_4_B3_a");
    public static final String DSP_EQI8_4_B3_b = config.getString("DSP_EQI8_4_B3_b");
    public static final String DSP_EQI8_4_B3_clip = config.getString("DSP_EQI8_4_B3_clip");
    public static final String DSP_EQI8_4_B3_g = config.getString("DSP_EQI8_4_B3_g");
    public static final String DSP_EQI8_4_B3_holdcount = config.getString("DSP_EQI8_4_B3_holdcount");
    public static final String DSP_EQI8_4_B3_minusone = config.getString("DSP_EQI8_4_B3_minusone");
    public static final String DSP_EQI8_4_B3_ramp = config.getString("DSP_EQI8_4_B3_ramp");
    //equalizer_parametric_transposed_direct_II: B4
    public static final String DSP_EQI8_4_B4_a = config.getString("DSP_EQI8_4_B4_a");
    public static final String DSP_EQI8_4_B4_b = config.getString("DSP_EQI8_4_B4_b");
    public static final String DSP_EQI8_4_B4_clip = config.getString("DSP_EQI8_4_B4_clip");
    public static final String DSP_EQI8_4_B4_g = config.getString("DSP_EQI8_4_B4_g");
    public static final String DSP_EQI8_4_B4_holdcount = config.getString("DSP_EQI8_4_B4_holdcount");
    public static final String DSP_EQI8_4_B4_minusone = config.getString("DSP_EQI8_4_B4_minusone");
    public static final String DSP_EQI8_4_B4_ramp = config.getString("DSP_EQI8_4_B4_ramp");
    //equalizer_parametric_transposed_direct_II: B5
    public static final String DSP_EQI8_4_B5_a = config.getString("DSP_EQI8_4_B5_a");
    public static final String DSP_EQI8_4_B5_b = config.getString("DSP_EQI8_4_B5_b");
    public static final String DSP_EQI8_4_B5_clip = config.getString("DSP_EQI8_4_B5_clip");
    public static final String DSP_EQI8_4_B5_g = config.getString("DSP_EQI8_4_B5_g");
    public static final String DSP_EQI8_4_B5_holdcount = config.getString("DSP_EQI8_4_B5_holdcount");
    public static final String DSP_EQI8_4_B5_minusone = config.getString("DSP_EQI8_4_B5_minusone");
    public static final String DSP_EQI8_4_B5_ramp = config.getString("DSP_EQI8_4_B5_ramp");
    //equalizer_parametric_transposed_direct_II: B6
    public static final String DSP_EQI8_4_B6_a = config.getString("DSP_EQI8_4_B6_a");
    public static final String DSP_EQI8_4_B6_b = config.getString("DSP_EQI8_4_B6_b");
    public static final String DSP_EQI8_4_B6_clip = config.getString("DSP_EQI8_4_B6_clip");
    public static final String DSP_EQI8_4_B6_g = config.getString("DSP_EQI8_4_B6_g");
    public static final String DSP_EQI8_4_B6_holdcount = config.getString("DSP_EQI8_4_B6_holdcount");
    public static final String DSP_EQI8_4_B6_minusone = config.getString("DSP_EQI8_4_B6_minusone");
    public static final String DSP_EQI8_4_B6_ramp = config.getString("DSP_EQI8_4_B6_ramp");
    //equalizer_parametric_transposed_direct_II: B7
    public static final String DSP_EQI8_4_B7_a = config.getString("DSP_EQI8_4_B7_a");
    public static final String DSP_EQI8_4_B7_b = config.getString("DSP_EQI8_4_B7_b");
    public static final String DSP_EQI8_4_B7_clip = config.getString("DSP_EQI8_4_B7_clip");
    public static final String DSP_EQI8_4_B7_g = config.getString("DSP_EQI8_4_B7_g");
    public static final String DSP_EQI8_4_B7_holdcount = config.getString("DSP_EQI8_4_B7_holdcount");
    public static final String DSP_EQI8_4_B7_minusone = config.getString("DSP_EQI8_4_B7_minusone");
    public static final String DSP_EQI8_4_B7_ramp = config.getString("DSP_EQI8_4_B7_ramp");
    //generator_white_noise: WN
    public static final String DSP_WN_gain = config.getString("DSP_WN_gain");
    public static final String DSP_WN_ramp = config.getString("DSP_WN_ramp");
    //generator_pink_noise: PN
    public static final String DSP_PN_gain = config.getString("DSP_PN_gain");
    public static final String DSP_PN_ramp = config.getString("DSP_PN_ramp");
    //detector_mean_square: Mean Square Detector
    public static final String DSP_CSI8_3_MeanSquareDetector_inputdisable1 = config.getString("DSP_CSI8_3_MeanSquareDetector_inputdisable1");
    public static final String DSP_CSI8_3_MeanSquareDetector_maxrms = config.getString("DSP_CSI8_3_MeanSquareDetector_maxrms");
    public static final String DSP_CSI8_3_MeanSquareDetector_tc = config.getString("DSP_CSI8_3_MeanSquareDetector_tc");
    //dynamic_compressor: Compressor
    public static final String DSP_CSI8_3_Compressor_dspattack = config.getString("DSP_CSI8_3_Compressor_dspattack");
    public static final String DSP_CSI8_3_Compressor_dspbypass = config.getString("DSP_CSI8_3_Compressor_dspbypass");
    public static final String DSP_CSI8_3_Compressor_dspratio = config.getString("DSP_CSI8_3_Compressor_dspratio");
    public static final String DSP_CSI8_3_Compressor_dspreduction = config.getString("DSP_CSI8_3_Compressor_dspreduction");
    public static final String DSP_CSI8_3_Compressor_dsprelease = config.getString("DSP_CSI8_3_Compressor_dsprelease");
    public static final String DSP_CSI8_3_Compressor_region = config.getString("DSP_CSI8_3_Compressor_region");
    public static final String DSP_CSI8_3_Compressor_softknee = config.getString("DSP_CSI8_3_Compressor_softknee");
    public static final String DSP_CSI8_3_Compressor_threshold = config.getString("DSP_CSI8_3_Compressor_threshold");
    //equalizer_parametric_transposed_direct_II: B1
    public static final String DSP_EQI8_3_B1_a = config.getString("DSP_EQI8_3_B1_a");
    public static final String DSP_EQI8_3_B1_b = config.getString("DSP_EQI8_3_B1_b");
    public static final String DSP_EQI8_3_B1_clip = config.getString("DSP_EQI8_3_B1_clip");
    public static final String DSP_EQI8_3_B1_g = config.getString("DSP_EQI8_3_B1_g");
    public static final String DSP_EQI8_3_B1_holdcount = config.getString("DSP_EQI8_3_B1_holdcount");
    public static final String DSP_EQI8_3_B1_minusone = config.getString("DSP_EQI8_3_B1_minusone");
    public static final String DSP_EQI8_3_B1_ramp = config.getString("DSP_EQI8_3_B1_ramp");
    //equalizer_parametric_transposed_direct_II: B2
    public static final String DSP_EQI8_3_B2_a = config.getString("DSP_EQI8_3_B2_a");
    public static final String DSP_EQI8_3_B2_b = config.getString("DSP_EQI8_3_B2_b");
    public static final String DSP_EQI8_3_B2_clip = config.getString("DSP_EQI8_3_B2_clip");
    public static final String DSP_EQI8_3_B2_g = config.getString("DSP_EQI8_3_B2_g");
    public static final String DSP_EQI8_3_B2_holdcount = config.getString("DSP_EQI8_3_B2_holdcount");
    public static final String DSP_EQI8_3_B2_minusone = config.getString("DSP_EQI8_3_B2_minusone");
    public static final String DSP_EQI8_3_B2_ramp = config.getString("DSP_EQI8_3_B2_ramp");
    //equalizer_parametric_transposed_direct_II: B3
    public static final String DSP_EQI8_3_B3_a = config.getString("DSP_EQI8_3_B3_a");
    public static final String DSP_EQI8_3_B3_b = config.getString("DSP_EQI8_3_B3_b");
    public static final String DSP_EQI8_3_B3_clip = config.getString("DSP_EQI8_3_B3_clip");
    public static final String DSP_EQI8_3_B3_g = config.getString("DSP_EQI8_3_B3_g");
    public static final String DSP_EQI8_3_B3_holdcount = config.getString("DSP_EQI8_3_B3_holdcount");
    public static final String DSP_EQI8_3_B3_minusone = config.getString("DSP_EQI8_3_B3_minusone");
    public static final String DSP_EQI8_3_B3_ramp = config.getString("DSP_EQI8_3_B3_ramp");
    //equalizer_parametric_transposed_direct_II: B4
    public static final String DSP_EQI8_3_B4_a = config.getString("DSP_EQI8_3_B4_a");
    public static final String DSP_EQI8_3_B4_b = config.getString("DSP_EQI8_3_B4_b");
    public static final String DSP_EQI8_3_B4_clip = config.getString("DSP_EQI8_3_B4_clip");
    public static final String DSP_EQI8_3_B4_g = config.getString("DSP_EQI8_3_B4_g");
    public static final String DSP_EQI8_3_B4_holdcount = config.getString("DSP_EQI8_3_B4_holdcount");
    public static final String DSP_EQI8_3_B4_minusone = config.getString("DSP_EQI8_3_B4_minusone");
    public static final String DSP_EQI8_3_B4_ramp = config.getString("DSP_EQI8_3_B4_ramp");
    //equalizer_parametric_transposed_direct_II: B5
    public static final String DSP_EQI8_3_B5_a = config.getString("DSP_EQI8_3_B5_a");
    public static final String DSP_EQI8_3_B5_b = config.getString("DSP_EQI8_3_B5_b");
    public static final String DSP_EQI8_3_B5_clip = config.getString("DSP_EQI8_3_B5_clip");
    public static final String DSP_EQI8_3_B5_g = config.getString("DSP_EQI8_3_B5_g");
    public static final String DSP_EQI8_3_B5_holdcount = config.getString("DSP_EQI8_3_B5_holdcount");
    public static final String DSP_EQI8_3_B5_minusone = config.getString("DSP_EQI8_3_B5_minusone");
    public static final String DSP_EQI8_3_B5_ramp = config.getString("DSP_EQI8_3_B5_ramp");
    //equalizer_parametric_transposed_direct_II: B6
    public static final String DSP_EQI8_3_B6_a = config.getString("DSP_EQI8_3_B6_a");
    public static final String DSP_EQI8_3_B6_b = config.getString("DSP_EQI8_3_B6_b");
    public static final String DSP_EQI8_3_B6_clip = config.getString("DSP_EQI8_3_B6_clip");
    public static final String DSP_EQI8_3_B6_g = config.getString("DSP_EQI8_3_B6_g");
    public static final String DSP_EQI8_3_B6_holdcount = config.getString("DSP_EQI8_3_B6_holdcount");
    public static final String DSP_EQI8_3_B6_minusone = config.getString("DSP_EQI8_3_B6_minusone");
    public static final String DSP_EQI8_3_B6_ramp = config.getString("DSP_EQI8_3_B6_ramp");
    //equalizer_parametric_transposed_direct_II: B7
    public static final String DSP_EQI8_3_B7_a = config.getString("DSP_EQI8_3_B7_a");
    public static final String DSP_EQI8_3_B7_b = config.getString("DSP_EQI8_3_B7_b");
    public static final String DSP_EQI8_3_B7_clip = config.getString("DSP_EQI8_3_B7_clip");
    public static final String DSP_EQI8_3_B7_g = config.getString("DSP_EQI8_3_B7_g");
    public static final String DSP_EQI8_3_B7_holdcount = config.getString("DSP_EQI8_3_B7_holdcount");
    public static final String DSP_EQI8_3_B7_minusone = config.getString("DSP_EQI8_3_B7_minusone");
    public static final String DSP_EQI8_3_B7_ramp = config.getString("DSP_EQI8_3_B7_ramp");
    //detector_mean_square: Mean Square Detector
    public static final String DSP_CSI8_2_MeanSquareDetector_inputdisable1 = config.getString("DSP_CSI8_2_MeanSquareDetector_inputdisable1");
    public static final String DSP_CSI8_2_MeanSquareDetector_maxrms = config.getString("DSP_CSI8_2_MeanSquareDetector_maxrms");
    public static final String DSP_CSI8_2_MeanSquareDetector_tc = config.getString("DSP_CSI8_2_MeanSquareDetector_tc");
    //dynamic_compressor: Compressor
    public static final String DSP_CSI8_2_Compressor_dspattack = config.getString("DSP_CSI8_2_Compressor_dspattack");
    public static final String DSP_CSI8_2_Compressor_dspbypass = config.getString("DSP_CSI8_2_Compressor_dspbypass");
    public static final String DSP_CSI8_2_Compressor_dspratio = config.getString("DSP_CSI8_2_Compressor_dspratio");
    public static final String DSP_CSI8_2_Compressor_dspreduction = config.getString("DSP_CSI8_2_Compressor_dspreduction");
    public static final String DSP_CSI8_2_Compressor_dsprelease = config.getString("DSP_CSI8_2_Compressor_dsprelease");
    public static final String DSP_CSI8_2_Compressor_region = config.getString("DSP_CSI8_2_Compressor_region");
    public static final String DSP_CSI8_2_Compressor_softknee = config.getString("DSP_CSI8_2_Compressor_softknee");
    public static final String DSP_CSI8_2_Compressor_threshold = config.getString("DSP_CSI8_2_Compressor_threshold");
    //equalizer_parametric_transposed_direct_II: B1
    public static final String DSP_EQI8_2_B1_a = config.getString("DSP_EQI8_2_B1_a");
    public static final String DSP_EQI8_2_B1_b = config.getString("DSP_EQI8_2_B1_b");
    public static final String DSP_EQI8_2_B1_clip = config.getString("DSP_EQI8_2_B1_clip");
    public static final String DSP_EQI8_2_B1_g = config.getString("DSP_EQI8_2_B1_g");
    public static final String DSP_EQI8_2_B1_holdcount = config.getString("DSP_EQI8_2_B1_holdcount");
    public static final String DSP_EQI8_2_B1_minusone = config.getString("DSP_EQI8_2_B1_minusone");
    public static final String DSP_EQI8_2_B1_ramp = config.getString("DSP_EQI8_2_B1_ramp");
    //equalizer_parametric_transposed_direct_II: B2
    public static final String DSP_EQI8_2_B2_a = config.getString("DSP_EQI8_2_B2_a");
    public static final String DSP_EQI8_2_B2_b = config.getString("DSP_EQI8_2_B2_b");
    public static final String DSP_EQI8_2_B2_clip = config.getString("DSP_EQI8_2_B2_clip");
    public static final String DSP_EQI8_2_B2_g = config.getString("DSP_EQI8_2_B2_g");
    public static final String DSP_EQI8_2_B2_holdcount = config.getString("DSP_EQI8_2_B2_holdcount");
    public static final String DSP_EQI8_2_B2_minusone = config.getString("DSP_EQI8_2_B2_minusone");
    public static final String DSP_EQI8_2_B2_ramp = config.getString("DSP_EQI8_2_B2_ramp");
    //equalizer_parametric_transposed_direct_II: B3
    public static final String DSP_EQI8_2_B3_a = config.getString("DSP_EQI8_2_B3_a");
    public static final String DSP_EQI8_2_B3_b = config.getString("DSP_EQI8_2_B3_b");
    public static final String DSP_EQI8_2_B3_clip = config.getString("DSP_EQI8_2_B3_clip");
    public static final String DSP_EQI8_2_B3_g = config.getString("DSP_EQI8_2_B3_g");
    public static final String DSP_EQI8_2_B3_holdcount = config.getString("DSP_EQI8_2_B3_holdcount");
    public static final String DSP_EQI8_2_B3_minusone = config.getString("DSP_EQI8_2_B3_minusone");
    public static final String DSP_EQI8_2_B3_ramp = config.getString("DSP_EQI8_2_B3_ramp");
    //equalizer_parametric_transposed_direct_II: B4
    public static final String DSP_EQI8_2_B4_a = config.getString("DSP_EQI8_2_B4_a");
    public static final String DSP_EQI8_2_B4_b = config.getString("DSP_EQI8_2_B4_b");
    public static final String DSP_EQI8_2_B4_clip = config.getString("DSP_EQI8_2_B4_clip");
    public static final String DSP_EQI8_2_B4_g = config.getString("DSP_EQI8_2_B4_g");
    public static final String DSP_EQI8_2_B4_holdcount = config.getString("DSP_EQI8_2_B4_holdcount");
    public static final String DSP_EQI8_2_B4_minusone = config.getString("DSP_EQI8_2_B4_minusone");
    public static final String DSP_EQI8_2_B4_ramp = config.getString("DSP_EQI8_2_B4_ramp");
    //equalizer_parametric_transposed_direct_II: B5
    public static final String DSP_EQI8_2_B5_a = config.getString("DSP_EQI8_2_B5_a");
    public static final String DSP_EQI8_2_B5_b = config.getString("DSP_EQI8_2_B5_b");
    public static final String DSP_EQI8_2_B5_clip = config.getString("DSP_EQI8_2_B5_clip");
    public static final String DSP_EQI8_2_B5_g = config.getString("DSP_EQI8_2_B5_g");
    public static final String DSP_EQI8_2_B5_holdcount = config.getString("DSP_EQI8_2_B5_holdcount");
    public static final String DSP_EQI8_2_B5_minusone = config.getString("DSP_EQI8_2_B5_minusone");
    public static final String DSP_EQI8_2_B5_ramp = config.getString("DSP_EQI8_2_B5_ramp");
    //equalizer_parametric_transposed_direct_II: B6
    public static final String DSP_EQI8_2_B6_a = config.getString("DSP_EQI8_2_B6_a");
    public static final String DSP_EQI8_2_B6_b = config.getString("DSP_EQI8_2_B6_b");
    public static final String DSP_EQI8_2_B6_clip = config.getString("DSP_EQI8_2_B6_clip");
    public static final String DSP_EQI8_2_B6_g = config.getString("DSP_EQI8_2_B6_g");
    public static final String DSP_EQI8_2_B6_holdcount = config.getString("DSP_EQI8_2_B6_holdcount");
    public static final String DSP_EQI8_2_B6_minusone = config.getString("DSP_EQI8_2_B6_minusone");
    public static final String DSP_EQI8_2_B6_ramp = config.getString("DSP_EQI8_2_B6_ramp");
    //equalizer_parametric_transposed_direct_II: B7
    public static final String DSP_EQI8_2_B7_a = config.getString("DSP_EQI8_2_B7_a");
    public static final String DSP_EQI8_2_B7_b = config.getString("DSP_EQI8_2_B7_b");
    public static final String DSP_EQI8_2_B7_clip = config.getString("DSP_EQI8_2_B7_clip");
    public static final String DSP_EQI8_2_B7_g = config.getString("DSP_EQI8_2_B7_g");
    public static final String DSP_EQI8_2_B7_holdcount = config.getString("DSP_EQI8_2_B7_holdcount");
    public static final String DSP_EQI8_2_B7_minusone = config.getString("DSP_EQI8_2_B7_minusone");
    public static final String DSP_EQI8_2_B7_ramp = config.getString("DSP_EQI8_2_B7_ramp");
    //meter_N_true_peak_and_RMS: MTI16
    public static final String DSP_MTI16_coeffpeak = config.getString("DSP_MTI16_coeffpeak");
    public static final String DSP_MTI16_coeffrms = config.getString("DSP_MTI16_coeffrms");
    public static final String DSP_MTI16_holdcount = config.getString("DSP_MTI16_holdcount");
    public static final String DSP_MTI16_infinitepeakhold = config.getString("DSP_MTI16_infinitepeakhold");
    public static final String DSP_MTI16_ms1 = config.getString("DSP_MTI16_ms1");
    public static final String DSP_MTI16_ms10 = config.getString("DSP_MTI16_ms10");
    public static final String DSP_MTI16_ms11 = config.getString("DSP_MTI16_ms11");
    public static final String DSP_MTI16_ms12 = config.getString("DSP_MTI16_ms12");
    public static final String DSP_MTI16_ms13 = config.getString("DSP_MTI16_ms13");
    public static final String DSP_MTI16_ms14 = config.getString("DSP_MTI16_ms14");
    public static final String DSP_MTI16_ms15 = config.getString("DSP_MTI16_ms15");
    public static final String DSP_MTI16_ms16 = config.getString("DSP_MTI16_ms16");
    public static final String DSP_MTI16_ms2 = config.getString("DSP_MTI16_ms2");
    public static final String DSP_MTI16_ms3 = config.getString("DSP_MTI16_ms3");
    public static final String DSP_MTI16_ms4 = config.getString("DSP_MTI16_ms4");
    public static final String DSP_MTI16_ms5 = config.getString("DSP_MTI16_ms5");
    public static final String DSP_MTI16_ms6 = config.getString("DSP_MTI16_ms6");
    public static final String DSP_MTI16_ms7 = config.getString("DSP_MTI16_ms7");
    public static final String DSP_MTI16_ms8 = config.getString("DSP_MTI16_ms8");
    public static final String DSP_MTI16_ms9 = config.getString("DSP_MTI16_ms9");
    public static final String DSP_MTI16_mshold1 = config.getString("DSP_MTI16_mshold1");
    public static final String DSP_MTI16_mshold10 = config.getString("DSP_MTI16_mshold10");
    public static final String DSP_MTI16_mshold11 = config.getString("DSP_MTI16_mshold11");
    public static final String DSP_MTI16_mshold12 = config.getString("DSP_MTI16_mshold12");
    public static final String DSP_MTI16_mshold13 = config.getString("DSP_MTI16_mshold13");
    public static final String DSP_MTI16_mshold14 = config.getString("DSP_MTI16_mshold14");
    public static final String DSP_MTI16_mshold15 = config.getString("DSP_MTI16_mshold15");
    public static final String DSP_MTI16_mshold16 = config.getString("DSP_MTI16_mshold16");
    public static final String DSP_MTI16_mshold2 = config.getString("DSP_MTI16_mshold2");
    public static final String DSP_MTI16_mshold3 = config.getString("DSP_MTI16_mshold3");
    public static final String DSP_MTI16_mshold4 = config.getString("DSP_MTI16_mshold4");
    public static final String DSP_MTI16_mshold5 = config.getString("DSP_MTI16_mshold5");
    public static final String DSP_MTI16_mshold6 = config.getString("DSP_MTI16_mshold6");
    public static final String DSP_MTI16_mshold7 = config.getString("DSP_MTI16_mshold7");
    public static final String DSP_MTI16_mshold8 = config.getString("DSP_MTI16_mshold8");
    public static final String DSP_MTI16_mshold9 = config.getString("DSP_MTI16_mshold9");
    public static final String DSP_MTI16_pk1 = config.getString("DSP_MTI16_pk1");
    public static final String DSP_MTI16_pk10 = config.getString("DSP_MTI16_pk10");
    public static final String DSP_MTI16_pk11 = config.getString("DSP_MTI16_pk11");
    public static final String DSP_MTI16_pk12 = config.getString("DSP_MTI16_pk12");
    public static final String DSP_MTI16_pk13 = config.getString("DSP_MTI16_pk13");
    public static final String DSP_MTI16_pk14 = config.getString("DSP_MTI16_pk14");
    public static final String DSP_MTI16_pk15 = config.getString("DSP_MTI16_pk15");
    public static final String DSP_MTI16_pk16 = config.getString("DSP_MTI16_pk16");
    public static final String DSP_MTI16_pk2 = config.getString("DSP_MTI16_pk2");
    public static final String DSP_MTI16_pk3 = config.getString("DSP_MTI16_pk3");
    public static final String DSP_MTI16_pk4 = config.getString("DSP_MTI16_pk4");
    public static final String DSP_MTI16_pk5 = config.getString("DSP_MTI16_pk5");
    public static final String DSP_MTI16_pk6 = config.getString("DSP_MTI16_pk6");
    public static final String DSP_MTI16_pk7 = config.getString("DSP_MTI16_pk7");
    public static final String DSP_MTI16_pk8 = config.getString("DSP_MTI16_pk8");
    public static final String DSP_MTI16_pk9 = config.getString("DSP_MTI16_pk9");
    public static final String DSP_MTI16_pkhold1 = config.getString("DSP_MTI16_pkhold1");
    public static final String DSP_MTI16_pkhold10 = config.getString("DSP_MTI16_pkhold10");
    public static final String DSP_MTI16_pkhold11 = config.getString("DSP_MTI16_pkhold11");
    public static final String DSP_MTI16_pkhold12 = config.getString("DSP_MTI16_pkhold12");
    public static final String DSP_MTI16_pkhold13 = config.getString("DSP_MTI16_pkhold13");
    public static final String DSP_MTI16_pkhold14 = config.getString("DSP_MTI16_pkhold14");
    public static final String DSP_MTI16_pkhold15 = config.getString("DSP_MTI16_pkhold15");
    public static final String DSP_MTI16_pkhold16 = config.getString("DSP_MTI16_pkhold16");
    public static final String DSP_MTI16_pkhold2 = config.getString("DSP_MTI16_pkhold2");
    public static final String DSP_MTI16_pkhold3 = config.getString("DSP_MTI16_pkhold3");
    public static final String DSP_MTI16_pkhold4 = config.getString("DSP_MTI16_pkhold4");
    public static final String DSP_MTI16_pkhold5 = config.getString("DSP_MTI16_pkhold5");
    public static final String DSP_MTI16_pkhold6 = config.getString("DSP_MTI16_pkhold6");
    public static final String DSP_MTI16_pkhold7 = config.getString("DSP_MTI16_pkhold7");
    public static final String DSP_MTI16_pkhold8 = config.getString("DSP_MTI16_pkhold8");
    public static final String DSP_MTI16_pkhold9 = config.getString("DSP_MTI16_pkhold9");
    //detector_mean_square: Mean Square Detector
    public static final String DSP_CSI8_1_MeanSquareDetector_inputdisable1 = config.getString("DSP_CSI8_1_MeanSquareDetector_inputdisable1");
    public static final String DSP_CSI8_1_MeanSquareDetector_maxrms = config.getString("DSP_CSI8_1_MeanSquareDetector_maxrms");
    public static final String DSP_CSI8_1_MeanSquareDetector_tc = config.getString("DSP_CSI8_1_MeanSquareDetector_tc");
    //dynamic_compressor: Compressor
    public static final String DSP_CSI8_1_Compressor_dspattack = config.getString("DSP_CSI8_1_Compressor_dspattack");
    public static final String DSP_CSI8_1_Compressor_dspbypass = config.getString("DSP_CSI8_1_Compressor_dspbypass");
    public static final String DSP_CSI8_1_Compressor_dspratio = config.getString("DSP_CSI8_1_Compressor_dspratio");
    public static final String DSP_CSI8_1_Compressor_dspreduction = config.getString("DSP_CSI8_1_Compressor_dspreduction");
    public static final String DSP_CSI8_1_Compressor_dsprelease = config.getString("DSP_CSI8_1_Compressor_dsprelease");
    public static final String DSP_CSI8_1_Compressor_region = config.getString("DSP_CSI8_1_Compressor_region");
    public static final String DSP_CSI8_1_Compressor_softknee = config.getString("DSP_CSI8_1_Compressor_softknee");
    public static final String DSP_CSI8_1_Compressor_threshold = config.getString("DSP_CSI8_1_Compressor_threshold");
    //equalizer_parametric_transposed_direct_II: B1
    public static final String DSP_EQI8_1_B1_a = config.getString("DSP_EQI8_1_B1_a");
    public static final String DSP_EQI8_1_B1_b = config.getString("DSP_EQI8_1_B1_b");
    public static final String DSP_EQI8_1_B1_clip = config.getString("DSP_EQI8_1_B1_clip");
    public static final String DSP_EQI8_1_B1_g = config.getString("DSP_EQI8_1_B1_g");
    public static final String DSP_EQI8_1_B1_holdcount = config.getString("DSP_EQI8_1_B1_holdcount");
    public static final String DSP_EQI8_1_B1_minusone = config.getString("DSP_EQI8_1_B1_minusone");
    public static final String DSP_EQI8_1_B1_ramp = config.getString("DSP_EQI8_1_B1_ramp");
    //equalizer_parametric_transposed_direct_II: B2
    public static final String DSP_EQI8_1_B2_a = config.getString("DSP_EQI8_1_B2_a");
    public static final String DSP_EQI8_1_B2_b = config.getString("DSP_EQI8_1_B2_b");
    public static final String DSP_EQI8_1_B2_clip = config.getString("DSP_EQI8_1_B2_clip");
    public static final String DSP_EQI8_1_B2_g = config.getString("DSP_EQI8_1_B2_g");
    public static final String DSP_EQI8_1_B2_holdcount = config.getString("DSP_EQI8_1_B2_holdcount");
    public static final String DSP_EQI8_1_B2_minusone = config.getString("DSP_EQI8_1_B2_minusone");
    public static final String DSP_EQI8_1_B2_ramp = config.getString("DSP_EQI8_1_B2_ramp");
    //equalizer_parametric_transposed_direct_II: B3
    public static final String DSP_EQI8_1_B3_a = config.getString("DSP_EQI8_1_B3_a");
    public static final String DSP_EQI8_1_B3_b = config.getString("DSP_EQI8_1_B3_b");
    public static final String DSP_EQI8_1_B3_clip = config.getString("DSP_EQI8_1_B3_clip");
    public static final String DSP_EQI8_1_B3_g = config.getString("DSP_EQI8_1_B3_g");
    public static final String DSP_EQI8_1_B3_holdcount = config.getString("DSP_EQI8_1_B3_holdcount");
    public static final String DSP_EQI8_1_B3_minusone = config.getString("DSP_EQI8_1_B3_minusone");
    public static final String DSP_EQI8_1_B3_ramp = config.getString("DSP_EQI8_1_B3_ramp");
    //equalizer_parametric_transposed_direct_II: B4
    public static final String DSP_EQI8_1_B4_a = config.getString("DSP_EQI8_1_B4_a");
    public static final String DSP_EQI8_1_B4_b = config.getString("DSP_EQI8_1_B4_b");
    public static final String DSP_EQI8_1_B4_clip = config.getString("DSP_EQI8_1_B4_clip");
    public static final String DSP_EQI8_1_B4_g = config.getString("DSP_EQI8_1_B4_g");
    public static final String DSP_EQI8_1_B4_holdcount = config.getString("DSP_EQI8_1_B4_holdcount");
    public static final String DSP_EQI8_1_B4_minusone = config.getString("DSP_EQI8_1_B4_minusone");
    public static final String DSP_EQI8_1_B4_ramp = config.getString("DSP_EQI8_1_B4_ramp");
    //equalizer_parametric_transposed_direct_II: B5
    public static final String DSP_EQI8_1_B5_a = config.getString("DSP_EQI8_1_B5_a");
    public static final String DSP_EQI8_1_B5_b = config.getString("DSP_EQI8_1_B5_b");
    public static final String DSP_EQI8_1_B5_clip = config.getString("DSP_EQI8_1_B5_clip");
    public static final String DSP_EQI8_1_B5_g = config.getString("DSP_EQI8_1_B5_g");
    public static final String DSP_EQI8_1_B5_holdcount = config.getString("DSP_EQI8_1_B5_holdcount");
    public static final String DSP_EQI8_1_B5_minusone = config.getString("DSP_EQI8_1_B5_minusone");
    public static final String DSP_EQI8_1_B5_ramp = config.getString("DSP_EQI8_1_B5_ramp");
    //equalizer_parametric_transposed_direct_II: B6
    public static final String DSP_EQI8_1_B6_a = config.getString("DSP_EQI8_1_B6_a");
    public static final String DSP_EQI8_1_B6_b = config.getString("DSP_EQI8_1_B6_b");
    public static final String DSP_EQI8_1_B6_clip = config.getString("DSP_EQI8_1_B6_clip");
    public static final String DSP_EQI8_1_B6_g = config.getString("DSP_EQI8_1_B6_g");
    public static final String DSP_EQI8_1_B6_holdcount = config.getString("DSP_EQI8_1_B6_holdcount");
    public static final String DSP_EQI8_1_B6_minusone = config.getString("DSP_EQI8_1_B6_minusone");
    public static final String DSP_EQI8_1_B6_ramp = config.getString("DSP_EQI8_1_B6_ramp");
    //equalizer_parametric_transposed_direct_II: B7
    public static final String DSP_EQI8_1_B7_a = config.getString("DSP_EQI8_1_B7_a");
    public static final String DSP_EQI8_1_B7_b = config.getString("DSP_EQI8_1_B7_b");
    public static final String DSP_EQI8_1_B7_clip = config.getString("DSP_EQI8_1_B7_clip");
    public static final String DSP_EQI8_1_B7_g = config.getString("DSP_EQI8_1_B7_g");
    public static final String DSP_EQI8_1_B7_holdcount = config.getString("DSP_EQI8_1_B7_holdcount");
    public static final String DSP_EQI8_1_B7_minusone = config.getString("DSP_EQI8_1_B7_minusone");
    public static final String DSP_EQI8_1_B7_ramp = config.getString("DSP_EQI8_1_B7_ramp");
    //gain_multi_channel: GNI8
    public static final String DSP_GNI8_channelclip1 = config.getString("DSP_GNI8_channelclip1");
    public static final String DSP_GNI8_channelclip2 = config.getString("DSP_GNI8_channelclip2");
    public static final String DSP_GNI8_channelclip3 = config.getString("DSP_GNI8_channelclip3");
    public static final String DSP_GNI8_channelclip4 = config.getString("DSP_GNI8_channelclip4");
    public static final String DSP_GNI8_channelclip5 = config.getString("DSP_GNI8_channelclip5");
    public static final String DSP_GNI8_channelclip6 = config.getString("DSP_GNI8_channelclip6");
    public static final String DSP_GNI8_channelclip7 = config.getString("DSP_GNI8_channelclip7");
    public static final String DSP_GNI8_channelclip8 = config.getString("DSP_GNI8_channelclip8");
    public static final String DSP_GNI8_g1 = config.getString("DSP_GNI8_g1");
    public static final String DSP_GNI8_g2 = config.getString("DSP_GNI8_g2");
    public static final String DSP_GNI8_g3 = config.getString("DSP_GNI8_g3");
    public static final String DSP_GNI8_g4 = config.getString("DSP_GNI8_g4");
    public static final String DSP_GNI8_g5 = config.getString("DSP_GNI8_g5");
    public static final String DSP_GNI8_g6 = config.getString("DSP_GNI8_g6");
    public static final String DSP_GNI8_g7 = config.getString("DSP_GNI8_g7");
    public static final String DSP_GNI8_g8 = config.getString("DSP_GNI8_g8");
    public static final String DSP_GNI8_holdcount = config.getString("DSP_GNI8_holdcount");
    public static final String DSP_GNI8_ramp = config.getString("DSP_GNI8_ramp");
    //mixer_NxM: 4
    public static final String DSP_MXI16O4_4_holdcount = config.getString("DSP_MXI16O4_4_holdcount");
    public static final String DSP_MXI16O4_4_input10output1send = config.getString("DSP_MXI16O4_4_input10output1send");
    public static final String DSP_MXI16O4_4_input11output1send = config.getString("DSP_MXI16O4_4_input11output1send");
    public static final String DSP_MXI16O4_4_input12output1send = config.getString("DSP_MXI16O4_4_input12output1send");
    public static final String DSP_MXI16O4_4_input13output1send = config.getString("DSP_MXI16O4_4_input13output1send");
    public static final String DSP_MXI16O4_4_input14output1send = config.getString("DSP_MXI16O4_4_input14output1send");
    public static final String DSP_MXI16O4_4_input15output1send = config.getString("DSP_MXI16O4_4_input15output1send");
    public static final String DSP_MXI16O4_4_input16output1send = config.getString("DSP_MXI16O4_4_input16output1send");
    public static final String DSP_MXI16O4_4_input1output1send = config.getString("DSP_MXI16O4_4_input1output1send");
    public static final String DSP_MXI16O4_4_input2output1send = config.getString("DSP_MXI16O4_4_input2output1send");
    public static final String DSP_MXI16O4_4_input3output1send = config.getString("DSP_MXI16O4_4_input3output1send");
    public static final String DSP_MXI16O4_4_input4output1send = config.getString("DSP_MXI16O4_4_input4output1send");
    public static final String DSP_MXI16O4_4_input5output1send = config.getString("DSP_MXI16O4_4_input5output1send");
    public static final String DSP_MXI16O4_4_input6output1send = config.getString("DSP_MXI16O4_4_input6output1send");
    public static final String DSP_MXI16O4_4_input7output1send = config.getString("DSP_MXI16O4_4_input7output1send");
    public static final String DSP_MXI16O4_4_input8output1send = config.getString("DSP_MXI16O4_4_input8output1send");
    public static final String DSP_MXI16O4_4_input9output1send = config.getString("DSP_MXI16O4_4_input9output1send");
    public static final String DSP_MXI16O4_4_outputclip1 = config.getString("DSP_MXI16O4_4_outputclip1");
    public static final String DSP_MXI16O4_4_ramp = config.getString("DSP_MXI16O4_4_ramp");
    //mixer_NxM: 3
    public static final String DSP_MXI16O4_3_holdcount = config.getString("DSP_MXI16O4_3_holdcount");
    public static final String DSP_MXI16O4_3_input10output1send = config.getString("DSP_MXI16O4_3_input10output1send");
    public static final String DSP_MXI16O4_3_input11output1send = config.getString("DSP_MXI16O4_3_input11output1send");
    public static final String DSP_MXI16O4_3_input12output1send = config.getString("DSP_MXI16O4_3_input12output1send");
    public static final String DSP_MXI16O4_3_input13output1send = config.getString("DSP_MXI16O4_3_input13output1send");
    public static final String DSP_MXI16O4_3_input14output1send = config.getString("DSP_MXI16O4_3_input14output1send");
    public static final String DSP_MXI16O4_3_input15output1send = config.getString("DSP_MXI16O4_3_input15output1send");
    public static final String DSP_MXI16O4_3_input16output1send = config.getString("DSP_MXI16O4_3_input16output1send");
    public static final String DSP_MXI16O4_3_input1output1send = config.getString("DSP_MXI16O4_3_input1output1send");
    public static final String DSP_MXI16O4_3_input2output1send = config.getString("DSP_MXI16O4_3_input2output1send");
    public static final String DSP_MXI16O4_3_input3output1send = config.getString("DSP_MXI16O4_3_input3output1send");
    public static final String DSP_MXI16O4_3_input4output1send = config.getString("DSP_MXI16O4_3_input4output1send");
    public static final String DSP_MXI16O4_3_input5output1send = config.getString("DSP_MXI16O4_3_input5output1send");
    public static final String DSP_MXI16O4_3_input6output1send = config.getString("DSP_MXI16O4_3_input6output1send");
    public static final String DSP_MXI16O4_3_input7output1send = config.getString("DSP_MXI16O4_3_input7output1send");
    public static final String DSP_MXI16O4_3_input8output1send = config.getString("DSP_MXI16O4_3_input8output1send");
    public static final String DSP_MXI16O4_3_input9output1send = config.getString("DSP_MXI16O4_3_input9output1send");
    public static final String DSP_MXI16O4_3_outputclip1 = config.getString("DSP_MXI16O4_3_outputclip1");
    public static final String DSP_MXI16O4_3_ramp = config.getString("DSP_MXI16O4_3_ramp");
    //mixer_NxM: 2
    public static final String DSP_MXI16O4_2_holdcount = config.getString("DSP_MXI16O4_2_holdcount");
    public static final String DSP_MXI16O4_2_input10output1send = config.getString("DSP_MXI16O4_2_input10output1send");
    public static final String DSP_MXI16O4_2_input11output1send = config.getString("DSP_MXI16O4_2_input11output1send");
    public static final String DSP_MXI16O4_2_input12output1send = config.getString("DSP_MXI16O4_2_input12output1send");
    public static final String DSP_MXI16O4_2_input13output1send = config.getString("DSP_MXI16O4_2_input13output1send");
    public static final String DSP_MXI16O4_2_input14output1send = config.getString("DSP_MXI16O4_2_input14output1send");
    public static final String DSP_MXI16O4_2_input15output1send = config.getString("DSP_MXI16O4_2_input15output1send");
    public static final String DSP_MXI16O4_2_input16output1send = config.getString("DSP_MXI16O4_2_input16output1send");
    public static final String DSP_MXI16O4_2_input1output1send = config.getString("DSP_MXI16O4_2_input1output1send");
    public static final String DSP_MXI16O4_2_input2output1send = config.getString("DSP_MXI16O4_2_input2output1send");
    public static final String DSP_MXI16O4_2_input3output1send = config.getString("DSP_MXI16O4_2_input3output1send");
    public static final String DSP_MXI16O4_2_input4output1send = config.getString("DSP_MXI16O4_2_input4output1send");
    public static final String DSP_MXI16O4_2_input5output1send = config.getString("DSP_MXI16O4_2_input5output1send");
    public static final String DSP_MXI16O4_2_input6output1send = config.getString("DSP_MXI16O4_2_input6output1send");
    public static final String DSP_MXI16O4_2_input7output1send = config.getString("DSP_MXI16O4_2_input7output1send");
    public static final String DSP_MXI16O4_2_input8output1send = config.getString("DSP_MXI16O4_2_input8output1send");
    public static final String DSP_MXI16O4_2_input9output1send = config.getString("DSP_MXI16O4_2_input9output1send");
    public static final String DSP_MXI16O4_2_outputclip1 = config.getString("DSP_MXI16O4_2_outputclip1");
    public static final String DSP_MXI16O4_2_ramp = config.getString("DSP_MXI16O4_2_ramp");
    //mixer_NxM: 1
    public static final String DSP_MXI16O4_1_holdcount = config.getString("DSP_MXI16O4_1_holdcount");
    public static final String DSP_MXI16O4_1_input10output1send = config.getString("DSP_MXI16O4_1_input10output1send");
    public static final String DSP_MXI16O4_1_input11output1send = config.getString("DSP_MXI16O4_1_input11output1send");
    public static final String DSP_MXI16O4_1_input12output1send = config.getString("DSP_MXI16O4_1_input12output1send");
    public static final String DSP_MXI16O4_1_input13output1send = config.getString("DSP_MXI16O4_1_input13output1send");
    public static final String DSP_MXI16O4_1_input14output1send = config.getString("DSP_MXI16O4_1_input14output1send");
    public static final String DSP_MXI16O4_1_input15output1send = config.getString("DSP_MXI16O4_1_input15output1send");
    public static final String DSP_MXI16O4_1_input16output1send = config.getString("DSP_MXI16O4_1_input16output1send");
    public static final String DSP_MXI16O4_1_input1output1send = config.getString("DSP_MXI16O4_1_input1output1send");
    public static final String DSP_MXI16O4_1_input2output1send = config.getString("DSP_MXI16O4_1_input2output1send");
    public static final String DSP_MXI16O4_1_input3output1send = config.getString("DSP_MXI16O4_1_input3output1send");
    public static final String DSP_MXI16O4_1_input4output1send = config.getString("DSP_MXI16O4_1_input4output1send");
    public static final String DSP_MXI16O4_1_input5output1send = config.getString("DSP_MXI16O4_1_input5output1send");
    public static final String DSP_MXI16O4_1_input6output1send = config.getString("DSP_MXI16O4_1_input6output1send");
    public static final String DSP_MXI16O4_1_input7output1send = config.getString("DSP_MXI16O4_1_input7output1send");
    public static final String DSP_MXI16O4_1_input8output1send = config.getString("DSP_MXI16O4_1_input8output1send");
    public static final String DSP_MXI16O4_1_input9output1send = config.getString("DSP_MXI16O4_1_input9output1send");
    public static final String DSP_MXI16O4_1_outputclip1 = config.getString("DSP_MXI16O4_1_outputclip1");
    public static final String DSP_MXI16O4_1_ramp = config.getString("DSP_MXI16O4_1_ramp");
    //router_NxM_basic: RTI22O16
    public static final String DSP_RTI22O16_outputselect1 = config.getString("DSP_RTI22O16_outputselect1");
    public static final String DSP_RTI22O16_outputselect10 = config.getString("DSP_RTI22O16_outputselect10");
    public static final String DSP_RTI22O16_outputselect11 = config.getString("DSP_RTI22O16_outputselect11");
    public static final String DSP_RTI22O16_outputselect12 = config.getString("DSP_RTI22O16_outputselect12");
    public static final String DSP_RTI22O16_outputselect13 = config.getString("DSP_RTI22O16_outputselect13");
    public static final String DSP_RTI22O16_outputselect14 = config.getString("DSP_RTI22O16_outputselect14");
    public static final String DSP_RTI22O16_outputselect15 = config.getString("DSP_RTI22O16_outputselect15");
    public static final String DSP_RTI22O16_outputselect16 = config.getString("DSP_RTI22O16_outputselect16");
    public static final String DSP_RTI22O16_outputselect2 = config.getString("DSP_RTI22O16_outputselect2");
    public static final String DSP_RTI22O16_outputselect3 = config.getString("DSP_RTI22O16_outputselect3");
    public static final String DSP_RTI22O16_outputselect4 = config.getString("DSP_RTI22O16_outputselect4");
    public static final String DSP_RTI22O16_outputselect5 = config.getString("DSP_RTI22O16_outputselect5");
    public static final String DSP_RTI22O16_outputselect6 = config.getString("DSP_RTI22O16_outputselect6");
    public static final String DSP_RTI22O16_outputselect7 = config.getString("DSP_RTI22O16_outputselect7");
    public static final String DSP_RTI22O16_outputselect8 = config.getString("DSP_RTI22O16_outputselect8");
    public static final String DSP_RTI22O16_outputselect9 = config.getString("DSP_RTI22O16_outputselect9");
    public static final String DSP_RTI22O16_ramp = config.getString("DSP_RTI22O16_ramp");
    //equalizer_parametric_transposed_direct_II: B1
    public static final String DSP_EQO8_8_B1_a = config.getString("DSP_EQO8_8_B1_a");
    public static final String DSP_EQO8_8_B1_b = config.getString("DSP_EQO8_8_B1_b");
    public static final String DSP_EQO8_8_B1_clip = config.getString("DSP_EQO8_8_B1_clip");
    public static final String DSP_EQO8_8_B1_g = config.getString("DSP_EQO8_8_B1_g");
    public static final String DSP_EQO8_8_B1_holdcount = config.getString("DSP_EQO8_8_B1_holdcount");
    public static final String DSP_EQO8_8_B1_minusone = config.getString("DSP_EQO8_8_B1_minusone");
    public static final String DSP_EQO8_8_B1_ramp = config.getString("DSP_EQO8_8_B1_ramp");
    //equalizer_parametric_transposed_direct_II: B2
    public static final String DSP_EQO8_8_B2_a = config.getString("DSP_EQO8_8_B2_a");
    public static final String DSP_EQO8_8_B2_b = config.getString("DSP_EQO8_8_B2_b");
    public static final String DSP_EQO8_8_B2_clip = config.getString("DSP_EQO8_8_B2_clip");
    public static final String DSP_EQO8_8_B2_g = config.getString("DSP_EQO8_8_B2_g");
    public static final String DSP_EQO8_8_B2_holdcount = config.getString("DSP_EQO8_8_B2_holdcount");
    public static final String DSP_EQO8_8_B2_minusone = config.getString("DSP_EQO8_8_B2_minusone");
    public static final String DSP_EQO8_8_B2_ramp = config.getString("DSP_EQO8_8_B2_ramp");
    //equalizer_parametric_transposed_direct_II: B3
    public static final String DSP_EQO8_8_B3_a = config.getString("DSP_EQO8_8_B3_a");
    public static final String DSP_EQO8_8_B3_b = config.getString("DSP_EQO8_8_B3_b");
    public static final String DSP_EQO8_8_B3_clip = config.getString("DSP_EQO8_8_B3_clip");
    public static final String DSP_EQO8_8_B3_g = config.getString("DSP_EQO8_8_B3_g");
    public static final String DSP_EQO8_8_B3_holdcount = config.getString("DSP_EQO8_8_B3_holdcount");
    public static final String DSP_EQO8_8_B3_minusone = config.getString("DSP_EQO8_8_B3_minusone");
    public static final String DSP_EQO8_8_B3_ramp = config.getString("DSP_EQO8_8_B3_ramp");
    //equalizer_parametric_transposed_direct_II: B4
    public static final String DSP_EQO8_8_B4_a = config.getString("DSP_EQO8_8_B4_a");
    public static final String DSP_EQO8_8_B4_b = config.getString("DSP_EQO8_8_B4_b");
    public static final String DSP_EQO8_8_B4_clip = config.getString("DSP_EQO8_8_B4_clip");
    public static final String DSP_EQO8_8_B4_g = config.getString("DSP_EQO8_8_B4_g");
    public static final String DSP_EQO8_8_B4_holdcount = config.getString("DSP_EQO8_8_B4_holdcount");
    public static final String DSP_EQO8_8_B4_minusone = config.getString("DSP_EQO8_8_B4_minusone");
    public static final String DSP_EQO8_8_B4_ramp = config.getString("DSP_EQO8_8_B4_ramp");
    //equalizer_parametric_transposed_direct_II: B5
    public static final String DSP_EQO8_8_B5_a = config.getString("DSP_EQO8_8_B5_a");
    public static final String DSP_EQO8_8_B5_b = config.getString("DSP_EQO8_8_B5_b");
    public static final String DSP_EQO8_8_B5_clip = config.getString("DSP_EQO8_8_B5_clip");
    public static final String DSP_EQO8_8_B5_g = config.getString("DSP_EQO8_8_B5_g");
    public static final String DSP_EQO8_8_B5_holdcount = config.getString("DSP_EQO8_8_B5_holdcount");
    public static final String DSP_EQO8_8_B5_minusone = config.getString("DSP_EQO8_8_B5_minusone");
    public static final String DSP_EQO8_8_B5_ramp = config.getString("DSP_EQO8_8_B5_ramp");
    //equalizer_parametric_transposed_direct_II: B6
    public static final String DSP_EQO8_8_B6_a = config.getString("DSP_EQO8_8_B6_a");
    public static final String DSP_EQO8_8_B6_b = config.getString("DSP_EQO8_8_B6_b");
    public static final String DSP_EQO8_8_B6_clip = config.getString("DSP_EQO8_8_B6_clip");
    public static final String DSP_EQO8_8_B6_g = config.getString("DSP_EQO8_8_B6_g");
    public static final String DSP_EQO8_8_B6_holdcount = config.getString("DSP_EQO8_8_B6_holdcount");
    public static final String DSP_EQO8_8_B6_minusone = config.getString("DSP_EQO8_8_B6_minusone");
    public static final String DSP_EQO8_8_B6_ramp = config.getString("DSP_EQO8_8_B6_ramp");
    //equalizer_parametric_transposed_direct_II: B7
    public static final String DSP_EQO8_8_B7_a = config.getString("DSP_EQO8_8_B7_a");
    public static final String DSP_EQO8_8_B7_b = config.getString("DSP_EQO8_8_B7_b");
    public static final String DSP_EQO8_8_B7_clip = config.getString("DSP_EQO8_8_B7_clip");
    public static final String DSP_EQO8_8_B7_g = config.getString("DSP_EQO8_8_B7_g");
    public static final String DSP_EQO8_8_B7_holdcount = config.getString("DSP_EQO8_8_B7_holdcount");
    public static final String DSP_EQO8_8_B7_minusone = config.getString("DSP_EQO8_8_B7_minusone");
    public static final String DSP_EQO8_8_B7_ramp = config.getString("DSP_EQO8_8_B7_ramp");
    //equalizer_parametric_transposed_direct_II: B1
    public static final String DSP_EQO8_7_B1_a = config.getString("DSP_EQO8_7_B1_a");
    public static final String DSP_EQO8_7_B1_b = config.getString("DSP_EQO8_7_B1_b");
    public static final String DSP_EQO8_7_B1_clip = config.getString("DSP_EQO8_7_B1_clip");
    public static final String DSP_EQO8_7_B1_g = config.getString("DSP_EQO8_7_B1_g");
    public static final String DSP_EQO8_7_B1_holdcount = config.getString("DSP_EQO8_7_B1_holdcount");
    public static final String DSP_EQO8_7_B1_minusone = config.getString("DSP_EQO8_7_B1_minusone");
    public static final String DSP_EQO8_7_B1_ramp = config.getString("DSP_EQO8_7_B1_ramp");
    //equalizer_parametric_transposed_direct_II: B2
    public static final String DSP_EQO8_7_B2_a = config.getString("DSP_EQO8_7_B2_a");
    public static final String DSP_EQO8_7_B2_b = config.getString("DSP_EQO8_7_B2_clip");
    public static final String DSP_EQO8_7_B2_clip = config.getString("DSP_EQO8_7_B2_clip");
    public static final String DSP_EQO8_7_B2_g = config.getString("DSP_EQO8_7_B2_g");
    public static final String DSP_EQO8_7_B2_holdcount = config.getString("DSP_EQO8_7_B2_holdcount");
    public static final String DSP_EQO8_7_B2_minusone = config.getString("DSP_EQO8_7_B2_minusone");
    public static final String DSP_EQO8_7_B2_ramp = config.getString("76240");
    //equalizer_parametric_transposed_direct_II: B3
    public static final String DSP_EQO8_7_B3_a = config.getString("DSP_EQO8_7_B3_a");
    public static final String DSP_EQO8_7_B3_b = config.getString("DSP_EQO8_7_B3_b");
    public static final String DSP_EQO8_7_B3_clip = config.getString("DSP_EQO8_7_B3_clip");
    public static final String DSP_EQO8_7_B3_g = config.getString("DSP_EQO8_7_B3_g");
    public static final String DSP_EQO8_7_B3_holdcount = config.getString("DSP_EQO8_7_B3_holdcount");
    public static final String DSP_EQO8_7_B3_minusone = config.getString("DSP_EQO8_7_B3_minusone");
    public static final String DSP_EQO8_7_B3_ramp = config.getString("DSP_EQO8_7_B3_ramp");
    //equalizer_parametric_transposed_direct_II: B4
    public static final String DSP_EQO8_7_B4_a = config.getString("DSP_EQO8_7_B4_a");
    public static final String DSP_EQO8_7_B4_b = config.getString("DSP_EQO8_7_B4_b");
    public static final String DSP_EQO8_7_B4_clip = config.getString("DSP_EQO8_7_B4_clip");
    public static final String DSP_EQO8_7_B4_g = config.getString("DSP_EQO8_7_B4_g");
    public static final String DSP_EQO8_7_B4_holdcount = config.getString("DSP_EQO8_7_B4_holdcount");
    public static final String DSP_EQO8_7_B4_minusone = config.getString("DSP_EQO8_7_B4_minusone");
    public static final String DSP_EQO8_7_B4_ramp = config.getString("DSP_EQO8_7_B4_ramp");
    //equalizer_parametric_transposed_direct_II: B5
    public static final String DSP_EQO8_7_B5_a = config.getString("DSP_EQO8_7_B5_a");
    public static final String DSP_EQO8_7_B5_b = config.getString("DSP_EQO8_7_B5_b");
    public static final String DSP_EQO8_7_B5_clip = config.getString("DSP_EQO8_7_B5_clip");
    public static final String DSP_EQO8_7_B5_g = config.getString("DSP_EQO8_7_B5_g");
    public static final String DSP_EQO8_7_B5_holdcount = config.getString("DSP_EQO8_7_B5_holdcount");
    public static final String DSP_EQO8_7_B5_minusone = config.getString("DSP_EQO8_7_B5_minusone");
    public static final String DSP_EQO8_7_B5_ramp = config.getString("DSP_EQO8_7_B5_ramp");
    //equalizer_parametric_transposed_direct_II: B6
    public static final String DSP_EQO8_7_B6_a = config.getString("DSP_EQO8_7_B6_a");
    public static final String DSP_EQO8_7_B6_b = config.getString("DSP_EQO8_7_B6_b");
    public static final String DSP_EQO8_7_B6_clip = config.getString("DSP_EQO8_7_B6_clip");
    public static final String DSP_EQO8_7_B6_g = config.getString("DSP_EQO8_7_B6_g");
    public static final String DSP_EQO8_7_B6_holdcount = config.getString("DSP_EQO8_7_B6_holdcount");
    public static final String DSP_EQO8_7_B6_minusone = config.getString("DSP_EQO8_7_B6_minusone");
    public static final String DSP_EQO8_7_B6_ramp = config.getString("DSP_EQO8_7_B6_ramp");
    //equalizer_parametric_transposed_direct_II: B7
    public static final String DSP_EQO8_7_B7_a = config.getString("DSP_EQO8_7_B7_a");
    public static final String DSP_EQO8_7_B7_b = config.getString("DSP_EQO8_7_B7_b");
    public static final String DSP_EQO8_7_B7_clip = config.getString("DSP_EQO8_7_B7_clip");
    public static final String DSP_EQO8_7_B7_g = config.getString("DSP_EQO8_7_B7_g");
    public static final String DSP_EQO8_7_B7_holdcount = config.getString("DSP_EQO8_7_B7_holdcount");
    public static final String DSP_EQO8_7_B7_minusone = config.getString("DSP_EQO8_7_B7_minusone");
    public static final String DSP_EQO8_7_B7_ramp = config.getString("DSP_EQO8_7_B7_ramp");
    //equalizer_parametric_transposed_direct_II: B1
    public static final String DSP_EQO8_6_B1_a = config.getString("DSP_EQO8_6_B1_a");
    public static final String DSP_EQO8_6_B1_b = config.getString("DSP_EQO8_6_B1_b");
    public static final String DSP_EQO8_6_B1_clip = config.getString("DSP_EQO8_6_B1_clip");
    public static final String DSP_EQO8_6_B1_g = config.getString("DSP_EQO8_6_B1_g");
    public static final String DSP_EQO8_6_B1_holdcount = config.getString("DSP_EQO8_6_B1_holdcount");
    public static final String DSP_EQO8_6_B1_minusone = config.getString("DSP_EQO8_6_B1_minusone");
    public static final String DSP_EQO8_6_B1_ramp = config.getString("DSP_EQO8_6_B1_ramp");
    //equalizer_parametric_transposed_direct_II: B2
    public static final String DSP_EQO8_6_B2_a = config.getString("DSP_EQO8_6_B2_a");
    public static final String DSP_EQO8_6_B2_b = config.getString("DSP_EQO8_6_B2_b");
    public static final String DSP_EQO8_6_B2_clip = config.getString("DSP_EQO8_6_B2_clip");
    public static final String DSP_EQO8_6_B2_g = config.getString("DSP_EQO8_6_B2_g");
    public static final String DSP_EQO8_6_B2_holdcount = config.getString("DSP_EQO8_6_B2_holdcount");
    public static final String DSP_EQO8_6_B2_minusone = config.getString("DSP_EQO8_6_B2_minusone");
    public static final String DSP_EQO8_6_B2_ramp = config.getString("DSP_EQO8_6_B2_ramp");
    //equalizer_parametric_transposed_direct_II: B3
    public static final String DSP_EQO8_6_B3_a = config.getString("DSP_EQO8_6_B3_a");
    public static final String DSP_EQO8_6_B3_b = config.getString("DSP_EQO8_6_B3_b");
    public static final String DSP_EQO8_6_B3_clip = config.getString("DSP_EQO8_6_B3_clip");
    public static final String DSP_EQO8_6_B3_g = config.getString("DSP_EQO8_6_B3_g");
    public static final String DSP_EQO8_6_B3_holdcount = config.getString("DSP_EQO8_6_B3_holdcount");
    public static final String DSP_EQO8_6_B3_minusone = config.getString("DSP_EQO8_6_B3_minusone");
    public static final String DSP_EQO8_6_B3_ramp = config.getString("DSP_EQO8_6_B3_ramp");
    //equalizer_parametric_transposed_direct_II: B4
    public static final String DSP_EQO8_6_B4_a = config.getString("DSP_EQO8_6_B4_a");
    public static final String DSP_EQO8_6_B4_b = config.getString("DSP_EQO8_6_B4_b");
    public static final String DSP_EQO8_6_B4_clip = config.getString("DSP_EQO8_6_B4_clip");
    public static final String DSP_EQO8_6_B4_g = config.getString("DSP_EQO8_6_B4_g");
    public static final String DSP_EQO8_6_B4_holdcount = config.getString("DSP_EQO8_6_B4_holdcount");
    public static final String DSP_EQO8_6_B4_minusone = config.getString("DSP_EQO8_6_B4_minusone");
    public static final String DSP_EQO8_6_B4_ramp = config.getString("DSP_EQO8_6_B4_ramp");
    //equalizer_parametric_transposed_direct_II: B5
    public static final String DSP_EQO8_6_B5_a = config.getString("DSP_EQO8_6_B5_a");
    public static final String DSP_EQO8_6_B5_b = config.getString("DSP_EQO8_6_B5_b");
    public static final String DSP_EQO8_6_B5_clip = config.getString("DSP_EQO8_6_B5_clip");
    public static final String DSP_EQO8_6_B5_g = config.getString("DSP_EQO8_6_B5_g");
    public static final String DSP_EQO8_6_B5_holdcount = config.getString("DSP_EQO8_6_B5_holdcount");
    public static final String DSP_EQO8_6_B5_minusone = config.getString("DSP_EQO8_6_B5_minusone");
    public static final String DSP_EQO8_6_B5_ramp = config.getString("DSP_EQO8_6_B5_ramp");
    //equalizer_parametric_transposed_direct_II: B6
    public static final String DSP_EQO8_6_B6_a = config.getString("DSP_EQO8_6_B6_a");
    public static final String DSP_EQO8_6_B6_b = config.getString("DSP_EQO8_6_B6_b");
    public static final String DSP_EQO8_6_B6_clip = config.getString("DSP_EQO8_6_B6_clip");
    public static final String DSP_EQO8_6_B6_g = config.getString("DSP_EQO8_6_B6_g");
    public static final String DSP_EQO8_6_B6_holdcount = config.getString("DSP_EQO8_6_B6_holdcount");
    public static final String DSP_EQO8_6_B6_minusone = config.getString("DSP_EQO8_6_B6_minusone");
    public static final String DSP_EQO8_6_B6_ramp = config.getString("DSP_EQO8_6_B6_ramp");
    //equalizer_parametric_transposed_direct_II: B7
    public static final String DSP_EQO8_6_B7_a = config.getString("DSP_EQO8_6_B7_a");
    public static final String DSP_EQO8_6_B7_b = config.getString("DSP_EQO8_6_B7_b");
    public static final String DSP_EQO8_6_B7_clip = config.getString("DSP_EQO8_6_B7_clip");
    public static final String DSP_EQO8_6_B7_g = config.getString("DSP_EQO8_6_B7_g");
    public static final String DSP_EQO8_6_B7_holdcount = config.getString("DSP_EQO8_6_B7_holdcount");
    public static final String DSP_EQO8_6_B7_minusone = config.getString("DSP_EQO8_6_B7_minusone");
    public static final String DSP_EQO8_6_B7_ramp = config.getString("DSP_EQO8_6_B7_ramp");
    //equalizer_parametric_transposed_direct_II: B1
    public static final String DSP_EQO8_5_B1_a = config.getString("DSP_EQO8_5_B1_a");
    public static final String DSP_EQO8_5_B1_b = config.getString("DSP_EQO8_5_B1_b");
    public static final String DSP_EQO8_5_B1_clip = config.getString("DSP_EQO8_5_B1_clip");
    public static final String DSP_EQO8_5_B1_g = config.getString("DSP_EQO8_5_B1_g");
    public static final String DSP_EQO8_5_B1_holdcount = config.getString("DSP_EQO8_5_B1_holdcount");
    public static final String DSP_EQO8_5_B1_minusone = config.getString("DSP_EQO8_5_B1_minusone");
    public static final String DSP_EQO8_5_B1_ramp = config.getString("DSP_EQO8_5_B1_ramp");
    //equalizer_parametric_transposed_direct_II: B2
    public static final String DSP_EQO8_5_B2_a = config.getString("DSP_EQO8_5_B2_a");
    public static final String DSP_EQO8_5_B2_b = config.getString("DSP_EQO8_5_B2_b");
    public static final String DSP_EQO8_5_B2_clip = config.getString("DSP_EQO8_5_B2_clip");
    public static final String DSP_EQO8_5_B2_g = config.getString("DSP_EQO8_5_B2_g");
    public static final String DSP_EQO8_5_B2_holdcount = config.getString("DSP_EQO8_5_B2_holdcount");
    public static final String DSP_EQO8_5_B2_minusone = config.getString("DSP_EQO8_5_B2_minusone");
    public static final String DSP_EQO8_5_B2_ramp = config.getString("DSP_EQO8_5_B2_ramp");
    //equalizer_parametric_transposed_direct_II: B3
    public static final String DSP_EQO8_5_B3_a = config.getString("DSP_EQO8_5_B3_a");
    public static final String DSP_EQO8_5_B3_b = config.getString("DSP_EQO8_5_B3_b");
    public static final String DSP_EQO8_5_B3_clip = config.getString("DSP_EQO8_5_B3_clip");
    public static final String DSP_EQO8_5_B3_g = config.getString("DSP_EQO8_5_B3_g");
    public static final String DSP_EQO8_5_B3_holdcount = config.getString("DSP_EQO8_5_B3_holdcount");
    public static final String DSP_EQO8_5_B3_minusone = config.getString("DSP_EQO8_5_B3_minusone");
    public static final String DSP_EQO8_5_B3_ramp = config.getString("DSP_EQO8_5_B3_ramp");
    //equalizer_parametric_transposed_direct_II: B4
    public static final String DSP_EQO8_5_B4_a = config.getString("DSP_EQO8_5_B4_a");
    public static final String DSP_EQO8_5_B4_b = config.getString("DSP_EQO8_5_B4_b");
    public static final String DSP_EQO8_5_B4_clip = config.getString("DSP_EQO8_5_B4_clip");
    public static final String DSP_EQO8_5_B4_g = config.getString("DSP_EQO8_5_B4_g");
    public static final String DSP_EQO8_5_B4_holdcount = config.getString("DSP_EQO8_5_B4_holdcount");
    public static final String DSP_EQO8_5_B4_minusone = config.getString("DSP_EQO8_5_B4_minusone");
    public static final String DSP_EQO8_5_B4_ramp = config.getString("DSP_EQO8_5_B4_ramp");
    //equalizer_parametric_transposed_direct_II: B5
    public static final String DSP_EQO8_5_B5_a = config.getString("DSP_EQO8_5_B5_a");
    public static final String DSP_EQO8_5_B5_b = config.getString("DSP_EQO8_5_B5_b");
    public static final String DSP_EQO8_5_B5_clip = config.getString("DSP_EQO8_5_B5_clip");
    public static final String DSP_EQO8_5_B5_g = config.getString("DSP_EQO8_5_B5_g");
    public static final String DSP_EQO8_5_B5_holdcount = config.getString("DSP_EQO8_5_B5_holdcount");
    public static final String DSP_EQO8_5_B5_minusone = config.getString("DSP_EQO8_5_B5_minusone");
    public static final String DSP_EQO8_5_B5_ramp = config.getString("DSP_EQO8_5_B5_ramp");
    //equalizer_parametric_transposed_direct_II: B6
    public static final String DSP_EQO8_5_B6_a = config.getString("DSP_EQO8_5_B6_a");
    public static final String DSP_EQO8_5_B6_b = config.getString("DSP_EQO8_5_B6_b");
    public static final String DSP_EQO8_5_B6_clip = config.getString("DSP_EQO8_5_B6_clip");
    public static final String DSP_EQO8_5_B6_g = config.getString("DSP_EQO8_5_B6_g");
    public static final String DSP_EQO8_5_B6_holdcount = config.getString("DSP_EQO8_5_B6_holdcount");
    public static final String DSP_EQO8_5_B6_minusone = config.getString("DSP_EQO8_5_B6_minusone");
    public static final String DSP_EQO8_5_B6_ramp = config.getString("DSP_EQO8_5_B6_ramp");
    //equalizer_parametric_transposed_direct_II: B7
    public static final String DSP_EQO8_5_B7_a = config.getString("DSP_EQO8_5_B7_a");
    public static final String DSP_EQO8_5_B7_b = config.getString("DSP_EQO8_5_B7_b");
    public static final String DSP_EQO8_5_B7_clip = config.getString("DSP_EQO8_5_B7_clip");
    public static final String DSP_EQO8_5_B7_g = config.getString("DSP_EQO8_5_B7_g");
    public static final String DSP_EQO8_5_B7_holdcount = config.getString("DSP_EQO8_5_B7_holdcount");
    public static final String DSP_EQO8_5_B7_minusone = config.getString("DSP_EQO8_5_B7_minusone");
    public static final String DSP_EQO8_5_B7_ramp = config.getString("DSP_EQO8_5_B7_ramp");
    //equalizer_parametric_transposed_direct_II: B1
    public static final String DSP_EQO8_4_B1_a = config.getString("DSP_EQO8_4_B1_a");
    public static final String DSP_EQO8_4_B1_b = config.getString("DSP_EQO8_4_B1_b");
    public static final String DSP_EQO8_4_B1_clip = config.getString("DSP_EQO8_4_B1_clip");
    public static final String DSP_EQO8_4_B1_g = config.getString("DSP_EQO8_4_B1_g");
    public static final String DSP_EQO8_4_B1_holdcount = config.getString("DSP_EQO8_4_B1_holdcount");
    public static final String DSP_EQO8_4_B1_minusone = config.getString("DSP_EQO8_4_B1_minusone");
    public static final String DSP_EQO8_4_B1_ramp = config.getString("DSP_EQO8_4_B1_ramp");
    //equalizer_parametric_transposed_direct_II: B2
    public static final String DSP_EQO8_4_B2_a = config.getString("DSP_EQO8_4_B2_a");
    public static final String DSP_EQO8_4_B2_b = config.getString("DSP_EQO8_4_B2_b");
    public static final String DSP_EQO8_4_B2_clip = config.getString("DSP_EQO8_4_B2_clip");
    public static final String DSP_EQO8_4_B2_g = config.getString("DSP_EQO8_4_B2_g");
    public static final String DSP_EQO8_4_B2_holdcount = config.getString("DSP_EQO8_4_B2_holdcount");
    public static final String DSP_EQO8_4_B2_minusone = config.getString("DSP_EQO8_4_B2_minusone");
    public static final String DSP_EQO8_4_B2_ramp = config.getString("DSP_EQO8_4_B2_ramp");
    //equalizer_parametric_transposed_direct_II: B3
    public static final String DSP_EQO8_4_B3_a = config.getString("DSP_EQO8_4_B3_a");
    public static final String DSP_EQO8_4_B3_b = config.getString("DSP_EQO8_4_B3_b");
    public static final String DSP_EQO8_4_B3_clip = config.getString("DSP_EQO8_4_B3_clip");
    public static final String DSP_EQO8_4_B3_g = config.getString("DSP_EQO8_4_B3_g");
    public static final String DSP_EQO8_4_B3_holdcount = config.getString("DSP_EQO8_4_B3_holdcount");
    public static final String DSP_EQO8_4_B3_minusone = config.getString("DSP_EQO8_4_B3_minusone");
    public static final String DSP_EQO8_4_B3_ramp = config.getString("DSP_EQO8_4_B3_ramp");
    //equalizer_parametric_transposed_direct_II: B4
    public static final String DSP_EQO8_4_B4_a = config.getString("DSP_EQO8_4_B4_a");
    public static final String DSP_EQO8_4_B4_b = config.getString("DSP_EQO8_4_B4_b");
    public static final String DSP_EQO8_4_B4_clip = config.getString("DSP_EQO8_4_B4_clip");
    public static final String DSP_EQO8_4_B4_g = config.getString("DSP_EQO8_4_B4_g");
    public static final String DSP_EQO8_4_B4_holdcount = config.getString("DSP_EQO8_4_B4_holdcount");
    public static final String DSP_EQO8_4_B4_minusone = config.getString("DSP_EQO8_4_B4_minusone");
    public static final String DSP_EQO8_4_B4_ramp = config.getString("DSP_EQO8_4_B4_ramp");
    //equalizer_parametric_transposed_direct_II: B5
    public static final String DSP_EQO8_4_B5_a = config.getString("DSP_EQO8_4_B5_a");
    public static final String DSP_EQO8_4_B5_b = config.getString("DSP_EQO8_4_B5_b");
    public static final String DSP_EQO8_4_B5_clip = config.getString("DSP_EQO8_4_B5_clip");
    public static final String DSP_EQO8_4_B5_g = config.getString("DSP_EQO8_4_B5_g");
    public static final String DSP_EQO8_4_B5_holdcount = config.getString("DSP_EQO8_4_B5_holdcount");
    public static final String DSP_EQO8_4_B5_minusone = config.getString("DSP_EQO8_4_B5_minusone");
    public static final String DSP_EQO8_4_B5_ramp = config.getString("DSP_EQO8_4_B5_ramp");
    //equalizer_parametric_transposed_direct_II: B6
    public static final String DSP_EQO8_4_B6_a = config.getString("DSP_EQO8_4_B6_a");
    public static final String DSP_EQO8_4_B6_b = config.getString("DSP_EQO8_4_B6_b");
    public static final String DSP_EQO8_4_B6_clip = config.getString("DSP_EQO8_4_B6_clip");
    public static final String DSP_EQO8_4_B6_g = config.getString("DSP_EQO8_4_B6_g");
    public static final String DSP_EQO8_4_B6_holdcount = config.getString("DSP_EQO8_4_B6_holdcount");
    public static final String DSP_EQO8_4_B6_minusone = config.getString("DSP_EQO8_4_B6_minusone");
    public static final String DSP_EQO8_4_B6_ramp = config.getString("DSP_EQO8_4_B6_ramp");
    //equalizer_parametric_transposed_direct_II: B7
    public static final String DSP_EQO8_4_B7_a = config.getString("DSP_EQO8_4_B7_a");
    public static final String DSP_EQO8_4_B7_b = config.getString("DSP_EQO8_4_B7_b");
    public static final String DSP_EQO8_4_B7_clip = config.getString("DSP_EQO8_4_B7_clip");
    public static final String DSP_EQO8_4_B7_g = config.getString("DSP_EQO8_4_B7_g");
    public static final String DSP_EQO8_4_B7_holdcount = config.getString("DSP_EQO8_4_B7_holdcount");
    public static final String DSP_EQO8_4_B7_minusone = config.getString("DSP_EQO8_4_B7_minusone");
    public static final String DSP_EQO8_4_B7_ramp = config.getString("DSP_EQO8_4_B7_ramp");
    //equalizer_parametric_transposed_direct_II: B1
    public static final String DSP_EQO8_3_B1_a = config.getString("DSP_EQO8_3_B1_a");
    public static final String DSP_EQO8_3_B1_b = config.getString("DSP_EQO8_3_B1_b");
    public static final String DSP_EQO8_3_B1_clip = config.getString("DSP_EQO8_3_B1_clip");
    public static final String DSP_EQO8_3_B1_g = config.getString("DSP_EQO8_3_B1_g");
    public static final String DSP_EQO8_3_B1_holdcount = config.getString("DSP_EQO8_3_B1_holdcount");
    public static final String DSP_EQO8_3_B1_minusone = config.getString("DSP_EQO8_3_B1_minusone");
    public static final String DSP_EQO8_3_B1_ramp = config.getString("DSP_EQO8_3_B1_ramp");
    //equalizer_parametric_transposed_direct_II: B2
    public static final String DSP_EQO8_3_B2_a = config.getString("DSP_EQO8_3_B2_a");
    public static final String DSP_EQO8_3_B2_b = config.getString("DSP_EQO8_3_B2_b");
    public static final String DSP_EQO8_3_B2_clip = config.getString("DSP_EQO8_3_B2_clip");
    public static final String DSP_EQO8_3_B2_g = config.getString("DSP_EQO8_3_B2_g");
    public static final String DSP_EQO8_3_B2_holdcount = config.getString("DSP_EQO8_3_B2_holdcount");
    public static final String DSP_EQO8_3_B2_minusone = config.getString("DSP_EQO8_3_B2_minusone");
    public static final String DSP_EQO8_3_B2_ramp = config.getString("DSP_EQO8_3_B2_ramp");
    //equalizer_parametric_transposed_direct_II: B3
    public static final String DSP_EQO8_3_B3_a = config.getString("DSP_EQO8_3_B3_a");
    public static final String DSP_EQO8_3_B3_b = config.getString("DSP_EQO8_3_B3_b");
    public static final String DSP_EQO8_3_B3_clip = config.getString("DSP_EQO8_3_B3_clip");
    public static final String DSP_EQO8_3_B3_g = config.getString("DSP_EQO8_3_B3_g");
    public static final String DSP_EQO8_3_B3_holdcount = config.getString("DSP_EQO8_3_B3_holdcount");
    public static final String DSP_EQO8_3_B3_minusone = config.getString("DSP_EQO8_3_B3_minusone");
    public static final String DSP_EQO8_3_B3_ramp = config.getString("DSP_EQO8_3_B3_ramp");
    //equalizer_parametric_transposed_direct_II: B4
    public static final String DSP_EQO8_3_B4_a = config.getString("DSP_EQO8_3_B4_a");
    public static final String DSP_EQO8_3_B4_b = config.getString("DSP_EQO8_3_B4_b");
    public static final String DSP_EQO8_3_B4_clip = config.getString("DSP_EQO8_3_B4_clip");
    public static final String DSP_EQO8_3_B4_g = config.getString("DSP_EQO8_3_B4_g");
    public static final String DSP_EQO8_3_B4_holdcount = config.getString("DSP_EQO8_3_B4_holdcount");
    public static final String DSP_EQO8_3_B4_minusone = config.getString("DSP_EQO8_3_B4_minusone");
    public static final String DSP_EQO8_3_B4_ramp = config.getString("DSP_EQO8_3_B4_ramp");
    //equalizer_parametric_transposed_direct_II: B5
    public static final String DSP_EQO8_3_B5_a = config.getString("DSP_EQO8_3_B5_a");
    public static final String DSP_EQO8_3_B5_b = config.getString("DSP_EQO8_3_B5_b");
    public static final String DSP_EQO8_3_B5_clip = config.getString("DSP_EQO8_3_B5_clip");
    public static final String DSP_EQO8_3_B5_g = config.getString("DSP_EQO8_3_B5_g");
    public static final String DSP_EQO8_3_B5_holdcount = config.getString("DSP_EQO8_3_B5_holdcount");
    public static final String DSP_EQO8_3_B5_minusone = config.getString("DSP_EQO8_3_B5_minusone");
    public static final String DSP_EQO8_3_B5_ramp = config.getString("DSP_EQO8_3_B5_ramp");
    //equalizer_parametric_transposed_direct_II: B6
    public static final String DSP_EQO8_3_B6_a = config.getString("DSP_EQO8_3_B6_a");
    public static final String DSP_EQO8_3_B6_b = config.getString("DSP_EQO8_3_B6_b");
    public static final String DSP_EQO8_3_B6_clip = config.getString("DSP_EQO8_3_B6_clip");
    public static final String DSP_EQO8_3_B6_g = config.getString("DSP_EQO8_3_B6_g");
    public static final String DSP_EQO8_3_B6_holdcount = config.getString("DSP_EQO8_3_B6_holdcount");
    public static final String DSP_EQO8_3_B6_minusone = config.getString("DSP_EQO8_3_B6_minusone");
    public static final String DSP_EQO8_3_B6_ramp = config.getString("DSP_EQO8_3_B6_ramp");
    //equalizer_parametric_transposed_direct_II: B7
    public static final String DSP_EQO8_3_B7_a = config.getString("DSP_EQO8_3_B7_a");
    public static final String DSP_EQO8_3_B7_b = config.getString("DSP_EQO8_3_B7_b");
    public static final String DSP_EQO8_3_B7_clip = config.getString("DSP_EQO8_3_B7_clip");
    public static final String DSP_EQO8_3_B7_g = config.getString("DSP_EQO8_3_B7_g");
    public static final String DSP_EQO8_3_B7_holdcount = config.getString("DSP_EQO8_3_B7_holdcount");
    public static final String DSP_EQO8_3_B7_minusone = config.getString("DSP_EQO8_3_B7_minusone");
    public static final String DSP_EQO8_3_B7_ramp = config.getString("DSP_EQO8_3_B7_ramp");
    //equalizer_parametric_transposed_direct_II: B1
    public static final String DSP_EQO8_2_B1_a = config.getString("DSP_EQO8_2_B1_a");
    public static final String DSP_EQO8_2_B1_b = config.getString("DSP_EQO8_2_B1_b");
    public static final String DSP_EQO8_2_B1_clip = config.getString("DSP_EQO8_2_B1_clip");
    public static final String DSP_EQO8_2_B1_g = config.getString("DSP_EQO8_2_B1_g");
    public static final String DSP_EQO8_2_B1_holdcount = config.getString("DSP_EQO8_2_B1_holdcount");
    public static final String DSP_EQO8_2_B1_minusone = config.getString("DSP_EQO8_2_B1_minusone");
    public static final String DSP_EQO8_2_B1_ramp = config.getString("DSP_EQO8_2_B1_ramp");
    //equalizer_parametric_transposed_direct_II: B2
    public static final String DSP_EQO8_2_B2_a = config.getString("DSP_EQO8_2_B2_a");
    public static final String DSP_EQO8_2_B2_b = config.getString("DSP_EQO8_2_B2_b");
    public static final String DSP_EQO8_2_B2_clip = config.getString("DSP_EQO8_2_B2_clip");
    public static final String DSP_EQO8_2_B2_g = config.getString("DSP_EQO8_2_B2_g");
    public static final String DSP_EQO8_2_B2_holdcount = config.getString("DSP_EQO8_2_B2_holdcount");
    public static final String DSP_EQO8_2_B2_minusone = config.getString("DSP_EQO8_2_B2_minusone");
    public static final String DSP_EQO8_2_B2_ramp = config.getString("DSP_EQO8_2_B2_ramp");
    //equalizer_parametric_transposed_direct_II: B3
    public static final String DSP_EQO8_2_B3_a = config.getString("DSP_EQO8_2_B3_a");
    public static final String DSP_EQO8_2_B3_b = config.getString("DSP_EQO8_2_B3_b");
    public static final String DSP_EQO8_2_B3_clip = config.getString("DSP_EQO8_2_B3_clip");
    public static final String DSP_EQO8_2_B3_g = config.getString("DSP_EQO8_2_B3_g");
    public static final String DSP_EQO8_2_B3_holdcount = config.getString("DSP_EQO8_2_B3_holdcount");
    public static final String DSP_EQO8_2_B3_minusone = config.getString("DSP_EQO8_2_B3_minusone");
    public static final String DSP_EQO8_2_B3_ramp = config.getString("DSP_EQO8_2_B3_ramp");
    //equalizer_parametric_transposed_direct_II: B4
    public static final String DSP_EQO8_2_B4_a = config.getString("DSP_EQO8_2_B4_a");
    public static final String DSP_EQO8_2_B4_b = config.getString("DSP_EQO8_2_B4_b");
    public static final String DSP_EQO8_2_B4_clip = config.getString("DSP_EQO8_2_B4_clip");
    public static final String DSP_EQO8_2_B4_g = config.getString("DSP_EQO8_2_B4_g");
    public static final String DSP_EQO8_2_B4_holdcount = config.getString("DSP_EQO8_2_B4_holdcount");
    public static final String DSP_EQO8_2_B4_minusone = config.getString("DSP_EQO8_2_B4_minusone");
    public static final String DSP_EQO8_2_B4_ramp = config.getString("DSP_EQO8_2_B4_ramp");
    //equalizer_parametric_transposed_direct_II: B5
    public static final String DSP_EQO8_2_B5_a = config.getString("DSP_EQO8_2_B5_a");
    public static final String DSP_EQO8_2_B5_b = config.getString("DSP_EQO8_2_B5_b");
    public static final String DSP_EQO8_2_B5_clip = config.getString("DSP_EQO8_2_B5_clip");
    public static final String DSP_EQO8_2_B5_g = config.getString("DSP_EQO8_2_B5_g");
    public static final String DSP_EQO8_2_B5_holdcount = config.getString("DSP_EQO8_2_B5_holdcount");
    public static final String DSP_EQO8_2_B5_minusone = config.getString("DSP_EQO8_2_B5_minusone");
    public static final String DSP_EQO8_2_B5_ramp = config.getString("DSP_EQO8_2_B5_ramp");
    //equalizer_parametric_transposed_direct_II: B6
    public static final String DSP_EQO8_2_B6_a = config.getString("DSP_EQO8_2_B6_a");
    public static final String DSP_EQO8_2_B6_b = config.getString("DSP_EQO8_2_B6_b");
    public static final String DSP_EQO8_2_B6_clip = config.getString("DSP_EQO8_2_B6_clip");
    public static final String DSP_EQO8_2_B6_g = config.getString("DSP_EQO8_2_B6_g");
    public static final String DSP_EQO8_2_B6_holdcount = config.getString("DSP_EQO8_2_B6_holdcount");
    public static final String DSP_EQO8_2_B6_minusone = config.getString("DSP_EQO8_2_B6_minusone");
    public static final String DSP_EQO8_2_B6_ramp = config.getString("DSP_EQO8_2_B6_ramp");
    //equalizer_parametric_transposed_direct_II: B7
    public static final String DSP_EQO8_2_B7_a = config.getString("DSP_EQO8_2_B7_a");
    public static final String DSP_EQO8_2_B7_b = config.getString("DSP_EQO8_2_B7_b");
    public static final String DSP_EQO8_2_B7_clip = config.getString("DSP_EQO8_2_B7_clip");
    public static final String DSP_EQO8_2_B7_g = config.getString("DSP_EQO8_2_B7_g");
    public static final String DSP_EQO8_2_B7_holdcount = config.getString("DSP_EQO8_2_B7_holdcount");
    public static final String DSP_EQO8_2_B7_minusone = config.getString("DSP_EQO8_2_B7_minusone");
    public static final String DSP_EQO8_2_B7_ramp = config.getString("DSP_EQO8_2_B7_ramp");
    //equalizer_parametric_transposed_direct_II: B1
    public static final String DSP_EQO8_1_B1_a = config.getString("DSP_EQO8_1_B1_a");
    public static final String DSP_EQO8_1_B1_b = config.getString("DSP_EQO8_1_B1_b");
    public static final String DSP_EQO8_1_B1_clip = config.getString("DSP_EQO8_1_B1_clip");
    public static final String DSP_EQO8_1_B1_g = config.getString("DSP_EQO8_1_B1_g");
    public static final String DSP_EQO8_1_B1_holdcount = config.getString("DSP_EQO8_1_B1_holdcount");
    public static final String DSP_EQO8_1_B1_minusone = config.getString("DSP_EQO8_1_B1_minusone");
    public static final String DSP_EQO8_1_B1_ramp = config.getString("DSP_EQO8_1_B1_ramp");
    //equalizer_parametric_transposed_direct_II: B2
    public static final String DSP_EQO8_1_B2_a = config.getString("DSP_EQO8_1_B2_a");
    public static final String DSP_EQO8_1_B2_b = config.getString("DSP_EQO8_1_B2_b");
    public static final String DSP_EQO8_1_B2_clip = config.getString("DSP_EQO8_1_B2_clip");
    public static final String DSP_EQO8_1_B2_g = config.getString("DSP_EQO8_1_B2_g");
    public static final String DSP_EQO8_1_B2_holdcount = config.getString("DSP_EQO8_1_B2_holdcount");
    public static final String DSP_EQO8_1_B2_minusone = config.getString("DSP_EQO8_1_B2_minusone");
    public static final String DSP_EQO8_1_B2_ramp = config.getString("DSP_EQO8_1_B2_ramp");
    //equalizer_parametric_transposed_direct_II: B3
    public static final String DSP_EQO8_1_B3_a = config.getString("DSP_EQO8_1_B3_a");
    public static final String DSP_EQO8_1_B3_b = config.getString("DSP_EQO8_1_B3_b");
    public static final String DSP_EQO8_1_B3_clip = config.getString("DSP_EQO8_1_B3_clip");
    public static final String DSP_EQO8_1_B3_g = config.getString("DSP_EQO8_1_B3_g");
    public static final String DSP_EQO8_1_B3_holdcount = config.getString("DSP_EQO8_1_B3_holdcount");
    public static final String DSP_EQO8_1_B3_minusone = config.getString("DSP_EQO8_1_B3_minusone");
    public static final String DSP_EQO8_1_B3_ramp = config.getString("DSP_EQO8_1_B3_ramp");
    //equalizer_parametric_transposed_direct_II: B4
    public static final String DSP_EQO8_1_B4_a = config.getString("DSP_EQO8_1_B4_a");
    public static final String DSP_EQO8_1_B4_b = config.getString("DSP_EQO8_1_B4_b");
    public static final String DSP_EQO8_1_B4_clip = config.getString("DSP_EQO8_1_B4_clip");
    public static final String DSP_EQO8_1_B4_g = config.getString("DSP_EQO8_1_B4_g");
    public static final String DSP_EQO8_1_B4_holdcount = config.getString("DSP_EQO8_1_B4_holdcount");
    public static final String DSP_EQO8_1_B4_minusone = config.getString("DSP_EQO8_1_B4_minusone");
    public static final String DSP_EQO8_1_B4_ramp = config.getString("DSP_EQO8_1_B4_ramp");
    //equalizer_parametric_transposed_direct_II: B5
    public static final String DSP_EQO8_1_B5_a = config.getString("DSP_EQO8_1_B5_a");
    public static final String DSP_EQO8_1_B5_b = config.getString("DSP_EQO8_1_B5_b");
    public static final String DSP_EQO8_1_B5_clip = config.getString("DSP_EQO8_1_B5_clip");
    public static final String DSP_EQO8_1_B5_g = config.getString("DSP_EQO8_1_B5_g");
    public static final String DSP_EQO8_1_B5_holdcount = config.getString("DSP_EQO8_1_B5_holdcount");
    public static final String DSP_EQO8_1_B5_minusone = config.getString("DSP_EQO8_1_B5_minusone");
    public static final String DSP_EQO8_1_B5_ramp = config.getString("DSP_EQO8_1_B5_ramp");
    //equalizer_parametric_transposed_direct_II: B6
    public static final String DSP_EQO8_1_B6_a = config.getString("DSP_EQO8_1_B6_a");
    public static final String DSP_EQO8_1_B6_b = config.getString("DSP_EQO8_1_B6_b");
    public static final String DSP_EQO8_1_B6_clip = config.getString("DSP_EQO8_1_B6_clip");
    public static final String DSP_EQO8_1_B6_g = config.getString("DSP_EQO8_1_B6_g");
    public static final String DSP_EQO8_1_B6_holdcount = config.getString("DSP_EQO8_1_B6_holdcount");
    public static final String DSP_EQO8_1_B6_minusone = config.getString("DSP_EQO8_1_B6_minusone");
    public static final String DSP_EQO8_1_B6_ramp = config.getString("DSP_EQO8_1_B6_ramp");
    //equalizer_parametric_transposed_direct_II: B7
    public static final String DSP_EQO8_1_B7_a = config.getString("DSP_EQO8_1_B7_a");
    public static final String DSP_EQO8_1_B7_b = config.getString("DSP_EQO8_1_B7_b");
    public static final String DSP_EQO8_1_B7_clip = config.getString("DSP_EQO8_1_B7_clip");
    public static final String DSP_EQO8_1_B7_g = config.getString("DSP_EQO8_1_B7_g");
    public static final String DSP_EQO8_1_B7_holdcount = config.getString("DSP_EQO8_1_B7_holdcount");
    public static final String DSP_EQO8_1_B7_minusone = config.getString("DSP_EQO8_1_B7_minusone");
    public static final String DSP_EQO8_1_B7_ramp = config.getString("DSP_EQO8_1_B7_ramp");
    //gain_up_24dB_multi_channel: NetTX Levels
    public static final String CS496122_NetTXLevels_channelclip1 = config.getString("CS496122_NetTXLevels_channelclip1");
    public static final String CS496122_NetTXLevels_channelclip2 = config.getString("CS496122_NetTXLevels_channelclip2");
    public static final String CS496122_NetTXLevels_channelclip3 = config.getString("CS496122_NetTXLevels_channelclip3");
    public static final String CS496122_NetTXLevels_channelclip4 = config.getString("CS496122_NetTXLevels_channelclip4");
    public static final String CS496122_NetTXLevels_channelclip5 = config.getString("CS496122_NetTXLevels_channelclip5");
    public static final String CS496122_NetTXLevels_channelclip6 = config.getString("CS496122_NetTXLevels_channelclip6");
    public static final String CS496122_NetTXLevels_channelclip7 = config.getString("CS496122_NetTXLevels_channelclip7");
    public static final String CS496122_NetTXLevels_channelclip8 = config.getString("CS496122_NetTXLevels_channelclip8");
    public static final String CS496122_NetTXLevels_g1 = config.getString("CS496122_NetTXLevels_g1");
    public static final String CS496122_NetTXLevels_g2 = config.getString("CS496122_NetTXLevels_g2");
    public static final String CS496122_NetTXLevels_g3 = config.getString("CS496122_NetTXLevels_g3");
    public static final String CS496122_NetTXLevels_g4 = config.getString("CS496122_NetTXLevels_g4");
    public static final String CS496122_NetTXLevels_g5 = config.getString("CS496122_NetTXLevels_g5");
    public static final String CS496122_NetTXLevels_g6 = config.getString("CS496122_NetTXLevels_g6");
    public static final String CS496122_NetTXLevels_g7 = config.getString("CS496122_NetTXLevels_g7");
    public static final String CS496122_NetTXLevels_g8 = config.getString("CS496122_NetTXLevels_g8");
    public static final String CS496122_NetTXLevels_holdcount = config.getString("CS496122_NetTXLevels_holdcount");
    public static final String CS496122_NetTXLevels_ramp = config.getString("CS496122_NetTXLevels_ramp");
    //gain_multi_channel: GNO8
    public static final String DSP_GNO8_channelclip1 = config.getString("DSP_GNO8_channelclip1");
    public static final String DSP_GNO8_channelclip2 = config.getString("DSP_GNO8_channelclip2");
    public static final String DSP_GNO8_channelclip3 = config.getString("DSP_GNO8_channelclip3");
    public static final String DSP_GNO8_channelclip4 = config.getString("DSP_GNO8_channelclip4");
    public static final String DSP_GNO8_channelclip5 = config.getString("DSP_GNO8_channelclip5");
    public static final String DSP_GNO8_channelclip6 = config.getString("DSP_GNO8_channelclip6");
    public static final String DSP_GNO8_channelclip7 = config.getString("DSP_GNO8_channelclip7");
    public static final String DSP_GNO8_channelclip8 = config.getString("DSP_GNO8_channelclip8");
    public static final String DSP_GNO8_g1 = config.getString("DSP_GNO8_g1");
    public static final String DSP_GNO8_g2 = config.getString("DSP_GNO8_g2");
    public static final String DSP_GNO8_g3 = config.getString("DSP_GNO8_g3");
    public static final String DSP_GNO8_g4 = config.getString("DSP_GNO8_g4");
    public static final String DSP_GNO8_g5 = config.getString("DSP_GNO8_g5");
    public static final String DSP_GNO8_g6 = config.getString("DSP_GNO8_g6");
    public static final String DSP_GNO8_g7 = config.getString("DSP_GNO8_g7");
    public static final String DSP_GNO8_g8 = config.getString("DSP_GNO8_g8");
    public static final String DSP_GNO8_holdcount = config.getString("DSP_GNO8_holdcount");
    public static final String DSP_GNO8_ramp = config.getString("DSP_GNO8_ramp");
    //mixer_NxM: 8
    public static final String DSP_TNO8_8_holdcount = config.getString("DSP_TNO8_8_holdcount");
    public static final String DSP_TNO8_8_input1output1send = config.getString("DSP_TNO8_8_input1output1send");
    public static final String DSP_TNO8_8_input2output1send = config.getString("DSP_TNO8_8_input2output1send");
    public static final String DSP_TNO8_8_outputclip1 = config.getString("DSP_TNO8_8_outputclip1");
    public static final String DSP_TNO8_8_ramp = config.getString("DSP_TNO8_8_ramp");
    //detector_peak_square: Peak Square Detector
    public static final String DSP_LMO8_8_PeakSquareDetector_inputdisable1 = config.getString("DSP_LMO8_8_PeakSquareDetector_inputdisable1");
    public static final String DSP_LMO8_8_PeakSquareDetector_maxpeak = config.getString("DSP_LMO8_8_PeakSquareDetector_maxpeak");
    public static final String DSP_LMO8_8_PeakSquareDetector_tc = config.getString("DSP_LMO8_8_PeakSquareDetector_tc");
    //dynamic_compressor: Compressor
    public static final String DSP_LMO8_8_Compressor_dspattack = config.getString("DSP_LMO8_8_Compressor_dspattack");
    public static final String DSP_LMO8_8_Compressor_dspbypass = config.getString("DSP_LMO8_8_Compressor_dspbypass");
    public static final String DSP_LMO8_8_Compressor_dspratio = config.getString("DSP_LMO8_8_Compressor_dspratio");
    public static final String DSP_LMO8_8_Compressor_dspreduction = config.getString("DSP_LMO8_8_Compressor_dspreduction");
    public static final String DSP_LMO8_8_Compressor_dsprelease = config.getString("DSP_LMO8_8_Compressor_dsprelease");
    public static final String DSP_LMO8_8_Compressor_region = config.getString("DSP_LMO8_8_Compressor_region");
    public static final String DSP_LMO8_8_Compressor_softknee = config.getString("DSP_LMO8_8_Compressor_softknee");
    public static final String DSP_LMO8_8_Compressor_threshold = config.getString("DSP_LMO8_8_Compressor_threshold");
    //mixer_NxM: 7
    public static final String DSP_TNO8_7_holdcount = config.getString("DSP_TNO8_7_holdcount");
    public static final String DSP_TNO8_7_input1output1send = config.getString("DSP_TNO8_7_input1output1send");
    public static final String DSP_TNO8_7_input2output1send = config.getString("DSP_TNO8_7_input2output1send");
    public static final String DSP_TNO8_7_outputclip1 = config.getString("DSP_TNO8_7_outputclip1");
    public static final String DSP_TNO8_7_ramp = config.getString("DSP_TNO8_7_ramp");
    //detector_peak_square: Peak Square Detector
    public static final String DSP_LMO8_7_PeakSquareDetector_inputdisable1 = config.getString("DSP_LMO8_7_PeakSquareDetector_inputdisable1");
    public static final String DSP_LMO8_7_PeakSquareDetector_maxpeak = config.getString("DSP_LMO8_7_PeakSquareDetector_maxpeak");
    public static final String DSP_LMO8_7_PeakSquareDetector_tc = config.getString("DSP_LMO8_7_PeakSquareDetector_tc");
    //dynamic_compressor: Compressor
    public static final String DSP_LMO8_7_Compressor_dspattack = config.getString("DSP_LMO8_7_Compressor_dspattack");
    public static final String DSP_LMO8_7_Compressor_dspbypass = config.getString("DSP_LMO8_7_Compressor_dspbypass");
    public static final String DSP_LMO8_7_Compressor_dspratio = config.getString("DSP_LMO8_7_Compressor_dspratio");
    public static final String DSP_LMO8_7_Compressor_dspreduction = config.getString("DSP_LMO8_7_Compressor_dspreduction");
    public static final String DSP_LMO8_7_Compressor_dsprelease = config.getString("DSP_LMO8_7_Compressor_dsprelease");
    public static final String DSP_LMO8_7_Compressor_region = config.getString("DSP_LMO8_7_Compressor_region");
    public static final String DSP_LMO8_7_Compressor_softknee = config.getString("DSP_LMO8_7_Compressor_softknee");
    public static final String DSP_LMO8_7_Compressor_threshold = config.getString("DSP_LMO8_7_Compressor_threshold");
    //mixer_NxM: 6
    public static final String DSP_TNO8_6_holdcount = config.getString("DSP_TNO8_6_holdcount");
    public static final String DSP_TNO8_6_input1output1send = config.getString("DSP_TNO8_6_input1output1send");
    public static final String DSP_TNO8_6_input2output1send = config.getString("DSP_TNO8_6_input2output1send");
    public static final String DSP_TNO8_6_outputclip1 = config.getString("DSP_TNO8_6_outputclip1");
    public static final String DSP_TNO8_6_ramp = config.getString("DSP_TNO8_6_ramp");
    //detector_peak_square: Peak Square Detector
    public static final String DSP_LMO8_6_PeakSquareDetector_inputdisable1 = config.getString("DSP_LMO8_6_PeakSquareDetector_inputdisable1");
    public static final String DSP_LMO8_6_PeakSquareDetector_maxpeak = config.getString("DSP_LMO8_6_PeakSquareDetector_maxpeak");
    public static final String DSP_LMO8_6_PeakSquareDetector_tc = config.getString("DSP_LMO8_6_PeakSquareDetector_tc");
    //dynamic_compressor: Compressor
    public static final String DSP_LMO8_6_Compressor_dspattack = config.getString("DSP_LMO8_6_Compressor_dspattack");
    public static final String DSP_LMO8_6_Compressor_dspbypass = config.getString("DSP_LMO8_6_Compressor_dspbypass");
    public static final String DSP_LMO8_6_Compressor_dspratio = config.getString("DSP_LMO8_6_Compressor_dspratio");
    public static final String DSP_LMO8_6_Compressor_dspreduction = config.getString("DSP_LMO8_6_Compressor_dspreduction");
    public static final String DSP_LMO8_6_Compressor_dsprelease = config.getString("DSP_LMO8_6_Compressor_dsprelease");
    public static final String DSP_LMO8_6_Compressor_region = config.getString("DSP_LMO8_6_Compressor_region");
    public static final String DSP_LMO8_6_Compressor_softknee = config.getString("DSP_LMO8_6_Compressor_softknee");
    public static final String DSP_LMO8_6_Compressor_threshold = config.getString("DSP_LMO8_6_Compressor_threshold");
    //mixer_NxM: 5
    public static final String DSP_TNO8_5_holdcount = config.getString("DSP_TNO8_5_holdcount");
    public static final String DSP_TNO8_5_input1output1send = config.getString("DSP_TNO8_5_input1output1send");
    public static final String DSP_TNO8_5_input2output1send = config.getString("DSP_TNO8_5_input2output1send");
    public static final String DSP_TNO8_5_outputclip1 = config.getString("DSP_TNO8_5_outputclip1");
    public static final String DSP_TNO8_5_ramp = config.getString("DSP_TNO8_5_ramp");
    //detector_peak_square: Peak Square Detector
    public static final String DSP_LMO8_5_PeakSquareDetector_inputdisable1 = config.getString("DSP_LMO8_5_PeakSquareDetector_inputdisable1");
    public static final String DSP_LMO8_5_PeakSquareDetector_maxpeak = config.getString("DSP_LMO8_5_PeakSquareDetector_maxpeak");
    public static final String DSP_LMO8_5_PeakSquareDetector_tc = config.getString("DSP_LMO8_5_PeakSquareDetector_tc");
    //dynamic_compressor: Compressor
    public static final String DSP_LMO8_5_Compressor_dspattack = config.getString("DSP_LMO8_5_Compressor_dspattack");
    public static final String DSP_LMO8_5_Compressor_dspbypass = config.getString("DSP_LMO8_5_Compressor_dspbypass");
    public static final String DSP_LMO8_5_Compressor_dspratio = config.getString("DSP_LMO8_5_Compressor_dspratio");
    public static final String DSP_LMO8_5_Compressor_dspreduction = config.getString("DSP_LMO8_5_Compressor_dspreduction");
    public static final String DSP_LMO8_5_Compressor_dsprelease = config.getString("DSP_LMO8_5_Compressor_dsprelease");
    public static final String DSP_LMO8_5_Compressor_region = config.getString("DSP_LMO8_5_Compressor_region");
    public static final String DSP_LMO8_5_Compressor_softknee = config.getString("DSP_LMO8_5_Compressor_softknee");
    public static final String DSP_LMO8_5_Compressor_threshold = config.getString("DSP_LMO8_5_Compressor_threshold");
    //mixer_NxM: 4
    public static final String DSP_TNO8_4_holdcount = config.getString("DSP_TNO8_4_holdcount");
    public static final String DSP_TNO8_4_input1output1send = config.getString("DSP_TNO8_4_input1output1send");
    public static final String DSP_TNO8_4_input2output1send = config.getString("DSP_TNO8_4_input2output1send");
    public static final String DSP_TNO8_4_outputclip1 = config.getString("DSP_TNO8_4_outputclip1");
    public static final String DSP_TNO8_4_ramp = config.getString("DSP_TNO8_4_ramp");
    //detector_peak_square: Peak Square Detector
    public static final String DSP_LMO8_4_PeakSquareDetector_inputdisable1 = config.getString("DSP_LMO8_4_PeakSquareDetector_inputdisable1");
    public static final String DSP_LMO8_4_PeakSquareDetector_maxpeak = config.getString("DSP_LMO8_4_PeakSquareDetector_maxpeak");
    public static final String DSP_LMO8_4_PeakSquareDetector_tc = config.getString("DSP_LMO8_4_PeakSquareDetector_tc");
    //dynamic_compressor: Compressor
    public static final String DSP_LMO8_4_Compressor_dspattack = config.getString("DSP_LMO8_4_Compressor_dspattack");
    public static final String DSP_LMO8_4_Compressor_dspbypass = config.getString("DSP_LMO8_4_Compressor_dspbypass");
    public static final String DSP_LMO8_4_Compressor_dspratio = config.getString("DSP_LMO8_4_Compressor_dspratio");
    public static final String DSP_LMO8_4_Compressor_dspreduction = config.getString("DSP_LMO8_4_Compressor_dspreduction");
    public static final String DSP_LMO8_4_Compressor_dsprelease = config.getString("DSP_LMO8_4_Compressor_dsprelease");
    public static final String DSP_LMO8_4_Compressor_region = config.getString("DSP_LMO8_4_Compressor_region");
    public static final String DSP_LMO8_4_Compressor_softknee = config.getString("DSP_LMO8_4_Compressor_softknee");
    public static final String DSP_LMO8_4_Compressor_threshold = config.getString("DSP_LMO8_4_Compressor_threshold");
    //mixer_NxM: 3
    public static final String DSP_TNO8_3_holdcount = config.getString("DSP_TNO8_3_holdcount");
    public static final String DSP_TNO8_3_input1output1send = config.getString("DSP_TNO8_3_input1output1send");
    public static final String DSP_TNO8_3_input2output1send = config.getString("DSP_TNO8_3_input2output1send");
    public static final String DSP_TNO8_3_outputclip1 = config.getString("DSP_TNO8_3_outputclip1");
    public static final String DSP_TNO8_3_ramp = config.getString("DSP_TNO8_3_ramp");
    //detector_peak_square: Peak Square Detector
    public static final String DSP_LMO8_3_PeakSquareDetector_inputdisable1 = config.getString("DSP_LMO8_3_PeakSquareDetector_inputdisable1");
    public static final String DSP_LMO8_3_PeakSquareDetector_maxpeak = config.getString("DSP_LMO8_3_PeakSquareDetector_maxpeak");
    public static final String DSP_LMO8_3_PeakSquareDetector_tc = config.getString("DSP_LMO8_3_PeakSquareDetector_tc");
    //dynamic_compressor: Compressor
    public static final String DSP_LMO8_3_Compressor_dspattack = config.getString("DSP_LMO8_3_Compressor_dspattack");
    public static final String DSP_LMO8_3_Compressor_dspbypass = config.getString("DSP_LMO8_3_Compressor_dspbypass");
    public static final String DSP_LMO8_3_Compressor_dspratio = config.getString("DSP_LMO8_3_Compressor_dspratio");
    public static final String DSP_LMO8_3_Compressor_dspreduction = config.getString("DSP_LMO8_3_Compressor_dspreduction");
    public static final String DSP_LMO8_3_Compressor_dsprelease = config.getString("DSP_LMO8_3_Compressor_dsprelease");
    public static final String DSP_LMO8_3_Compressor_region = config.getString("DSP_LMO8_3_Compressor_region");
    public static final String DSP_LMO8_3_Compressor_softknee = config.getString("DSP_LMO8_3_Compressor_softknee");
    public static final String DSP_LMO8_3_Compressor_threshold = config.getString("DSP_LMO8_3_Compressor_threshold");
    //mixer_NxM: 2
    public static final String DSP_TNO8_2_holdcount = config.getString("DSP_TNO8_2_holdcount");
    public static final String DSP_TNO8_2_input1output1send = config.getString("DSP_TNO8_2_input1output1send");
    public static final String DSP_TNO8_2_input2output1send = config.getString("DSP_TNO8_2_input2output1send");
    public static final String DSP_TNO8_2_outputclip1 = config.getString("DSP_TNO8_2_outputclip1");
    public static final String DSP_TNO8_2_ramp = config.getString("DSP_TNO8_2_ramp");
    //detector_peak_square: Peak Square Detector
    public static final String DSP_LMO8_2_PeakSquareDetector_inputdisable1 = config.getString("DSP_LMO8_2_PeakSquareDetector_inputdisable1");
    public static final String DSP_LMO8_2_PeakSquareDetector_maxpeak = config.getString("DSP_LMO8_2_PeakSquareDetector_maxpeak");
    public static final String DSP_LMO8_2_PeakSquareDetector_tc = config.getString("DSP_LMO8_2_PeakSquareDetector_tc");
    //dynamic_compressor: Compressor
    public static final String DSP_LMO8_2_Compressor_dspattack = config.getString("DSP_LMO8_2_Compressor_dspattack");
    public static final String DSP_LMO8_2_Compressor_dspbypass = config.getString("DSP_LMO8_2_Compressor_dspbypass");
    public static final String DSP_LMO8_2_Compressor_dspratio = config.getString("DSP_LMO8_2_Compressor_dspratio");
    public static final String DSP_LMO8_2_Compressor_dspreduction = config.getString("DSP_LMO8_2_Compressor_dspreduction");
    public static final String DSP_LMO8_2_Compressor_dsprelease = config.getString("DSP_LMO8_2_Compressor_dsprelease");
    public static final String DSP_LMO8_2_Compressor_region = config.getString("DSP_LMO8_2_Compressor_region");
    public static final String DSP_LMO8_2_Compressor_softknee = config.getString("DSP_LMO8_2_Compressor_softknee");
    public static final String DSP_LMO8_2_Compressor_threshold = config.getString("DSP_LMO8_2_Compressor_threshold");
    //mixer_NxM: 1
    public static final String DSP_TNO8_1_holdcount = config.getString("DSP_TNO8_1_holdcount");
    public static final String DSP_TNO8_1_input1output1send = config.getString("DSP_TNO8_1_input1output1send");
    public static final String DSP_TNO8_1_input2output1send = config.getString("DSP_TNO8_1_input2output1send");
    public static final String DSP_TNO8_1_outputclip1 = config.getString("DSP_TNO8_1_outputclip1");
    public static final String DSP_TNO8_1_ramp = config.getString("DSP_TNO8_1_ramp");
    //detector_peak_square: Peak Square Detector
    public static final String DSP_LMO8_1_PeakSquareDetector_inputdisable1 = config.getString("DSP_LMO8_1_PeakSquareDetector_inputdisable1");
    public static final String DSP_LMO8_1_PeakSquareDetector_maxpeak = config.getString("DSP_LMO8_1_PeakSquareDetector_maxpeak");
    public static final String DSP_LMO8_1_PeakSquareDetector_tc = config.getString("DSP_LMO8_1_PeakSquareDetector_tc");
    //dynamic_compressor: Compressor
    public static final String DSP_LMO8_1_Compressor_dspattack = config.getString("DSP_LMO8_1_Compressor_dspattack");
    public static final String DSP_LMO8_1_Compressor_dspbypass = config.getString("DSP_LMO8_1_Compressor_dspbypass");
    public static final String DSP_LMO8_1_Compressor_dspratio = config.getString("DSP_LMO8_1_Compressor_dspratio");
    public static final String DSP_LMO8_1_Compressor_dspreduction = config.getString("DSP_LMO8_1_Compressor_dspreduction");
    public static final String DSP_LMO8_1_Compressor_dsprelease = config.getString("DSP_LMO8_1_Compressor_dsprelease");
    public static final String DSP_LMO8_1_Compressor_region = config.getString("DSP_LMO8_1_Compressor_region");
    public static final String DSP_LMO8_1_Compressor_softknee = config.getString("DSP_LMO8_1_Compressor_softknee");
    public static final String DSP_LMO8_1_Compressor_threshold = config.getString("DSP_LMO8_1_Compressor_threshold");
    //delay: 8
    public static final String DSP_DLO8_8_delay1 = config.getString("DSP_DLO8_8_delay1");
    public static final String DSP_DLO8_8_delaygain1 = config.getString("DSP_DLO8_8_delaygain1");
    public static final String DSP_DLO8_8_holdcount = config.getString("DSP_DLO8_8_holdcount");
    public static final String DSP_DLO8_8_ramp = config.getString("DSP_DLO8_8_ramp");
    public static final String DSP_DLO8_8_tapclip1 = config.getString("DSP_DLO8_8_tapclip1");
    //delay: 7
    public static final String DSP_DLO8_7_delay1 = config.getString("DSP_DLO8_7_delay1");
    public static final String DSP_DLO8_7_delaygain1 = config.getString("DSP_DLO8_7_delaygain1");
    public static final String DSP_DLO8_7_holdcount = config.getString("DSP_DLO8_7_holdcount");
    public static final String DSP_DLO8_7_ramp = config.getString("DSP_DLO8_7_ramp");
    public static final String DSP_DLO8_7_tapclip1 = config.getString("DSP_DLO8_7_tapclip1");
    //delay: 6
    public static final String DSP_DLO8_6_delay1 = config.getString("DSP_DLO8_6_delay1");
    public static final String DSP_DLO8_6_delaygain1 = config.getString("DSP_DLO8_6_delaygain1");
    public static final String DSP_DLO8_6_holdcount = config.getString("DSP_DLO8_6_holdcount");
    public static final String DSP_DLO8_6_ramp = config.getString("DSP_DLO8_6_ramp");
    public static final String DSP_DLO8_6_tapclip1 = config.getString("DSP_DLO8_6_tapclip1");
    //delay: 5
    public static final String DSP_DLO8_5_delay1 = config.getString("DSP_DLO8_5_delay1");
    public static final String DSP_DLO8_5_delaygain1 = config.getString("DSP_DLO8_5_delaygain1");
    public static final String DSP_DLO8_5_holdcount = config.getString("DSP_DLO8_5_holdcount");
    public static final String DSP_DLO8_5_ramp = config.getString("DSP_DLO8_5_ramp");
    public static final String DSP_DLO8_5_tapclip1 = config.getString("DSP_DLO8_5_tapclip1");
    //delay: 4
    public static final String DSP_DLO8_4_delay1 = config.getString("DSP_DLO8_4_delay1");
    public static final String DSP_DLO8_4_delaygain1 = config.getString("DSP_DLO8_4_delaygain1");
    public static final String DSP_DLO8_4_holdcount = config.getString("DSP_DLO8_4_holdcount");
    public static final String DSP_DLO8_4_ramp = config.getString("DSP_DLO8_4_ramp");
    public static final String DSP_DLO8_4_tapclip1 = config.getString("DSP_DLO8_4_tapclip1");
    //delay: 3
    public static final String DSP_DLO8_3_delay1 = config.getString("DSP_DLO8_3_delay1");
    public static final String DSP_DLO8_3_delaygain1 = config.getString("DSP_DLO8_3_delaygain1");
    public static final String DSP_DLO8_3_holdcount = config.getString("DSP_DLO8_3_holdcount");
    public static final String DSP_DLO8_3_ramp = config.getString("DSP_DLO8_3_ramp");
    public static final String DSP_DLO8_3_tapclip1 = config.getString("DSP_DLO8_3_tapclip1");
    //delay: 2
    public static final String DSP_DLO8_2_delay1 = config.getString("DSP_DLO8_2_delay1");
    public static final String DSP_DLO8_2_delaygain1 = config.getString("DSP_DLO8_2_delaygain1");
    public static final String DSP_DLO8_2_holdcount = config.getString("DSP_DLO8_2_holdcount");
    public static final String DSP_DLO8_2_ramp = config.getString("DSP_DLO8_2_ramp");
    public static final String DSP_DLO8_2_tapclip1 = config.getString("DSP_DLO8_2_tapclip1");
    //delay: 1
    public static final String DSP_DLO8_1_delay1 = config.getString("DSP_DLO8_1_delay1");
    public static final String DSP_DLO8_1_delaygain1 = config.getString("DSP_DLO8_1_delaygain1");
    public static final String DSP_DLO8_1_holdcount = config.getString("DSP_DLO8_1_holdcount");
    public static final String DSP_DLO8_1_ramp = config.getString("DSP_DLO8_1_ramp");
    public static final String DSP_DLO8_1_tapclip1 = config.getString("DSP_DLO8_1_tapclip1");
    //gain_up_24dB_multi_channel: DAO Levels
    public static final String CS496122_DAOLevels_channelclip1 = config.getString("CS496122_DAOLevels_channelclip1");
    public static final String CS496122_DAOLevels_channelclip2 = config.getString("CS496122_DAOLevels_channelclip2");
    public static final String CS496122_DAOLevels_channelclip3 = config.getString("CS496122_DAOLevels_channelclip3");
    public static final String CS496122_DAOLevels_channelclip4 = config.getString("CS496122_DAOLevels_channelclip4");
    public static final String CS496122_DAOLevels_channelclip5 = config.getString("CS496122_DAOLevels_channelclip5");
    public static final String CS496122_DAOLevels_channelclip6 = config.getString("CS496122_DAOLevels_channelclip6");
    public static final String CS496122_DAOLevels_channelclip7 = config.getString("CS496122_DAOLevels_channelclip7");
    public static final String CS496122_DAOLevels_channelclip8 = config.getString("CS496122_DAOLevels_channelclip8");
    public static final String CS496122_DAOLevels_g1 = config.getString("CS496122_DAOLevels_g1");
    public static final String CS496122_DAOLevels_g2 = config.getString("CS496122_DAOLevels_g2");
    public static final String CS496122_DAOLevels_g3 = config.getString("CS496122_DAOLevels_g3");
    public static final String CS496122_DAOLevels_g4 = config.getString("CS496122_DAOLevels_g4");
    public static final String CS496122_DAOLevels_g5 = config.getString("CS496122_DAOLevels_g5");
    public static final String CS496122_DAOLevels_g6 = config.getString("CS496122_DAOLevels_g6");
    public static final String CS496122_DAOLevels_g7 = config.getString("CS496122_DAOLevels_g7");
    public static final String CS496122_DAOLevels_g8 = config.getString("CS496122_DAOLevels_g8");
    public static final String CS496122_DAOLevels_holdcount = config.getString("CS496122_DAOLevels_holdcount");
    public static final String CS496122_DAOLevels_ramp = config.getString("CS496122_DAOLevels_ramp");
    //meter_N_true_peak_and_RMS: MTO16
    public static final String DSP_MTO16_coeffpeak = config.getString("DSP_MTO16_coeffpeak");
    public static final String DSP_MTO16_coeffrms = config.getString("DSP_MTO16_coeffrms");
    public static final String DSP_MTO16_holdcount = config.getString("DSP_MTO16_holdcount");
    public static final String DSP_MTO16_infinitepeakhold = config.getString("DSP_MTO16_infinitepeakhold");
    public static final String DSP_MTO16_ms1 = config.getString("DSP_MTO16_ms1");
    public static final String DSP_MTO16_ms10 = config.getString("DSP_MTO16_ms10");
    public static final String DSP_MTO16_ms11 = config.getString("DSP_MTO16_ms11");
    public static final String DSP_MTO16_ms12 = config.getString("DSP_MTO16_ms12");
    public static final String DSP_MTO16_ms13 = config.getString("DSP_MTO16_ms13");
    public static final String DSP_MTO16_ms14 = config.getString("DSP_MTO16_ms14");
    public static final String DSP_MTO16_ms15 = config.getString("DSP_MTO16_ms15");
    public static final String DSP_MTO16_ms16 = config.getString("DSP_MTO16_ms16");
    public static final String DSP_MTO16_ms2 = config.getString("DSP_MTO16_ms2");
    public static final String DSP_MTO16_ms3 = config.getString("DSP_MTO16_ms3");
    public static final String DSP_MTO16_ms4 = config.getString("DSP_MTO16_ms4");
    public static final String DSP_MTO16_ms5 = config.getString("DSP_MTO16_ms5");
    public static final String DSP_MTO16_ms6 = config.getString("DSP_MTO16_ms6");
    public static final String DSP_MTO16_ms7 = config.getString("DSP_MTO16_ms7");
    public static final String DSP_MTO16_ms8 = config.getString("DSP_MTO16_ms8");
    public static final String DSP_MTO16_ms9 = config.getString("DSP_MTO16_ms9");
    public static final String DSP_MTO16_mshold1 = config.getString("DSP_MTO16_mshold1");
    public static final String DSP_MTO16_mshold10 = config.getString("DSP_MTO16_mshold10");
    public static final String DSP_MTO16_mshold11 = config.getString("DSP_MTO16_mshold11");
    public static final String DSP_MTO16_mshold12 = config.getString("DSP_MTO16_mshold12");
    public static final String DSP_MTO16_mshold13 = config.getString("DSP_MTO16_mshold13");
    public static final String DSP_MTO16_mshold14 = config.getString("DSP_MTO16_mshold14");
    public static final String DSP_MTO16_mshold15 = config.getString("DSP_MTO16_mshold15");
    public static final String DSP_MTO16_mshold16 = config.getString("DSP_MTO16_mshold16");
    public static final String DSP_MTO16_mshold2 = config.getString("DSP_MTO16_mshold2");
    public static final String DSP_MTO16_mshold3 = config.getString("DSP_MTO16_mshold3");
    public static final String DSP_MTO16_mshold4 = config.getString("DSP_MTO16_mshold4");
    public static final String DSP_MTO16_mshold5 = config.getString("DSP_MTO16_mshold5");
    public static final String DSP_MTO16_mshold6 = config.getString("DSP_MTO16_mshold6");
    public static final String DSP_MTO16_mshold7 = config.getString("DSP_MTO16_mshold7");
    public static final String DSP_MTO16_mshold8 = config.getString("DSP_MTO16_mshold8");
    public static final String DSP_MTO16_mshold9 = config.getString("DSP_MTO16_mshold9");
    public static final String DSP_MTO16_pk1 = config.getString("DSP_MTO16_pk1");
    public static final String DSP_MTO16_pk10 = config.getString("DSP_MTO16_pk10");
    public static final String DSP_MTO16_pk11 = config.getString("DSP_MTO16_pk11");
    public static final String DSP_MTO16_pk12 = config.getString("DSP_MTO16_pk12");
    public static final String DSP_MTO16_pk13 = config.getString("DSP_MTO16_pk13");
    public static final String DSP_MTO16_pk14 = config.getString("DSP_MTO16_pk14");
    public static final String DSP_MTO16_pk15 = config.getString("DSP_MTO16_pk15");
    public static final String DSP_MTO16_pk16 = config.getString("DSP_MTO16_pk16");
    public static final String DSP_MTO16_pk2 = config.getString("DSP_MTO16_pk2");
    public static final String DSP_MTO16_pk3 = config.getString("DSP_MTO16_pk3");
    public static final String DSP_MTO16_pk4 = config.getString("DSP_MTO16_pk4");
    public static final String DSP_MTO16_pk5 = config.getString("DSP_MTO16_pk5");
    public static final String DSP_MTO16_pk6 = config.getString("DSP_MTO16_pk6");
    public static final String DSP_MTO16_pk7 = config.getString("DSP_MTO16_pk7");
    public static final String DSP_MTO16_pk8 = config.getString("DSP_MTO16_pk8");
    public static final String DSP_MTO16_pk9 = config.getString("DSP_MTO16_pk9");
    public static final String DSP_MTO16_pkhold1 = config.getString("DSP_MTO16_pkhold1");
    public static final String DSP_MTO16_pkhold10 = config.getString("DSP_MTO16_pkhold10");
    public static final String DSP_MTO16_pkhold11 = config.getString("DSP_MTO16_pkhold11");
    public static final String DSP_MTO16_pkhold12 = config.getString("DSP_MTO16_pkhold12");
    public static final String DSP_MTO16_pkhold13 = config.getString("DSP_MTO16_pkhold13");
    public static final String DSP_MTO16_pkhold14 = config.getString("DSP_MTO16_pkhold14");
    public static final String DSP_MTO16_pkhold15 = config.getString("DSP_MTO16_pkhold15");
    public static final String DSP_MTO16_pkhold16 = config.getString("DSP_MTO16_pkhold16");
    public static final String DSP_MTO16_pkhold2 = config.getString("DSP_MTO16_pkhold2");
    public static final String DSP_MTO16_pkhold3 = config.getString("DSP_MTO16_pkhold3");
    public static final String DSP_MTO16_pkhold4 = config.getString("DSP_MTO16_pkhold4");
    public static final String DSP_MTO16_pkhold5 = config.getString("DSP_MTO16_pkhold5");
    public static final String DSP_MTO16_pkhold6 = config.getString("DSP_MTO16_pkhold6");
    public static final String DSP_MTO16_pkhold7 = config.getString("DSP_MTO16_pkhold7");
    public static final String DSP_MTO16_pkhold8 = config.getString("DSP_MTO16_pkhold8");
    public static final String DSP_MTO16_pkhold9 = config.getString("DSP_MTO16_pkhold9");
    // #endregion
    // #region "finalantes propias(para indices y demas)"
    //Rango de Bundles de tx
    public static final int MIN_txBUNDLE = 1;
    public static final int MAX_txBUNDLE = 4;
    //Bundles de Tx
    public static final int txBUNDLE_1 = 1;
    public static final int txBUNDLE_2 = 2;
    public static final int txBUNDLE_3 = 3;
    public static final int txBUNDLE_4 = 4;
    //Rango de Bundles de tx
    public static final int MIN_rxBUNDLE = 1;
    public static final int MAX_rxBUNDLE = 8;
    //Bundles de Rx
    public static final int rxBUNDLE_1 = 1;
    public static final int rxBUNDLE_2 = 2;
    public static final int rxBUNDLE_3 = 3;
    public static final int rxBUNDLE_4 = 4;
    public static final int rxBUNDLE_5 = 5;
    public static final int rxBUNDLE_6 = 6;
    public static final int rxBUNDLE_7 = 7;
    public static final int rxBUNDLE_8 = 8;
    //Rango de Subchannels de Tx y Rx
    public static final int MIN_SUB_CANAL = 1;
    public static final int MAX_SUB_CANAL = 8;
    //SubChannels que componen los Tx y los Rx
    public static final int SUB_CANAL1 = 1;
    public static final int SUB_CANAL2 = 2;
    public static final int SUB_CANAL3 = 3;
    public static final int SUB_CANAL4 = 4;
    public static final int SUB_CANAL5 = 5;
    public static final int SUB_CANAL6 = 6;
    public static final int SUB_CANAL7 = 7;
    public static final int SUB_CANAL8 = 8;
    //Valores de los Tx-subchannel 
    //Rango de bundle validos para los subMap tanto para RX como TX
    public static final int MAX_BUNDLE = 8;
    public static final int MIN_BUNDLE = 1;
    //Valores del canal del primer transmisor
    public static final int V0_TX1_SUB_CANAL = 0;
    public static final int V1_TX1_SUB_CANAL = 1;
    public static final int V2_TX1_SUB_CANAL = 2;
    public static final int V3_TX1_SUB_CANAL = 3;
    public static final int V4_TX1_SUB_CANAL = 4;
    public static final int V5_TX1_SUB_CANAL = 5;
    public static final int V6_TX1_SUB_CANAL = 6;
    public static final int V7_TX1_SUB_CANAL = 7;
    public static final int V8_TX1_SUB_CANAL = 8;
    //Valores de los Rx-subchannel 
    //Rango de los posibles valores de todos los transmisores
    public static final int MAX_VALOR_TX_SUB_CANAL = V8_TX1_SUB_CANAL;
    public static final int MIN_VALOR_TX_SUB_CANAL = V0_TX1_SUB_CANAL;
    //Valores del canal del primer receptor
    public static final int V0_RX1_SUB_CANAL = 0;
    public static final int V1_RX1_SUB_CANAL = 33;
    public static final int V2_RX1_SUB_CANAL = 34;
    public static final int V3_RX1_SUB_CANAL = 35;
    public static final int V4_RX1_SUB_CANAL = 36;
    public static final int V5_RX1_SUB_CANAL = 37;
    public static final int V6_RX1_SUB_CANAL = 38;
    public static final int V7_RX1_SUB_CANAL = 39;
    public static final int V8_RX1_SUB_CANAL = 40;
    //Rango de los posibles valores de todos los receptores
    public static final int MAX_VALOR_RX_SUB_CANAL = V8_RX1_SUB_CANAL;
    public static final int MIN_VALOR_RX_SUB_CANAL = V0_RX1_SUB_CANAL;
    // #endregion

    // #region "Funciones de Seleccion de OID"
    //Devuelve el oid del rxBundle solicitado
    public static String OID_txBundle(int X) {
        String functionReturnValue = null;
        switch (X) {
            case txBUNDLE_1:
                functionReturnValue = txBundle1;
                break;
            case txBUNDLE_2:
                functionReturnValue = txBundle2;
                break;
            case txBUNDLE_3:
                functionReturnValue = txBundle3;
                break;
            case txBUNDLE_4:
                functionReturnValue = txBundle4;
                break;
            default:
                functionReturnValue = "";
                break;
        }
        return functionReturnValue;
    }

    //Devuelve el oid del txBundle solicitado 
    public static String OID_rxBundle(int x) {
        String functionReturnValue = null;
        switch (x) {
            case rxBUNDLE_1:
                functionReturnValue = rxBundle1;
                break;
            case rxBUNDLE_2:
                functionReturnValue = rxBundle2;
                break;
            case rxBUNDLE_3:
                functionReturnValue = rxBundle3;
                break;
            case rxBUNDLE_4:
                functionReturnValue = rxBundle4;
                break;
            case rxBUNDLE_5:
                functionReturnValue = rxBundle5;
                break;
            case rxBUNDLE_6:
                functionReturnValue = rxBundle6;
                break;
            case rxBUNDLE_7:
                functionReturnValue = rxBundle7;
                break;
            case rxBUNDLE_8:
                functionReturnValue = rxBundle8;
                break;
            default:
                functionReturnValue = "";
                break;
        }
        return functionReturnValue;
    }

    //Devuelve el oid del rxSubMap solicitado
    public static String OID_txSubMap(int Tx, int subCanalBundle) {
        String functionReturnValue = null;
        switch (Tx) {
            case txBUNDLE_1:
                switch (subCanalBundle) {
                    case SUB_CANAL1:
                        functionReturnValue = txSubMap1B1;
                        break;
                    case SUB_CANAL2:
                        functionReturnValue = txSubMap2B1;
                        break;
                    case SUB_CANAL3:
                        functionReturnValue = txSubMap3B1;
                        break;
                    case SUB_CANAL4:
                        functionReturnValue = txSubMap4B1;
                        break;
                    case SUB_CANAL5:
                        functionReturnValue = txSubMap5B1;
                        break;
                    case SUB_CANAL6:
                        functionReturnValue = txSubMap6B1;
                        break;
                    case SUB_CANAL7:
                        functionReturnValue = txSubMap7B1;
                        break;
                    case SUB_CANAL8:
                        functionReturnValue = txSubMap8B1;
                        break;
                    default:
                        functionReturnValue = "";
                        break;
                }
                break;
            case txBUNDLE_2:
                switch (subCanalBundle) {
                    case SUB_CANAL1:
                        functionReturnValue = txSubMap1B2;
                        break;
                    case SUB_CANAL2:
                        functionReturnValue = txSubMap2B2;
                        break;
                    case SUB_CANAL3:
                        functionReturnValue = txSubMap3B2;
                        break;
                    case SUB_CANAL4:
                        functionReturnValue = txSubMap4B2;
                        break;
                    case SUB_CANAL5:
                        functionReturnValue = txSubMap5B2;
                        break;
                    case SUB_CANAL6:
                        functionReturnValue = txSubMap6B2;
                        break;
                    case SUB_CANAL7:
                        functionReturnValue = txSubMap7B2;
                        break;
                    case SUB_CANAL8:
                        functionReturnValue = txSubMap8B2;
                        break;
                    default:
                        functionReturnValue = "";
                        break;
                }
                break;
            case txBUNDLE_3:
                switch (subCanalBundle) {
                    case SUB_CANAL1:
                        functionReturnValue = txSubMap1B3;
                        break;
                    case SUB_CANAL2:
                        functionReturnValue = txSubMap2B3;
                        break;
                    case SUB_CANAL3:
                        functionReturnValue = txSubMap3B3;
                        break;
                    case SUB_CANAL4:
                        functionReturnValue = txSubMap4B3;
                        break;
                    case SUB_CANAL5:
                        functionReturnValue = txSubMap5B3;
                        break;
                    case SUB_CANAL6:
                        functionReturnValue = txSubMap6B3;
                        break;
                    case SUB_CANAL7:
                        functionReturnValue = txSubMap7B3;
                        break;
                    case SUB_CANAL8:
                        functionReturnValue = txSubMap8B3;
                        break;
                    default:
                        functionReturnValue = "";
                        break;
                }
                break;
            case txBUNDLE_4:
                switch (subCanalBundle) {
                    case SUB_CANAL1:
                        functionReturnValue = txSubMap1B4;
                        break;
                    case SUB_CANAL2:
                        functionReturnValue = txSubMap2B4;
                        break;
                    case SUB_CANAL3:
                        functionReturnValue = txSubMap3B4;
                        break;
                    case SUB_CANAL4:
                        functionReturnValue = txSubMap4B4;
                        break;
                    case SUB_CANAL5:
                        functionReturnValue = txSubMap5B4;
                        break;
                    case SUB_CANAL6:
                        functionReturnValue = txSubMap6B4;
                        break;
                    case SUB_CANAL7:
                        functionReturnValue = txSubMap7B4;
                        break;
                    case SUB_CANAL8:
                        functionReturnValue = txSubMap8B4;
                        break;
                    default:
                        functionReturnValue = "";
                        break;
                }
                break;
            default:
                functionReturnValue = "";
                break;
        }
        return functionReturnValue;
    }

    //Devuelve el oid del rxsubMap del Tx 1
    public static String OID_txSubMap_Tx1(int subCanal) {
        return OID_txSubMap(txBUNDLE_1, subCanal);
    }

    //Devuelve el oid del rxsubMap del Tx 1
    public static String OID_txSubMap_Tx2(int subCanal) {
        return OID_txSubMap(txBUNDLE_2, subCanal);
    }

    //Devuelve el oid del rxsubMap del Tx 1
    public static String OID_txSubMap_Tx3(int subCanal) {
        return OID_txSubMap(txBUNDLE_3, subCanal);
    }

    //Devuelve el oid del rxsubMap del Tx 1
    public static String OID_txSubMap_Tx4(int subCanal) {
        return OID_txSubMap(txBUNDLE_4, subCanal);
    }

    //Devuelve el oid del rxSubMap solicitado 
    public static String OID_rxSubMap(int Rx, int subCanalBundle) {
        String functionReturnValue = null;
        switch (Rx) {
            case rxBUNDLE_1:
                switch (subCanalBundle) {
                    case SUB_CANAL1:
                        functionReturnValue = rxSubMap1B1;
                        break;
                    case SUB_CANAL2:
                        functionReturnValue = rxSubMap2B1;
                        break;
                    case SUB_CANAL3:
                        functionReturnValue = rxSubMap3B1;
                        break;
                    case SUB_CANAL4:
                        functionReturnValue = rxSubMap4B1;
                        break;
                    case SUB_CANAL5:
                        functionReturnValue = rxSubMap5B1;
                        break;
                    case SUB_CANAL6:
                        functionReturnValue = rxSubMap6B1;
                        break;
                    case SUB_CANAL7:
                        functionReturnValue = rxSubMap7B1;
                        break;
                    case SUB_CANAL8:
                        functionReturnValue = rxSubMap8B1;
                        break;
                    default:
                        functionReturnValue = "";
                        break;
                }
                break;
            case rxBUNDLE_2:
                switch (subCanalBundle) {
                    case SUB_CANAL1:
                        functionReturnValue = rxSubMap1B2;
                        break;
                    case SUB_CANAL2:
                        functionReturnValue = rxSubMap2B2;
                        break;
                    case SUB_CANAL3:
                        functionReturnValue = rxSubMap3B2;
                        break;
                    case SUB_CANAL4:
                        functionReturnValue = rxSubMap4B2;
                        break;
                    case SUB_CANAL5:
                        functionReturnValue = rxSubMap5B2;
                        break;
                    case SUB_CANAL6:
                        functionReturnValue = rxSubMap6B2;
                        break;
                    case SUB_CANAL7:
                        functionReturnValue = rxSubMap7B2;
                        break;
                    case SUB_CANAL8:
                        functionReturnValue = rxSubMap8B2;
                        break;
                    default:
                        functionReturnValue = "";
                        break;
                }
                break;
            case rxBUNDLE_3:
                switch (subCanalBundle) {
                    case SUB_CANAL1:
                        functionReturnValue = rxSubMap1B3;
                        break;
                    case SUB_CANAL2:
                        functionReturnValue = rxSubMap2B3;
                        break;
                    case SUB_CANAL3:
                        functionReturnValue = rxSubMap3B3;
                        break;
                    case SUB_CANAL4:
                        functionReturnValue = rxSubMap4B3;
                        break;
                    case SUB_CANAL5:
                        functionReturnValue = rxSubMap5B3;
                        break;
                    case SUB_CANAL6:
                        functionReturnValue = rxSubMap6B3;
                        break;
                    case SUB_CANAL7:
                        functionReturnValue = rxSubMap7B3;
                        break;
                    case SUB_CANAL8:
                        functionReturnValue = rxSubMap8B3;
                        break;
                    default:
                        functionReturnValue = "";
                        break;
                }
                break;
            case rxBUNDLE_4:
                switch (subCanalBundle) {
                    case SUB_CANAL1:
                        functionReturnValue = rxSubMap1B4;
                        break;
                    case SUB_CANAL2:
                        functionReturnValue = rxSubMap2B4;
                        break;
                    case SUB_CANAL3:
                        functionReturnValue = rxSubMap3B4;
                        break;
                    case SUB_CANAL4:
                        functionReturnValue = rxSubMap4B4;
                        break;
                    case SUB_CANAL5:
                        functionReturnValue = rxSubMap5B4;
                        break;
                    case SUB_CANAL6:
                        functionReturnValue = rxSubMap6B4;
                        break;
                    case SUB_CANAL7:
                        functionReturnValue = rxSubMap7B4;
                        break;
                    case SUB_CANAL8:
                        functionReturnValue = rxSubMap8B4;
                        break;
                    default:
                        functionReturnValue = "";
                        break;
                }
                break;
            case rxBUNDLE_5:
                switch (subCanalBundle) {
                    case SUB_CANAL1:
                        functionReturnValue = rxSubMap1B5;
                        break;
                    case SUB_CANAL2:
                        functionReturnValue = rxSubMap2B5;
                        break;
                    case SUB_CANAL3:
                        functionReturnValue = rxSubMap3B5;
                        break;
                    case SUB_CANAL4:
                        functionReturnValue = rxSubMap4B5;
                        break;
                    case SUB_CANAL5:
                        functionReturnValue = rxSubMap5B5;
                        break;
                    case SUB_CANAL6:
                        functionReturnValue = rxSubMap6B5;
                        break;
                    case SUB_CANAL7:
                        functionReturnValue = rxSubMap7B5;
                        break;
                    case SUB_CANAL8:
                        functionReturnValue = rxSubMap8B5;
                        break;
                    default:
                        functionReturnValue = "";
                        break;
                }
                break;
            case rxBUNDLE_6:
                switch (subCanalBundle) {
                    case SUB_CANAL1:
                        functionReturnValue = rxSubMap1B6;
                        break;
                    case SUB_CANAL2:
                        functionReturnValue = rxSubMap2B6;
                        break;
                    case SUB_CANAL3:
                        functionReturnValue = rxSubMap3B6;
                        break;
                    case SUB_CANAL4:
                        functionReturnValue = rxSubMap4B6;
                        break;
                    case SUB_CANAL5:
                        functionReturnValue = rxSubMap5B6;
                        break;
                    case SUB_CANAL6:
                        functionReturnValue = rxSubMap6B6;
                        break;
                    case SUB_CANAL7:
                        functionReturnValue = rxSubMap7B6;
                        break;
                    case SUB_CANAL8:
                        functionReturnValue = rxSubMap8B6;
                        break;
                    default:
                        functionReturnValue = "";
                        break;
                }
                break;
            case rxBUNDLE_7:
                switch (subCanalBundle) {
                    case SUB_CANAL1:
                        functionReturnValue = rxSubMap1B7;
                        break;
                    case SUB_CANAL2:
                        functionReturnValue = rxSubMap2B7;
                        break;
                    case SUB_CANAL3:
                        functionReturnValue = rxSubMap3B7;
                        break;
                    case SUB_CANAL4:
                        functionReturnValue = rxSubMap4B7;
                        break;
                    case SUB_CANAL5:
                        functionReturnValue = rxSubMap5B7;
                        break;
                    case SUB_CANAL6:
                        functionReturnValue = rxSubMap6B7;
                        break;
                    case SUB_CANAL7:
                        functionReturnValue = rxSubMap7B7;
                        break;
                    case SUB_CANAL8:
                        functionReturnValue = rxSubMap8B7;
                        break;
                    default:
                        functionReturnValue = "";
                        break;
                }
                break;
            case rxBUNDLE_8:
                switch (subCanalBundle) {
                    case SUB_CANAL1:
                        functionReturnValue = rxSubMap1B8;
                        break;
                    case SUB_CANAL2:
                        functionReturnValue = rxSubMap2B8;
                        break;
                    case SUB_CANAL3:
                        functionReturnValue = rxSubMap3B8;
                        break;
                    case SUB_CANAL4:
                        functionReturnValue = rxSubMap4B8;
                        break;
                    case SUB_CANAL5:
                        functionReturnValue = rxSubMap5B8;
                        break;
                    case SUB_CANAL6:
                        functionReturnValue = rxSubMap6B8;
                        break;
                    case SUB_CANAL7:
                        functionReturnValue = rxSubMap7B8;
                        break;
                    case SUB_CANAL8:
                        functionReturnValue = rxSubMap8B8;
                        break;
                    default:
                        functionReturnValue = "";
                        break;
                }
                break;
            default:
                functionReturnValue = "";
                break;
        }
        return functionReturnValue;
    }

    //Devuelve el oid del rxsubMap del Rx 1
    public static String OID_rxSubMap_Rx1(int subcanal) {
        return OID_rxSubMap(rxBUNDLE_1, subcanal);
    }

    //Devuelve el oid del rxsubMap del Rx 2
    public static String OID_rxSubMap_Rx2(int subcanal) {
        return OID_rxSubMap(rxBUNDLE_2, subcanal);
    }

    //Devuelve el oid del rxsubMap del Rx 3
    public static String OID_rxSubMap_Rx3(int subcanal) {
        return OID_rxSubMap(rxBUNDLE_3, subcanal);
    }

    //Devuelve el oid del rxsubMap del Rx 4
    public static String OID_rxSubMap_Rx4(int subcanal) {
        return OID_rxSubMap(rxBUNDLE_4, subcanal);
    }

    //Devuelve el oid del rxsubMap del Rx 5
    public static String OID_rxSubMap_Rx5(int subcanal) {
        return OID_rxSubMap(rxBUNDLE_5, subcanal);
    }

    //Devuelve el oid del rxsubMap del Rx 6
    public static String OID_rxSubMap_Rx6(int subcanal) {
        return OID_rxSubMap(rxBUNDLE_6, subcanal);
    }

    //Devuelve el oid del rxsubMap del Rx 7
    public static String OID_rxSubMap_Rx7(int subcanal) {
        return OID_rxSubMap(rxBUNDLE_7, subcanal);
    }

    //Devuelve el oid del rxsubMap del Rx 8
    public static String OID_rxSubMap_Rx8(int subcanal) {
        return OID_rxSubMap(rxBUNDLE_8, subcanal);
    }

    public static String OID_Tono_Gain(int X, int Y) {
        String functionReturnValue = null;
        switch (X) {
            case 1:
                switch (Y) {
                    case 1:
                        functionReturnValue = DSP_TNO8_1_input1output1send;
                        break;
                    case 2:
                        functionReturnValue = DSP_TNO8_1_input2output1send;
                        break;
                    default:
                        functionReturnValue = "";
                        break;
                }

                break;
            case 2:
                switch (Y) {
                    case 1:
                        functionReturnValue = DSP_TNO8_2_input1output1send;
                        break;
                    case 2:
                        functionReturnValue = DSP_TNO8_2_input2output1send;
                        break;
                    default:
                        functionReturnValue = "";
                        break;
                }
                break;
            case 3:
                switch (Y) {
                    case 1:
                        functionReturnValue = DSP_TNO8_3_input1output1send;
                        break;
                    case 2:
                        functionReturnValue = DSP_TNO8_3_input2output1send;
                        break;
                    default:
                        functionReturnValue = "";
                        break;
                }
                break;
            case 4:
                switch (Y) {
                    case 1:
                        functionReturnValue = DSP_TNO8_4_input1output1send;
                        break;
                    case 2:
                        functionReturnValue = DSP_TNO8_4_input2output1send;
                        break;
                    default:
                        functionReturnValue = "";
                        break;
                }
                break;
            case 5:
                switch (Y) {
                    case 1:
                        functionReturnValue = DSP_TNO8_5_input1output1send;
                        break;
                    case 2:
                        functionReturnValue = DSP_TNO8_5_input2output1send;
                        break;
                    default:
                        functionReturnValue = "";
                        break;
                }

                break;
            case 6:
                switch (Y) {
                    case 1:
                        functionReturnValue = DSP_TNO8_6_input1output1send;
                        break;
                    case 2:
                        functionReturnValue = DSP_TNO8_6_input2output1send;
                        break;
                    default:
                        functionReturnValue = "";
                        break;
                }
                break;
            case 7:
                switch (Y) {
                    case 1:
                        functionReturnValue = DSP_TNO8_7_input1output1send;
                        break;
                    case 2:
                        functionReturnValue = DSP_TNO8_7_input2output1send;
                        break;
                    default:
                        functionReturnValue = "";
                        break;
                }
                break;
            case 8:
                switch (Y) {
                    case 1:
                        functionReturnValue = DSP_TNO8_8_input1output1send;
                        break;
                    case 2:
                        functionReturnValue = DSP_TNO8_8_input2output1send;
                        break;
                    default:
                        functionReturnValue = "";
                        break;
                }
                break;
            default:
                functionReturnValue = "";
                break;
        }
        return functionReturnValue;

    }

    public static String OID_Compressor_Bypass(int X) {

        String Resultado = null;

        switch (X) {
            case 1:
                Resultado = DSP_CSI8_1_Compressor_dspbypass;
                break;
            case 2:
                Resultado = DSP_CSI8_2_Compressor_dspbypass;
                break;
            case 3:
                Resultado = DSP_CSI8_3_Compressor_dspbypass;
                break;
            case 4:
                Resultado = DSP_CSI8_4_Compressor_dspbypass;
                break;
            case 5:
                Resultado = DSP_CSI8_5_Compressor_dspbypass;
                break;
            case 6:
                Resultado = DSP_CSI8_6_Compressor_dspbypass;
                break;
            case 7:
                Resultado = DSP_CSI8_7_Compressor_dspbypass;
                break;
            case 8:
                Resultado = DSP_CSI8_8_Compressor_dspbypass;
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_Compressor_Ratio(int X) {

        String Resultado = null;

        switch (X) {
            case 1:
                Resultado = DSP_CSI8_1_Compressor_dspratio;
                break;
            case 2:
                Resultado = DSP_CSI8_2_Compressor_dspratio;
                break;
            case 3:
                Resultado = DSP_CSI8_3_Compressor_dspratio;
                break;
            case 4:
                Resultado = DSP_CSI8_4_Compressor_dspratio;
                break;
            case 5:
                Resultado = DSP_CSI8_5_Compressor_dspratio;
                break;
            case 6:
                Resultado = DSP_CSI8_6_Compressor_dspratio;
                break;
            case 7:
                Resultado = DSP_CSI8_7_Compressor_dspratio;
                break;
            case 8:
                Resultado = DSP_CSI8_8_Compressor_dspratio;
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_Compressor_Attack(int X) {

        String Resultado = null;

        switch (X) {
            case 1:
                Resultado = DSP_CSI8_1_Compressor_dspattack;
                break;
            case 2:
                Resultado = DSP_CSI8_2_Compressor_dspattack;
                break;
            case 3:
                Resultado = DSP_CSI8_3_Compressor_dspattack;
                break;
            case 4:
                Resultado = DSP_CSI8_4_Compressor_dspattack;
                break;
            case 5:
                Resultado = DSP_CSI8_5_Compressor_dspattack;
                break;
            case 6:
                Resultado = DSP_CSI8_6_Compressor_dspattack;
                break;
            case 7:
                Resultado = DSP_CSI8_7_Compressor_dspattack;
                break;
            case 8:
                Resultado = DSP_CSI8_8_Compressor_dspattack;
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_Compressor_Release(int X) {

        String Resultado = null;

        switch (X) {
            case 1:
                Resultado = DSP_CSI8_1_Compressor_dsprelease;
                break;
            case 2:
                Resultado = DSP_CSI8_2_Compressor_dsprelease;
                break;
            case 3:
                Resultado = DSP_CSI8_3_Compressor_dsprelease;
                break;
            case 4:
                Resultado = DSP_CSI8_4_Compressor_dsprelease;
                break;
            case 5:
                Resultado = DSP_CSI8_5_Compressor_dsprelease;
                break;
            case 6:
                Resultado = DSP_CSI8_6_Compressor_dsprelease;
                break;
            case 7:
                Resultado = DSP_CSI8_7_Compressor_dsprelease;
                break;
            case 8:
                Resultado = DSP_CSI8_8_Compressor_dsprelease;
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_Compressor_SoftKnee(int X) {

        String Resultado = null;

        switch (X) {
            case 1:
                Resultado = DSP_CSI8_1_Compressor_softknee;
                break;
            case 2:
                Resultado = DSP_CSI8_2_Compressor_softknee;
                break;
            case 3:
                Resultado = DSP_CSI8_3_Compressor_softknee;
                break;
            case 4:
                Resultado = DSP_CSI8_4_Compressor_softknee;
                break;
            case 5:
                Resultado = DSP_CSI8_5_Compressor_softknee;
                break;
            case 6:
                Resultado = DSP_CSI8_6_Compressor_softknee;
                break;
            case 7:
                Resultado = DSP_CSI8_7_Compressor_softknee;
                break;
            case 8:
                Resultado = DSP_CSI8_8_Compressor_softknee;
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_Compressor_ThresHold(int X) {

        String Resultado = null;

        switch (X) {
            case 1:
                Resultado = DSP_CSI8_1_Compressor_threshold;
                break;
            case 2:
                Resultado = DSP_CSI8_2_Compressor_threshold;
                break;
            case 3:
                Resultado = DSP_CSI8_3_Compressor_threshold;
                break;
            case 4:
                Resultado = DSP_CSI8_4_Compressor_threshold;
                break;
            case 5:
                Resultado = DSP_CSI8_5_Compressor_threshold;
                break;
            case 6:
                Resultado = DSP_CSI8_6_Compressor_threshold;
                break;
            case 7:
                Resultado = DSP_CSI8_7_Compressor_threshold;
                break;
            case 8:
                Resultado = DSP_CSI8_8_Compressor_threshold;
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_Compressor_Reduction(int X) {

        String Resultado = null;

        switch (X) {
            case 1:
                Resultado = DSP_CSI8_1_Compressor_dspreduction;
                break;
            case 2:
                Resultado = DSP_CSI8_2_Compressor_dspreduction;
                break;
            case 3:
                Resultado = DSP_CSI8_3_Compressor_dspreduction;
                break;
            case 4:
                Resultado = DSP_CSI8_4_Compressor_dspreduction;
                break;
            case 5:
                Resultado = DSP_CSI8_5_Compressor_dspreduction;
                break;
            case 6:
                Resultado = DSP_CSI8_6_Compressor_dspreduction;
                break;
            case 7:
                Resultado = DSP_CSI8_7_Compressor_dspreduction;
                break;
            case 8:
                Resultado = DSP_CSI8_8_Compressor_dspreduction;
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_Compressor_Region(int X) {

        String Resultado = null;

        switch (X) {
            case 1:
                Resultado = DSP_CSI8_1_Compressor_region;
                break;
            case 2:
                Resultado = DSP_CSI8_2_Compressor_region;
                break;
            case 3:
                Resultado = DSP_CSI8_3_Compressor_region;
                break;
            case 4:
                Resultado = DSP_CSI8_4_Compressor_region;
                break;
            case 5:
                Resultado = DSP_CSI8_5_Compressor_region;
                break;
            case 6:
                Resultado = DSP_CSI8_6_Compressor_region;
                break;
            case 7:
                Resultado = DSP_CSI8_7_Compressor_region;
                break;
            case 8:
                Resultado = DSP_CSI8_8_Compressor_region;
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_Limiter_Ratio(int X) {

        String Resultado = null;

        switch (X) {
            case 1:
                Resultado = DSP_LMO8_1_Compressor_dspratio;
                break;
            case 2:
                Resultado = DSP_LMO8_2_Compressor_dspratio;
                break;
            case 3:
                Resultado = DSP_LMO8_3_Compressor_dspratio;
                break;
            case 4:
                Resultado = DSP_LMO8_4_Compressor_dspratio;
                break;
            case 5:
                Resultado = DSP_LMO8_5_Compressor_dspratio;
                break;
            case 6:
                Resultado = DSP_LMO8_6_Compressor_dspratio;
                break;
            case 7:
                Resultado = DSP_LMO8_7_Compressor_dspratio;
                break;
            case 8:
                Resultado = DSP_LMO8_8_Compressor_dspratio;
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_Limiter_Attack(int X) {

        String Resultado = null;

        switch (X) {
            case 1:
                Resultado = DSP_LMO8_1_Compressor_dspattack;
                break;
            case 2:
                Resultado = DSP_LMO8_2_Compressor_dspattack;
                break;
            case 3:
                Resultado = DSP_LMO8_3_Compressor_dspattack;
                break;
            case 4:
                Resultado = DSP_LMO8_4_Compressor_dspattack;
                break;
            case 5:
                Resultado = DSP_LMO8_5_Compressor_dspattack;
                break;
            case 6:
                Resultado = DSP_LMO8_6_Compressor_dspattack;
                break;
            case 7:
                Resultado = DSP_LMO8_7_Compressor_dspattack;
                break;
            case 8:
                Resultado = DSP_LMO8_8_Compressor_dspattack;
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_Limiter_Release(int X) {

        String Resultado = null;

        switch (X) {
            case 1:
                Resultado = DSP_LMO8_1_Compressor_dsprelease;
                break;
            case 2:
                Resultado = DSP_LMO8_2_Compressor_dsprelease;
                break;
            case 3:
                Resultado = DSP_LMO8_3_Compressor_dsprelease;
                break;
            case 4:
                Resultado = DSP_LMO8_4_Compressor_dsprelease;
                break;
            case 5:
                Resultado = DSP_LMO8_5_Compressor_dsprelease;
                break;
            case 6:
                Resultado = DSP_LMO8_6_Compressor_dsprelease;
                break;
            case 7:
                Resultado = DSP_LMO8_7_Compressor_dsprelease;
                break;
            case 8:
                Resultado = DSP_LMO8_8_Compressor_dsprelease;
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_Limiter_SoftKnee(int X) {

        String Resultado = null;

        switch (X) {
            case 1:
                Resultado = DSP_LMO8_1_Compressor_softknee;
                break;
            case 2:
                Resultado = DSP_LMO8_2_Compressor_softknee;
                break;
            case 3:
                Resultado = DSP_LMO8_3_Compressor_softknee;
                break;
            case 4:
                Resultado = DSP_LMO8_4_Compressor_softknee;
                break;
            case 5:
                Resultado = DSP_LMO8_5_Compressor_softknee;
                break;
            case 6:
                Resultado = DSP_LMO8_6_Compressor_softknee;
                break;
            case 7:
                Resultado = DSP_LMO8_7_Compressor_softknee;
                break;
            case 8:
                Resultado = DSP_LMO8_8_Compressor_softknee;
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_Limiter_ThresHold(int X) {

        String Resultado = null;

        switch (X) {
            case 1:
                Resultado = DSP_LMO8_1_Compressor_threshold;
                break;
            case 2:
                Resultado = DSP_LMO8_2_Compressor_threshold;
                break;
            case 3:
                Resultado = DSP_LMO8_3_Compressor_threshold;
                break;
            case 4:
                Resultado = DSP_LMO8_4_Compressor_threshold;
                break;
            case 5:
                Resultado = DSP_LMO8_5_Compressor_threshold;
                break;
            case 6:
                Resultado = DSP_LMO8_6_Compressor_threshold;
                break;
            case 7:
                Resultado = DSP_LMO8_7_Compressor_threshold;
                break;
            case 8:
                Resultado = DSP_LMO8_8_Compressor_threshold;
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_Limiter_Reduction(int X) {

        String Resultado = null;

        switch (X) {
            case 1:
                Resultado = DSP_LMO8_1_Compressor_dspreduction;
                break;
            case 2:
                Resultado = DSP_LMO8_2_Compressor_dspreduction;
                break;
            case 3:
                Resultado = DSP_LMO8_3_Compressor_dspreduction;
                break;
            case 4:
                Resultado = DSP_LMO8_4_Compressor_dspreduction;
                break;
            case 5:
                Resultado = DSP_LMO8_5_Compressor_dspreduction;
                break;
            case 6:
                Resultado = DSP_LMO8_6_Compressor_dspreduction;
                break;
            case 7:
                Resultado = DSP_LMO8_7_Compressor_dspreduction;
                break;
            case 8:
                Resultado = DSP_LMO8_8_Compressor_dspreduction;
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_Limiter_Region(int X) {

        String Resultado = null;

        switch (X) {
            case 1:
                Resultado = DSP_LMO8_1_Compressor_region;
                break;
            case 2:
                Resultado = DSP_LMO8_2_Compressor_region;
                break;
            case 3:
                Resultado = DSP_LMO8_3_Compressor_region;
                break;
            case 4:
                Resultado = DSP_LMO8_4_Compressor_region;
                break;
            case 5:
                Resultado = DSP_LMO8_5_Compressor_region;
                break;
            case 6:
                Resultado = DSP_LMO8_6_Compressor_region;
                break;
            case 7:
                Resultado = DSP_LMO8_7_Compressor_region;
                break;
            case 8:
                Resultado = DSP_LMO8_8_Compressor_region;
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_Limiter_Bypass(int X) {

        String Resultado = null;

        switch (X) {
            case 1:
                Resultado = DSP_LMO8_1_Compressor_dspbypass;
                break;
            case 2:
                Resultado = DSP_LMO8_2_Compressor_dspbypass;
                break;
            case 3:
                Resultado = DSP_LMO8_3_Compressor_dspbypass;
                break;
            case 4:
                Resultado = DSP_LMO8_4_Compressor_dspbypass;
                break;
            case 5:
                Resultado = DSP_LMO8_5_Compressor_dspbypass;
                break;
            case 6:
                Resultado = DSP_LMO8_6_Compressor_dspbypass;
                break;
            case 7:
                Resultado = DSP_LMO8_7_Compressor_dspbypass;
                break;
            case 8:
                Resultado = DSP_LMO8_8_Compressor_dspbypass;
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_Router(int X) {

        String Resultado = null;

        switch (X) {
            case 1:
                Resultado = DSP_RTI22O16_outputselect1;
                break;
            case 2:
                Resultado = DSP_RTI22O16_outputselect2;
                break;
            case 3:
                Resultado = DSP_RTI22O16_outputselect3;
                break;
            case 4:
                Resultado = DSP_RTI22O16_outputselect4;
                break;
            case 5:
                Resultado = DSP_RTI22O16_outputselect5;
                break;
            case 6:
                Resultado = DSP_RTI22O16_outputselect6;
                break;
            case 7:
                Resultado = DSP_RTI22O16_outputselect7;
                break;
            case 8:
                Resultado = DSP_RTI22O16_outputselect8;
                break;
            case 9:
                Resultado = DSP_RTI22O16_outputselect9;
                break;
            case 10:
                Resultado = DSP_RTI22O16_outputselect10;
                break;
            case 11:
                Resultado = DSP_RTI22O16_outputselect11;
                break;
            case 12:
                Resultado = DSP_RTI22O16_outputselect12;
                break;
            case 13:
                Resultado = DSP_RTI22O16_outputselect13;
                break;
            case 14:
                Resultado = DSP_RTI22O16_outputselect14;
                break;
            case 15:
                Resultado = DSP_RTI22O16_outputselect15;
                break;
            case 16:
                Resultado = DSP_RTI22O16_outputselect16;
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_GananciaE(int X) {

        String Resultado = null;

        switch (X) {
            case 1:
                Resultado = DSP_GNI8_g1;
                break;
            case 2:
                Resultado = DSP_GNI8_g2;
                break;
            case 3:
                Resultado = DSP_GNI8_g3;
                break;
            case 4:
                Resultado = DSP_GNI8_g4;
                break;
            case 5:
                Resultado = DSP_GNI8_g5;
                break;
            case 6:
                Resultado = DSP_GNI8_g6;
                break;
            case 7:
                Resultado = DSP_GNI8_g7;
                break;
            case 8:
                Resultado = DSP_GNI8_g8;
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_GananciaS(int X) {

        String Resultado = null;

        switch (X) {
            case 1:
                Resultado = DSP_GNO8_g1;
                break;
            case 2:
                Resultado = DSP_GNO8_g2;
                break;
            case 3:
                Resultado = DSP_GNO8_g3;
                break;
            case 4:
                Resultado = DSP_GNO8_g4;
                break;
            case 5:
                Resultado = DSP_GNO8_g5;
                break;
            case 6:
                Resultado = DSP_GNO8_g6;
                break;
            case 7:
                Resultado = DSP_GNO8_g7;
                break;
            case 8:
                Resultado = DSP_GNO8_g8;
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_ClipE(int X) {

        String Resultado = null;

        switch (X) {
            case 1:
                Resultado = DSP_GNI8_channelclip1;
                break;
            case 2:
                Resultado = DSP_GNI8_channelclip2;
                break;
            case 3:
                Resultado = DSP_GNI8_channelclip3;
                break;
            case 4:
                Resultado = DSP_GNI8_channelclip4;
                break;
            case 5:
                Resultado = DSP_GNI8_channelclip5;
                break;
            case 6:
                Resultado = DSP_GNI8_channelclip6;
                break;
            case 7:
                Resultado = DSP_GNI8_channelclip7;
                break;
            case 8:
                Resultado = DSP_GNI8_channelclip8;
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_ClipS(int X) {

        String Resultado = null;

        switch (X) {
            case 1:
                Resultado = DSP_GNO8_channelclip1;
                break;
            case 2:
                Resultado = DSP_GNO8_channelclip2;
                break;
            case 3:
                Resultado = DSP_GNO8_channelclip3;
                break;
            case 4:
                Resultado = DSP_GNO8_channelclip4;
                break;
            case 5:
                Resultado = DSP_GNO8_channelclip5;
                break;
            case 6:
                Resultado = DSP_GNO8_channelclip6;
                break;
            case 7:
                Resultado = DSP_GNO8_channelclip7;
                break;
            case 8:
                Resultado = DSP_GNO8_channelclip8;
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_VolumenE(int X) {

        String Resultado = null;

        switch (X) {
            case 1:
                Resultado = DSP_MTI16_pk1;
                break;
            case 2:
                Resultado = DSP_MTI16_pk2;
                break;
            case 3:
                Resultado = DSP_MTI16_pk3;
                break;
            case 4:
                Resultado = DSP_MTI16_pk4;
                break;
            case 5:
                Resultado = DSP_MTI16_pk5;
                break;
            case 6:
                Resultado = DSP_MTI16_pk6;
                break;
            case 7:
                Resultado = DSP_MTI16_pk7;
                break;
            case 8:
                Resultado = DSP_MTI16_pk8;
                break;
            case 9:
                Resultado = DSP_MTI16_pk9;
                break;
            case 10:
                Resultado = DSP_MTI16_pk10;
                break;
            case 11:
                Resultado = DSP_MTI16_pk11;
                break;
            case 12:
                Resultado = DSP_MTI16_pk12;
                break;
            case 13:
                Resultado = DSP_MTI16_pk13;
                break;
            case 14:
                Resultado = DSP_MTI16_pk14;
                break;
            case 15:
                Resultado = DSP_MTI16_pk15;
                break;
            case 16:
                Resultado = DSP_MTI16_pk16;
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_VolumenS(int X) {

        String Resultado = null;

        switch (X) {
            case 1:
                Resultado = DSP_MTO16_pk1;
                break;
            case 2:
                Resultado = DSP_MTO16_pk2;
                break;
            case 3:
                Resultado = DSP_MTO16_pk3;
                break;
            case 4:
                Resultado = DSP_MTO16_pk4;
                break;
            case 5:
                Resultado = DSP_MTO16_pk5;
                break;
            case 6:
                Resultado = DSP_MTO16_pk6;
                break;
            case 7:
                Resultado = DSP_MTO16_pk7;
                break;
            case 8:
                Resultado = DSP_MTO16_pk8;
                break;
            case 9:
                Resultado = DSP_MTO16_pk9;
                break;
            case 10:
                Resultado = DSP_MTO16_pk10;
                break;
            case 11:
                Resultado = DSP_MTO16_pk11;
                break;
            case 12:
                Resultado = DSP_MTO16_pk12;
                break;
            case 13:
                Resultado = DSP_MTO16_pk13;
                break;
            case 14:
                Resultado = DSP_MTO16_pk14;
                break;
            case 15:
                Resultado = DSP_MTO16_pk15;
                break;
            case 16:
                Resultado = DSP_MTO16_pk16;
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_EntradaEqGanancia(int X, int Y) {

        String Resultado = null;

        switch (X) {
            case 1:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQI8_1_B1_g;
                        break;
                    case 2:
                        Resultado = DSP_EQI8_1_B2_g;
                        break;
                    case 3:
                        Resultado = DSP_EQI8_1_B3_g;
                        break;
                    case 4:
                        Resultado = DSP_EQI8_1_B4_g;
                        break;
                    case 5:
                        Resultado = DSP_EQI8_1_B5_g;
                        break;
                    case 6:
                        Resultado = DSP_EQI8_1_B6_g;
                        break;
                    case 7:
                        Resultado = DSP_EQI8_1_B7_g;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 2:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQI8_2_B1_g;
                        break;
                    case 2:
                        Resultado = DSP_EQI8_2_B2_g;
                        break;
                    case 3:
                        Resultado = DSP_EQI8_2_B3_g;
                        break;
                    case 4:
                        Resultado = DSP_EQI8_2_B4_g;
                        break;
                    case 5:
                        Resultado = DSP_EQI8_2_B5_g;
                        break;
                    case 6:
                        Resultado = DSP_EQI8_2_B6_g;
                        break;
                    case 7:
                        Resultado = DSP_EQI8_2_B7_g;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 3:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQI8_3_B1_g;
                        break;
                    case 2:
                        Resultado = DSP_EQI8_3_B2_g;
                        break;
                    case 3:
                        Resultado = DSP_EQI8_3_B3_g;
                        break;
                    case 4:
                        Resultado = DSP_EQI8_3_B4_g;
                        break;
                    case 5:
                        Resultado = DSP_EQI8_3_B5_g;
                        break;
                    case 6:
                        Resultado = DSP_EQI8_3_B6_g;
                        break;
                    case 7:
                        Resultado = DSP_EQI8_3_B7_g;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 4:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQI8_4_B1_g;
                        break;
                    case 2:
                        Resultado = DSP_EQI8_4_B2_g;
                        break;
                    case 3:
                        Resultado = DSP_EQI8_4_B3_g;
                        break;
                    case 4:
                        Resultado = DSP_EQI8_4_B4_g;
                        break;
                    case 5:
                        Resultado = DSP_EQI8_4_B5_g;
                        break;
                    case 6:
                        Resultado = DSP_EQI8_4_B6_g;
                        break;
                    case 7:
                        Resultado = DSP_EQI8_4_B7_g;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 5:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQI8_5_B1_g;
                        break;
                    case 2:
                        Resultado = DSP_EQI8_5_B2_g;
                        break;
                    case 3:
                        Resultado = DSP_EQI8_5_B3_g;
                        break;
                    case 4:
                        Resultado = DSP_EQI8_5_B4_g;
                        break;
                    case 5:
                        Resultado = DSP_EQI8_5_B5_g;
                        break;
                    case 6:
                        Resultado = DSP_EQI8_5_B6_g;
                        break;
                    case 7:
                        Resultado = DSP_EQI8_5_B7_g;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 6:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQI8_6_B1_g;
                        break;
                    case 2:
                        Resultado = DSP_EQI8_6_B2_g;
                        break;
                    case 3:
                        Resultado = DSP_EQI8_6_B3_g;
                        break;
                    case 4:
                        Resultado = DSP_EQI8_6_B4_g;
                        break;
                    case 5:
                        Resultado = DSP_EQI8_6_B5_g;
                        break;
                    case 6:
                        Resultado = DSP_EQI8_6_B6_g;
                        break;
                    case 7:
                        Resultado = DSP_EQI8_6_B7_g;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 7:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQI8_7_B1_g;
                        break;
                    case 2:
                        Resultado = DSP_EQI8_7_B2_g;
                        break;
                    case 3:
                        Resultado = DSP_EQI8_7_B3_g;
                        break;
                    case 4:
                        Resultado = DSP_EQI8_7_B4_g;
                        break;
                    case 5:
                        Resultado = DSP_EQI8_7_B5_g;
                        break;
                    case 6:
                        Resultado = DSP_EQI8_7_B6_g;
                        break;
                    case 7:
                        Resultado = DSP_EQI8_7_B7_g;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 8:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQI8_8_B1_g;
                        break;
                    case 2:
                        Resultado = DSP_EQI8_8_B2_g;
                        break;
                    case 3:
                        Resultado = DSP_EQI8_8_B3_g;
                        break;
                    case 4:
                        Resultado = DSP_EQI8_8_B4_g;
                        break;
                    case 5:
                        Resultado = DSP_EQI8_8_B5_g;
                        break;
                    case 6:
                        Resultado = DSP_EQI8_8_B6_g;
                        break;
                    case 7:
                        Resultado = DSP_EQI8_8_B7_g;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_SalidaEqGanancia(int X, int Y) {

        String Resultado = null;

        switch (X) {
            case 1:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQO8_1_B1_g;
                        break;
                    case 2:
                        Resultado = DSP_EQO8_1_B2_g;
                        break;
                    case 3:
                        Resultado = DSP_EQO8_1_B3_g;
                        break;
                    case 4:
                        Resultado = DSP_EQO8_1_B4_g;
                        break;
                    case 5:
                        Resultado = DSP_EQO8_1_B5_g;
                        break;
                    case 6:
                        Resultado = DSP_EQO8_1_B6_g;
                        break;
                    case 7:
                        Resultado = DSP_EQO8_1_B7_g;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 2:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQO8_2_B1_g;
                        break;
                    case 2:
                        Resultado = DSP_EQO8_2_B2_g;
                        break;
                    case 3:
                        Resultado = DSP_EQO8_2_B3_g;
                        break;
                    case 4:
                        Resultado = DSP_EQO8_2_B4_g;
                        break;
                    case 5:
                        Resultado = DSP_EQO8_2_B5_g;
                        break;
                    case 6:
                        Resultado = DSP_EQO8_2_B6_g;
                        break;
                    case 7:
                        Resultado = DSP_EQO8_2_B7_g;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 3:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQO8_3_B1_g;
                        break;
                    case 2:
                        Resultado = DSP_EQO8_3_B2_g;
                        break;
                    case 3:
                        Resultado = DSP_EQO8_3_B3_g;
                        break;
                    case 4:
                        Resultado = DSP_EQO8_3_B4_g;
                        break;
                    case 5:
                        Resultado = DSP_EQO8_3_B5_g;
                        break;
                    case 6:
                        Resultado = DSP_EQO8_3_B6_g;
                        break;
                    case 7:
                        Resultado = DSP_EQO8_3_B7_g;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 4:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQO8_4_B1_g;
                        break;
                    case 2:
                        Resultado = DSP_EQO8_4_B2_g;
                        break;
                    case 3:
                        Resultado = DSP_EQO8_4_B3_g;
                        break;
                    case 4:
                        Resultado = DSP_EQO8_4_B4_g;
                        break;
                    case 5:
                        Resultado = DSP_EQO8_4_B5_g;
                        break;
                    case 6:
                        Resultado = DSP_EQO8_4_B6_g;
                        break;
                    case 7:
                        Resultado = DSP_EQO8_4_B7_g;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 5:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQO8_5_B1_g;
                        break;
                    case 2:
                        Resultado = DSP_EQO8_5_B2_g;
                        break;
                    case 3:
                        Resultado = DSP_EQO8_5_B3_g;
                        break;
                    case 4:
                        Resultado = DSP_EQO8_5_B4_g;
                        break;
                    case 5:
                        Resultado = DSP_EQO8_5_B5_g;
                        break;
                    case 6:
                        Resultado = DSP_EQO8_5_B6_g;
                        break;
                    case 7:
                        Resultado = DSP_EQO8_5_B7_g;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 6:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQO8_6_B1_g;
                        break;
                    case 2:
                        Resultado = DSP_EQO8_6_B2_g;
                        break;
                    case 3:
                        Resultado = DSP_EQO8_6_B3_g;
                        break;
                    case 4:
                        Resultado = DSP_EQO8_6_B4_g;
                        break;
                    case 5:
                        Resultado = DSP_EQO8_6_B5_g;
                        break;
                    case 6:
                        Resultado = DSP_EQO8_6_B6_g;
                        break;
                    case 7:
                        Resultado = DSP_EQO8_6_B7_g;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 7:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQO8_7_B1_g;
                        break;
                    case 2:
                        Resultado = DSP_EQO8_7_B2_g;
                        break;
                    case 3:
                        Resultado = DSP_EQO8_7_B3_g;
                        break;
                    case 4:
                        Resultado = DSP_EQO8_7_B4_g;
                        break;
                    case 5:
                        Resultado = DSP_EQO8_7_B5_g;
                        break;
                    case 6:
                        Resultado = DSP_EQO8_7_B6_g;
                        break;
                    case 7:
                        Resultado = DSP_EQO8_7_B7_g;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 8:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQO8_8_B1_g;
                        break;
                    case 2:
                        Resultado = DSP_EQO8_8_B2_g;
                        break;
                    case 3:
                        Resultado = DSP_EQO8_8_B3_g;
                        break;
                    case 4:
                        Resultado = DSP_EQO8_8_B4_g;
                        break;
                    case 5:
                        Resultado = DSP_EQO8_8_B5_g;
                        break;
                    case 6:
                        Resultado = DSP_EQO8_8_B6_g;
                        break;
                    case 7:
                        Resultado = DSP_EQO8_8_B7_g;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_EntradaEqFrequencia(int X, int Y) {

        String Resultado = null;

        switch (X) {
            case 1:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQI8_1_B1_b;
                        break;
                    case 2:
                        Resultado = DSP_EQI8_1_B2_b;
                        break;
                    case 3:
                        Resultado = DSP_EQI8_1_B3_b;
                        break;
                    case 4:
                        Resultado = DSP_EQI8_1_B4_b;
                        break;
                    case 5:
                        Resultado = DSP_EQI8_1_B5_b;
                        break;
                    case 6:
                        Resultado = DSP_EQI8_1_B6_b;
                        break;
                    case 7:
                        Resultado = DSP_EQI8_1_B7_b;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 2:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQI8_2_B1_b;
                        break;
                    case 2:
                        Resultado = DSP_EQI8_2_B2_b;
                        break;
                    case 3:
                        Resultado = DSP_EQI8_2_B3_b;
                        break;
                    case 4:
                        Resultado = DSP_EQI8_2_B4_b;
                        break;
                    case 5:
                        Resultado = DSP_EQI8_2_B5_b;
                        break;
                    case 6:
                        Resultado = DSP_EQI8_2_B6_b;
                        break;
                    case 7:
                        Resultado = DSP_EQI8_2_B7_b;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 3:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQI8_3_B1_b;
                        break;
                    case 2:
                        Resultado = DSP_EQI8_3_B2_b;
                        break;
                    case 3:
                        Resultado = DSP_EQI8_3_B3_b;
                        break;
                    case 4:
                        Resultado = DSP_EQI8_3_B4_b;
                        break;
                    case 5:
                        Resultado = DSP_EQI8_3_B5_b;
                        break;
                    case 6:
                        Resultado = DSP_EQI8_3_B6_b;
                        break;
                    case 7:
                        Resultado = DSP_EQI8_3_B7_b;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 4:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQI8_4_B1_b;
                        break;
                    case 2:
                        Resultado = DSP_EQI8_4_B2_b;
                        break;
                    case 3:
                        Resultado = DSP_EQI8_4_B3_b;
                        break;
                    case 4:
                        Resultado = DSP_EQI8_4_B4_b;
                        break;
                    case 5:
                        Resultado = DSP_EQI8_4_B5_b;
                        break;
                    case 6:
                        Resultado = DSP_EQI8_4_B6_b;
                        break;
                    case 7:
                        Resultado = DSP_EQI8_4_B7_b;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 5:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQI8_5_B1_b;
                        break;
                    case 2:
                        Resultado = DSP_EQI8_5_B2_b;
                        break;
                    case 3:
                        Resultado = DSP_EQI8_5_B3_b;
                        break;
                    case 4:
                        Resultado = DSP_EQI8_5_B4_b;
                        break;
                    case 5:
                        Resultado = DSP_EQI8_5_B5_b;
                        break;
                    case 6:
                        Resultado = DSP_EQI8_5_B6_b;
                        break;
                    case 7:
                        Resultado = DSP_EQI8_5_B7_b;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 6:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQI8_6_B1_b;
                        break;
                    case 2:
                        Resultado = DSP_EQI8_6_B2_b;
                        break;
                    case 3:
                        Resultado = DSP_EQI8_6_B3_b;
                        break;
                    case 4:
                        Resultado = DSP_EQI8_6_B4_b;
                        break;
                    case 5:
                        Resultado = DSP_EQI8_6_B5_b;
                        break;
                    case 6:
                        Resultado = DSP_EQI8_6_B6_b;
                        break;
                    case 7:
                        Resultado = DSP_EQI8_6_B7_b;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 7:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQI8_7_B1_b;
                        break;
                    case 2:
                        Resultado = DSP_EQI8_7_B2_b;
                        break;
                    case 3:
                        Resultado = DSP_EQI8_7_B3_b;
                        break;
                    case 4:
                        Resultado = DSP_EQI8_7_B4_b;
                        break;
                    case 5:
                        Resultado = DSP_EQI8_7_B5_b;
                        break;
                    case 6:
                        Resultado = DSP_EQI8_7_B6_b;
                        break;
                    case 7:
                        Resultado = DSP_EQI8_7_B7_b;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 8:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQI8_8_B1_b;
                        break;
                    case 2:
                        Resultado = DSP_EQI8_8_B2_b;
                        break;
                    case 3:
                        Resultado = DSP_EQI8_8_B3_b;
                        break;
                    case 4:
                        Resultado = DSP_EQI8_8_B4_b;
                        break;
                    case 5:
                        Resultado = DSP_EQI8_8_B5_b;
                        break;
                    case 6:
                        Resultado = DSP_EQI8_8_B6_b;
                        break;
                    case 7:
                        Resultado = DSP_EQI8_8_B7_b;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_SalidaEqFrequencia(int X, int Y) {

        String Resultado = null;

        switch (X) {
            case 1:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQO8_1_B1_b;
                        break;
                    case 2:
                        Resultado = DSP_EQO8_1_B2_b;
                        break;
                    case 3:
                        Resultado = DSP_EQO8_1_B3_b;
                        break;
                    case 4:
                        Resultado = DSP_EQO8_1_B4_b;
                        break;
                    case 5:
                        Resultado = DSP_EQO8_1_B5_b;
                        break;
                    case 6:
                        Resultado = DSP_EQO8_1_B6_b;
                        break;
                    case 7:
                        Resultado = DSP_EQO8_1_B7_b;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 2:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQO8_2_B1_b;
                        break;
                    case 2:
                        Resultado = DSP_EQO8_2_B2_b;
                        break;
                    case 3:
                        Resultado = DSP_EQO8_2_B3_b;
                        break;
                    case 4:
                        Resultado = DSP_EQO8_2_B4_b;
                        break;
                    case 5:
                        Resultado = DSP_EQO8_2_B5_b;
                        break;
                    case 6:
                        Resultado = DSP_EQO8_2_B6_b;
                        break;
                    case 7:
                        Resultado = DSP_EQO8_2_B7_b;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 3:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQO8_3_B1_b;
                        break;
                    case 2:
                        Resultado = DSP_EQO8_3_B2_b;
                        break;
                    case 3:
                        Resultado = DSP_EQO8_3_B3_b;
                        break;
                    case 4:
                        Resultado = DSP_EQO8_3_B4_b;
                        break;
                    case 5:
                        Resultado = DSP_EQO8_3_B5_b;
                        break;
                    case 6:
                        Resultado = DSP_EQO8_3_B6_b;
                        break;
                    case 7:
                        Resultado = DSP_EQO8_3_B7_b;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 4:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQO8_4_B1_b;
                        break;
                    case 2:
                        Resultado = DSP_EQO8_4_B2_b;
                        break;
                    case 3:
                        Resultado = DSP_EQO8_4_B3_b;
                        break;
                    case 4:
                        Resultado = DSP_EQO8_4_B4_b;
                        break;
                    case 5:
                        Resultado = DSP_EQO8_4_B5_b;
                        break;
                    case 6:
                        Resultado = DSP_EQO8_4_B6_b;
                        break;
                    case 7:
                        Resultado = DSP_EQO8_4_B7_b;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 5:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQO8_5_B1_b;
                        break;
                    case 2:
                        Resultado = DSP_EQO8_5_B2_b;
                        break;
                    case 3:
                        Resultado = DSP_EQO8_5_B3_b;
                        break;
                    case 4:
                        Resultado = DSP_EQO8_5_B4_b;
                        break;
                    case 5:
                        Resultado = DSP_EQO8_5_B5_b;
                        break;
                    case 6:
                        Resultado = DSP_EQO8_5_B6_b;
                        break;
                    case 7:
                        Resultado = DSP_EQO8_5_B7_b;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 6:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQO8_6_B1_b;
                        break;
                    case 2:
                        Resultado = DSP_EQO8_6_B2_b;
                        break;
                    case 3:
                        Resultado = DSP_EQO8_6_B3_b;
                        break;
                    case 4:
                        Resultado = DSP_EQO8_6_B4_b;
                        break;
                    case 5:
                        Resultado = DSP_EQO8_6_B5_b;
                        break;
                    case 6:
                        Resultado = DSP_EQO8_6_B6_b;
                        break;
                    case 7:
                        Resultado = DSP_EQO8_6_B7_b;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 7:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQO8_7_B1_b;
                        break;
                    case 2:
                        Resultado = DSP_EQO8_7_B2_b;
                        break;
                    case 3:
                        Resultado = DSP_EQO8_7_B3_b;
                        break;
                    case 4:
                        Resultado = DSP_EQO8_7_B4_b;
                        break;
                    case 5:
                        Resultado = DSP_EQO8_7_B5_b;
                        break;
                    case 6:
                        Resultado = DSP_EQO8_7_B6_b;
                        break;
                    case 7:
                        Resultado = DSP_EQO8_7_B7_b;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 8:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQO8_8_B1_b;
                        break;
                    case 2:
                        Resultado = DSP_EQO8_8_B2_b;
                        break;
                    case 3:
                        Resultado = DSP_EQO8_8_B3_b;
                        break;
                    case 4:
                        Resultado = DSP_EQO8_8_B4_b;
                        break;
                    case 5:
                        Resultado = DSP_EQO8_8_B5_b;
                        break;
                    case 6:
                        Resultado = DSP_EQO8_8_B6_b;
                        break;
                    case 7:
                        Resultado = DSP_EQO8_8_B7_b;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_EntradaEqBandwidth(int X, int Y) {

        String Resultado = null;

        switch (X) {
            case 1:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQI8_1_B1_a;
                        break;
                    case 2:
                        Resultado = DSP_EQI8_1_B2_a;
                        break;
                    case 3:
                        Resultado = DSP_EQI8_1_B3_a;
                        break;
                    case 4:
                        Resultado = DSP_EQI8_1_B4_a;
                        break;
                    case 5:
                        Resultado = DSP_EQI8_1_B5_a;
                        break;
                    case 6:
                        Resultado = DSP_EQI8_1_B6_a;
                        break;
                    case 7:
                        Resultado = DSP_EQI8_1_B7_a;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 2:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQI8_2_B1_a;
                        break;
                    case 2:
                        Resultado = DSP_EQI8_2_B2_a;
                        break;
                    case 3:
                        Resultado = DSP_EQI8_2_B3_a;
                        break;
                    case 4:
                        Resultado = DSP_EQI8_2_B4_a;
                        break;
                    case 5:
                        Resultado = DSP_EQI8_2_B5_a;
                        break;
                    case 6:
                        Resultado = DSP_EQI8_2_B6_a;
                        break;
                    case 7:
                        Resultado = DSP_EQI8_2_B7_a;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 3:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQI8_3_B1_a;
                        break;
                    case 2:
                        Resultado = DSP_EQI8_3_B2_a;
                        break;
                    case 3:
                        Resultado = DSP_EQI8_3_B3_a;
                        break;
                    case 4:
                        Resultado = DSP_EQI8_3_B4_a;
                        break;
                    case 5:
                        Resultado = DSP_EQI8_3_B5_a;
                        break;
                    case 6:
                        Resultado = DSP_EQI8_3_B6_a;
                        break;
                    case 7:
                        Resultado = DSP_EQI8_3_B7_a;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 4:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQI8_4_B1_a;
                        break;
                    case 2:
                        Resultado = DSP_EQI8_4_B2_a;
                        break;
                    case 3:
                        Resultado = DSP_EQI8_4_B3_a;
                        break;
                    case 4:
                        Resultado = DSP_EQI8_4_B4_a;
                        break;
                    case 5:
                        Resultado = DSP_EQI8_4_B5_a;
                        break;
                    case 6:
                        Resultado = DSP_EQI8_4_B6_a;
                        break;
                    case 7:
                        Resultado = DSP_EQI8_4_B7_a;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 5:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQI8_5_B1_a;
                        break;
                    case 2:
                        Resultado = DSP_EQI8_5_B2_a;
                        break;
                    case 3:
                        Resultado = DSP_EQI8_5_B3_a;
                        break;
                    case 4:
                        Resultado = DSP_EQI8_5_B4_a;
                        break;
                    case 5:
                        Resultado = DSP_EQI8_5_B5_a;
                        break;
                    case 6:
                        Resultado = DSP_EQI8_5_B6_a;
                        break;
                    case 7:
                        Resultado = DSP_EQI8_5_B7_a;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 6:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQI8_6_B1_a;
                        break;
                    case 2:
                        Resultado = DSP_EQI8_6_B2_a;
                        break;
                    case 3:
                        Resultado = DSP_EQI8_6_B3_a;
                        break;
                    case 4:
                        Resultado = DSP_EQI8_6_B4_a;
                        break;
                    case 5:
                        Resultado = DSP_EQI8_6_B5_a;
                        break;
                    case 6:
                        Resultado = DSP_EQI8_6_B6_a;
                        break;
                    case 7:
                        Resultado = DSP_EQI8_6_B7_a;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 7:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQI8_7_B1_a;
                        break;
                    case 2:
                        Resultado = DSP_EQI8_7_B2_a;
                        break;
                    case 3:
                        Resultado = DSP_EQI8_7_B3_a;
                        break;
                    case 4:
                        Resultado = DSP_EQI8_7_B4_a;
                        break;
                    case 5:
                        Resultado = DSP_EQI8_7_B5_a;
                        break;
                    case 6:
                        Resultado = DSP_EQI8_7_B6_a;
                        break;
                    case 7:
                        Resultado = DSP_EQI8_7_B7_a;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 8:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQI8_8_B1_a;
                        break;
                    case 2:
                        Resultado = DSP_EQI8_8_B2_a;
                        break;
                    case 3:
                        Resultado = DSP_EQI8_8_B3_a;
                        break;
                    case 4:
                        Resultado = DSP_EQI8_8_B4_a;
                        break;
                    case 5:
                        Resultado = DSP_EQI8_8_B5_a;
                        break;
                    case 6:
                        Resultado = DSP_EQI8_8_B6_a;
                        break;
                    case 7:
                        Resultado = DSP_EQI8_8_B7_a;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_SalidaEqBandwidth(int X, int Y) {

        String Resultado = null;

        switch (X) {
            case 1:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQO8_1_B1_a;
                        break;
                    case 2:
                        Resultado = DSP_EQO8_1_B2_a;
                        break;
                    case 3:
                        Resultado = DSP_EQO8_1_B3_a;
                        break;
                    case 4:
                        Resultado = DSP_EQO8_1_B4_a;
                        break;
                    case 5:
                        Resultado = DSP_EQO8_1_B5_a;
                        break;
                    case 6:
                        Resultado = DSP_EQO8_1_B6_a;
                        break;
                    case 7:
                        Resultado = DSP_EQO8_1_B7_a;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 2:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQO8_2_B1_a;
                        break;
                    case 2:
                        Resultado = DSP_EQO8_2_B2_a;
                        break;
                    case 3:
                        Resultado = DSP_EQO8_2_B3_a;
                        break;
                    case 4:
                        Resultado = DSP_EQO8_2_B4_a;
                        break;
                    case 5:
                        Resultado = DSP_EQO8_2_B5_a;
                        break;
                    case 6:
                        Resultado = DSP_EQO8_2_B6_a;
                        break;
                    case 7:
                        Resultado = DSP_EQO8_2_B7_a;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 3:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQO8_3_B1_a;
                        break;
                    case 2:
                        Resultado = DSP_EQO8_3_B2_a;
                        break;
                    case 3:
                        Resultado = DSP_EQO8_3_B3_a;
                        break;
                    case 4:
                        Resultado = DSP_EQO8_3_B4_a;
                        break;
                    case 5:
                        Resultado = DSP_EQO8_3_B5_a;
                        break;
                    case 6:
                        Resultado = DSP_EQO8_3_B6_a;
                        break;
                    case 7:
                        Resultado = DSP_EQO8_3_B7_a;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 4:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQO8_4_B1_a;
                        break;
                    case 2:
                        Resultado = DSP_EQO8_4_B2_a;
                        break;
                    case 3:
                        Resultado = DSP_EQO8_4_B3_a;
                        break;
                    case 4:
                        Resultado = DSP_EQO8_4_B4_a;
                        break;
                    case 5:
                        Resultado = DSP_EQO8_4_B5_a;
                        break;
                    case 6:
                        Resultado = DSP_EQO8_4_B6_a;
                        break;
                    case 7:
                        Resultado = DSP_EQO8_4_B7_a;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 5:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQO8_5_B1_a;
                        break;
                    case 2:
                        Resultado = DSP_EQO8_5_B2_a;
                        break;
                    case 3:
                        Resultado = DSP_EQO8_5_B3_a;
                        break;
                    case 4:
                        Resultado = DSP_EQO8_5_B4_a;
                        break;
                    case 5:
                        Resultado = DSP_EQO8_5_B5_a;
                        break;
                    case 6:
                        Resultado = DSP_EQO8_5_B6_a;
                        break;
                    case 7:
                        Resultado = DSP_EQO8_5_B7_a;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 6:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQO8_6_B1_a;
                        break;
                    case 2:
                        Resultado = DSP_EQO8_6_B2_a;
                        break;
                    case 3:
                        Resultado = DSP_EQO8_6_B3_a;
                        break;
                    case 4:
                        Resultado = DSP_EQO8_6_B4_a;
                        break;
                    case 5:
                        Resultado = DSP_EQO8_6_B5_a;
                        break;
                    case 6:
                        Resultado = DSP_EQO8_6_B6_a;
                        break;
                    case 7:
                        Resultado = DSP_EQO8_6_B7_a;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 7:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQO8_7_B1_a;
                        break;
                    case 2:
                        Resultado = DSP_EQO8_7_B2_a;
                        break;
                    case 3:
                        Resultado = DSP_EQO8_7_B3_a;
                        break;
                    case 4:
                        Resultado = DSP_EQO8_7_B4_a;
                        break;
                    case 5:
                        Resultado = DSP_EQO8_7_B5_a;
                        break;
                    case 6:
                        Resultado = DSP_EQO8_7_B6_a;
                        break;
                    case 7:
                        Resultado = DSP_EQO8_7_B7_a;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            case 8:
                switch (Y) {
                    case 1:
                        Resultado = DSP_EQO8_8_B1_a;
                        break;
                    case 2:
                        Resultado = DSP_EQO8_8_B2_a;
                        break;
                    case 3:
                        Resultado = DSP_EQO8_8_B3_a;
                        break;
                    case 4:
                        Resultado = DSP_EQO8_8_B4_a;
                        break;
                    case 5:
                        Resultado = DSP_EQO8_8_B5_a;
                        break;
                    case 6:
                        Resultado = DSP_EQO8_8_B6_a;
                        break;
                    case 7:
                        Resultado = DSP_EQO8_8_B7_a;
                        break;
                    default:
                        Resultado = "";
                        break;
                }
                break;
            default:
                Resultado = "";
                break;
        }

        return Resultado;

    }

    public static String OID_Mixer_Gain(int X, int Y) {
        String functionReturnValue = null;
        //X is index of mixer
        //Y is index of input
        switch (X) {
            case 1:
                switch (Y) {
                    case 1:
                        functionReturnValue = DSP_MXI16O4_1_input1output1send;
                        break;
                    case 2:
                        functionReturnValue = DSP_MXI16O4_1_input2output1send;
                        break;
                    case 3:
                        functionReturnValue = DSP_MXI16O4_1_input3output1send;
                        break;
                    case 4:
                        functionReturnValue = DSP_MXI16O4_1_input4output1send;
                        break;
                    case 5:
                        functionReturnValue = DSP_MXI16O4_1_input5output1send;
                        break;
                    case 6:
                        functionReturnValue = DSP_MXI16O4_1_input6output1send;
                        break;
                    case 7:
                        functionReturnValue = DSP_MXI16O4_1_input7output1send;
                        break;
                    case 8:
                        functionReturnValue = DSP_MXI16O4_1_input8output1send;
                        break;
                    case 9:
                        functionReturnValue = DSP_MXI16O4_1_input9output1send;
                        break;
                    case 10:
                        functionReturnValue = DSP_MXI16O4_1_input10output1send;
                        break;
                    case 11:
                        functionReturnValue = DSP_MXI16O4_1_input11output1send;
                        break;
                    case 12:
                        functionReturnValue = DSP_MXI16O4_1_input12output1send;
                        break;
                    case 13:
                        functionReturnValue = DSP_MXI16O4_1_input13output1send;
                        break;
                    case 14:
                        functionReturnValue = DSP_MXI16O4_1_input14output1send;
                        break;
                    case 15:
                        functionReturnValue = DSP_MXI16O4_1_input15output1send;
                        break;
                    case 16:
                        functionReturnValue = DSP_MXI16O4_1_input16output1send;
                        break;
                    default:
                        functionReturnValue = "";
                        break;
                }
                break;
            case 2:
                switch (Y) {
                    case 1:
                        functionReturnValue = DSP_MXI16O4_2_input1output1send;
                        break;
                    case 2:
                        functionReturnValue = DSP_MXI16O4_2_input2output1send;
                        break;
                    case 3:
                        functionReturnValue = DSP_MXI16O4_2_input3output1send;
                        break;
                    case 4:
                        functionReturnValue = DSP_MXI16O4_2_input4output1send;
                        break;
                    case 5:
                        functionReturnValue = DSP_MXI16O4_2_input5output1send;
                        break;
                    case 6:
                        functionReturnValue = DSP_MXI16O4_2_input6output1send;
                        break;
                    case 7:
                        functionReturnValue = DSP_MXI16O4_2_input7output1send;
                        break;
                    case 8:
                        functionReturnValue = DSP_MXI16O4_2_input8output1send;
                        break;
                    case 9:
                        functionReturnValue = DSP_MXI16O4_2_input9output1send;
                        break;
                    case 10:
                        functionReturnValue = DSP_MXI16O4_2_input10output1send;
                        break;
                    case 11:
                        functionReturnValue = DSP_MXI16O4_2_input11output1send;
                        break;
                    case 12:
                        functionReturnValue = DSP_MXI16O4_2_input12output1send;
                        break;
                    case 13:
                        functionReturnValue = DSP_MXI16O4_2_input13output1send;
                        break;
                    case 14:
                        functionReturnValue = DSP_MXI16O4_2_input14output1send;
                        break;
                    case 15:
                        functionReturnValue = DSP_MXI16O4_2_input15output1send;
                        break;
                    case 16:
                        functionReturnValue = DSP_MXI16O4_2_input16output1send;
                        break;
                    default:
                        functionReturnValue = "";
                        break;
                }
                break;
            case 3:
                switch (Y) {
                    case 1:
                        functionReturnValue = DSP_MXI16O4_3_input1output1send;
                        break;
                    case 2:
                        functionReturnValue = DSP_MXI16O4_3_input2output1send;
                        break;
                    case 3:
                        functionReturnValue = DSP_MXI16O4_3_input3output1send;
                        break;
                    case 4:
                        functionReturnValue = DSP_MXI16O4_3_input4output1send;
                        break;
                    case 5:
                        functionReturnValue = DSP_MXI16O4_3_input5output1send;
                        break;
                    case 6:
                        functionReturnValue = DSP_MXI16O4_3_input6output1send;
                        break;
                    case 7:
                        functionReturnValue = DSP_MXI16O4_3_input7output1send;
                        break;
                    case 8:
                        functionReturnValue = DSP_MXI16O4_3_input8output1send;
                        break;
                    case 9:
                        functionReturnValue = DSP_MXI16O4_3_input9output1send;
                        break;
                    case 10:
                        functionReturnValue = DSP_MXI16O4_3_input10output1send;
                        break;
                    case 11:
                        functionReturnValue = DSP_MXI16O4_3_input11output1send;
                        break;
                    case 12:
                        functionReturnValue = DSP_MXI16O4_3_input12output1send;
                        break;
                    case 13:
                        functionReturnValue = DSP_MXI16O4_3_input13output1send;
                        break;
                    case 14:
                        functionReturnValue = DSP_MXI16O4_3_input14output1send;
                        break;
                    case 15:
                        functionReturnValue = DSP_MXI16O4_3_input15output1send;
                        break;
                    case 16:
                        functionReturnValue = DSP_MXI16O4_3_input16output1send;
                        break;
                    default:
                        functionReturnValue = "";
                        break;
                }
                break;
            case 4:
                switch (Y) {
                    case 1:
                        functionReturnValue = DSP_MXI16O4_4_input1output1send;
                        break;
                    case 2:
                        functionReturnValue = DSP_MXI16O4_4_input2output1send;
                        break;
                    case 3:
                        functionReturnValue = DSP_MXI16O4_4_input3output1send;
                        break;
                    case 4:
                        functionReturnValue = DSP_MXI16O4_4_input4output1send;
                        break;
                    case 5:
                        functionReturnValue = DSP_MXI16O4_4_input5output1send;
                        break;
                    case 6:
                        functionReturnValue = DSP_MXI16O4_4_input6output1send;
                        break;
                    case 7:
                        functionReturnValue = DSP_MXI16O4_4_input7output1send;
                        break;
                    case 8:
                        functionReturnValue = DSP_MXI16O4_4_input8output1send;
                        break;
                    case 9:
                        functionReturnValue = DSP_MXI16O4_4_input9output1send;
                        break;
                    case 10:
                        functionReturnValue = DSP_MXI16O4_4_input10output1send;
                        break;
                    case 11:
                        functionReturnValue = DSP_MXI16O4_4_input11output1send;
                        break;
                    case 12:
                        functionReturnValue = DSP_MXI16O4_4_input12output1send;
                        break;
                    case 13:
                        functionReturnValue = DSP_MXI16O4_4_input13output1send;
                        break;
                    case 14:
                        functionReturnValue = DSP_MXI16O4_4_input14output1send;
                        break;
                    case 15:
                        functionReturnValue = DSP_MXI16O4_4_input15output1send;
                        break;
                    case 16:
                        functionReturnValue = DSP_MXI16O4_4_input16output1send;
                        break;
                    default:
                        functionReturnValue = "";
                        break;
                }
                break;
            default:
                functionReturnValue = "";
                break;
        }
        return functionReturnValue;


    }

    public static String OID_Pink_Noise() {
        return DSP_PN_gain;
    }

    public static String OID_White_Noise() {
        return DSP_WN_gain;
    }

    public static String OID_Delay_Delay(int X) {
        String functionReturnValue = null;
        switch (X) {
            case 1:
                functionReturnValue = DSP_DLO8_1_delay1;
                break;
            case 2:
                functionReturnValue = DSP_DLO8_2_delay1;
                break;
            case 3:
                functionReturnValue = DSP_DLO8_3_delay1;
                break;
            case 4:
                functionReturnValue = DSP_DLO8_4_delay1;
                break;
            case 5:
                functionReturnValue = DSP_DLO8_5_delay1;
                break;
            case 6:
                functionReturnValue = DSP_DLO8_6_delay1;
                break;
            case 7:
                functionReturnValue = DSP_DLO8_7_delay1;
                break;
            case 8:
                functionReturnValue = DSP_DLO8_8_delay1;
                break;
            default:
                functionReturnValue = "";
                break;
        }
        return functionReturnValue;

    }

    public static String OID_Delay_Gain(int X) {
        String functionReturnValue = null;
        switch (X) {
            case 1:
                functionReturnValue = DSP_DLO8_1_delaygain1;
                break;
            case 2:
                functionReturnValue = DSP_DLO8_2_delaygain1;
                break;
            case 3:
                functionReturnValue = DSP_DLO8_3_delaygain1;
                break;
            case 4:
                functionReturnValue = DSP_DLO8_4_delaygain1;
                break;
            case 5:
                functionReturnValue = DSP_DLO8_5_delaygain1;
                break;
            case 6:
                functionReturnValue = DSP_DLO8_6_delaygain1;
                break;
            case 7:
                functionReturnValue = DSP_DLO8_7_delaygain1;
                break;
            case 8:
                functionReturnValue = DSP_DLO8_8_delaygain1;
                break;
            default:
                functionReturnValue = "";
                break;
        }
        return functionReturnValue;
    }

    public static String OID_GananciaTono() {
        return DSP_TNO8_SNG_gain;

    }

    public static String OID_FrecuenciaTono() {
        return DSP_TNO8_SNG_omega;
    }
    // #endregion
    // #region "finalantes para las funcines de conversion de datos del DSP de cobranet "
    /// <summary>
    /// Es el valor minimo ó mas pequeño de los decibelios
    /// </summary>
    /// <remarks></remarks>
    // #endregion
    public static final int MIN_DECIBELIOS = -100;

    // #region "Funciones de conversion de datos del DSP de cobranet"
    //Convierte punto fijo a LevelTono
    public static double aLevelTono(double B) {
        double functionReturnValue = 0.0;

        if (B != 0) {
            functionReturnValue = 20 * (Math.log10(B / (Math.pow(2, 29))));
        } else {
            functionReturnValue = Double.valueOf(-100);
        }
        return functionReturnValue;

    }

    //Convierte LevelTono a punto fijo
    public static double aLevelTonoPuntoFijo(double T) {
        return Math.round((Math.pow(10, (T / 20))) * (Math.pow(2, 29)));
    }

    public static long aLevelTonoMasterPuntoFijo(double T) {
        //Dim aux As Integer
        //MsgBox(Round(((-10 ^ ((T - 20) / 20)) / 16) * (2 ^ 31)))
        //MsgBox("Hi")
        //MsgBox(CInt(Round(((-10 ^ ((T - 20) / 20)) / 16) * (2 ^ 31)) - 2 ^ 31))
        //Dim bbb As Integer = 2 ^ 31 - Round(((-10 ^ ((T - 20) / 20)) / 16) * (2 ^ 31)) ' - 2 ^ 31
        //MsgBox(bbb & "hi")
        //aux = CInt(-2 ^ 31 - CDbl(Round(((-10 ^ ((T - 20) / 20)) / 16) * (2 ^ 31)))))

        //aux = Round(((-10 ^ ((T - 20) / 20)) / 16) * (2 ^ 31))
        //If aux < 0 Then
        // aLevelTonoMasterPuntoFijo = (2 ^ 32) + aux
        //Else
        //aLevelTonoMasterPuntoFijo = CUInt(aux)
        //End If


        return Math.round(((-Math.pow(10, ((T - 20) / 20))) / 16) * (Math.pow(2, 31)));
        //aLevelTonoMasterPuntoFijo = Round(((-10 ^ ((T - 20) / 20))) * (2 ^ 31))
    }

    //Convierte punto fijo a LevelTono
    public static double aLevelTonoMaster(double B) {
        double functionReturnValue = 0.0;
        //B = -B - 2 ^ 31

        if (B != 0) {
            //aLevelTonoMaster = 20 + 20 * Log10(-16 * b / 2 ^ 31)
            functionReturnValue = 20 + 20 * Math.log10(-16 * B / Math.pow(2, 31));
        } else {
            functionReturnValue = -100;
        }
        return functionReturnValue;
    }

    public static double aFreqTonoPuntoFijo(double T) {
        return Math.round(2 * T / 48000 * Math.pow(2, 31));
    }

    public static double aFreqTono(double B) {
        return 48000 * B / (2 * Math.pow(2, 31));
    }

    /// <summary>
    /// Convierte decibelios en puntos de volumen
    /// </summary>
    /// <param name="x">Decibelos a convertir</param>
    /// <returns>Son los pasos de volumenes ya conviertidos </returns>
    /// <remarks></remarks>
    public static double aPV(double x) {
        return Math.round(((Math.pow(10, (x / 20))) * (Math.pow(2, 29))));
    }

    /// <summary>
    /// Convierte Puntos de volumen en decibelios 
    /// </summary>
    /// <param name="T">Son los pasos de volumen a convertir</param>
    /// <returns>Son los decibelios ya convertidos</returns>
    /// <remarks></remarks>
    public static double adB(double T) {
        double functionReturnValue = 0;
        double Y = 0;
        if (T == 0) {
            functionReturnValue = MIN_DECIBELIOS;
        } else {
            Y = 20 * (Math.log10(T) - 29 * Math.log10(2));
            functionReturnValue = Math.round((Y + 82) / 2);
        }
        return functionReturnValue;
    }

    /// <summary>
    /// Convierte puntos de volumen en ganancia decibelios
    /// </summary>
    /// <param name="T">Son los puntos de volumen a convertir</param>
    /// <returns>Es la ganancia decibelios convertidos</returns>
    /// <remarks></remarks>
    public static double adB2(double T) {
        double functionReturnValue = 0;
        if (T == 0) {
            functionReturnValue = MIN_DECIBELIOS;
        } else {
            functionReturnValue = Math.round(20 * (Math.log10(T) - 29 * Math.log10(2)));
        }
        return functionReturnValue;
    }

    /// <summary>
    /// Convierte Puntos de volumen en pk y pkhold para meter
    /// </summary>
    /// <param name="T">Son los puntos de volumen a convertir</param>
    /// <returns>Son los pk y pkhold convertidos para el meter</returns>
    /// <remarks></remarks>
    public static double adB3(double T) {
        double functionReturnValue = 0;
        double Y = 0;
        if (T == 0) {
            functionReturnValue = MIN_DECIBELIOS;
        } else {
            Y = 20 + 10 * Math.log10(2) + 20 * Math.log10(16) + 20 * Math.log10(T);
            functionReturnValue = Math.round(Y - 190);
        }
        return functionReturnValue;
    }

    /// <summary>
    /// convierte Ratio a punto fijo
    /// </summary>
    /// <param name="T">Es el ratio a convertir</param>
    /// <returns>es el parametro convertido a punto fijo</returns>
    /// <remarks></remarks>
    public static double aRatioPuntoFijo(double T) {
        return Math.round((-1 + (1 / Double.valueOf(T))) * (Math.pow(2, 31)));
    }

    /// <summary>
    /// Convierte Attack a punto fijo
    /// </summary>
    /// <param name="T">Es el attack a convertir</param>
    /// <returns>es el attack convertido a punto fijo</returns>
    /// <remarks></remarks>
    public static double aAttackPuntoFijo(double T) {
        return Math.round((1 - Math.exp(-1 / (T * (48 / 16)))) * Math.pow(2, 31));
    }

    /// <summary>
    /// Convierte Release a punto fijo
    /// </summary>
    /// <param name="T">Es el release a convertir</param>
    /// <returns>Es el parametro convertido a punto fijo</returns>
    /// <remarks></remarks>
    public static double aReleasePuntoFijo(double T) {
        return Math.round((1 - Math.exp(-1 / (T * (48 / 16)))) * (Math.pow(2, 31)));
    }

    /// <summary>
    /// Convierte Soft Knee a punto fijo
    /// </summary>
    /// <param name="T">Es el Soft Knee a convertir </param>
    /// <returns>Es el parametro convertido a punto fijo</returns>
    /// <remarks></remarks>
    public static double aSoftKneePuntoFijo(double T) {
        return Math.round(T * (Math.pow(2, 23)));
    }

    /// <summary>
    /// Convierte ThresHold a punto fijo
    /// </summary>
    /// <param name="T">Es el ThresHold a convertir</param>
    /// <returns>Es el parametro convertido a punto fijo</returns>
    /// <remarks></remarks>
    public static double aThresHoldPuntoFijo(double T) {
        return Math.round(T * (Math.pow(2, 23)));
    }

    /// <summary>
    /// Convierte Reduction punto fijo a Reduction 
    /// </summary>
    /// <param name="T">Reduction en punto fijo a convertir</param>
    /// <returns>Es el parametro convertido en Reduction</returns>
    /// <remarks></remarks>
    public static double aReduction(double T) {
        return Math.round(20 * (Math.log10(T) - (31 * Math.log10(2))));
    }

    /// <summary>
    /// Convierte punto fijo a Ratio
    /// </summary>
    /// <param name="T">Ratio en punto fijo para convertir</param>
    /// <returns>Es el parametro convertido en Ratio</returns>
    /// <remarks></remarks>
    public static long aRatio(double T) {
        return (Math.round((Math.pow(2, 31)) / (T + (Math.pow(2, 31)))));
    }

    public static float aThresHold(double T) {
        return (Math.round(T / (Math.pow(2, 23))));
    }

    //Convierte punto fijo a Attack
    public static long aAttack(double T) {
        long functionReturnValue = 0;
        if (T == 0) {
            functionReturnValue = 0;
            return functionReturnValue;
        }
        functionReturnValue = Math.round((-16 / 48) / (Math.log(1 - (T / (Math.pow(2, 31))))));
        return functionReturnValue;
    }

    //Convierte punto fijo a SoftKnee
    public static long aSoftKnee(double T) {
        return Math.round(T / (Math.pow(2, 23)));
    }

    public static double aFreq(double B) {
        return (48000 / (2 * Math.PI)) * Math.acos(B / (Math.pow(2, 31)));
    }

    public static double aBndw(double A, double Gain, double Freq) {
        double Sin_Omega_c = 0;
        double g = 0;
        double Bndw = 0;
        double q = 0;
        double q2 = 0;
        double q3 = 0;
        double Omega_c = 0;
        double Omega_3 = 0;

        Omega_c = (2 * Math.PI) * Freq / 48000;
        Sin_Omega_c = Math.sin(Omega_c);

        if (Gain < 0) {
            g = Math.pow(10, (Gain / 20));
            q3 = (Sin_Omega_c / (2 * g)) * (((Math.pow(2, 31)) + A) / ((Math.pow(2, 31)) - A));
        } else {
            q3 = (Sin_Omega_c / 2) * (((Math.pow(2, 31)) + A) / ((Math.pow(2, 31)) - A));
        }

        Omega_3 = -Math.atan((2 * q3 * Cot(Omega_c)) / Math.sqrt(4 * (Math.pow(q3, 2)) + 1)) + Math.atan((2 * q3) / (Math.sin(Omega_c)));

        q2 = (Omega_3 * Omega_c) / ((Math.pow(Omega_c, 2)) - (Math.pow(Omega_3, 2)));

        if (q2 < 0) {
            q = (1 - Math.sqrt(1 + (4 * (Math.pow(q2, 2))))) / (2 * q2);
        } else {
            q = (1 + Math.sqrt(1 + (4 * (Math.pow(q2, 2))))) / (2 * q2);
        }

        Bndw = 2 * (Math.log10(q) / Math.log10(2));

        return Bndw * 1000;

    }

    //Convierte Bndw a punto fijo
    public static double aBndwPuntoFijo(double BndW, double Freq, double Gain) {
        double q = 0;
        double q2 = 0;
        double q3 = 0;
        double q4 = 0;
        double g = 0;
        double a = 0;
        double Omega_3 = 0;
        double Omega_c = 0;

        BndW = BndW / 1000;

        q = Math.pow(2, (BndW / 2));
        q2 = q / (q * q - 1);
        Omega_c = (2 * Math.PI) * Freq / 48000;
        Omega_3 = Omega_c * (Math.sqrt(4 * q2 * q2 + 1) - 1) / (q2 + q2);
        q3 = Math.sin(Omega_3) * Math.sin(Omega_c) / (2 * (Math.cos(Omega_3) - Math.cos(Omega_c)));

        if (Gain < 0) {
            g = Math.pow(10, (Gain / 20));
            q4 = q3 * g;
        } else {
            q4 = q3;
        }

        a = (2 * q4 - Math.sin(Omega_c)) / (2 * q4 + Math.sin(Omega_c));
        a = a * (Math.pow(2, 31));
        return Math.round(a);

    }

    //Convierte Freq a punto fijo
    public static double aFreqPuntoFijo(double T) {
        return Math.round((Math.cos((2 * Math.PI) * T / 48000)) * (Math.pow(2, 31)));
    }

    public static double Cot(double X) {
        return 1 / Math.tan(X);
    }

    public static double aPinkNoisePuntoFijo(double T) {
        double functionReturnValue = 0;
        if (T != -100) {
            functionReturnValue = Math.round(((Math.pow(10, ((T - 23.0103) / 20))) / 16) * (Math.pow(2, 31)));
        } else {
            functionReturnValue = 0;
        }
        return functionReturnValue;
    }

    public static double aPinkNoise(double T) {
        double functionReturnValue = 0;
        if (T != 0) {
            functionReturnValue = (20 * (Math.log10(16 * (T)) - 31 * Math.log10(2)) + 23.0103);


        } else {
            functionReturnValue = -100;
        }
        return functionReturnValue;
    }

    public static double aWhiteNoisePuntoFijo(double T) {
        double functionReturnValue = 0;
        if (T != -100) {
            functionReturnValue = Math.round(((Math.pow(10, ((T - 18.2403) / 20))) / 16) * (Math.pow(2, 31)));
        } else {
            functionReturnValue = 0;
        }
        return functionReturnValue;
    }

    public static double aWhiteNoise(double T) {
        double functionReturnValue = 0;
        if (T != 0) {
            functionReturnValue = (20 * (Math.log10(16 * (T)) - 31 * Math.log10(2)) + 18.2403);
        } else {
            functionReturnValue = -100;
        }
        return functionReturnValue;
    }
    // #endregion
    
    /************************************************************************************************/
    
    /**
     *  Error Generico.
     *  
     *  Cuando es un error no controlado  */
    public static int  ER_GENERICO = 0;
    /**
     *  Ok.
     *  
     *  Todo ha salido correctamente */
    public static int  OK = 1;
    /**
     *  Error de parametros.
     *  
     *  Este error se produce cuando se le ha pasado un parametro erroneo. */
    public static int  ER_PARAMETROS = 2;
    /**
     *  Error equipo desconectado.
     *  
     *  Este error se produce cuando el equipo esta desconectado. */
    public static int  ER_EQUIPO_DESCONECTADO = 3;
    /**
     *  El equipo se esta sincronizando.
     *  
     *  El equipo esta activo y se esta sincronizando puede que devuelve un valor raro. */
    public static int  EQUIPO_SINCRONIZANDOSE = 4;
    /**
     *  Error el equipo tiene una version que no tiene esa funcion.
     *  
     *  El equipo tiene una versión que no tiene esa funcionalidad. */
    public static int  ER_VERSION = 5;
    /**
     *  Identificador para decir que la direccion HMI es de tipo Read-Only
     *  
     *   */
    public static final int TIPO_RO = 1;
    /**
     *  Identificador para decir que la direccion HMI es de tipo Read-Write 
     *  
     *   */
    public static final int TIPO_RW = 2;
    /**
     *  Identificador para decir que la direccion HMI es un Bundle Rx
     *  
     *   */
    public static final int TIPO_RX = 3;
    /**
     *  Identificador para decir que la direccion HMI es un Bundle Tx
     *  
     *   */
    public static final int TIPO_TX = 4;
    /**
     *  Identificador para decir que la direccion HMi es un SubMap del Bundle 1 de Rx
     *  
     *   */
    public static final int TIPO_RXSUBMAPB1 = 5;
    /**
     *  Identificador para decir que la direccion HMi es un SubMap del Bundle 2 de Rx
     *  
     *   */
    public static final int TIPO_RXSUBMAPB2 = 6;
    /**
     *  Identificador para decir que la direccion HMi es un SubMap del Bundle 3 de Rx
     *  
     *   */
    public static final int TIPO_RXSUBMAPB3 = 7;
    /**
     *  Identificador para decir que la direccion HMi es un SubMap del Bundle 4 de Rx
     *  
     *   */
    public static final int TIPO_RXSUBMAPB4 = 8;
    /**
     *  Identificador para decir que la direccino HMI es un SubMap del Bundle 5 de Rx
     *  
     *   */
    public static final int TIPO_RXSUBMAPB5 = 9;
    /**
     *  Identificador para decir que la direccino HMI es un SubMap del Bundle 6 de Rx
     *  
     *   */
    public static final int TIPO_RXSUBMAPB6 = 10;
    /**
     *  Identificador para decir que la direccino HMI es un SubMap del Bundle 7 de Rx
     *  
     *   */
    public static final int TIPO_RXSUBMAPB7 = 11;
    /**
     *  Identificador para decir que la direccino HMI es un SubMap del Bundle 8 de Rx
     *  
     *   */
    public static final int TIPO_RXSUBMAPB8 = 12;
    /**
     *  Identificador para decir que la direccion HMi es un SubMap del Bundle 1 de Tx
     *  
     *   */
    public static final int TIPO_TXSUBMAPB1 = 13;
    /**
     *  Identificador para decir que la direccion HMi es un SubMap del Bundle 2 de Tx
     *  
     *   */
    public static final int TIPO_TXSUBMAPB2 = 14;
    /**
     *  Identificador para decir que la direccion HMi es un SubMap del Bundle 3 de Tx
     *  
     *   */
    public static final int TIPO_TXSUBMAPB3 = 15;
    /**
     *  Identificador para decir que la direccion HMi es un SubMap del Bundle 4 de Tx
     *  
     *   */
    public static final int TIPO_TXSUBMAPB4 = 16;
    /**
     *  Es la base para calcular las direcciones HMI de las variables Read-Only
     */
    public static final int BASE_RO = 499712;
    /**
     *  Es el numero maximo de variables de Read-Only 
     */
    public static final int MAX_RO = 342;
    /**
     *  Es el offset ó desplazamiento para el calculo de las direcciones HMI de las variables Read-Only
     */
    public static final int OFFSET_RO = 3;
    /**
     *  Es el tamaño ó numero de variables Read-Only que vamos a tener.
     *  
     *  Quitando el offset, es decir, desde 0 hasta el tamaño(se hemos quitado el offset) */
    public static final int TAM_RO = ((MAX_RO - OFFSET_RO) + 1);
    /**
     *  Es la base para calcular las direcciones HMI de las variables Read-Write
     */
    public static final int BASE_RW = 483328;
    /**
     *  Es el numero maximo de variables de Read-Write
     */
    public static final int MAX_RW = 1025;
    /**
     *  Es el offset ó desplazamiento para el calculo de las direcciones HMI de las variables Read-Only
     */
    public static final int OFFSET_RW = 0;
    /**
     *  Es el tamaño ó numero de variables Read-Write que vamos a tener.
     *  
     *  Quitando el offset, es decir, desde 0 hasta el tamaño(se hemos quitado el offset) */
    public static final int TAM_RW = ((MAX_RW - OFFSET_RW) + 1);
    /**
     *  Es la base de los bundle Rx, para calcular los demas,es el primer bundle Rx 
     *  
     *   */
    //Base hexadecimal 40100
    public static final int BASE_BUNDLERX = 262400;
    /**
     *  Es la direccion del bundle Rx 1
     */
    public static final int BUNDLERX1_ADDR = 262400;
    /**
     *  Es la direccion del bundle Rx 2
     */
    public static final int BUNDLERX2_ADDR = 266496;
    /**
     *  Es la direccion del bundle Rx 3
     */
    public static final int BUNDLERX3_ADDR = 270592;
    /**
     *  Es la direccion del bundle Rx 4
     */
    public static final int BUNDLERX4_ADDR = 274688;
    /**
     *  Es la direccion del bundle Rx 5
     *  
     *   */
    public static final int BUNDLERX5_ADDR = 278784;
    /**
     *  Es la direccion del bundle Rx 6
     *  
     *   */
    public static final int BUNDLERX6_ADDR = 282880;
    /**
     *  Es la direccion del bundle Rx 7
     *  
     *   */
    public static final int BUNDLERX7_ADDR = 286976;
    /**
     *  Es la direccion del bundle Rx 8
     *  
     *   */
    public static final int BUNDLERX8_ADDR = 291072;
    /**
     *  Es el numero de bundle que tiene el DSP
     *  
     *   */
    public static final int NUM_BUNDLE = 8;
    /**
     *  Es el total de Bundle que se van a utilizar
     *  
     *  Es decir son 4 pero va del 0 al 3 */
    public static final int TMN_BUNDLE = NUM_BUNDLE - 1;
    /**
     *  Es la base de los bundle Tx, para calcular los demas, es el primer bundle Tx
     *  
     *   */
    //Base hexadecimal 50100
    public static final int BASE_BUNDLETX = 327936;
    /**
     *  Es la direccion del bundle Tx 1
     */
    public static final int BUNDLETX1_ADDR = 327936;
    /**
     *  Es la direccion del bundle Tx 2
     */
    public static final int BUNDLETX2_ADDR = 332032;
    /**
     *  Es la direccion del bundle Tx 3
     */
    public static final int BUNDLETX3_ADDR = 336128;
    /**
     *  Es la direccion del bundle Tx 4
     */
    public static final int BUNDLETX4_ADDR = 340224;
    /**
     *  ES el nunmero de canales que tiene cada bundle
     *  
     *   */
    public static final int NUM_CANALES_BUNDLE = 8;
    /**
     *  Es el total de canales que tiene un Bundle
     *  
     *  Es decir es el numero de canales que tiene un bundle, pero que va del 0 al numero de canales menos 1, simplemente para que empiece en cero */
    public static final int TMN_CANALES_BUNDLE = NUM_CANALES_BUNDLE - 1;
    /**
     *  Base para calcular el rxSubMapB1, es decir, es la base del sub-map del Rx1
     */
    //Base hexadecimal 40200
    public static final int BASE_RXSUBMAPB1 = 262656;
    /**
     *  Base para calcular el rxSubMapB2, es decir, es la base del sub-map del Rx2
     */
    //Base hexadecimal 41200
    public static final int BASE_RXSUBMAPB2 = 266752;
    /**
     *  Base para calcular el rxSubMapB3, es decir, es la base del sub-map del Rx13
     */
    //Base hexadecimal 42200
    public static final int BASE_RXSUBMAPB3 = 270848;
    /**
     *  Base para calcular el rxSubMapB4, es decir, es la base del sub-map del Rx4 
     */
    //Base hexadecimal 43200
    public static final int BASE_RXSUBMAPB4 = 274944;
    /**
     *  Base para calcular el rxSubMapB5, es decir, es la base del sub-map del Rx5
     */
    //Base hexadecimal 44200
    public static final int BASE_RXSUBMAPB5 = 279040;
    /**
     *  Base para calcular el rxSubMapB5, es decir, es la base del sub-map del Rx6
     */
    //Base hexadecimal 45200
    public static final int BASE_RXSUBMAPB6 = 283136;
    /**
     *  Base para calcular el rxSubMapB5, es decir, es la base del sub-map del Rx7
     */
    //Base hexadecimal 46200
    public static final int BASE_RXSUBMAPB7 = 287232;
    /**
     *  Base para calcular el rxSubMapB5, es decir, es la base del sub-map del Rx8
     */
    //Base hexadecimal 47200
    public static final int BASE_RXSUBMAPB8 = 291328;
    /**
     *  Base para calcular el TxSubMapB1, es decir, es la base del sub-map del Tx1
     */
    //Base hexadecimal 50200
    public static final int BASE_TXSUBMAPB1 = 328192;
    /**
     *  Base para calcular el TxSubMapB2, es decir, es la base del sub-map del Tx2
     */
    //Base hexadecimal 51200
    public static final int BASE_TXSUBMAPB2 = 332288;
    /**
     *  Base para calcular el TxSubMapB3, es decir, es la base del sub-map del Tx3
     */
    //Base hexadecimal 52200
    public static final int BASE_TXSUBMAPB3 = 336384;
    /**
     *  Base para calcular el rTSubMapB4, es decir, es la base del sub-map del Tx4 
     */
    //Base hexadecimal 53200
    public static final int BASE_TXSUBMAPB4 = 340480;
    /**
     *  Numero maximo de salidas que tiene el equipo
     */
    public static final int MAX_SALIDA = 16;
    /**
     *  Numero minimo de salidas que tiene el equipo
     */
    public static final int MIN_SALIDA = 1;
    /**
     *  Constantes para la numeracion de las entradas.
     *  
     *  Indica la primera entrada del equipo */
    public static final int MIN_ENTRADA = 1;
    /**
     *  Constantes para la numeracion de las entradas.
     *  
     *  Indica la ultima entrada del equipo */
    public static final int MAX_ENTRADA = 16;
    /**
     *  Constantes para la numeracion de las entradas.
     *  
     *  Indica el ultimo canal fisico. */
    public static final int ULTIMO_CANAL_FISICO = 8;
    //Ganancia Mínima
    public static final int MIN_GANANCIA = -100;
    //Ganancia Máxima
    public static final int MAX_GANANCIA = 12;
    //Tono Minimo
    public static final int MIN_TONO = -100;
    //Tono Maximo
    public static final int MAX_TONO = 0;
    //Tono Master Minimo
    public static final int MIN_TONO_MASTER = -100;
    //Tono Master Maximo
    public static final int MAX_TONO_MASTER = 20;
    //Tono Frecuencia Minima
    public static final int MIN_TONO_FREC = 20;
    //Tono Frecuencia Maximo
    public static final int MAX_TONO_FREC = 20000;
    public static final int RX_BUNDLE1 = 1;
    public static final int RX_BUNDLE2 = 2;
    public static final int RX_BUNDLE3 = 3;
    public static final int RX_BUNDLE4 = 4;
    public static final int RX_BUNDLE5 = 5;
    public static final int RX_BUNDLE6 = 6;
    public static final int RX_BUNDLE7 = 7;
    public static final int RX_BUNDLE8 = 8;
    public static final int MAX_RX_BUNDLE = RX_BUNDLE8;
    public static final int MIN_RX_BUNDLE = RX_BUNDLE1;
    public static final int MIN_VALOR_BUNDLE = 0;
    public static final int MAX_VALOR_BUNDLE = 65535;
    public static final int TX_BUNDLE1 = 1;
    public static final int TX_BUNDLE2 = 2;
    public static final int TX_BUNDLE3 = 3;
    public static final int TX_BUNDLE4 = 4;
    public static final int MAX_TX_BUNDLE = TX_BUNDLE4;
    public static final int MIN_TX_BUNDLE = TX_BUNDLE1;
    //Rango de los posibles valores de todos los transmisores
//    public static final int MAX_VALOR_TX_SUB_CANAL = CobraNetUtil.V8_TX1_SUB_CANAL;
//    public static final int MIN_VALOR_TX_SUB_CANAL = CobraNetUtil.V0_TX1_SUB_CANAL;
    /**
     *  Es el numero de cierres que tiene el equipo
     *  
     *   */
    public static final int CIERRE1 = 1;
    public static final int CIERRE2 = 2;
    public static final int CIERRE3 = 3;
    public static final int CIERRE4 = 4;
    public static final int CIERRE5 = 5;
    public static final int CIERRE6 = 6;
    public static final int CIERRE7 = 7;
    public static final int CIERRE8 = 8;
    public static final int CIERRE9 = 9;
    public static final int CIERRE10 = 10;
    public static final int CIERRE11 = 11;
    public static final int CIERRE12 = 12;
    public static final int CIERRE13 = 13;
    public static final int CIERRE14 = 14;
    public static final int CIERRE15 = 15;
    public static final int CIERRE16 = 16;
    public static final int NUMERO_CIERRES = CIERRE16;
    /**
     *  Son los posibles valores que puede tener el evento PeticionMicrofonos
     *  
     *  No tiene ninguna peticion. */
    public static final int SIN_PETICION = 0;
    /**
     *  Son los posibles valores que puede tener el evento PeticionMicrofonos
     *  
     *  Tiene una peticion de palabra. */
    public static final int PETICION_PALABRA = 1;
    /**
     *  Son los posibles valores que puede tener el evento PeticionMicrofonos
     *  
     *  Tiene una peticion de un mensaje. */
    public static final int PETICION_MENSAJE = 2;
    /**
     *  Es para saber que version tiene el ZES8s02.
     *  
     *  Es el primer Numero de la versión */
    public static final int VERSION1 = 2;
    /**
     *  Es para saber que version tiene el ZES8s02.
     *  
     *  Es el segundo Numero de la versión. */
    public static final int VERSION2 = 1;
    /**
     *  Es para saber que version tiene el ZES8s02.
     *  
     *  Es el tercer Numero de la versión. */
    public static final int VERSION3 = 0;
    /**
     *  Es para saber que version tiene el ZESs02
     *  
     *  Es la primer numero de versión que tiene el ZES, lo utilizo para el comando de gestión automatica de microfonos. */
    public static final int VERSION1_CMD_N = 2;
    /**
     *  Es para saber que versión tiene el ZESs80s02
     *  
     *  Es el segundo Numero de la versión, lo utilizo para el comando de gestión automatica de microfonos. */
    public static final int VERSION2_CMD_N = 3;
    /**
     *  Es para saber que versión tiene el ZESs80s02
     *  
     *  Es el tercer Numero de la versión, lo utilizo para el comando de gestión automatica de microfonos. */
    public static final int VERSION3_CMD_N = 0;
    //  "COMANDOS DEL EQUIPO"
    /**
     *  Sepradador del comando, por si tiene mas de un paremetro
     *  
     *  Solo se esta utilizando para el comando del HMI */
    public static final String SEPARADOR = config.getString("SEPARADOR");
    /**
     *  Caracter de terminacion del comando 
     *  
     *   */
    public static final String FIN_COMANDO = config.getString("FIN_COMANDO");
    /**
     *  Es el principio del comando que consulta ó asigna datos al HMI 
     *  
     *  Si esta en Mayuscalas Asigna y si esta en Minusculas consulta. */
    public static final String COMANDO_HMI = config.getString("COMANDO_HMI");
    /**
     *  Es el comando de error
     *  
     *  El equipo devuelve este comando cuando hay algun tipo de error ya sea comando equivocado u otro error. */
    public static final String COMANDO_ERR = config.getString("COMANDO_ERR");
    /**
     *  Es el principio, identificador ó cabecera del comando IP
     *  
     *  Si esta en Mayusculas Asigna y si esta en Minusculas Consulta */
    public static final String COMANDO_IP = config.getString("COMANDO_IP");
    /**
     *  Es el principio, identificador ó cabecera del comando MAC
     *  
     *  Si esta en Mayusculas Asigna y si esta en Minusculas Consulta */
    public static final String COMANDO_MAC = config.getString("COMANDO_MAC");
    /**
     *  Es el principio, identificador ó cabecera del comando SUBRED
     *  
     *  Si esta en Mayusculas Asigna y si esta en Minusculas Consulta */
    public static final String COMANDO_SUBRED = config.getString("COMANDO_SUBRED");
    /**
     *  Es el principio, identificador ó cabecera del comando Puerta enlace
     *  
     *  Si esta en Mayusculas Asigna y si esta en Minusculas Consulta */
    public static final String COMANDO_PUERTA_ENLACE = config.getString("COMANDO_PUERTA_ENLACE");
    /**
     *  Es el principio, identificador ó cabecer del comando que nos muestra los flags de sincronización de las variables de Read-Only y Read-Write del HMI
     *  
     *  Si esta en Mayusculas Asigna y si esta en Minusculas Consula */
    public static final String COMANDO_FLAG_SINCRONIZACION = config.getString("COMANDO_FLAG_SINCRONIZACION");
    /**
     *  Es el principio, identificador ó cabecera del comando que hacemos una peticion de solicitud de sincronizacion de la variable Read-Only ó Read-Write del HMI
     *  
     *  Si esta en Mayusculas Asigna y si esta en Minusculas Consula, Este comando solo esta para la asignacion, es decir, en minustula te daria un error */
    public static final String COMANDO_PETICION_SINCRONIZACION = config.getString("COMANDO_PETICION_SINCRONIZACION");
    /**
     *  Es el principio, identificador o cabcera del comando que hacemos una peticion de solicitud de guardar o borrar un preset 
     *  
     *  Si esta en Mayusculas Asigna y si esta en Minusculas Consula, Este comando solo esta para la asignacion, es decir, en minustula te daria un error */
    public static final String COMANDO_PRESET = config.getString("COMANDO_PRESET");
    /**
     *  Es el principio, identificador o cabecera del comando que hacemos una peticion de monitorizacion de datos y flag del equipo.
     *  
     *  si esta en mayusculas Asigna y si esta en Minusculas Consulta. Ojo este comando solo esta en minusculas. */
    public static final String COMANDO_MONITOR = config.getString("COMANDO_MONITOR");
    /**
     *  Es el principio, identificador o cabecera del comando que hacemos activamos o desactivamos un cierre
     *  
     *  Si esta en mayusculas Asigna y si esta en Minusculas Consula. Ojo este comando solo esta en mayusculas. */
    public static final String COMANDO_CIERRE = config.getString("COMANDO_CIERRE");
    /**
     *  Es el principio, identificacdor o cabecera del comando que hacemos una configuracion del cierre. 
     *  
     *  Si esta en mayusculas Asigna y si esta en Minusculas consulta. Ojo este comando solo esta en mayusculas */
    public static final String COMANDO_CONFIG_CIERRE = config.getString("COMANDO_CONFIG_CIERRE");
    /**
     *  Es el principio, identificador o cabecera del comando que hacemos una peticion de activar o desactivar el amplificador para el monitor
     *  
     *  si esta en Mayusculas Asigna y si esta en Minusculas Consulta. */
    public static final String COMANDO_AMP = config.getString("COMANDO_AMP");
    /**
     *  Es el principio, identificador o cabecera del comando que hacemos una peticion de reset 
     *  
     *  si esta en Mayusculas Asigna y si esta en Minusculas Consulta. */
    public static final String COMANDO_RESET = config.getString("COMANDO_RESET");
    /**
     *  Es el principio, identificador o cabecera del comando que hacemos una peticion de activar o desactivar el mp3 
     *  
     *  si esta en Mayusculas Asigna y si esta en Minusculas Consulta. */
    public static final String COMANDO_MP3 = config.getString("COMANDO_MP3");
    /**
     *  Es el principio, identificador o cabecera del comando que hacemos una peticion de activar o desactivar el atenuador 
     *  
     *  si esta en Mayusculas Asigna y si esta en Minusculas Consulta. */
    public static final String COMANDO_ATENUADOR = config.getString("COMANDO_ATENUADOR");
    /**
     *  Es el principio, identificador o cabecera del comando que configura si se activa o desactiva el gestor automatico de microfonos.
     *  
     *   */
    public static final String COMANDO_SET_MIC = config.getString("COMANDO_SET_MIC");
    /**
     *  Es el principio, identificador o cabecera del comando que configura si se activa o desactiva los atenuadores cuando esta configurado el gestor automático de micrófonos.
     *  
     *   */
    public static final String COMANDO_SET_ATEN = config.getString("COMANDO_SET_ATEN");
    /**
     *  Es el principio, identificador o cabecera del comando que configura si se activa o desactiva las comunicaciones 485 ó 232.
     *  
     *   */
    public static final String COMANDO_UART1 = config.getString("COMANDO_UART1");
    //  "Constantes ó Identificador de los procesos que tiene la libreria"
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificado para la funcion PStart */
    public static final int P_INICIALIZACION = 0;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificado para la funcion PStart */
    public static final int P_START = 1;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificador del proceso Pfinish */
    public static final int P_FINISH = 2;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificador del proceso PDSPActivo */
    public static final int P_DSPACTIVO = 3;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificador del proceso PGETVUMETROCE */
    public static final int P_SETBUNDLEENTRADA = 4;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificador del proceso PSETBUNDLESALIDA */
    public static final int P_SETBUNDLESALIDA = 5;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificador del proceso PGETBUNDLEENTRADA */
    public static final int P_GETBUNDLEENTRADA = 6;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificador del proceso PGETBUNDLESALIDA */
    public static final int P_GETBUNDLESALIDA = 7;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificador del proceso PGETCLIPCFE */
    public static final int P_GETCLIPCFE = 8;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificador del proceso PGETGANANCIACFE */
    public static final int P_GETGANANCIACFE = 9;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificador del proceso PSETGANANCIACFE */
    public static final int P_SETGANANCIACFE = 10;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificador del proceso PGETCLIPCFS */
    public static final int P_GETCLIPCFS = 11;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificador del proceso PGETGANANCIACFS */
    public static final int P_GETGANANCIACFS = 12;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificador del proceso PSETGANANCIACFS */
    public static final int P_SETGANANCIACFS = 13;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificador del proceso PSETSALIDAFISICA */
    public static final int P_SETSALIDAFISICA = 14;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificador del proceso PGETSALIDAFISICA */
    public static final int P_GETSALIDAFISICA = 15;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificador del proceso PSETSALIDACOBRANET */
    public static final int P_SETSALIDACOBRANET = 16;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificador del proceso PGETSALIDACOBRANET */
    public static final int P_GETSALIDACOBRANET = 17;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificador del proceso PSETTONO */
    public static final int P_SETTONO = 18;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificador del proceso PGETTONO */
    public static final int P_GETTONO = 19;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificador del proceso PGETTXSUBMAP */
    public static final int P_GETTXSUBMAP = 20;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificador del proceso PSETTXSUBMAP */
    public static final int P_SETTXSUBMAP = 21;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificador del proceso PGETRXSUBMAP */
    public static final int P_GETRXSUBMAP = 22;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificador del proceso PSETRXSUBMAP */
    public static final int P_SETRXSUBMAP = 23;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificador del proceso PGETPRESENCIACE */
    public static final int P_GETPRESENCIACE = 24;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificador del proceso PGETVUMETROCE */
    public static final int P_GETVUMETROCE = 25;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificador del proceso PGETPRESENCIACS */
    public static final int P_GETPRESENCIACS = 26;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificador del proceso PGETVUMETROCS */
    public static final int P_GETVUMETROCS = 27;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificador del proceso PSETSALIDA */
    public static final int P_SETSALIDA = 28;
    /**
     *  Identificador del proceso para los eventos de esta clase
     *  
     *  Identificador del proceso PGETSALIDA */
    public static final int P_GETSALIDA = 29;
    //Correccion CAG
    public static final int P_SETGANANCIAIFS = 30;
    /**
     *  Identificador del proceso para los eventos de la clase 
     */
    public static final int P_ADDRESS_IP = 31;
    /**
     *  Identificador del proceso para los eventos de la clase
     */
    public static final int P_SUBRED = 32;
    /**
     *  Identificador del proceso para los eventos de la clase
     */
    public static final int P_ADDRES_MAC = 33;
    /**
     *  Identificador del proceso para los eventos de la clase
     */
    public static final int P_PUERTA_ENLACE = 34;
    /**
     *  Identificador del proceso para los envios de la clase
     *  
     *  Indentificador del proceso de PGetDatoHMI */
    public static final int P_GET_DATO_HMI = 35;
    /**
     *  Identificador del proceso para los envios de la clase
     *  
     *  Identificador del proceso de PSetDatoHMI */
    public static final int P_SET_DATO_HMI = 36;
    /**
     *  Identificador del proceso para los envios de la clase
     *  
     *  Identificador del proceso de PSetPreset. */
    public static final int P_SET_PRESET = 37;
    /**
     *  Identificador del proceso para los envios de la clase.
     *  
     *  Identificador del proceso de PSetAmplificador */
    public static final int P_SET_AMPLIFICADOR = 38;
    /**
     *  Identificador del proceso para los envios de la clase.
     *  
     *  Identificador del proceso de PSetCierre. */
    public static final int P_SET_CIERRE = 39;
    /**
     *  Identificador del proceso para los envios de la clase.
     *  
     *  Identificador del proceso de PSetConfigCierre. */
    public static final int P_SET_CONFIG_CIERRE = 40;
    /**
     *  Identificador del proceso para los envios de la clase.
     *  
     *  Identificador del proceso de PSetAtenuador24V */
    public static final int P_SET_ATENUADOR = 41;
    /**
     *  Identificador del proceso para los envios de la clase.
     *  
     *  Identificador del proceso de PSetReset */
    public static final int P_SET_RESET = 42;
    /**
     *  Identificador del proceso para los envios de la clase.
     *  
     *  Identificador del proceso de PSetMP3 */
    public static final int P_SET_MP3 = 43;
    /**
     *  Identificador del proceso para los envios de la clase.
     *  
     *  Identificador del proceso de PSetTonoMaster. */
    public static final int P_SET_TONO_MASTER = 44;
    /**
     *  Identificador del proceso para los envios de la clase.
     *  
     *  Identificador del proceso de PGetTonoMaster. */
    public static final int P_GET_TONO_MASTER = 45;
    /**
     *  Identificador del proceso para los envios de la clase.
     *  
     *  Identificador del proceso de PSetTonoFrec. */
    public static final int P_SET_TONO_FREC = 46;
    /**
     *  Identificador del proceso para los envios de la clase.
     *  
     *  Identificador del proceso de PGetTonoFrec. */
    public static final int P_GET_TONO_FREC = 47;
    public static final int P_GET_COMPRESOR_THRESHOLD = 48;
    public static final int P_GET_COMPRESOR_RATIO = 49;
    public static final int P_GET_COMPRESOR_ATTACK = 50;
    public static final int P_GET_COMPRESOR_RELEASE = 51;
    public static final int P_GET_COMPRESOR_SOFTKNEE = 52;
    public static final int P_GET_COMPRESOR_BYPASS = 53;
    public static final int P_GET_LIMITADOR_THRESHOLD = 54;
    public static final int P_GET_LIMITADOR_RATIO = 55;
    public static final int P_GET_LIMITADOR_ATTACK = 56;
    public static final int P_GET_LIMITADOR_RELEASE = 57;
    public static final int P_GET_LIMITADOR_SOFTKNEE = 58;
    public static final int P_GET_LIMITADOR_BYPASS = 59;
    /**
     *  Identificador del proceso para los envios de la clase.
     *  
     *  Identificador del proceso de  PSetConfigMicrosTipoA1 */
    public static final int P_SET_MIC = 60;
    /**
     *  Identificador del proceso para los envios de la clase.
     *  
     *  Identificador del proceso de PSetComunicaciones485 */
    public static final int P_SET_UART1 = 61;
    /**
     *  Identificador del proceso para los envios de la clase.
     *  
     *  Identificador del proceso de PSetConfigAtenuadores. */
    public static final int P_SET_ATEN = 62;

    
    
}
