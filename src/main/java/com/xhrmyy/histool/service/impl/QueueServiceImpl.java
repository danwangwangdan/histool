package com.xhrmyy.histool.service.impl;

import com.xhrmyy.histool.common.BaseResult;
import com.xhrmyy.histool.entity.QueueInfo;
import com.xhrmyy.histool.model.QueueResult;
import com.xhrmyy.histool.repository.QueryUtil;
import com.xhrmyy.histool.service.QueueService;
import org.apache.commons.net.ntp.TimeStamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("queueService")
public class QueueServiceImpl implements QueueService {

    @Autowired
    private QueryUtil queueUtil;
    private static final Logger log = LoggerFactory.getLogger(QueueServiceImpl.class);

    @Override
    public BaseResult getQueueList(String office, String room) {

        BaseResult baseResult = new BaseResult();
        try {
            // 获取未处理的排队数据
            List<QueueInfo> crudeInfo = queueUtil.getQueueInfo(office, room);
            SimpleDateFormat dd = new SimpleDateFormat("HH:mm");
            // 获取最新的叫号时间
//            Timestamp timeStamp = queueUtil.getLatestTime(office, room);
//            Date latestCallTime = new Date();
//            latestCallTime.setTime(timeStamp.getTime());
//            long diffMin = (new Date().getTime() - latestCallTime.getTime())/(1000 * 60);
//            // 设置每个叫号房间的人均等待时长，单位：分钟
//            int perWaitLength = 0;
//            if (office.equals("B超室")) {
//                if (room.equals("1号窗口")) {
//                    perWaitLength = 30;
//                } else if (room.equals("2号窗口")) {
//                    perWaitLength = 20;
//                } else if (room.equals("3号窗口")) {
//                    perWaitLength = 15;
//                } else if (room.equals("4号窗口")) {
//                    perWaitLength = 20;
//                } else {
//                    perWaitLength = 20;
//                }
//            } else if (office.equals("内窥镜室")) {
//                if (room.equals("普通胃镜")) {
//                    perWaitLength = 30;
//                } else if (room.equals("无痛胃镜")) {
//                    perWaitLength = 20;
//                } else if (room.equals("电子肠镜")) {
//                    perWaitLength = 45;
//                }else {
//                    perWaitLength = 20;
//                }
//            } else if (office.equals("心电图室")) {
//                perWaitLength = 20;
//            } else if (office.equals("脑电图室")) {
//                perWaitLength = 20;
//            } else if (office.equals("DR室")) {
//                perWaitLength = 20;
//            } else if (office.equals("CT室")) {
//                perWaitLength = 20;
//            }
            //// 获取第一个人的排队序号
            //Long firstSn = crudeInfo.get(0).getSn();
            // 处理数据
            List<QueueResult> queueResultList = new ArrayList<>();
            for (int i = 0;i<crudeInfo.size();i++) {
                QueueResult queueResult = new QueueResult();
                queueResult.setName(crudeInfo.get(i).getPatientName());
                queueResult.setSn(crudeInfo.get(i).getSn());
                queueResult.setFrontNo(i);
                queueResult.setEsTime("");
                queueResultList.add(queueResult);
            }
            baseResult.setData(queueResultList);
        } catch (Exception e) {
            log.error(e.toString());
            baseResult.setCode(-500);
            baseResult.setMessage("服务器异常");
            return baseResult;
        }
        return baseResult;
    }
}
