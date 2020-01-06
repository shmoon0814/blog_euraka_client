package m.s.h.blog_eureka_client.repository;

import m.s.h.blog_eureka_client.model.BlogPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Integer> {
    //Page<BlogPost> findBlogPostByUser_id(@Param("user_id") Integer user_id, Pageable pageable);

}
