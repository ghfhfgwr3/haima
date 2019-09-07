package com.ruoyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * 启动程序
 *
 * @author ruoyi
 */

@EnableTransactionManagement
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

public class RuoYiApplication {
    @Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager) {
        System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
        return new Object();
    }

    public static void main(String[] args) {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(RuoYiApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  金海马启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                "海纳百川-------------有容乃大---------" +
                "壁立千仞--------------无欲则刚"
        );
    }
}