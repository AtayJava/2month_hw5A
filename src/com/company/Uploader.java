package com.company;

public class Uploader extends Thread {
    private int fileSize;
    private int speed;
    private Downloaders downloaders;

    public Uploader(String name, int fileSize, int speed) {
        super(name);
        this.fileSize = fileSize;
        this.speed = speed;
    }

    public int getFileSize() {
        return fileSize;
    }

    public int getSpeed() {
        return speed;
    }

    public void run () {
        try {
            System.out.println("Загрузка началась");
            sleep(3000);
            System.out.println("⌛");
            sleep(fileSize/speed * 2);
            System.out.println("⌛⌛");
            sleep(fileSize/speed * 2);
            System.out.println("⌛⌛⌛");
            sleep(fileSize/speed * 5);
            System.out.println("⌛⌛⌛⌛");
            sleep(3000);
            System.out.println("Файл загружен на сервер");



        } catch (Exception e) {
            System.out.println("Ошибка");
        }
    }

}
