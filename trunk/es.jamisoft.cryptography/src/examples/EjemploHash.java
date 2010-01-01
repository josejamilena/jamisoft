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



package examples;

//~--- JDK imports ------------------------------------------------------------

import java.io.*;

import java.security.*;

import javax.crypto.*;
import javax.crypto.interfaces.*;
import javax.crypto.spec.*;

//~--- classes ----------------------------------------------------------------

public class EjemploHash {

    /*
     *   Ejemplo de uso de funciones de resumen Hash
     *  carga el fichero que recibe como parametro y genera el resumen
     */
    public static void main(String[] args) throws Exception {

        // Comprobar argumentos
        if (args.length != 1) {
            mensajeAyuda();
            System.exit(1);
        }

        /* Cargar "provider" (sólo si no se usa el que viene por defecto) */

        // Security.addProvider(new BouncyCastleProvider());  // Usa provider BC

        /* Crear función resumen */
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");    // Usa MD5

        // MessageDigest messageDigest = MessageDigest.getInstance("SHA"); // Usar SHA-1

        /* Leer fichero de 1k en 1k y pasar fragmentos leidos a la funcion resumen */
        byte[]          buffer = new byte[1000];
        FileInputStream in     = new FileInputStream(args[0]);
        int             leidos = in.read(buffer, 0, 1000);

        while (leidos != -1) {
            messageDigest.update(buffer);    // Pasa texto claro a la función resumen
            leidos = in.read(buffer, 0, 1000);
        }

        in.close();

        byte[] resumen = messageDigest.digest();    // Completar el resumen

        // Mostrar resumen
        System.out.println("RESUMEN:");
        mostrarBytes(resumen);
        System.out.println();
    }

    public static void mostrarBytes(byte[] buffer) {
        System.out.write(buffer, 0, buffer.length);
    }

    public static void mensajeAyuda() {
        System.out.println("Ejemplo funciones Hash");
        System.out.println("\tSintaxis:   java EjemploHash fichero");
        System.out.println();
    }
}
