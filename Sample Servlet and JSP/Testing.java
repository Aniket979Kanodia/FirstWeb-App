//
//
//import java.io.IOException;
//import javax.servlet.Servlet;
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebServlet;
//
///**
// * Servlet implementation class Testing
// */
//@WebServlet("/Testing")
//public class Testing implements Servlet {
//
//    /**
//     * Default constructor. 
//     */
//    public Testing() {
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see Servlet#init(ServletConfig)
//	 */
//	public void init(ServletConfig config) throws ServletException {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see Servlet#destroy()
//	 */
//	public void destroy() {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see Servlet#getServletConfig()
//	 */
//	public ServletConfig getServletConfig() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	/**
//	 * @see Servlet#getServletInfo()
//	 */
//	public String getServletInfo() {
//		// TODO Auto-generated method stub
//		return null; 
//	}
//
//	/**
//	 * @see Servlet#service(ServletRequest request, ServletResponse response)
//	 */
//	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}
//
//}


//--------------------------------------------------------------------------------------------------------------------

import java.io.*;  
import javax.servlet.*;  
  
public class Testing implements Servlet{  
ServletConfig config=null;  
  
public void init(ServletConfig config){  
this.config=config;  
System.out.println("servlet is initialized");  
}  
  
public void service(ServletRequest req,ServletResponse res)  
throws IOException,ServletException{  
  
res.setContentType("text/html");  
  
PrintWriter out=res.getWriter();  
out.print("<html><body>");  
out.print("<b>Hello World</b>");  
out.print("</body></html>");  
  
}  
public void destroy(){System.out.println("servlet is destroyed");}  
public ServletConfig getServletConfig(){return config;}  
public String getServletInfo(){return "copyright 2007-1010";}  
  
} 
























