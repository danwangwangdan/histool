package com.xhrmyy.histool.controller;


import com.xhrmyy.histool.common.BaseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/queue")
public class QueueController {

    @RequestMapping("/list")
    private BaseResult getQueueList(@RequestParam String office,@RequestParam String room, @RequestParam String ca){

        return new BaseResult();
    }
}
