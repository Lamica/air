package cn.stylefeng.guns.service.impl;

import cn.stylefeng.guns.dao.EmployeeDao;
import cn.stylefeng.guns.dao.LogDao;
import cn.stylefeng.guns.pojo.Employee;

import cn.stylefeng.guns.pojo.Log;
import cn.stylefeng.guns.pojo.LoginLog;
import  cn.stylefeng.guns.service.EmployeeService;
import cn.stylefeng.guns.service.LoginLogService;
import cn.stylefeng.guns.utils.IdWorker;
import com.github.pagehelper.PageHelper;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author leon
 * @since 2020-02-26
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private LogDao logDao;

    @Autowired
    private IdWorker idWorker;

    @Override
    public void saveUsername(Employee employee, HttpServletRequest request) {
        employee.setId(idWorker.nextId()+"");
        employee.settMobile(employee.gettMobile());
        // 日期格式化
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        dateFormat.format(date);
        employee.settCreatedate(date);
        employee.settIsService(employee.gettIsService());
        employee.settIsTeacher(employee.gettIsTeacher());
        // 密码加密
        String password = new Md5Hash(employee.gettPassword(), employee.gettUsername(), 3).toString();
        employee.settPassword(password);
        // 用户名
        employee.settUsername(employee.gettUsername());
        // 真实姓名
        employee.settRealyname(employee.gettRealyname());
        employee.settStatus(1);// 状态 1正常 2禁用
        // 角色
        employee.setRoleId(employee.getRoleId());
        employeeDao.insert(employee);

        // 获取当前登录用户id
        String userId = (String) request.getSession().getAttribute("id");
        try {
            // 操作日志
            Log log = new Log();
            log.setId(idWorker.nextId()+"");
            log.settIpAddress(Inet4Address.getLocalHost().getHostAddress());
            log.settOperatorDate(date);
            log.settOperatorMan(userId);
            log.settOperatorRecord("新增员工");
            logDao.insert(log);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee findByUsername(String username) {

        return employeeDao.findByUsername(username);
    }

    @Override
    public List<Employee> findEmpList(int page, int size) {
        PageHelper.startPage(page-1,size);
        return employeeDao.findEmpList();
    }

    @Override
    public Employee findById(String id) {
        return employeeDao.findById(id);
    }

    @Override
    public void updateById(String id, Employee emp, HttpServletRequest request) {
        try {
            Employee employee = findById(id);
            // 用户名
            employee.settUsername(emp.gettUsername());
            // 密码加密
            String password = new Md5Hash(emp.gettPassword(), emp.gettUsername(), 3).toString();
            employee.settPassword(password);
            // 手机号
            employee.settMobile(emp.gettMobile());
            // 日期格式化
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            dateFormat.format(date);
            employee.settUpdatedate(date);

            employee.settIsService(emp.gettIsService());
            employee.settIsTeacher(emp.gettIsTeacher());

            // 用户名
            employee.settUsername(emp.gettUsername());
            // 真实姓名
            employee.settRealyname(emp.gettRealyname());
            // 状态 1正常 2禁用
            employee.settStatus(emp.gettStatus());
            // 角色
            employee.setRoleId(emp.getRoleId());
            employeeDao.updateById(employee);

            // 获取当前登录用户id
            String userId = (String) request.getSession().getAttribute("id");
            try {
                // 操作日志
                Log log = new Log();
                log.setId(idWorker.nextId()+"");
                log.settIpAddress(Inet4Address.getLocalHost().getHostAddress());
                log.settOperatorDate(date);
                log.settOperatorMan(userId);
                log.settOperatorRecord("编辑员工");
                logDao.insert(log);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(String[] ids, HttpServletRequest request) {
        for (String id : ids) {
            employeeDao.deleteById(id);
        }

        // 获取当前登录用户id
        String userId = (String) request.getSession().getAttribute("id");
        // 日期格式化
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        dateFormat.format(date);
        try {
            // 操作日志
            Log log = new Log();
            log.setId(idWorker.nextId()+"");
            log.settIpAddress(Inet4Address.getLocalHost().getHostAddress());
            log.settOperatorDate(date);
            log.settOperatorMan(userId);
            log.settOperatorRecord("删除员工");
            logDao.insert(log);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStatus(int status, String id, HttpServletRequest request) {
        employeeDao.updateStatus(status,id);
        // 获取当前登录用户id
        String userId = (String) request.getSession().getAttribute("id");
        // 日期格式化
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        dateFormat.format(date);
        try {
            // 操作日志
            Log log = new Log();
            log.setId(idWorker.nextId()+"");
            log.settIpAddress(Inet4Address.getLocalHost().getHostAddress());
            log.settOperatorDate(date);
            log.settOperatorMan(userId);
            log.settOperatorRecord("修改员工状态");
            logDao.insert(log);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> findByUsernameOrMobileOrRn(Employee employee) {
        return employeeDao.findByUsernameOrMobileOrRn(employee);
    }

    @Override
    public List<Employee> findByStatus(Integer status) {
        return employeeDao.findByStatus(status);
    }

    @Override
    public int countEmp() {
        return employeeDao.countEmp();
    }

    @Override
    public void updateEmpPwd(String newPwd, String userId) {
        employeeDao.updateEmpPwd(newPwd,userId);
    }

    @Override
    public void updateLoginUserMobile(String mobile, String userId) {
        employeeDao.updateLoginUserMobile(mobile,userId);
    }

}
