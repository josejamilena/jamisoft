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

//~--- JDK imports ------------------------------------------------------------

import java.util.UUID;

//~--- classes ----------------------------------------------------------------

/**
 * Generates UUIDs
 *
 * @author IBM
 *
 */
public final class UUIDUtils {
    private UUIDUtils() {
        throw new AssertionError("Do not instantiate utility class");
    }

    //~--- methods ------------------------------------------------------------

    /**
     * Generates a unique identifier
     */
    public synchronized static String generate() {
        UUID uuid = UUID.randomUUID();

        return uuid.toString().replaceAll("-", "").toUpperCase();
    }
}
