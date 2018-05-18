package com.gr.bk.service.service.upload.impl;

import com.gr.bk.service.controller.user.UserController;
import com.gr.bk.service.service.upload.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class UploadServiceImpl implements UploadService {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Override
    public void upload(MultipartFile file) {
        upCopy(file);
    }

    @Override
    public void down(long nPos, String savePathAndFile) {
        String url = "https://dldir1.qq.com/qqfile/qq/QQ9.0.3/23729/QQ9.0.3.exe";
        String savePath = "e://";
        String fileName = url.substring(url.lastIndexOf("/"));
        String fileNam=fileName;
//        HttpURLConnection conn = null;
//        try {
//            conn = (HttpURLConnection) (new URL(url)).openConnection();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        File file = new File(savePath + fileName);
        // 获得远程文件大小
        long remoteFileSize = getRemoteFileSize(url);
        System.out.println("远程文件大小="+remoteFileSize);
        int i = 0;
        if (file.exists()) {
            // 先看看是否是完整的，完整，换名字，跳出循环，不完整，继续下载
            long localFileSize = file.length();
            System.out.println("已有文件大小为:"+localFileSize);
            if (localFileSize < remoteFileSize) {
                System.out.println("文件续传");
                download(url, localFileSize, savePath + fileName);
            }else{
                System.out.println("文件存在，重新下载");
                do{
                    i++;
                    fileName = fileNam.substring(0, fileNam.indexOf(".")) + "(" + i + ")" + fileNam.substring(fileNam.indexOf("."));
                    file = new File(savePath + fileName);
                }while(file.exists());
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                download(url, 0, savePath + fileName);
            }
            // 下面表示文件存在，改名字

        } else {
            try {
                file.createNewFile();
                System.out.println("下载中");
                download(url, 0, savePath + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
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

    public static void download(String URL, long nPos, String savePathAndFile) {
        try {
            URL url = new URL(URL);
            HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();

            // 设置User-Agent
            httpConnection.setRequestProperty("User-Agent", "NetFox");
            // 设置断点续传的开始位置
            httpConnection.setRequestProperty("RANGE", "bytes=" + nPos + "-" + 74911608);
            // 获得输入流
            InputStream input = httpConnection.getInputStream();
            RandomAccessFile oSavedFile = new RandomAccessFile(savePathAndFile,
                    "rw");
            // 定位文件指针到nPos位置
            oSavedFile.seek(nPos);
            byte[] b = new byte[1024];
            int nRead;
            // 从输入流中读入字节流，然后写到文件中
            while ((nRead = input.read(b, 0, 1024)) > 0) {
                (oSavedFile).write(b, 0, nRead);
            }
            httpConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * 在服务器创建新文件
     * 并将文件内容拷贝到新文件
     *
     * @param file
     */
    private void upCopy(MultipartFile file) {
        File dest = new File("E:/upload/" + file.getOriginalFilename());
        // 将文件内容复制到新文件中
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
