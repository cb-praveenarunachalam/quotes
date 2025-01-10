package com.vilai.quote.models;

public class Item {
	private String name;
	private String itemPriceCode;
	private long dateFrom;
	private long dateTo;
	private String currencyCode;
	private String billingFrequency;
	private long price = 1;
	private int quantity;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getItemPriceCode() {
		return itemPriceCode;
	}
	
	public void setItemPriceCode(String itemPriceCode) {
		this.itemPriceCode = itemPriceCode;
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
	
	public long getPrice() {
		return price;
	}
	
	public void setPrice(long price) {
		this.price = price;
	}
}
