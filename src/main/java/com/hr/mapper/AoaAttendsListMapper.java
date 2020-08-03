package com.hr.mapper;

import com.hr.entity.AoaAttendsList;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AoaAttendsListMapper {
    /*
        @Select("select u.user_name as userName,u.user_id as userId , a.* from aoa_attends_list a \n" +
                "\n" +
                "LEFT JOIN aoa_user u on a.attends_user_id = u.user_id;")*/
    @Select("select * from aoa_attends_list ")
    List<AoaAttendsList> querylistaoaattend();
}