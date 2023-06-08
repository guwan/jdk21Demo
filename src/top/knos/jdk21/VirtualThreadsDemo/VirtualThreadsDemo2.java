package top.knos.jdk21.VirtualThreadsDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class VirtualThreadsDemo2 {
    public static void main(String[] args) {

        // 创建一个支持Virtual Threads的线程池
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            try {
                // 提交并发任务
                Future<String> future1 = executor.submit(() -> {
                    System.out.println("Running task 1 on Virtual Thread: " + Thread.currentThread());
                    return "Task 1 completed.";
                });

                Future<String> future2 = executor.submit(() -> {
                    System.out.println("Running task 2 on Virtual Thread: " + Thread.currentThread());
                    return "Task 2 completed.";
                });

                // 获取任务结果
                String result1 = future1.get();
                String result2 = future2.get();

                System.out.println("Result 1: " + result1);
                System.out.println("Result 2: " + result2);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } finally {
                // 关闭线程池
                executor.shutdown();
            }
        }
    }
}
