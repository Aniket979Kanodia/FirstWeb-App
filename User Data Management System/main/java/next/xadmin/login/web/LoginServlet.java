package next.xadmin.login.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import next.xadmin.login.bean.LoginBean;
import next.xadmin.login.database.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter(); 
		String userID = request.getParameter("UserID");
		int idUser = Integer.parseInt(userID);
		System.out.println(idUser); 
		String password = request.getParameter("Password");
		System.out.println(password);
		LoginBean loginBean = new LoginBean();
		loginBean.setUserID(idUser);
		loginBean.setPassword(password);
		
		LoginDao loginDao = new LoginDao();
		if(loginDao.validate(loginBean)) {
			HttpSession session= request.getSession();
			session.setAttribute("userID", userID);
			session.setMaxInactiveInterval(1);
			response.sendRedirect("loginSuccess.jsp");
		}
		else
		{
		   out.println("<script type=\"text/javascript\">");
		   out.println("alert('User or password incorrect');");
		   out.println("location='Login.jsp';");
		   out.println("</script>");
		}
	}

}
