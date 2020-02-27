package cn.stylefeng.guns.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 登录日志
 * </p>
 *
 * @author 
 * @since 2020-02-26
 */
@TableName("tb_login_log")
public class LoginLog implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("row_guid")
    private String rowGuid;

    /**
     * 关联用户
     */
    @TableField("recordguid")
    private String recordguid;

    @TableId(value = "id", type = IdType.ID_WORKER)
    private String id;

    /**
     * 登录日期
     */
    @TableField("t_login_date")
    private Date tLoginDate;

    /**
     * 登录IP
     */
    @TableField("t_login_ip")
    private String tLoginIp;


    public String getRowGuid() {
        return rowGuid;
    }

    public void setRowGuid(String rowGuid) {
        this.rowGuid = rowGuid;
    }

    public String getRecordguid() {
        return recordguid;
    }

    public void setRecordguid(String recordguid) {
        this.recordguid = recordguid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date gettLoginDate() {
        return tLoginDate;
    }

    public void settLoginDate(Date tLoginDate) {
        this.tLoginDate = tLoginDate;
    }

    public String gettLoginIp() {
        return tLoginIp;
    }

    public void settLoginIp(String tLoginIp) {
        this.tLoginIp = tLoginIp;
    }

    @Override
    public String toString() {
        return "LoginLog{" +
        "rowGuid=" + rowGuid +
        ", recordguid=" + recordguid +
        ", id=" + id +
        ", tLoginDate=" + tLoginDate +
        ", tLoginIp=" + tLoginIp +
        "}";
    }
}
