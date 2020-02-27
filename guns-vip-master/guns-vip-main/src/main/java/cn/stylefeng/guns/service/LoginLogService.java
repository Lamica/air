package cn.stylefeng.guns.service;

import cn.stylefeng.guns.pojo.LoginLog;
import sun.rmi.runtime.Log;

import java.util.List;

public interface LoginLogService {
    void saveLoginLog(LoginLog loginLog);
    List<LoginLog> findLoginLogList(int page,int size);
}
