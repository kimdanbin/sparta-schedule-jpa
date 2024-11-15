package com.example.spartaschedulejpa.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

@Slf4j
public class LoginFilter implements Filter {
    private static final String[] WHITE_LIST = {"/members/signup", "/members/login"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();


        log.info("로그인 필터 로직 실행");

        // white list에 포함된 경우가 아닐때
        if (!isWhiteList(requestURI)) {
            HttpSession session = httpRequest.getSession(false);

            if (session == null || session.getAttribute("sessionKey") == null) {
                throw new RuntimeException("로그인 해주세요");
            }

            log.info("로그인에 성공했습니다.");
        }

        // 1번 경우 : white list에 등록된 url 요청이라면 chain.dofilter()호출
        // 2번 경우: white list가 아닌 경우 위 필터로직을 통과 후에 chain.doFilter() 다음 필터나 servlet 호출
        // 다음 필터가 없으면 servvlet -> controller, 다음 필터가 있으면 다음 filter 호출
        filterChain.doFilter(request, response);

    }

    private boolean isWhiteList(String reqestURI) {
        return PatternMatchUtils.simpleMatch(WHITE_LIST, reqestURI);
    }
}
