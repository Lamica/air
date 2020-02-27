package cn.stylefeng.guns.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 员工表
 * </p>
 *
 * @author leon
 * @since 2020-02-26
 */
@TableName("tb_employee")
public class Employee implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
      @TableId(value = "id", type = IdType.ID_WORKER)
    private String id;

    /**
     * 用户名
     */
    @TableField("t_username")
    private String tUsername;

    /**
     * 真实姓名
     */
    @TableField("t_realyname")
    private String tRealyname;

    /**
     * 手机号
     */
    @TableField("t_mobile")
    private String tMobile;

    /**
     * 密码
     */
    @TableField("t_password")
    private String tPassword;

    /**
     * 是否教师
     */
    @TableField("t_is_teacher")
    private boolean tIsTeacher;

    /**
     * 是否客服
     */
    @TableField("t_is_service")
    private boolean tIsService;

    /**
     * 状态 1正常 2禁用
     */
    @TableField("t_status")
    private Integer tStatus;

    /**
     * 创建日期
     */
    @TableField("t_createdate")
    private Date tCreatedate;

    /**
     * 修改日期
     */
    @TableField("t_updatedate")
    private Date tUpdatedate;

    /**
     * 角色ID
     */
    @TableField("role_id")
    private String roleId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String gettUsername() {
        return tUsername;
    }

    public void settUsername(String tUsername) {
        this.tUsername = tUsername;
    }

    public String gettRealyname() {
        return tRealyname;
    }

    public void settRealyname(String tRealyname) {
        this.tRealyname = tRealyname;
    }

    public String gettMobile() {
        return tMobile;
    }

    public void settMobile(String tMobile) {
        this.tMobile = tMobile;
    }

    public String gettPassword() {
        return tPassword;
    }

    public void settPassword(String tPassword) {
        this.tPassword = tPassword;
    }

    public boolean gettIsTeacher() {
        return tIsTeacher;
    }

    public void settIsTeacher(boolean tIsTeacher) {
        this.tIsTeacher = tIsTeacher;
    }

    public boolean gettIsService() {
        return tIsService;
    }

    public void settIsService(boolean tIsService) {
        this.tIsService = tIsService;
    }

    public Integer gettStatus() {
        return tStatus;
    }

    public void settStatus(Integer tStatus) {
        this.tStatus = tStatus;
    }

    public Date gettCreatedate() {
        return tCreatedate;
    }

    public void settCreatedate(Date tCreatedate) {
        this.tCreatedate = tCreatedate;
    }

    public Date gettUpdatedate() {
        return tUpdatedate;
    }

    public void settUpdatedate(Date tUpdatedate) {
        this.tUpdatedate = tUpdatedate;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "Employee{" +
        "id=" + id +
        ", tUsername=" + tUsername +
        ", tRealyname=" + tRealyname +
        ", tMobile=" + tMobile +
        ", tPassword=" + tPassword +
        ", tIsTeacher=" + tIsTeacher +
        ", tIsService=" + tIsService +
        ", tStatus=" + tStatus +
        ", tCreatedate=" + tCreatedate +
        ", tUpdatedate=" + tUpdatedate +
        ", roleId=" + roleId +
        "}";
    }
}
