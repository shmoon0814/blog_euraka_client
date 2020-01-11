package m.s.h.blog_eureka_client.controller;

import com.netflix.ribbon.proxy.annotation.Http;
import io.swagger.annotations.*;
import m.s.h.blog_eureka_client.model.BlogPost;
import m.s.h.blog_eureka_client.model.SampleModel;
import m.s.h.blog_eureka_client.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/blog")
public class BlogController {

    BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService){
        this.blogService = blogService;
    }

    @PostMapping("/blogpost")
    public ResponseEntity<BlogPost> registBlogPost(BlogPost blogPost){
        return blogService.registBlogPost(blogPost);
    }

    @GetMapping("/blogposts")
    public ResponseEntity<List> getBlogPosts(
            HttpServletRequest request,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Integer now_page,
            @RequestParam(required = false)Integer page_size){
        return blogService.getBlogPosts(request, title, now_page, page_size);
    }

    @GetMapping("/test")
    public ResponseEntity test(HttpServletRequest request){
        return blogService.test(request);
    }

}
