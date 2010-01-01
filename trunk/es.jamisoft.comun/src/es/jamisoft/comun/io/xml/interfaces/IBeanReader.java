
package es.jamisoft.comun.io.xml.interfaces;

import java.beans.IntrospectionException;
import java.io.IOException;
import org.apache.commons.betwixt.BindingConfiguration;
import org.apache.commons.betwixt.XMLIntrospector;
import org.apache.commons.betwixt.io.read.ReadConfiguration;
import org.apache.commons.logging.Log;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Jose
 */
public interface IBeanReader {

    /**
     * <p>Remove the given class from the register.
     * Calling this method will allow the bean class to be re-registered
     * by a subsequent call to <code>registerBeanClass</code>.
     * This allows (for example) a bean to be reintrospected after a change
     * to the introspection settings.</p>
     *
     * <p><strong>Note</strong> that deregistering a bean does <strong>not</strong>
     * remove the Digester rules associated with that bean.</p>
     *
     * @param beanClass the <code>Class</code> to remove from the set of registered bean classes
     * @since 0.5
     */
    void deregisterBeanClass(Class beanClass);

    /**
     * <p>Flush all registered bean classes.
     * This allows all bean classes to be re-registered
     * by a subsequent calls to <code>registerBeanClass</code>.</p>
     *
     * <p><strong>Note</strong> that deregistering a bean does <strong>not</strong>
     * remove the Digester rules associated with that bean.</p>
     * @since 0.5
     */
    void flushRegisteredBeanClasses();

    /**
     * Gets the dynamic configuration setting to be used for bean reading.
     * @return the BindingConfiguration settings, not null
     * @since 0.5
     */
    BindingConfiguration getBindingConfiguration();

    /**
     * <p> Get the current level for logging. </p>
     *
     * @return the <code>Log</code> implementation this class logs to
     */
    Log getLog();

    /**
     *
     * Should the reader use <code>ID</code> attributes to match beans.
     *
     * @return true if <code>ID</code> and <code>IDREF</code>
     * attributes should be used to match instances
     * @deprecated 0.5 use {@link BindingConfiguration#getMapIDs}
     */
    boolean getMatchIDs();

    /**
     * Gets read specific configuration details.
     * @return the ReadConfiguration, not null
     * @since 0.5
     */
    ReadConfiguration getReadConfiguration();

    /**
     * <p> Get the introspector used. </p>
     *
     * <p> The {@link XMLBeanInfo} used to map each bean is
     * created by the <code>XMLIntrospector</code>.
     * One way in which the mapping can be customized is by
     * altering the <code>XMLIntrospector</code>. </p>
     *
     * @return the <code>XMLIntrospector</code> used for the introspection
     */
    XMLIntrospector getXMLIntrospector();

    /**
     *
     * <p>Register a bean class and add mapping rules for this bean class.</p>
     *
     * <p>A bean class is introspected when it is registered.
     * It will <strong>not</strong> be introspected again even if the introspection
     * settings are changed.
     * If re-introspection is required, then {@link #deregisterBeanClass} must be called
     * and the bean re-registered.</p>
     *
     * <p>A bean class can only be registered once.
     * If the same class is registered a second time, this registration will be ignored.
     * In order to change a registration, call {@link #deregisterBeanClass}
     * before calling this method.</p>
     *
     * <p>All the rules required to digest this bean are added when this method is called.
     * Other rules that you want to execute before these should be added before this
     * method is called.
     * Those that should be executed afterwards, should be added afterwards.</p>
     *
     * @param beanClass the <code>Class</code> to be registered
     * @throws IntrospectionException if the bean introspection fails
     */
    void registerBeanClass(Class beanClass) throws IntrospectionException;

    /**
     *
     * <p>Registers a bean class
     * and add mapping rules for this bean class at the given path expression.</p>
     *
     *
     * <p>A bean class is introspected when it is registered.
     * It will <strong>not</strong> be introspected again even if the introspection
     * settings are changed.
     * If re-introspection is required, then {@link #deregisterBeanClass} must be called
     * and the bean re-registered.</p>
     *
     * <p>A bean class can only be registered once.
     * If the same class is registered a second time, this registration will be ignored.
     * In order to change a registration, call {@link #deregisterBeanClass}
     * before calling this method.</p>
     *
     * <p>All the rules required to digest this bean are added when this method is called.
     * Other rules that you want to execute before these should be added before this
     * method is called.
     * Those that should be executed afterwards, should be added afterwards.</p>
     *
     * @param path the xml path expression where the class is to registered.
     * This should be in digester path notation
     * @param beanClass the <code>Class</code> to be registered
     * @throws IntrospectionException if the bean introspection fails
     */
    void registerBeanClass(String path, Class beanClass) throws IntrospectionException;

    /**
     * <p>Registers a class with a custom mapping.
     * This mapping is specified by the standard dot betwixt document
     * contained in the given <code>InputSource</code>.
     * </p><p>
     * <strong>Note:</strong> the custom mapping will be registered with
     * the introspector. This must remain so for the reading to work correctly
     * It is recommended that use of the pre-registeration process provided
     * by {@link XMLIntrospector#register}  be considered as an alternative to this method.
     * </p>
     * @see #registerBeanClass(Class) since the general notes given there
     * apply equally to this
     * @since 0.7
     * @param mapping <code>InputSource</code> giving the dot betwixt document specifying
     * the mapping
     * @param beanClass <code>Class</code> that should be register
     * @throws IntrospectionException
     * @throws SAXException
     * @throws IOException
     */
    void registerBeanClass(InputSource mapping, Class beanClass) throws IntrospectionException, IOException, SAXException;

    /**
     * <p>Registers a class with a multi-mapping.
     * This mapping is specified by the multi-mapping document
     * contained in the given <code>InputSource</code>.
     * </p><p>
     * <strong>Note:</strong> the custom mappings will be registered with
     * the introspector. This must remain so for the reading to work correctly
     * It is recommended that use of the pre-registeration process provided
     * by {@link XMLIntrospector#register}  be considered as an alternative to this method.
     * </p>
     * @see #registerBeanClass(Class) since the general notes given there
     * apply equally to this
     * @see XMLIntrospector#register(InputSource) for more details on the multi-mapping format
     * @since 0.7
     * @param mapping <code>InputSource</code> giving the multi-mapping document specifying
     * the mapping
     * @throws IntrospectionException
     * @throws SAXException
     * @throws IOException
     */
    void registerMultiMapping(InputSource mapping) throws IntrospectionException, IOException, SAXException;

    /**
     * Sets the dynamic configuration setting to be used for bean reading.
     * @param bindingConfiguration the BindingConfiguration settings, not null
     * @since 0.5
     */
    void setBindingConfiguration(BindingConfiguration bindingConfiguration);

    /**
     * <p> Set the current logging level. </p>
     *
     * @param log the <code>Log</code>implementation to use for logging
     */
    void setLog(Log log);

    /**
     * Set whether the read should use <code>ID</code> attributes to match beans.
     *
     * @param matchIDs pass true if <code>ID</code>'s should be matched
     * @deprecated 0.5 use {@link BindingConfiguration#setMapIDs}
     */
    void setMatchIDs(boolean matchIDs);

    /**
     * Sets the read specific configuration details.
     * @param readConfiguration not null
     * @since 0.5
     */
    void setReadConfiguration(ReadConfiguration readConfiguration);

    /**
     * <p> Set the introspector to be used. </p>
     *
     * <p> The {@link XMLBeanInfo} used to map each bean is
     * created by the <code>XMLIntrospector</code>.
     * One way in which the mapping can be customized is by
     * altering the <code>XMLIntrospector</code>. </p>
     *
     * @param introspector use this introspector
     */
    void setXMLIntrospector(XMLIntrospector introspector);

}
