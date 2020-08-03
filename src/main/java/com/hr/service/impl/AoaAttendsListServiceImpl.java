package com.hr.service.impl;

import com.hr.entity.AoaAttendsList;
import com.hr.mapper.AoaAttendsListMapper;
import com.hr.service.AoaAttendsListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AoaAttendsListServiceImpl implements AoaAttendsListService{

    @Autowired
    private AoaAttendsListMapper aoaAttendsListMapper;

    @Override
    @Transactional
    public List<AoaAttendsList> querylistaoaattend() {
        return aoaAttendsListMapper.querylistaoaattend();
    }
}
