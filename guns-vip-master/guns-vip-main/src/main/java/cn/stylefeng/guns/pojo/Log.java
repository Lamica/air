package cn.stylefeng.guns.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2020-02-26
 */
@TableName("tb_log")
public class Log implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.ID_WORKER)
    private String id;

    /**
     * 操作人
     */
    @TableField("t_operator_man")
    private String tOperatorMan;

    /**
     * 操作日期
     */
    @TableField("t_operator_date")
    private Date tOperatorDate;

    /**
     * ip地址
     */
    @TableField("t_ip_address")
    private String tIpAddress;

    /**
     * 操作记录
     */
    @TableField("t_operator_record")
    private String tOperatorRecord;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String gettOperatorMan() {
        return tOperatorMan;
    }

    public void settOperatorMan(String tOperatorMan) {
        this.tOperatorMan = tOperatorMan;
    }

    public Date gettOperatorDate() {
        return tOperatorDate;
    }

    public void settOperatorDate(Date tOperatorDate) {
        this.tOperatorDate = tOperatorDate;
    }

    public String gettIpAddress() {
        return tIpAddress;
    }

    public void settIpAddress(String tIpAddress) {
        this.tIpAddress = tIpAddress;
    }

    public String gettOperatorRecord() {
        return tOperatorRecord;
    }

    public void settOperatorRecord(String tOperatorRecord) {
        this.tOperatorRecord = tOperatorRecord;
    }

    @Override
    public String toString() {
        return "Log{" +
        "id=" + id +
        ", tOperatorMan=" + tOperatorMan +
        ", tOperatorDate=" + tOperatorDate +
        ", tIpAddress=" + tIpAddress +
        ", tOperatorRecord=" + tOperatorRecord +
        "}";
    }
}
