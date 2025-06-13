package com.boa.conlog.content.model.dao;

import com.boa.conlog.content.model.dto.CategoryDTO;
import com.boa.conlog.content.model.dto.ContentAndCategoryDTO;
import com.boa.conlog.content.model.dto.ContentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContentMapper {
    List<ContentDTO> selectAllContent();

    void deleteContent(int no);

    void modifyContent(ContentDTO content);

    ContentAndCategoryDTO selectContentByNo(int no);

    ContentDTO getContent(int no);

    void createContent(ContentDTO newContent);

    List<CategoryDTO> findAllCategory();
}
