package com.gr.bk.service;

import java.util.ArrayList;
import java.util.List;

public class existTest {
    public static void main(String[] args) {
        String s = "asdasffdllaffsddfeeoiadf";
        char[] chars = s.toCharArray();
        List list = new ArrayList();
        List sameList = new ArrayList();
        for(char c:chars){
            if(!list.contains(c)){
                list.add(c);
            }else {
                if(!sameList.contains(c)){
                    sameList.add(c);
                }

            }
        }
        System.out.println(sameList);
        System.out.println(list);
    }
}
