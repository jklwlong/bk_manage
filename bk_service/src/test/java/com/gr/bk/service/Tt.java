package com.gr.bk.service;

import com.gr.bk.common.domain.UserDomain;
import com.gr.bk.common.utils.StringTools;
import groovy.transform.Synchronized;
import org.apache.ibatis.cache.decorators.SynchronizedCache;
import sun.security.krb5.internal.Ticket;

import java.util.ArrayList;
import java.util.List;

public class Tt {

    public static void main(String[] args) throws Exception {
        System.out.println(sub("11"));
    }

    private synchronized static String sub(String a) throws InterruptedException {
        Thread th = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("22222222222"+ a);
        });
        th.start();
//        th.wait();
//        th.notify();
//        th.notifyAll();
        return StringTools.getUuid();
    }

}
