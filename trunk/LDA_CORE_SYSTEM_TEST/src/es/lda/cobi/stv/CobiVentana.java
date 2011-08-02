package es.lda.cobi.stv;

import es.lda.core.exception.DriverException;
import es.lda.core.exception.UnsupportedDriverOperation;
import es.lda.core.lib.driver.IDriver;
import es.lda.core.lib.driver.stv.STV;
import es.lda.core.lib.driver.stv.impl.STVImpl;
import es.lda.core.lib.driver.stv.impl.STVInfo;
import es.lda.core.lib.plugin.PluginFinder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class CobiVentana extends javax.swing.JFrame {

    private static final ResourceBundle config = ResourceBundle.getBundle("resources.config");
    private final String VERDE = config.getString("OK_COLOR");
    private final String ROJO = config.getString("ERROR_COLOR");
    public static IDriver etapa = null; //new STVImpl();
    private boolean Automatico = false;
    private boolean Conectado = false;
    private Timer tmrConectado;
    private Timer tmrRefresco;
    private DefaultListModel listincidencias = new DefaultListModel();
    /** Logger. */
    private static Logger logger = Logger.getLogger(CobiVentana.class);

    public CobiVentana() {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //getContentPane().setBackground(Color.decode(VERDE));       
        lblLink.setBackground(Color.WHITE);
        lblLink.setBorder(BorderFactory.createLineBorder(Color.black));
        jPanel11.setBorder(new TitledBorder(new LineBorder(Color.cyan, 0), config.getString("STV_MODEL")));
        jPanel12.setBorder(new TitledBorder(new LineBorder(Color.cyan, 0), config.getString("ACTIONS")));
        jPanel13.setBorder(new TitledBorder(new LineBorder(Color.red, 0), config.getString("ERRORS")));
        jPanel14.setBorder(new TitledBorder(new LineBorder(Color.yellow, 0), config.getString("POWER_SUPPLY")));
        jPanel15.setBorder(new TitledBorder(new LineBorder(Color.red, 0), config.getString("LOG")));
        jPanel16.setBorder(new TitledBorder(new LineBorder(Color.red, 0), config.getString("LIMITER_CH")));
        jPanel17.setBorder(new TitledBorder(new LineBorder(Color.yellow, 0), config.getString("INFOR")));
        this.pack();
        this.setResizable(false);
    }

    public CobiVentana(String lNF) {
        if (!lNF.isEmpty()) {
            try {
                UIManager.setLookAndFeel(lNF);
            } catch (ClassNotFoundException ex) {
                logger.error(ex);
            } catch (InstantiationException ex) {
                logger.error(ex);
            } catch (IllegalAccessException ex) {
                logger.error(ex);
            } catch (UnsupportedLookAndFeelException ex) {
                logger.error(ex);
            }
        }

        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //getContentPane().setBackground(Color.decode(VERDE));       
//            lblLink.setBackground(Color.decode(VERDE));
//            lblLink.setBorder(BorderFactory.createLineBorder(Color.black));
        lblLink.setBackground(Color.WHITE);
        lblLink.setBorder(BorderFactory.createLineBorder(Color.black));
        jPanel11.setBorder(new TitledBorder(new LineBorder(Color.cyan, 0), config.getString("STV_MODEL")));
        jPanel12.setBorder(new TitledBorder(new LineBorder(Color.cyan, 0), config.getString("ACTIONS")));
        jPanel13.setBorder(new TitledBorder(new LineBorder(Color.red, 0), config.getString("ERRORS")));
        jPanel14.setBorder(new TitledBorder(new LineBorder(Color.yellow, 0), config.getString("POWER_SUPPLY")));
        jPanel15.setBorder(new TitledBorder(new LineBorder(Color.red, 0), config.getString("LOG")));
        jPanel16.setBorder(new TitledBorder(new LineBorder(Color.red, 0), config.getString("LIMITER_CH")));
        jPanel17.setBorder(new TitledBorder(new LineBorder(Color.yellow, 0), config.getString("INFOR")));
        this.pack();
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel19 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIP = new javax.swing.JTextField();
        btnConnect = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        btBorraIncidencias = new javax.swing.JButton();
        btBorrarLogo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        rb2200 = new javax.swing.JRadioButton();
        rb2400 = new javax.swing.JRadioButton();
        rb2800 = new javax.swing.JRadioButton();
        rb4200 = new javax.swing.JRadioButton();
        rb4400 = new javax.swing.JRadioButton();
        chkSDCard = new javax.swing.JCheckBox();
        chkCobraNet = new javax.swing.JCheckBox();
        jPanel12 = new javax.swing.JPanel();
        chkPower_On = new javax.swing.JCheckBox();
        chkConfiguracionEntradaDigital = new javax.swing.JCheckBox();
        ckEnableEtherNet = new javax.swing.JCheckBox();
        btnReset = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        chkErrRAM = new javax.swing.JCheckBox();
        chkErrCobraNet = new javax.swing.JCheckBox();
        chkErr3008 = new javax.swing.JCheckBox();
        chkErrTempETX = new javax.swing.JCheckBox();
        jPanel14 = new javax.swing.JPanel();
        chkErr230V = new javax.swing.JCheckBox();
        chkErr230I = new javax.swing.JCheckBox();
        chkErrVP1 = new javax.swing.JCheckBox();
        chkErr12V = new javax.swing.JCheckBox();
        chkErrVP2 = new javax.swing.JCheckBox();
        chkErrCarga = new javax.swing.JCheckBox();
        chkErrComunicacion = new javax.swing.JCheckBox();
        chkErrMod1 = new javax.swing.JCheckBox();
        chkErrMod2 = new javax.swing.JCheckBox();
        ChkErrFrontal = new javax.swing.JCheckBox();
        chkErrSobreTempETX = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        chkPresetsPrio = new javax.swing.JCheckBox();
        btnCargaDefault = new javax.swing.JButton();
        btnGuardarDefault = new javax.swing.JButton();
        btnCargarFabrica = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        nudChannel = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        tkbGainLinearInput1 = new javax.swing.JSlider();
        jLabel7 = new javax.swing.JLabel();
        lblGainLinearInput1 = new javax.swing.JLabel();
        tkbGainInput1 = new javax.swing.JSlider();
        lblGainInput1 = new javax.swing.JLabel();
        chkMute = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        tkbGainOutput1 = new javax.swing.JSlider();
        lblGainOutput1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        nudEqInputBand1 = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        nudEqInputBoost1 = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();
        nudEqInputFreq1 = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        nudEqInputQ_Slope1 = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        tkbEqInputGain1 = new javax.swing.JSlider();
        jLabel18 = new javax.swing.JLabel();
        nudEqInputEnable1 = new javax.swing.JSpinner();
        lblEqInputGain1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        nudEnableLoudNess1 = new javax.swing.JSpinner();
        jPanel6 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        nudTCLimiter1 = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        nudDecayLimiter1 = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        nudThresHoldLimiter1 = new javax.swing.JSpinner();
        jLabel19 = new javax.swing.JLabel();
        nudEnableLimiter1 = new javax.swing.JSpinner();
        jPanel7 = new javax.swing.JPanel();
        tkbGainInputPrio = new javax.swing.JSlider();
        tkbFilterPrioGain = new javax.swing.JSlider();
        tkbGainLinearInputPrio = new javax.swing.JSlider();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblGainLinearInputPrio = new javax.swing.JLabel();
        lblGainInputPrio = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        nudFilterPrioBoost = new javax.swing.JSpinner();
        jLabel28 = new javax.swing.JLabel();
        nudFilterPrioFreq = new javax.swing.JSpinner();
        jLabel29 = new javax.swing.JLabel();
        nudFilterPrioQ_Slope = new javax.swing.JSpinner();
        jLabel30 = new javax.swing.JLabel();
        lblFilterPrioGain = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        tkbGainFilter1 = new javax.swing.JSlider();
        tkbGainTone1 = new javax.swing.JSlider();
        tkbDC1 = new javax.swing.JSlider();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        nudFreqFilter1 = new javax.swing.JSpinner();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        nudEnableFilter1 = new javax.swing.JSpinner();
        lblGainFilter1 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        nudFreqTone1 = new javax.swing.JSpinner();
        jLabel36 = new javax.swing.JLabel();
        lblGainTone1 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        nudEnableTone1 = new javax.swing.JSpinner();
        jLabel39 = new javax.swing.JLabel();
        lblDC1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        chkCobraNetPrio = new javax.swing.JCheckBox();
        jLabel33 = new javax.swing.JLabel();
        nudAddr_bundle = new javax.swing.JSpinner();
        jLabel37 = new javax.swing.JLabel();
        nudInput_channel = new javax.swing.JSpinner();
        jLabel40 = new javax.swing.JLabel();
        txtCobraNetNombreFuente = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        txtCobraNetNombreZona = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        chkEnableCobraNetPrio = new javax.swing.JCheckBox();
        chkManiobra5vPrio = new javax.swing.JCheckBox();
        chkPuertaRuidoPrio = new javax.swing.JCheckBox();
        jLabel42 = new javax.swing.JLabel();
        nudUmbralPuertaRuido = new javax.swing.JSpinner();
        jLabel43 = new javax.swing.JLabel();
        lblclave = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        lblTemp = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        lbltempplaca = new javax.swing.JLabel();
        nudDelayArranque = new javax.swing.JSpinner();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        lblTempAmbiente = new javax.swing.JLabel();
        lblMuestras = new javax.swing.JLabel();
        lblLink = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = config; // NOI18N
        setTitle(bundle.getString("STV")); // NOI18N
        setBackground(java.awt.SystemColor.activeCaptionBorder);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jButton1.setText(bundle.getString("SALIR")); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jTabbedPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jLabel1.setText(bundle.getString("IP")); // NOI18N

        txtIP.setText(bundle.getString("DEFAULT_IP")); // NOI18N
        txtIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIPActionPerformed(evt);
            }
        });

        btnConnect.setText(bundle.getString("CONECT")); // NOI18N
        btnConnect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConnectMouseClicked(evt);
            }
        });

        jLabel2.setText(bundle.getString("BUGS")); // NOI18N

        jScrollPane1.setViewportView(jList1);

        btBorraIncidencias.setText(bundle.getString("BUGS_DELETE")); // NOI18N
        btBorraIncidencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btBorraIncidenciasMouseClicked(evt);
            }
        });

        btBorrarLogo.setText(bundle.getString("LOGO_DELETE")); // NOI18N
        btBorrarLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btBorrarLogoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btBorraIncidencias)
                        .addGap(26, 26, 26)
                        .addComponent(btBorrarLogo))
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnConnect))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(412, 412, 412))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConnect))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btBorraIncidencias)
                    .addComponent(btBorrarLogo))
                .addGap(104, 104, 104))
        );

        jTabbedPane1.addTab("Conexion", jPanel1);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Modelo STV"));

        rb2200.setText(bundle.getString("2_X_200")); // NOI18N
        rb2200.setOpaque(false);
        rb2200.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rb2200ItemStateChanged(evt);
            }
        });

        rb2400.setText(bundle.getString("2_X_400")); // NOI18N
        rb2400.setOpaque(false);
        rb2400.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rb2400ItemStateChanged(evt);
            }
        });

        rb2800.setText(bundle.getString("2_X_800")); // NOI18N
        rb2800.setOpaque(false);
        rb2800.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rb2800ItemStateChanged(evt);
            }
        });

        rb4200.setText(bundle.getString("4_X_200")); // NOI18N
        rb4200.setOpaque(false);
        rb4200.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rb4200ItemStateChanged(evt);
            }
        });

        rb4400.setText(bundle.getString("4_X_400")); // NOI18N
        rb4400.setOpaque(false);
        rb4400.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rb4400ItemStateChanged(evt);
            }
        });

        chkSDCard.setText(bundle.getString("SD_CARD")); // NOI18N
        chkSDCard.setOpaque(false);
        chkSDCard.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkSDCardItemStateChanged(evt);
            }
        });

        chkCobraNet.setText(bundle.getString("COBRANET")); // NOI18N
        chkCobraNet.setOpaque(false);
        chkCobraNet.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkCobraNetItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb4200)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rb2400)
                            .addComponent(rb2200)
                            .addComponent(rb2800))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkCobraNet)
                            .addComponent(chkSDCard))))
                .addContainerGap())
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(rb4400)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(rb2200)
                .addGap(3, 3, 3)
                .addComponent(rb2400)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb2800)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb4200)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb4400))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(chkSDCard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkCobraNet))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

        chkPower_On.setText(bundle.getString("POWER_ON")); // NOI18N
        chkPower_On.setOpaque(false);
        chkPower_On.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkPower_OnItemStateChanged(evt);
            }
        });

        chkConfiguracionEntradaDigital.setText(bundle.getString("DIGITAL_INPUT")); // NOI18N
        chkConfiguracionEntradaDigital.setOpaque(false);
        chkConfiguracionEntradaDigital.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkConfiguracionEntradaDigitalItemStateChanged(evt);
            }
        });

        ckEnableEtherNet.setText(bundle.getString("ETHERNET_ENABLE")); // NOI18N
        ckEnableEtherNet.setOpaque(false);
        ckEnableEtherNet.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckEnableEtherNetItemStateChanged(evt);
            }
        });

        btnReset.setText(bundle.getString("RESET")); // NOI18N
        btnReset.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkPower_On)
                    .addComponent(chkConfiguracionEntradaDigital)
                    .addComponent(ckEnableEtherNet))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(chkPower_On)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkConfiguracionEntradaDigital)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ckEnableEtherNet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(239, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(337, 337, 337))
        );

        jTabbedPane1.addTab("Opciones", jPanel2);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Errores"));

        chkErrRAM.setText(bundle.getString("RAM")); // NOI18N
        chkErrRAM.setOpaque(false);

        chkErrCobraNet.setText(bundle.getString("COBRANET")); // NOI18N
        chkErrCobraNet.setOpaque(false);

        chkErr3008.setText(bundle.getString("POWER_SENSING")); // NOI18N
        chkErr3008.setOpaque(false);

        chkErrTempETX.setText(bundle.getString("TEMP_ETX_SENSING")); // NOI18N
        chkErrTempETX.setOpaque(false);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Fuente de Alimentacion"));

        chkErr230V.setText("230 V");
        chkErr230V.setOpaque(false);

        chkErr230I.setText("230 I");
        chkErr230I.setOpaque(false);

        chkErrVP1.setText(bundle.getString("VP1")); // NOI18N
        chkErrVP1.setOpaque(false);

        chkErr12V.setText("12 V");
        chkErr12V.setOpaque(false);

        chkErrVP2.setText(bundle.getString("VP2")); // NOI18N
        chkErrVP2.setOpaque(false);

        chkErrCarga.setText(bundle.getString("LOAD")); // NOI18N
        chkErrCarga.setOpaque(false);

        chkErrComunicacion.setText(bundle.getString("CONTROL")); // NOI18N
        chkErrComunicacion.setOpaque(false);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkErr12V)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkErr230V)
                            .addComponent(chkErr230I))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(chkErrVP2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkErrComunicacion))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(chkErrVP1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkErrCarga)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkErr230V)
                    .addComponent(chkErrVP1)
                    .addComponent(chkErrCarga))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkErr230I)
                    .addComponent(chkErrVP2)
                    .addComponent(chkErrComunicacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chkErr12V))
        );

        chkErrMod1.setText(bundle.getString("CONTROL_CH_1_2")); // NOI18N
        chkErrMod1.setOpaque(false);

        chkErrMod2.setText(bundle.getString("CONTROL_CH_3_4")); // NOI18N
        chkErrMod2.setOpaque(false);

        ChkErrFrontal.setText(bundle.getString("FRONT_CONTROL")); // NOI18N
        ChkErrFrontal.setOpaque(false);

        chkErrSobreTempETX.setText(bundle.getString("OVER_TEMP_ETX")); // NOI18N
        chkErrSobreTempETX.setOpaque(false);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkErrCobraNet)
                            .addComponent(chkErr3008)
                            .addComponent(chkErrTempETX)
                            .addComponent(chkErrRAM))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkErrMod1)
                            .addComponent(chkErrSobreTempETX)
                            .addComponent(ChkErrFrontal)
                            .addComponent(chkErrMod2)))
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkErrRAM)
                    .addComponent(chkErrMod1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkErrCobraNet)
                    .addComponent(chkErrMod2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkErr3008)
                    .addComponent(ChkErrFrontal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkErrTempETX)
                    .addComponent(chkErrSobreTempETX))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 296, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(394, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab(bundle.getString("ERRORES"), jPanel3); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText(bundle.getString("PRESETS")); // NOI18N

        chkPresetsPrio.setText(bundle.getString("PRIO")); // NOI18N
        chkPresetsPrio.setOpaque(false);

        btnCargaDefault.setText(bundle.getString("LOAD_DEFAULT")); // NOI18N
        btnCargaDefault.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCargaDefaultMouseClicked(evt);
            }
        });

        btnGuardarDefault.setText(bundle.getString("SAVE_DEFAULT")); // NOI18N
        btnGuardarDefault.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarDefaultMouseClicked(evt);
            }
        });

        btnCargarFabrica.setText(bundle.getString("LOAD_FACTORY")); // NOI18N
        btnCargarFabrica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCargarFabricaMouseClicked(evt);
            }
        });

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Log"));

        txtLog.setColumns(20);
        txtLog.setEditable(false);
        txtLog.setRows(5);
        jScrollPane2.setViewportView(txtLog);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkPresetsPrio))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnCargaDefault, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardarDefault, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCargarFabrica, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(chkPresetsPrio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCargaDefault, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarDefault, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCargarFabrica, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Log/Presets", jPanel4);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setText(bundle.getString("CHANNEL")); // NOI18N

        nudChannel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nudChannelStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel6.setText(bundle.getString("GAIN_LINEAR_INPUT_CH")); // NOI18N

        tkbGainLinearInput1.setMajorTickSpacing(200);
        tkbGainLinearInput1.setMaximum(1200);
        tkbGainLinearInput1.setMinimum(-1500);
        tkbGainLinearInput1.setMinorTickSpacing(100);
        tkbGainLinearInput1.setPaintTicks(true);
        tkbGainLinearInput1.setValue(0);
        tkbGainLinearInput1.setOpaque(false);
        tkbGainLinearInput1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tkbGainLinearInput1StateChanged(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel7.setText(bundle.getString(" GAIN_INPUT_CH")); // NOI18N

        lblGainLinearInput1.setText("0");

        tkbGainInput1.setMajorTickSpacing(50);
        tkbGainInput1.setMaximum(0);
        tkbGainInput1.setMinimum(-100);
        tkbGainInput1.setMinorTickSpacing(20);
        tkbGainInput1.setOrientation(javax.swing.JSlider.VERTICAL);
        tkbGainInput1.setPaintTicks(true);
        tkbGainInput1.setOpaque(false);
        tkbGainInput1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tkbGainInput1StateChanged(evt);
            }
        });

        lblGainInput1.setText("0");

        chkMute.setText(bundle.getString("MUTE")); // NOI18N
        chkMute.setOpaque(false);
        chkMute.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkMuteItemStateChanged(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel10.setText(bundle.getString("GAIN_OUTPUT_CH")); // NOI18N

        tkbGainOutput1.setMajorTickSpacing(50);
        tkbGainOutput1.setMaximum(0);
        tkbGainOutput1.setMinimum(-100);
        tkbGainOutput1.setMinorTickSpacing(20);
        tkbGainOutput1.setOrientation(javax.swing.JSlider.VERTICAL);
        tkbGainOutput1.setPaintTicks(true);
        tkbGainOutput1.setOpaque(false);
        tkbGainOutput1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tkbGainOutput1StateChanged(evt);
            }
        });

        lblGainOutput1.setText("0");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel12.setText(bundle.getString("EQ_INPUT_CH")); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel13.setText(bundle.getString("BAND")); // NOI18N

        nudEqInputBand1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nudEqInputBand1StateChanged(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel14.setText(bundle.getString("BOOST")); // NOI18N

        nudEqInputBoost1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nudEqInputBoost1StateChanged(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel15.setText(bundle.getString("FREQ")); // NOI18N

        nudEqInputFreq1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nudEqInputFreq1StateChanged(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel16.setText(bundle.getString("Q_SLOPE")); // NOI18N

        nudEqInputQ_Slope1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nudEqInputQ_Slope1StateChanged(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel17.setText(bundle.getString("GAIN")); // NOI18N

        tkbEqInputGain1.setMaximum(15);
        tkbEqInputGain1.setMinimum(-15);
        tkbEqInputGain1.setMinorTickSpacing(2);
        tkbEqInputGain1.setOrientation(javax.swing.JSlider.VERTICAL);
        tkbEqInputGain1.setPaintTicks(true);
        tkbEqInputGain1.setValue(0);
        tkbEqInputGain1.setOpaque(false);
        tkbEqInputGain1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tkbEqInputGain1StateChanged(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel18.setText(bundle.getString("ENABLE")); // NOI18N

        nudEqInputEnable1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nudEqInputEnable1StateChanged(evt);
            }
        });

        lblEqInputGain1.setText("0");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel20.setText(bundle.getString("LOUDNESS_CH")); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel21.setText(bundle.getString("ENABLE")); // NOI18N

        nudEnableLoudNess1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nudEnableLoudNess1StateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tkbGainLinearInput1, 0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(nudChannel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(chkMute)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(nudEqInputBoost1, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(nudEqInputBand1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)))
                                        .addGap(25, 25, 25)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nudEqInputQ_Slope1, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                            .addComponent(nudEqInputFreq1, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                            .addComponent(jLabel15)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel16)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addComponent(lblGainLinearInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel12)
                                .addGap(34, 34, 34)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(tkbGainInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblGainInput1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(tkbGainOutput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblGainOutput1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tkbEqInputGain1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEqInputGain1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(nudEqInputEnable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nudEnableLoudNess1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel21)))))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14)))
                .addGap(391, 391, 391))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nudChannel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkMute))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tkbGainLinearInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGainLinearInput1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12))
                    .addComponent(tkbGainInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGainInput1)
                    .addComponent(tkbGainOutput1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGainOutput1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(jLabel17)
                        .addComponent(jLabel18)
                        .addComponent(jLabel20)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nudEqInputBand1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nudEqInputFreq1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 288, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nudEqInputBoost1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nudEqInputQ_Slope1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tkbEqInputGain1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEqInputGain1)
                        .addComponent(nudEqInputEnable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nudEnableLoudNess1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Gain Input/Output", jPanel5);

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("Limiter Ch"));

        jLabel8.setText(bundle.getString("TC")); // NOI18N

        nudTCLimiter1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nudTCLimiter1StateChanged(evt);
            }
        });

        jLabel9.setText(bundle.getString("DECAY")); // NOI18N

        nudDecayLimiter1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nudDecayLimiter1StateChanged(evt);
            }
        });

        jLabel11.setText(bundle.getString("THRESHOLD")); // NOI18N

        nudThresHoldLimiter1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nudThresHoldLimiter1StateChanged(evt);
            }
        });

        jLabel19.setText(bundle.getString("MODE")); // NOI18N

        nudEnableLimiter1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nudEnableLimiter1StateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nudTCLimiter1, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(nudDecayLimiter1))
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19)
                            .addComponent(nudEnableLimiter1))
                        .addGap(47, 47, 47))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nudThresHoldLimiter1, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(jLabel11))
                        .addContainerGap())))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nudTCLimiter1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nudThresHoldLimiter1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nudDecayLimiter1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nudEnableLimiter1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(436, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(367, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Limiter", jPanel6);

        tkbGainInputPrio.setMajorTickSpacing(20);
        tkbGainInputPrio.setMaximum(0);
        tkbGainInputPrio.setMinimum(-100);
        tkbGainInputPrio.setMinorTickSpacing(10);
        tkbGainInputPrio.setOrientation(javax.swing.JSlider.VERTICAL);
        tkbGainInputPrio.setPaintTicks(true);
        tkbGainInputPrio.setOpaque(false);
        tkbGainInputPrio.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tkbGainInputPrioStateChanged(evt);
            }
        });

        tkbFilterPrioGain.setMajorTickSpacing(5);
        tkbFilterPrioGain.setMaximum(15);
        tkbFilterPrioGain.setMinimum(-15);
        tkbFilterPrioGain.setMinorTickSpacing(2);
        tkbFilterPrioGain.setOrientation(javax.swing.JSlider.VERTICAL);
        tkbFilterPrioGain.setPaintTicks(true);
        tkbFilterPrioGain.setValue(0);
        tkbFilterPrioGain.setOpaque(false);
        tkbFilterPrioGain.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tkbFilterPrioGainStateChanged(evt);
            }
        });

        tkbGainLinearInputPrio.setMajorTickSpacing(200);
        tkbGainLinearInputPrio.setMaximum(1200);
        tkbGainLinearInputPrio.setMinimum(-1500);
        tkbGainLinearInputPrio.setMinorTickSpacing(100);
        tkbGainLinearInputPrio.setPaintTicks(true);
        tkbGainLinearInputPrio.setValue(0);
        tkbGainLinearInputPrio.setOpaque(false);
        tkbGainLinearInputPrio.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tkbGainLinearInputPrioStateChanged(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel22.setText(bundle.getString("GAIN_LINEAR_INPUT_PRIO")); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel23.setText(bundle.getString("GAIN_INPUT_PRIO")); // NOI18N

        lblGainLinearInputPrio.setText("0");

        lblGainInputPrio.setText("0");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel26.setText(bundle.getString("FILTER_PRIO")); // NOI18N

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel27.setText(bundle.getString("BOOST")); // NOI18N

        nudFilterPrioBoost.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nudFilterPrioBoostStateChanged(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel28.setText(bundle.getString("FREQ")); // NOI18N

        nudFilterPrioFreq.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nudFilterPrioFreqStateChanged(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel29.setText(bundle.getString("Q_SLOPE")); // NOI18N

        nudFilterPrioQ_Slope.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nudFilterPrioQ_SlopeStateChanged(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel30.setText(bundle.getString("GAIN")); // NOI18N

        lblFilterPrioGain.setText("0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel23))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tkbGainLinearInputPrio, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel26)
                                        .addComponent(jLabel22)))
                                .addGap(37, 37, 37))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(lblGainLinearInputPrio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)))
                        .addComponent(tkbGainInputPrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblGainInputPrio, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nudFilterPrioFreq, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nudFilterPrioBoost, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(nudFilterPrioQ_Slope, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(tkbFilterPrioGain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFilterPrioGain, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                            .addComponent(jLabel30))))
                .addContainerGap(422, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel23)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tkbGainLinearInputPrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGainLinearInputPrio))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tkbGainInputPrio, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblGainInputPrio)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nudFilterPrioBoost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nudFilterPrioQ_Slope, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nudFilterPrioFreq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFilterPrioGain)
                            .addComponent(tkbFilterPrioGain, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(292, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Gain Prio", jPanel7);

        tkbGainFilter1.setMajorTickSpacing(5);
        tkbGainFilter1.setMaximum(15);
        tkbGainFilter1.setMinimum(-15);
        tkbGainFilter1.setMinorTickSpacing(2);
        tkbGainFilter1.setOrientation(javax.swing.JSlider.VERTICAL);
        tkbGainFilter1.setPaintTicks(true);
        tkbGainFilter1.setValue(0);
        tkbGainFilter1.setOpaque(false);
        tkbGainFilter1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tkbGainFilter1StateChanged(evt);
            }
        });

        tkbGainTone1.setMajorTickSpacing(50);
        tkbGainTone1.setMaximum(0);
        tkbGainTone1.setMinimum(-100);
        tkbGainTone1.setMinorTickSpacing(20);
        tkbGainTone1.setOrientation(javax.swing.JSlider.VERTICAL);
        tkbGainTone1.setPaintTicks(true);
        tkbGainTone1.setOpaque(false);
        tkbGainTone1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tkbGainTone1StateChanged(evt);
            }
        });

        tkbDC1.setMajorTickSpacing(200);
        tkbDC1.setMaximum(1600);
        tkbDC1.setMinimum(-1600);
        tkbDC1.setMinorTickSpacing(100);
        tkbDC1.setOrientation(javax.swing.JSlider.VERTICAL);
        tkbDC1.setPaintTicks(true);
        tkbDC1.setValue(0);
        tkbDC1.setOpaque(false);
        tkbDC1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tkbDC1StateChanged(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel24.setText(bundle.getString("FILTER_CH")); // NOI18N

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel25.setText(bundle.getString("FREQ")); // NOI18N

        nudFreqFilter1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nudFreqFilter1StateChanged(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel31.setText(bundle.getString("GAIN")); // NOI18N

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel32.setText(bundle.getString("ENABLE")); // NOI18N

        nudEnableFilter1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nudEnableFilter1StateChanged(evt);
            }
        });

        lblGainFilter1.setText("0");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel34.setText(bundle.getString("TONE_CH")); // NOI18N

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel35.setText(bundle.getString("FREQ")); // NOI18N

        nudFreqTone1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nudFreqTone1StateChanged(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel36.setText(bundle.getString("GAIN")); // NOI18N

        lblGainTone1.setText("0");

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel38.setText(bundle.getString("ENABLE")); // NOI18N

        nudEnableTone1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nudEnableTone1StateChanged(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel39.setText(bundle.getString("DC_CH")); // NOI18N

        lblDC1.setText("0");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(nudFreqFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(tkbGainFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblGainFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addComponent(nudEnableFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel36)
                                    .addComponent(nudFreqTone1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel38)
                                        .addGap(52, 52, 52))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                        .addComponent(nudEnableTone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(55, 55, 55)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel39)
                                    .addComponent(tkbDC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(tkbGainTone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblGainTone1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDC1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel34)))
                .addGap(330, 330, 330))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel34)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel32)
                            .addComponent(jLabel35)
                            .addComponent(jLabel38))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nudFreqFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nudEnableFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nudFreqTone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nudEnableTone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel36))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tkbGainTone1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(tkbGainFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblGainTone1)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDC1)
                            .addComponent(tkbDC1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(lblGainFilter1)))
                .addGap(4328, 4328, 4328))
        );

        jTabbedPane1.addTab("Filter/Tone/DC Ch", jPanel8);

        chkCobraNetPrio.setText(bundle.getString("PRIO")); // NOI18N
        chkCobraNetPrio.setOpaque(false);

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel33.setText(bundle.getString("ADDR_BUNDLE")); // NOI18N

        nudAddr_bundle.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nudAddr_bundleStateChanged(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel37.setText(bundle.getString("CH_BUNDLE")); // NOI18N

        nudInput_channel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nudInput_channelStateChanged(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel40.setText(bundle.getString("SUPPLY_NAME")); // NOI18N

        txtCobraNetNombreFuente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCobraNetNombreFuenteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCobraNetNombreFuenteFocusLost(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel41.setText(bundle.getString("ZONE_NAME")); // NOI18N

        txtCobraNetNombreZona.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCobraNetNombreZonaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCobraNetNombreZonaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chkCobraNetPrio)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nudAddr_bundle))
                .addGap(28, 28, 28)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel40))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(nudInput_channel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCobraNetNombreFuente, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(jLabel41)
                            .addComponent(txtCobraNetNombreZona))))
                .addContainerGap(336, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(chkCobraNetPrio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel37)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nudAddr_bundle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nudInput_channel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCobraNetNombreFuente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCobraNetNombreZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(380, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cobranet", jPanel9);

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("Infor"));

        chkEnableCobraNetPrio.setText(bundle.getString("COBRANET_PRIO_ENABLE")); // NOI18N
        chkEnableCobraNetPrio.setOpaque(false);
        chkEnableCobraNetPrio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkEnableCobraNetPrioItemStateChanged(evt);
            }
        });

        chkManiobra5vPrio.setText(bundle.getString("MANEUVER_5V")); // NOI18N
        chkManiobra5vPrio.setOpaque(false);
        chkManiobra5vPrio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkManiobra5vPrioItemStateChanged(evt);
            }
        });

        chkPuertaRuidoPrio.setText(bundle.getString("NOISE_GATE")); // NOI18N
        chkPuertaRuidoPrio.setOpaque(false);
        chkPuertaRuidoPrio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkPuertaRuidoPrioItemStateChanged(evt);
            }
        });

        jLabel42.setText(bundle.getString("NOISE_GATE_THRESHOLD")); // NOI18N

        nudUmbralPuertaRuido.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nudUmbralPuertaRuidoStateChanged(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel43.setText(bundle.getString("KEY")); // NOI18N

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel45.setText(bundle.getString("TEMP_CH")); // NOI18N

        lblTemp.setText("0");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel47.setText(bundle.getString("SOURCE_START_DELAY")); // NOI18N

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel48.setText(bundle.getString("BOARD_TEMP")); // NOI18N

        lbltempplaca.setText("0");

        nudDelayArranque.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nudDelayArranqueStateChanged(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel50.setText("/ 10 Seg");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel51.setText(bundle.getString("TEMP_ENVIRONMENT")); // NOI18N

        lblTempAmbiente.setText("0"); // NOI18N

        lblMuestras.setFont(new java.awt.Font("Tahoma", 0, 12));
        lblMuestras.setText(bundle.getString("NOISE_GATE_THRESHOLD")); // NOI18N

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkEnableCobraNetPrio)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel17Layout.createSequentialGroup()
                            .addComponent(jLabel43)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblclave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(chkManiobra5vPrio, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addGap(18, 18, 18)
                        .addComponent(nudUmbralPuertaRuido, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chkPuertaRuidoPrio)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTemp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(nudDelayArranque, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel50)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(lblMuestras)
                        .addContainerGap())
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel17Layout.createSequentialGroup()
                            .addComponent(jLabel48)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbltempplaca, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                        .addGroup(jPanel17Layout.createSequentialGroup()
                            .addComponent(jLabel51)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblTempAmbiente, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)))))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkEnableCobraNetPrio)
                    .addComponent(chkPuertaRuidoPrio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkManiobra5vPrio)
                    .addComponent(jLabel42)
                    .addComponent(nudUmbralPuertaRuido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel43)
                        .addComponent(lblclave, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTemp)
                        .addComponent(jLabel45)))
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nudDelayArranque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50)))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(lbltempplaca))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(lblTempAmbiente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMuestras)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(325, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(341, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Config Prio / Infor", jPanel10);

        lblLink.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblLink.setOpaque(true);

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setForeground(new java.awt.Color(255, 255, 255));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/LOGO CUADRADO.jpg"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setMaximumSize(new java.awt.Dimension(256, 256));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(944, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(52, 52, 52))
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel19Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(47, 47, 47)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblLink, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(82, Short.MAX_VALUE)))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(554, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(23, 23, 23))
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel19Layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(lblLink, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(268, Short.MAX_VALUE))
                .addGroup(jPanel19Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Automatico = true;
    }//GEN-LAST:event_formWindowActivated

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setVisible(false);
        tmrConectado.stop();
        tmrRefresco.stop();
        try {
            //etapa.dispose();
            etapa.exec("dispose", null, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        etapa = null;
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jList1.setModel(listincidencias);
        buttonGroup1.add(rb2200);
        buttonGroup1.add(rb2400);
        buttonGroup1.add(rb2800);
        buttonGroup1.add(rb4200);
        buttonGroup1.add(rb4400);
        nudChannel.setModel(new SpinnerNumberModel(1, 1, 4, 1));
        nudEqInputBand1.setModel(new SpinnerNumberModel(1, 1, 7, 1));
        nudEqInputBoost1.setModel(new SpinnerNumberModel(0, -10, 10, 1));
        nudEqInputFreq1.setModel(new SpinnerNumberModel(3, 3, 60000, 1));
        nudEqInputQ_Slope1.setModel(new SpinnerNumberModel(141, 0, 5100, 1));
        nudEqInputEnable1.setModel(new SpinnerNumberModel(0, 0, 1, 1));
        nudEnableLoudNess1.setModel(new SpinnerNumberModel(0, 0, 1, 1));
        nudTCLimiter1.setModel(new SpinnerNumberModel(1, 1, 10000, 1));
        nudDecayLimiter1.setModel(new SpinnerNumberModel(5, 5, 23, 1));
        nudThresHoldLimiter1.setModel(new SpinnerNumberModel(3, -24, 24, 1));
        nudEnableLimiter1.setModel(new SpinnerNumberModel(0, 0, 1, 1));
        nudFilterPrioBoost.setModel(new SpinnerNumberModel(0, -10, 10, 1));
        nudFilterPrioFreq.setModel(new SpinnerNumberModel(3, 3, 60000, 1));
        nudFilterPrioQ_Slope.setModel(new SpinnerNumberModel(141, 0, 5100, 1));
        nudFreqFilter1.setModel(new SpinnerNumberModel(3, 3, 60000, 1));
        nudEnableFilter1.setModel(new SpinnerNumberModel(0, 0, 1, 1));
        nudFreqTone1.setModel(new SpinnerNumberModel(3, 1, 24000, 1));
        nudEnableTone1.setModel(new SpinnerNumberModel(0, 0, 1, 1));
        nudAddr_bundle.setModel(new SpinnerNumberModel(0, 0, 65535, 1));
        nudInput_channel.setModel(new SpinnerNumberModel(0, 0, 8, 1));
        nudUmbralPuertaRuido.setModel(new SpinnerNumberModel(20, -100, 20, 1));
        nudDelayArranque.setModel(new SpinnerNumberModel(0, 0, 20, 1));

        tmrConectado = new Timer(1000, new ActionListener() {

            boolean color = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                try {
                    Boolean b1 = Boolean.valueOf(((etapa.exec("getAsyncConnect", null, null))[0]).toString());
                    Boolean b2 = Boolean.valueOf(((etapa.exec("getSyncConnect", null, null))[0]).toString());
                    //if (etapa.getAsyncConnect() && etapa.getSyncConnect()) {
                    if (b1 && b2) {
                        //Parpadeo Link
                        color = !(color);

                        if (color) {
                            lblLink.setBackground(Color.decode(ROJO));
                        } else {
                            lblLink.setBackground(Color.decode(VERDE));
                        }

                        if (!(Conectado)) {
                            listincidencias.add(0, formato.format(new Date()) + config.getString("CONNECT_MSG"));
                            Conectado = true;
                        }

                    } else {
                        //Link Apagado
                        lblLink.setBackground(Color.decode(VERDE));

                        if (Conectado) {
                            listincidencias.add(0, formato.format(new Date()) + config.getString("NO_CONNECT_MSG"));
                            Conectado = false;
                        }
                    }
                } catch (UnsupportedDriverOperation ex) {
                    logger.error(ex);
                    JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (DriverException ex) {
                    //Link Apagado
                    logger.error(ex);
//                    System.err.println("-->AQUI-->");
                    JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    lblLink.setBackground(Color.decode(VERDE));
                }
            }
        });

        tmrRefresco = new Timer(1500, new ActionListener() {

            boolean Procesando = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                int i, j, l;

                try {
                    if (Procesando) {
                        return;
                    }

                    if (!(Conectado)) {
                        return;
                    }

                    Procesando = true;

                    Automatico = false;

                    i = (cv(nudChannel.getValue()) > 2) ? 1 : 0;
                    j = cv(nudChannel.getValue()) - 1;
                    j = (i == 1) ? j - 2 : j;
                    l = cv(nudEqInputBand1.getValue()) - 1;

                    STVInfo tempSTVInfo = null;
                    tempSTVInfo = (STVInfo) (etapa.exec("getInfo", null, null))[0];

                    if (tempSTVInfo.num_canales <= 2) {
                        if (tempSTVInfo.pot_canal == 2) {
                            rb2200.setSelected(true);
                        } else if (tempSTVInfo.pot_canal == 4) {
                            rb2400.setSelected(true);
                        } else {
                            rb2800.setSelected(true);
                        }
                    } else {
                        if (tempSTVInfo.pot_canal == 2) {
                            rb4200.setSelected(true);
                        } else {
                            rb4400.setSelected(true);
                        }
                    }

                    lblMuestras.setText(String.valueOf(bv(tempSTVInfo.modAmp[i].NewSense)));

                    chkCobraNet.setSelected(tempSTVInfo.hay_CobraNet);
                    chkSDCard.setSelected(tempSTVInfo.hay_SD);
                    chkPower_On.setSelected(tempSTVInfo.Power_On);

                    tkbGainOutput1.setValue(tempSTVInfo.modAmp[i].Canal[j].GainOutput);
                    tkbGainInput1.setValue(tempSTVInfo.modAmp[i].Canal[j].GainInput);

                    nudEnableFilter1.setValue(myCByte(tempSTVInfo.modAmp[i].Canal[j].EnableFilter));
                    nudFreqFilter1.setValue(tempSTVInfo.modAmp[i].Canal[j].FrecFilter);

                    tkbGainFilter1.setValue(tempSTVInfo.modAmp[i].Canal[j].GainFilter);

                    nudEnableLimiter1.setValue(myCByte(cbool(tempSTVInfo.modAmp[i].Canal[j].Limitador_Modo)));
                    nudThresHoldLimiter1.setValue(tempSTVInfo.modAmp[i].Canal[j].ThresHoldLimiter);
                    nudTCLimiter1.setValue(tempSTVInfo.modAmp[i].Canal[j].TCLimiter);
                    nudDecayLimiter1.setValue(bv(tempSTVInfo.modAmp[i].Canal[j].Decaylimiter));
                    nudEqInputEnable1.setValue(myCByte(tempSTVInfo.modAmp[i].Canal[j].EnableEq));
                    nudEqInputBoost1.setValue(tempSTVInfo.modAmp[i].Canal[j].BoostEq[l]);
                    nudEqInputFreq1.setValue(tempSTVInfo.modAmp[i].Canal[j].FreqEq[l]);
                    nudEqInputQ_Slope1.setValue(tempSTVInfo.modAmp[i].Canal[j].Q_SlopeEq[l]);

                    tkbEqInputGain1.setValue(tempSTVInfo.modAmp[i].Canal[j].GainEq[l]);

                    nudEnableTone1.setValue(myCByte(tempSTVInfo.modAmp[i].Canal[j].EnableTone));

                    tkbGainTone1.setValue(tempSTVInfo.modAmp[i].Canal[j].GainTone);

                    nudFreqTone1.setValue(tempSTVInfo.modAmp[i].Canal[j].FreqTone);

                    tkbDC1.setValue(tempSTVInfo.modAmp[i].Canal[j].DC);
                    tkbGainLinearInput1.setValue(tempSTVInfo.modAmp[i].Canal[j].GainLinearInput);

                    nudEnableLoudNess1.setValue(myCByte(tempSTVInfo.modAmp[i].Canal[j].EnableLoudNess));

                    chkMute.setSelected(cbool(tempSTVInfo.modAmp[i].Canal[j].Mute));

                    if (!(chkCobraNetPrio.isSelected())) {
                        nudInput_channel.setValue(tempSTVInfo.modAmp[i].Canal[j].Canal_Bundle_Cobranet);
                        nudAddr_bundle.setValue(tempSTVInfo.modAmp[i].Canal[j].Direccion_Bundle_Cobranet);
                    }

                    //Informacion de prio
                    nudFilterPrioBoost.setValue(tempSTVInfo.modAmp[i].Prio.BoostFilterPrio);
                    nudFilterPrioFreq.setValue(tempSTVInfo.modAmp[i].Prio.FrecFilterPrio);
                    nudFilterPrioQ_Slope.setValue(tempSTVInfo.modAmp[i].Prio.Q_SlopeFilterPrio);

                    tkbFilterPrioGain.setValue(tempSTVInfo.modAmp[i].Prio.GainFilterPrio);
                    tkbGainLinearInputPrio.setValue(tempSTVInfo.modAmp[i].Prio.GainLinearInputPrio);
                    tkbGainInputPrio.setValue(tempSTVInfo.modAmp[i].Prio.GainPrio);

                    if (chkCobraNetPrio.isSelected()) {
                        nudInput_channel.setValue(tempSTVInfo.modAmp[i].Prio.Canal_Bundle_Cobranet);
                        nudAddr_bundle.setValue(tempSTVInfo.modAmp[i].Prio.Direccion_Bundle_Cobranet);
                    }

                    lblGainLinearInput1.setText(String.valueOf(cv(tkbGainLinearInput1.getValue())));
                    lblGainLinearInputPrio.setText(String.valueOf(cv(tkbGainLinearInputPrio.getValue())));
                    lblGainInput1.setText(String.valueOf(cv(tkbGainInput1.getValue())));
                    lblGainOutput1.setText(String.valueOf(cv(tkbGainOutput1.getValue())));
                    lblEqInputGain1.setText(String.valueOf(cv(tkbEqInputGain1.getValue())));
                    lblGainFilter1.setText(String.valueOf(cv(tkbGainFilter1.getValue())));
                    lblGainTone1.setText(String.valueOf(cv(tkbGainTone1.getValue())));
                    lblDC1.setText(String.valueOf(cv(tkbDC1.getValue())));
                    lblFilterPrioGain.setText(String.valueOf(cv(tkbFilterPrioGain.getValue())));
                    lblGainInputPrio.setText(String.valueOf(cv(tkbGainInputPrio.getValue())));

                    chkEnableCobraNetPrio.setSelected(tempSTVInfo.Prioridad_CobraNet_Habilitada);
                    chkPuertaRuidoPrio.setSelected(tempSTVInfo.Prioridad_Modo_Presencia);
                    chkManiobra5vPrio.setSelected(tempSTVInfo.Prioridad_Activacion_5V);

                    nudUmbralPuertaRuido.setValue(tempSTVInfo.Prioridad_Umbral_activacion);
                    nudDelayArranque.setValue(bv(tempSTVInfo.DelayArranque));

                    ckEnableEtherNet.setSelected(tempSTVInfo.hay_EtherNet);
                    chkConfiguracionEntradaDigital.setSelected(tempSTVInfo.Entrada_Digital);

                    String argTemp[] = new String[2];
                    argTemp[0] = Integer.toString(i);
                    argTemp[1] = Integer.toString(j);

                    byte dBytes[] = (byte[]) etapa.exec("getNSupply", argTemp, null)[0]; //etapa.getNSupply(i, j);
                    String str = new String(dBytes, "UTF-8");

                    if (!(txtCobraNetNombreFuente.isFocusOwner())) {
                        txtCobraNetNombreFuente.setText(str);
                    }

                    dBytes = (byte[]) etapa.exec("getNZone", argTemp, null)[0];//dBytes = etapa.getNZone(i, j);
                    str = new String(dBytes, "UTF-8");

                    if (!(txtCobraNetNombreZona.isFocusOwner())) {
                        txtCobraNetNombreZona.setText(str);
                    }
                    dBytes = null;

                    tempSTVInfo = null;
                    tempSTVInfo = (STVInfo) (etapa.exec("getInfo", null, null))[0];

                    //Informacion variada
                    //Errores
                    chkErr12V.setSelected(cbool((byte) (bv(tempSTVInfo.Errores[4]) & 16)));
                    chkErr230I.setSelected(cbool((byte) (bv(tempSTVInfo.Errores[4]) & 2)));
                    chkErr230V.setSelected(cbool((byte) (bv(tempSTVInfo.Errores[4]) & 1)));
                    chkErr3008.setSelected(cbool(tempSTVInfo.Errores[2]));
                    chkErrCarga.setSelected(cbool((byte) (bv(tempSTVInfo.Errores[4]) & 32)));
                    chkErrCobraNet.setSelected(cbool(tempSTVInfo.Errores[1]));
                    chkErrComunicacion.setSelected(cbool((byte) (bv(tempSTVInfo.Errores[4]) & 64)));
                    ChkErrFrontal.setSelected(cbool(tempSTVInfo.Errores[7]));
                    chkErrMod1.setSelected(cbool(tempSTVInfo.Errores[5]));
                    chkErrMod2.setSelected(cbool(tempSTVInfo.Errores[6]));
                    chkErrRAM.setSelected(cbool(tempSTVInfo.Errores[0]));
                    chkErrSobreTempETX.setSelected(cbool(tempSTVInfo.Errores[8]));
                    chkErrTempETX.setSelected(cbool(tempSTVInfo.Errores[3]));
                    chkErrVP1.setSelected(cbool((byte) (bv(tempSTVInfo.Errores[4]) & 4)));
                    chkErrVP2.setSelected(cbool((byte) (bv(tempSTVInfo.Errores[4]) & 8)));

                    lblclave.setText(String.valueOf(tempSTVInfo.Clave));
                    lblTemp.setText(String.valueOf(bv(tempSTVInfo.modAmp[i].Canal[j].Temp.temp)));
                    lblTempAmbiente.setText(String.valueOf(bv(tempSTVInfo.modAmp[i].tempAmb)));
                    lbltempplaca.setText(String.valueOf(bv(tempSTVInfo.modAmp[i].Canal[j].Temp.tempPlaca)));

                    String tmpSetText = ((etapa.exec("getSTVLog", null, null))[0]).toString();
                    txtLog.setText(tmpSetText);

                    Automatico = true;

                    Procesando = false;
                } catch (UnsupportedDriverOperation ex) {
                    logger.error(ex);
                    JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (UnsupportedEncodingException ex) {
                    logger.error(ex);
//                    System.err.println("-->AQUI-->");
                    JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (DriverException ex) {
                    logger.error(ex);
//                    System.err.println("-->AQUI-->");
                    JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        tmrConectado.start();
        tmrRefresco.start();
    }//GEN-LAST:event_formWindowOpened

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try {
            //dispose();
            //this.etapa.dispose();
            etapa.exec("dispose", null, null);
            Runtime.getRuntime().exit(0);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void btBorraIncidenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btBorraIncidenciasMouseClicked
        listincidencias.clear();
    }//GEN-LAST:event_btBorraIncidenciasMouseClicked

    private void btnConnectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConnectMouseClicked
        try {
            tmrConectado.stop();
            tmrConectado.setInitialDelay(0);
            tmrConectado.start();
            //this.etapa.dispose();
            etapa.exec("dispose", null, null);
            etapa = null;
            etapa = new STVImpl();
            String[] tempArgs = new String[1];
            tempArgs[0] = txtIP.getText();
            Byte tempResInt = (Byte) (etapa.exec("connect", tempArgs, null))[0];
            if (tempResInt != 1) {
                //                    System.err.println("-->AQUI-->");
                JOptionPane.showMessageDialog(null, config.getString("CONNECTION_ERROR"), config.getString("CRITICAL_ERROR"), 0);
            }
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConnectMouseClicked

    private void tkbGainLinearInput1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tkbGainLinearInput1StateChanged
        if (tkbGainLinearInput1.getValueIsAdjusting() == false) {
            lblGainLinearInput1.setText(String.valueOf(cv(tkbGainLinearInput1.getValue())));

            if (!(Automatico)) {
                return;
            }

            tmrRefresco.stop();
            try {
                //etapa.setAmpGainLinearInput((byte) cv(nudChannel.getValue()), (short) cv(tkbGainLinearInput1.getValue()));
                String[] tempArgs = new String[2];
                tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
                tempArgs[1] = Short.toString((short) cv(tkbGainLinearInput1.getValue()));
                etapa.exec("setAmpGainLinearInput", tempArgs, null);
            } catch (UnsupportedDriverOperation ex) {
                logger.error(ex);
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (DriverException ex) {
                logger.error(ex);
                //                    System.err.println("-->AQUI-->");
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            tmrRefresco.start();
        }
}//GEN-LAST:event_tkbGainLinearInput1StateChanged

    private void tkbGainLinearInputPrioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tkbGainLinearInputPrioStateChanged
        if (tkbGainLinearInputPrio.getValueIsAdjusting() == false) {
            lblGainLinearInputPrio.setText(String.valueOf(cv(tkbGainLinearInputPrio.getValue())));

            if (!(Automatico)) {
                return;
            }

            tmrRefresco.stop();
            try {
                //etapa.setAmpGainLinearPrioInput((short) cv(tkbGainLinearInputPrio.getValue()));
                String[] tempArgs = new String[1];
                tempArgs[0] = Short.toString((short) cv(tkbGainLinearInputPrio.getValue()));
                etapa.exec("setAmpGainLinearPrioInput", tempArgs, null);
            } catch (UnsupportedDriverOperation ex) {
                logger.error(ex);
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (DriverException ex) {
                logger.error(ex);
                //                    System.err.println("-->AQUI-->");
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            tmrRefresco.start();
        }
    }//GEN-LAST:event_tkbGainLinearInputPrioStateChanged

    private void tkbGainInput1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tkbGainInput1StateChanged
        if (tkbGainInput1.getValueIsAdjusting() == false) {
            lblGainInput1.setText(String.valueOf(cv(tkbGainInput1.getValue())));

            if (!(Automatico)) {
                return;
            }

            tmrRefresco.stop();
            try {
                // etapa.setAmpGain((byte) cv(nudChannel.getValue()), true, (byte) cv(tkbGainInput1.getValue()));
                String[] tempArgs = new String[3];
                tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
                tempArgs[1] = Boolean.toString(true);
                tempArgs[2] = Byte.toString((byte) cv(tkbGainInput1.getValue()));
                etapa.exec("setAmpGain", tempArgs, null);
            } catch (UnsupportedDriverOperation ex) {
                logger.error(ex);
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (DriverException ex) {
                logger.error(ex);
                //                    System.err.println("-->AQUI-->");
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            tmrRefresco.start();
        }
    }//GEN-LAST:event_tkbGainInput1StateChanged

    private void tkbGainOutput1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tkbGainOutput1StateChanged
        if (tkbGainOutput1.getValueIsAdjusting() == false) {
            lblGainOutput1.setText(String.valueOf(tkbGainOutput1.getValue()));

            if (!(Automatico)) {
                return;
            }

            tmrRefresco.stop();
            try {
                //etapa.setAmpGain((byte) cv(nudChannel.getValue()), false, (byte) cv(tkbGainOutput1.getValue()));
                String[] tempArgs = new String[3];
                tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
                tempArgs[1] = Boolean.toString(false);
                tempArgs[2] = Byte.toString((byte) cv(tkbGainOutput1.getValue()));
                etapa.exec("setAmpGain", tempArgs, null);
            } catch (UnsupportedDriverOperation ex) {
                logger.error(ex);
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (DriverException ex) {
                logger.error(ex);
                //                    System.err.println("-->AQUI-->");
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            tmrRefresco.start();
        }
    }//GEN-LAST:event_tkbGainOutput1StateChanged

    private void nudEqInputBoost1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nudEqInputBoost1StateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setAmpEqualizer(
//                    (byte) cv(nudChannel.getValue()), 
//                    (byte) cv(nudEqInputBand1.getValue()), 
//                    (byte) cv(nudEqInputBoost1.getValue()), 
//                    cv(nudEqInputFreq1.getValue()), 
//                    cv(nudEqInputQ_Slope1.getValue()), 
//                    (byte) cv(tkbEqInputGain1.getValue())
//                    );
            String[] tempArgs = new String[6];
            tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
            tempArgs[1] = Byte.toString((byte) cv(nudEqInputBand1.getValue()));
            tempArgs[2] = Byte.toString((byte) cv(nudEqInputBoost1.getValue()));
            tempArgs[3] = Integer.toString(cv(nudEqInputFreq1.getValue()));
            tempArgs[4] = Integer.toString(cv(nudEqInputQ_Slope1.getValue()));
            tempArgs[5] = Byte.toString((byte) cv(tkbEqInputGain1.getValue()));
            etapa.exec("setAmpEqualizer", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_nudEqInputBoost1StateChanged

    private void nudEqInputFreq1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nudEqInputFreq1StateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
            //etapa.setAmpEqualizer((byte) cv(nudChannel.getValue()), 
            //            (byte) cv(nudEqInputBand1.getValue()), 
            //            (byte) cv(nudEqInputBoost1.getValue()), 
            //            cv(nudEqInputFreq1.getValue()), 
            //            cv(nudEqInputQ_Slope1.getValue()), 
            //            (byte) cv(tkbEqInputGain1.getValue()));
            String[] tempArgs = new String[6];
            tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
            tempArgs[1] = Byte.toString((byte) cv(nudEqInputBand1.getValue()));
            tempArgs[2] = Byte.toString((byte) cv(nudEqInputBoost1.getValue()));
            tempArgs[3] = Integer.toString(cv(nudEqInputFreq1.getValue()));
            tempArgs[4] = Integer.toString(cv(nudEqInputQ_Slope1.getValue()));
            tempArgs[5] = Byte.toString((byte) cv(tkbEqInputGain1.getValue()));
            etapa.exec("setAmpEqualizer", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_nudEqInputFreq1StateChanged

    private void nudEqInputQ_Slope1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nudEqInputQ_Slope1StateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setAmpEqualizer((byte) cv(nudChannel.getValue()), 
//                                  (byte) cv(nudEqInputBand1.getValue()), 
//                                  (byte) cv(nudEqInputBoost1.getValue()), 
//                                  cv(nudEqInputFreq1.getValue()),
//                                  cv(nudEqInputQ_Slope1.getValue()), 
//                                  (byte) cv(tkbEqInputGain1.getValue()));
            String[] tempArgs = new String[6];
            tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
            tempArgs[1] = Byte.toString((byte) cv(nudEqInputBand1.getValue()));
            tempArgs[2] = Byte.toString((byte) cv(nudEqInputBoost1.getValue()));
            tempArgs[3] = Integer.toString(cv(nudEqInputFreq1.getValue()));
            tempArgs[4] = Integer.toString(cv(nudEqInputQ_Slope1.getValue()));
            tempArgs[5] = Byte.toString((byte) cv(tkbEqInputGain1.getValue()));
            etapa.exec("setAmpEqualizer", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_nudEqInputQ_Slope1StateChanged

    private void tkbEqInputGain1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tkbEqInputGain1StateChanged
        if (tkbEqInputGain1.getValueIsAdjusting() == false) {
            lblEqInputGain1.setText(String.valueOf(tkbEqInputGain1.getValue()));

            if (!(Automatico)) {
                return;
            }

            tmrRefresco.stop();
            try {
//                etapa.setAmpEqualizer((byte) cv(nudChannel.getValue()), 
//                        (byte) cv(nudEqInputBand1.getValue()), 
//                        (byte) cv(nudEqInputBoost1.getValue()), 
//                        cv(nudEqInputFreq1.getValue()), 
//                        cv(nudEqInputQ_Slope1.getValue()), 
//                        (byte) cv(tkbEqInputGain1.getValue()));
                String[] tempArgs = new String[6];
                tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
                tempArgs[1] = Byte.toString((byte) cv(nudEqInputBand1.getValue()));
                tempArgs[2] = Byte.toString((byte) cv(nudEqInputBoost1.getValue()));
                tempArgs[3] = Integer.toString(cv(nudEqInputFreq1.getValue()));
                tempArgs[4] = Integer.toString(cv(nudEqInputQ_Slope1.getValue()));
                tempArgs[5] = Byte.toString((byte) cv(tkbEqInputGain1.getValue()));
                etapa.exec("setAmpEqualizer", tempArgs, null);
            } catch (UnsupportedDriverOperation ex) {
                logger.error(ex);
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (DriverException ex) {
                logger.error(ex);
                //                    System.err.println("-->AQUI-->");
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            tmrRefresco.start();
        }
    }//GEN-LAST:event_tkbEqInputGain1StateChanged

    private void nudEqInputBand1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nudEqInputBand1StateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setAmpEqualizer(
//                    (byte) cv(nudChannel.getValue()), 
//                    (byte) cv(nudEqInputBand1.getValue()), 
//                    (byte) cv(nudEqInputBoost1.getValue()), 
//                    cv(nudEqInputFreq1.getValue()), 
//                    cv(nudEqInputQ_Slope1.getValue()), 
//                    (byte) cv(tkbEqInputGain1.getValue()));
            String[] tempArgs = new String[6];
            tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
            tempArgs[1] = Byte.toString((byte) cv(nudEqInputBand1.getValue()));
            tempArgs[2] = Byte.toString((byte) cv(nudEqInputBoost1.getValue()));
            tempArgs[3] = Integer.toString(cv(nudEqInputFreq1.getValue()));
            tempArgs[4] = Integer.toString(cv(nudEqInputQ_Slope1.getValue()));
            tempArgs[5] = Byte.toString((byte) cv(tkbEqInputGain1.getValue()));
            etapa.exec("setAmpEqualizer", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_nudEqInputBand1StateChanged

    private void nudEqInputEnable1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nudEqInputEnable1StateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setAmpEqualizerEnable((byte) cv(nudChannel.getValue()), cbool((byte) cv(nudEqInputEnable1.getValue())));
            String[] tempArgs = new String[2];
            tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
            tempArgs[1] = Boolean.toString(cbool((byte) cv(nudEqInputEnable1.getValue())));
            etapa.exec("setAmpEqualizerEnable", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_nudEqInputEnable1StateChanged

    private void nudEnableLoudNess1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nudEnableLoudNess1StateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
            //etapa.setAmpLoudnessEnable((byte) cv(nudChannel.getValue()), cbool((byte) cv(nudEnableLoudNess1.getValue())));
            String[] tempArgs = new String[2];
            tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
            tempArgs[1] = Boolean.toString(cbool((byte) cv(nudEnableLoudNess1.getValue())));
            etapa.exec("setAmpLoudnessEnable", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_nudEnableLoudNess1StateChanged

    private void nudEnableLimiter1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nudEnableLimiter1StateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setSTVModeLimiter((byte) cv(nudEnableLimiter1.getValue()));
            String[] tempArgs = new String[1];
            tempArgs[0] = Byte.toString((byte) cv(nudEnableLimiter1.getValue()));
            etapa.exec("setSTVModeLimiter", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_nudEnableLimiter1StateChanged

    private void nudEnableFilter1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nudEnableFilter1StateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setAmpFilterEnable((byte) cv(nudChannel.getValue()), cbool((byte) cv(nudEnableFilter1.getValue())));
            String[] tempArgs = new String[2];
            tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
            tempArgs[1] = Boolean.toString(cbool((byte) cv(nudEnableFilter1.getValue())));
            etapa.exec("setAmpFilterEnable", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_nudEnableFilter1StateChanged

    private void nudEnableTone1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nudEnableTone1StateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setAmpToneEnable((byte) cv(nudChannel.getValue()), cbool((byte) cv(nudEnableTone1.getValue())));
            String[] tempArgs = new String[2];
            tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
            tempArgs[1] = Boolean.toString(cbool((byte) cv(nudEnableTone1.getValue())));
            etapa.exec("setAmpToneEnable", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_nudEnableTone1StateChanged

    private void nudTCLimiter1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nudTCLimiter1StateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setAmpTCLimiter((byte) cv(nudChannel.getValue()), cv(nudTCLimiter1.getValue()));
            String[] tempArgs = new String[2];
            tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
            tempArgs[1] = Integer.toString(cv(nudTCLimiter1.getValue()));
            etapa.exec("setAmpTCLimiter", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_nudTCLimiter1StateChanged

    private void nudDecayLimiter1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nudDecayLimiter1StateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setAmpDecayLimiter((byte) cv(nudChannel.getValue()), (byte) cv(nudDecayLimiter1.getValue()));
            String[] tempArgs = new String[2];
            tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
            tempArgs[1] = Byte.toString((byte) cv(nudDecayLimiter1.getValue()));
            etapa.exec("setAmpDecayLimiter", tempArgs, null);

        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_nudDecayLimiter1StateChanged

    private void nudThresHoldLimiter1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nudThresHoldLimiter1StateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setAmpThresholdLimiter((byte) cv(nudChannel.getValue()), (byte) cv(nudThresHoldLimiter1.getValue()));
            String[] tempArgs = new String[2];
            tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
            tempArgs[1] = Byte.toString((byte) cv(nudThresHoldLimiter1.getValue()));
            etapa.exec("setAmpThresholdLimiter", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_nudThresHoldLimiter1StateChanged

    private void nudFreqFilter1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nudFreqFilter1StateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setAmpFilter((byte) cv(nudChannel.getValue()), cv(nudFreqFilter1.getValue()), (byte) cv(tkbGainFilter1.getValue()));
            String[] tempArgs = new String[3];
            tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
            tempArgs[1] = Integer.toString(cv(nudFreqFilter1.getValue()));
            tempArgs[2] = Byte.toString((byte) cv(tkbGainFilter1.getValue()));
            etapa.exec("setAmpFilter", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_nudFreqFilter1StateChanged

    private void tkbGainFilter1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tkbGainFilter1StateChanged
        if (tkbGainFilter1.getValueIsAdjusting() == false) {
            lblGainFilter1.setText(String.valueOf(cv(tkbGainFilter1.getValue())));

            if (!(Automatico)) {
                return;
            }

            tmrRefresco.stop();
            try {
//                etapa.setAmpFilter((byte) cv(nudChannel.getValue()), cv(nudFreqFilter1.getValue()), (byte) cv(tkbGainFilter1.getValue()));
                String[] tempArgs = new String[3];
                tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
                tempArgs[1] = Integer.toString(cv(nudFreqFilter1.getValue()));
                tempArgs[2] = Byte.toString((byte) cv(tkbGainFilter1.getValue()));
                etapa.exec("setAmpFilter", tempArgs, null);
            } catch (UnsupportedDriverOperation ex) {
                logger.error(ex);
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (DriverException ex) {
                logger.error(ex);
                //                    System.err.println("-->AQUI-->");
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            tmrRefresco.start();
        }
    }//GEN-LAST:event_tkbGainFilter1StateChanged

    private void nudFreqTone1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nudFreqTone1StateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setAmpFrecTone((byte) cv(nudChannel.getValue()), cv(nudFreqTone1.getValue()));
            String[] tempArgs = new String[2];
            tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
            tempArgs[1] = Integer.toString(cv(nudFreqTone1.getValue()));
            etapa.exec("setAmpFrecTone", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_nudFreqTone1StateChanged

    private void tkbGainTone1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tkbGainTone1StateChanged
        if (tkbGainTone1.getValueIsAdjusting() == false) {
            lblGainTone1.setText(String.valueOf(tkbGainTone1.getValue()));

            if (!(Automatico)) {
                return;
            }

            tmrRefresco.stop();
            try {
//                etapa.setAmpGainTone((byte) cv(nudChannel.getValue()), (byte) cv(tkbGainTone1.getValue()));
                String[] tempArgs = new String[2];
                tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
                tempArgs[1] = Byte.toString((byte) cv(tkbGainTone1.getValue()));
                etapa.exec("setAmpGainTone", tempArgs, null);
            } catch (UnsupportedDriverOperation ex) {
                logger.error(ex);
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (DriverException ex) {
                logger.error(ex);
                //                    System.err.println("-->AQUI-->");
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            tmrRefresco.start();
        }
    }//GEN-LAST:event_tkbGainTone1StateChanged

    private void tkbDC1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tkbDC1StateChanged
        if (tkbDC1.getValueIsAdjusting() == false) {
            lblDC1.setText(String.valueOf(tkbDC1.getValue()));

            if (!(Automatico)) {
                return;
            }

            tmrRefresco.stop();
            try {
//                etapa.setAmpDC((byte) cv(nudChannel.getValue()), (short) cv(tkbDC1.getValue()));
                String[] tempArgs = new String[2];
                tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
                tempArgs[1] = Short.toString((short) cv(tkbDC1.getValue()));
                etapa.exec("setAmpDC", tempArgs, null);
            } catch (UnsupportedDriverOperation ex) {
                logger.error(ex);
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (DriverException ex) {
                logger.error(ex);
                //                    System.err.println("-->AQUI-->");
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            tmrRefresco.start();
        }
    }//GEN-LAST:event_tkbDC1StateChanged

    private void tkbGainInputPrioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tkbGainInputPrioStateChanged
        if (tkbGainInputPrio.getValueIsAdjusting() == false) {
            lblGainInputPrio.setText(String.valueOf(tkbGainInputPrio.getValue()));

            if (!(Automatico)) {
                return;
            }

            tmrRefresco.stop();
            try {
//                etapa.setAmpGainPrio((byte) cv(tkbGainInputPrio.getValue()));
                String[] tempArgs = new String[1];
                tempArgs[0] = Byte.toString((byte) cv(tkbGainInputPrio.getValue()));
                etapa.exec("setAmpGainPrio", tempArgs, null);
            } catch (UnsupportedDriverOperation ex) {
                logger.error(ex);
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (DriverException ex) {
                logger.error(ex);
                //                    System.err.println("-->AQUI-->");
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            tmrRefresco.start();
        }
    }//GEN-LAST:event_tkbGainInputPrioStateChanged

    private void nudFilterPrioBoostStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nudFilterPrioBoostStateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setAmpFilterPrio(
//                    (byte) cv(nudFilterPrioBoost.getValue()), 
//                    cv(nudFilterPrioFreq.getValue()), 
//                    cv(nudFilterPrioQ_Slope.getValue()), 
//                    (byte) cv(tkbFilterPrioGain.getValue()));
            String[] tempArgs = new String[4];
            tempArgs[0] = Byte.toString((byte) cv(nudFilterPrioBoost.getValue()));
            tempArgs[1] = Integer.toString(cv(nudFilterPrioFreq.getValue()));
            tempArgs[2] = Integer.toString(cv(nudFilterPrioQ_Slope.getValue()));
            tempArgs[3] = Byte.toString((byte) cv(tkbFilterPrioGain.getValue()));
            etapa.exec("setAmpFilterPrio", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_nudFilterPrioBoostStateChanged

    private void nudFilterPrioFreqStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nudFilterPrioFreqStateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setAmpFilterPrio((byte) cv(nudFilterPrioBoost.getValue()), cv(nudFilterPrioFreq.getValue()), cv(nudFilterPrioQ_Slope.getValue()), (byte) cv(tkbFilterPrioGain.getValue()));
            String[] tempArgs = new String[4];
            tempArgs[0] = Byte.toString((byte) cv(nudFilterPrioBoost.getValue()));
            tempArgs[1] = Integer.toString(cv(nudFilterPrioFreq.getValue()));
            tempArgs[2] = Integer.toString(cv(nudFilterPrioQ_Slope.getValue()));
            tempArgs[3] = Byte.toString((byte) cv(tkbFilterPrioGain.getValue()));
            etapa.exec("setAmpFilterPrio", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_nudFilterPrioFreqStateChanged

    private void nudFilterPrioQ_SlopeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nudFilterPrioQ_SlopeStateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setAmpFilterPrio(
//                    (byte) cv(nudFilterPrioBoost.getValue()), 
//                    cv(nudFilterPrioFreq.getValue()), 
//                    cv(nudFilterPrioQ_Slope.getValue()), 
//                    (byte) cv(tkbFilterPrioGain.getValue()));
            String[] tempArgs = new String[4];
            tempArgs[0] = Byte.toString((byte) cv(nudFilterPrioBoost.getValue()));
            tempArgs[1] = Integer.toString(cv(nudFilterPrioFreq.getValue()));
            tempArgs[2] = Integer.toString(cv(nudFilterPrioQ_Slope.getValue()));
            tempArgs[3] = Byte.toString((byte) cv(tkbFilterPrioGain.getValue()));
            etapa.exec("setAmpFilterPrio", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_nudFilterPrioQ_SlopeStateChanged

    private void tkbFilterPrioGainStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tkbFilterPrioGainStateChanged
        if (tkbFilterPrioGain.getValueIsAdjusting() == false) {
            lblFilterPrioGain.setText(String.valueOf(tkbFilterPrioGain.getValue()));

            if (!(Automatico)) {
                return;
            }

            tmrRefresco.stop();
            try {
//                etapa.setAmpFilterPrio((byte) cv(nudFilterPrioBoost.getValue()), cv(nudFilterPrioFreq.getValue()), cv(nudFilterPrioQ_Slope.getValue()), (byte) cv(tkbFilterPrioGain.getValue()));
                String[] tempArgs = new String[4];
                tempArgs[0] = Byte.toString((byte) cv(nudFilterPrioBoost.getValue()));
                tempArgs[1] = Integer.toString(cv(nudFilterPrioFreq.getValue()));
                tempArgs[2] = Integer.toString(cv(nudFilterPrioQ_Slope.getValue()));
                tempArgs[3] = Byte.toString((byte) cv(tkbFilterPrioGain.getValue()));
                etapa.exec("setAmpFilterPrio", tempArgs, null);
            } catch (UnsupportedDriverOperation ex) {
                logger.error(ex);
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (DriverException ex) {
                logger.error(ex);
                //                    System.err.println("-->AQUI-->");
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            tmrRefresco.start();
        }
    }//GEN-LAST:event_tkbFilterPrioGainStateChanged

    private void chkMuteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkMuteItemStateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setAmpChMute((byte) cv(nudChannel.getValue()), chkMute.isSelected());
            String[] tempArgs = new String[2];
            tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
            tempArgs[1] = Boolean.toString(chkMute.isSelected());
            etapa.exec("setAmpChMute", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_chkMuteItemStateChanged

    private void nudAddr_bundleStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nudAddr_bundleStateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
            if (chkCobraNetPrio.isSelected()) {
//                etapa.setAmpCobraNetPrio(cv(nudAddr_bundle.getValue()), (byte) cv(nudInput_channel.getValue()));
                String[] tempArgs = new String[2];
                tempArgs[0] = Integer.toString(cv(nudAddr_bundle.getValue()));
                tempArgs[1] = Byte.toString((byte) cv(nudInput_channel.getValue()));
                etapa.exec("setAmpCobraNetPrio", tempArgs, null);
            } else {
//                etapa.setCobraNet((byte) cv(nudChannel.getValue()), cv(nudAddr_bundle.getValue()), (byte) cv(nudInput_channel.getValue()));
                String[] tempArgs = new String[3];
                tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
                tempArgs[1] = Integer.toString(cv(nudAddr_bundle.getValue()));
                tempArgs[2] = Byte.toString((byte) cv(nudInput_channel.getValue()));
                etapa.exec("setCobraNet", tempArgs, null);
            }
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
            //                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_nudAddr_bundleStateChanged

    private void nudInput_channelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nudInput_channelStateChanged
        if (!(Automatico)) {
            return;
        }
        try {
            tmrRefresco.stop();
            if (chkCobraNetPrio.isSelected()) {
//                etapa.setAmpCobraNetPrio(cv(nudAddr_bundle.getValue()), (byte) cv(nudInput_channel.getValue()));
                String[] tempArgs = new String[2];
                tempArgs[0] = Integer.toString(cv(nudAddr_bundle.getValue()));
                tempArgs[1] = Byte.toString((byte) cv(nudInput_channel.getValue()));
                etapa.exec("setAmpCobraNetPrio", tempArgs, null);
            } else {
//                etapa.setCobraNet((byte) cv(nudChannel.getValue()), cv(nudAddr_bundle.getValue()), (byte) cv(nudInput_channel.getValue()));
                String[] tempArgs = new String[3];
                tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
                tempArgs[1] = Integer.toString(cv(nudAddr_bundle.getValue()));
                tempArgs[2] = Byte.toString((byte) cv(nudInput_channel.getValue()));
                etapa.exec("setCobraNet", tempArgs, null);
            }
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
            //                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_nudInput_channelStateChanged

    private void txtCobraNetNombreFuenteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCobraNetNombreFuenteFocusGained
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setCobraNetSupplyName((byte) cv(nudChannel.getValue()), txtCobraNetNombreFuente.getText());
            String[] tempArgs = new String[2];
            tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
            tempArgs[1] = txtCobraNetNombreFuente.getText();
            etapa.exec("setCobraNetSupplyName", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_txtCobraNetNombreFuenteFocusGained

    private void txtCobraNetNombreZonaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCobraNetNombreZonaFocusGained
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setCobraNetZoneName((byte) cv(nudChannel.getValue()), txtCobraNetNombreZona.getText());
            String[] tempArgs = new String[2];
            tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
            tempArgs[1] = txtCobraNetNombreZona.getText();
            etapa.exec("setCobraNetZoneName", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_txtCobraNetNombreZonaFocusGained

    private void btnCargaDefaultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCargaDefaultMouseClicked
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
            if (chkPresetsPrio.isSelected()) {
//                etapa.setAmpPresets((byte) 'P', (byte) 1);
                String[] tempArgs = new String[2];
                tempArgs[0] = Byte.toString((byte) 'P');
                tempArgs[1] = Byte.toString((byte) 1);
                etapa.exec("setAmpPresets", tempArgs, null);
            } else {
//                etapa.setAmpPresets((byte) cv(nudChannel.getValue()), (byte) 1);
                String[] tempArgs = new String[2];
                tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
                tempArgs[1] = Byte.toString((byte) 1);
                etapa.exec("setAmpPresets", tempArgs, null);
            }
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
            //                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_btnCargaDefaultMouseClicked

    private void btnGuardarDefaultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarDefaultMouseClicked
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
            if (chkPresetsPrio.isSelected()) {
//                etapa.setAmpPresets((byte) 'P', (byte) 2);
                String[] tempArgs = new String[2];
                tempArgs[0] = Byte.toString((byte) 'P');
                tempArgs[1] = Byte.toString((byte) 2);
                etapa.exec("setAmpPresets", tempArgs, null);
            } else {
//                etapa.setAmpPresets((byte) cv(nudChannel.getValue()), (byte) 2);
                String[] tempArgs = new String[2];
                tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
                tempArgs[1] = Byte.toString((byte) 2);
                etapa.exec("setAmpPresets", tempArgs, null);
            }
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
            //                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_btnGuardarDefaultMouseClicked

    private void btnCargarFabricaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCargarFabricaMouseClicked
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
            if (chkPresetsPrio.isSelected()) {
//                etapa.setAmpPresets((byte) 'P', (byte) 3);
                String[] tempArgs = new String[2];
                tempArgs[0] = Byte.toString((byte) 'P');
                tempArgs[1] = Byte.toString((byte) 3);
                etapa.exec("setAmpPresets", tempArgs, null);
            } else {
//                etapa.setAmpPresets((byte) cv(nudChannel.getValue()), (byte) 3);
                String[] tempArgs = new String[2];
                tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
                tempArgs[1] = Byte.toString((byte) 3);
                etapa.exec("setAmpPresets", tempArgs, null);
            }
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
            //                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_btnCargarFabricaMouseClicked

    private void chkPuertaRuidoPrioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkPuertaRuidoPrioItemStateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setAmpModePrioActive(chkPuertaRuidoPrio.isSelected());
            String[] tempArgs = new String[1];
            tempArgs[0] = Boolean.toString(chkPuertaRuidoPrio.isSelected());
            etapa.exec("setAmpModePrioActive", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_chkPuertaRuidoPrioItemStateChanged

    private void chkManiobra5vPrioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkManiobra5vPrioItemStateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setAmpLevelPrioActive(chkManiobra5vPrio.isSelected());
            String[] tempArgs = new String[1];
            tempArgs[0] = Boolean.toString(chkManiobra5vPrio.isSelected());
            etapa.exec("setAmpLevelPrioActive", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_chkManiobra5vPrioItemStateChanged

    private void nudUmbralPuertaRuidoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nudUmbralPuertaRuidoStateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setAmpThresHoldActivePrio((byte) cv(nudUmbralPuertaRuido.getValue()));
            String[] tempArgs = new String[1];
            tempArgs[0] = Byte.toString((byte) cv(nudUmbralPuertaRuido.getValue()));
            etapa.exec("setAmpThresHoldActivePrio", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_nudUmbralPuertaRuidoStateChanged

    private void chkConfiguracionEntradaDigitalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkConfiguracionEntradaDigitalItemStateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setAmpModeAudioInput(chkConfiguracionEntradaDigital.isSelected());
            String[] tempArgs = new String[1];
            tempArgs[0] = Boolean.toString(chkConfiguracionEntradaDigital.isSelected());
            etapa.exec("setAmpModeAudioInput", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_chkConfiguracionEntradaDigitalItemStateChanged

    private void txtCobraNetNombreFuenteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCobraNetNombreFuenteFocusLost
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setCobraNetSupplyName((byte) cv(nudChannel.getValue()), txtCobraNetNombreFuente.getText());
            String[] tempArgs = new String[2];
            tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
            tempArgs[1] = txtCobraNetNombreFuente.getText();
            etapa.exec("setCobraNetSupplyName", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_txtCobraNetNombreFuenteFocusLost

    private void txtCobraNetNombreZonaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCobraNetNombreZonaFocusLost
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setCobraNetZoneName((byte) cv(nudChannel.getValue()), txtCobraNetNombreZona.getText());
            String[] tempArgs = new String[2];
            tempArgs[0] = Byte.toString((byte) cv(nudChannel.getValue()));
            tempArgs[1] = txtCobraNetNombreZona.getText();
            etapa.exec("setCobraNetZoneName", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_txtCobraNetNombreZonaFocusLost

    private void rb2200ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rb2200ItemStateChanged
        if (!(Automatico)) {
            return;
        }

        if (rb2200.isSelected()) {
            tmrRefresco.stop();
            try {
//                etapa.setSTVModel((byte) 1);
                String[] tempArgs = new String[1];
                tempArgs[0] = Byte.toString((byte) 1);
                etapa.exec("setSTVModel", tempArgs, null);
            } catch (UnsupportedDriverOperation ex) {
                logger.error(ex);
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (DriverException ex) {
                logger.error(ex);
                //                    System.err.println("-->AQUI-->");
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            tmrRefresco.start();
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(null, config.getString("RESTART_STV_MSG"));
        }
    }//GEN-LAST:event_rb2200ItemStateChanged

    private void rb2400ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rb2400ItemStateChanged
        if (!(Automatico)) {
            return;
        }

        if (rb2400.isSelected()) {
            tmrRefresco.stop();
            try {
//                etapa.setSTVModel((byte) 2);
                String[] tempArgs = new String[1];
                tempArgs[0] = Byte.toString((byte) 2);
                etapa.exec("setSTVModel", tempArgs, null);
            } catch (UnsupportedDriverOperation ex) {
                logger.error(ex);
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (DriverException ex) {
                logger.error(ex);
                //                    System.err.println("-->AQUI-->");
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            tmrRefresco.start();
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(null, config.getString("RESTART_STV_MSG"));
        }
    }//GEN-LAST:event_rb2400ItemStateChanged

    private void rb2800ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rb2800ItemStateChanged
        if (!(Automatico)) {
            return;
        }

        if (rb2800.isSelected()) {
            tmrRefresco.stop();
            try {
//                etapa.setSTVModel((byte) 3);
                String[] tempArgs = new String[1];
                tempArgs[0] = Byte.toString((byte) 3);
                etapa.exec("setSTVModel", tempArgs, null);
            } catch (UnsupportedDriverOperation ex) {
                logger.error(ex);
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (DriverException ex) {
                logger.error(ex);
                //                    System.err.println("-->AQUI-->");
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            tmrRefresco.start();
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(null, config.getString("RESTART_STV_MSG"));
        }
    }//GEN-LAST:event_rb2800ItemStateChanged

    private void rb4200ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rb4200ItemStateChanged
        if (!(Automatico)) {
            return;
        }

        if (rb4200.isSelected()) {
            tmrRefresco.stop();
            try {
//                etapa.setSTVModel((byte) 4);
                String[] tempArgs = new String[1];
                tempArgs[0] = Byte.toString((byte) 4);
                etapa.exec("setSTVModel", tempArgs, null);
            } catch (UnsupportedDriverOperation ex) {
                logger.error(ex);
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (DriverException ex) {
                logger.error(ex);
                //                    System.err.println("-->AQUI-->");
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            tmrRefresco.start();
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(null, config.getString("RESTART_STV_MSG"));
        }
    }//GEN-LAST:event_rb4200ItemStateChanged

    private void rb4400ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rb4400ItemStateChanged
        if (!(Automatico)) {
            return;
        }

        if (rb4400.isSelected()) {
            tmrRefresco.stop();
            try {
//                etapa.setSTVModel((byte) 5);
                String[] tempArgs = new String[1];
                tempArgs[0] = Byte.toString((byte) 5);
                etapa.exec("setSTVModel", tempArgs, null);
            } catch (UnsupportedDriverOperation ex) {
                logger.error(ex);
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (DriverException ex) {
                logger.error(ex);
                //                    System.err.println("-->AQUI-->");
                JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            tmrRefresco.start();
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(null, config.getString("RESTART_STV_MSG"));
        }
    }//GEN-LAST:event_rb4400ItemStateChanged

    private void nudChannelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nudChannelStateChanged
        try {
            STVInfo tempSTVInfo = null;
            tempSTVInfo = (STVInfo) (etapa.exec("getInfo", null, null))[0];
            if ((byte) cv(nudChannel.getValue()) > tempSTVInfo.num_canales) {
                nudChannel.setValue(tempSTVInfo.num_canales);
            }
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_nudChannelStateChanged

    private void chkCobraNetItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkCobraNetItemStateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
            String[] tempArgs = new String[1];
            tempArgs[0] = Boolean.toString(chkCobraNet.isSelected());
            etapa.exec("setCM2Enable", tempArgs, null);
//            etapa.setCM2Enable(chkCobraNet.isSelected());
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
        System.err.println("-->AQUI-->");
        JOptionPane.showMessageDialog(null, config.getString("RESTART_STV_MSG"));
    }//GEN-LAST:event_chkCobraNetItemStateChanged

    private void chkSDCardItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkSDCardItemStateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setSDCardEnable(chkSDCard.isSelected());
            String[] tempArgs = new String[1];
            tempArgs[0] = Boolean.toString(chkSDCard.isSelected());
            etapa.exec("setSDCardEnable", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
        System.err.println("-->AQUI-->");
        JOptionPane.showMessageDialog(null, config.getString("RESTART_STV_MSG"));
    }//GEN-LAST:event_chkSDCardItemStateChanged

    private void chkPower_OnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkPower_OnItemStateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setPowerOn(chkPower_On.isSelected());
            String[] tempArgs = new String[1];
            tempArgs[0] = Boolean.toString(chkPower_On.isSelected());
            etapa.exec("setPowerOn", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_chkPower_OnItemStateChanged

    private void chkEnableCobraNetPrioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkEnableCobraNetPrioItemStateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setAmpCobraNetPrioModeEnable(chkEnableCobraNetPrio.isSelected());
            String[] tempArgs = new String[1];
            tempArgs[0] = Boolean.toString(chkEnableCobraNetPrio.isSelected());
            etapa.exec("setAmpCobraNetPrioModeEnable", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_chkEnableCobraNetPrioItemStateChanged

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setSoftwareReset();
            etapa.exec("setSoftwareReset", null, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_btnResetMouseClicked

    private void ckEnableEtherNetItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckEnableEtherNetItemStateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setEtherNetEnable(ckEnableEtherNet.isSelected());
            String[] tempArgs = new String[1];
            tempArgs[0] = Boolean.toString(ckEnableEtherNet.isSelected());
            etapa.exec("setEtherNetEnable", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//                    System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_ckEnableEtherNetItemStateChanged

    private void btBorrarLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btBorrarLogoMouseClicked
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
            //            etapa.setDeleteFrontalLogo();
            etapa.exec("setDeleteFrontalLogo", null, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//            System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
    }//GEN-LAST:event_btBorrarLogoMouseClicked

    private void nudDelayArranqueStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nudDelayArranqueStateChanged
        if (!(Automatico)) {
            return;
        }

        tmrRefresco.stop();
        try {
//            etapa.setDelayBootSupply((byte) cv(nudDelayArranque.getValue()));
            String[] tempArgs = new String[1];
            tempArgs[0] = Byte.toString((byte) cv(nudDelayArranque.getValue()));
            etapa.exec("setDelayBootSupply", tempArgs, null);
        } catch (UnsupportedDriverOperation ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DriverException ex) {
            logger.error(ex);
//            System.err.println("-->AQUI-->");
            JOptionPane.showMessageDialog(CobiVentana.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tmrRefresco.start();
}//GEN-LAST:event_nudDelayArranqueStateChanged

    private void txtIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIPActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        try {
            PropertyConfigurator.configure(config.getString("LOG4J.PROPERTIES"));
            logger.info("Locale" + " (" + Locale.getDefault().getDisplayLanguage() + ", " + Locale.getDefault().getDisplayCountry() + ").");

          //  PluginFinder pluginFinder = new PluginFinder();    
          //  etapa = (IDriver) (pluginFinder.searchImpl("./lib", config.getString("STV"))).newInstance();
            etapa = new STVImpl();
            
            java.awt.EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    CobiVentana w = new CobiVentana(config.getString("LOOK_AND_FEEL"));
                    w.setVisible(true);
                }
            });
        } catch (NullPointerException ex) {
            logger.error(ex);
//        } catch (InstantiationException ex) {
//            logger.error(ex);
//        } catch (IllegalAccessException ex) {
//            logger.error(ex);
        }
    }

    private byte myCByte(boolean a) {
        return (byte) ((a) ? 1 : 0);
    }

    private boolean cbool(byte n) {
        return (n == 0) ? false : true;
    }

    private short bv(short a) {
        return (short) (a & 0xFF);
    }

    private int cv(Object ob) {
        return Integer.parseInt(ob.toString());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ChkErrFrontal;
    private javax.swing.JButton btBorraIncidencias;
    private javax.swing.JButton btBorrarLogo;
    private javax.swing.JButton btnCargaDefault;
    private javax.swing.JButton btnCargarFabrica;
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnGuardarDefault;
    private javax.swing.JButton btnReset;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chkCobraNet;
    private javax.swing.JCheckBox chkCobraNetPrio;
    private javax.swing.JCheckBox chkConfiguracionEntradaDigital;
    private javax.swing.JCheckBox chkEnableCobraNetPrio;
    private javax.swing.JCheckBox chkErr12V;
    private javax.swing.JCheckBox chkErr230I;
    private javax.swing.JCheckBox chkErr230V;
    private javax.swing.JCheckBox chkErr3008;
    private javax.swing.JCheckBox chkErrCarga;
    private javax.swing.JCheckBox chkErrCobraNet;
    private javax.swing.JCheckBox chkErrComunicacion;
    private javax.swing.JCheckBox chkErrMod1;
    private javax.swing.JCheckBox chkErrMod2;
    private javax.swing.JCheckBox chkErrRAM;
    private javax.swing.JCheckBox chkErrSobreTempETX;
    private javax.swing.JCheckBox chkErrTempETX;
    private javax.swing.JCheckBox chkErrVP1;
    private javax.swing.JCheckBox chkErrVP2;
    private javax.swing.JCheckBox chkManiobra5vPrio;
    private javax.swing.JCheckBox chkMute;
    private javax.swing.JCheckBox chkPower_On;
    private javax.swing.JCheckBox chkPresetsPrio;
    private javax.swing.JCheckBox chkPuertaRuidoPrio;
    private javax.swing.JCheckBox chkSDCard;
    private javax.swing.JCheckBox ckEnableEtherNet;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblDC1;
    private javax.swing.JLabel lblEqInputGain1;
    private javax.swing.JLabel lblFilterPrioGain;
    private javax.swing.JLabel lblGainFilter1;
    private javax.swing.JLabel lblGainInput1;
    private javax.swing.JLabel lblGainInputPrio;
    private javax.swing.JLabel lblGainLinearInput1;
    private javax.swing.JLabel lblGainLinearInputPrio;
    private javax.swing.JLabel lblGainOutput1;
    private javax.swing.JLabel lblGainTone1;
    private javax.swing.JLabel lblLink;
    private javax.swing.JLabel lblMuestras;
    private javax.swing.JLabel lblTemp;
    private javax.swing.JLabel lblTempAmbiente;
    private javax.swing.JLabel lblclave;
    private javax.swing.JLabel lbltempplaca;
    private javax.swing.JSpinner nudAddr_bundle;
    private javax.swing.JSpinner nudChannel;
    private javax.swing.JSpinner nudDecayLimiter1;
    private javax.swing.JSpinner nudDelayArranque;
    private javax.swing.JSpinner nudEnableFilter1;
    private javax.swing.JSpinner nudEnableLimiter1;
    private javax.swing.JSpinner nudEnableLoudNess1;
    private javax.swing.JSpinner nudEnableTone1;
    private javax.swing.JSpinner nudEqInputBand1;
    private javax.swing.JSpinner nudEqInputBoost1;
    private javax.swing.JSpinner nudEqInputEnable1;
    private javax.swing.JSpinner nudEqInputFreq1;
    private javax.swing.JSpinner nudEqInputQ_Slope1;
    private javax.swing.JSpinner nudFilterPrioBoost;
    private javax.swing.JSpinner nudFilterPrioFreq;
    private javax.swing.JSpinner nudFilterPrioQ_Slope;
    private javax.swing.JSpinner nudFreqFilter1;
    private javax.swing.JSpinner nudFreqTone1;
    private javax.swing.JSpinner nudInput_channel;
    private javax.swing.JSpinner nudTCLimiter1;
    private javax.swing.JSpinner nudThresHoldLimiter1;
    private javax.swing.JSpinner nudUmbralPuertaRuido;
    private javax.swing.JRadioButton rb2200;
    private javax.swing.JRadioButton rb2400;
    private javax.swing.JRadioButton rb2800;
    private javax.swing.JRadioButton rb4200;
    private javax.swing.JRadioButton rb4400;
    private javax.swing.JSlider tkbDC1;
    private javax.swing.JSlider tkbEqInputGain1;
    private javax.swing.JSlider tkbFilterPrioGain;
    private javax.swing.JSlider tkbGainFilter1;
    private javax.swing.JSlider tkbGainInput1;
    private javax.swing.JSlider tkbGainInputPrio;
    private javax.swing.JSlider tkbGainLinearInput1;
    private javax.swing.JSlider tkbGainLinearInputPrio;
    private javax.swing.JSlider tkbGainOutput1;
    private javax.swing.JSlider tkbGainTone1;
    private javax.swing.JTextField txtCobraNetNombreFuente;
    private javax.swing.JTextField txtCobraNetNombreZona;
    private javax.swing.JTextField txtIP;
    private javax.swing.JTextArea txtLog;
    // End of variables declaration//GEN-END:variables
}
