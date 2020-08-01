package com.hr.mapper;


import com.hr.entity.AoaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AoaUserMapper {


    @Select("select * from aoa_user where user_name = #{userName} and `password`=#{password}")
    AoaUser LoginCheck(AoaUser u);

}