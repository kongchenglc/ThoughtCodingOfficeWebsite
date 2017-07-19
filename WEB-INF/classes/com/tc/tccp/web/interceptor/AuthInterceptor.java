//package com.tc.tccp.web.interceptor; 
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import com.tc.tccp.core.annotation.Authority;
//import com.tc.tccp.core.enumtype.AuthorityType;
//
///** 
// * @author wangpei 
// * @version 
// *创建时间：2017年3月1日 下午9:23:01 
// * 类说明 
// */
//public class AuthInterceptor extends HandlerInterceptorAdapter {
//    
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        
//        if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
//            Authority authority = ((HandlerMethod) handler).getMethodAnnotation(Authority.class); 
//            System.out.println("进入权限验证页面"+authority);
//            //url没有声明需要权限,或者声明不验证权限
//            if(authority == null || authority.authority() == AuthorityType.TOURIST)
//                return true;
//            else{ 
//            	int index = authority.authority().getIndex();
//                int authIndex = (Integer)request.getSession().getAttribute("authority");
//                if(authIndex >= index)
//                    return true;
//                else
//                {
//                    response.sendRedirect("/tccp/page/noauth");
//                    return false;
//                }       
//            }
//        }
//        else
//            return true;   
//    	 
//	
//      }
//	
//}