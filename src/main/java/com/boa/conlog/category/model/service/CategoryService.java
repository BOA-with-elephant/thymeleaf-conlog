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
    public void registCategory(String categoryName) {
        categoryMapper.registCategory(categoryName); // comment. 만약 추가가 안된다면? 실패한다면 어떤식으로 rollback되는지. void반환인데 결과 어케 아는지?
    }

    public CategoryDTO findOneCategory(int categoryNo) {
        return categoryMapper.findOneCategory(categoryNo);
    }

    @Transactional
    public void modifyCategory(CategoryDTO categoryDTO) {
        categoryMapper.modifyCategory(categoryDTO);
    }

    @Transactional
    public void deleteCategory(int categoryNo) {
        categoryMapper.deleteCategory(categoryNo);
    }
}
