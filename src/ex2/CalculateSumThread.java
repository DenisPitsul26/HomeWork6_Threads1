package ex2;

public class CalculateSumThread implements Runnable{
    private int[] array;
    private int firstElement;
    private int lastElement;
    private long sum = 0;

    public CalculateSumThread(int[] array, int firstElement, int lastElement) {
        this.array = array;
        this.firstElement = firstElement;
        this.lastElement = lastElement;
    }

    public long getSum() {
        return sum;
    }

    public long calculateSum(int[] array, int firstElement, int lastElement){
        long sum = 0;
        for (int i = firstElement; i < lastElement; i++) {
            sum += array[i];
        }
        return sum;
    }

    @Override
    public void run() {
        sum = calculateSum(array, firstElement, lastElement);
    }
}
