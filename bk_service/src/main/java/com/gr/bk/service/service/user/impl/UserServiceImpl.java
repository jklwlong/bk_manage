package com.gr.bk.service.service.user.impl;

import com.gr.bk.common.domain.UserDomain;
import com.gr.bk.service.persistence.permission.PermissionDomainMapper;
import com.gr.bk.service.persistence.role.RoleDomainMapper;
import com.gr.bk.service.persistence.user.UserDomainMapper;
import com.gr.bk.service.service.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserDomainMapper userDomainMapper;
    @Resource
    private RoleDomainMapper roleDomainMapper;
    @Resource
    private PermissionDomainMapper permissionDomainMapper;

    @Override
    public List<UserDomain> queryAll() {
        return userDomainMapper.queryAll();
    }

    @Override
    public UserDomain findUserByUserName(String username) {
        return userDomainMapper.findUserByUserName(username);
    }

    @Override
    public Set<String> queryRoleByUser(String userUuid) {
        return roleDomainMapper.queryRoleByUser(userUuid);
    }

    @Override
    public Set<String> queryPermission(String userUuid) {
        return permissionDomainMapper.queryPermission(userUuid);
    }
}
