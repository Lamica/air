package cn.stylefeng.guns.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 权限
 * </p>
 *
 * @author 
 * @since 2020-02-26
 */
@TableName("tb_permission")
public class Permission implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

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

    public Permission() {
    }

    public Permission(Integer id, String tName, Integer tPid, Integer tLevel) {
        this.id = id;
        this.tName = tName;
        this.tPid = tPid;
        this.tLevel = tLevel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Permission{" +
        "id=" + id +
        ", tName=" + tName +
        ", tPid=" + tPid +
        ", tLevel=" + tLevel +
        "}";
    }
}
