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
package es.jamisoft.comun.utils.compression;

//~--- JDK imports ------------------------------------------------------------
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.Enumeration;
import java.util.jar.JarFile;
import org.apache.commons.compress.archivers.jar.JarArchiveEntry;
import org.apache.commons.compress.archivers.jar.JarArchiveInputStream;
import org.apache.commons.compress.archivers.jar.JarArchiveOutputStream;

//~--- classes ----------------------------------------------------------------
public class Jar {

    private static final int SIZE_BUFFER = 2048;
    //~--- fields -------------------------------------------------------------
    String isDirectorioRelativoComp;
    String isFicheroJar;
    JarArchiveOutputStream sout;

    //~--- constructors -------------------------------------------------------
    public Jar(String asFich) {
        sout = null;
        isFicheroJar = "";
        isDirectorioRelativoComp = "";
        isFicheroJar = asFich;
    }

    //~--- methods ------------------------------------------------------------
    private void addToJar(File afFichero, String asDir) {
        try {
            String lsRutaAbs = afFichero.getPath();
            String lsRutaRelat = lsRutaAbs.substring(isDirectorioRelativoComp.length(), lsRutaAbs.length());
            JarArchiveEntry entry = new JarArchiveEntry(lsRutaRelat);

            sout.putArchiveEntry(entry);

            FileInputStream lfin = new FileInputStream(afFichero);
            byte buffer[] = new byte[2048];
            int liLeido = -1;
            int numCaracteresLeidos = 0;

            while ((liLeido = lfin.read(buffer, 0, 2048)) != -1) {
                sout.write(buffer, 0, liLeido);
            }

            sout.flush();
            sout.closeArchiveEntry();
            lfin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void comprimir(String asDir) {
        try {
            isDirectorioRelativoComp = asDir;
            sout = new JarArchiveOutputStream(new FileOutputStream(isFicheroJar));
            sout.setLevel(6);
            compress(asDir);
            metaInf();
            sout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void descomprimir(String lsDirDestino) {
        try {
            JarFile lzfFichero = new JarFile(isFicheroJar);
            Enumeration lenum = lzfFichero.entries();
            JarArchiveEntry entrada = null;
            InputStream linput;

            for (; lenum.hasMoreElements(); linput.close()) {
                entrada = (JarArchiveEntry) lenum.nextElement();
                linput = lzfFichero.getInputStream(entrada);

                byte labBytes[] = new byte[2048];
                int liLeido = -1;
                String lsRutaDestino = lsDirDestino + File.separator + entrada.getName();

                lsRutaDestino = lsRutaDestino.replace('\\', File.separatorChar);

                File lfRutaCompleta = new File(lsRutaDestino);
                String lsRuta = lfRutaCompleta.getAbsolutePath();
                int liPosSeparator = lsRuta.lastIndexOf(File.separatorChar);

                lsRuta = lsRuta.substring(0, liPosSeparator);

                File ldDir = new File(lsRuta);
                boolean lbCreado = ldDir.mkdirs();

                if (entrada.isDirectory()) {
                    continue;
                }

                FileOutputStream loutput = new FileOutputStream(lfRutaCompleta);

                if (entrada.getSize() > 0L) {
                    while ((liLeido = linput.read(labBytes, 0, 2048)) != -1) {
                        loutput.write(labBytes, 0, liLeido);
                    }
                }

                loutput.flush();
                loutput.close();
            }

            lzfFichero.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void unjar(InputStream is, String outputDirectory) throws IOException {
        JarArchiveInputStream jis = new JarArchiveInputStream(is);
        JarArchiveEntry jarEntry = null;
        byte buffer[] = new byte[1024];
        int readCount = 0;

        if (!outputDirectory.endsWith(File.separator)) {
            outputDirectory = outputDirectory + File.separator;
        }

        do {
            if ((jarEntry = jis.getNextJarEntry()) == null) {
                break;
            }

            if (jarEntry.isDirectory()) {
                File file = new File(outputDirectory + jarEntry.getName());

                if (!file.exists()) {
                    file.mkdir();
                }
            } else {
                FileOutputStream fos = new FileOutputStream(outputDirectory + jarEntry.getName());

                while ((readCount = jis.read(buffer)) != -1) {
                    fos.write(buffer, 0, readCount);
                }

                fos.close();
            }
        } while (true);

        jis.close();
    }

    private void compress(String asDir) {
        File d = new File(asDir);
        File lfFicheros[] = d.listFiles();

        if ((lfFicheros != null) && (lfFicheros.length > 0)) {
            try {
                for (int i = 0; i < lfFicheros.length; i++) {
                    if (lfFicheros[i].isDirectory()) {
                        compress(lfFicheros[i].getAbsolutePath());
                    } else {
                        addToJar(lfFicheros[i], asDir);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("no tiene ficheros ");
        }
    }

    private void metaInf() {
        byte[] buf = "Manifest-Version: 1.0\r\nX-COMMENT: www.jamisoft.es - Jose Antonio Jamilena Daza".getBytes();
        ByteArrayInputStream manifest = new ByteArrayInputStream(buf);
        String asDir = "/META-INF/";
        try {
            String lsRutaAbs = "/META-INF/manifest.mf";
            //String lsRutaRelat = lsRutaAbs.substring(isDirectorioRelativoComp.length(), lsRutaAbs.length());
            String lsRutaRelat = lsRutaAbs;
            JarArchiveEntry entry = new JarArchiveEntry(lsRutaRelat);

            sout.putArchiveEntry(entry);

            byte buffer[] = new byte[2048];
            int liLeido = -1;
            int numCaracteresLeidos = 0;

            while ((liLeido = manifest.read(buffer, 0, 2048)) != -1) {
                sout.write(buffer, 0, liLeido);
            }

            sout.flush();
            sout.closeArchiveEntry();
            manifest.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        System.out.println("antes");

        Jar z = new Jar("c:/bdDes.zip");

        z.comprimir("c:/Cabsdk");
        System.out.println("fin de descomprimir...");
    }
}
