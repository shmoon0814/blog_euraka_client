package m.s.h.blog_eureka_client.repository;

import m.s.h.blog_eureka_client.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "SELECT c FROM Category c WHERE c.user_id = :user_id")
    List<Category> getCategoriesByUser_id(@Param("user_id") String user_id);

}
