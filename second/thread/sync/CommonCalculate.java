package second.thread.sync;

public class CommonCalculate {

    private int amount;
    final Object lock = new Object();

    public CommonCalculate() {
        amount = 0;
    }

    public synchronized void plus(int value) {
        System.out.println("plus() method is called." + Thread.currentThread().getName());

        synchronized (lock) {
            amount += value;
        }

        System.out.println("got out of plus synchronized block.");
    }

    public synchronized void minus(int value) {
        System.out.println("minus() method is called." + Thread.currentThread().getName());

        synchronized (lock) {
            amount -= value;
        }

        System.out.println("got out of minus synchronized block.");
    }

    public int getAmount() {
        return amount;
    }
}
