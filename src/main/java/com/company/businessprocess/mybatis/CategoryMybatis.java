package com.company.businessprocess.mybatis;

import com.company.businessprocess.entity.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CategoryMybatis {
    //id in select = method name
    List<CategoryEntity> findByName(@Param("name") String name);
//    List<Map<String, Object>> query1(@Param("name") String name);
}
