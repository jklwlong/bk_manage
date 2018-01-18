package com.gr.bk.service;

import com.gr.bk.common.domain.UserDomain;

import java.lang.reflect.Array;
import java.util.*;

public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("2");
        list.add("1");
        list.add("5");
        list.add("3");
//        System.out.println(list);
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);



    }
}
