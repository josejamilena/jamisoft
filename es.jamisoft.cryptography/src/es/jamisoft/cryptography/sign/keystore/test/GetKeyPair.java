/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.jamisoft.cryptography.sign.keystore.test;

import es.jamisoft.cryptography.exception.CryptoException;
import es.jamisoft.cryptography.sign.keystore.AlmacenClaves;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyPair;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose
 */
public class GetKeyPair {

    public static void main(String[] args) {
        FileInputStream is = null;
        try {
            is = new FileInputStream("keystore.jks");
            KeyPair par = AlmacenClaves.getPrivateKey(is, "test", "es.jamisoft", "testtest");
            System.out.println("Clave publica: " + par.getPublic().toString());
            System.out.println("Clave privada: " + par.getPrivate().toString());
        } catch (CryptoException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
