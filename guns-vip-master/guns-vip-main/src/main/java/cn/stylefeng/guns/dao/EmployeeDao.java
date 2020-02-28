package cn.stylefeng.guns.dao;

import cn.stylefeng.guns.pojo.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmployeeDao extends BaseMapper<Employee> {

    @Select("SELECT * from tb_employee e where e.t_username = #{username}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "t_username", property = "tUsername"),
            @Result(column = "t_realyname", property = "tRealyname"),
            @Result(column = "t_password", property = "tPassword"),
            @Result(column = "t_status", property = "tStatus"),
            @Result(column = "t_mobile", property = "tMobile"),
            @Result(column = "t_is_teacher", property = "tIsTeacher"),
            @Result(column = "t_is_service", property = "tIsService"),
            @Result(column = "t_createdate", property = "tCreatedate"),
            @Result(column = "t_updatedate", property = "tUpdatedate"),
            @Result(column = "role_id", property = "roleId")
    })
    Employee findByUsername(@Param("username") String username);

    @Select("SELECT * from tb_employee e")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "t_username", property = "tUsername"),
            @Result(column = "t_realyname", property = "tRealyname"),
            @Result(column = "t_password", property = "tPassword"),
            @Result(column = "t_status", property = "tStatus"),
            @Result(column = "t_mobile", property = "tMobile"),
            @Result(column = "t_is_teacher", property = "tIsTeacher"),
            @Result(column = "t_is_service", property = "tIsService"),
            @Result(column = "t_createdate", property = "tCreatedate"),
            @Result(column = "t_updatedate", property = "tUpdatedate"),
            @Result(column = "role_id", property = "roleId")
    })
    List<Employee> findEmpList();

    @Select("SELECT * from tb_employee e where e.id = #{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "t_username", property = "tUsername"),
            @Result(column = "t_realyname", property = "tRealyname"),
            @Result(column = "t_password", property = "tPassword"),
            @Result(column = "t_status", property = "tStatus"),
            @Result(column = "t_mobile", property = "tMobile"),
            @Result(column = "t_is_teacher", property = "tIsTeacher"),
            @Result(column = "t_is_service", property = "tIsService"),
            @Result(column = "t_createdate", property = "tCreatedate"),
            @Result(column = "t_updatedate", property = "tUpdatedate"),
            @Result(column = "role_id", property = "roleId")
    })
    Employee findById(@Param("id") String id);

    /**
     * 修改员工状态
     * @param id
     */
    @Update("update tb_employee e set e.t_status=#{status} where e.id=#{id}")
    void updateStatus(@Param("status") int status,@Param("id") String id);

    @Select({"<script>" +
            "select * from tb_employee e where 1=1 " +
            "<if test='tUsername!=null and tUsername!=\"\"'> and e.t_username LIKE '%${tUsername}%' </if> " +
            "<if test='tMobile!=null and tMobile!=\"\"'> and e.t_mobile = #{tMobile}</if> " +
            "<if test='tRealyname!=null and tRealyname!=\"\"'> and e.t_realyname LIKE '%${tRealyname}%'</if>" +
            "</script>"})
    public List<Employee> findByUsernameOrMobileOrRn(Employee employee);

    @Select("<script>" +
            "select * from tb_employee e where 1=1 " +
            "<if test='status!=null'> and e.t_status=#{status} </if> " +
            "</script>")
    List<Employee> findByStatus(@Param("status") Integer status);

    @Select("select count(*) from tb_employee")
    int countEmp();

    /**
     * 修改密码
     * @param newPwd
     * @param userId
     */
    @Update("update tb_employee e set e.t_password=#{newPwd} where e.id=#{userId}")
    void updateEmpPwd(@Param("newPwd") String newPwd, @Param("userId") String userId);

    /**
     * 修改当前登录用户手机号
     * @param mobile
     * @param userId
     * @return
     */
    @Update("update tb_employee e set e.t_mobile=#{mobile} where e.id=#{userId}")
    void updateLoginUserMobile(@Param("mobile") String mobile,@Param("userId") String userId);
}
