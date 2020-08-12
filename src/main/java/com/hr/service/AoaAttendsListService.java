package com.hr.service;

import com.hr.entity.AoaAttendsList;
import com.hr.entity.AoaStatusList;

import java.util.List;

public interface AoaAttendsListService {

    List<AoaAttendsList> querylistaoaattend();

    int countaoaendslist();

    int deleaoa(int aid);

    AoaAttendsList queryid(int aid);

    List<AoaAttendsList> likeaoa(AoaAttendsList aoaAttendsList);

    List<AoaStatusList> querystatu();

    void  updaoalist(AoaAttendsList aoaAttendsList);

    List<AoaAttendsList> queryweeklyreport();
}
