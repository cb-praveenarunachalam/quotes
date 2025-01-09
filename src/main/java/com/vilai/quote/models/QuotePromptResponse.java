package com.vilai.quote.models;

import java.util.List;

public class QuotePromptResponse {

	private String explanation;
	private long contractStartDate;
	private long contractEndDate;
	private List<Item> items;

	public String getExplanation() {
		return explanation;
	}
	
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public long getContractStartDate() {
		return contractStartDate;
	}
	
	public void setContractStartDate(long contractStartDate) {
		this.contractStartDate = contractStartDate;
	}
	
	public long getContractEndDate() {
		return contractEndDate;
	}
	
	public void setContractEndDate(long contractEndDate) {
		this.contractEndDate = contractEndDate;
	}
	
	public List<Item> getItems() {
		return items;
	}
	
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
public static class Item {
	private String itemPriceName;
	private long dateFrom;
	private long dateTo;
	private String currencyCode;
	private String periodUnit;
	private int period;
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
	
	public String getPeriodUnit() {
		return periodUnit;
	}
	
	public void setPeriodUnit(String periodUnit) {
		this.periodUnit = periodUnit;
	}
	
	public int getPeriod() {
		return period;
	}
	
	public void setPeriod(int period) {
		this.period = period;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
}
}
