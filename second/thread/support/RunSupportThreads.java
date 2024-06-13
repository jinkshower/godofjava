package second.thread.support;

public class RunSupportThreads {

    public static void main(String[] args) {
        RunSupportThreads sample = new RunSupportThreads();
//        sample.checkThreadState1();
        sample.checkJoin();
    }

    private void checkThreadState1() {
        SleepThread thread = new SleepThread(2000);

        try {
            System.out.println("thread state = " + thread.getState());//new
            thread.start();
            System.out.println("thread state(after start) = " + thread.getState()); //running

            Thread.sleep(1000);
            System.out.println("thread state(after 1 sec) = " + thread.getState());//timed_wait

            thread.join();
            thread.interrupt();
            System.out.println("thread state(after join)" + thread.getState()); //terminated
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void checkJoin() {
        SleepThread thread = new SleepThread(2000);

        try {
            thread.start();
            thread.join(500);
            thread.interrupt();
            System.out.println("thread state(after join) = " + thread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("thread state(after join) = " + Thread.currentThread());
    }
}
