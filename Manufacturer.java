package com.luv2code.web.customer;

public class Manufacturer {
	private int manufactId;
	private String manufactName;
	private String manufactAddress;
	
	
	
	
	public Manufacturer(String manufactName, String manufactAddress) {
		super();
		this.manufactName = manufactName;
		this.manufactAddress = manufactAddress;
	}
	public int getManufactId() {
		return manufactId;
	}
	public void setManufactId(int manufactId) {
		this.manufactId = manufactId;
	}
	public String getManufactName() {
		return manufactName;
	}
	public void setManufactName(String manufactName) {
		this.manufactName = manufactName;
	}
	public String getManufactAddress() {
		return manufactAddress;
	}
	public void setManufactAddress(String manufactAddress) {
		this.manufactAddress = manufactAddress;
	}
	public Manufacturer(int manufactId, String manufactName, String manufactAddress) {
		super();
		this.manufactId = manufactId;
		this.manufactName = manufactName;
		this.manufactAddress = manufactAddress;
	}
	@Override
	public String toString() {
		return "Manufacturer [manufactId=" + manufactId + ", manufactName=" + manufactName + ", manufactAddress="
				+ manufactAddress + "]";
	}
	
	
	
	
}
