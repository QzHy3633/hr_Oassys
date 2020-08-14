package com.hr.service.impl;

import com.hr.entity.AoaAttendsList;
import com.hr.entity.AoaStatusList;
import com.hr.mapper.AoaAttendsListMapper;
import com.hr.service.AoaAttendsListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Service
public class AoaAttendsListServiceImpl implements AoaAttendsListService{

    @Autowired
    private AoaAttendsListMapper aoaAttendsListMapper;

    @Override
    @Transactional
    public List<AoaAttendsList> querylistaoaattend() {
        return aoaAttendsListMapper.querylistaoaattend();
    }

    @Override
    public int countaoaendslist() {
        return aoaAttendsListMapper.countaoaendslist();
    }

    @Override
    public AoaAttendsList queryid(int aid) {
        return aoaAttendsListMapper.queryid(aid);
    }

    @Override
    public List<AoaAttendsList> likeaoa(AoaAttendsList aoaAttendsList) {
        return aoaAttendsListMapper.likeaoa(aoaAttendsList);
    }

    @Override
    public List<AoaAttendsList> queryweeklyreport() {
        return aoaAttendsListMapper.queryweeklyreport();
    }

    @Override
    public void updaoalist(AoaAttendsList aoaAttendsList) {
        aoaAttendsListMapper.updaoalist(aoaAttendsList);
    }

    @Override
    public List<AoaStatusList> querystatu() {
        return aoaAttendsListMapper.querystatu();
    }

    @Override
    public List<AoaAttendsList> queraoatime(Date start, Date end) {
        return aoaAttendsListMapper.queraoatime(start, end);
    }

    @Override
    public List<AoaAttendsList> queryaoaliebiao() {
        return aoaAttendsListMapper.queryaoaliebiao();
    }

    @Override
    public List<AoaAttendsList> querylikename(AoaAttendsList aoaAttendsList) {
        return aoaAttendsListMapper.querylikename(aoaAttendsList);
    }

    @Override
    public List<AoaAttendsList> queryyue() {
        return aoaAttendsListMapper.queryyue();
    }

    @Override
    public int deleaoa(int aid) {
        return aoaAttendsListMapper.deleaoa(aid);
    }
}
