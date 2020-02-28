package cn.stylefeng.guns.dao;

import cn.stylefeng.guns.pojo.Role;
import cn.stylefeng.guns.pojos.RolePermission;
import cn.stylefeng.guns.pojos.RolePermissionNode;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.apache.shiro.authz.permission.RolePermissionResolver;

import java.util.List;

@Mapper
public interface RoleDao extends BaseMapper<Role> {

    @Select("select * " +
            "from tb_role r order by t_create_date desc")
    @Results({
            @Result(column = "t_role_name", property = "tRoleName"),
            @Result(column = "t_role_description", property = "tRoleDescription"),
            @Result(column = "t_ip_address", property = "tIpAddress"),
            @Result(column = "t_operator_record", property = "tOperatorRecord"),
            @Result(column = "t_status", property = "tStatus"),
            @Result(column = "t_create_date", property = "tCreateDate"),
            @Result(column = "t_update_date", property = "tUpdateDate"),
    })
    public List<Role> roleList();


    /**
     * 根据角色id查询
     */
    public List<RolePermissionNode> findByRoleId(String roleId);

    @Update("update tb_role r set t_role_name=#{tRoleName}, t_role_description=#{tRoleDescription} " +
            "where role_id=#{roleId}")
    void updateRole(String tRoleName, String tRoleDescription, String roleId);

    @Select("select count(*) from tb_role")
    int countRole();

    @Select("<script>" +
            "select * from tb_role r where 1=1 " +
            "<if test='tRoleName!=null and tRoleName!=\"\" '> and r.t_role_name like '%${tRoleName}%' </if> " +
            "</script>")
    @Results({
            @Result(column = "t_role_name", property = "tRoleName"),
            @Result(column = "t_role_description", property = "tRoleDescription"),
            @Result(column = "t_ip_address", property = "tIpAddress"),
            @Result(column = "t_operator_record", property = "tOperatorRecord"),
            @Result(column = "t_status", property = "tStatus"),
            @Result(column = "t_create_date", property = "tCreateDate"),
            @Result(column = "t_update_date", property = "tUpdateDate"),
    })
    List<Role> findRoleName(@Param("tRoleName") String tRoleName);

    @Delete("delete from tb_role r where r.role_id=#{roleId}")
    void deleteRole(@Param("roleId") String roleId);
}
