package ex1;

import java.math.BigInteger;

public class FactorialThread implements Runnable {
    private int number;

    public FactorialThread(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private BigInteger calculateFactorial(int number){
        BigInteger fact = new BigInteger("1");
        for (int i = 2; i <= number; i+=1) {
            fact = fact.multiply(new BigInteger(""+ i));
        }
        return fact;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+" "+ number +"! = "+ calculateFactorial(number));
    }
}
