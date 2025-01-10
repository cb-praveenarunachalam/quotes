package com.vilai.quote.models;

public class QuoteInitRequest {

	private long contractStartDate;
	private long contractEndDate;
	
	private long tcv;
	
	private String prompt;
	
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
