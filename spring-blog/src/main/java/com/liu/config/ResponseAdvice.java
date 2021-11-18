package com.liu.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liu.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

//@ControllerAdvice
@Slf4j
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    /**
     * 这个方法无法解决请求映射方法返回类型为Object，但是返回值为null，需要包裹统一数据格式的问题
     * 原因是SpringMVC框架在这种逻辑条件下都不会进入这个方法
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        Response resp = null;
        //如果Controller请求映射方法返回值本身就是统一数据类型，不需要再包裹
        if(body instanceof Response){
            return body;
        } else {
            resp = new Response();
            resp.setOk(true);
            resp.setData(body);
        }
        //如果返回类型为Object，返回值为String，或是返回类型是String，则需要包裹后再序列化为相同的String类型
        if(body instanceof String || returnType.getParameterType().equals(String.class)){
            try {
                response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
                return objectMapper.writeValueAsString(resp);
            } catch (JsonProcessingException e) {
                log.error("序列化响应数据失败", e);
            }
        }
        return resp;
    }
}