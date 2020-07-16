package com.luv2code.web.customer;

public class Store {
	private int storeId;
	private String storeName;
	private String storeAddress;
	
	
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	
	
	public Store(int storeId, String storeName, String storeAddress) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.storeAddress = storeAddress;

	}
	public Store(String storeName, String storeAddress) {
		super();
		this.storeName = storeName;
		this.storeAddress = storeAddress;
	}
	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", storeName=" + storeName + ", storeAddress=" + storeAddress + "]";
	}
	
	
}
