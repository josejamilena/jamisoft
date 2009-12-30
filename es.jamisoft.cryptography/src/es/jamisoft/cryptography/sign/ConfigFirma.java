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

import org.bouncycastle.jce.provider.BouncyCastleProvider;

//~--- JDK imports ------------------------------------------------------------

import java.security.Provider;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author Jose
 */
final public class ConfigFirma {
    public static String   cryptosystem             = "RSA";
    public static String   secureRandomAlgorithm    = "SHA1PRNG";
    public static String   secureRandomProviderName = "SUN";
    public static Provider securityProvider         = new BouncyCastleProvider();
    public static String   securityProviderName     = "BC";
    public static String   signatureAlgorithm       = "MD5WithRSAEncryption";
    public static short    keySize                  = 1024;
}
