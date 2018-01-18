package com.gr.bk.service;

import java.util.ArrayList;
import java.util.List;

public class ExistTest {

    public static void main(String[] args) {
        String s = "asdasffdllaffsddfeeoiadf";
        char[] chars = s.toCharArray();
        List<Character> list = new ArrayList<>();
        List<Character> sameList = new ArrayList<>();
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
