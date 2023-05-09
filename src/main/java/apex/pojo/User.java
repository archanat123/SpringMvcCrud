package apex.pojo;



public class User {

	 private Integer id;
	 private String userid;
	 private String username;
	 private String passward;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public String getPassward() {
		return passward;
	}
	public void setPassward(String passward) {
		this.passward = passward;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userid=" + userid + ", username=" + username + ", passward=" + passward + "]";
	}
	 
	
}
