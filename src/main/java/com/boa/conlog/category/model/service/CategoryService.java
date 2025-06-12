package com.boa.conlog.category.model.service;

import com.boa.conlog.category.model.dao.CategoryMapper;
import com.boa.conlog.category.model.dto.CategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryMapper categoryMapper){this.categoryMapper = categoryMapper;}

    public List<CategoryDTO> findAllCategory() {
        return categoryMapper.findAllCategory();
    }
}
