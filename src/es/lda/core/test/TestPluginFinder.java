package es.lda.core.test;

import es.lda.core.lib.driver.IDriver;
import es.lda.core.lib.plugin.PluginFinder;
import java.util.List;

public class TestPluginFinder {
    private static Object o;

    public static void main(String[] args) {
        try {
            PluginFinder pluginFinder = new PluginFinder();
            pluginFinder.search("./plugin");
            List<String> pluginCollection = pluginFinder.getPluginCollection();
            for (String plugin : pluginCollection) {
                System.out.println("Driver encontrado => " + plugin);
                Class temp = pluginFinder.searchImpl("./plugin", plugin);
                System.out.println("Implementación Driver encontrado => " + temp.getName());
                IDriver o = (IDriver) temp.newInstance();                
                System.out.println(o.hashCode());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
