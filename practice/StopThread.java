package practice;

import java.util.concurrent.TimeUnit;

public class StopThread {
    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                System.out.println("waiting");
                try {
                    Thread.sleep(300); // 0.3초마다 "waiting" 출력
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    // 예외 처리 로직 추가 가능
                }
                i++;
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
