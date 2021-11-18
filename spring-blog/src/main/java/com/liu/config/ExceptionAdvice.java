package com.liu.config;

import com.liu.exception.AppException;
import com.liu.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class ExceptionAdvice {

    @ExceptionHandler(AppException.class)
    @ResponseBody
    public Object handle(AppException e){
        log.debug("自定义异常", e);
        Response resp = new Response();
        resp.setCode(e.getCode());
        resp.setMsg(e.getMessage());
        return resp;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handle(Exception e){
        log.error("非自定义异常", e);
        Response resp = new Response();
        resp.setCode("ERR000");
        resp.setMsg("未知错误，请联系管理员");
        return resp;
    }
}
