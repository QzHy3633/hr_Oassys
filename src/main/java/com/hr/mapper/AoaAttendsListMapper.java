package com.hr.mapper;

import com.hr.entity.AoaAttendsList;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.hr.entity.AoaDept;
import com.hr.entity.AoaStatusList;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AoaAttendsListMapper {

        //查询考勤状态全部信息
        @Select("select t.status_name,y.type_name,t.status_color, u.user_name, a.* from aoa_attends_list a\n" +
                "\n" +
                "LEFT JOIN aoa_status_list t on a.status_id = t.status_id\n" +
                "\n" +
                "LEFT JOIN aoa_type_list y on a.type_id = y.type_id\n" +
                "\n" +
                "LEFT JOIN aoa_user u on a.attends_user_id = u.user_id  LIMIT 0,10")
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

        //查询每周的报表数据
        @Select("select d.dept_name,u.user_name,t.type_name,a.* from aoa_attends_list a\n" +
                "\n" +
                "LEFT JOIN aoa_user u on a.attends_user_id = u.user_id\n" +
                "\n" +
                "LEFT JOIN aoa_dept d on d.dept_id = u.dept_id\n" +
                "\n" +
                "LEFT JOIN  aoa_type_list t on t.type_id = a.type_id\n" +
                "\n" +
                "where attends_time BETWEEN #{start} AND #{end} ORDER BY attends_time ASC")
        List<AoaAttendsList> queraoatime(Date start , Date end);

        //考勤周报表关键字查询-用户名字
        @Select("select d.dept_name,u.user_name,t.type_name,a.* from aoa_attends_list a\n" +
                "\n" +
                "LEFT JOIN aoa_user u on a.attends_user_id = u.user_id\n" +
                "\n" +
                "LEFT JOIN aoa_dept d on d.dept_id = u.dept_id\n" +
                "\n" +
                "LEFT JOIN  aoa_type_list t on t.type_id = a.type_id\n" +
                "\n" +
                "WHERE u.user_name like concat('%',#{userName},'%') LIMIT 0,5;")
        List<AoaAttendsList> querylikename(AoaAttendsList aoaAttendsList);
//===========================================================================================================================================
        //查询考勤列表
        @Select("select t.status_name,y.type_name,t.status_color, a.* from aoa_attends_list a\n" +
                "\n" +
                "LEFT JOIN aoa_status_list t on a.status_id = t.status_id\n" +
                "\n" +
                "LEFT JOIN aoa_type_list y on a.type_id = y.type_id LIMIT 0,10")
        List<AoaAttendsList> queryaoaliebiao();
//===========================================================================================================================================

        //查询月报表+分组统计
        @Select("select \n" +
                "\n" +
                "d.dept_name,u.user_name,t.status_name,a.status_id,a.attends_time,\n" +
                "\n" +
                "sum(CASE status_name WHEN \"早退\" THEN 1 ELSE 0 END) AS \"zt\",\n" +
                "sum(CASE status_name WHEN \"正常\" THEN 1 ELSE 0 END) AS \"zc\" ,\n" +
                "sum(CASE status_name WHEN \"迟到\" THEN 1 ELSE 0 END) AS \"cd\" ,\n" +
                "sum(CASE status_name WHEN \"请假\" THEN 1 ELSE 0 END) AS \"qj\",\n" +
                "sum(CASE status_name WHEN \"出差\" THEN 1 ELSE 0 END) AS \"cc\" ,\n" +
                "sum(CASE status_name WHEN \"旷工\" THEN 1 ELSE 0 END) AS \"kg\"\n" +
                "\n" +
                "\n" +
                "from aoa_attends_list a\n" +
                "\n" +
                "LEFT JOIN aoa_user u on a.attends_user_id = u.user_id\n" +
                "\n" +
                "LEFT JOIN aoa_dept d on d.dept_id = u.dept_id\n" +
                "\n" +
                "LEFT JOIN aoa_status_list t on a.status_id = t.status_id\n" +
                "\n" +
                "GROUP BY user_name")
        List<AoaAttendsList> queryyue();
}