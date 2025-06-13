package com.boa.conlog.category.model.service;

import com.boa.conlog.category.model.dao.CategoryMapper;
import com.boa.conlog.category.model.dto.CategoryDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryMapper categoryMapper){this.categoryMapper = categoryMapper;}

    public List<CategoryDTO> findAllCategory() {
        return categoryMapper.findAllCategory();
    }

    @Transactional
    public boolean registCategory(String categoryName) {
        int result = categoryMapper.registCategory(categoryName);

        if(result > 0){
            System.out.println(result);
            return true;
        }
        else{
            return false;
        }
    }

    public CategoryDTO findOneCategory(int categoryNo) {
        return categoryMapper.findOneCategory(categoryNo);
    }

    @Transactional
    public boolean modifyCategory(CategoryDTO categoryDTO) {
        int result = categoryMapper.modifyCategory(categoryDTO);

        if(result > 0){
            return true;
        }else{
            return false;
        }
    }

    @Transactional
    public boolean deleteCategory(int categoryNo) {

        int result = categoryMapper.deleteCategory(categoryNo);

        if(result > 0){
            return true;
        }else{
            return false;
        }
    }
}
