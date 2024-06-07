package cn.lvwei.vue.server.core.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "用户登录参数")
public class UserLoginReq {

    @Schema(description = "用户编号")
    private String userNo;

    @Schema(description = "用户密码")
    private String password;
}
