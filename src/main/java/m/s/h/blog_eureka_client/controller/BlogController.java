package m.s.h.blog_eureka_client.controller;

import m.s.h.blog_eureka_client.model.BlogPost;
import m.s.h.blog_eureka_client.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    BlogService blogService;

    @PostMapping("/blogpost")
    public ResponseEntity<BlogPost> registBlogPost(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
