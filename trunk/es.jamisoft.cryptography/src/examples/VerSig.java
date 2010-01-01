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

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

//~--- classes ----------------------------------------------------------------

class VerSig {
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());

        /* Verify a RSA signature */
        if (args.length != 3) {
            System.out.println("Usage: VerSig publickeyfile signaturefile datafile");
        } else {
            try {

                /* import encoded public key */
                FileInputStream keyfis = new FileInputStream(args[0]);
                byte[]          encKey = new byte[keyfis.available()];

                keyfis.read(encKey);
                keyfis.close();

                X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(encKey);
                KeyFactory         keyFactory = KeyFactory.getInstance("RSA", "BC");
                PublicKey          pubKey     = keyFactory.generatePublic(pubKeySpec);

                /* input the signature bytes */
                FileInputStream sigfis      = new FileInputStream(args[1]);
                byte[]          sigToVerify = new byte[sigfis.available()];

                sigfis.read(sigToVerify);
                sigfis.close();

                /* create a Signature object and initialize it with the public key */
                Signature sig = Signature.getInstance("MD5WithRSAEncryption", "BC");

                sig.initVerify(pubKey);

                /* Update and verify the data */
                FileInputStream     datafis = new FileInputStream(args[2]);
                BufferedInputStream bufin   = new BufferedInputStream(datafis);
                byte[]              buffer  = new byte[1024];
                int                 len;

                while (bufin.available() != 0) {
                    len = bufin.read(buffer);
                    sig.update(buffer, 0, len);
                }
                ;

                bufin.close();

                boolean verifies = sig.verify(sigToVerify);

                System.out.println("signature verifies: " + verifies);
            } catch (Exception e) {
                System.err.println("Caught exception " + e.toString());
            }
        }
        ;
    }
}
