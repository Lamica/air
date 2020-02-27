package cn.stylefeng.guns.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author leon
 * @since 2020-02-26
 */
@Data
public class EmployeeResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */
    private String id;

    /**
     * 用户名
     */
    private String tUsername;

    /**
     * 真实姓名
     */
    private String tRealyname;

    /**
     * 手机号
     */
    private String tMobile;

    /**
     * 密码
     */
    private String tPassword;

    /**
     * 是否教师
     */
    private Long tIsTeacher;

    /**
     * 是否客服
     */
    private Long tIsService;

    /**
     * 状态 1正常 2禁用
     */
    private Integer tStatus;

    /**
     * 创建日期
     */
    private String tCreatedate;

    /**
     * 修改日期
     */
    private String tUpdatedate;

    /**
     * 角色ID
     */
    private String roleId;

}
