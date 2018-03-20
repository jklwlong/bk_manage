package com.rctest;

/**
 * @author liuwl
 * 2017/11/6
 */
public class ModelCodeDto {
    /**
     * 编码uuid
     */
    private String rcMetricCodeUuid;
    /**
     * 编码
     */
    private String code;
    /**
     * 编码名称
     */
    private String codeName;
    /**
     * 归属于
     */
    private String belong;
    /**
     * 判定条件
     */
    private String jCondition;
    /**
     * 判定条件描述
     */
    private String jConditionDesc;
    /**
     * 判定值
     */
    private String jValue;
    /**
     * 判定结果
     */
    private String jResult;
    /**
     * 判定结果描述
     */
    private String jResultDesc;
    /**
     * 扩展字段
     */
    private String extField;
    /**
     * 是否依赖引用
     */
    private String isRef;
    /**
     * 编码级别
     */
    private String codeLevel;

    public String getRcMetricCodeUuid() {
        return rcMetricCodeUuid;
    }

    public void setRcMetricCodeUuid(String rcMetricCodeUuid) {
        this.rcMetricCodeUuid = rcMetricCodeUuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public String getjCondition() {
        return jCondition;
    }

    public void setjCondition(String jCondition) {
        this.jCondition = jCondition;
    }

    public String getjConditionDesc() {
        return jConditionDesc;
    }

    public void setjConditionDesc(String jConditionDesc) {
        this.jConditionDesc = jConditionDesc;
    }

    public String getjValue() {
        return jValue;
    }

    public void setjValue(String jValue) {
        this.jValue = jValue;
    }

    public String getjResultDesc() {
        return jResultDesc;
    }

    public void setjResultDesc(String jResultDesc) {
        this.jResultDesc = jResultDesc;
    }

    public String getjResult() {
        return jResult;
    }

    public void setjResult(String jResult) {
        this.jResult = jResult;
    }

    public String getExtField() {
        return extField;
    }

    public void setExtField(String extField) {
        this.extField = extField;
    }

    public String getIsRef() {
        return isRef;
    }

    public void setIsRef(String isRef) {
        this.isRef = isRef;
    }

    public String getCodeLevel() {
        return codeLevel;
    }

    public void setCodeLevel(String codeLevel) {
        this.codeLevel = codeLevel;
    }
}
