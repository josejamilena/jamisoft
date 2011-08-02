package es.lda.core.network.impl;

import es.lda.core.event.interfaces.DataEvent;
import es.lda.core.network.IUdp;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Arrays;
import org.apache.log4j.Logger;

/**
 * Comunication Protocol Implementation.
 * 
 * @author Jose Antonio
 */
public class UdpMT implements IUdp {

    /** Logger. */
    private static Logger logger = Logger.getLogger(UdpMT.class);
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

    /**
     * Constructor.
     */
    public UdpMT() {
        defaultPort();
    }

    /**
     * Constructor.
     * @param bufferSize buffer size
     */
    public UdpMT(int bufferSize) {
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
    @Override
    public void sendData(String Data) {
        try {
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
    @Override
    public void sendData(byte[] Data) {
        try {
            this.remoteSocketAddress = null;
            logger.info("Remote host: " + remoteHost);
            logger.info("Remote port: " + remotePortNum);
            this.remoteSocketAddress = new InetSocketAddress(remoteHost, remotePortNum);
            if (Data != null) {
                this.outputMsg = new DatagramPacket(Data, Data.length, this.remoteSocketAddress);
                if (this.udpSck == null) {
                    this.udpSck = new DatagramSocket(this.localSocketAddress);
                }
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

    @Override
    public String getData() /*throws UnsupportedEncodingException*/ {
        String cadena = "";
        cadena = new String(this.bufferUdp, 0, this.bufferUdpSize/*, "ISO-8859-1"*/);
        //this.bufferUdpSize = 0;
        return cadena;
    }

    @Override
    public byte[] getDataByte() {
        byte[] buffer = null;
        System.arraycopy(this.bufferUdp, 0, buffer, 0, this.bufferUdpSize);
        return buffer;
    }

    /**
     * Bind localSocketAddress. Listening.
     */
    @Override
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
    @Override
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
    @Override
    public int getPortNum() {
        logger.info("Get Port: " + portNum);
        return portNum;
    }

    /**
     * Set.
     * @param portNum Number.
     */
    @Override
    public void setPortNum(int portNum) {
        logger.info("Set Port: " + portNum);
        this.portNum = portNum;
    }

    /**
     * Get.
     * @return String.
     */
    @Override
    public String getRemoteHost() {
        logger.info("Get Remote Host: " + remoteHost);
        return remoteHost;
    }

    /**
     * Set.
     * @param remoteHost Number. 
     */
    @Override
    public void setRemoteHost(String remoteHost) {
        logger.info("Set Remote Host: " + remoteHost);
        this.remoteHost = remoteHost;
    }

    /**
     * Get.
     * @return String. 
     */
    @Override
    public int getRemotePortNum() {
        logger.info("Get Remote port: " + remotePortNum);
        return remotePortNum;
    }

    /**
     * Set.
     * @param remotePortNum Number. 
     */
    @Override
    public void setRemotePortNum(int remotePortNum) {
        logger.info("Set Remote port: " + remotePortNum);
        this.remotePortNum = remotePortNum;
    }

    /**
     * Get.
     * @return String. 
     */
    @Override
    public int getRemotePort() {
        logger.info("Get Remote port: " + remotePortNum);
        return remotePortNum;
    }

    /**
     * Set.
     * @param remotePortNum Number. 
     */
    @Override
    public void setRemotePort(int remotePortNum) {
        logger.info("Get Remote port: " + remotePortNum);
        this.remotePortNum = remotePortNum;
    }

    /**
     * Get DataEvent.
     * @return DataEvent.
     */
    @Override
    public DataEvent getListener() {
        return listener;
    }

    /**
     * Set DataEvent.
     * @param listener DataEvent. 
     */
    @Override
    public void setListener(DataEvent listener) {
        this.listener = listener;
//        this.t = null;
        this.udpSck = null;
    }

    public static UdpListener getUdpListener() {
        return t;
    }

    public static void setUdpListener(UdpListener t) {
        UdpMT.t = t;
    }

    @Override
    public void setNumData2Rec(int n) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getNumData2Rec() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * UdpMT manager.
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




            int leidos = 0;
            byte[] buffer = new byte[maxBufferSize];
            while (!this.Abort) {
                try {
                    Thread.sleep(1L);
                    UdpMT.this.inputMsg = new DatagramPacket(buffer, buffer.length);
                    UdpMT.this.udpSck.receive(UdpMT.this.inputMsg);
                    logger.debug("Received: " + UdpMT.this.inputMsg);
                    leidos = UdpMT.this.inputMsg.getLength();
                    logger.debug("Received length: " + leidos);
                    if (leidos > 0) {
                        UdpMT.this.bufferUdpSize = (short) leidos;
                        System.arraycopy(UdpMT.this.inputMsg.getData(), 0, UdpMT.this.bufferUdp, 0, UdpMT.this.bufferUdpSize);
                        debug();
                        UdpMT.this.listener.dataArrival(UdpMT.this.bufferUdpSize);
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

        public void debug() {
            System.err.println();
            System.err.println("::Start_Received::");
            System.err.print("\t");
            for (int i = 0; i < UdpMT.this.bufferUdpSize; i++) {
                System.err.print((char) bufferUdp[i]);
            }
            System.err.println();
            System.err.println("::End_Received::");
            //System.err.println();
        }
    }
}
