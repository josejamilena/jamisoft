package es.jamisoft.cryptography.sign.keystore.test;


import es.jamisoft.cryptography.sign.keystore.AlmacenClaves;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import sun.security.x509.AlgorithmId;
import sun.security.x509.CertificateAlgorithmId;
import sun.security.x509.CertificateIssuerName;
import sun.security.x509.CertificateSerialNumber;
import sun.security.x509.CertificateSubjectName;
import sun.security.x509.CertificateValidity;
import sun.security.x509.X500Name;
import sun.security.x509.X509CertImpl;
import sun.security.x509.X509CertInfo;

public class CreateKey {
//  public static void createKey(String keystoreFile, String caAlias,
//          String certToSignAlias, String newAlias,
//          char[] password, char[] caPassword, char[] certPassword
//          ) throws Exception {
////    String keystoreFile = "keyStoreFile.bin";
////    String caAlias = "caAlias";
////    String certToSignAlias = "cert";
////    String newAlias = "newAlias";
////    char[] password = new char[]{'a','b','c','d','e','f','g','h'};
////    char[] caPassword = new char[]{'a','b','c','d','e','f','g','h'};
////    char[] certPassword = new char[]{'a','b','c','d','e','f','g','h'};
//
//    FileInputStream input = new FileInputStream(keystoreFile);
//    KeyStore keyStore = KeyStore.getInstance("JKS");
//    keyStore.load(input, password);
//    input.close();
//
//    PrivateKey caPrivateKey = (PrivateKey) keyStore.getKey(caAlias, caPassword);
//    java.security.cert.Certificate caCert = keyStore.getCertificate(caAlias);
//
//    byte[] encoded = caCert.getEncoded();
//    X509CertImpl caCertImpl = new X509CertImpl(encoded);
//
//    X509CertInfo caCertInfo = (X509CertInfo) caCertImpl.get(X509CertImpl.NAME + "."
//        + X509CertImpl.INFO);
//
//    X500Name issuer = (X500Name) caCertInfo.get(X509CertInfo.SUBJECT + "."
//        + CertificateIssuerName.DN_NAME);
//
//    java.security.cert.Certificate cert = keyStore.getCertificate(certToSignAlias);
//    PrivateKey privateKey = (PrivateKey) keyStore.getKey(certToSignAlias, certPassword);
//    encoded = cert.getEncoded();
//    X509CertImpl certImpl = new X509CertImpl(encoded);
//    X509CertInfo certInfo = (X509CertInfo) certImpl
//        .get(X509CertImpl.NAME + "." + X509CertImpl.INFO);
//
//    Date firstDate = new Date();
//    Date lastDate = new Date(firstDate.getTime() + 365 * 24 * 60 * 60 * 1000L);
//    CertificateValidity interval = new CertificateValidity(firstDate, lastDate);
//
//    certInfo.set(X509CertInfo.VALIDITY, interval);
//
//    certInfo.set(X509CertInfo.SERIAL_NUMBER, new CertificateSerialNumber(
//        (int) (firstDate.getTime() / 1000)));
//
//    certInfo.set(X509CertInfo.ISSUER + "." + CertificateSubjectName.DN_NAME, issuer);
//
//    AlgorithmId algorithm = new AlgorithmId(AlgorithmId.md5WithRSAEncryption_oid);
//    certInfo.set(CertificateAlgorithmId.NAME + "." + CertificateAlgorithmId.ALGORITHM, algorithm);
//    X509CertImpl newCert = new X509CertImpl(certInfo);
//
//    newCert.sign(caPrivateKey, "MD5WithRSA");
//
//    keyStore.setKeyEntry(newAlias, privateKey, certPassword,
//        new java.security.cert.Certificate[] { newCert });
//
//    FileOutputStream output = new FileOutputStream(keystoreFile);
//    keyStore.store(output, password);
//    output.close();
//
//  }

  public static void main(String args[]) {
    // almacen y passwd
    String keystoreFile = "keystore.jks";
    String password = "es.jamisoft";

    // CA y passwd
    String caAlias = "test";
    String caPassword = "testtest";

    // CA firmante
    String certToSignAlias = "test";
    
    // nuevo certificado y passwd
    String newAlias = "test3";
    String certPassword = "testtest";

        try {
            AlmacenClaves.createKey(keystoreFile, caAlias, certToSignAlias,
                    newAlias, password.toCharArray(), caPassword.toCharArray(),
                    certPassword.toCharArray());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
  }
}