package com.gr.bk.common;

public class MessageResp {
    protected String code = "100200";

    protected String msg = "";

    protected Object data;

    public MessageResp() {
        super();
    }

    public MessageResp(Object data) {
        super();
        this.data = data;
    }

    public MessageResp(String code, String msg, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getRespCode() {
        return code;
    }

    public void setRespCode(String respCode) {
        this.code = respCode;
    }

    public String getRespMsg() {
        return msg;
    }

    public void setRespMsg(String respMsg) {
        this.msg = respMsg;
    }
    public void setMessage(RespCode respCode) {
        code = respCode.getCode();
        msg = respCode.getContent();
    }
}