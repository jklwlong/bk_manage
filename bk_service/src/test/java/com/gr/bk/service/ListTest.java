package com.gr.bk.service;

import com.gr.bk.common.domain.UserDomain;
import com.gr.bk.common.utils.StringTools;
import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        System.out.println(StringTools.getUuid());
        System.out.println(StringTools.getUuid());
        System.out.println(StringTools.getUuid());
        System.out.println(StringTools.getUuid());
        System.out.println(StringTools.getUuid());
        System.out.println(StringTools.getUuid());
    }

    private static void T1() {
        List<String> list = new ArrayList<>();
        list.add("2");
        list.add("1");
        list.add("5");
        list.add("3");
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);
    }

    private static void T2() {
        List<UserDomain> users = new ArrayList<>();
        UserDomain user = new UserDomain();
        for(int i=0;i<5;i++){
            user.setId(i);
            users.add(user);

        }

        System.out.println(users);
    }

    private static void T3() {
        List<String> list = new ArrayList<>();
        list.add("2");
        list.add("1");
        list.add("5");
        list.add("3");
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }

}
