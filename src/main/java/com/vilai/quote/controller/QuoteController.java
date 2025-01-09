package com.vilai.quote.controller;

import com.vilai.quote.models.QuotePromptRequest;
import com.vilai.quote.models.QuotePromptResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/quote")
public class QuoteController {

	@PostMapping("/init")
	public QuotePromptResponse initQuote(@RequestBody QuotePromptRequest quoteRequest) {
		QuotePromptResponse quoteResponse = new QuotePromptResponse();
		quoteResponse.setContractStartDate(quoteRequest.getContractStartDate());
		quoteResponse.setContractEndDate(quoteRequest.getContractEndDate());
		quoteResponse.setExplanation("Based on your requirements of a plan with a price of 150 and 1 feature, I suggest the following:\\\\n\\\\nBest Plan: Plan 1 at $150 with 2 features. This plan exactly matches your budget and offers an additional feature, providing better value for your money.\\\\n\\\\nSecond Best Plan: Plan 3 at $100 with 1 feature. This plan meets your feature requirement and is within your budget, but offers less value compared to Plan 1.\\\\n\\\\nWhile Plan 3 exactly matches your feature count requirement, Plan 1 is the better choice as it offers an additional feature for the same price you're willing to pay. This gives you more value for your money without exceeding your budget");
		
		QuotePromptResponse.Item item = new QuotePromptResponse.Item();
		item.setItemPriceName("Enterprise plan");
		item.setDateFrom(quoteRequest.getContractStartDate()+ 100000);
		item.setDateTo(quoteRequest.getContractEndDate() + 100001);
		item.setCurrencyCode("USD");
		item.setPeriodUnit("month");
		item.setPeriod(1);
		item.setPrice(1000);
		
		quoteResponse.setItems(Collections.singletonList(item));
		
		QuotePromptResponse.Item item2 = new QuotePromptResponse.Item();
		item2.setItemPriceName("Enterprise plan");
		item2.setDateFrom(quoteRequest.getContractEndDate() + 200001);
		item2.setDateTo(quoteRequest.getContractEndDate() + 300000);
		item2.setCurrencyCode("USD");
		item2.setPeriodUnit("month");
		item2.setPeriod(1);
		item2.setPrice(1000);
		
		List<QuotePromptResponse.Item> itemList = new ArrayList<>();
		itemList.add(item);
		itemList.add(item2);
		
		quoteResponse.setItems(itemList);
		
		return quoteResponse;
	}
}
