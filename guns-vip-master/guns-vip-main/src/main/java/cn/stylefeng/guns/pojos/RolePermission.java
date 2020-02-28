package cn.stylefeng.guns.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

public class RolePermission {

    @TableId(value = "id")
    private Integer id;

    @TableId(value = "role_id", type = IdType.ID_WORKER)
    private String roleId;

    /**
     * 角色名称
     */
    @TableField("t_role_name")
    private String tRoleName;

    /**
     * 角色描述
     */
    @TableField("t_role_description")
    private String tRoleDescription;

    /**
     * 权限ID集
     */
    @TableField("t_ids")
    private String tIds;

    /**
     * 状态 1启用 2停用
     */
    @TableField("t_status")
    private Integer tStatus;

    /**
     * 新增时间
     */
    @TableField("t_create_date")
    private Date tCreateDate;

    /**
     * 修改日期
     */
    @TableField("t_update_date")
    private Date tUpdateDate;


    /**
     * 权限名称
     */
    @TableField("t_name")
    private String tName;

    /**
     * 父级权限ID
     */
    @TableField("t_pid")
    private Integer tPid;

    /**
     * 权限级别
     */
    @TableField("t_level")
    private Integer tLevel;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String gettRoleName() {
        return tRoleName;
    }

    public void settRoleName(String tRoleName) {
        this.tRoleName = tRoleName;
    }

    public String gettRoleDescription() {
        return tRoleDescription;
    }

    public void settRoleDescription(String tRoleDescription) {
        this.tRoleDescription = tRoleDescription;
    }

    public String gettIds() {
        return tIds;
    }

    public void settIds(String tIds) {
        this.tIds = tIds;
    }

    public Integer gettStatus() {
        return tStatus;
    }

    public void settStatus(Integer tStatus) {
        this.tStatus = tStatus;
    }

    public Date gettCreateDate() {
        return tCreateDate;
    }

    public void settCreateDate(Date tCreateDate) {
        this.tCreateDate = tCreateDate;
    }

    public Date gettUpdateDate() {
        return tUpdateDate;
    }

    public void settUpdateDate(Date tUpdateDate) {
        this.tUpdateDate = tUpdateDate;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public Integer gettPid() {
        return tPid;
    }

    public void settPid(Integer tPid) {
        this.tPid = tPid;
    }

    public Integer gettLevel() {
        return tLevel;
    }

    public void settLevel(Integer tLevel) {
        this.tLevel = tLevel;
    }
}
