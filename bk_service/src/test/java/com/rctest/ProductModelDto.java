package com.rctest;

import java.util.List;

/**
 * @author liuwl
 * 2017/11/3
 */
public class ProductModelDto {
    /**
     * 验证登录参数
     */
    private String token;
    /**
     * 产品uuid
     */
    private String rcProductUuid;
    /**
     * 模型uuid
     */
    private String rcModelUuid;
    /**
     * 操作标识
     * add or update
     */
    private String actionType;
    /**
     * 申请地区
     */
    private List<RcModelArea> rcModelArea;

    /**
     * 人基础信息
     */
    private List<ModelCodeDto> basePer;

    /**
     * 企业基础信息
     */
    private List<ModelCodeDto> baseCom;

    /**
     * 烟草
     */
    private List<ModelCodeDto> proTbac;

    /**
     * 运营商
     */
    private List<ModelCodeDto> thirdOper;

    /**
     * 淘宝天猫
     */
    private List<ModelCodeDto> proAli;

    /**
     * 京东
     */
    private List<ModelCodeDto> proJd;

    /**
     * 银行卡
     */
    private List<BankCardDto> proBankCard;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRcProductUuid() {
        return rcProductUuid;
    }

    public void setRcProductUuid(String rcProductUuid) {
        this.rcProductUuid = rcProductUuid;
    }

    public String getRcModelUuid() {
        return rcModelUuid;
    }

    public void setRcModelUuid(String rcModelUuid) {
        this.rcModelUuid = rcModelUuid;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public List<RcModelArea> getRcModelArea() {
        return rcModelArea;
    }

    public void setRcModelArea(List<RcModelArea> rcModelArea) {
        this.rcModelArea = rcModelArea;
    }

    public List<ModelCodeDto> getBasePer() {
        return basePer;
    }

    public void setBasePer(List<ModelCodeDto> basePer) {
        this.basePer = basePer;
    }

    public List<ModelCodeDto> getProTbac() {
        return proTbac;
    }

    public void setProTbac(List<ModelCodeDto> proTbac) {
        this.proTbac = proTbac;
    }

    public List<ModelCodeDto> getThirdOper() {
        return thirdOper;
    }

    public void setThirdOper(List<ModelCodeDto> thirdOper) {
        this.thirdOper = thirdOper;
    }

    public List<ModelCodeDto> getProAli() {
        return proAli;
    }

    public void setProAli(List<ModelCodeDto> proAli) {
        this.proAli = proAli;
    }

    public List<ModelCodeDto> getProJd() {
        return proJd;
    }

    public void setProJd(List<ModelCodeDto> proJd) {
        this.proJd = proJd;
    }

    public List<BankCardDto> getProBankCard() {
        return proBankCard;
    }

    public void setProBankCard(List<BankCardDto> proBankCard) {
        this.proBankCard = proBankCard;
    }

    public List<ModelCodeDto> getBaseCom() {
        return baseCom;
    }

    public void setBaseCom(List<ModelCodeDto> baseCom) {
        this.baseCom = baseCom;
    }
}
