package second.io;

import java.io.File;
import java.io.FileFilter;

public class JPGFileFilter implements FileFilter {

    @Override
    public boolean accept(final File file) {
        if (file.isFile()) {
            String fileName = file.getName();
            if (fileName.endsWith(".jpg")) {
                return true;
            }
        }
        return false;
    }
}
