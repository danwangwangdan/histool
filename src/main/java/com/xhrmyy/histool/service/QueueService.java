package com.xhrmyy.histool.service;

import com.xhrmyy.histool.common.BaseResult;

public interface QueueService {

    BaseResult getQueueList(String office, String room);

    BaseResult toNotify(Long pid);

}
