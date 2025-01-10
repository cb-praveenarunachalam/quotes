package com.vilai.quote.clients.chargebee;

import com.chargebee.Environment;
import com.chargebee.models.Subscription;
import com.vilai.quote.models.Item;
import com.vilai.quote.models.QuoteResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChargebeeClient {

	@Value("${client.chargebee.site_name}")
	private String siteName;

	@Value("${client.chargebee.api_key}")
	private String apiKey;

	public void createSubscription(QuoteResponse quote) throws Exception {
		Environment.configure(siteName, apiKey);

		Long startingItemsDate = quote.getItems().stream()
				.map(Item::getDateFrom)
				.min(Long::compare)
				.get();

		List<Item> startingItems = quote.getItems().stream()
				.filter(item -> item.getDateFrom() == startingItemsDate)
				.collect(Collectors.toList());

		Subscription.CreateWithItemsRequest createRequest = Subscription.createWithItems(quote.getCustomerId())
				.id(quote.getCustomerId());

		for (int i = 0; i < startingItems.size(); i++) {
			Item item = startingItems.get(i);
			createRequest = createRequest
					.subscriptionItemQuantity(i, item.getQuantity())
					.subscriptionItemUnitPrice(i, item.getPrice())
					.subscriptionItemItemPriceId(i, item.getItemPriceCode());
		}
		createRequest.request();
	}
}
