package com.company;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloaders extends Thread {
    private Semaphore semaphore;
    private CountDownLatch countDownLatch;
    private int downloaderSpeed;
    private Uploader uploader;

    public Downloaders(String name, Semaphore semaphore,CountDownLatch countDownLatch,
                       int downloaderSpeed, Uploader uploader) {
        super(name);
        this.semaphore = semaphore;
        this.countDownLatch = countDownLatch;
        this.downloaderSpeed = downloaderSpeed;
        this.uploader = uploader;
    }

    public int getDownloaderSpeed() {
        return downloaderSpeed;
    }

    public Uploader getUploader() {
        return uploader;
    }

    public void run () {
        try {
            semaphore.acquire();
            System.out.println(this.getName() + " начал скачивать файл " + uploader.getName());
            sleep(3000);
            System.out.println(this.getName() +" скачал файл " + uploader.getFileSize() + " мб" );
            semaphore.release();
            System.out.println(this.getName() + " завершил установку файла ");

        } catch (Exception e) {
            System.out.println("Ошибка");
        }


    }
}
