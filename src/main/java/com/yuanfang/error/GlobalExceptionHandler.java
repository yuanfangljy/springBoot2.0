package com.yuanfang.error;

import org.aspectj.weaver.ast.Not;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局捕获异常通知
 * 1、捕获返回json格式
 * 2、捕获放回页面
 */

@ControllerAdvice(basePackages = "com.yuanfang.member.controller")
public class GlobalExceptionHandler {

 @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String,Object> errorResult(){
        Map<String,Object> errorResultMap=new HashMap<>();
        errorResultMap.put("errorCode","500");
        errorResultMap.put("errorMsg","全局异常，系统错误！");
        return errorResultMap;
    }


   //明要捕获的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object>  defultExcepitonHandler(HttpServletRequest request, Exception e) {
        System.out.println("=============================================");
        if(e instanceof RuntimeException) {
          //  Log.error(this.getClass(),"业务异常："+e.getMessage());
            Map<String,Object> errorResultMap=new HashMap<>();
            errorResultMap.put("errorCode","500");
            errorResultMap.put("errorMsg","全局异常，系统错误！");

            //RuntimeException businessException = (RuntimeException)e;
            return errorResultMap;
        }else if(e instanceof NoHandlerFoundException){
            System.out.println("----------------------------------------------");
            //未知错误
            Map<String,Object> errorResultMap=new HashMap<>();
            errorResultMap.put("errorCode","404");
            errorResultMap.put("errorMsg","页面不存在！");
            return errorResultMap;
        }
        return null;
    }


 @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public String noHandlerFoundException(NoHandlerFoundException e) {
        //logger.error("Not Found", e);
        return "Not Found="+e;
    }


}
