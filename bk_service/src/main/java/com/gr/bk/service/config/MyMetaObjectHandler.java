package com.gr.bk.service.config;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

public class MyMetaObjectHandler extends MetaObjectHandler {
    /**
     * 测试 user 表 name 字段为空自动填充
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Object createTime = getFieldValByName("createTime", metaObject);//mybatis-plus版本2.0.9+
        Object lastUpdateTime = getFieldValByName("lastUpdateTime", metaObject);
        Object delFlag = getFieldValByName("delFlag", metaObject);
        if (createTime == null) {
            setFieldValByName("createTime", new Date(), metaObject);
        }
        if (lastUpdateTime == null) {
            setFieldValByName("lastUpdateTime", new Date(), metaObject);
        }
        if (delFlag == null) {
            setFieldValByName("delFlag", "0", metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //更新填充
        //mybatis-plus版本2.0.9+
        setFieldValByName("lastUpdateTime", new Date(), metaObject);
    }

}
