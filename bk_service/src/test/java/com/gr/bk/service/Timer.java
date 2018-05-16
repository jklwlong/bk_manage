package com.gr.bk.service;

import org.springframework.scheduling.annotation.Scheduled;

public class Timer {
    @Scheduled(cron = "0 */5 * * * ?")
    public static void main(String[] args) {
        System.out.println("----");
    }
}
