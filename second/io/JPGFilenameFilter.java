package second.io;

import java.io.File;
import java.io.FilenameFilter;

public class JPGFilenameFilter implements FilenameFilter {

    @Override
    public boolean accept(final File file, String fileName) {
        if (fileName.endsWith(".jpg")) {
            return true;
        }
        return false;
    }
}
