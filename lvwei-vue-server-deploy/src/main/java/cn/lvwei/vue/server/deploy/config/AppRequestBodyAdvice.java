package cn.lvwei.vue.server.deploy.config;

import cn.lvwei.vue.server.common.utils.LogUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.lang.reflect.Type;

@ControllerAdvice
public class AppRequestBodyAdvice extends RequestBodyAdviceAdapter {

    @Autowired
    private HttpServletRequest request;

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return converterType
                .getName()
                .contains(MappingJackson2HttpMessageConverter.class.getSimpleName())
                ||
                converterType
                        .getName()
                        .contains(FastJsonHttpMessageConverter.class.getSimpleName());
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        LogUtil.info("----->>【http request】uri = {}, requestBody = {} ", request.getRequestURI(), JSON.toJSONString(body));
        return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
    }
}
