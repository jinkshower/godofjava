package second.io;

import java.io.File;
import java.io.IOException;

public class FileManageClass {

    public static void main(String[] args) {
        FileManageClass sample = new FileManageClass();
        String pathName = "/Users/person/Documents/godofjava/text";
        String fileName = "test.txt";

        sample.checkFile(pathName, fileName);
    }

    private void checkFile(final String pathName, final String fileName) {
        File file = new File(pathName, fileName);

        try {
            System.out.println("Create result = " + file.createNewFile());
            getFileInfo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getFileInfo(File file) throws IOException {
        System.out.println("Absoulte Path = " + file.getAbsolutePath());
        System.out.println("Absolute File = " + file.getAbsoluteFile());
        System.out.println("Canonical Path = " + file.getCanonicalPath());
        System.out.println("Canonical File = " + file.getCanonicalFile());

        System.out.println("Name = " + file.getName());
        System.out.println("Path = " + file.getPath());
    }
}
