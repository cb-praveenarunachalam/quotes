package com.vilai.quote.models;

public class AeroAIResult {
    String type;

    public QuotePromptResponse getContent() {
        return content;
    }

    public void setContent(QuotePromptResponse content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    QuotePromptResponse content;
}
