package cn.stylefeng.guns.shiro.realm;

import cn.stylefeng.guns.pojo.Employee;
import cn.stylefeng.guns.service.EmployeeService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private EmployeeService userService;

    public void setName(String name) {
        super.setName("userRealm");
    }

    /**
     * 授权：授权的主要目的就是根据认证数据获取到用户的权限信息
     * principalCollection 包含了所有已认证的安全数据
     * AuthorizationInfo 授权数据
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 3 构造返回
        return null;
    }

    /**
     * 认证：认证的主要目的，比较用户名和密码是否与数据库中的一致
     * 将安全数据存入到shiro进行保管
     * @param authenticationToken：登陆构造到username password token
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 1.构造uptoken
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 2.获取输入到用户名和密码
        String username = token.getUsername();
        String password = new String(token.getPassword());
        // 3 根据用户名查询数据库
        Employee user = userService.findByUsername(username);
        // 4 比较密码和数据库中的密码是否一致 密码加密
        if (user != null && user.gettPassword().equals(password)) {
            // 5 如果成功 向shiro存入安全数据
            // 构造方法：用户数据，密码，realm域名称
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.gettPassword(),this.getName());
            return info;
        }
        // 6 如果失败 抛出异常
        return null;
    }
}
