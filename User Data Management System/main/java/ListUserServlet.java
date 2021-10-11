

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListUserServlet
 */
@WebServlet(name = "ListUser", urlPatterns = { "/" })
public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ListUserDao listUserDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException{
    	listUserDao = new ListUserDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		switch(action) {
		case "/new":
			showNewForm(request,response);
			break;
		
		case "/insert":
			break;
			
		case "/delete":
			deleteUser(request,response);
			
			
		case "/edit":
			System.out.println(" lEdit called");
			showEditForm(request,response); 
			break;
			
		case "/update":
			System.out.println("lUpdate called");
			showEditForm(request,response);
			break;
			
		default:
			listUsers(request,response);
			break;
		}	
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserRegistration.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("partyID"));
		listUserDao.deleteUser(id);
		response.sendRedirect("list");
		
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("showEdit form called");
		int partyID = Integer.parseInt(request.getParameter("partyID"));
		Members existingUser;
		
		try{
			existingUser = listUserDao.selectByPartyID(partyID);
		    RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateUser.jsp");
			request.setAttribute("member", existingUser);

			//updateUser(request,response);
			dispatcher.forward(request, response);
		
		}catch(Exception e) {
			e.printStackTrace();
			
			
		}
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("update User called");
		Members member;
		int partyID = Integer.parseInt(request.getParameter("partyID"));
		 int userID = Integer.parseInt(request.getParameter("userID"));
		  String password =request.getParameter("password");
		  String fname = request.getParameter("fname");
		  String lname = request.getParameter("lname");
		  String address = request.getParameter("address");
		  String city = request.getParameter("city");
		  String state = request.getParameter("state");
		  String zip = request.getParameter("zip");
		  String country = request.getParameter("country");
		  String phone = request.getParameter("phone");
		  member = new Members(userID,partyID,password,fname,lname,address,city,state,zip,country,phone);
		  listUserDao.updateuser(member, partyID);
		  response.sendRedirect("list");
	}

	private void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			List<Members> listUsers;
			
			if(fname == null && lname == null) {
			    listUsers = listUserDao.selectAllByPartyID();}
			else if(fname==null) {
				listUsers = listUserDao.searchUsersl(lname);
			}
			else  {
				listUsers = listUserDao.searchUsersf(fname);
			}
			
			for(Members i : listUsers) {
				System.out.println(i);
			}
			request.setAttribute("listUsers", listUsers);
			RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost called");
		updateUser(request,response);
		doGet(request, response);
	}

}
