package cn.stylefeng.guns.controller;

import cn.stylefeng.guns.entity.Result;
import cn.stylefeng.guns.entity.ResultStatusCode;
import cn.stylefeng.guns.pojo.Employee;
import cn.stylefeng.guns.pojo.LoginLog;
import cn.stylefeng.guns.service.EmployeeService;
import cn.stylefeng.guns.service.LoginLogService;
import cn.stylefeng.guns.utils.IdWorker;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 员工管理
 */
@RestController
@RequestMapping("/admin")
@CrossOrigin
@Api(value = "员工管理",description = "员工的增删改查，员工权限、登录、注册")
public class AdminController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private LoginLogService loginLogService;
    @Autowired
    private IdWorker idWorker;

    /**
     * 保存员工 （管理员）
     * @param employee
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    @ApiOperation("保存员工 （管理员）")
    public Result saveUsername(@RequestBody Employee employee, HttpServletRequest request) {
        try {
            String username = employee.gettUsername();
            Employee emp = employeeService.findByUsername(username);
            if (emp!=null) {
                return new Result(true, ResultStatusCode.FAIL, "用户名已存在!");
            }
            employeeService.saveUsername(employee,request);
            return new Result(true, ResultStatusCode.SUCCESS, "保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, ResultStatusCode.FAIL, "保存失败!");
        }
    }

    /**
     * 查询员工 （管理员）
     * @return
     */
    @GetMapping("/findEmpList")
    @ResponseBody
    @ApiOperation("查询员工 （管理员）")
    public Result findEmpList(int page, int size){
        try {
            int total = employeeService.countEmp();
            List<Employee> emp = employeeService.findEmpList(page,size);
            return new Result(true, ResultStatusCode.SUCCESS,total, "查询成功!", emp);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, ResultStatusCode.FAIL, "查询失败!");
        }
    }

    /**
     * 查询员工 （管理员）
     * @return
     */
    @GetMapping("/findById")
    @ResponseBody
    @ApiOperation("根据id查询员工 （管理员）")
    public Result findById(String id) {
        try {
            Employee emp = employeeService.findById(id);
            return new Result(true, ResultStatusCode.SUCCESS, "查询成功!", emp);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, ResultStatusCode.FAIL, "查询失败!");
        }
    }

    /**
     * 条件查询员工 （管理员）
     * @return
     */
    @PostMapping("/findByUnOrMobileOrRn")
    @ApiOperation("根据输入框的条件查询员工 （管理员）")
    public Result findByUsernameOrMobileOrRn(@RequestBody Employee employee) {
        try {
            int total = employeeService.countEmp();
            List<Employee> usernameOrMobileOrRn = employeeService.findByUsernameOrMobileOrRn(employee);
            return new Result(true, ResultStatusCode.SUCCESS,total, "查询成功!", usernameOrMobileOrRn);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, ResultStatusCode.FAIL, "查询失败!");
        }
    }

    /**
     * 状态查询
     */
    @GetMapping("/findByStatus")
    @ApiOperation("根据状态查询员工 （管理员）")
    public Result findByStatus(Integer status) {
        try {
            int total = employeeService.countEmp();
            List<Employee> sta = employeeService.findByStatus(status);
            return new Result(true, ResultStatusCode.SUCCESS,total, "查询成功!", sta);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, ResultStatusCode.FAIL, "查询失败!");
        }
    }

    /**
     * 编辑员工 （管理员）
     * @return
     */
    @PutMapping("/updateById")
    @ResponseBody
    @ApiOperation("根据id编辑员工 （管理员）")
    public Result updateById(String id,@RequestBody Employee employee, HttpServletRequest request) {
        try {
            employeeService.updateById(id, employee, request);
            return new Result(true, ResultStatusCode.SUCCESS, "修改成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, ResultStatusCode.FAIL, "修改失败!");
        }
    }

    /**
     * 修改员工 （管理员）状态
     * @return
     */
    @PutMapping("/updateStatus")
    @ResponseBody
    @ApiOperation("根据id修改员工 （管理员）状态")
    public Result updateStatus(int status,String id, HttpServletRequest request) {
        try {
            employeeService.updateStatus(status,id,request);
            return new Result(true, ResultStatusCode.SUCCESS, "修改状态成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, ResultStatusCode.FAIL, "修改状态失败!");
        }
    }

    /**
     * 删除员工 （管理员）
     * @return
     */
    @DeleteMapping("/deleteById")
    @ResponseBody
    @ApiOperation("根据id删除员工 （管理员）")
    public Result deleteById(String[] ids, HttpServletRequest request) {
        try {
            for (String id : ids) {
                if (id.equals("110")) {
                    return new Result(false, ResultStatusCode.DELETE_ADMIN_FAIL, "系统用户不支持删除!");
                }
            }
            employeeService.deleteById(ids,request);
            return new Result(true, ResultStatusCode.SUCCESS, "删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, ResultStatusCode.FAIL, "删除失败!");
        }
    }

    /**
     * 修改员工密码
     */
    @PutMapping("/updateEmpPwd")
    @ResponseBody
    @ApiOperation("修改员工密码")
    public Result updateEmpPwd(String id,@RequestBody Map<String,String> twoPwdMap, HttpServletRequest request) {
        try {
            String oldPwd = twoPwdMap.get("oldPwd");
            String newPwd = twoPwdMap.get("newPwd");
            // 获取当前登录用户id
            String userId = (String) request.getSession().getAttribute("id");
            // 查询当前旧密码
            Employee empPwd = employeeService.findById(userId);
            //对输入的旧密码进行加密密码
            String oldPassword = new Md5Hash(oldPwd, empPwd.gettUsername(), 3).toString();  //1.密码，盐，加密次数

            // 新密码加密
            String newPassword = new Md5Hash(newPwd, empPwd.gettUsername(), 3).toString();  //1.密码，盐，加密次数
            // 校验输入的旧密码和表中密码是否一致
            if (empPwd.gettPassword().equals(oldPassword)) { // 说明旧密码正确
                employeeService.updateEmpPwd(newPassword, userId);
                return new Result(true, ResultStatusCode.SUCCESS, "修改密码成功!");
            } else {
                return new Result(false, ResultStatusCode.FAIL, "旧密码输出错误！!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, ResultStatusCode.FAIL, "修改密码失败!");
        }
    }

    /**
     * 用户登录
     */
    @PostMapping("/login")
    @ResponseBody
    @ApiOperation("用户登录")
    public Result login(@RequestBody Map<String,String> loginMap, HttpServletResponse response, HttpServletRequest request){
        try {
            String username = loginMap.get("username");
            String password = loginMap.get("password");
            Employee employee = employeeService.findByUsername(username);
            String id = employee.getId();
            if (employee.gettStatus()==1) {
                //1.构造登录令牌 UsernamePasswordToken  ba4661edf7a3035a922fa44b1a98e0da
                //加密密码
                password = new Md5Hash(password, username, 3).toString();  //1.密码，盐，加密次数
                UsernamePasswordToken upToken = new UsernamePasswordToken(username, password);
                //2.获取subject
                Subject subject = SecurityUtils.getSubject();
                //3.调用login方法，进入realm完成认证
                subject.login(upToken);
                subject.getSession().setTimeout(3600000);
                //4.获取sessionId
                String sessionId = (String) subject.getSession().getId();

                // 存储用户名
                request.getSession().setAttribute("id",employee.getId());
                request.getSession().setAttribute("username",employee.gettUsername());
                request.getSession().setAttribute("mobile",employee.gettMobile());

                // 日期格式化
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();
                dateFormat.format(date);

                InetAddress ip = Inet4Address.getLocalHost();
                String ipHostAddress = ip.getHostAddress();

                // 记录登录日志
                LoginLog loginLog = new LoginLog();
                loginLog.setId(idWorker.nextId()+"");
                loginLog.setRecordguid(id);// 用户id
                loginLog.settLoginDate(date);
                loginLog.settLoginIp(ipHostAddress);
                loginLogService.saveLoginLog(loginLog);

                //5.构造返回结果
                return new Result(true, ResultStatusCode.LOGIN_SUCCESS, "登录成功!", sessionId);
//            return new Result(ResultCode.SUCCESS,sessionId);
            }
            return new Result(false, ResultStatusCode.LOGIN_FAIL1, "账号已禁用!");
        }catch (Exception e) {
            e.printStackTrace();
            return new Result(false, ResultStatusCode.LOGIN_FAIL2,"用户名或密码错误!");
        }
    }
}
