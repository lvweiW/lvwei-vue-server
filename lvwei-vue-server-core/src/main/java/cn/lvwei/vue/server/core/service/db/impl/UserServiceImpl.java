package cn.lvwei.vue.server.core.service.db.impl;

import cn.lvwei.vue.server.core.entity.User;
import cn.lvwei.vue.server.core.mapper.UserMapper;
import cn.lvwei.vue.server.core.service.db.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2024-06-07 15:01:10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

}




