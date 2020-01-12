package m.s.h.blog_eureka_client.service;

import m.s.h.blog_eureka_client.model.Category;
import m.s.h.blog_eureka_client.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public ResponseEntity registCategory(HttpServletRequest request, List<Category> category){

        return new ResponseEntity(category, HttpStatus.OK);
    }

}
