package second.io;

import java.io.File;

public class FileFilterSample {

    public static void main(String[] args) {
        FileFilterSample sample = new FileFilterSample();
        String pathName = "/Users/person/Documents/godofjava/text";

        sample.checkPath(pathName);
    }

    private void checkPath(final String pathName) {
        File file;
        try {
            file = new File(pathName);
//            File[] mainFileList = file.listFiles();
             File[] mainFileList = file.listFiles(new JPGFilenameFilter());

            for (File tempfile : mainFileList) {
                System.out.println(tempfile.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
