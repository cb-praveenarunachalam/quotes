package com.vilai.quote.clients.aeroai.model;

import java.util.List;

public class Response {
	private String type;
	private Content content;
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Content getContent(){
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public static class Content {
		private String explanation;
		private List<Item> items;
		
		public String getExplanation() {
			return explanation;
		}
		
		public void setExplanation(String explanation) {
			this.explanation = explanation;
		}
		
		public List<Item> getItems() {
			return items;
		}
		
		public void setItems(List<Item> items) {
			this.items = items;
		}
	}

	public static class Item {
		private String name;
		private String itemPriceCode;
		private String billingFrequency;
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getItemPriceCode() {
			return itemPriceCode;
		}
		
		public void setItemPriceCode(String itemPriceCode) {
			this.itemPriceCode = itemPriceCode;
		}
		
		public String getBillingFrequency() {
			return billingFrequency;
		}
		
		public void setBillingFrequency(String billingFrequency) {
			this.billingFrequency = billingFrequency;
		}
	}
}
