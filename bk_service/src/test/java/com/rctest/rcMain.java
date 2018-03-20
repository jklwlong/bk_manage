package com.rctest;

import java.io.FileReader;

public class rcMain {
    public static void main(String[] args) throws Exception{
        String a = "";
        FileReader fr = new FileReader("D:\\json.txt");
        char[] buf = new char[1024];
        int num;
        while ((num = fr.read(buf)) != -1) {
            System.out.println(num);
            a += new String(buf, 0, num);
        }
        fr.close();
        System.out.println(a);
    }
}
