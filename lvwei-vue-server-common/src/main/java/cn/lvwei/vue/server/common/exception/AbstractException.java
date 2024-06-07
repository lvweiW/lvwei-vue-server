package cn.lvwei.vue.server.common.exception;

import lombok.Getter;

@Getter
public abstract class AbstractException extends RuntimeException {
    public Integer code;
    public String msg;

    public AbstractException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
