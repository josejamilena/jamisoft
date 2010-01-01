/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.jamisoft.cryptography.sign.keystore.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;

/**
 *
 * @author Jose
 */
public class GetAlias {

    public static void main(String[] args) {
        try {
            // Load the keystore in the user's home directory
            File file = new File("keystore.jks");
            FileInputStream is = new FileInputStream(file);
            KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
            String password = "es.jamisoft";
            keystore.load(is, password.toCharArray());

            // List the aliases
            Enumeration enu = keystore.aliases();
            for (; enu.hasMoreElements();) {
                String alias = (String) enu.nextElement();

                // Does alias refer to a private key?
                boolean b = keystore.isKeyEntry(alias);

                // Does alias refer to a trusted certificate?
                b = keystore.isCertificateEntry(alias);
            }
            is.close();
        } catch (java.security.cert.CertificateException e) {
        } catch (NoSuchAlgorithmException e) {
        } catch (FileNotFoundException e) {
            // Keystore does not exist
        } catch (KeyStoreException e) {
        } catch (IOException e) {
        }
    }
}
