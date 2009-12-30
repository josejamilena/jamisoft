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
import java.security.PrivateKey;
import java.security.Security;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author Jose Antonio Jamilena Daza
 */
public class RealizarFirma {

    /**
     * Firma un fichero.
     * @param keyfis Clave Privada.
     * @param datafis Datos a firmar.
     * @return resultado de la firma.
     */
    public static byte[] run(InputStream keyfis, InputStream datafis) {
        Security.addProvider(ConfigFirma.securityProvider);
        byte[]  realSig  = null;

        try {
            Signature rsa    = Signature.getInstance(ConfigFirma.signatureAlgorithm, ConfigFirma.securityProviderName);
            byte[]    encKey = new byte[keyfis.available()];

            keyfis.read(encKey);

            X509EncodedKeySpec privKeySpec = new X509EncodedKeySpec(encKey);
            KeyFactory         keyFactory  = KeyFactory.getInstance(ConfigFirma.cryptosystem,
                                                 ConfigFirma.securityProviderName);
            PrivateKey         privKey     = keyFactory.generatePrivate(privKeySpec);

            rsa.initSign(privKey);

            BufferedInputStream bufin  = new BufferedInputStream(datafis);
            byte[]              buffer = new byte[1024];
            int                 len;

            while (bufin.available() != 0) {
                len = bufin.read(buffer);
                rsa.update(buffer, 0, len);
            }

            realSig = rsa.sign();
        } catch (Exception e) {
            new FirmaException(e.getMessage());
        } finally {
            return realSig;
        }
    }
}
