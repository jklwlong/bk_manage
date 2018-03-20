package com.rctest;

import java.util.List;

public class BankCardDto extends ModelCodeDto {
    /**
     * 银行卡归属地
     */
    private List<String> bankCardArea;

    public List<String> getBankCardArea() {
        return bankCardArea;
    }

    public void setBankCardArea(List<String> bankCardArea) {
        this.bankCardArea = bankCardArea;
    }
}
