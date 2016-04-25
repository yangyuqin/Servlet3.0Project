package com.yyq.servlet3.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * Created by gao on 16-4-14.
 */

@WebFilter(servletNames = {"servlet3filterannotation"}, filterName = "characterFilter",
        initParams = {@WebInitParam(name = "encoding", value = "UTF-8")})


public class Servlet3FilterAnnotation implements Filter {
    private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获取此Filter的初始参数的值
        String encoding = filterConfig.getInitParameter("encoding");
        System.out.println(encoding);
        //设置请求数据的编码方式
        servletRequest.setCharacterEncoding(encoding);
        //把请求和响应对象传给过滤链中的下一个要调用的过滤器或Servlet
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        //空
    }
}
