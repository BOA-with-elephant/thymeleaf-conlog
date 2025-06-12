package com.boa.conlog.category.model.dao;

import com.boa.conlog.category.model.dto.CategoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<CategoryDTO> findAllCategory();
}
