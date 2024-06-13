package second.thread.object;

public class StateThread extends Thread {

    private Object monitor;

    public StateThread(Object monitor) {
        this.monitor = monitor;
    }

    public void run() {
        try {
            for (int i = 0; i < 10000; i++) {
                String a = "A";
            }

            synchronized (monitor) {
                monitor.wait();// 모니터 객체의 wait 실행
            }

            System.out.println(getName() + "is notified");
            Thread.sleep(1000);//1초 대기 후 종료
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
