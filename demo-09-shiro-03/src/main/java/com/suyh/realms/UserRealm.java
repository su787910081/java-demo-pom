package com.suyh.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 自定义Realm 的实现
 */
public class UserRealm extends AuthorizingRealm {
    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 认证
     * 完成身份认证并且返回认证信息
     * 如果认证失败则返回null
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取用户输入的用户名，其实就是 UsernamePasswordToken::getPrincipal() 即：getUsername();
        String username = (String) token.getPrincipal();
        System.out.println("username====" + username);
        // 根据用户名到数据库中查询密码信息 -- 模拟
        // 假定从数据库中获取的密码就是: "1111"
        String pwd = "1111";
        // 将数据库中查询到的信息封装到 SimpleAuthenticationInfo 中
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, pwd, getName());
        return info;
    }
}
