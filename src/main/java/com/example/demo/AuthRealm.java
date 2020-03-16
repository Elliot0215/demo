package com.example.demo;

import com.example.demo.domain.Permission;
import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.service.UsersService;
import com.example.demo.service.impl.UsersServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2020/3/15.
 */

public class AuthRealm extends AuthorizingRealm {
    @Autowired
    private UsersServiceImpl usersService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.fromRealm(this.getClass().getName()).iterator().next();
        List<String> permissionList = new ArrayList<>();
        List<String> roleNameList = new ArrayList<>();
        Set<Role> roles = user.getRoles();
        if (!CollectionUtils.isEmpty(roles)){
            for (Role role:roles){
                roleNameList.add(role.getName());
                Set<Permission> permissions = role.getPermissions();
                if (!CollectionUtils.isEmpty(permissions)){
                    for (Permission permission:permissions){
                        permissionList.add(permission.getName());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roleNameList);
        info.addStringPermissions(permissionList);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        User user = usersService.findByUsername(username);
        return new SimpleAuthenticationInfo(user,user.getPassword(),this.getClass().getName());
    }
}
