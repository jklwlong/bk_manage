package com.gr.bk.common;

public class RespCode {
    private String mCode;
    private String mContent;

    public RespCode(String code, String msg) {
        this.mCode = code;
        this.mContent = msg;
    }

    public String getCode() {
        return mCode;
    }

    public String getContent() {
        return mContent;
    }
}