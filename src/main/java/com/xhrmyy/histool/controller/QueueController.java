package com.xhrmyy.histool.controller;


import com.xhrmyy.histool.common.BaseResult;
import com.xhrmyy.histool.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/queue")
public class QueueController {

    @Autowired
    private QueueService queueService;

    @RequestMapping("/list")
    private BaseResult getQueueList(@RequestParam String office, @RequestParam String room, @RequestParam String ca) {


        return queueService.getQueueList(office, room);
    }
}
