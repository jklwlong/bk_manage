package com.gr.bk.service;


public class SingleTest {
    public static void main(String[] args) throws InterruptedException {
        B thread = new B();
        thread.start();
        Thread.sleep(1000);
        thread.setRunning(false);

    }
}

class B extends Thread {
     private volatile boolean isRunning = true;

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
        System.out.println("进入到run方法中了");
        while (isRunning == true) {
        }
        System.out.println("线程执行完成了");
    }
}