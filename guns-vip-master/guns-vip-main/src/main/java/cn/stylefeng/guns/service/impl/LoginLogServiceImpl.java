package cn.stylefeng.guns.service.impl;

import cn.stylefeng.guns.dao.LoginLogDao;
import cn.stylefeng.guns.pojo.LoginLog;
import cn.stylefeng.guns.service.LoginLogService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    private LoginLogDao loginLogDao;

    /**
     * 登录日志
     */
    @Override
    public void saveLoginLog(LoginLog loginLog) {
        loginLogDao.insertLoginLog(loginLog);
    }

    /**
     * 查询登录日志
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<LoginLog> findLoginLogList(int page,int size) {
        PageHelper.startPage(page-1,size);
        return loginLogDao.findLoginLogList();
    }
}
