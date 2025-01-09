package com.vilai.quote.models;

public class Item {
	private String itemPriceName;
	private long dateFrom;
	private long dateTo;
	private String currencyCode;
	private String billingFrequency;
	private int price;
	
	// Getters and Setters
	public String getItemPriceName() {
		return itemPriceName;
	}
	
	public void setItemPriceName(String itemPriceName) {
		this.itemPriceName = itemPriceName;
	}
	
	public long getDateFrom() {
		return dateFrom;
	}
	
	public void setDateFrom(long dateFrom) {
		this.dateFrom = dateFrom;
	}
	
	public long getDateTo() {
		return dateTo;
	}
	
	public void setDateTo(long dateTo) {
		this.dateTo = dateTo;
	}
	
	public String getCurrencyCode() {
		return currencyCode;
	}
	
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	public String getBillingFrequency() {
		return billingFrequency;
	}
	
	public void setBillingFrequency(String billingFrequency) {
		this.billingFrequency = billingFrequency;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
}
