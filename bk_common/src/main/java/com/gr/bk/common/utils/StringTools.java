package com.gr.bk.common.utils;

import java.util.UUID;

public class StringTools {
    private StringTools() {
    }

    /**
     * 获取UUID
     *
     * @Title: getUuid
     * @Description: TODO
     * @Param @return
     * @Return String
     * @Throws
     */
    public static String getUuid() {
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        return uuid;
    }
}
