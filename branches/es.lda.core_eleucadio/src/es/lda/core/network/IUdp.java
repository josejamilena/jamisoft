package es.lda.core.network;

import es.lda.core.event.interfaces.DataEvent;

/**
 *
 * @author Jose Antonio
 */
public interface IUdp {

//    /** UDP_SINGLETON */
//    public static int UDP_SINGLETON=0;
//    
//    /** UDP_MULTITHREAT. */    
//    public static int UDP_MULTITHREAT=1;   
    
    /**
     * Bind localSocketAddress. Listening.
     */
    void bind();

    /**
     * Close socket.
     */
    void close();

    String getData();

    byte[] getDataByte();

    /**
     * Get DataEvent.
     * @return DataEvent.
     */
    DataEvent getListener();

    /**
     * Get.
     * @return String.
     */
    int getPortNum();

    /**
     * Get.
     * @return String.
     */
    String getRemoteHost();

    /**
     * Get.
     * @return String.
     */
    int getRemotePort();

    /**
     * Get.
     * @return String.
     */
    int getRemotePortNum();

    /**
     * Send data to target.
     *
     * @param Data as String.
     */
    void sendData(String Data);

    /**
     * Send data to target.
     *
     * @param Data as byte array.
     */
    void sendData(byte[] Data);

    /**
     * Set DataEvent.
     * @param listener DataEvent.
     */
    void setListener(DataEvent listener);

    /**
     * Set.
     * @param portNum Number.
     */
    void setPortNum(int portNum);

    /**
     * Set.
     * @param remoteHost Number.
     */
    void setRemoteHost(String remoteHost);

    /**
     * Set.
     * @param remotePortNum Number.
     */
    void setRemotePort(int remotePortNum);

    /**
     * Set.
     * @param remotePortNum Number.
     */
    void setRemotePortNum(int remotePortNum);
    
}
