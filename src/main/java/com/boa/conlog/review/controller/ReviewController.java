package com.boa.conlog.review.controller;

import com.boa.conlog.review.model.dto.ReviewDTO;
import com.boa.conlog.review.model.service.ReviewService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    /* check. 컨텐츠 상세조회 페이지에서 리뷰를 같이 본다면, 해당 컨텐츠코드로 필터 조회 필요 -> 컨텐츠컨트롤러에서 조회? */
    @GetMapping("/reviewPage")
    public String reviewPage(Model model) {
        List<ReviewDTO> reviews = reviewService.findAllReview();
        model.addAttribute("reviews", reviews);
        return "review/reviewPage";
    }

    @PostMapping("/regist")
    public String registReview(
        ReviewDTO newReview,
        int memberNo,
        int contentsNo,
        RedirectAttributes rttr) {

        reviewService.registNewReview(newReview, memberNo, contentsNo);
        rttr.addFlashAttribute("successMessage", "리뷰가 등록되었습니다!");
        return "redirect:/review/reviewPage";
    }

    @PostMapping("/edit")
    public String updateReview(ReviewDTO updateReview, RedirectAttributes rttr) {
        reviewService.updateReview(updateReview);
        rttr.addFlashAttribute("successMessage", "리뷰가 수정되었습니다.");
        return "redirect:/review/reviewPage";
    }

    @GetMapping("/delete/{reviewNo}")
    public String deleteReview(@PathVariable("reviewNo") int reviewNo, RedirectAttributes rttr) {
        reviewService.deleteReviewByReviewNo(reviewNo);
        rttr.addFlashAttribute("successMessage", "리뷰가 삭제되었습니다.");
        return "redirect:/review/reviewPage";
    }

}
