package com.boa.conlog.category.controller;

import com.boa.conlog.category.model.dto.CategoryDTO;
import com.boa.conlog.category.model.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    /* todo. categorylist를 조회하는 작업을 servlet?intersector로 묶어서 작업할 수 있게 가능한지. ✅
        그리고, Error Handler도 추가하기! ✅ */

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){ this.categoryService = categoryService;}

    // Category List View
    @GetMapping("/list")
    public void getCategory(){}

    // Select CRUD Job
    @GetMapping("/list/selected")
    public String selectJob(@RequestParam String operation, Model model){
        model.addAttribute("selected",operation);

        return "category/list";
    }

    // Create Category
    @PostMapping("/create")
    public String registCategory(String categoryName,RedirectAttributes rttr){

        if(categoryService.registCategory(categoryName)){
            rttr.addFlashAttribute("successMessage", "✅ 신규 카테고리 등록에 성공하셨습니다!");
        }else{
            rttr.addFlashAttribute("successMessage", "⚠️ 카테고리 수정이 실패하였습니다!");
        }

        return "redirect:/category/list";
    }

    // Read Category
    @GetMapping("/read")
    public String findOneCategory(@RequestParam int categoryNo, Model model){
        CategoryDTO categoryDTO =  categoryService.findOneCategory(categoryNo);
        model.addAttribute("oneCategory", categoryDTO);

        return "category/list";
    }

    // Update Category
    @PostMapping("/update")
    public String modifyCategory(CategoryDTO categoryDTO,
                                 RedirectAttributes rttr){

        if(categoryService.modifyCategory(categoryDTO)) {
            rttr.addFlashAttribute("successMessage", "✅ 카테고리 수정이 성공적으로 되었습니다!");
        }
        else{
            rttr.addFlashAttribute("successMessage", "⚠️ 카테고리 수정이 실패하였습니다!");
        }

        return "redirect:/category/list";
    }

    @PostMapping("/delete")
    public String deleteCategory(int categoryNo,
                                 RedirectAttributes rttr){

        if(categoryService.deleteCategory(categoryNo)){
            rttr.addFlashAttribute("successMessage", "✅ 카테고리가 정상적으로 삭제되었습니다. ");
        }else{
            rttr.addFlashAttribute("successMessage", "⚠️ 카테고리 삭제가 실패하였습니다!");
        }

        return "redirect:/category/list";
    }


}
