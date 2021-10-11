import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListUserDao {
	private String dbDriver  = "com.mysql.jdbc.Driver";
	private String SELECT_USER_BY_ID ="select * from party left join userlogin using(partyId) where partyid = ?; ";
	private String SELECT_ALL_USERS = "select * from party left join userlogin using(partyId);";
	private String DELETE_USER_USERLOGIN = "delete from userlogin where partyid=?;";
	private String DELETE_USER_PARTY = "delete from party where partyid=?;";
	private String UPDATE_PARTY = "update party set firstname = ? , lastname = ? ,address= ?,city = ?, state = ? , zip = ?, country = ? , phone = ?  where partyid = ?;";
	private String UPDATE_USERLOGIN = "update userlogin set username=? , password = ? where partyId =?";
	private String SEARCH_USER_F = "select * from party left join userlogin using(partyId) where firstname like ?;";
	private String SEARCH_USER_L = "select * from party left join userlogin using(partyId) where lastname like ?;";
	

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
	
	//Insert user
	public void insert(Members member) {
		loadDriver(dbDriver);
		Connection con = getConnection();
		int partyCount = 0;
		
		String sql = "select * from userlogin";
		PreparedStatement ps; 
		try {
			ps=con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				partyCount++;
			}
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
		}
	}
	
	//Select user by partyID
	public Members selectByPartyID(int partyID) {
		loadDriver(dbDriver);
		Connection con = getConnection();
		Members member = null;
		try {
			PreparedStatement ps2 = con.prepareStatement(SELECT_USER_BY_ID);
			ps2.setInt(1, partyID);
			ResultSet rs = ps2.executeQuery();
			while(rs.next()) {
				 int userID = rs.getInt("username");
				  String password = rs.getString("Password");
				  String fname = rs.getString("firstName");
				  String lname = rs.getString("lastName");
				  String address = rs.getString("address");
				  String city = rs.getString("city");
				  String state = rs.getString("state");
				  String zip = rs.getString("zip");
				  String country = rs.getString("country");
				  String phone = rs.getString("phone");
				  member = new Members(partyID,userID,password,fname,lname,address,city,state,zip,country,phone);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
	//Search User
	public List<Members> searchUsersf(String entry) {
		List<Members> members = new ArrayList<>();
		loadDriver(dbDriver);
		Connection con = getConnection();
		Members member = null;
		try {
			PreparedStatement ps2 = con.prepareStatement(SEARCH_USER_F);
			ps2.setString(1,entry + "%");
		
			ResultSet rs = ps2.executeQuery();
			while(rs.next()) {
				int partyID = rs.getInt("partyId");
				 int userID = rs.getInt("username");
				  String password = rs.getString("Password");
				  String fname = rs.getString("firstName");
				  String lname = rs.getString("lastName");
				  String address = rs.getString("address");
				  String city = rs.getString("city");
				  String state = rs.getString("state");
				  String zip = rs.getString("zip");
				  String country = rs.getString("country");
				  String phone = rs.getString("phone");
				  member = new Members(userID,partyID,password,fname,lname,address,city,state,zip,country,phone);
				  members.add(member);
			
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return members;
	}
	public List<Members> searchUsersl(String entry) {
		List<Members> members = new ArrayList<>();
		loadDriver(dbDriver);
		Connection con = getConnection();
		Members member = null;
		try {
			PreparedStatement ps2 = con.prepareStatement(SEARCH_USER_L);
			ps2.setString(1,entry + "%");
		
			ResultSet rs = ps2.executeQuery();
			while(rs.next()) {
				int partyID = rs.getInt("partyId");
				 int userID = rs.getInt("username");
				  String password = rs.getString("Password");
				  String fname = rs.getString("firstName");
				  String lname = rs.getString("lastName");
				  String address = rs.getString("address");
				  String city = rs.getString("city");
				  String state = rs.getString("state");
				  String zip = rs.getString("zip");
				  String country = rs.getString("country");
				  String phone = rs.getString("phone");
				  member = new Members(userID,partyID,password,fname,lname,address,city,state,zip,country,phone);
				  members.add(member);
			
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return members;
	}
	// select all user
	public List<Members> selectAllByPartyID() {
		List<Members> members = new ArrayList<>();
		loadDriver(dbDriver);
		Connection con = getConnection();
		Members member = null;
		try {
			PreparedStatement ps2 = con.prepareStatement(SELECT_ALL_USERS);
			ResultSet rs = ps2.executeQuery();
			while(rs.next()) {
				int partyID = rs.getInt("partyId");
				 int userID = rs.getInt("username");
				  String password = rs.getString("Password");
				  String fname = rs.getString("firstName");
				  String lname = rs.getString("lastName");
				  String address = rs.getString("address");
				  String city = rs.getString("city");
				  String state = rs.getString("state");
				  String zip = rs.getString("zip");
				  String country = rs.getString("country");
				  String phone = rs.getString("phone");
				  member = new Members(userID,partyID,password,fname,lname,address,city,state,zip,country,phone);
				  members.add(member);
			
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return members;
	}
	
	//update user
	public boolean updateuser(Members member , int partyID) {
		loadDriver(dbDriver);
		Connection con = getConnection();
		boolean success=false;
		try {
			System.out.println(member.getPartyID() + " " + member.getCity());
			PreparedStatement ps2 = con.prepareStatement(UPDATE_PARTY);
			ps2.setString(1,member.getFnamen());
			ps2.setString(2,member.getLnamen());
			ps2.setString(3,member.getAddress());
			ps2.setString(4,member.getCity());
			ps2.setString(5,member.getState());
			ps2.setString(6,member.getZip());
			ps2.setString(7,member.getCountry());
			ps2.setString(8,member.getPhone());
			ps2.setInt(9, partyID);
			success = ps2.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return success;
	}
	
	//delete user
	public boolean deleteUser(int partyID) {
		boolean success = false;
		loadDriver(dbDriver);
		Connection con = getConnection();
		try {
			PreparedStatement ps2 = con.prepareStatement(DELETE_USER_USERLOGIN);
			ps2.setInt(1, partyID);
			PreparedStatement ps3 = con.prepareStatement(DELETE_USER_PARTY);
			ps3.setInt(1, partyID);
			success = ((ps2.executeUpdate()>0) && (ps3.executeUpdate()>0));
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return success;
	}
	
	
}
