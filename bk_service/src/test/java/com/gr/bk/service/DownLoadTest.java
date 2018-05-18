package com.gr.bk.service;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;

public class DownLoadTest {
    public static void main(String[] args) throws Exception {
//        String addr = "https://dldir1.qq.com/qqfile/qq/QQ9.0.3/23729/QQ9.0.3.exe";
//        load(addr);
        System.out.println(getMD5Three("E:\\QQ9.0.3.exe"));
    }


    public static void load(String addr) throws Exception {
        long start = 0;
        long end = getRemoteFileSize(addr);
        URL url = new URL(addr);
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("User-Agent", "NetFox");
            conn.setRequestProperty("RANGE", "bytes=" + start + "-" + end); //header中增加range属性
            conn.connect();
            System.out.println(conn.getResponseCode());
            System.out.println(conn.getContentLength());
            System.out.println(conn.getContentType());
            InputStream ins = (InputStream) conn.getContent();
            String fileName = addr.substring(addr.lastIndexOf("/")+1);
            fileName = new String(fileName.getBytes("ISO8859-1"), "UTF-8");
            System.out.println(fileName);
            RandomAccessFile raFile = new RandomAccessFile("E:\\" + fileName, "rw");
            raFile.seek(start);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = ins.read(buffer)) != -1) {
                raFile.write(buffer, 0, len);
            }
            raFile.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long getRemoteFileSize(String url) {
        long size = 0;
        try {
            HttpURLConnection conn = (HttpURLConnection) (new URL(url))
                    .openConnection();
            size = conn.getContentLength();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }

    public static String getMD5Two(String path){
        StringBuffer sb = new StringBuffer("");
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(FileUtils.readFileToByteArray(new File(path)));
            byte b[] = md.digest();
            int d;
            for (int i = 0; i < b.length; i++) {
                d = b[i];
                if (d < 0) {
                    d = b[i] & 0xff;
                    // 与上一行效果等同
                    // i += 256;
                }
                if (d < 16)
                    sb.append("0");
                sb.append(Integer.toHexString(d));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String getMD5Three(String path) {
        BigInteger bi = null;
        try {
            byte[] buffer = new byte[8192];
            int len = 0;
            MessageDigest md = MessageDigest.getInstance("MD5");
            File f = new File(path);
            FileInputStream fis = new FileInputStream(f);
            while ((len = fis.read(buffer)) != -1) {
                md.update(buffer, 0, len);
            }
            fis.close();
            byte[] b = md.digest();
            bi = new BigInteger(1, b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bi.toString(16);
    }
}
