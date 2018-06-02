package nuc.test.vo;

import java.util.Date;

public class registerModel {
	private int id;
	private String username;
	private String trueusername;
	private String truepassword;
	private String email;
	private String phone;
	private String password;
	private String checking;
	private String type;
	private Date date;
	
    public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

		public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
		public String getChecking() {
		return checking;
	}

	public void setChecking(String checking) {
		this.checking = checking;
	}
    
		public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTrueusername() {
		return trueusername;
	}

	public void setTrueusername(String trueusername) {
		this.trueusername = trueusername;
	}

	public String getTruepassword() {
		return truepassword;
	}

	public void setTruepassword(String truepassword) {
		this.truepassword = truepassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
