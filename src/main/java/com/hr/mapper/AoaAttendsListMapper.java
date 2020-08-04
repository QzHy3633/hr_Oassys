package com.hr.mapper;

import com.hr.entity.AoaAttendsList;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AoaAttendsListMapper {
        /**
         * 
         * @return
         */

        //查询考勤状态全部信息
        @Select("select u.user_name,u.user_id, a.* from aoa_attends_list a \n" +
                "\n" +
                "LEFT JOIN aoa_user u on a.attends_user_id = u.user_id LIMIT 0,10;")
        List<AoaAttendsList> querylistaoaattend();

        //统计考勤数据
        @Select("SELECT COUNT(*) FROM aoa_attends_list;")
        int countaoaendslist();

        //删除考勤数据
        //为何不考虑批量删除?
        //数据直接删除 而不是修改状态
        @Delete("Delete from aoa_attends_list where attends_id = #{aid}")
        int deleaoa(int aid);

        //点击修改查询出对应的数据 跳转到修改界面
        @Select("select u.user_name,u.user_id, a.* from aoa_attends_list a \n" +
                "\n" +
                "LEFT JOIN aoa_user u on a.attends_user_id = u.user_id \n" +
                "\n" +
                "where attends_id = #{aid}")
        AoaAttendsList queryid(int aid);

        void  updaoalist();
}