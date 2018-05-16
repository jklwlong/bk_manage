package com.gr.bk.service;

import com.alibaba.fastjson.JSON;
import com.gr.bk.common.domain.UserDomain;
import com.gr.bk.common.utils.StringTools;
import com.gr.bk.service.config.AuthRealm;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.concurrent.ConcurrentUtils;

import javax.annotation.Resource;
import javax.swing.text.Segment;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Tt {
    public static void main(String[] args) throws Exception {
//        StringBuffer sb = new StringBuffer("asdfffss");
//        for(int i=0;i<sb.length();i++){
//            char ch = sb.charAt(i);
//            System.out.println(ch);
//        }
//        double x = 8.05;
//        System.out.println((long)x);
//         ConcurrentMap<String,String> map = new ConcurrentHashMap(88);
//         System.out.println("-111".replaceAll("-1", "222"));
//        UserDomain u = new UserDomain();
//        isnull(u);
//        for(int i = 0;i<21;i++){
//            System.out.println(StringTools.getUuid());
//        }
        List<String> s = new ArrayList<>();
        s.add("1");
        s.add("1");s.add("1");s.add("1");s.add("1");s.add("1");
        System.out.println(s.toString());

    }

    public static boolean isnull(Object obj) throws Exception {
        Field fields[] = obj.getClass().getDeclaredFields();//获得对象所有属性
        for (Field fd : fields) {
            fd.setAccessible(true);//修改访问权限
            System.out.println(fd.get(obj));
        }
        return true;
    }

}
