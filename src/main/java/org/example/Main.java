package org.example;

import java.util.Arrays;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("Создаю потоки......");

        int streamNumber = 5;
        Callable<Integer>[] myCallable = new MyCallable[streamNumber];
        for (int i = 0; i < streamNumber; i++) {
            myCallable[i] = new MyCallable();
        }

        int threadNumber = 4;
        final ExecutorService threadPool = Executors.newFixedThreadPool(threadNumber);
        for (int i = 0; i < threadNumber; i++) {
            final Future<Integer> task = threadPool.submit(myCallable[i]);
            final Integer resultOfTask = task.get();
            System.out.println("Количество сообщений = " + resultOfTask);
        }

        System.out.println("\nПолучение результата от одной из задач");
        int result = threadPool.invokeAny(Arrays.stream(myCallable).toList());
        Thread.sleep(100);
        System.out.println("Количество сообщений самого быстрого потока = " + result);

        threadPool.shutdown();


    }
}
