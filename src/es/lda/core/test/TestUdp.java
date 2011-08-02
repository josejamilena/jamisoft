package es.lda.core.test;

import es.lda.core.event.interfaces.DataEvent;
import es.lda.core.network.IUdp;
import es.lda.core.network.UdpException;
import es.lda.core.network.UdpFactory;
import es.lda.core.network.UdpType;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Jose Antonio
 */
public class TestUdp {

    static class DE implements DataEvent {

        public void dataArrival(int size) {
            System.err.print(++contador + " -> Longitud Recibida: " + size + " -> ");
            System.err.println(tmp.getData());
        }

        @Override
        public void dataArrival(short size) {
            System.err.print(++contador + " -> Longitud Recibida: " + size + " -> ");
            System.err.println(tmp.getData());
        }
    }
    private static Logger logger = Logger.getLogger(TestUdp.class);
    public static IUdp tmp = null;
    public static int contador = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UdpException {
        PropertyConfigurator.configure("log4j.properties");
        DE deo = new DE();
        tmp = UdpFactory.getInstance(UdpType.UDP_SINGLETON);
        tmp.setRemoteHost("192.168.0.103");
        tmp.setRemotePortNum(2000);
        tmp.setListener(deo);
//        tmp.bind();
//        while (true) {
        tmp.sendData(((char) 2) + "e@" + ((char) 3));
        tmp.bind();
        tmp.sendData(((char) 2) + "d@" + ((char) 3));
        tmp.bind();
        tmp.sendData(((char) 2) + "g@" + ((char) 3));
        tmp.bind();
        tmp.sendData(((char) 2) + "G1@" + ((char) 3));
        tmp.bind();
        while(true) {}
//        }
//        Object o = new Boolean("True");
//        System.err.println(o.toString());
//        Boolean n = new Boolean(o.toString());
//        System.out.println();
//        tmp.close();
    }
}
