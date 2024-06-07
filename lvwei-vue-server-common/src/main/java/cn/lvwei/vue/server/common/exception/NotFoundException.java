package cn.lvwei.vue.server.common.exception;

import cn.hutool.core.text.CharSequenceUtil;
import cn.lvwei.vue.server.common.enums.ResultEnum;

public class NotFoundException extends AbstractException {
    public NotFoundException(String message) {
        super(ResultEnum.BIZ_ERROR.getCode(), message);
        this.code = ResultEnum.NOT_FOUND_ERROR.getCode();
        this.msg = ResultEnum.NOT_FOUND_ERROR.getMsg();
    }

    public NotFoundException(String format, Object... objects) {
        super(ResultEnum.BIZ_ERROR.getCode(), CharSequenceUtil.format(format, objects));
        this.code = ResultEnum.NOT_FOUND_ERROR.getCode();
        this.msg = CharSequenceUtil.format(format, objects);
    }
}
