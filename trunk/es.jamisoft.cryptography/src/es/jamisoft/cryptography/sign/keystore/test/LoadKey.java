package es.jamisoft.cryptography.sign.keystore.test;

import es.jamisoft.cryptography.sign.keystore.AlmacenClaves;
import java.io.FileInputStream;
import java.security.cert.Certificate;

public class LoadKey {

    public static void main(String args[]) {
        try {
            FileInputStream fIn      = new FileInputStream("keystore.jks");
            Certificate cert = AlmacenClaves.loadKey(fIn, "es.jamisoft".toCharArray(), "test");
            System.out.println(cert);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
