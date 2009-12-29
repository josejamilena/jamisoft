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

//~--- JDK imports ------------------------------------------------------------

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

//~--- classes ----------------------------------------------------------------

// Referenced classes of package es.novasoft.nfc.comun.servicios.cifrado:
//            Codificador
public class CifradoPBE extends Codificador {
    protected static int  defaultCount    = 20;
    protected static byte defaultSalt[]   = {
        -57, 115, 33, -116, 126, -56, -18, -103
    };
    protected static char defaultSecret[] = {
        'n', '(', 'u', '2', 'M', '#', 'y', '-', '0', 'g', 't', 'P', '4', '%', 'S', 's', 'W', '0', '*', 'r', 'D', '1',
        '2', '6', '0', '0', 'n', 'r', '!', 'e', '^', 'b', '#', 'x', 'r', 'l', 'S', '&', 'h', 'r', 'k', 't', 'P', '4',
        '%', 'S', 's', 'Q', 'M', '#', 'y', '-', 'S', '&', 'C', 'r', 'E', '@', 'n', 'j', '!', 'e', '^', 'b'
    };

    //~--- fields -------------------------------------------------------------

    PBEParameterSpec paramSpec;
    Cipher           pbeCipher;
    SecretKey        secretKey;

    //~--- constructors -------------------------------------------------------

    public CifradoPBE() {
        this(defaultSecret, defaultSalt, defaultCount);
    }

    public CifradoPBE(char secret[]) {
        this(secret, defaultSalt, defaultCount);
    }

    public CifradoPBE(char secret[], byte salt[], int count) {
        secretKey = generatePBKey(secret);

        try {
            pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
            paramSpec = new PBEParameterSpec(salt, count);
        } catch (Exception e) {
            System.out.println("Error en la inicializacion de la clase de cifrado:" + e);
            e.printStackTrace();
        }
    }

    //~--- methods ------------------------------------------------------------

    public byte[] cifra(byte bytes[]) {
        try {
            pbeCipher.init(1, secretKey, paramSpec);

            return pbeCipher.doFinal(bytes);
        } catch (Exception e) {
            System.out.println("Error cifrando:" + e);
            e.printStackTrace();

            return null;
        }
    }

    public byte[] descifra(byte bytes[]) {
        try {
            pbeCipher.init(2, secretKey, paramSpec);

            return pbeCipher.doFinal(bytes);
        } catch (Exception e) {
            System.out.println("Error descifrando:" + e);
            e.printStackTrace();

            return null;
        }
    }

    public SecretKey generatePBKey(char secret[]) {
        try {
            PBEKeySpec       keySpec = new PBEKeySpec(secret);
            SecretKeyFactory keyFac  = SecretKeyFactory.getInstance("PBEWithMD5AndDES");

            return keyFac.generateSecret(keySpec);
        } catch (Exception e) {
            System.out.println("Error generando la clave:" + e);
            e.printStackTrace();

            return null;
        }
    }

    //~--- get methods --------------------------------------------------------

    public byte[] getBufferFromInput(InputStream afin, int aiTamInput) throws IOException {
        byte labResultado[] = new byte[aiTamInput];
        byte labInfo[]      = new byte[2048];
        int  liLeido        = -1;

        for (int liTotalLeidos = 0; (liLeido = afin.read(labInfo, 0, 2048)) != -1; liTotalLeidos += liLeido) {
            System.arraycopy(labInfo, 0, labResultado, liTotalLeidos, liLeido);
        }

        labInfo = null;

        return labResultado;
    }

    //~--- methods ------------------------------------------------------------

    public void cifrar(String asPathFichero) {
        try {
            File            lfFichero = new File(asPathFichero);
            byte            buffer[]  = null;
            FileInputStream lfin      = new FileInputStream(lfFichero);

            buffer = getBufferFromInput(lfin, (int) lfFichero.length());
            lfin.close();
            System.gc();

            if (buffer != null) {
                byte labCifrado[] = cifra(buffer);

                lfFichero = new File(asPathFichero);

                FileOutputStream lfw = new FileOutputStream(lfFichero);

                lfw.write(labCifrado, 0, labCifrado.length);
                lfw.close();
            }

            System.gc();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private byte[] copiarABuffer(byte abuf[], int liTam) {
        byte bufAux[] = new byte[liTam];

        for (int i = 0; i < liTam; i++) {
            bufAux[i] = abuf[i];
        }

        return bufAux;
    }

    public void descifrar(String asPathFichero) throws Exception {
        try {
            File            lfFichero = new File(asPathFichero);
            byte            buffer[]  = null;
            FileInputStream lfin      = new FileInputStream(asPathFichero);

            buffer = getBufferFromInput(lfin, (int) lfFichero.length());
            lfin.close();

            byte bufferDescifrado[] = descifra(buffer);

            if (bufferDescifrado != null) {
                lfFichero = new File(asPathFichero);

                FileOutputStream lfo = new FileOutputStream(lfFichero);

                lfo.write(bufferDescifrado, 0, bufferDescifrado.length);
                lfo.close();
            } else {
                throw new Exception("Clave incorrecta");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void main(String args[]) {
        CifradoPBE crypt = new CifradoPBE("llfe02".toCharArray());

        try {
            System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
            System.out.println("antes de descifrar");
            crypt.descifrar("f://bdDes.zip");
            System.out.println("despues de descifrar");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
