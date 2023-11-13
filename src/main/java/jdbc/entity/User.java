package jdbc.entity;

public class User {
	private Integer user_id;
	private String user_name;
	private String user_email;
	private String user_password;
	private String user_pepdom;

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_pepdom() {
		return user_pepdom;
	}

	public void setUser_pepdom(String user_pepdom) {
		this.user_pepdom = user_pepdom;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_email=" + user_email
				+ ", user_password=" + user_password + ", user_pepdom=" + user_pepdom + "]";
	}

}