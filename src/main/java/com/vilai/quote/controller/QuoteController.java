package com.vilai.quote.controller;

import com.vilai.quote.models.*;
import com.vilai.quote.service.QuoteInitializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quote")
public class QuoteController {

	private final QuoteInitializationService quoteInitializationService;
	
	@Autowired
	public QuoteController(QuoteInitializationService quoteInitializationService) {
		this.quoteInitializationService = quoteInitializationService;
}

	@PostMapping("/init")
	public QuoteInitResponse initQuote(@RequestBody QuoteInitRequest quoteRequest) throws Exception {
		return quoteInitializationService.initializeQuote(quoteRequest);
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
