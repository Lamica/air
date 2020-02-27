package cn.stylefeng.guns;

import cn.stylefeng.guns.shiro.realm.UserRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfiguration {
    // 1创建realm
    @Bean
    public UserRealm getRealm(){
        return new UserRealm();
    }

    // 2创建安全管理器
    @Bean
    public SecurityManager getSecurityManager(UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 3配置shiro的过滤器工厂
     *  在web程序中，shiro进行权限控制全部是通过一组过滤器集合进行控制
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        // 1 创建过滤器工厂
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        // 2 设置安全管理器
        filterFactoryBean.setSecurityManager(securityManager);
        // 3 通用配置（跳转登陆页面，为授权跳转的页面）
        filterFactoryBean.setLoginUrl("/admin/login");// 跳转url地址
        filterFactoryBean.setUnauthorizedUrl("/admin/login");// 未授权
        /*
           4 设置过滤器集合
            设置所有的过滤器：有顺序map
                key=拦截的url地址
                value=过滤器类型
         */
        // 使用过滤器的形式配置请求地址的依赖权限
        Map<String,String> filterMap = new LinkedHashMap<>();
        // 当前请求地址可以匿名访问
        filterMap.put("/admin/login","anon");
        // 当前请求地址可以认证
        // filterMap.put("index","authc");
        // 注销
        filterMap.put("/admin/logout","logout");

        // 具有某种权限才能访问
        // 如果不具备指定的权限，会跳转到setUnauthorizedUrl
        //filterMap.put("/supplier","perms[user-supplier]");
        // 过滤器集合设置到过滤器工厂
        filterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return filterFactoryBean;
    }

    // 4开启对shiro注解的支持
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

}