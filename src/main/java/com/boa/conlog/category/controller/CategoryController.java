package com.boa.conlog.category.controller;

import com.boa.conlog.category.model.dto.CategoryDTO;
import com.boa.conlog.category.model.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){ this.categoryService = categoryService;}

    // Category List View
    @GetMapping("/list")
    public String getCategory(Model model){

        List<CategoryDTO> categoryList = categoryService.findAllCategory();
        model.addAttribute("categoryList", categoryList);

        return "category/list";  // templates/category/list.html
    }

    // Select CRUD Job
    @GetMapping("/list/selected")
    public String selectJob(@RequestParam String operation, Model model){

        List<CategoryDTO> categoryList = categoryService.findAllCategory();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("selected",operation);

        return "category/list";
    }

}
