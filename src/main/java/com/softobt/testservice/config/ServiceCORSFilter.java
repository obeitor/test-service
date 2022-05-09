package com.softobt.testservice.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServiceCORSFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;

        String originHeader = request.getHeader("Origin");

        response.setHeader("Access-Control-Allow-Origin", originHeader);
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,origin,accept,content-type,access-control-request-method,access-control-request-headers,authorization,client-id");
        response.setHeader("Content-Security-Policy", "default-src https:");
        response.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains");
        if (!"OPTIONS".equals(request.getMethod())) {
            try {
                chain.doFilter(req, res);
            } catch (IOException | ServletException e) {
                //logger.debug(e);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
