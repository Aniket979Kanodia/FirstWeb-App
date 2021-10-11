package next.xadmin.login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import next.xadmin.login.bean.LoginBean;

public class LoginDao {
	
	private String dbDriver  = "com.mysql.jdbc.Driver";
	
	
	
	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
		Connection con = null;
		try {
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/partyuserdata","root","9752438758");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}
	public boolean validate(LoginBean loginBean) {
		
		loadDriver(dbDriver);
		Connection con = getConnection();
		boolean status = false;
		String sql = "select * from userlogin where username = ? AND Password = ?";
		
		PreparedStatement ps ;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, loginBean.getUserID());
			ps.setString(2, loginBean.getPassword());
		
		ResultSet rs = ps.executeQuery();
		status = rs.next();
		System.out.print(status);
//		System.out.println(rs.getString("username") + "  -  " + rs.getString("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	
	
	
			

}
