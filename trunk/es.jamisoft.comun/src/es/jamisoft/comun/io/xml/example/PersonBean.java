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



package es.jamisoft.comun.io.xml.example;

public class PersonBean {
    private int    age;
    private String name;

    //~--- constructors -------------------------------------------------------

    /** Need to allow bean to be created via reflection */
    public PersonBean() {}

    public PersonBean(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    //~--- get methods --------------------------------------------------------

    public String getName() {
        return name;
    }

    //~--- set methods --------------------------------------------------------

    public void setName(String name) {
        this.name = name;
    }

    //~--- get methods --------------------------------------------------------

    public int getAge() {
        return age;
    }

    //~--- set methods --------------------------------------------------------

    public void setAge(int age) {
        this.age = age;
    }

    //~--- methods ------------------------------------------------------------

    public String toString() {
        return "PersonBean[name='" + name + "',age='" + age + "']";
    }
}
