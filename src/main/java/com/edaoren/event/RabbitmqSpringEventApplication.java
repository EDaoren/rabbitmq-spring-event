package com.edaoren.event;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动程序
 *
 * @author EDaoren
 */
@MapperScan("com.edaoren.event.mapper")
@SpringBootApplication
@EnableTransactionManagement
public class RabbitmqSpringEventApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqSpringEventApplication.class, args);
    }

}
