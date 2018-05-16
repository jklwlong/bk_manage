package com.gr.bk.service;

import java.io.*;

public class IoTest {
    public static void main(String[] args) throws Exception {
        characters();
//        CopyTextDemo("E:\\1.txt", "E:\\2.txt");
//        bWriter();
//        copyMedia();
//        InOutDemo();
    }

    /**
     * 写入文件，文件不存在会自动创建
     *
     * @throws Exception
     */
    private static void Fwrite() throws Exception {
        FileWriter wr = new FileWriter("E:\\1.txt", true);
        wr.write("续写");
        wr.flush();
        wr.close();
    }

    private static void characters() {
        try {
            FileReader fr = new FileReader("E:\\1.txt");
            char[] buf = new char[6];
            int num = 0;
            while ((num = fr.read(buf)) != -1) {
                System.out.println(new String(buf, 0, num));
            }
            System.out.println('\n');
            fr.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private static void singleReader() {
        try {
            //创建一个文件读取流对象，和指定名称的文件关联。
            //要保证文件已经存在，否则会发生异常：FileNotFoundException
            FileReader fr = new FileReader("E:\\1.txt");
            //如何调用读取流对象的read方法？
            //read()方法，一次读取一个字符，并且自动往下读。如果到达末尾则返回-1
            int ch = 0;
            while ((ch = fr.read()) != -1) {
                System.out.println(ch);
            }
            System.out.println('\n');
            fr.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private static void CopyTextDemo(String source, String destination) throws Exception {
        FileWriter fw = new FileWriter(destination);
        FileReader fr = new FileReader(source);
        char[] buf = new char[1024];
        //将Denmo中的文件读取到buf数组中。
        int num = 0;
        while ((num = fr.read(buf)) != -1) {
            System.out.println(num);
            fw.write(new String(buf, 0, num));
        }
        fr.close();
        fw.close();
    }

    private static void bReader() throws Exception {
        //创建一个字符读取流流对象，和文件关联
        FileReader rw = new FileReader("E:\\1.txt");
        //只要将需要被提高效率的流作为参数传递给缓冲区的构造函数即可
        BufferedReader brw = new BufferedReader(rw);
        String str;
        do {
            str = brw.readLine();
            if(str == null) break;
            System.out.println(str);
        } while (str != null);

        brw.close();//关闭输入流对象
    }

    private static void bWriter() throws Exception {
        //创建一个字符写入流对象
        FileWriter fw = new FileWriter("buf.txt");
        //为了提高字符写入效率，加入了缓冲技术。
        //只要将需要被提高效率的流作为参数传递给缓冲区的构造函数即可
        BufferedWriter bfw = new BufferedWriter(fw);
        //用到缓冲区就必须要刷新
        for (int x = 1; x < 5; x++) {
            bfw.write("abc");
            bfw.newLine();                  //java提供了一个跨平台的换行符newLine();
            bfw.flush();
        }
        bfw.flush();
        bfw.close();                                                //关闭缓冲区，但是必须要先刷新
        //注意，关闭缓冲区就是在关闭缓冲中的流对象
        fw.close();
    }

    public static void copyMedia() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // buffered高效流，字节缓冲输入，字节缓冲输出
            bis = new BufferedInputStream(new FileInputStream("E:\\devil.jpg"));
            bos = new BufferedOutputStream(new FileOutputStream("E:\\cry.jpg"));
            byte[] copy = new byte[1024];
            int len = 0;
            while ((len = bis.read(copy)) != -1) {
                bos.write(copy, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("复制文件异常");
        } finally {
            try {
                bis.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void InOutDemo() {
        //键盘的最常见的写法
        BufferedReader bufr;
        BufferedWriter bufw;
        try {
            bufr = new BufferedReader(new InputStreamReader(System.in));
            bufw = new BufferedWriter(new FileWriter("buf.txt", true));
            String line;
            while ((line = bufr.readLine()) != null) {
                if ("over".equals(line)) break;
                bufw.write(line);
                bufw.newLine();
                bufw.flush();
            }
            if (bufw != null) {
                bufr.close();
                bufw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void InOutDemoTest() {
        //键盘的最常见的写法
        BufferedReader bufr;
        BufferedWriter bufw;
        try {
            bufr = new BufferedReader(new InputStreamReader(System.in));            //匿名类。InputSteamReader:读取字节并将其解码为字符
            bufw = new BufferedWriter(new OutputStreamWriter(System.out));      //OutputStreamWriter:要写入流中的字符编码成字节
            String line;
            while ((line = bufr.readLine()) != null) {
                if ("over".equals(line)) break;
                bufw.write(line);                     //打印
                bufw.newLine();                                     //为了兼容，使用newLine()写入换行符
                bufw.flush();                                       //必须要刷新。不然不会显示
            }
            if (bufw != null) {
                bufr.close();
                bufw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

