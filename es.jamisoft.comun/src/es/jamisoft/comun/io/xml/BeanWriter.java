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



package es.jamisoft.comun.io.xml;

//~--- JDK imports ------------------------------------------------------------

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

//~--- classes ----------------------------------------------------------------

/**
 * @see org.apache.commons.betwixt.io.BeanWriter
 * @author Jose Antonio Jamilena Daza
 */
public class BeanWriter extends org.apache.commons.betwixt.io.BeanWriter {
    public BeanWriter() {
        super();
    }

    public BeanWriter(OutputStream out) {
        super(out);
    }

    public BeanWriter(Writer writer) {
        super(writer);
    }

    public BeanWriter(OutputStream out, String enc) throws UnsupportedEncodingException {
        super(out, enc);
    }
}
