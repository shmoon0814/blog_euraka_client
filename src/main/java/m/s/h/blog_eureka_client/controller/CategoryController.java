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

@Api(tags = "카테고리 컨트롤러")
@RestController
@RequestMapping("/blog")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "authorization header", required = true, dataType = "string", paramType = "header", defaultValue = "bearer eyJ1c2VyVHlwZSI6IlVTRVIiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1NzY1NjMyNTgsImV4cCI6MTU3ODMxNjI5MSwiaXNzIjoibW93YV9hdXRoZW5jaWF0aW9uX3NlcnZlciJ9.ufRSIftrTW5qjS-eQJ_CRycaiPnynoJKIJrL433yt_g"),
            @ApiImplicitParam(name = "카테고리 데이터", value = "value 값 아무거나 인트형", required = true, dataTypeClass = Category.class),
    })
    @ApiOperation(value = "카테고리 등록 api")
    @ApiResponses(@ApiResponse(code = 200, message = "OK", response = Category.class))
    @PostMapping("/registCategory")
    public ResponseEntity registCategory(Category category){
        return categoryService.registCategory(category);
    }
}
