package com.wa.controller.interceptor;

import com.wa.common.Const;
import com.wa.pojo.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginIntercptor extends HandlerInterceptorAdapter{
    //定义可以被拦截器忽略的访问的路径
    private static final String[] IGNORE_URI = {"/","/redirect","*.do"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        /*
         * 验证 URL 是否在允许通过的路径中，如果没有那就 interceptor返回false，阻止这个路径的访问
         *
         */
        boolean flag = false;
        String uri = request.getRequestURI().toString();
        for(String str:IGNORE_URI){
            if(uri.contains(str)){
                flag = true;break;
            }
        }

        if(!flag){
            User user = (User) request.getSession().getAttribute(Const.CURRENT_USER);
            if (user != null) {
                flag = true;
            }else{
                response.sendRedirect("/");
                return flag;
            }
        }
        System.out.println(flag);
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
