package com.gr.bk.service;

public class DlTest {
    private static DlTest u = new DlTest();

    private DlTest() {
    }

    public static DlTest u() {
        return u;
    }
}
