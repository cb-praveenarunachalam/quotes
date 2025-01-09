package com.vilai.quote.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vilai.quote.models.QuotePromptResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class QuotePromptResponseMapper {

    public static QuotePromptResponse convertJsonToQuotePromptResponse(String json) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode rootNode = objectMapper.readTree(json);

        JsonNode firstElement = rootNode.get(0);

        JsonNode contentNode = firstElement.path("content");

        JsonNode outputVariableNode = contentNode.path("output_variable_name_1");

        JsonNode itemNode = outputVariableNode.get(0);

        QuotePromptResponse quotePromptResponse = new QuotePromptResponse();

        quotePromptResponse.setExplanation(itemNode.path("reason").asText());

        quotePromptResponse.setContractStartDate(parseDate(itemNode.path("from_date").asText()));
        quotePromptResponse.setContractEndDate(parseDate(itemNode.path("to_date").asText()));


        return quotePromptResponse;
    }

    private static long parseDate(String dateString) {
        try {
            // Convert date string (e.g., "2023-07-01") to long timestamp
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(dateString).getTime();
        } catch (ParseException e) {
            throw new RuntimeException("Error parsing date", e);
        }
    }
}
