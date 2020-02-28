package cn.stylefeng.guns.controller;

import cn.stylefeng.guns.entity.Result;
import cn.stylefeng.guns.entity.ResultStatusCode;
import cn.stylefeng.guns.pojo.PermissionNode;
import cn.stylefeng.guns.pojo.Role;
import cn.stylefeng.guns.pojos.RolePermissionNode;
import cn.stylefeng.guns.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制器
 *
 * @author 
 * @Date 2020-02-27 19:58:19
 */
@Controller
@RequestMapping("/role")
@CrossOrigin
@Api(value = "角色管理",description = "角色的增删改查")
public class RolesController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/roleList")
    @ResponseBody
    @ApiOperation("角色管理查询列表")
    public Result roleList(int page, int size) {
        try {
            int count = roleService.countRole();
            List<Role> perList = roleService.roleList(page, size);
            return new Result(true, ResultStatusCode.SUCCESS,count, "查询角色成功!", perList);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, ResultStatusCode.FAIL, "查询角色失败!");
        }
    }

    @PostMapping("/saveRole")
    @ResponseBody
    @ApiOperation("保存角色")
    public Result saveRole(@RequestBody Role role) {
        try {
            roleService.saveRole(role);
            return new Result(true, ResultStatusCode.SUCCESS, "保存角色成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, ResultStatusCode.FAIL, "保存角色失败!");
        }
    }

    @GetMapping("/findByRoleId")
    @ResponseBody
    @ApiOperation("根据id查询角色和权限")
    public Result findByRoleId(String roleId) {
        try {
            List<RolePermissionNode> byRoleId = roleService.findByRoleId(roleId);
            return new Result(true, ResultStatusCode.SUCCESS, "根据id查询角色和权限成功!", byRoleId);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, ResultStatusCode.FAIL, "根据id查询角色和权限失败!");
        }
    }

    @PutMapping("/updateRole")
    @ResponseBody
    @ApiOperation("根据id修改角色信息和权限")
    public Result updateRole(String roleId, @RequestBody Role role) {
        try {
            roleService.updateRole(roleId,role);
            return new Result(true, ResultStatusCode.SUCCESS, "根据id修改角色信息和权限成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, ResultStatusCode.FAIL, "根据id修改角色信息和权限失败!");
        }
    }

    @GetMapping("/findRoleName")
    @ResponseBody
    @ApiOperation("根据角色名称查询角色信息和权限")
    public Result findRoleName(String tRoleName) {
        try {
            List<Role> roleName = roleService.findRoleName(tRoleName);
            return new Result(true, ResultStatusCode.SUCCESS, "根据角色名称查询角色信息和权限成功!", roleName);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, ResultStatusCode.FAIL, "根据角色名称查询角色信息和权限失败!");
        }
    }

    @DeleteMapping("/deleteRole")
    @ResponseBody
    @ApiOperation("根据角色id删除角色信息和权限")
    public Result deleteRole(String roleId) {
        try {
            roleService.deleteRole(roleId);
            return new Result(true, ResultStatusCode.SUCCESS, "根据角色id删除角色信息和权限成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, ResultStatusCode.FAIL, "根据角色id删除角色信息和权限失败!");
        }
    }

}
