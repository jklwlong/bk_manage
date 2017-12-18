package com.gr.bk.service.config;

import com.gr.bk.common.domain.UserDomain;
import com.gr.bk.service.service.user.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.Set;

public class AuthRealm extends AuthorizingRealm{

    @Resource
    private UserService userService;

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken utoken = (UsernamePasswordToken) token;
        String username = utoken.getUsername();
        UserDomain user = userService.findUserByUserName(username);
        if (user == null) {
            throw new UnknownAccountException();
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
    }

    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 取出用户信息
        UserDomain user = (UserDomain) principals.getPrimaryPrincipal();
        // 查询用户角色
        Set<String> roles = userService.queryRoleByUser(user.getUserUuid());
        // 查询用户权限
        Set<String> permission = userService.queryPermission(user.getUserUuid());
        // 用户授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(permission);
        System.out.println("----------***"+info.getRoles());
        System.out.println("----------***"+info.getStringPermissions());
        return info;
    }
}
