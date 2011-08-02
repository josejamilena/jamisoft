package es.lda.core.test;

import es.lda.core.event.interfaces.DataEvent;
import es.lda.core.network.impl.UdpMT;

/**
 *
 * @author Jose Antonio
 */
public class TestUdp {

    static class DE implements DataEvent {

        public void dataArrival(int size) {
            System.err.println(" -> Longitud Recibida: " + size);
        }

        @Override
        public void dataArrival(short size) {
            this.dataArrival(size);
        }
        
    }   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {      
        DE deo = new DE();
        UdpMT tmp = new UdpMT();
        tmp.setRemoteHost("localhost");
        tmp.setRemotePortNum(2000);       
        tmp.setListener(deo);
        tmp.bind();
        while (true)
            tmp.sendData("Hola");
//        Object o = new Boolean("True");
//        System.err.println(o.toString());
//        Boolean n = new Boolean(o.toString());
//        System.err.println(n.toString());        
    }
}
