package com.tockm;

import cn.hutool.core.lang.Console;
import com.tockm.utils.IpAddressUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@MapperScan(basePackages = "com.tockm.mappers")
@EnableTransactionManagement
@EnableScheduling
@EnableAsync
@SpringBootApplication(scanBasePackages = {"com.tockm"})
public class NewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsApplication.class, args);

    }
    /**
     * 项目启动输出访问地址
     */
    @Bean
    public ApplicationRunner applicationRunner(WebServerApplicationContext context,IpAddressUtils ipAddressUtils) {
        return (ApplicationArguments args) -> {
            try {
                Console.log("===============项目启动成功 start===============");
                List<String> ipAddressList = ipAddressUtils.getIpAddressOfStartUp(context);
                ipAddressList.forEach(Console::log);
                Console.log("================项目启动成功 end================");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}
