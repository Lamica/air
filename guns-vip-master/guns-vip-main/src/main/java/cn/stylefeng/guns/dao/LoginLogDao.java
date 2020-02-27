package cn.stylefeng.guns.dao;

import cn.stylefeng.guns.pojo.Employee;
import cn.stylefeng.guns.pojo.LoginLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LoginLogDao extends BaseMapper<LoginLog> {
    @Insert("insert into tb_login_log(id,row_guid,recordguid,t_login_date,t_login_ip) " +
            "values(#{id},#{rowGuid},#{recordguid},#{tLoginDate},#{tLoginIp})")
    void insertLoginLog(LoginLog loginLog);

    @Select("SELECT * from tb_login_log tb")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "row_guid", property = "rowGuid"),
            @Result(column = "recordguid", property = "recordguid"),
            @Result(column = "t_login_date", property = "tLoginDate"),
            @Result(column = "t_login_ip", property = "tLoginIp")
    })
    List<LoginLog> findLoginLogList();
}
