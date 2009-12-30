package es.jamisoft.cryptography.sign;

import es.jamisoft.cryptography.sign.exception.FirmaException;
import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

/**
 *
 * @author Jose Antonio Jamilena Daza
 */
public class GenerarClaves {

    public static ParClaves run() {
        ParClaves par = null;
        try {
            /* Generate a key pair */
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ConfigFirma.cryptosystem, ConfigFirma.securityProviderName);
            SecureRandom random = SecureRandom.getInstance(ConfigFirma.secureRandomAlgorithm, ConfigFirma.secureRandomAlgorithm);
            keyGen.initialize(ConfigFirma.keySize, random);
            KeyPair pair = keyGen.generateKeyPair();
            PrivateKey priv = pair.getPrivate();
            PublicKey pub = pair.getPublic();
            byte[] keyPublic = pub.getEncoded();
            byte[] keyPrivate = priv.getEncoded();
            par.setPrivateKey(keyPrivate);
            par.setPublicKey(keyPublic);
        } catch (Exception e) {
            new FirmaException(e.getMessage());
        } finally {
            return par;
        }

    }
}
