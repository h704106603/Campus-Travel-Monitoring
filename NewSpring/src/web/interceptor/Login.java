package web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class Login extends HandlerInterceptorAdapter{
    private static final String[] IGNORE_URL = {"/Login","/doLogin","/doRegister"};
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        boolean flag = false;
        String url = request.getRequestURL().toString();
//不拦截上面定义的路径
        for (String str : IGNORE_URL) {
            if (url.contains(str)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            
           String user = (String) request.getSession().getAttribute("username");
            if (user!= null){
                flag = true;
            }
            else{
             response.sendRedirect("Login"); 
             return false; 
            }
            
        }
        return flag;
    }
    
    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}
