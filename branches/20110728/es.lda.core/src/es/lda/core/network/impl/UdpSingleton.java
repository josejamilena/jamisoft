package es.lda.core.network.impl;

import es.lda.core.event.interfaces.DataEvent;
import es.lda.core.lib.util.TimeStamp;
import es.lda.core.network.IUdp;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import org.apache.log4j.Logger;

/**
 * Comunication Protocol Implementation.
 * 
 * @author Jose Antonio
 */
public class UdpSingleton implements IUdp {

    /* Package Number. */
    private int pkgN = 1;
    /** Logger. */
    private static Logger logger = Logger.getLogger(UdpSingleton.class);
    /** Max buffer size. */
    public static int maxBufferSize = 1500;
    /** Buffer */
    private byte[] bufferUdp = new byte[maxBufferSize];
    /** Local SocketAddress. */
    private InetSocketAddress localSocketAddress = null;
    /** Local Port Number. */
    private int portNum;
    /** Remote SocketAddress. */
    private InetSocketAddress remoteSocketAddress = new InetSocketAddress("0.0.0.0", 0);
    /** Remote Host. */
    private String remoteHost;
    /** Remote Port. */
    private int remotePortNum;
    /** Socket. */
    private DatagramSocket udpSck = null;
    /** UdpListener. */
    private static UdpListener t = null;
    /** Output message. */
    private DatagramPacket outputMsg = null;
    /** Input message. */
    private DatagramPacket inputMsg = null;
    /** Read size. */
    private short bufferUdpSize = 0;
    /** Event. */
    private DataEvent listener;
    /** Boolean End Flag*/
    private boolean end;
    public static boolean singleton = false;
    /** number data to recieve */
    private static int num2Recibir = 0;

    /**
     * Constructor.
     */
    public UdpSingleton() {
        defaultPort();
    }

    /**
     * Constructor.
     * @param bufferSize buffer size
     */
    public UdpSingleton(int bufferSize) {
        maxBufferSize = bufferSize;
        defaultPort();
    }

    /**
     * Set default port.
     */
    private void defaultPort() {
        int nport = 1024;
        boolean v = false;
        while ((!v) && (nport != 65536)) {
            try {
                this.localSocketAddress = new InetSocketAddress(nport);
                this.udpSck = new DatagramSocket(this.localSocketAddress);
                v = true;
            } catch (SocketException e) {
                v = false;
                nport++;
            }
        }
        this.udpSck.close();
        this.udpSck = null;
    }

    /**
     * Send data to target.
     * 
     * @param Data as String.
     */
    public void sendData(String Data) {
        try {
            UdpSingleton.num2Recibir++;
            this.remoteSocketAddress = null;
            logger.info("Remote host: " + remoteHost);
            logger.info("Remote port: " + remotePortNum);
            this.remoteSocketAddress = new InetSocketAddress(remoteHost, remotePortNum);
            this.outputMsg = new DatagramPacket(Data.getBytes("ISO-8859-1"), Data.length(), this.remoteSocketAddress);
            if (this.udpSck == null) {
                this.udpSck = new DatagramSocket(this.localSocketAddress);
            }
            this.udpSck.send(this.outputMsg);
        } catch (SocketException e) {
            logger.error(e);
        } catch (IOException e) {
            logger.error(e);
        } finally {
            this.remoteSocketAddress = null;
        }
    }

    /**
     * Send data to target.
     * 
     * @param Data as byte array.
     */
    public void sendData(byte[] Data) {
        try {
            UdpSingleton.num2Recibir++;
            this.remoteSocketAddress = null;
            logger.info("Remote host: " + remoteHost);
            logger.info("Remote port: " + remotePortNum);
            this.remoteSocketAddress = new InetSocketAddress(remoteHost, remotePortNum);
            if (Data != null) {
                this.outputMsg = new DatagramPacket(Data, Data.length, this.remoteSocketAddress);
                if (this.udpSck == null) {
                    this.udpSck = new DatagramSocket(this.localSocketAddress);
                }
                debugSend(this.outputMsg.getData() + "");
                this.udpSck.send(this.outputMsg);                
            }
        } catch (SocketException e) {
            logger.error(e);
        } catch (IOException e) {
            logger.error(e);
        } finally {
            this.remoteSocketAddress = null;
        }
    }

    public String getData() /*throws UnsupportedEncodingException*/ {
        String cadena = "";
        cadena = new String(this.bufferUdp, 0, this.bufferUdpSize/*, "ISO-8859-1"*/);
        //this.bufferUdpSize = 0;
        return cadena;
    }

    public byte[] getDataByte() {
        byte[] buffer = null;
        System.arraycopy(this.bufferUdp, 0, buffer, 0, this.bufferUdpSize);
        return buffer;
    }

    /**
     * Bind localSocketAddress. Listening.
     */
    public void bind() {
        logger.info("bind()");
        try {
            if (this.udpSck == null) {
                this.udpSck = new DatagramSocket(this.localSocketAddress);
            }
            if (this.t == null) {
                this.t = new UdpListener();
                this.t.start();
            }
        } catch (SocketException e) {
            logger.error(e);
        } catch (IOException e) {
            logger.error(e);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    /**
     * Close socket.
     */
    public void close() {
        logger.info("close()");
        try {
            if (this.t != null) {
                Thread.sleep(50L);
                this.t = null;
            }
            this.udpSck.close();
            this.udpSck = null;
            this.remoteSocketAddress = null;
            this.localSocketAddress = null;
            this.listener = null;
        } catch (Exception e) {
            logger.error(e);
        }
    }

    /**
     * Get.
     * @return String.
     */
    public int getPortNum() {
        logger.info("Get Port: " + portNum);
        return portNum;
    }

    /**
     * Set.
     * @param portNum Number.
     */
    public void setPortNum(int portNum) {
        logger.info("Set Port: " + portNum);
        this.portNum = portNum;
    }

    /**
     * Get.
     * @return String.
     */
    public String getRemoteHost() {
        logger.info("Get Remote Host: " + remoteHost);
        return remoteHost;
    }

    /**
     * Set.
     * @param remoteHost Number. 
     */
    public void setRemoteHost(String remoteHost) {
        logger.info("Set Remote Host: " + remoteHost);
        this.remoteHost = remoteHost;
    }

    /**
     * Get.
     * @return String. 
     */
    public int getRemotePortNum() {
        logger.info("Get Remote port: " + remotePortNum);
        return remotePortNum;
    }

    /**
     * Set.
     * @param remotePortNum Number. 
     */
    public void setRemotePortNum(int remotePortNum) {
        logger.info("Set Remote port: " + remotePortNum);
        this.remotePortNum = remotePortNum;
    }

    /**
     * Get.
     * @return String. 
     */
    public int getRemotePort() {
        logger.info("Get Remote port: " + remotePortNum);
        return remotePortNum;
    }

    /**
     * Set.
     * @param remotePortNum Number. 
     */
    public void setRemotePort(int remotePortNum) {
        logger.info("Get Remote port: " + remotePortNum);
        this.remotePortNum = remotePortNum;
    }

    /**
     * Get DataEvent.
     * @return DataEvent.
     */
    public DataEvent getListener() {
        return listener;
    }

    /**
     * Set DataEvent.
     * @param listener DataEvent. 
     */
    public void setListener(DataEvent listener) {
        this.listener = listener;
//        this.t = null;
        this.udpSck = null;
    }

    public static UdpListener getUdpListener() {
        return t;
    }

    public static void setUdpListener(UdpListener t) {
        UdpSingleton.t = t;
    }

    @Override
    public void setNumData2Rec(int n) {
        this.num2Recibir = n;
    }

    @Override
    public int getNumData2Rec() {
        return this.num2Recibir;
    }

    /**
     * UdpSingleton manager.
     */
    class UdpListener extends Thread {

        /** Control. */
        boolean Abort = false;

        /** Constructor. */
        public UdpListener() {
            logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        }

        /**
         * Threat main method.
         */
        @Override
        public void run() {
            logger.debug("EXECUTING : " + Thread.currentThread().getStackTrace()[1].getMethodName());
            if (!singleton) {
                logger.info("run()");

                boolean Abort = false;

                int leidos = 0;
                byte[] buffer = new byte[maxBufferSize];
                try {
                    while (!Abort) {
                        UdpSingleton.this.inputMsg = new DatagramPacket(buffer, buffer.length);
                        UdpSingleton.this.udpSck.receive(UdpSingleton.this.inputMsg);
                        logger.debug("Received: " + UdpSingleton.this.inputMsg);
                        leidos = UdpSingleton.this.inputMsg.getLength();
                        logger.debug("Received length: " + leidos);
                        if (leidos > 0) {
                            UdpSingleton.this.bufferUdpSize = (short) leidos;
                            System.arraycopy(UdpSingleton.this.inputMsg.getData(), 0, UdpSingleton.this.bufferUdp, 0, UdpSingleton.this.bufferUdpSize);
                            debugReceived();
                            UdpSingleton.this.listener.dataArrival(UdpSingleton.this.bufferUdpSize);
                            UdpSingleton.num2Recibir--;
                        }
                        Abort = UdpSingleton.num2Recibir <= 0;
                    }
                } catch (SocketException e) {
                    Abort = true;
                    if (!e.getMessage().equals("socket closed")) {
                        System.err.println(e);
                    }
                } catch (IOException e) {
                    Abort = true;
                    logger.error(e);
                } catch (IllegalArgumentException e) {
                    logger.error(e);
                } catch (Exception e) {
                    Abort = true;
                    logger.error(e);
                } finally {
//                    UdpSingleton.setUdpListener(null);
                }
            }
        }

        /**
         * Get.
         * @return boolean.
         */
        public boolean isAbort() {
            return Abort;
        }

        /**
         * Set.
         * @param Abort boolean.
         */
        public void setAbort(boolean Abort) {
            this.Abort = Abort;
        }

        public void debugReceived() {
            System.err.println();
            System.err.println("::" + pkgN + "::");
            pkgN++;
            System.err.println(TimeStamp.now());
            System.err.println("::Start_Received::");
            System.err.print("\t");
            for (int i = 0; i < UdpSingleton.this.bufferUdpSize; i++) {
                System.err.print((char) bufferUdp[i]);
            }
            System.err.println();
            System.err.println("::End_Received::");
//            System.err.flush();            
            //System.err.println();
        }
    }

    public void debugSend(String data) {
        System.err.println();
        System.err.println(TimeStamp.now());
        System.err.println("::Start_Send::");
        System.err.print("\t");
        System.err.print(data);
        System.err.println();
        System.err.println("::End_Send::");
//        System.err.flush();
    }
}
