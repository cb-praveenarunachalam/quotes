package com.vilai.quote.models;

public class QuoteInitRequest {
	private String companyName;
	private String customerName;
	private String customerEmail;
	private long contractStartDate;
	private long contractEndDate;
	private long tcv;
	private String prompt;

	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerEmail() {
		return customerEmail;
	}
	
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
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

public String getPrompt() {
		return prompt;
	}
	
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
}
