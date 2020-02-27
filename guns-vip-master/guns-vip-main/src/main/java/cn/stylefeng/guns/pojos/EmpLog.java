package cn.stylefeng.guns.pojos;

import cn.stylefeng.guns.pojo.Employee;
import cn.stylefeng.guns.pojo.Log;
import com.baomidou.mybatisplus.annotation.TableField;

import java.util.Date;

public class EmpLog {
    private Employee employee = new Employee();
    private Log log = new Log();

    /**
     * 用户名
     */
    @TableField("t_username")
    private String tUsername;

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

    public EmpLog() {
    }

    public EmpLog(Employee employee, Log log) {
        this.employee = employee;
        this.log = log;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
    }

    public String gettUsername() {
        return tUsername;
    }

    public void settUsername(String tUsername) {
        this.tUsername = tUsername;
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
}
