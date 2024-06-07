package cn.lvwei.vue.server.deploy.config;

import cn.lvwei.vue.server.common.enums.ResultEnum;
import cn.lvwei.vue.server.common.exception.BizException;
import cn.lvwei.vue.server.common.exception.NotFoundException;
import cn.lvwei.vue.server.common.model.ApiResult;
import cn.lvwei.vue.server.common.utils.LogUtil;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 统一响应处理 参数类型不匹配 异常(包括 Spring validation 抛出的异常)
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ApiResult<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        LogUtil.error("A MethodArgumentNotValidException occur:{}", e.getMessage());

        StringBuilder sb = new StringBuilder();
        for (ObjectError error : e.getBindingResult().getAllErrors()) {
            sb.append("[").append(error.getDefaultMessage()).append("] ");
        }
        return ApiResult.error(ResultEnum.PARAM_ERROR.newMsg(sb.toString()));
    }

    @ExceptionHandler({BizException.class})
    public ApiResult<Object> handleBizException(BizException e) {
        LogUtil.error("A BizException occur:{}", e.getMessage());

        return ApiResult.error(ResultEnum.BIZ_ERROR.newMsg(e.getMessage()));
    }

    @ExceptionHandler({NotFoundException.class})
    public ApiResult<Object> handleNotFoundException(NotFoundException e) {
        LogUtil.error("A NotFoundException occur:{}", e.getMessage());

        return ApiResult.error(ResultEnum.NOT_FOUND_ERROR.newMsg(e.getMessage()));
    }

    @ExceptionHandler({Exception.class})
    public ApiResult<Object> handleException(Exception e) {
        LogUtil.error("A Exception occur:{}", e);

        return ApiResult.error(ResultEnum.SYS_ERROR);
    }
}
