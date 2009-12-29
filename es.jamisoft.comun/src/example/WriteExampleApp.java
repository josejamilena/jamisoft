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

import org.apache.commons.betwixt.io.BeanWriter;

//~--- JDK imports ------------------------------------------------------------

import java.io.StringWriter;

//~--- classes ----------------------------------------------------------------

public class WriteExampleApp {

    /**
     * Create an example bean and then convert it to xml.
     */
    public static final void main(String[] args) throws Exception {

        // Start by preparing the writer
        // We'll write to a string
        StringWriter outputWriter = new StringWriter();

        // Betwixt just writes out the bean as a fragment
        // So if we want well-formed xml, we need to add the prolog
        outputWriter.write("<?xml version='1.0' ?>");
        outputWriter.write("\n");

        // Create a BeanWriter which writes to our prepared stream
        BeanWriter beanWriter = new BeanWriter(outputWriter);

        // Configure betwixt
        // For more details see java docs or later in the main documentation
        beanWriter.getXMLIntrospector().getConfiguration().setAttributesForPrimitives(false);
        beanWriter.getBindingConfiguration().setMapIDs(false);
        beanWriter.enablePrettyPrint();

        // If the base element is not passed in, Betwixt will guess
        // But let's write example bean as base element 'person'
        beanWriter.write("person", new PersonBean("John Smith", 21));

        // Write to System.out
        // (We could have used the empty constructor for BeanWriter
        // but this way is more instructive)
        System.out.println(outputWriter.toString());

        // Betwixt writes fragments not documents so does not automatically close
        // writers or streams.
        // This example will do no more writing so close the writer now.
        outputWriter.close();
    }
}
