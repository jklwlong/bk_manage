package com.gr.bk.service.controller.rolecopy;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.gr.bk.common.BaseController;
import com.gr.bk.common.MessageResp;
import com.gr.bk.common.domain.RoleCopyDomain;
import com.gr.bk.common.utils.StringTools;
import com.gr.bk.service.service.rolecopy.RoleCopyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/rolecopy")
@Controller
public class RoleCopyController extends BaseController {

    @Resource
    private RoleCopyService roleCopyService;

    @RequestMapping("/test")
    @ResponseBody
    public MessageResp test() {
        return success(roleCopyService.selectPage(new Page<>(1, 10)));
    }

    @RequestMapping("/insert")
    @ResponseBody
    public MessageResp insert() {
        RoleCopyDomain domain = new RoleCopyDomain();
        domain.setRoleUuid(StringTools.getUuid());
        domain.setRoleCode("hhhaaa");
        domain.setRoleName("hahahah");
        roleCopyService.insert(domain);
        return success();
    }

    @RequestMapping("/update")
    @ResponseBody
    public MessageResp update() {
        RoleCopyDomain domain = new RoleCopyDomain();
        domain.setRoleUuid(StringTools.getUuid());
        domain.setRoleCode("update");
        domain.setRoleName("hahahah");
        roleCopyService.update(domain, new EntityWrapper<RoleCopyDomain>().eq("id", 3));
        return success();
    }

    @RequestMapping("/del")
    @ResponseBody
    public MessageResp del() {
        roleCopyService.deleteById(3);
        return success();
    }
}
