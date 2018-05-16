package com.gr.bk.service.service.upload.impl;

import com.gr.bk.service.controller.user.UserController;
import com.gr.bk.service.service.upload.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class UploadServiceImpl implements UploadService {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Override
    public void upload(MultipartFile file) {
        upCopy(file);
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
