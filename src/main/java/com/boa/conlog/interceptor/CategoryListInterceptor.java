package com.boa.conlog.interceptor;

import com.boa.conlog.category.model.dto.CategoryDTO;
import com.boa.conlog.category.model.service.CategoryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Component
public class CategoryListInterceptor implements HandlerInterceptor {

    @Autowired
    CategoryService categoryService; // 의존성 주입

    // 메서드가 실행되기 전에 전체 리스트를 업로드 해야하므로 postHandler을 override 한다.
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        // 카테고리 관련 뷰로 이동할 때만 가로챈다.
        if(modelAndView != null &&
                modelAndView.getViewName() != null &&
                modelAndView.getViewName().equals("category/list")){

            // Category List 조회
            List<CategoryDTO> categoryList = categoryService.findAllCategory();
            modelAndView.addObject("categoryList", categoryList);
        }

    }
}
