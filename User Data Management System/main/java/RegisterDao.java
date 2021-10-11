import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDao {
	private String dbDriver  = "com.mysql.jdbc.Driver";
	
	public String insert(Members member) {
		loadDriver(dbDriver);
		Connection con = getConnection();
		int partyCount=0;
		String result = "Data entered Successfully";
		
		String sql = "select MAX(partyId) from userlogin;";
		PreparedStatement ps; 
		try {
			ps=con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
				partyCount = rs.getInt(1);
				System.out.println(partyCount);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		String sql2 = "insert into party values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.setInt(1, partyCount+1);
			ps2.setString(2,member.getFnamen());
			ps2.setString(3,member.getLnamen());
			ps2.setString(4,member.getAddress());
			ps2.setString(5,member.getCity());
			ps2.setString(7,member.getState());
			ps2.setString(6,member.getZip());
			ps2.setString(8,member.getCountry());
			ps2.setString(9,member.getPhone());
			ps2.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result= "Error accessing party data";
		}
		

		String sql1 = "insert into userlogin values(?,?,?)";
		try {
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps1.setInt(1, member.getuserID());
			ps1.setString(2,member.getPassword());
			ps1.setInt(3,partyCount+1);
			ps1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "Error accessing userlogin";
		}
		
		
		
		return result;
	}
    	
	

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

}
