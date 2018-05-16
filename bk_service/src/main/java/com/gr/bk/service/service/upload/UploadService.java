package com.gr.bk.service.service.upload;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    void upload(MultipartFile file);
}
