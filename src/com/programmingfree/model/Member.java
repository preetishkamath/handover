package com.programmingfree.model;

public class Member {

	private int id;
	private String first_name;
	private String last_name;	
	private String email;
	private String uname ;
	private String pass;
	private String status;
	private String type;
	private String admin;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", email=" + email + ", uname="
				+ uname + ", pass=" + pass + ", status=" + status + ", type="
				+ type + ", admin=" + admin + "]";
	}
	
	
	
	
	
	
	
	
	
}
