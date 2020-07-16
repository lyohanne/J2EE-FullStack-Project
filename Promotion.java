package com.luv2code.web.customer;

public class Promotion {
	private int promoId;
	private String promoStart;
	private String promoEnd;
	private double promoPercent;
	
	
	public int getPromoId() {
		return promoId;
	}
	public void setPromoId(int promoId) {
		this.promoId = promoId;
	}
	public String getPromoStart() {
		return promoStart;
	}
	public void setPromoStart(String promoStart) {
		this.promoStart = promoStart;
	}
	public String getPromoEnd() {
		return promoEnd;
	}
	public void setPromoEnd(String promoEnd) {
		this.promoEnd = promoEnd;
	}
	public double getPromoPercent() {
		return promoPercent;
	}
	public void setPromoPercent(double promoPercent) {
		this.promoPercent = promoPercent;
	}
	public Promotion(int promoId, String promoStart, String promoEnd, double promoPercent) {
		super();
		this.promoId = promoId;
		this.promoStart = promoStart;
		this.promoEnd = promoEnd;
		this.promoPercent = promoPercent;
	}
	public Promotion(String promoStart, String promoEnd, double promoPercent) {
		super();
		this.promoStart = promoStart;
		this.promoEnd = promoEnd;
		this.promoPercent = promoPercent;
	}
	@Override
	public String toString() {
		return "Promotion [promoId=" + promoId + ", promoStart=" + promoStart + ", promoEnd=" + promoEnd
				+ ", promoPercent=" + promoPercent + "]";
	}
	
	
	
	
	
}
