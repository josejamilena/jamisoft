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
package es.jamisoft.cryptography.sign.keystore;

import es.jamisoft.cryptography.exception.CryptoException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Date;
import sun.security.x509.AlgorithmId;
import sun.security.x509.CertificateAlgorithmId;
import sun.security.x509.CertificateIssuerName;
import sun.security.x509.CertificateSerialNumber;
import sun.security.x509.CertificateSubjectName;
import sun.security.x509.CertificateValidity;
import sun.security.x509.X500Name;
import sun.security.x509.X509CertImpl;
import sun.security.x509.X509CertInfo;

/**
 *
 * @author Jose Antonio Jamilena Daza
 */
public class AlmacenClaves {

    public static final String KEYSTORE_TYPE = "JKS";
    public static final String ALGORITMO = "MD5withRSA";

    /**
     *
     * @param keystoreIs
     * @param password
     * @param alias
     * @return
     * @throws CryptoException
     */
    public static Certificate loadKey(InputStream keystoreIs, char[] password, String alias) throws CryptoException {
        Certificate cert = null;
        try {
            KeyStore keystore = KeyStore.getInstance(AlmacenClaves.KEYSTORE_TYPE);
            keystore.load(keystoreIs, password);
            cert = keystore.getCertificate(alias);
            return cert;
        } catch (IOException ex) {
            new CryptoException(ex.toString());
        } catch (NoSuchAlgorithmException ex) {
            new CryptoException(ex.toString());
        } catch (CertificateException ex) {
            new CryptoException(ex.toString());
        } catch (KeyStoreException ex) {
            new CryptoException(ex.toString());
        } finally {
            return cert;
        }
    }

    /**
     * Crea un certificado.
     * @param keystoreFile almacen de claves.
     * @param caAlias CA generadora.
     * @param certToSignAlias
     * @param newAlias nuevo certificado.
     * @param password Password del alamacen de claves.
     * @param caPassword Password CA gegeradora.
     * @param certPassword password del nuevo certificado.
     * @throws Exception
     */
    public static void createKey(String keystoreFile, String caAlias,
            String certToSignAlias, String newAlias,
            char[] password, char[] caPassword, char[] certPassword) throws CryptoException {
        {
            FileInputStream keystoreIs = null;
            try {
                KeyStore keyStore = KeyStore.getInstance(AlmacenClaves.KEYSTORE_TYPE);
                keystoreIs = new FileInputStream(keystoreFile);
                keyStore.load(keystoreIs, password);
                keystoreIs.close();
                PrivateKey caPrivateKey = (PrivateKey) keyStore.getKey(caAlias, caPassword);
                Certificate caCert = keyStore.getCertificate(caAlias);
                byte[] encoded = caCert.getEncoded();
                X509CertImpl caCertImpl = new X509CertImpl(encoded);
                X509CertInfo caCertInfo = (X509CertInfo) caCertImpl.get(X509CertImpl.NAME + "."
                        + X509CertImpl.INFO);
                X500Name issuer = (X500Name) caCertInfo.get(X509CertInfo.SUBJECT + "."
                        + CertificateIssuerName.DN_NAME);
                Certificate cert = keyStore.getCertificate(certToSignAlias);
                PrivateKey privateKey = (PrivateKey) keyStore.getKey(certToSignAlias, certPassword);
                encoded = cert.getEncoded();
                X509CertImpl certImpl = new X509CertImpl(encoded);
                X509CertInfo certInfo = (X509CertInfo) certImpl.get(X509CertImpl.NAME + "." + X509CertImpl.INFO);
                Date firstDate = new Date();
                Date lastDate = new Date(firstDate.getTime() + 365 * 24 * 60 * 60 * 1000L);
                CertificateValidity interval = new CertificateValidity(firstDate, lastDate);
                certInfo.set(X509CertInfo.VALIDITY, interval);
                certInfo.set(X509CertInfo.SERIAL_NUMBER, new CertificateSerialNumber((int) (firstDate.getTime() / 1000)));
                certInfo.set(X509CertInfo.ISSUER + "." + CertificateSubjectName.DN_NAME, issuer);
                AlgorithmId algorithm = new AlgorithmId(AlgorithmId.md5WithRSAEncryption_oid);
                certInfo.set(CertificateAlgorithmId.NAME + "." + CertificateAlgorithmId.ALGORITHM, algorithm);
                X509CertImpl newCert = new X509CertImpl(certInfo);
                newCert.sign(caPrivateKey, AlmacenClaves.ALGORITMO);
                keyStore.setKeyEntry(newAlias, privateKey, certPassword, new Certificate[]{newCert});
                FileOutputStream output = new FileOutputStream(keystoreFile);
                keyStore.store(output, password);
                output.close();
            } catch (InvalidKeyException ex) {
                new CryptoException(ex.toString());
            } catch (NoSuchProviderException ex) {
                new CryptoException(ex.toString());
            } catch (SignatureException ex) {
                new CryptoException(ex.toString());
            } catch (UnrecoverableKeyException ex) {
                new CryptoException(ex.toString());
            } catch (IOException ex) {
                new CryptoException(ex.toString());
            } catch (NoSuchAlgorithmException ex) {
                new CryptoException(ex.toString());
            } catch (CertificateException ex) {
                new CryptoException(ex.toString());
            } catch (KeyStoreException ex) {
                new CryptoException(ex.toString());
            } finally {
                try {
                    keystoreIs.close();
                } catch (IOException ex) {
                    new CryptoException(ex.toString());
                }
            }
        }
    }

    public static void exportCertificate(InputStream keystoreIs, String password, String alias, String archCert) throws CryptoException {
        try {
            KeyStore keystore = KeyStore.getInstance(AlmacenClaves.KEYSTORE_TYPE);
            keystore.load(keystoreIs, password.toCharArray());
            Certificate cert = keystore.getCertificate(alias);
            byte[] buf = cert.getEncoded();
            FileOutputStream os = new FileOutputStream(archCert);
            os.write(buf);
            os.close();
            Writer wr = new OutputStreamWriter(os, Charset.forName("UTF-8"));
            wr.write(new sun.misc.BASE64Encoder().encode(buf));
            wr.flush();
        } catch (IOException ex) {
            new CryptoException(ex.toString());
        } catch (NoSuchAlgorithmException ex) {
            new CryptoException(ex.toString());
        } catch (CertificateException ex) {
            new CryptoException(ex.toString());
        } catch (KeyStoreException ex) {
            new CryptoException(ex.toString());
        }
    }

    /**
     *
     * @param keystoreIs almacen de claves.
     * @param alias alias a recuperar.
     * @param password password alamcen.
     * @param passwordAlias password alias.
     * @return par de claves.
     * @throws CryptoException
     */
    public static KeyPair getPrivateKey(InputStream keystoreIs, String alias, String password, String passwordAlias) throws CryptoException {
        KeyPair par = null;
        try {
            KeyStore keystore = KeyStore.getInstance(AlmacenClaves.KEYSTORE_TYPE);
            keystore.load(keystoreIs, password.toCharArray());
            // Get private key
            Key key = keystore.getKey(alias, passwordAlias.toCharArray());
            if (key instanceof PrivateKey) {
                // Get certificate of public key
                Certificate cert = keystore.getCertificate(alias);
                // Get public key
                PublicKey publicKey = cert.getPublicKey();
                // Return a key pair
                par = new KeyPair(publicKey, (PrivateKey) key);
            }
        } catch (UnrecoverableKeyException e) {
            new CryptoException(e.toString());
        } catch (NoSuchAlgorithmException e) {
            new CryptoException(e.toString());
        } catch (KeyStoreException e) {
            new CryptoException(e.toString());
        } finally {
            return par;
        }
    }
}
