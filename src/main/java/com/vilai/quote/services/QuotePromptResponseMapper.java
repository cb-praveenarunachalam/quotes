package com.vilai.quote.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vilai.quote.models.AeroAIResult;
import com.vilai.quote.models.QuotePromptResponse;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class QuotePromptResponseMapper {

    public static QuotePromptResponse convertJsonToQuotePromptResponse(String json) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(json, new TypeReference<List<AeroAIResult>>(){}).get(0).getContent();
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
