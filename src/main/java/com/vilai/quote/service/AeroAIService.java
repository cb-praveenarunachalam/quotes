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
		Response response = aeroAIClient.retrievePrompt(request);
		QuoteInitResponse quoteInitResponse = new QuoteInitResponse();
		quoteInitResponse.setExplanation(response.getExplanation());
		List<Item> items = new ArrayList<>();
		for(Response.Item item : response.getItems()){
			items.add(convert(item));
		}
		quoteInitResponse.setItems(items);
		//TODO: To fill ramps
		return quoteInitResponse;
	}

	private Item convert(Response.Item aeroAIItem) {
			Item item = new Item();
			item.setName(aeroAIItem.getName());
			item.setItemPriceCode(aeroAIItem.getItemPriceCode());
			return item;
	}

//	private static long parseDate(String dateString) {
//		try {
//			// Convert date string (e.g., "2023-07-01") to long timestamp
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			return sdf.parse(dateString).getTime();
//		} catch (ParseException e) {
//			throw new RuntimeException("Error parsing date", e);
//		}
//	}
}
