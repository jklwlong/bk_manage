package com.gr.bk.common;

public class CommonRespConst {
    public final static RespCode SUCCESS = new RespCode("100200","成功"),
            FAIL =  new RespCode("101400", "服务异常"),
            ARGS_ERROR =  new RespCode("101401", "参数错误"),
            UNKNOWNACCOUNT = new RespCode("101402", "账号不存在"),
            INCORRECTCREDENTIALS = new RespCode("101403", "密码不正确"),
            LOCKEDACCOUNT = new RespCode("101404", "账户已锁定"),
            EXCESSIVEATTEMPTS = new RespCode("101405", "密码错误次数过多"),
            AUTHENTICATION = new RespCode("101406", "用户名或密码不正确")
                    ;

}
