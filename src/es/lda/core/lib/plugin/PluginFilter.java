package es.lda.core.lib.plugin;

import java.io.File;
import java.io.FileFilter;

/**
 * File filter.
 * @author Jose Antonio
 */
class PluginFilter implements FileFilter {

    public PluginFilter() {}

    @Override
    public boolean accept(File pathname) {
        return (pathname.getName().endsWith(".jar") || pathname.getName().endsWith(".lda"));
    }
}
