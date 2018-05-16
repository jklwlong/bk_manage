package com.gr.bk.service.controller.upload;


import com.gr.bk.common.BaseController;
import com.gr.bk.common.MessageResp;
import com.gr.bk.service.controller.user.UserController;
import com.gr.bk.service.service.upload.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/upload")
public class UploadController extends BaseController{

    @Resource
    private UploadService uploadService;

    @RequestMapping("/file")
    @ResponseBody
    public MessageResp file(MultipartFile file) {
        if (file.isEmpty()) {
            return fail();
        }
        uploadService.upload(file);
        return success();
    }
}
