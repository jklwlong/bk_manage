package com.gr.bk.service.controller.mq;

import com.gr.bk.common.BaseController;
import com.gr.bk.common.MessageResp;
import com.gr.bk.service.common.constants.MqNameConstants;
import com.gr.bk.service.common.mq.MqSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/mq")
public class MqController extends BaseController {
    @Resource
    private MqSender send;

    @RequestMapping("/mq1")
    @ResponseBody
    public MessageResp mq1() {
        send.sendDirect(MqNameConstants.TEST_QUE_1,"mq1111111111111111");
        return success();
    }
}
