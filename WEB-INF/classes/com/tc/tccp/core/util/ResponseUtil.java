package com.tc.tccp.core.util; 
/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年12月29日 上午12:46:59 
 * 响应请求
 */
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
public class ResponseUtil {
	public static void write(HttpServletResponse response,Object object)throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println(object);
		out.flush();
		out.close();
	}
}
 