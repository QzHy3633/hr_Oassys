package com.hr.mapper;

import com.hr.entity.AoaTypeList;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AoaTypeListMapper {
    long countByExample(AoaTypeListExample example);

    int deleteByExample(AoaTypeListExample example);

    int deleteByPrimaryKey(Long typeId);

    int insert(AoaTypeList record);

    int insertSelective(AoaTypeList record);

    List<AoaTypeList> selectByExample(AoaTypeListExample example);

    AoaTypeList selectByPrimaryKey(Long typeId);

    int updateByExampleSelective(@Param("record") AoaTypeList record, @Param("example") AoaTypeListExample example);

    int updateByExample(@Param("record") AoaTypeList record, @Param("example") AoaTypeListExample example);

    int updateByPrimaryKeySelective(AoaTypeList record);

    int updateByPrimaryKey(AoaTypeList record);
}