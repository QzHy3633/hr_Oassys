package com.hr.mapper;

import com.hr.entity.AoaAttendsList;

import java.util.List;

import com.hr.entity.AoaDept;
import com.hr.entity.AoaStatusList;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AoaAttendsListMapper {

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
        @Select("select t.status_name,y.type_name, a.* from aoa_attends_list a\n" +
                "\n" +
                "LEFT JOIN aoa_status_list t on a.status_id = t.status_id\n" +
                "\n" +
                "LEFT JOIN aoa_type_list y on a.type_id = y.type_id\n" +
                "\n" +
                "where a.attends_id = #{aid}")
        AoaAttendsList queryid(int aid);

        //获取所有考勤状态信息
        @Select("SELECT * from aoa_status_list")
        List<AoaStatusList> querystatu();

        //修改考勤信息
        @Update("UPDATE aoa_attends_list SET attends_remark = #{attendsRemark}, status_id=#{statusId}  \n" +
                "\n" +
                "WHERE attends_id= #{attendsId}")
        void  updaoalist(AoaAttendsList aoaAttendsList);

        //关键字搜索  指定用户名
        @Select("select u.user_name,u.user_id, a.* from aoa_attends_list a \n" +
                "\n" +
                "LEFT JOIN aoa_user u on a.attends_user_id = u.user_id\n" +
                "\n" +
                "where u.user_name like concat('%',#{userName},'%') LIMIT 0,5;")
        List<AoaAttendsList> likeaoa(AoaAttendsList aoaAttendsList);
//===========================================================================================================================================
        //查询周报表数据列表
        @Select("select d.dept_name,u.user_name,t.type_name,a.* from aoa_attends_list a\n" +
                "\n" +
                "LEFT JOIN aoa_user u on a.attends_user_id = u.user_id\n" +
                "\n" +
                "LEFT JOIN aoa_dept d on d.dept_id = u.dept_id\n" +
                "\n" +
                "LEFT JOIN  aoa_type_list t on t.type_id = a.type_id LIMIT 0,10")
        List<AoaAttendsList> queryweeklyreport();
}