package com.boa.conlog.review.model.service;

import com.boa.conlog.review.model.dao.ReviewMapper;
import com.boa.conlog.review.model.dto.ReviewDTO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewMapper reviewMapper;

    public ReviewService(ReviewMapper reviewMapper) {
        this.reviewMapper = reviewMapper;
    }

    public List<ReviewDTO> findAllReview() {
        return reviewMapper.findAllReview();
    }

    public void deleteReviewByReviewNo(int reviewNo) {
        reviewMapper.deleteReview(reviewNo);
    }

    public void registNewReview(ReviewDTO newReview, int memberNo, int contentsNo) {
        reviewMapper.registReview(newReview);

        // 리뷰-회원-컨텐츠 연결 (member_contents 테이블 등록)
        Map<String, Object> map = new HashMap<>();
        map.put("reviewNo", newReview.getReviewNo());
        map.put("memberNo", memberNo);
        map.put("contentsNo", contentsNo);

        reviewMapper.registMemberContents(map);
    }

    public void updateReview(ReviewDTO updateReview) {
        reviewMapper.updateReview(updateReview);
    }

    public List<ReviewDTO> findReviewsByContentNo(int no) {
        return reviewMapper.findReviewsByContentNo(no);
    }
}
