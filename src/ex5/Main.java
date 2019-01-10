package ex5;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File folder = new File(".");
        Thread thread = new Thread(new FileWatcher(folder));
        thread.start();

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
