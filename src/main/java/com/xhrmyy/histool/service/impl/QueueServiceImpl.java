package com.xhrmyy.histool.service.impl;

import com.xhrmyy.histool.common.BaseResult;
import com.xhrmyy.histool.entity.QueueInfo;
import com.xhrmyy.histool.model.QueueResult;
import com.xhrmyy.histool.repository.QueryUtil;
import com.xhrmyy.histool.repository.QueueRepository;
import com.xhrmyy.histool.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("queueService")
public class QueueServiceImpl implements QueueService {

    @Autowired
    private QueryUtil queueUtil;

    @Override
    public BaseResult getQueueList(String office, String room) {

        BaseResult baseResult = new BaseResult();
        try {
            // 获取未处理的排队数据
            List<QueueInfo> crudeInfo = queueUtil.getQueueInfo(office, room);
            SimpleDateFormat dd = new SimpleDateFormat("HH:mm");
            // 获取最新的叫号时间
            Date latestCallTime = queueUtil.getLatestTime(office, room);
            // 设置每个叫号房间的人均等待时长，单位：分钟
            int perWaitLength = 0;
            if (office.equals("B超室")) {
                if (room.equals("1号窗口")) {
                    perWaitLength = 30;
                } else if (room.equals("2号窗口")) {
                    perWaitLength = 20;
                } else if (room.equals("3号窗口")) {
                    perWaitLength = 15;
                } else if (room.equals("4号窗口")) {
                    perWaitLength = 20;
                } else {
                    perWaitLength = 20;
                }
            } else if (office.equals("胃镜室")) {
                if (room.equals("普通胃镜")) {
                    perWaitLength = 30;
                } else if (room.equals("无痛胃镜")) {
                    perWaitLength = 20;
                } else if (room.equals("电子肠镜")) {
                    perWaitLength = 45;
                } else if (room.equals("4号窗口")) {
                    perWaitLength = 20;
                } else {
                    perWaitLength = 20;
                }
            } else if (office.equals("心电图室")) {
                perWaitLength = 20;
            } else if (office.equals("脑电图室")) {
                perWaitLength = 20;
            } else if (office.equals("DR室")) {
                perWaitLength = 20;
            } else if (office.equals("CT室")) {
                perWaitLength = 20;
            }
            // 获取第一个人的排队序号
            Long firstSn = crudeInfo.get(0).getSn();
            // 处理数据
            List<QueueResult> queueResultList = new ArrayList<>();
            for (QueueInfo queueInfo : crudeInfo) {
                QueueResult queueResult = new QueueResult();
                queueResult.setName(queueInfo.getPatientName());
                queueResult.setSn(queueInfo.getSn());
                queueResult.setFrontNo(Long.valueOf(queueInfo.getSn() - firstSn).intValue());
                queueResult.setEsTime(dd.format(new Date(perWaitLength * queueResult.getFrontNo() * 60 * 1000L + latestCallTime.getTime())));
                queueResultList.add(queueResult);
            }
            baseResult.setData(queueResultList);
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(-500);
            baseResult.setMessage("服务器异常");
        }
        return baseResult;
    }
}
