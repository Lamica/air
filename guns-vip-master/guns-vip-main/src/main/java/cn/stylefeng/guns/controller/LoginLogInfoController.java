package cn.stylefeng.guns.controller;

import cn.stylefeng.guns.entity.Result;
import cn.stylefeng.guns.entity.ResultStatusCode;
import cn.stylefeng.guns.pojo.Employee;
import cn.stylefeng.guns.pojo.LoginLog;
import cn.stylefeng.guns.service.LoginLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loginLog")
@CrossOrigin
@Api(value = "登录日志",description = "登录日志")
public class LoginLogInfoController {
    @Autowired
    private LoginLogService loginLogService;

    /**
     * 查询登录日志
     * @return
     */
    @GetMapping("/findLoginLogList/{page}/{size}")
    @ApiOperation("查询登录日志")
    public Result findLoginLogList(@PathVariable("page") int page, @PathVariable("size") int size) {
        try {
            List<LoginLog> loginLogList = loginLogService.findLoginLogList(page,size);
            return new Result(true, ResultStatusCode.SUCCESS, "查询成功!", loginLogList);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, ResultStatusCode.FAIL, "查询失败!");
        }
    }
}
