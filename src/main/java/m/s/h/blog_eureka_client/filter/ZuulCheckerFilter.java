package m.s.h.blog_eureka_client.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class ZuulCheckerFilter extends OncePerRequestFilter {

    @Autowired
    public ZuulCheckerFilter(){
        log.info("ZuulCheckerFiler Init");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request.getHeader("username") == null){
            log.warn("This request is not include username || user_id");
        }
        //Zuul 에서 Routing된 값이 아니면 체크
        //TODO 이것만 있어도 줄에서 넘어온 건지 아닌지 필터링 가능한가?? x-forwarded 정보들이.. 흠.. nginx 포워딩 + zuul 포워딩이면 값이 어떻게 날라올지 걱정이다
        if(request.getHeader("x-forwarded-prefix") == null){
            response.sendError(999,"This request is not from zuul");
        }else if(!request.getHeader("x-forwarded-prefix").equals("/api/spring-cloud-blog")){
            response.sendError(998,"This request is not from zuul");
        }else{
            filterChain.doFilter(request, response);
        }

     }


}
