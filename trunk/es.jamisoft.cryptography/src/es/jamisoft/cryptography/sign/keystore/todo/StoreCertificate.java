package es.jamisoft.cryptography.sign.keystore.todo;

import es.jamisoft.cryptography.exception.CryptoException;
import es.jamisoft.cryptography.sign.keystore.AlmacenClaves;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertPath;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StoreCertificate {

    public static void storeCertificate(String keystoreFile, String password, String alias, String passwordAlias, InputStream is) throws CryptoException {
        ObjectInputStream b = null;
        FileInputStream keystoreIs = null;
        FileOutputStream output = null;
        try {
            b = new ObjectInputStream(is);
            CertPath cp = (CertPath) b.readObject();
            KeyStore keyStore = KeyStore.getInstance(AlmacenClaves.KEYSTORE_TYPE);
            keystoreIs = new FileInputStream(keystoreFile);
            keyStore.load(keystoreIs, password.toCharArray());
            List cplist = cp.getCertificates();
            Object[] o = cplist.toArray();
            for (int i = 0; i < o.length; i++) {
                X509Certificate c = (X509Certificate) o[i];
                keyStore.setCertificateEntry(alias + i, c);
            }
            output = new FileOutputStream(keystoreFile);
            keyStore.store(output, passwordAlias.toCharArray());
        } catch (NoSuchAlgorithmException ex) {
            new CryptoException(ex.toString());
        } catch (CertificateException ex) {
            new CryptoException(ex.toString());
        } catch (KeyStoreException ex) {
            new CryptoException(ex.toString());
        } catch (ClassNotFoundException ex) {
            new CryptoException(ex.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
            new CryptoException(ex.toString());
        } finally {
            try {
                b.close();
                keystoreIs.close();
                output.close();
            } catch (IOException ex) {
                new CryptoException(ex.toString());
            }
        }
    }

    public static void main(String args[]) {
        FileInputStream f = null;
        try {
            f = new FileInputStream("test.cer");
            StoreCertificate.storeCertificate("keystore.jks", "es.jamisoft", "alias", "", f);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
