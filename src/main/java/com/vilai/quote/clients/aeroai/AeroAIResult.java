package com.vilai.quote.clients.aeroai;

import com.vilai.quote.models.QuoteInitResponse;

public class AeroAIResult {
    String type;

    public QuoteInitResponse getContent() {
        return content;
    }

    public void setContent(QuoteInitResponse content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    QuoteInitResponse content;
}
