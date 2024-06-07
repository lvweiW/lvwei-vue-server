package cn.lvwei.vue.server.core.controller;


import cn.lvwei.vue.server.common.model.ApiResult;
import cn.lvwei.vue.server.core.dto.req.UserLoginReq;
import cn.lvwei.vue.server.core.dto.resp.UserLoginResp;
import cn.lvwei.vue.server.core.service.biz.UserBizService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@Tag(name = "用户相关接口", description = "用户相关接口")
public class UserController {

    @Autowired
    private UserBizService userBizService;

    @PostMapping("/login")
    @Operation(summary = "用户登录")
    public ApiResult<UserLoginResp> login(@RequestBody @Validated UserLoginReq req) {
        return ApiResult.success(userBizService.login(req));
    }
}
