package m.s.h.blog_eureka_client.controller;

import io.swagger.annotations.*;
import m.s.h.blog_eureka_client.model.BlogPost;
import m.s.h.blog_eureka_client.model.Category;
import m.s.h.blog_eureka_client.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(tags = "카테고리 컨트롤러")
@RestController
@RequestMapping("/blog")
public class CategoryController {

    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }


    @ApiOperation(value = "카테고리 등록 api")
    @PostMapping("/registCategory")
    public ResponseEntity registCategory(HttpServletRequest request, List<Category> category){
        return categoryService.registCategory(request, category);
    }

}
