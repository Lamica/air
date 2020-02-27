package cn.stylefeng.guns.dao;

import cn.stylefeng.guns.pojo.Log;
import cn.stylefeng.guns.pojos.EmpLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface LogDao extends BaseMapper {

    @Select("select count(*) from tb_log")
    int countLog();

    @Select("select e.t_username,l.t_operator_date,l.t_ip_address,l.t_operator_record " +
            "from tb_employee e, tb_log l where e.id = l.t_operator_man")
    @Results({
            @Result(column = "t_username", property = "tUsername"),
            @Result(column = "t_operator_date", property = "tOperatorDate"),
            @Result(column = "t_ip_address", property = "tIpAddress"),
            @Result(column = "t_operator_record", property = "tOperatorRecord")
    })
    List<Map<String,String>> findLogList();

    /**
     * 操作人、操作记录、IP地址查询
     */
    @Select("<script>" +
            "select e.t_username,l.t_operator_date,l.t_ip_address,l.t_operator_record " +
            "from tb_employee e, tb_log l " +
            "where e.id = l.t_operator_man " +
            "<if test='tIpAddress!=null and tIpAddress!=\"\"'> and l.t_ip_address=#{tIpAddress} </if> " +
            "<if test='tUsername!=null and tUsername!=\"\"'> and e.t_username like '%${tUsername}%' </if> " +
            "<if test='tOperatorRecord!=null and tOperatorRecord!=\"\"'> and l.t_operator_record like '%${tOperatorRecord}%' </if> " +
            "</script>")
    @Results({
            @Result(column = "t_username", property = "tUsername"),
            @Result(column = "t_operator_date", property = "tOperatorDate"),
            @Result(column = "t_ip_address", property = "tIpAddress"),
            @Result(column = "t_operator_record", property = "tOperatorRecord")
    })
    List<Map<String,Object>> findUsernameIpOr(EmpLog empLog);
}
