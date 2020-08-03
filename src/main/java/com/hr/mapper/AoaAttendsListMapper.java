package com.hr.mapper;

import com.hr.entity.AoaAttendsList;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AoaAttendsListMapper {
        /**
         * 
         * @return
         */

        @Select("select u.user_name,u.user_id, a.* from aoa_attends_list a \n" +
                "\n" +
                "LEFT JOIN aoa_user u on a.attends_user_id = u.user_id;")
        public  List<AoaAttendsList> querylistaoaattend();
}