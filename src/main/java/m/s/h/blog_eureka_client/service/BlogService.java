package m.s.h.blog_eureka_client.service;

import m.s.h.blog_eureka_client.model.BlogPost;
import m.s.h.blog_eureka_client.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Service
public class BlogService {

    BlogPostRepository blogPostRepository;

    @Value("${security.jwt.secret}")
    private String jwt_secret;

    @Autowired
    public BlogService(BlogPostRepository blogPostRepository){
        this.blogPostRepository = blogPostRepository;
    }

    public ResponseEntity registBlogPost(BlogPost blogPost){

        //TODO 벨리데이션 체크
        blogPostRepository.save(blogPost);
        return new ResponseEntity(blogPost, HttpStatus.OK);
    }

    public ResponseEntity getBlogPosts(HttpServletRequest request, String title, Integer now_page, Integer page_size){
        System.out.println(JwtTokenFactory.jwtDecoer(jwt_secret, request).getUserId().toString());
        return new ResponseEntity(HttpStatus.OK);
    }

    public ResponseEntity test(HttpServletRequest request){

        Enumeration<String>  value =  request.getHeaderNames();
        while (value.hasMoreElements()){
            String key = value.nextElement();
            System.out.println("header param  == " + key + " ,  value == " + request.getHeader(key));
        }

        return new ResponseEntity(HttpStatus.OK);
    }

}
