package com.vilai.quote.service;

import com.vilai.quote.clients.aeroai.AeroAIClient;
import com.vilai.quote.clients.aeroai.model.Response;
import com.vilai.quote.models.Item;
import com.vilai.quote.models.QuoteInitRequest;
import com.vilai.quote.models.QuoteInitResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AeroAIService implements QuoteInitializationService {
	@Autowired
	private AeroAIClient aeroAIClient;
	
	@Override
	public QuoteInitResponse initializeQuote(QuoteInitRequest request) throws Exception {
		aeroAIClient.init();
		Response response = aeroAIClient.getResponse(request);
		QuoteInitResponse quoteInitResponse = new QuoteInitResponse();
		quoteInitResponse.setExplanation(response.getContent().getExplanation());
		quoteInitResponse.setContractStartDate(response.getContent().getContractStartDate());
		quoteInitResponse.setContractEndDate(response.getContent().getContractEndDate());
		quoteInitResponse.setCompanyName(request.getCompanyName());
		quoteInitResponse.setCustomerName(request.getCustomerName());
		quoteInitResponse.setCustomerEmail(request.getCustomerEmail());
		List<Item> items = new ArrayList<>();
		for(Response.Item item : response.getContent().getItems()){
			items.add(convert(item));
		}
		quoteInitResponse.setItems(items);
		
		return quoteInitResponse;
	}

	private Item convert(Response.Item aeroAIItem) {
			Item item = new Item();
			item.setName(aeroAIItem.getName());
			item.setItemPriceCode(aeroAIItem.getItemPriceCode());
			item.setBillingFrequency(aeroAIItem.getBillingFrequency());
			item.setCurrencyCode(aeroAIItem.getCurrencyCode());
			item.setDateFrom(aeroAIItem.getDateFrom());
			item.setDateTo(aeroAIItem.getDateTo());
			item.setPrice(aeroAIItem.getPrice());
			return item;
	}
}
