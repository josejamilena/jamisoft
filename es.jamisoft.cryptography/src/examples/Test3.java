package examples;


import java.math.*;
import java.security.*;
import java.security.spec.*;

import javax.crypto.*;
import javax.crypto.spec.*;
import javax.crypto.interfaces.*;

import sun.misc.*; //Base64

import java.io.*;

public class Test3  {
   boolean doneAGI = false;
   byte[] ciphertext;
   static byte alice[]; //Test
   static String aliceb;
   static String alicec;


   public static void main(String args[]) {
     int taillekpg=512; //512 suffit pour test

       try {
           // Step 1:  AGI generates a key pair
           System.out.println("Etape 1");
           KeyPairGenerator kpg = KeyPairGenerator.getInstance("DH");
           kpg.initialize(taillekpg);
           KeyPair kp = kpg.generateKeyPair();


//        the encoded key, or null if the key does not support encoding.
           alice = kp.getPublic().getEncoded();
           aliceb = new String(kp.getPublic().getEncoded(),"UTF8");


          System.out.println("alice "+alice); //
          System.out.println("aliceB "+aliceb);
          BASE64Encoder encoder = new BASE64Encoder();
          String alicec = encoder.encode(alice);
          System.out.println("aliceC "+alicec);

          String roundTrip = new String(alice);
          String roundTrip2 = new String(alice, "UTF8");

          byte[] Bytes1 = roundTrip.getBytes();
          byte[] utf8Bytes2 = roundTrip2.getBytes("UTF8");

          byte[] Bytes1b = aliceb.getBytes();
          byte[] utf8Bytes2b2 = aliceb.getBytes("UTF8");

          BASE64Decoder decoder = new BASE64Decoder();
          byte[]  utf8Bytes6 = decoder.decodeBuffer(alicec);

         System.out.println("alice1 "+Bytes1); //Mauvais
         System.out.println("alice2 "+utf8Bytes2); //Mauvais

         System.out.println("alice1B "+Bytes1b); //Mauvais
         System.out.println("alice2B "+utf8Bytes2b2); //Mauvais
         System.out.println("alicex6G "+utf8Bytes6); //Mauvais
        } catch (Exception e) {
           e.printStackTrace();
       }
   }
}
