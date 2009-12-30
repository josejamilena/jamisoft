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



package examples;

//~--- non-JDK imports --------------------------------------------------------

import org.bouncycastle.jce.provider.BouncyCastleProvider;

//~--- JDK imports ------------------------------------------------------------

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;

//~--- classes ----------------------------------------------------------------

class GenSig {
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());

        /* Generate a RSA signature */
        if (args.length != 1) {
            System.out.println("Usage: GenSig nameOfFileToSign");
        } else {
            try {

                /* Generate a key pair */
                KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA", "BC");
                SecureRandom     random = SecureRandom.getInstance("SHA1PRNG", "SUN");

                keyGen.initialize(1024, random);

                KeyPair    pair = keyGen.generateKeyPair();
                PrivateKey priv = pair.getPrivate();
                PublicKey  pub  = pair.getPublic();

                /* Create a Signature object and initialize it with the private key */
                Signature rsa = Signature.getInstance("MD5WithRSAEncryption", "BC");

                rsa.initSign(priv);

                /* Update and sign the data */
                FileInputStream     fis    = new FileInputStream(args[0]);
                BufferedInputStream bufin  = new BufferedInputStream(fis);
                byte[]              buffer = new byte[1024];
                int                 len;

                while (bufin.available() != 0) {
                    len = bufin.read(buffer);
                    rsa.update(buffer, 0, len);
                }
                ;

                bufin.close();

                /*
                 *  Now that all the data to be signed has been read in,
                 *       generate a signature for it
                 */
                byte[] realSig = rsa.sign();

                /* Save the signature in a file */
                FileOutputStream sigfos = new FileOutputStream("sig");

                sigfos.write(realSig);
                sigfos.close();

                /* Save the public key in a file */
                byte[]           keyPublic    = pub.getEncoded();
                FileOutputStream keyPublicfos = new FileOutputStream("publickey");

                keyPublicfos.write(keyPublic);
                keyPublicfos.close();

                /* Save the public key in a file */
                byte[]           keyPrivate    = priv.getEncoded();
                FileOutputStream keyPrivatefos = new FileOutputStream("privatekey");

                keyPrivatefos.write(keyPrivate);
                keyPrivatefos.close();
            } catch (Exception e) {
                System.err.println("Caught exception " + e.toString());
            }
        }
    }

    ;
}
