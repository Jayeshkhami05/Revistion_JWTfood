package com.Jayesh.Security_Service.entity;

public class LogInRequste {

	private String name;
	private String passcode;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	public LogInRequste(String name, String passcode) {
		super();
		this.name = name;
		this.passcode = passcode;
	}
	public LogInRequste() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LogInRequste [name=" + name + ", passcode=" + passcode + "]";
	}
	
	
	
}
