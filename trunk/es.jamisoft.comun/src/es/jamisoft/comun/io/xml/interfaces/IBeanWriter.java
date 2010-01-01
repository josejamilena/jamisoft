
package es.jamisoft.comun.io.xml.interfaces;

import java.beans.IntrospectionException;
import java.io.IOException;
import org.apache.commons.betwixt.strategy.MixedContentEncodingStrategy;
import org.apache.commons.logging.Log;
import org.xml.sax.SAXException;

/**
 *
 * @author Jose
 */
public interface IBeanWriter {

    /**
     * Closes the underlying output stream
     *
     * @throws IOException when writer cannot be closed
     */
    void close() throws IOException;

    /**
     * <p> Switch on formatted output.
     * This sets the end of line and the indent.
     * The default is adding 2 spaces and a newline
     */
    void enablePrettyPrint();

    /**
     * Allows output to be flushed on the underlying output stream
     *
     * @throws IOException when the flush cannot be completed
     */
    void flush() throws IOException;

    /**
     *
     * Gets the string used to mark end of lines.
     *
     * @return the string used for end of lines
     */
    String getEndOfLine();

    /**
     *
     * Gets the indent string
     *
     * @return the string used for indentation
     */
    String getIndent();

    /**
     *
     * Gets the initial indent level
     *
     * @return the initial level for indentation
     * @since 0.8
     */
    int getInitialIndentLevel();

    /**
     * <p> Set the log implementation used. </p>
     *
     * @return a <code>org.apache.commons.logging.Log</code> level constant
     */
    Log getLog();

    /**
     * Gets the encoding strategy for mixed content.
     * This is used to process body content
     * before it is written to the textual output.
     * @return the <code>MixedContentEncodingStrategy</code>, not null
     * @since 0.5
     */
    MixedContentEncodingStrategy getMixedContentEncodingStrategy();

    /**
     * <p>Should an end tag be added for each empty element?
     * </p><p>
     * When this property is false then empty elements will
     * be written as <code>&lt;<em>element-name</em>/gt;</code>.
     * When this property is true then empty elements will
     * be written as <code>&lt;<em>element-name</em>gt;
     * &lt;/<em>element-name</em>gt;</code>.
     * </p>
     * @return true if an end tag should be added
     */
    boolean isEndTagForEmptyElement();

    /**
     *
     * Sets the string used for end of lines
     * Produces a warning the specified value contains an invalid whitespace character
     *
     * @param endOfLine the <code>String</code to use
     */
    void setEndOfLine(String endOfLine);

    /**
     * Sets when an an end tag be added for each empty element.
     * When this property is false then empty elements will
     * be written as <code>&lt;<em>element-name</em>/gt;</code>.
     * When this property is true then empty elements will
     * be written as <code>&lt;<em>element-name</em>gt;
     * &lt;/<em>element-name</em>gt;</code>.
     * @param addEndTagForEmptyElement true if an end tag should be
     * written for each empty element, false otherwise
     */
    void setEndTagForEmptyElement(boolean addEndTagForEmptyElement);

    /**
     *
     * Sets the string used for pretty print indents
     * @param indent use this <code>string</code> for indents
     */
    void setIndent(String indent);

    /**
     *
     * Sets the initial indent level used for pretty print indents
     * @param initialIndentLevel use this <code>int</code> to start with
     * @since 0.8
     */
    void setInitialIndentLevel(int initialIndentLevel);

    /**
     * <p> Set the log implementation used. </p>
     *
     * @param log <code>Log</code> implementation to use
     */
    void setLog(Log log);

    /**
     * Sets the encoding strategy for mixed content.
     * This is used to process body content
     * before it is written to the textual output.
     * @param strategy the <code>MixedContentEncodingStrategy</code>
     * used to process body content, not null
     * @since 0.5
     */
    void setMixedContentEncodingStrategy(MixedContentEncodingStrategy strategy);

    /**
     * Write the given object to the stream (and then flush).
     *
     * @param bean write this <code>Object</code> to the stream
     * @throws IOException if an IO problem causes failure
     * @throws SAXException if a SAX problem causes failure
     * @throws IntrospectionException if bean cannot be introspected
     */
    void write(Object bean) throws IOException, SAXException, IntrospectionException;

    /**
     * A helper method that allows you to write the XML Declaration.
     * This should only be called once before you output any beans.
     *
     * @param xmlDeclaration is the XML declaration string typically of
     * the form "&lt;xml version='1.0' encoding='UTF-8' ?&gt;
     *
     * @throws IOException when declaration cannot be written
     */
    void writeXmlDeclaration(String xmlDeclaration) throws IOException;

}
