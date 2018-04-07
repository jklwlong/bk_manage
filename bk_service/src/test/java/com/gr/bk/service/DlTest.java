package com.gr.bk.service;

import com.gr.bk.common.domain.UserDomain;

public class DlTest {
    private static final UserDomain u = new UserDomain();
    private DlTest() {}

    public static UserDomain u() {
        return u;
    }
}
