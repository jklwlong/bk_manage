package com.gr.bk.common.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 区域地址
 * </p>
 *
 * @author liuwl
 * @since 2018-03-19
 */
@TableName("rc_area_addr")
public class RcAreaAddr implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="rc_area_addr_id", type= IdType.AUTO)
	private Integer rcAreaAddrId;
    /**
     * 区域地址UUID
     */
	@TableField("rc_area_addr_uuid")
	private String rcAreaAddrUuid;
    /**
     * 区域编码UUID
     */
	@TableField("rc_area_code_uuid")
	private String rcAreaCodeUuid;
    /**
     * 地址编码
     */
	@TableField("addr_code")
	private String addrCode;
    /**
     * 区域地址
     */
	@TableField("area_addr")
	private String areaAddr;
    /**
     * 备注
     */
	private String remark;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 修改时间
     */
	@TableField("update_time")
	private Date updateTime;
    /**
     * 删除标记(0-否，1-是)
     */
	@TableField("del_flag")
	private Integer delFlag;


	public Integer getRcAreaAddrId() {
		return rcAreaAddrId;
	}

	public void setRcAreaAddrId(Integer rcAreaAddrId) {
		this.rcAreaAddrId = rcAreaAddrId;
	}

	public String getRcAreaAddrUuid() {
		return rcAreaAddrUuid;
	}

	public void setRcAreaAddrUuid(String rcAreaAddrUuid) {
		this.rcAreaAddrUuid = rcAreaAddrUuid;
	}

	public String getRcAreaCodeUuid() {
		return rcAreaCodeUuid;
	}

	public void setRcAreaCodeUuid(String rcAreaCodeUuid) {
		this.rcAreaCodeUuid = rcAreaCodeUuid;
	}

	public String getAddrCode() {
		return addrCode;
	}

	public void setAddrCode(String addrCode) {
		this.addrCode = addrCode;
	}

	public String getAreaAddr() {
		return areaAddr;
	}

	public void setAreaAddr(String areaAddr) {
		this.areaAddr = areaAddr;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	@Override
	public String toString() {
		return "RcAreaAddr{" +
			", rcAreaAddrId=" + rcAreaAddrId +
			", rcAreaAddrUuid=" + rcAreaAddrUuid +
			", rcAreaCodeUuid=" + rcAreaCodeUuid +
			", addrCode=" + addrCode +
			", areaAddr=" + areaAddr +
			", remark=" + remark +
			", createTime=" + createTime +
			", updateTime=" + updateTime +
			", delFlag=" + delFlag +
			"}";
	}
}
