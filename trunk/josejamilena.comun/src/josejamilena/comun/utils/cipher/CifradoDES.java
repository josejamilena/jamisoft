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

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

//~--- classes ----------------------------------------------------------------

public class CifradoDES extends Codificador {
    protected Cipher    desCipher;
    protected SecretKey desKey;

    //~--- constructors -------------------------------------------------------

    public CifradoDES() {
        desKey    = generaDesKey();
        desCipher = generaDesCipher();
    }

    //~--- methods ------------------------------------------------------------

    public byte[] cifra(byte bytes[]) {
        byte cleartext[] = new byte[bytes.length];

        try {
            desCipher.init(1, desKey);
            cleartext = desCipher.doFinal(bytes);
        } catch (Exception e) {
            System.out.println("Error cifrando un texto:" + e);
            e.printStackTrace();
        }

        return cleartext;
    }

    public byte[] descifra(byte bytes[]) {
        byte ciphertext[] = new byte[bytes.length];

        try {
            desCipher.init(2, desKey);
            ciphertext = desCipher.doFinal(bytes);
        } catch (Exception e) {
            System.out.println("Error descifrando un texto:" + e);
            e.printStackTrace();
        }

        return ciphertext;
    }

    private SecretKey generaDesKey() {
        try {
            KeyGenerator keygen = KeyGenerator.getInstance("DES");

            return keygen.generateKey();
        } catch (Exception e) {
            System.out.println("Error descifrando un texto:" + e);
            e.printStackTrace();

            return null;
        }
    }

    private Cipher generaDesCipher() {
        try {
            return Cipher.getInstance("DES");
        } catch (Exception e) {
            System.out.println("Error descifrando un texto:" + e);
            e.printStackTrace();

            return null;
        }
    }

    //~--- get methods --------------------------------------------------------

    public SecretKey getKey() {
        return desKey;
    }

    //~--- set methods --------------------------------------------------------

    public void setKey(SecretKey secretKey) {
        desKey = secretKey;
    }

    //~--- get methods --------------------------------------------------------

    public Cipher getCipher() {
        return desCipher;
    }

    //~--- set methods --------------------------------------------------------

    public void setCipher(Cipher cipher) {
        desCipher = cipher;
    }

    //~--- methods ------------------------------------------------------------

    public static void main(String args[]) throws EncoderException {
        CifradoDES crypt     = new CifradoDES();
        String     encrypted = crypt.cifra("Adios");

        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + crypt.descifra(encrypted));
    }
}
