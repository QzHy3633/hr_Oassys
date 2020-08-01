package com.hr.service.impl;

import com.hr.entity.AoaUser;
import com.hr.mapper.AoaUserMapper;
import com.hr.service.AoaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName：AoaUserServiceImpl
 * @Description：TODO
 * @Author：HuangZhen
 * @Date 2020/8/1 15:47
 * @Versopn：1.0
 */

@Service
public class AoaUserServiceImpl implements AoaUserService {

    @Autowired
    private AoaUserMapper aoaUserMapper;

    @Override
    @Transactional
    public AoaUser LoginCheck(AoaUser u) {
        return aoaUserMapper.LoginCheck(u);
    }
}
