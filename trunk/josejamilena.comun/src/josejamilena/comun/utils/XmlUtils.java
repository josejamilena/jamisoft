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



package josejamilena.comun.utils;

//~--- non-JDK imports --------------------------------------------------------

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.DOMReader;
import org.dom4j.io.SAXReader;

import org.w3c.dom.Node;

//~--- JDK imports ------------------------------------------------------------

import java.io.StringReader;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

//~--- classes ----------------------------------------------------------------

/**
 * Clase de utilidad para el manejo de XML
 *
 * @author IBM
 *
 */
public final class XmlUtils {
    private XmlUtils() {
        throw new AssertionError("Do not instantiate utility class");
    }

    //~--- methods ------------------------------------------------------------

    /**
     * Transforma una cadena en un objeto Document de Dom4J.
     */
    public static final Document readXML(String content) {
        try {
            return new SAXReader().read(new StringReader(content));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Parse a document from a URL string using the provided credentials if any.
     *
     */
    public static final Document readXML(final String url, final String username, final String password)
            throws DocumentException {
        SAXReader reader = new SAXReader();

        if (StringUtils.hasText(username)) {
            Assert.hasText(password);
            Authenticator.setDefault(new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password.toCharArray());
                }
            });
        }

        return reader.read(url);
    }

    public static final Document toDom4J(Node node) {
        try {
            return new DOMReader().read(node.getOwnerDocument());
        } catch (Exception e) {
            return null;
        }
    }
}
