package cn.stylefeng.guns.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.pojo.PermissionNode;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2020-02-27
 */
public interface PermissionService {

    List<PermissionNode> findPerList();
}
