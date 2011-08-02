package es.lda.core.network;

import es.lda.core.network.impl.UdpMT;
import es.lda.core.network.impl.UdpSingleton;

/**
 *
 * @author Jose Antonio
 */
public abstract class UdpFactory {

    private UdpFactory() {
    }

    public static IUdp getInstance(UdpType type) throws UdpException {
        if (type.equals(UdpType.UDP_SINGLETON)) {
            return new UdpSingleton();
        } else if (type.equals(UdpType.UDP_MULTITHREAT)) {
            return new UdpMT();
        } else {
            throw new UdpException("UdpType NOT FOUND.");
        }
    }
    
    public static IUdp getInstance(UdpType type, int bufferSize) throws UdpException {
        if (type.equals(UdpType.UDP_SINGLETON)) {
            return new UdpSingleton(bufferSize);
        } else if (type.equals(UdpType.UDP_MULTITHREAT)) {
            return new UdpMT(bufferSize);
        } else {
            throw new UdpException("UdpType NOT FOUND.");
        }
    }    
}
