package com.gr.bk.service.controller.de;


import com.gr.bk.common.BaseController;
import com.gr.bk.common.MessageResp;
import com.gr.bk.common.domain.RcAreaAddr;
import com.gr.bk.common.domain.RoleCopyDomain;
import com.gr.bk.common.utils.StringTools;
import com.gr.bk.service.service.de.RcAreaAddrService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 区域地址 前端控制器
 * </p>
 *
 * @author liuwl
 * @since 2018-03-19
 */
@Controller
@RequestMapping("/rcAreaAddr")
public class RcAreaAddrController extends BaseController{

    @Resource
    private RcAreaAddrService rcAreaAddrService;

    @RequestMapping("/insert")
    @ResponseBody
    public MessageResp insert() {
        List<RcAreaAddr> rclist = new ArrayList<>();
        String[] a = new String[]{"瞻岐",
                "章水",
                "墙头",
                "涂茨",
                "一市",
                "岔路",
                "桑洲",
                "深甽",
                "牟山",
                "丈亭",
                "三七市",
                "河姆渡",
                "大隐",
                "梁弄",
                "大岚",
                "四明山",
                "裘村",
                "大堰",
                "松岙"};
        for(String s: a){
            RcAreaAddr ra = new RcAreaAddr();
            ra.setDelFlag(0);
            ra.setCreateTime(new Date());
            ra.setUpdateTime(new Date());
            ra.setRcAreaAddrUuid(StringTools.getUuid());
            ra.setRcAreaCodeUuid("b9dc0f0cabe4472386df7dac1db042b5");
            ra.setAreaAddr(s);
            rclist.add(ra);
        }
        rcAreaAddrService.insertBatch(rclist);
        return success();
    }


    @RequestMapping("/write")
    @ResponseBody
    public MessageResp write() {
        rcAreaAddrService.writeCode();
        return success();
    }

}

