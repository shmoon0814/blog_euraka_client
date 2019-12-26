package m.s.h.blog_eureka_client.service;

import m.s.h.blog_eureka_client.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

    @Autowired
    BlogPostRepository blogPostRepository;

}
