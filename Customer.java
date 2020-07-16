package com.luv2code.web.customer;

public class Customer {
	private int customerId;
	private String customerFirstName;
	private String customerLastName;
	private String customerAddress;
	
	
	public Customer(int customerId, String customerFirstName, String customerLastName, String customerAddress) {
		super();
		this.customerId = customerId;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerAddress = customerAddress;
	}


	public Customer(String customerFirstName, String customerLastName, String customerAddress) {
		super();
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerAddress = customerAddress;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getCustomerFirstName() {
		return customerFirstName;
	}


	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}


	public String getCustomerLastName() {
		return customerLastName;
	}


	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}


	public String getCustomerAddress() {
		return customerAddress;
	}


	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerFirstName=" + customerFirstName + ", customerLastName="
				+ customerLastName + ", customerAddress=" + customerAddress + ", getCustomerId()=" + getCustomerId()
				+ ", getCustomerFirstName()=" + getCustomerFirstName() + ", getCustomerLastName()="
				+ getCustomerLastName() + ", getCustomerAddress()=" + getCustomerAddress() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	

}
