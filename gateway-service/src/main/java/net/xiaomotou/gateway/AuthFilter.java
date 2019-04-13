package net.xiaomotou.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import net.xiaomotou.gateway.config.FilterProperties;
import net.xiaomotou.gateway.config.JwtProperties;
import net.xiaomotou.commonexception.ExceptionEnum;
import net.xiaomotou.gateway.model.User;
import net.xiaomotou.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

//@Component
public class AuthFilter extends ZuulFilter {

    @Autowired
    FilterProperties filterProperties;

    @Autowired
    JwtProperties properties;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String requestURL = request.getRequestURI();

        return isAllowPath(requestURL);
    }

    public boolean isAllowPath(String path){
        for (String allowPath : filterProperties.getAllowPaths()) {
            if(Pattern.matches(allowPath,path)){
                return false;
            }
        }
        return true;
    }


    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getHeader("token");

        if(token==null){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(ExceptionEnum.AUTH_TOKEN_ERROR.getCode());
            ctx.setResponseBody(ExceptionEnum.AUTH_TOKEN_ERROR.getMsg());
            ctx.getResponse().setCharacterEncoding("UTF-8");
            return null;
        }

        try {
            User user = JwtUtil.parseJWT(token, properties.getPriKey(), User.class);
            request.setCharacterEncoding("UTF-8");
            request.setAttribute("tokenUser",user);
        } catch (Exception e) {
            e.printStackTrace();
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(ExceptionEnum.AUTH_TOKEN_ERROR.getCode());
            ctx.setResponseBody(ExceptionEnum.AUTH_TOKEN_ERROR.getMsg());
            ctx.getResponse().setCharacterEncoding("UTF-8");
        }


        return null;
    }
}
