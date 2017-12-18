package com.gr.bk.service.service.user;

import com.gr.bk.common.domain.UserDomain;

import java.util.List;
import java.util.Set;

public interface UserService {

    List<UserDomain> queryAll();

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    UserDomain findUserByUserName(String username);

    /**
     * 根据用户uuid查询角色
     * @param userUuid
     * @return
     */
    Set<String> queryRoleByUser(String userUuid);

    Set<String> queryPermission(String userUuid);
}
