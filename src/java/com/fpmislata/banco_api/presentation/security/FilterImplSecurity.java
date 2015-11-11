package com.fpmislata.banco_api.presentation.security;

import com.fpmislata.banco_service.security.Authorization;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author PEDRO DEL BARRIO
 */
public class FilterImplSecurity implements Filter {

    @Autowired
    private WebSessionProvider webSessionProvider;
    @Autowired
    private Authorization authorization;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext.getAutowireCapableBeanFactory();
        autowireCapableBeanFactory.autowireBean(this);

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        WebSession webSession = webSessionProvider.getWebSession(httpServletRequest, httpServletResponse);
        if (authorization.isAuthorizedURL(webSession.getUsuario(), httpServletRequest.getRequestURI(), httpServletRequest.getMethod())) {

        } else {

        }
    }

    @Override
    public void destroy() {

    }

}
