package com.shan.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
@Mapper
public interface TestMapper {

   int  updateById(HashMap param);

}
