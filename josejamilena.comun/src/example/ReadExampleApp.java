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



package example;

//~--- non-JDK imports --------------------------------------------------------

import org.apache.commons.betwixt.io.BeanReader;

//~--- JDK imports ------------------------------------------------------------

import java.io.StringReader;

//~--- classes ----------------------------------------------------------------

public class ReadExampleApp {
    public static final void main(String args[]) throws Exception {

        // First construct the xml which will be read in
        // For this example, read in from a hard coded string
        StringReader xmlReader =
            new StringReader("<?xml version='1.0' ?><person><age>25</age><name>James Smith</name></person>");

        // Now convert this to a bean using betwixt
        // Create BeanReader
        BeanReader beanReader = new BeanReader();

        // Configure the reader
        // If you're round-tripping, make sure that the configurations are compatible!
        beanReader.getXMLIntrospector().getConfiguration().setAttributesForPrimitives(false);
        beanReader.getBindingConfiguration().setMapIDs(false);

        // Register beans so that betwixt knows what the xml is to be converted to
        // Since the element mapped to a PersonBean isn't called the same
        // as Betwixt would have guessed, need to register the path as well
        beanReader.registerBeanClass("person", PersonBean.class);

        // Now we parse the xml
        PersonBean person = (PersonBean) beanReader.parse(xmlReader);

        // send bean to system out
        System.out.println(person);
    }
}
