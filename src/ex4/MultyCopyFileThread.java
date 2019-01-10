package ex4;

import java.io.File;

public class MultyCopyFileThread {

    public static void copyFiles(File from, File to, int couutOfTreads) {
        int filesCount = 0;
        if (from.list() != null) {
            filesCount = from.list().length;
        }
        if (filesCount > 0) {
            Thread[] threads = new Thread[couutOfTreads];

            int sizeOfThreads = filesCount / couutOfTreads;
            for (int i = 0; i < couutOfTreads; i++) {
                int firstIndex = i * sizeOfThreads;
                int lastIndex = (i + 1) * sizeOfThreads;
                if ((filesCount - lastIndex) < sizeOfThreads) {
                    lastIndex = filesCount;
                }
                threads[i] = new Thread(new CopyFileThread(from, to, firstIndex, lastIndex));
                threads[i].start();
            }
        } else {
            System.out.println("This folder is empty.");
        }
    }
}
