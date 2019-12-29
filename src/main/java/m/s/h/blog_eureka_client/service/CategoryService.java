package m.s.h.blog_eureka_client.service;

import m.s.h.blog_eureka_client.model.Category;
import m.s.h.blog_eureka_client.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public ResponseEntity registCategory(Category category){
        categoryRepository.save(category);
        return new ResponseEntity(category, HttpStatus.OK);
    }

}
