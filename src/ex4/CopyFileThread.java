package ex4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyFileThread implements Runnable{
    private File from;
    private File to;
    private int firstIndex;
    private int lastIndex;

    CopyFileThread(File from, File to, int firstIndex, int lastIndex) {
        this.from = from;
        this.to = to;
        this.firstIndex = firstIndex;
        this.lastIndex = lastIndex;
    }

    @Override
    public void run() {
        File[] fileArr = from.listFiles();

        for (int i = firstIndex; i < lastIndex; i++) {
            try {
                Files.copy(fileArr[i].toPath(), Paths.get(to.getAbsolutePath() + File.separator + fileArr[i].getName()), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
