package es.jamisoft.cryptography.sign.keystore.test;

import es.jamisoft.cryptography.sign.keystore.AlmacenClaves;
import java.io.FileInputStream;

public class ExportCertificate {

    public static void main(String[] argv) throws Exception {
        FileInputStream is = new FileInputStream("keystore.jks");
        AlmacenClaves.exportCertificate(is, "es.jamisoft", "test", "test.cer");
    }
}
