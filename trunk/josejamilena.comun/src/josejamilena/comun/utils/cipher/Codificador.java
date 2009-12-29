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



package josejamilena.comun.utils.cipher;

//~--- non-JDK imports --------------------------------------------------------

import josejamilena.comun.codec.B64;

import org.apache.commons.codec.EncoderException;
import org.apache.log4j.Logger;

//~--- JDK imports ------------------------------------------------------------

import java.io.UnsupportedEncodingException;

//~--- classes ----------------------------------------------------------------

public abstract class Codificador {
    public Codificador() {}

    //~--- methods ------------------------------------------------------------

    public String cifra(String string) throws EncoderException {
        Logger logger = Logger.getLogger(Codificador.class);

        logger.debug("cifra esto:" + string);

        try {
            byte plain[] = cifra(string.getBytes("UTF-8"));
            B64  b64     = new B64();

            return b64.encodeBase64String(plain);
        } catch (UnsupportedEncodingException e) {
            return new String(cifra(string.getBytes()));
        }
    }

    public String descifra(String cadena) {
        Logger logger = Logger.getLogger(Codificador.class);

        logger.debug("descifra esto:" + cadena);

        try {
            B64 b64 = new B64();

            b64.decodeBase64(cadena);

            byte cipherCode[] = b64.decodeBase64(cadena);
            byte plainCode[]  = descifra(cipherCode);

            return new String(plainCode, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return new String(descifra(cadena.getBytes()));
        }
    }

    public abstract byte[] cifra(byte abyte0[]);

    public abstract byte[] descifra(byte abyte0[]);
}
