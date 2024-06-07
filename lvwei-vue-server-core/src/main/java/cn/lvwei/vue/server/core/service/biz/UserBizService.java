package cn.lvwei.vue.server.core.service.biz;

import cn.lvwei.vue.server.core.dto.req.UserLoginReq;
import cn.lvwei.vue.server.core.dto.resp.UserLoginResp;

public interface UserBizService {
    UserLoginResp login(UserLoginReq req);
}
