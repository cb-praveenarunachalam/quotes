package com.vilai.quote.models;

import java.util.List;

public class QuoteCreateRequest {
	private String customerId;
	private long contractStartDate;
	private long contractEndDate;
	private List<Item> items;

	public String getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
}
