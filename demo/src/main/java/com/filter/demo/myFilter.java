package com.filter.demo;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;
@Slf4j
public class myFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("첫 필터가 생성됐어요! > <");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("==================필터 시작=====================");
        chain.doFilter(request, response);
        log.info("==================필터 종료=====================");
    }

    @Override
    public void destroy() {
        log.info("내 첫 필터가 사라집니다!");
    }
}
