package com.example.loggers.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HelloService {

    public String hello(){

        log.trace("TRACE: HelloService log");
        log.debug("DEBUG: HelloService log");
        log.info("INFO: HelloService log");
        log.warn("WARN: HelloService log");
        log.error("ERROR: HelloService log");
//        int i = 10/0;
        return "Hello";
    }
}
