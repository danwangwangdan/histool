package com.xhrmyy.histool.repository;

import com.xhrmyy.histool.entity.QueueInfo;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface QueueRepository extends JpaRepository<QueueInfo, Long> {

    List<QueueInfo> findByOfficeAndRoomAndStatusAndCallTime(String office, String room, int status, Date callTime, Sort sort);


}
