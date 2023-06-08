package top.knos.jdk21.VirtualThreadsDemo;

public class VirtualThreadsDemo {
    public static void main(String[] args) {
        // 创建并执行Virtual Thread
        Thread virtualThread = Thread.ofVirtual().start(() -> {
            System.out.println("Running Virtual Thread: " + Thread.currentThread());
        });

        // 等待线程执行完成
        try {
            virtualThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
