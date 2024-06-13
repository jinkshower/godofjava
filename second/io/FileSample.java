package second.io;

import java.io.File;

public class FileSample {

    public static void main(String[] args) {
        FileSample sample = new FileSample();
//        String pathName = "C:\\godofjava\\text";
        String pathName = "/Users/person/Documents/godofjava/text";
//        sample.checkPath(pathName);
//        sample.makeDir(pathName);
        sample.checkFileMethods(pathName);
    }

    private void checkPath(final String pathName) {
        File file = new File(pathName);
        System.out.println(pathName + "is exists? = " + file.exists());
    }

    public void makeDir(String pathName) {
        File file = new File(pathName);
        System.out.println("Make " + pathName + " result = " + file.mkdir());
    }

    public void checkFileMethods(String pathName) {
        File file = new File(pathName);
        System.out.println(pathName + " is directory ? = " + file.isDirectory());
        System.out.println(pathName + " is file? = " + file.isFile());
        System.out.println(pathName + " is hidden ? = " + file.isHidden());
    }
}
