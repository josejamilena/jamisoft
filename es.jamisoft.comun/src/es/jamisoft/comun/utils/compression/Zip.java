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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

//~--- classes ----------------------------------------------------------------

public class Zip {
    private static final int SIZE_BUFFER = 2048;

    //~--- fields -------------------------------------------------------------

    String          isDirectorioRelativoComp;
    String          isFicheroZip;
    ZipOutputStream sout;

    //~--- constructors -------------------------------------------------------

    public Zip(String asFich) {
        sout                     = null;
        isFicheroZip             = "";
        isDirectorioRelativoComp = "";
        isFicheroZip             = asFich;
    }

    //~--- methods ------------------------------------------------------------

    private void addToZip(File afFichero, String asDir) {
        try {
            String   lsRutaAbs   = afFichero.getPath();
            String   lsRutaRelat = lsRutaAbs.substring(isDirectorioRelativoComp.length(), lsRutaAbs.length());
            ZipEntry entry       = new ZipEntry(lsRutaRelat);

            sout.putNextEntry(entry);

            FileInputStream lfin                = new FileInputStream(afFichero);
            byte            buffer[]            = new byte[2048];
            int             liLeido             = -1;
            int             numCaracteresLeidos = 0;

            while ((liLeido = lfin.read(buffer, 0, 2048)) != -1) {
                sout.write(buffer, 0, liLeido);
            }

            sout.flush();
            sout.closeEntry();
            lfin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void comprimir(String asDir) {
        try {
            isDirectorioRelativoComp = asDir;
            sout                     = new ZipOutputStream(new FileOutputStream(isFicheroZip));
            sout.setLevel(6);
            compress(asDir);
            sout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void descomprimir(String lsDirDestino) {
        try {
            ZipFile     lzfFichero = new ZipFile(isFicheroZip);
            Enumeration lenum      = lzfFichero.entries();
            ZipEntry    entrada    = null;
            InputStream linput;

            for (; lenum.hasMoreElements(); linput.close()) {
                entrada = (ZipEntry) lenum.nextElement();
                linput  = lzfFichero.getInputStream(entrada);

                byte   labBytes[]    = new byte[2048];
                int    liLeido       = -1;
                String lsRutaDestino = lsDirDestino + File.separator + entrada.getName();

                lsRutaDestino = lsRutaDestino.replace('\\', File.separatorChar);

                File   lfRutaCompleta = new File(lsRutaDestino);
                String lsRuta         = lfRutaCompleta.getAbsolutePath();
                int    liPosSeparator = lsRuta.lastIndexOf(File.separatorChar);

                lsRuta = lsRuta.substring(0, liPosSeparator);

                File    ldDir    = new File(lsRuta);
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

    private void unzip(InputStream is, String outputDirectory) throws IOException {
        ZipInputStream zis       = new ZipInputStream(is);
        ZipEntry       zipEntry  = null;
        byte           buffer[]  = new byte[1024];
        int            readCount = 0;

        if (!outputDirectory.endsWith(File.separator)) {
            outputDirectory = outputDirectory + File.separator;
        }

        do {
            if ((zipEntry = zis.getNextEntry()) == null) {
                break;
            }

            if (zipEntry.isDirectory()) {
                File file = new File(outputDirectory + zipEntry.getName());

                if (!file.exists()) {
                    file.mkdir();
                }
            } else {
                FileOutputStream fos = new FileOutputStream(outputDirectory + zipEntry.getName());

                while ((readCount = zis.read(buffer)) != -1) {
                    fos.write(buffer, 0, readCount);
                }

                fos.close();
            }
        } while (true);

        zis.close();
    }

    private void compress(String asDir) {
        File d            = new File(asDir);
        File lfFicheros[] = d.listFiles();

        if ((lfFicheros != null) && (lfFicheros.length > 0)) {
            try {
                for (int i = 0; i < lfFicheros.length; i++) {
                    if (lfFicheros[i].isDirectory()) {
                        compress(lfFicheros[i].getAbsolutePath());
                    } else {
                        addToZip(lfFicheros[i], asDir);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("no tiene ficheros ");
        }
    }

    public static void main(String args[]) {
        System.out.println("antes");

        Jar z = new Jar("c:/bdDes.zip");

        z.comprimir("c:/Cabsdk");
        System.out.println("fin de descomprimir...");
    }
}
