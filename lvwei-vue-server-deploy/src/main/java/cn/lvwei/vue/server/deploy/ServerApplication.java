package cn.lvwei.vue.server.deploy;


import cn.hutool.core.util.ObjectUtil;
import cn.lvwei.vue.server.common.utils.LogUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;


@SpringBootApplication
@ComponentScan(basePackages = "cn.lvwei.vue.server")
@MapperScan("cn.lvwei.vue.server.core.mapper")
public class ServerApplication {
    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(ServerApplication.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = ObjectUtil.defaultIfBlank(env.getProperty("server.servlet.context-path"), "");
        LogUtil.info(STR."""
----------------------------------------------------------
\tApplication lvwei-vue-server is running! Access URLs:
\tLocal: \t\thttp://localhost:\{port}\{path}/
\tExternal: \thttp://\{ip}:\{port}\{path}/
\tSwagger文档: \thttp://\{ip}:\{port}\{path}/doc.html
----------------------------------------------------------""");
    }
}
