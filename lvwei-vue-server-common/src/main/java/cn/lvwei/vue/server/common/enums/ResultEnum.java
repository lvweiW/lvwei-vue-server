package cn.lvwei.vue.server.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultEnum implements BaseEnum {
    OK(1, "成功"),
    SYS_ERROR(-1, "系统异常"),
    BIZ_ERROR(-3, "业务异常"),
    PARAM_ERROR(-5, "参数错误"),
    NOT_FOUND_ERROR(-10, "订单不存在");

    private final Integer code;
    private final String msg;

    public BaseEnum newMsg(String msg) {
        Integer code = this.code;
        return new BaseEnum() {

            @Override
            public Integer getCode() {
                return code;
            }

            @Override
            public String getMsg() {
                return msg;
            }
        };
    }
}
