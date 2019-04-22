package com.xhrmyy.histool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by huangshiming on 2017/12/27.
 */
@SpringBootApplication
@EnableScheduling
public class HisToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(HisToolApplication.class, args);
    }
}
