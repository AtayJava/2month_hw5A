package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3, true);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        Uploader uploader = new Uploader("GOOGLE ", 500, 20);


        for (int i = 1; i <=10 ; i++) {
            new Downloaders("Пользователь " +i, semaphore, countDownLatch, 100, uploader).start();

        }



    }
}
