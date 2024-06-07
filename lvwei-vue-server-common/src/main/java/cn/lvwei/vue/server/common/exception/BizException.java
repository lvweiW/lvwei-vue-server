package cn.lvwei.vue.server.common.exception;

import cn.lvwei.vue.server.common.enums.ResultEnum;

public class BizException extends AbstractException {

    public BizException(String message) {
        super(ResultEnum.BIZ_ERROR.getCode(), message);
        this.code = ResultEnum.BIZ_ERROR.getCode();
        this.msg = ResultEnum.BIZ_ERROR.getMsg();
    }
}
