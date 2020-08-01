package com.hr.mapper;


import com.hr.entity.AoaAttendsList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AoaAttendsListMapper {

    @Select("Select * from aoa_attends_list")
    public List<AoaAttendsList> querylistaoaattend();

}