/*
 *   Copyright 2010 Jose Antonio Jamilena Daza
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */



package es.jamisoft.cryptography.sign;

//~--- non-JDK imports --------------------------------------------------------

import es.jamisoft.cryptography.exception.CryptoException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

//~--- JDK imports ------------------------------------------------------------

import java.io.FileInputStream;
import java.io.InputStream;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;

//~--- classes ----------------------------------------------------------------

public class Firma {
    public static final String ALGORITMO = "MD5withRSA";
    private static byte[] firmar(InputStream datafile, PrivateKey prvKey, String sigAlg) throws CryptoException {
        byte[] res = null;
        try {
            Signature sig = Signature.getInstance(sigAlg);
            sig.initSign(prvKey);
            BufferedInputStream fis = new BufferedInputStream(datafile);
            byte[] dataBytes = new byte[1024];
            int nread = fis.read(dataBytes);
            while (nread > 0) {
                sig.update(dataBytes, 0, nread);
                nread = fis.read(dataBytes);
            }
            res = sig.sign();
        } catch (SignatureException ex) {
            new CryptoException(ex.toString());
        } catch (IOException ex) {
            new CryptoException(ex.toString());
        } catch (InvalidKeyException ex) {
            new CryptoException(ex.toString());
        } catch (NoSuchAlgorithmException ex) {
            new CryptoException(ex.toString());
        } finally {
            return res;
        }
    }

    private static boolean verificar(InputStream datafile, PublicKey pubKey, String sigAlg, byte[] sigbytes) throws CryptoException {
        boolean res = false;
        try {
            Signature sig = Signature.getInstance(sigAlg);
            sig.initVerify(pubKey);
            BufferedInputStream fis = new BufferedInputStream(datafile);
            byte[] dataBytes = new byte[1024];
            int nread = fis.read(dataBytes);
            while (nread > 0) {
                sig.update(dataBytes, 0, nread);
                nread = fis.read(dataBytes);
            }
            res = sig.verify(sigbytes);
        } catch (SignatureException ex) {
            new CryptoException(ex.toString());
        } catch (IOException ex) {
            new CryptoException(ex.toString());
        } catch (InvalidKeyException ex) {
            new CryptoException(ex.toString());
        } catch (NoSuchAlgorithmException ex) {
            new CryptoException(ex.toString());
        } finally {
            return res;
        }
    }

    public static void main(String[] unused) throws Exception {
        Security.addProvider(new BouncyCastleProvider());    // Cargar el provider BC

        // Generate a key-pair
//    KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA");
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA", "BC");

        kpg.initialize(512);    // 512 is the keysize.

        KeyPair    kp   = kpg.generateKeyPair();
        PublicKey  pubk = kp.getPublic();
        PrivateKey prvk = kp.getPrivate();

        System.out.println(pubk.getEncoded());
        System.out.println(prvk.getEncoded());

        String datafile = "build.xml";
        FileInputStream fis = new FileInputStream(datafile);
        byte[] sigbytes = firmar(fis, prvk, Firma.ALGORITMO);
        System.out.println("Signature:: " + sigbytes);
        boolean result = verificar(fis, pubk, Firma.ALGORITMO, sigbytes);
        System.out.println("Signature Verification Result = " + result);
        fis.close();
    }
}
