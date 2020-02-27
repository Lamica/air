package cn.stylefeng.guns.service;

import cn.stylefeng.guns.pojo.Log;
import cn.stylefeng.guns.pojos.EmpLog;

import java.util.List;
import java.util.Map;

public interface LogService {
    List<Map<String,String>> findLogList(int page, int size);
    List<Map<String,Object>> findUsernameIpOr(EmpLog empLog);
    int countLog();
}
