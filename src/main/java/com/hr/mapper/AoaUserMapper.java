package com.hr.mapper;


import com.hr.entity.AoaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AoaUserMapper {


    @Select("select u.*, d.dept_name as deptName , p.name as positionName , r.role_name as roleName from \n" +
            "aoa_user u INNER JOIN aoa_role_ r on r.role_id=u.role_id \n" +
            "INNER JOIN aoa_position  p on u.position_id = p.position_id \n" +
            "INNER JOIN aoa_dept d on u.position_id = d.dept_id   where user_name = #{userName} and `password`=#{password}")
    AoaUser LoginCheck(AoaUser u);

}