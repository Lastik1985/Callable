package org.example;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        int count = 1;
        while (count <= 4) {
            Thread.sleep(100);
            System.out.println("Я " + Thread.currentThread().getName() + ". Всем привет!" + "Выхожу на связь в " + count + " раз");
            count++;
        }
        return count - 1;
    }

}