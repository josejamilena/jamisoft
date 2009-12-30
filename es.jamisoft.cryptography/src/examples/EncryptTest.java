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

//~--- JDK imports ------------------------------------------------------------

import java.io.*;

import java.security.*;
import java.security.spec.*;

import java.util.*;

import javax.crypto.*;
import javax.crypto.spec.*;

//~--- classes ----------------------------------------------------------------

public class EncryptTest {
    public static void main(String args[]) {
        File desFile = new File("out.des");

        // Create data to encrypt
        Map map    = new TreeMap(System.getProperties());
        int number = map.size();

        try {

            // Create Key
            KeyGenerator kg        = KeyGenerator.getInstance("DES");
            SecretKey    secretKey = kg.generateKey();

            // Create Cipher
            Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            desCipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Create stream
            FileOutputStream     fos = new FileOutputStream(desFile);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            CipherOutputStream   cos = new CipherOutputStream(bos, desCipher);
            ObjectOutputStream   oos = new ObjectOutputStream(cos);

            // Write objects
            oos.writeObject(map);
            oos.writeInt(number);
            oos.flush();
            oos.close();

            // Change cipher mode
            desCipher.init(Cipher.DECRYPT_MODE, secretKey);

            // Create stream
            FileInputStream     fis = new FileInputStream(desFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            CipherInputStream   cis = new CipherInputStream(bis, desCipher);
            ObjectInputStream   ois = new ObjectInputStream(cis);

            // Read objects
            Map map2    = (Map) ois.readObject();
            int number2 = ois.readInt();

            ois.close();

            // Compare original with what was read back
            if (map.equals(map2) && (map.size() == number2)) {
                System.out.println("Everything read back out okay.");
            } else {
                System.out.println("Problems during encryption/decryption process.");
            }
        } catch (NoSuchPaddingException e) {
            System.err.println("Padding problem: " + e);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Invalid algorithm: " + e);
        } catch (InvalidKeyException e) {
            System.err.println("Invalid key: " + e);
        } catch (IOException e) {
            System.err.println("I/O Problem: " + e);
        } catch (ClassNotFoundException e) {
            System.err.println("Class loading Problem: " + e);
        } finally {
            if (desFile.exists()) {
                desFile.delete();
            }
        }
    }
}
