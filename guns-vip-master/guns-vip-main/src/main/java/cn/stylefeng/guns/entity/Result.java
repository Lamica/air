package cn.stylefeng.guns.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 数据响应对象
 *    {
 *      success ：是否成功
 *      code    ：返回码
 *      message ：返回信息
 *      //返回数据
 *      data：  ：{
 *
 *      }
 *    }
 */
@Data
@NoArgsConstructor
public class Result {

    private boolean success;//是否成功
    private Integer meta;// 返回码
    private String message;//返回信息
    private Object data;// 返回数据
    private String jwt;
    private int total;

    public Result(boolean success, Integer meta, String message) {
        this.success = success;
        this.meta = meta;
        this.message = message;
    }

    public Result(boolean success, Integer meta, String message, Object data, String jwt) {
        this.success = success;
        this.meta = meta;
        this.message = message;
        this.data = data;
        this.jwt = jwt;
    }

    public Result(boolean success, Integer meta, String message, Object data) {
        this.success = success;
        this.meta = meta;
        this.message = message;
        this.data = data;
    }

    public Result(boolean success, Integer meta, int total, String message, Object data) {
        this.success = success;
        this.meta = meta;
        this.message = message;
        this.data = data;
        this.total = total;
    }

    public Result(ResultCode code) {
        this.success = code.success;
        this.meta = code.code;
        this.message = code.message;
    }

    public Result(ResultCode code,Object data) {
        this.success = code.success;
        this.meta = code.code;
        this.message = code.message;
        this.data = data;
    }

    public Result(Integer code,String message,boolean success) {
        this.meta = code;
        this.message = message;
        this.success = success;
    }

    public static Result SUCCESS(){
        return new Result(ResultCode.SUCCESS);
    }

    public static Result ERROR(){
        return new Result(ResultCode.SERVER_ERROR);
    }

    public static Result FAIL(){
        return new Result(ResultCode.FAIL);
    }
}
