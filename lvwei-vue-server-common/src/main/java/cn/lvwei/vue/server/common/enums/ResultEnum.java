package cn.lvwei.vue.server.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultEnum {
    OK(1, "成功"),
    SYS_ERROR(-1, "系统异常"),
    PARAM_ERROR(-5, "参数错误"),
    NOT_FOUND_ERROR(-10, "订单不存在");
    private final Integer code;
    private final String msg;
}
