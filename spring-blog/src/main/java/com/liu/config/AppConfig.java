package com.liu.config;

import com.liu.config.web.RedirectLoginInterceptor;
import com.liu.config.web.RequestResponseBodyMethodProcessorWrapper;
import com.liu.config.web.UnauthorizedInterceptor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig implements WebMvcConfigurer, InitializingBean {

    @Resource
    private RequestMappingHandlerAdapter adapter;

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("api", c -> true);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //后端敏感接口拦截器，后端接口排除登陆、注册、注销，其他接口都是敏感资源
        registry.addInterceptor(new UnauthorizedInterceptor())
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/article/query")
                .excludePathPatterns("/api/user/login")
                .excludePathPatterns("/api/user/register")
                .excludePathPatterns("/api/user/logout");

        //前端敏感资源拦截器
        registry.addInterceptor(new RedirectLoginInterceptor())
                .addPathPatterns("/views/my_articles.html")
                .addPathPatterns("/views/article.html");
    }

    //之前以@ControllerAdvice+实现ResponseBodyAdvice接口，完成统一处理返回数据包装：无法解决返回值为null需要包装
    //改用现在这种方式，可以解决返回null包装为自定义类型
    @Override
    public void afterPropertiesSet() throws Exception {
        List<HandlerMethodReturnValueHandler> returnValueHandlers = adapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> handlers = new ArrayList(returnValueHandlers);
        for(int i=0; i<handlers.size(); i++){
            HandlerMethodReturnValueHandler handler = handlers.get(i);
            if(handler instanceof RequestResponseBodyMethodProcessor){
                handlers.set(i, new RequestResponseBodyMethodProcessorWrapper(handler));
            }
        }
        adapter.setReturnValueHandlers(handlers);
    }
}
