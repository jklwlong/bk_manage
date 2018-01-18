package com.gr.bk.service.controller.user;

import com.gr.bk.common.BaseController;
import com.gr.bk.common.CommonRespConst;
import com.gr.bk.common.MessageResp;
import com.gr.bk.common.domain.UserDomain;
import com.gr.bk.service.service.user.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController extends BaseController{
private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;


    /**
     * 测试
     * @return
     */
    @RequestMapping("/test")
    @RequiresPermissions("add:edit")
    @ResponseBody
    public MessageResp test() {
        logger.info("info------------------------------");
        List<UserDomain> userlist = userService.queryAll();
        return success(userlist);
    }

    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        logger.info("进入登录页面");
        return "/user/login";
    }

    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/loginUser")
    @ResponseBody
    public MessageResp loginUser(String username, String password) {
        logger.info("用户登录,username={},password={}", username, password);
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.login(token);
        } catch (UnknownAccountException uae) {
            return buildResp(CommonRespConst.UNKNOWNACCOUNT);
        } catch (IncorrectCredentialsException ice) {
            return buildResp(CommonRespConst.INCORRECTCREDENTIALS);
        } catch (LockedAccountException lae) {
            return buildResp(CommonRespConst.LOCKEDACCOUNT);
        } catch (ExcessiveAttemptsException eae) {
            return buildResp(CommonRespConst.EXCESSIVEATTEMPTS);
        } catch (AuthenticationException ae) {
            return buildResp(CommonRespConst.AUTHENTICATION);
        }
        return success();
    }

    /**
     * 登出方法
     * @return
     */
    @RequestMapping("/logout")
    public String logOut() {
        logger.info("用户登出");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
//        session.removeAttribute("user");
        return "/user/login";
    }

}
