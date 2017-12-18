package com.gr.bk.common.domain;

public class TestDto extends RoleDomain{
    private String tt;

    public String getTt() {
        return tt;
    }

    public void setTt(String tt) {
        this.tt = tt;
    }

    @Override
    public String toString() {
        return "TestDto{" +
                "tt='" + tt + '\'' +
                '}';
    }
}
