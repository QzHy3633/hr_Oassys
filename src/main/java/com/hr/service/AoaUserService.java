package com.hr.service;

import com.hr.entity.AoaUser;

/**
 * @ClassName：AoaUserService
 * @Description：TODO
 * @Author：HuangZhen
 * @Date 2020/8/1 15:44
 * @Versopn：1.0
 */

public interface AoaUserService {

    /**
     * @Author HuangZhen
     * @Description // 登录
     * @Date 15:45 2020/8/1
     * @Param [u]
     * @return com.hr.entity.AoaUser
     **/
    AoaUser LoginCheck(AoaUser u);

    
    
}
