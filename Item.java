package com.luv2code.web.customer;

public class Item {
	private int itemId;
	private String itemCode;
	private String itemDescription;
	
	
	
	
	
	public Item(String itemCode, String itemDescription) {
		super();
		this.itemCode = itemCode;
		this.itemDescription = itemDescription;
	}
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public Item(int itemId, String itemCode, String itemDescription) {
		super();
		this.itemId = itemId;
		this.itemCode = itemCode;
		this.itemDescription = itemDescription;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemCode=" + itemCode + ", itemDescription=" + itemDescription + "]";
	}
	
	
	
	
	
}
