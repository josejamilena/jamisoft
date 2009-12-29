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



package es.jamisoft.comun.codec.exceptions;

//~--- non-JDK imports --------------------------------------------------------

import org.apache.commons.codec.DecoderException;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author Jose
 */
public class B64DecoderException extends DecoderException {

    /**
     * Creates a new instance of <code>B64DecoderException</code> without detail message.
     */
    public B64DecoderException() {}

    /**
     * Constructs an instance of <code>B64DecoderException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public B64DecoderException(String msg) {
        super(msg);
    }
}
