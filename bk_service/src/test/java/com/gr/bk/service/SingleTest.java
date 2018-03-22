package com.gr.bk.service;


public class SingleTest {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new B().start();
        }


    }
}

class B extends Thread {

    @Override
    public void run() {

    }
}