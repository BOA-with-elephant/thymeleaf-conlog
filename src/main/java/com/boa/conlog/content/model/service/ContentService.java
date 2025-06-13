package com.boa.conlog.content.model.service;

import com.boa.conlog.content.model.dao.ContentMapper;
import com.boa.conlog.content.model.dto.CategoryDTO;
import com.boa.conlog.content.model.dto.ContentAndCategoryDTO;
import com.boa.conlog.content.model.dto.ContentDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContentService {

    private ContentMapper contentMapper;

    ContentService(ContentMapper contentMapper){
        this.contentMapper = contentMapper;
    }

    public List<ContentDTO> selectAllContent() {
        return contentMapper.selectAllContent();
    }

    @Transactional
    public void deleteContent(int no) {
        contentMapper.deleteContent(no);
    }

    @Transactional
    public void modifyContent(ContentDTO content) {
        contentMapper.modifyContent(content);
    }

    public ContentAndCategoryDTO selectContentByNo(int no) {
        return contentMapper.selectContentByNo(no);
    }

    public ContentDTO getContent(int no) {
        return contentMapper.getContent(no);
    }

    @Transactional
    public void createContent(ContentDTO newContent) {
        contentMapper.createContent(newContent);
    }

    public List<CategoryDTO> findAllCategory() {
        return contentMapper.findAllCategory();
    }
}
