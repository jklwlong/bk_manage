package com.gr.bk.common.domain;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;

import static com.baomidou.mybatisplus.enums.FieldFill.*;

/**
 * <p>
 * 测试表
 * </p>
 *
 * @author liuwl
 * @since 2018-01-16
 */
@TableName("role_copy")
public class RoleCopyDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 角色uuid
     */
    @TableField("role_uuid")
    private String roleUuid;
    /**
     * 角色名称
     */
    @TableField("role_name")
    private String roleName;
    /**
     * 角色编码
     */
    @TableField("role_code")
    private String roleCode;
    /**
     * 创建用户uuid
     */
    @TableField("create_user_uuid")
    private String createUserUuid;
    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = INSERT)
    private Date createTime;
    /**
     * 修改用户uuid
     */
    @TableField("last_update_user_uuid")
    private String lastUpdateUserUuid;
    /**
     * 修改时间
     */
    @TableField(value = "last_update_time",fill = INSERT_UPDATE)
    private Date lastUpdateTime;
    /**
     * 删除标记0：有效数据，1：无效数据
     */
    @TableField(value = "del_flag",fill = INSERT)
    @TableLogic
    private String delFlag;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleUuid() {
        return roleUuid;
    }

    public void setRoleUuid(String roleUuid) {
        this.roleUuid = roleUuid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getCreateUserUuid() {
        return createUserUuid;
    }

    public void setCreateUserUuid(String createUserUuid) {
        this.createUserUuid = createUserUuid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdateUserUuid() {
        return lastUpdateUserUuid;
    }

    public void setLastUpdateUserUuid(String lastUpdateUserUuid) {
        this.lastUpdateUserUuid = lastUpdateUserUuid;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "RoleCopy{" +
                ", id=" + id +
                ", roleUuid=" + roleUuid +
                ", roleName=" + roleName +
                ", roleCode=" + roleCode +
                ", createUserUuid=" + createUserUuid +
                ", createTime=" + createTime +
                ", lastUpdateUserUuid=" + lastUpdateUserUuid +
                ", lastUpdateTime=" + lastUpdateTime +
                ", delFlag=" + delFlag +
                "}";
    }
}
