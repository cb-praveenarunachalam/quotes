package com.vilai.quote.models;

import java.util.List;

public class QuoteResponse {
	private long number;
	private String customerId;
	private long contractStartDate;
	private long contractEndDate;
	private long tcv;
	private String status;
	private List<Item> items;

	public long getNumber() {
		return number;
	}
	
	public void setNumber(long number) {
		this.number = number;
	}
	
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
	
	public long getTcv() {
		return tcv;
	}
	
	public void setTcv(long tcv) {
		this.tcv = tcv;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<Item> getItems() {
		return items;
	}
	
	public void setItems(List<Item> items) {
		this.items = items;
	}
}
