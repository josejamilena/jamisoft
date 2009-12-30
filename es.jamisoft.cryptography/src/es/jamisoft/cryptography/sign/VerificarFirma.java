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
import es.jamisoft.cryptography.sign.exception.FirmaException;

//~--- JDK imports ------------------------------------------------------------

import java.io.BufferedInputStream;
import java.io.InputStream;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

//~--- classes ----------------------------------------------------------------
/**
 *
 * @author Jose Antonio Jamilena Daza
 */
public class VerificarFirma {

    /**
     * Realiza la verificación de la firma.
     * @param keyfis clave pública.
     * @param sigfis firma a verificar.
     * @param datafis datos firmados.
     * @return devuelve si se ha verificado o no.
     */
    public static boolean run(InputStream keyfis, InputStream sigfis, InputStream datafis) {
        Security.addProvider(ConfigFirma.securityProvider);
        boolean verifies = false;
        try {
            byte[] encKey = new byte[keyfis.available()];
            keyfis.read(encKey);

            X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(encKey);
            KeyFactory keyFactory = KeyFactory.getInstance(ConfigFirma.cryptosystem, ConfigFirma.securityProviderName);
            PublicKey pubKey = keyFactory.generatePublic(pubKeySpec);
            byte[] sigToVerify = new byte[sigfis.available()];
            sigfis.read(sigToVerify);

            Signature sig = Signature.getInstance(ConfigFirma.signatureAlgorithm, ConfigFirma.securityProviderName);
            sig.initVerify(pubKey);

            BufferedInputStream bufin = new BufferedInputStream(datafis);
            byte[] buffer = new byte[1024];
            int len;

            while (bufin.available() != 0) {
                len = bufin.read(buffer);
                sig.update(buffer, 0, len);
            }

            verifies = sig.verify(sigToVerify);
            
        } catch (Exception e) {
            new FirmaException(e.getMessage());
        } finally {
            return verifies;
        }
    }
}
