package cn.lvwei.vue.server.core.service.biz.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.lvwei.vue.server.common.exception.BizException;
import cn.lvwei.vue.server.common.exception.NotFoundException;
import cn.lvwei.vue.server.core.dto.req.UserLoginReq;
import cn.lvwei.vue.server.core.dto.resp.UserLoginResp;
import cn.lvwei.vue.server.core.entity.User;
import cn.lvwei.vue.server.core.service.biz.UserBizService;
import cn.lvwei.vue.server.core.service.db.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBizServiceImpl implements UserBizService {

    @Autowired
    private UserService userService;

    @Override
    public UserLoginResp login(UserLoginReq req) {
        LambdaQueryWrapper<User> condition = new LambdaQueryWrapper<User>()
                .eq(User::getUserNo, req.getUserNo());
        User user = userService.getOneOpt(condition, true)
                .orElseThrow(() -> new NotFoundException("用户不存在【{}】", req.getUserNo()));
        if (ObjectUtil.isEmpty(user.getPassword())) {
            throw new BizException("用户密码错误，需要重新设置密码");
        }
        if (!user.getPassword().equals(req.getPassword())) {
            throw new BizException("用户名或密码错误");
        }
        return UserLoginResp.builder().build();
    }
}
