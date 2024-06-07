package cn.lvwei.vue.server.deploy.config;

import cn.lvwei.vue.server.common.utils.LogUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class AppResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Autowired
    private HttpServletRequest request;

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return converterType.getName().contains(MappingJackson2HttpMessageConverter.class.getSimpleName())
                || converterType.getName().contains(FastJsonHttpMessageConverter.class.getSimpleName());
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest serverHttpRequest, ServerHttpResponse response) {
        LogUtil.info("<<-----【http response】uri = {}, responseBody = {} ", request.getRequestURI(),
                JSONObject.toJSONString(body));
        return body;
    }
}
