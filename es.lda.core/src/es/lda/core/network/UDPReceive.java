package es.lda.core.network;

/**
 *
 * @author Jose Antonio
 */
import es.lda.core.lib.util.TimeStamp;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceive {

    public UDPReceive(int p, int bufferSize) {
        try {
            int port = p;

            // Create a socket to listen on the port.
            DatagramSocket dsocket = new DatagramSocket(port);

            // Create a buffer to read datagrams into. If a
            // packet is larger than this buffer, the
            // excess will simply be discarded!
            byte[] buffer = new byte[bufferSize];

            // Create a packet to receive data into the buffer
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // Now loop forever, waiting to receive packets and printing them.
            while (true) {
                // Wait to receive a datagram
                dsocket.receive(packet);

                // Convert the contents to a string, and display them
                String msg = new String(buffer, 0, packet.getLength());
                System.out.println(TimeStamp.now() + " -> " + packet.getAddress().getHostName() + ": " + msg);

                // Reset the length of the packet before reusing it.
                packet.setLength(buffer.length);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) throws Exception {
        new UDPReceive(2000, 20000);
    }
}
