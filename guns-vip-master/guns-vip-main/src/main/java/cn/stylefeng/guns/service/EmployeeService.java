package cn.stylefeng.guns.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.pojo.Employee;
import cn.stylefeng.guns.model.params.EmployeeParam;
import cn.stylefeng.guns.model.result.EmployeeResult;
import cn.stylefeng.guns.pojo.LoginLog;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author leon
 * @since 2020-02-26
 */
public interface EmployeeService {
    void saveUsername(Employee employee, HttpServletRequest request);
    Employee findByUsername(String username);
    List<Employee> findEmpList(int page, int size);
    Employee findById(String id);
    public void updateById(String id, Employee emp, HttpServletRequest request);
    void deleteById(String[] ids, HttpServletRequest request);
    void updateStatus(int status, String id, HttpServletRequest request);
    List<Employee> findByUsernameOrMobileOrRn(Employee employee);
    List<Employee> findByStatus(Integer status);
    int countEmp();

    void updateEmpPwd(String newPwd, String userId);
}
