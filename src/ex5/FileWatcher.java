package ex5;

import java.io.File;
import java.text.SimpleDateFormat;

public class FileWatcher implements Runnable{
    private File mainFolder;

    public FileWatcher(File mainFolder) {
        this.mainFolder = mainFolder;
    }

    public File getMainFolder() {
        return mainFolder;
    }

    public String getFolderInfo(){
        if (mainFolder == null)
            return "None";
        StringBuilder sb = new StringBuilder();

        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yy  hh:mm:ss");
        sb.append(sdf.format(System.currentTimeMillis())).append(System.lineSeparator());
        File[] files = mainFolder.listFiles();
        for (File file: files) {
            sb.append(file.getName()+"\t"+file.length()).append(System.lineSeparator());
        }

        return sb.toString();
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();

        File[] fileInFolder = mainFolder.listFiles();
        int countOfFilesOneSecondLast = fileInFolder.length;
        int change;
        while (!thread.isInterrupted()){
            System.out.println(getFolderInfo());

            fileInFolder = mainFolder.listFiles();
            int countNowOfFiles = fileInFolder.length;
            change = countOfFilesOneSecondLast - countNowOfFiles;
            if (change > 0)
                System.out.println("Deleted " + change + " files from the main folder.");
            if (change < 0)
                System.out.println("Added " + Math.abs(change) + " files to the main folder.");
            if (change == 0)
                System.out.println("No change in the main folder.");
            countOfFilesOneSecondLast = countNowOfFiles;

            System.out.println();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("File watcher is stop!!");
    }
}







