package cn.stylefeng.guns.controller;

import cn.stylefeng.guns.entity.Result;
import cn.stylefeng.guns.entity.ResultStatusCode;
import cn.stylefeng.guns.pojo.Employee;
import cn.stylefeng.guns.pojos.EmpLog;
import cn.stylefeng.guns.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/log")
@CrossOrigin
@Api(value = "日志管理",description = "日志记录，员工的所有操作")
public class LogsController {

    @Autowired
    private LogService logService;

    /**
     * 查看操作记录日志
     * @return
     */
    @GetMapping("/findLogList")
    @ResponseBody
    @ApiOperation("查看日志操作记录")
    public Result findLogList(int page,int size) {
        try {
            int total = logService.countLog();
            List<Map<String,String>> logList = logService.findLogList(page, size);
            return new Result(true, ResultStatusCode.SUCCESS, total, "查询成功!",logList);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, ResultStatusCode.FAIL, "查询失败!");
        }
    }

    /**
     * 查看操作记录日志
     * @return
     */
    @PostMapping("/findUsernameIpOr")
    @ResponseBody
    @ApiOperation("根据操作人、操作记录、IP地址来搜索")
    public Result findUsernameIpOr(@RequestBody EmpLog empLog) {
        try {
            int total = logService.countLog();
            List<Map<String, Object>> logList = logService.findUsernameIpOr(empLog);
            return new Result(true, ResultStatusCode.SUCCESS,total, "查询成功!",logList);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, ResultStatusCode.FAIL, "查询失败!");
        }
    }
}
