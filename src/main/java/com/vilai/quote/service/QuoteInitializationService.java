package com.vilai.quote.service;

import com.vilai.quote.models.QuoteInitRequest;
import com.vilai.quote.models.QuoteInitResponse;

public interface QuoteInitializationService {
	
	QuoteInitResponse initializeQuote(QuoteInitRequest request) throws Exception;
}
