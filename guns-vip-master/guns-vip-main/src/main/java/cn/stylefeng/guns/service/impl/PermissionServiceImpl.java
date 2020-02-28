package cn.stylefeng.guns.service.impl;

import cn.stylefeng.guns.dao.PermissionDao;
import cn.stylefeng.guns.pojo.PermissionNode;
import  cn.stylefeng.guns.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<PermissionNode> findPerList() {
        List<PermissionNode> perList = permissionDao.selectList();
        System.out.println(perList);
        return perList;
    }
}
