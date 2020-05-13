package com.company.businessprocess.mybatis;

import com.company.businessprocess.entity.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMybatis {
    List<CategoryEntity> findByName(@Param("name") String name);
}
