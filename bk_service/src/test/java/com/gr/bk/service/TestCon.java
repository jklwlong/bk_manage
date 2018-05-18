package com.gr.bk.service;

import org.apache.commons.lang3.ArrayUtils;

public class TestCon {
    public static void main(String[] args) {
//        (ArrayUtils.contains(extField.split("\\|"), addProStr)
//                || ArrayUtils.contains(extField.split("\\|"), addCityStr))
        String extField = "330200|11";
        String addProStr = "33";
        String addCityStr = "3302";
        String a [] = extField.split("\\|");

        if(ArrayUtils.contains(a, addProStr)){
            System.out.println("-----------------1");
        }
        if(ArrayUtils.contains(a, addCityStr)){
            System.out.println("-----------------2");
        }
    }
}
