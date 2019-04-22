package com.xhrmyy.histool.repository;

import com.xhrmyy.histool.entity.QueueInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class QueryUtil {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger log = LoggerFactory.getLogger(QueryUtil.class);

    public List<QueueInfo> getQueueInfo(String office, String room){

        String sql  ="select * from sys.view_queue_info where status = 0 and callTime is null and office=? and room=? order by sn asc";
//        PreparedStatement preparedStatement = null;
//        List<QueueInfo> queueInfoList= new ArrayList<>();
//        try {
//            preparedStatement = JdbcUtil.getConnection().prepareStatement(
//                    "");
//
//        preparedStatement.setString(1, office);
//        preparedStatement.setString(2, room);
//        ResultSet rs = preparedStatement.executeQuery();
//        while (rs.next()) {
//            QueueInfo queueInfo = new QueueInfo();
//            queueInfo.setPatientName(rs.getString("patientName"));
//            queueInfo.setOffice(rs.getString("office"));
//            queueInfo.setSn(rs.getLong("sn"));
//            queueInfo.setQueueTime(rs.getDate("queueTime"));
//            queueInfo.setRoom(rs.getString("room"));
//            log.info("查询出："+queueInfo.toString());
//            queueInfoList.add(queueInfo);
//        }
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
        return jdbcTemplate.query(sql, new Object[]{office, room}, new BeanPropertyRowMapper<>(QueueInfo.class));
    }

    public Date getLatestTime(String office, String room) {

        String sql  ="select max(callTime) callTime from sys.view_queue_info where office=? and room=?";
        return jdbcTemplate.queryForObject(sql,new Object[]{office, room}, java.sql.Date.class);
//
//        PreparedStatement preparedStatement = null;
//        Date maxCallTime = null;
//        try {
//            preparedStatement = JdbcUtil.getConnection().prepareStatement(
//                    "select max(callTime) callTime from sys.view_queue_info where office=? and room=?");
//
//            preparedStatement.setString(1, office);
//            preparedStatement.setString(2, room);
//            ResultSet rs = preparedStatement.executeQuery();
//            QueueInfo queueInfo;
//            while (rs.next()) {
//                maxCallTime = rs.getDate("callTime");
//            }
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return maxCallTime;
    }
}
