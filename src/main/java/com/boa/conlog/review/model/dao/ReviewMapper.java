package com.boa.conlog.review.model.dao;

import com.boa.conlog.review.model.dto.ReviewDTO;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {

    void registReview(ReviewDTO newReview);
    void registMemberContents(Map<String, Object> map);
    List<ReviewDTO> findAllReview();
    void updateReview(ReviewDTO updateReview);
    void deleteReview(int reviewNo);
    List<ReviewDTO> findReviewsByContentNo(int no);
    int findContentsNoByReviewNo(int reviewNo);
}
