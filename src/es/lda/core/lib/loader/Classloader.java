package es.lda.core.lib.loader;

/**
 *
 * @author Jose Antonio
 */
public class Classloader {

    public static Class load(String clazz) {
        
        Class aClass = null;
        ClassLoader classLoader = Classloader.class.getClassLoader();

        try {
            aClass = classLoader.loadClass(clazz);
            System.out.println("aClass.getName() = " + aClass.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return aClass;
    }
}