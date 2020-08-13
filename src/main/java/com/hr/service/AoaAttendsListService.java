package com.hr.service;

import com.hr.entity.AoaAttendsList;
import com.hr.entity.AoaStatusList;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface AoaAttendsListService {

    List<AoaAttendsList> querylistaoaattend();

    int countaoaendslist();

    int deleaoa(int aid);

    AoaAttendsList queryid(int aid);

    List<AoaAttendsList> likeaoa(AoaAttendsList aoaAttendsList);

    List<AoaStatusList> querystatu();

    void  updaoalist(AoaAttendsList aoaAttendsList);

    List<AoaAttendsList> queryweeklyreport();

    List<AoaAttendsList> queraoatime(Date start, Date end);
}
