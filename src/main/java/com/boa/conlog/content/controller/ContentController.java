package com.boa.conlog.content.controller;

import com.boa.conlog.content.model.dto.CategoryDTO;
import com.boa.conlog.content.model.dto.ContentAndCategoryDTO;
import com.boa.conlog.content.model.dto.ContentDTO;
import com.boa.conlog.content.model.service.ContentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("content")
public class ContentController {

    //build.gradle에 valid 의존성 추가함

    private final ContentService contentService;

    public ContentController(ContentService contentService){
        this.contentService = contentService;
    }

    @GetMapping("/page")
    public String enterContentPage(Model model){
        List<ContentDTO> contentList = contentService.selectAllContent();

        model.addAttribute("contentList", contentList);

        return "content/page";
    }

    @GetMapping("/delete/{no}")
    public String deleteContent(@PathVariable int no, RedirectAttributes rttr) {

        contentService.deleteContent(no);

        rttr.addFlashAttribute("deleteMessage", "삭제에 성공하였습니다.");

        return "redirect:/content/page";
    }

    @GetMapping("/detail/{no}")
    public String selectContentByNo(@PathVariable int no, Model model) {
        ContentAndCategoryDTO content = contentService.selectContentByNo(no);
        model.addAttribute("content", content);
        return "content/detail";
    }

    @GetMapping("/modify/{no}")
    public String modifyPage(@PathVariable int no, Model model) {
        ContentDTO content = contentService.getContent(no); // 기존 내용 불러오기
        model.addAttribute("content", content); // 폼에 뿌릴 내용

        return "content/modify";
    }

    @PostMapping("/modify/{no}")
    public String modifyContent(@PathVariable int no,
                                @Valid ContentDTO content,
                                RedirectAttributes rttr) {
        content.setNo(no);
        contentService.modifyContent(content);
        rttr.addFlashAttribute("modifyMessage", "수정에 성공하였습니다.");
        return "redirect:/content/page";
    }

    @GetMapping("/create")
    public void createPage() {}

    @PostMapping("/create")
    public String createContent(@Valid ContentDTO newContent,
                                RedirectAttributes rttr){
        contentService.createContent(newContent);
        rttr.addFlashAttribute("createMessage", "컨텐츠 추가에 성공하였습니다.");
        return "redirect:/content/page";
    }

    @GetMapping(value = "category", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<CategoryDTO> findCategoryList() {
        return contentService.findAllCategory();
    }

}
