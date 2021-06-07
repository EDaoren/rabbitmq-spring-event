package com.edaoren.event.controller;

import cn.hutool.core.date.DateUtil;
import com.edaoren.event.constants.CommonResult;
import com.edaoren.event.message.TestMessage;
import com.edaoren.event.amqp.TestAmqpEvent;
import com.edaoren.event.publisher.AmqpEventPublisher;
import com.edaoren.event.publisher.SpringEventPublisher;
import com.edaoren.event.service.TestService;
import com.edaoren.event.spring.TestSpringEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author EDaoren
 */
@RestController
@Slf4j
public class TestController {


    @Autowired
    private TestService testService;


    @PostMapping("/sendMqMsg")
    public String testAmqp() {
        try {
            CommonResult<String> commonResult = testService.testAmqp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "成功";
    }

    @PostMapping("/sendSpringMsg")
    public String testSpring() {
        CommonResult<String> commonResult = testService.testSpring();
        return "成功";
    }


}
