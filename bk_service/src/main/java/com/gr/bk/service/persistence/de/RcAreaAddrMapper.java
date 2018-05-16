package com.gr.bk.service.persistence.de;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.gr.bk.common.domain.RcAreaAddr;
import com.gr.bk.common.domain.RcAreaCode;

import java.util.List;

/**
 * <p>
 * 区域地址 Mapper 接口
 * </p>
 *
 * @author liuwl
 * @since 2018-03-19
 */
public interface RcAreaAddrMapper extends BaseMapper<RcAreaAddr> {

    List<RcAreaCode> queryAddr();
}
