package ex2;

import ex1.GenerateArray;

public class Main {
    public static void main(String[] args) {

        int array[] = new int[200000000];
        GenerateArray.generate(array);

        long timeStart = System.currentTimeMillis();
        long sum = 0;
        for (int anArray : array) {
            sum += anArray;
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("MilSecond calculate sum without threads = "+ (timeEnd - timeStart));
        System.out.println("Sum = "+ sum);

        CalculateSumThread calcOne = new CalculateSumThread(array, 0, 50000000);
        CalculateSumThread calcTwo = new CalculateSumThread(array, 50000000, 100000000);
        CalculateSumThread calcThree = new CalculateSumThread(array, 100000000, 150000000);
        CalculateSumThread calcFour = new CalculateSumThread(array, 150000000, 200000000);

        Thread threadOne = new Thread(calcOne);
        Thread threadTwo = new Thread(calcTwo);
        Thread threadThree = new Thread(calcThree);
        Thread threadFour = new Thread(calcFour);

        timeStart = System.currentTimeMillis();
        threadOne.start();
        threadTwo.start();
        threadThree.start();
        threadFour.start();

        int nbRunning = 0;
        for (Thread t : Thread.getAllStackTraces().keySet()) {
            if (t.getState()==Thread.State.RUNNABLE)
                nbRunning++;
        }
        System.out.println(nbRunning);
        try {
            threadOne.join();
            threadTwo.join();
            threadThree.join();
            threadFour.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        timeEnd = System.currentTimeMillis();
        System.out.println("MilSecond calculate sum with four threads = "+ (timeEnd - timeStart));
        System.out.println("Sum = "+ (calcOne.getSum() + calcTwo.getSum() + calcThree.getSum() + calcFour.getSum()));

    }
}
