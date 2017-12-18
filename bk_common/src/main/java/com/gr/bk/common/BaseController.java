package com.gr.bk.common;

public class BaseController {
    protected static MessageResp buildResp(Object data, RespCode respEnum) {
        MessageResp resp = new MessageResp();
        resp.setMessage(respEnum);
        resp.setData(data);
        return resp;
    }

    protected static MessageResp buildResp(RespCode respEnum) {
        MessageResp resp = new MessageResp();
        resp.setMessage(respEnum);
        resp.setData(null);
        return resp;
    }

    protected static MessageResp success() {
        return buildResp(null, CommonRespConst.SUCCESS);
    }

    protected static MessageResp success(Object data) {
        return buildResp(data, CommonRespConst.SUCCESS);
    }

    protected static MessageResp fail() {
        return buildResp(null, CommonRespConst.FAIL);
    }
}
