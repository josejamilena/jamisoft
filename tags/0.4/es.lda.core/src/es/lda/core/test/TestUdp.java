package es.lda.core.test;

import es.lda.core.event.interfaces.DataEvent;
import es.lda.core.network.Udp;

/**
 *
 * @author Jose Antonio
 */
public class TestUdp {

//    static class DE implements DataEvent {
//
//        @Override
//        public void dataArrival(int size) {
//            System.err.println(" -> Longitud Recibida: " + size);
//        }
//        
//    }   
//    
//    /**
//     * @param args the command line arguments
//     */
    public static void main(String[] args) {      
//        DE deo = new DE();
//        Udp tmp = new Udp();
//        tmp.setRemoteHost("localhost");
//        tmp.setRemotePortNum(888);       
//        tmp.setListener(deo);
//        tmp.bind();
        Object o = new Boolean("True");
        System.err.println(o.toString());
        Boolean n = new Boolean(o.toString());
        System.err.println(n.toString());        
    }
}
