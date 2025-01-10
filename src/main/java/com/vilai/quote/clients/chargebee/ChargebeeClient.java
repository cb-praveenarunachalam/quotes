package com.vilai.quote.clients.chargebee;

import com.chargebee.Environment;
import com.chargebee.Result;
import com.chargebee.models.Ramp;
import com.chargebee.models.Subscription;
import com.vilai.quote.models.Item;
import com.vilai.quote.models.QuoteResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChargebeeClient {

    @Value("${client.chargebee.site_name}")
    private String siteName;

    @Value("${client.chargebee.api_key}")
    private String apiKey;


    public String createSubscriptionAndRamps(QuoteResponse quoteResponse) throws Exception {
        Subscription subscription = createSubscription(quoteResponse);
        createRamps(quoteResponse, subscription);
        return subscription.id();
    }

    public Subscription createSubscription(QuoteResponse quote) throws Exception {
        Environment.configure(siteName, apiKey);

        Long startingItemsDate = getLowestItemDate(quote.getItems());

        List<Item> startingItems = getItemsOnDate(quote.getItems(), startingItemsDate);

        Subscription.CreateWithItemsRequest createRequest = Subscription.createWithItems(quote.getCustomerId());

        for (int i = 0; i < startingItems.size(); i++) {
            Item item = startingItems.get(i);
            createRequest = createRequest
                    .subscriptionItemItemPriceId(i, item.getItemPriceCode())
                    .subscriptionItemUnitPrice(i, item.getPrice())
                    .subscriptionItemQuantity(i, item.getQuantity());
        }
        Result result = createRequest.request();
        return result.subscription();
    }

    public void createRamps(QuoteResponse quote, Subscription subscription) throws Exception {
        long startingItemsDate = getLowestItemDate(quote.getItems());
        List<Item> items = getItemsOnDate(quote.getItems(), startingItemsDate);
        for (Item item: items){
            removeItem(quote.getItems(), item.getItemPriceCode(), item.getDateFrom());
        }
        while (true) {
            if (quote.getItems().isEmpty())
                break;
            startingItemsDate = getLowestItemDate(quote.getItems());
            items = getItemsOnDate(quote.getItems(), startingItemsDate);
			for (Item item: items){
				removeItem(quote.getItems(), item.getItemPriceCode(), item.getDateFrom());
			}
            Ramp.CreateForSubscriptionRequest createForSubscriptionRequest = Ramp.createForSubscription(subscription.id())
                    .effectiveFrom(new Timestamp(startingItemsDate * 1000));
            for (int i = 0; i < items.size(); i++) {
                Item item = items.get(i);
                createForSubscriptionRequest = createForSubscriptionRequest
                        .itemsToUpdateItemPriceId(i, item.getItemPriceCode())
                        .itemsToUpdateUnitPrice(i, item.getPrice())
                        .itemsToUpdateQuantity(i, item.getQuantity());
            }
            createForSubscriptionRequest.request();
        }
    }

    private static Long getLowestItemDate(List<Item> items) {
        return items.stream()
                .map(Item::getDateFrom)
                .min(Long::compare)
                .get();
    }

    private static List<Item> getItemsOnDate(List<Item> items, Long date) {
        return items.stream()
                .filter(item -> item.getDateFrom() == date)
                .collect(Collectors.toList());
    }

    public static void removeItem(List<Item> items, String itemPriceCode, long dateFrom) {
        // Loop through the list and find the matching item
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            // Check if the item matches the condition
            if (item.getItemPriceCode().equals(itemPriceCode) && item.getDateFrom() == dateFrom) {
                items.remove(i); // Remove the item from the list at index i
                System.out.println("Removed item: " + item);
                break; // Stop after removing the first match
            }
        }
    }
}
