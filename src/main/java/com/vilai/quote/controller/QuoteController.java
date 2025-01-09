package com.vilai.quote.controller;

import com.vilai.quote.clients.AeroAIClient;
import com.vilai.quote.models.*;
import com.vilai.quote.services.QuotePromptResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quote")
public class QuoteController {

	@Autowired
	private AeroAIClient aeroAIClient;

	@PostMapping("/init")
	public QuotePromptResponse initQuote(@RequestBody QuotePromptRequest quoteRequest) throws Exception {
		aeroAIClient.init();
		String result = aeroAIClient.retrievePrompt(quoteRequest);
		return QuotePromptResponseMapper.convertJsonToQuotePromptResponse(result);
	}

@PostMapping("/")
public QuoteResponse createQuote(@RequestBody QuoteRequest quoteRequest) {
	
		QuoteResponse quoteResponse = new QuoteResponse();
		
		quoteResponse.setNumber(101);
		quoteResponse.setCustomerId(quoteRequest.getCustomerId());
		quoteResponse.setContractStartDate(quoteRequest.getContractStartDate());
		quoteResponse.setContractEndDate(quoteRequest.getContractEndDate());
		
		long tcv = quoteRequest.getItems().stream().mapToLong(Item::getPrice).sum();
		quoteResponse.setTcv(tcv);
		
		quoteResponse.setStatus("Open");
		
		quoteResponse.setItems(quoteRequest.getItems());
		
		return quoteResponse;
	}

	@PostMapping("/convert")
	public QuoteResponse convertToContract(@RequestBody QuoteRequest quoteRequest) {
		
		QuoteResponse quoteResponse = new QuoteResponse();
		
		quoteResponse.setNumber(101);
		quoteResponse.setCustomerId(quoteRequest.getCustomerId());
		quoteResponse.setContractStartDate(quoteRequest.getContractStartDate());
		quoteResponse.setContractEndDate(quoteRequest.getContractEndDate());
		
		long tcv = quoteRequest.getItems().stream().mapToLong(Item::getPrice).sum();
		quoteResponse.setTcv(tcv);
		
		quoteResponse.setStatus("Closed, Won");
		
		quoteResponse.setItems(quoteRequest.getItems());
		
		return quoteResponse;
	}
}
