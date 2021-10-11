
public class Members {
	private int userID, partyID;
	public Members(int userID, int partyID, String password, String fnamen, String lnamen, String address, String city,
			String state, String zip, String country, String phone) {
		super();
		this.userID = userID;
		this.partyID = partyID;
		this.password = password;
		this.fnamen = fnamen;
		this.lnamen = lnamen;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.phone = phone;
	}

	public int getPartyID() {
		return partyID;
	}

	public void setPartyID(int partyID) {
		this.partyID = partyID;
	}
	private String password, fnamen, lnamen, address, city, state, zip, country,phone;
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Members() {
		super();
	}
	
	public Members(int userID, String password, String fnamen, String lnamen, String address, String city, String state,
			String zip, String country, String phone) {
		super();
		this.userID = userID;
		this.password = password;
		this.fnamen = fnamen;
		this.lnamen = lnamen;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.phone = phone;
	}
	
	public int getuserID() {
		return userID;
	}
	public void setuserID(int userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFnamen() {
		return fnamen;
	}
	public void setFnamen(String fnamen) {
		this.fnamen = fnamen;
	}
	public String getLnamen() {
		return lnamen;
	}
	public void setLnamen(String lnamen) {
		this.lnamen = lnamen;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
