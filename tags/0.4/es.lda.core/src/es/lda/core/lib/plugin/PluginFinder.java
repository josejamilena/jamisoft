package es.lda.core.lib.plugin;

import es.lda.core.lib.driver.IDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.logging.Level;
import org.apache.log4j.Logger;

/**
 * Search plugins.
 * @author Jose Antonio
 */
public class PluginFinder {

    /** Logger. */
    private static Logger logger = Logger.getLogger(PluginFinder.class);
    /** Parameters. */
    private static final Class[] parameters = new Class[]{URL.class};
    /** List Plugin. */
    private List<String> pluginCollection;
    /** List Class. */
    private List<Class> pluginCollectionClass;

    /** Contructor. */
    public PluginFinder() {
        pluginCollection = new LinkedList<String>();
        pluginCollectionClass = new LinkedList<Class>();
    }

    /** Search in plugin dir. */
    public void search(String directory) throws Exception {
        File dir = new File(directory);
        if (dir.isFile()) {
            return;
        }
        File[] files = dir.listFiles(new PluginFilter());
        for (File f : files) {
            List<String> classNames = getClassNames(f.getAbsolutePath());
            for (String className : classNames) {
                // Remove the ".class" at the back
                String name = className.substring(0, className.length() - 6);
                Class clazz = getClass(f, name);
                Class[] interfaces = clazz.getInterfaces();
                for (Class c : interfaces) {
                    // Implement the IDriver interface
                    if (c.getName().equals(IDriver.class.getName())) {
                        pluginCollection.add(clazz.getName());
                    }
                }
            }
        }
    }

    public Class searchImpl(String directory, String clazz) {
        File dir = new File(directory);
        Class clazz1 = null;
        try {
            if (!dir.isFile()) {
                File[] files = dir.listFiles(new PluginFilter());
                for (File f : files) {
                    List<String> classNames = getClassNames(f.getAbsolutePath());
                    for (String className : classNames) {
                        // Remove the ".class" at the back
                        String name = className.substring(0, className.length() - 6);
                        clazz1 = getClass(f, name);
                        Class[] interfaces = clazz1.getInterfaces();
                        for (Class c : interfaces) {
                            // Implement the IDriver interface
                            if (c.getName().equals(clazz)) {
                                pluginCollectionClass.add(clazz1);
                                return clazz1;
                            }
                        }
                    }
                }
            }
        } catch (IOException ex) {
            logger.error(ex);
        } finally {
            return clazz1;
        }
    }

    /**
     * List class name from a jar file.
     * @param jarName JAR file.
     * @return list.
     * @throws IOException Error.
     */
    protected List<String> getClassNames(String jarName) throws IOException {
        ArrayList<String> classes = new ArrayList<String>(10);
        JarInputStream jarFile = new JarInputStream(new FileInputStream(jarName));
        JarEntry jarEntry;
        while (true) {
            jarEntry = jarFile.getNextJarEntry();
            if (jarEntry == null) {
                break;
            }
            if (jarEntry.getName().endsWith(".class")) {
                classes.add(jarEntry.getName().replaceAll("/", "\\."));
            }
        }
        return classes;
    }

    /**
     * Get class from a JAR file.
     * @param file file.
     * @param name name.
     * @return class.
     * @throws Exception error.
     */
    public Class getClass(File file, String name) throws Exception {
        addURL(file.toURI().toURL());
        URLClassLoader clazzLoader;
        Class clazz;
        String filePath = file.getAbsolutePath();
        filePath = "jar:file://" + filePath + "!/";
        URL url = new File(filePath).toURI().toURL();
        clazzLoader = new URLClassLoader(new URL[]{url});
        clazz = clazzLoader.loadClass(name);
        return clazz;
    }

    /**
     * Add URL of a JAR file to Classpath.
     * @param u URL.
     * @throws IOException Error.
     */
    public void addURL(URL u) throws IOException {
        URLClassLoader sysLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        URL urls[] = sysLoader.getURLs();
        for (int i = 0; i < urls.length; i++) {
            if (urls[i].toString().equalsIgnoreCase(u.toString())) {
                return;
            }
        }
        Class sysclass = URLClassLoader.class;
        try {
            Method method = sysclass.getDeclaredMethod("addURL", parameters);
            method.setAccessible(true);
            method.invoke(sysLoader, new Object[]{u});
        } catch (Throwable t) {
            logger.error(t);
            throw new IOException("Error, could not add URL to system classloader");
        }
    }

    /**
     * Get.
     * @return drivers list.
     */
    public List<String> getPluginCollection() {
        return pluginCollection;
    }

    /**
     * Get.
     * @return drivers list.
     */
    public List<Class> getPluginCollectionClass() {
        return pluginCollectionClass;
    }
}
