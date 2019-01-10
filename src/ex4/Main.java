package ex4;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File icon1 = new File("icon1");
        File icon2 = new File("icon2");
        MultyCopyFileThread.copyFiles(icon1, icon2, 4);
    }
}
