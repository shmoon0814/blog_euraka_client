package m.s.h.blog_eureka_client.service;

import m.s.h.blog_eureka_client.model.BlogPost;
import m.s.h.blog_eureka_client.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

    @Autowired
    BlogPostRepository blogPostRepository;

    public ResponseEntity registBlogPost(BlogPost blogPost){

        //TODO 벨리데이션 체크
        blogPostRepository.save(blogPost);
        return new ResponseEntity(blogPost, HttpStatus.OK);
    }

}
