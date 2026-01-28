package com.example.loggers.controller;

import com.example.loggers.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
@Slf4j
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello(){

        log.trace("TRACE: HelloController log");
        log.debug("DEBUG: HelloController log");
        log.info("INFO: HelloController log");
        log.warn("WARN: HelloController log");
        log.error("ERROR: HelloController log");
        return helloService.hello();
    }
}
