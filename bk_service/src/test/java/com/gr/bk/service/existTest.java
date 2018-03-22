package com.gr.bk.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExistTest {

    public static void main(String[] args) {
        String s = "asdasffdllaffsddfeeoiadf";
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.containsKey(c) ? (map.get(c) + 1) : 1);
        }
        System.out.println(map);
    }


    private static void T1() {
        String s = "asdasffdllaffsddfeeoiadf";
        char[] chars = s.toCharArray();
        List<Character> list = new ArrayList<>();
        List<Character> sameList = new ArrayList<>();
        for (char c : chars) {
            if (!list.contains(c)) {
                list.add(c);
            } else {
                if (!sameList.contains(c)) {
                    sameList.add(c);
                }

            }
        }
        System.out.println(sameList);
        System.out.println(list);
    }
}
