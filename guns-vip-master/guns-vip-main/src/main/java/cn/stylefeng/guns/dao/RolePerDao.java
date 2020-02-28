package cn.stylefeng.guns.dao;

import cn.stylefeng.guns.pojo.RolePer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RolePerDao extends BaseMapper<RolePer> {

    @Delete("delete from tb_role_per where role_id=#{roleId}")
    void deleteByRoleId(@Param("roleId") String roleId);

}
