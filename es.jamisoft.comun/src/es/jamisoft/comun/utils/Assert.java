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



package es.jamisoft.comun.utils;

/**
 * Asserts conditions.
 *
 * @author
 *
 */
public final class Assert {
    private Assert() {
        throw new AssertionError("Do not instantiate utility class");
    }

    //~--- get methods --------------------------------------------------------

    public static void isNull(Object tested) {
        isNull(tested, "Argument must be null");
    }

    public static void isNull(Object tested, String message) {
        if (tested != null) {
            throw new IllegalArgumentException(message);
        }
    }

    //~--- methods ------------------------------------------------------------

    public static void notNull(Object tested) {
        notNull(tested, "Argument cannot be null");
    }

    public static void notNull(Object tested, String message) {
        if (tested == null) {
            throw new IllegalArgumentException(message);
        }
    }

    //~--- get methods --------------------------------------------------------

    public static void hasText(String tested) {
        hasText(tested, "Input cannot be empty");
    }

    public static void hasText(String tested, String message) {
        if (!StringUtils.hasText(tested)) {
            throw new IllegalArgumentException(message);
        }
    }
}
