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



package es.jamisoft.comun.codec;

//~--- non-JDK imports --------------------------------------------------------

import es.jamisoft.comun.codec.exceptions.B64DecoderException;
import es.jamisoft.comun.codec.exceptions.B64EncoderException;

import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.net.BCodec;

//~--- JDK imports ------------------------------------------------------------

import java.io.UnsupportedEncodingException;

//~--- classes ----------------------------------------------------------------

/**
 * <p>
 * Identical to the Base64 encoding defined by <a href="http://www.ietf.org/rfc/rfc1521.txt">RFC
 * 1521</a> and allows a character set to be specified.
 * </p>
 *
 * <p>
 * <a href="http://www.ietf.org/rfc/rfc1522.txt">RFC 1522</a> describes techniques to allow the encoding of non-ASCII
 * text in various portions of a RFC 822 [2] message header, in a manner which is unlikely to confuse existing message
 * handling software.
 * </p>
 *
 * @see <a href="http://www.ietf.org/rfc/rfc1522.txt">MIME (Multipurpose Internet Mail Extensions) Part Two: Message
 *          Header Extensions for Non-ASCII Text</a>
 *
 * @author Apache Software Foundation
 * @since 1.3
 * @version $Id: BCodec.java 797857 2009-07-25 23:43:33Z ggregory $
 *
 * B64Codec
 * @author Jose Antonio Jamilena Daza
 */
public class B64Codec extends BCodec {

    /**
     * The default charset used for string decoding and encoding.
     */
    private final String charset;

    //~--- constructors -------------------------------------------------------

    /**
     * Default constructor.
     */
    public B64Codec() {
        this(CharEncoding.UTF_8);
    }

    /**
     * Constructor which allows for the selection of a default charset
     *
     * @param charset
     *                  the default string charset to use.
     *
     * @see <a href="http://java.sun.com/j2se/1.4.2/docs/api/java/nio/charset/Charset.html">Standard charsets</a>
     */
    public B64Codec(final String charset) {
        super();
        this.charset = charset;
    }

    //~--- get methods --------------------------------------------------------

    protected String getEncoding() {
        return "B64Codec";
    }

    //~--- methods ------------------------------------------------------------

    protected byte[] doEncoding(byte[] bytes) {
        if (bytes == null) {
            return null;
        }

        return Base64.encodeBase64(bytes);
    }

    protected byte[] doDecoding(byte[] bytes) {
        if (bytes == null) {
            return null;
        }

        return Base64.decodeBase64(bytes);
    }

    /**
     * Encodes a string into its Base64 form using the specified charset. Unsafe characters are escaped.
     *
     * @param value
     *                  string to convert to Base64 form
     * @param charset
     *                  the charset for <code>value</code>
     * @return Base64 string
     *
     * @throws B64EncoderException
     *                  thrown if a failure condition is encountered during the encoding process.
     */
    public String encode(final String value, final String charset) throws B64EncoderException {
        if (value == null) {
            return null;
        }

        try {
            return encodeText(value, charset);
        } catch (Exception e) {
            throw new B64EncoderException(e.getMessage());
        }
    }

    /**
     * Encodes a string into its Base64 form using the default charset. Unsafe characters are escaped.
     *
     * @param value
     *                  string to convert to Base64 form
     * @return Base64 string
     *
     * @throws B64EncoderException
     *                  thrown if a failure condition is encountered during the encoding process.
     */
    public String encode(String value) throws B64EncoderException {
        if (value == null) {
            return null;
        }

        return encode(value, getDefaultCharset());
    }

    /**
     * Decodes a Base64 string into its original form. Escaped characters are converted back to their original
     * representation.
     *
     * @param value
     *            Base64 string to convert into its original form
     * @return original string
     * @throws B64DecoderException
     *             A decoder exception is thrown if a failure condition is encountered during the decode process.
     */
    public String decode(String value) throws B64DecoderException {
        if (value == null) {
            return null;
        }

        try {
            return decodeText(value);
        } catch (Exception e) {
            throw new B64DecoderException(e.getMessage());
        }
    }

    /**
     * Encodes an object into its Base64 form using the default charset. Unsafe characters are escaped.
     *
     * @param value
     *                  object to convert to Base64 form
     * @return Base64 object
     *
     * @throws EncoderException
     *                  thrown if a failure condition is encountered during the encoding process.
     */
    public Object encode(Object value) throws EncoderException {
        if (value == null) {
            return null;
        } else if (value instanceof String) {
            return encode((String) value);
        } else {
            throw new EncoderException("Objects of type " + value.getClass().getName()
                                       + " cannot be encoded using BCodec");
        }
    }

    /**
     * Decodes a Base64 object into its original form. Escaped characters are converted back to their original
     * representation.
     *
     * @param value
     *                  Base64 object to convert into its original form
     *
     * @return original object
     *
     * @throws DecoderException
     *                  Thrown if the argument is not a <code>String</code>. Thrown if a failure condition is
     *                  encountered during the decode process.
     */
    public Object decode(Object value) throws DecoderException {
        if (value == null) {
            return null;
        } else if (value instanceof String) {
            return decode((String) value);
        } else {
            throw new DecoderException("Objects of type " + value.getClass().getName()
                                       + " cannot be decoded using BCodec");
        }
    }

    //~--- get methods --------------------------------------------------------

    /**
     * The default charset used for string decoding and encoding.
     *
     * @return the default string charset.
     */
    public String getDefaultCharset() {
        return this.charset;
    }
}
