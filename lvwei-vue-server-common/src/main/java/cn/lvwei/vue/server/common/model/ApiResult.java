package cn.lvwei.vue.server.common.model;

import cn.lvwei.vue.server.common.enums.BaseEnum;
import cn.lvwei.vue.server.common.enums.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResult<T> {

    private Integer code;

    private String msg;

    private T data;

    public static <T> ApiResult<T> success() {
        return new ApiResult<>(ResultEnum.OK.getCode(), ResultEnum.OK.getMsg(), null);
    }

    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(ResultEnum.OK.getCode(), ResultEnum.OK.getMsg(), data);
    }

    public static <T> ApiResult<T> error(BaseEnum baseEnum) {
        return new ApiResult<>(baseEnum.getCode(), baseEnum.getMsg(), null);
    }
}
