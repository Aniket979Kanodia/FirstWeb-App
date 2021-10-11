

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		if(request.getParameter("userID")==null) {
			response.sendRedirect("Error.jsp");
		}
		  int userID = Integer.parseInt(request.getParameter("userID"));
		  String password = request.getParameter("password");
		  String fname = request.getParameter("fname");
		  String lname = request.getParameter("lname");
		  String address = request.getParameter("address");
		  String city = request.getParameter("city");
		  String state = request.getParameter("state");
		  String zip = request.getParameter("zip");
		  String country = request.getParameter("country");
		  String phone = request.getParameter("phone");
		  
		  Members members = new Members(userID,password,fname,lname,address,city,state,zip,country,phone);
		  RegisterDao Rdo = new RegisterDao();
		  
		  
		  String result = Rdo.insert(members);
		  response.sendRedirect("Login.jsp");
   	}
}
