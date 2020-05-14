
package newrestfull;

/**
 *
 */

import java.io.File;
import java.io.FilenameFilter;

public class FileSelect implements FilenameFilter {

    private String fragment;
    private boolean regexp;

    public FileSelect(String fragment) {
        this.fragment = fragment;
        this.regexp = false;
    }

    public FileSelect(String fragment, boolean regexp) {
        this.fragment = fragment;
        this.regexp = regexp;
    }

    @Override
    public boolean accept(File dir, String name) {
        if (regexp) {
            return name.matches(fragment);
        } else return name.contains(fragment);
        
    }
}