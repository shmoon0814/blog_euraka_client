package m.s.h.blog_eureka_client.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import m.s.h.blog_eureka_client.enums.CategoryType;
import m.s.h.blog_eureka_client.enums.PostState;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "category")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@DynamicUpdate(true)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Integer parent_id;
    @Enumerated(EnumType.STRING)
    private CategoryType category_type;
    @CreationTimestamp
    private Timestamp created_at;
    private Integer user_id;
    private Integer order_idx;

}
