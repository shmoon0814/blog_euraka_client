package m.s.h.blog_eureka_client.service;

import m.s.h.blog_eureka_client.model.Category;
import m.s.h.blog_eureka_client.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
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

    /**
    * @Param user_id = 유져 키값
    * */
    public ResponseEntity getUserCategory(String display_name){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));    //Response Header to UTF-8

        UriComponents builder = UriComponentsBuilder.fromHttpUrl("27.96.135.235:8760/auth/v1/getUserIdDisplayName")
                .queryParam("display_name", display_name)
                .build(false);    //자동으로 encode해주는 것을 막기 위해 false
        Object response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, new HttpEntity<String>(headers), String.class);

        System.out.println(response);
        List<Category> categoryList = categoryRepository.getCategoriesByUser_id(response.toString());

        return new ResponseEntity(categoryList, HttpStatus.OK);
    }

}
