package es.lda.core.network;

import es.lda.core.event.interfaces.DataEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * Comunication Protocol Implementation.
 * 
 * @author Jose Antonio
 */
public class Udp {

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
    private UdpListener t = null;
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


    /**
     * Constructor.
     */
    public Udp() {
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
            this.remoteSocketAddress = null;
//            System.err.println(remoteHost);
//            System.err.println(remotePortNum);
            this.remoteSocketAddress = new InetSocketAddress(remoteHost, remotePortNum);            
            this.outputMsg = new DatagramPacket(Data.getBytes("ISO-8859-1"), Data.length(), this.remoteSocketAddress);
            this.udpSck.send(this.outputMsg);            
        } catch (SocketException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    /**
     * Send data to target.
     * 
     * @param Data as byte array.
     */
    public void sendData(byte[] Data) {
        try {
            this.remoteSocketAddress = null;
//            System.err.println(remoteHost);
//            System.err.println(remotePortNum);            
            this.remoteSocketAddress = new InetSocketAddress(remoteHost, remotePortNum);
            if (Data != null) {
                this.outputMsg = new DatagramPacket(Data, Data.length, this.remoteSocketAddress);
                this.udpSck.send(this.outputMsg);
            }
        } catch (SocketException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    
    public String getData() /*throws UnsupportedEncodingException*/ {
        String cadena = "";
        cadena = new String(this.bufferUdp, 0, this.bufferUdpSize /*, "ISO-8859-1"*/ );
        this.bufferUdpSize = 0;
        return cadena;
    }

    public void getDataByte(byte[] buffer) {
        System.arraycopy(this.bufferUdp, 0, buffer, 0, this.bufferUdpSize);
        this.bufferUdpSize = 0;
    }    

    /**
     * Bind localSocketAddress. Listening.
     */
    public void bind() {
        try {
            this.udpSck = new DatagramSocket(this.localSocketAddress);
            if (this.t == null) {
                this.t = new UdpListener();
                this.t.start();
            }
        } catch (SocketException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    /**
     * Close socket.
     */
    public void close() {
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
            System.err.println(e);
        }
    }

    /**
     * Get.
     * @return String.
     */
    public int getPortNum() {
        return portNum;
    }

    /**
     * Set.
     * @param portNum Number.
     */
    public void setPortNum(int portNum) {
        this.portNum = portNum;
    }

    /**
     * Get.
     * @return String.
     */
    public String getRemoteHost() {
        return remoteHost;
    }

    /**
     * Set.
     * @param remoteHost Number. 
     */
    public void setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
    }

    /**
     * Get.
     * @return String. 
     */
    public int getRemotePortNum() {
        return remotePortNum;
    }

    /**
     * Set.
     * @param remotePortNum Number. 
     */
    public void setRemotePortNum(int remotePortNum) {
        this.remotePortNum = remotePortNum;
    }
    
    /**
     * Get.
     * @return String. 
     */
    public int getRemotePort() {
        return remotePortNum;
    }

    /**
     * Set.
     * @param remotePortNum Number. 
     */
    public void setRemotePort(int remotePortNum) {
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
    }    
    
    /**
     * Udp manager.
     */
    class UdpListener extends Thread {

        /** Control. */
        boolean Abort = false;        
       
        /** Constructor. */
        public UdpListener() {
        }

        /**
         * Threat main method.
         */
        @Override
        public void run() {
            int leidos = 0;
            byte[] buffer = new byte[1500];
            while (!this.Abort) {
                try {
                    Thread.sleep(1L);
                    Udp.this.inputMsg = new DatagramPacket(buffer, buffer.length);
                    Udp.this.udpSck.receive(Udp.this.inputMsg);
                    leidos = Udp.this.inputMsg.getLength();

                    if (leidos > 0) {
                        Udp.this.bufferUdpSize = (short) leidos;
                        Udp.this.bufferUdp = Udp.this.inputMsg.getData();
                        Udp.this.listener.dataArrival(Udp.this.bufferUdpSize);
                    }
                } catch (SocketException e) {
                    this.Abort = true;
                    if (!e.getMessage().equals("socket closed")) {
                        System.err.println(e);
                    }
                } catch (IOException e) {
                    this.Abort = true;
                    System.err.println(e);
                } catch (IllegalArgumentException e) {
                    System.err.println(e);
                } catch (Exception e) {
                    this.Abort = true;
                    System.err.println(e);
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
       
    }
}
