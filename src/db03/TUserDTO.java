package db03;

public class TUserDTO {
	//field
	private String userid;
	private String username;
	private String email;
	
	
	//Constructor
	public TUserDTO() {}
	public TUserDTO(String userid, String username, String email) {
		this.userid = userid;
		this.username = username;
		this.email = email;
	}
	
	//getter/setter
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//toString
	@Override
	public String toString() {
		return "TUser [userid=" + userid + ", username=" + username + ", email=" + email + "]";
	}

}
