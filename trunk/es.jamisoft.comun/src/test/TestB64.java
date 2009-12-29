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



package test;

//~--- non-JDK imports --------------------------------------------------------

import es.jamisoft.comun.codec.B64;
import es.jamisoft.comun.codec.B64Codec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author Jose
 */
public class TestB64 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EncoderException, DecoderException {
        B64    lb64    = new B64();
        String lsTexto = "Cadena texto plano";

        System.out.println(lsTexto);

        byte[] lbTempEnc = lb64.encode(lsTexto.getBytes());

        System.out.println(lbTempEnc);

        byte[] lbTempDec  = lb64.decode(lbTempEnc);
        String lsTextoDec = new String(lbTempDec);

        System.out.println(lsTextoDec);
        System.out.println("=================================================");

        B64Codec b64c = new B64Codec();

        System.out.println(lsTexto);

        String lbTempStrEnc = b64c.encode(lsTexto);

        System.out.println(lbTempStrEnc);

        String lbTempStrDec = b64c.decode(lbTempStrEnc);

        System.out.println(lbTempStrDec);
    }
}
