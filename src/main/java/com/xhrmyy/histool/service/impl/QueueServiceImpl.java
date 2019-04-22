package com.xhrmyy.histool.service.impl;

import com.xhrmyy.histool.common.BaseResult;
import com.xhrmyy.histool.entity.QueueInfo;
import com.xhrmyy.histool.repository.QueueRepository;
import com.xhrmyy.histool.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("queueService")
public class QueueServiceImpl implements QueueService {

    @Autowired
    private QueueRepository queueRepository;
    @Override
    public BaseResult getQueueList(String office, String room) {

        BaseResult baseResult = new BaseResult();
        try {
            Sort sort = new Sort(Sort.Direction.ASC, "sn");
            List<QueueInfo> queueInfoList = queueRepository.findByOfficeAndRoomAndStatusAndCallTime(office, room, 0, null, sort);
            baseResult.setData(queueInfoList);
        }catch (Exception e){
            e.printStackTrace();

        }
        return baseResult;
    }
}
