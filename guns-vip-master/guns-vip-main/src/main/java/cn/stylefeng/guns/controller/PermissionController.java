package cn.stylefeng.guns.controller;

import cn.stylefeng.guns.entity.Result;
import cn.stylefeng.guns.entity.ResultStatusCode;
import cn.stylefeng.guns.pojo.Employee;
import cn.stylefeng.guns.pojo.PermissionNode;
import cn.stylefeng.guns.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/permission")
@CrossOrigin
@Api(value = "权限管理",description = "权限的增删改查")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/findPerList")
    @ResponseBody
    @ApiOperation("权限管理")
    public Result findPerList() {
        try {
            List<PermissionNode> perList = permissionService.findPerList();
            return new Result(perList,true, ResultStatusCode.SUCCESS, "查询权限成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, ResultStatusCode.FAIL, "查询权限失败!");
        }
    }

}


