package cn.stylefeng.guns.dao;

import cn.stylefeng.guns.pojo.PermissionNode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PermissionDao {
    // 权限树形节点
    public List<PermissionNode> selectList();
}
