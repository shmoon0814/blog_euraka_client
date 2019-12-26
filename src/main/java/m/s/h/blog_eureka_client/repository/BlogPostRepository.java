package m.s.h.blog_eureka_client.repository;

import m.s.h.blog_eureka_client.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Integer> {



}
