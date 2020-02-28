package cn.stylefeng.guns.service;

import cn.stylefeng.guns.pojo.Role;
import cn.stylefeng.guns.pojos.RolePermissionNode;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2020-02-27
 */
public interface RoleService {

    public List<Role> roleList(int page, int size);

    void saveRole(Role role);

    List<RolePermissionNode> findByRoleId(String roleId);

    void updateRole(String roleId, Role role);

    int countRole();

    List<Role> findRoleName(String tRoleName);

    void deleteRole(String roleId);
}
