package m.s.h.blog_eureka_client.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import m.s.h.blog_eureka_client.enums.PostState;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "blog_post")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@DynamicUpdate(true)
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    @CreationTimestamp
    private Timestamp created_at;
    private PostState post_state;
    private Timestamp updated_at;
    private Integer user_id;

}
