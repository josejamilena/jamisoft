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

import org.apache.commons.codec.EncoderException;

//~--- JDK imports ------------------------------------------------------------

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

//~--- classes ----------------------------------------------------------------

// Referenced classes of package es.novasoft.nfc.comun.servicios.cifrado:
//            CifradoPBE
public class CifradoPBE3DES extends CifradoPBE {
    PBEParameterSpec paramSpec;
    Cipher           pbeCipher;
    SecretKey        secretKey;

    //~--- constructors -------------------------------------------------------

    public CifradoPBE3DES() {
        this(defaultSecret, defaultSalt, defaultCount);
    }

    public CifradoPBE3DES(char secret[]) {
        this(secret, defaultSalt, defaultCount);
    }

    public CifradoPBE3DES(char secret[], byte salt[], int count) {
        secretKey = generatePBKey(secret);

        try {
            pbeCipher = Cipher.getInstance("PBEWithMD5AndTripleDES");
            paramSpec = new PBEParameterSpec(salt, count);
        } catch (Exception e) {
            System.out.println("Error en la inicializacion de la clase de cifrado:" + e);
            e.printStackTrace();
        }
    }

    //~--- methods ------------------------------------------------------------

    public SecretKey generatePBKey(char secret[]) {
        try {
            PBEKeySpec       keySpec = new PBEKeySpec(secret);
            SecretKeyFactory keyFac  = SecretKeyFactory.getInstance("PBEWithMD5AndTripleDES");

            return keyFac.generateSecret(keySpec);
        } catch (Exception e) {
            System.out.println("Error generando la clave:" + e);
            e.printStackTrace();

            return null;
        }
    }

    public static void main(String args[]) {
        try {
            CifradoPBE crypt     = new CifradoPBE("dgsadfasdfasdfasdfasdfasdf".toCharArray());
            String     encrypted = crypt.cifra("hola");

            System.out.println("Encrypted: " + encrypted);
            System.out.println("Decrypted: " + crypt.descifra(encrypted));
        } catch (EncoderException ex) {
            ex.printStackTrace();
        }
    }
}
