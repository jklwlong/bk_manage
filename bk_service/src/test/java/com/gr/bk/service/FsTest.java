package com.gr.bk.service;

import com.gr.bk.common.domain.UserDomain;
import com.gr.bk.common.utils.StringTools;

import java.lang.reflect.Field;
import java.util.Date;

public class FsTest {
    public static void main(String[] args) throws Exception {
        UserDomain user = new UserDomain();
        user.setPassword("pw");
        user.setCreateTime(new Date());
        user.setCreateUserUuid("2222");
        user.setDelFlag(0);
        user.setId(1);
        user.setMobile("222");
        user.setUsername("name");
        System.out.println(StringTools.getUuid());
//        System.out.println(MD5.encode("123654",MD5.LENGTH_32));
    }
}
