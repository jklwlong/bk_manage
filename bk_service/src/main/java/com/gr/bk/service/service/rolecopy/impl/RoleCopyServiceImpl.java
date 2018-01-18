package com.gr.bk.service.service.rolecopy.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gr.bk.common.domain.RoleCopyDomain;
import com.gr.bk.service.persistence.rolecopy.RoleCopyDomainMapper;
import com.gr.bk.service.service.rolecopy.RoleCopyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleCopyServiceImpl extends ServiceImpl<RoleCopyDomainMapper, RoleCopyDomain> implements RoleCopyService {

    @Resource
    private RoleCopyDomainMapper roleCopyDomainMapper;

    @Override
    public List<RoleCopyDomain> queryAll() {
        List<RoleCopyDomain> list = roleCopyDomainMapper.selectList(null);
        return list;
    }


}
