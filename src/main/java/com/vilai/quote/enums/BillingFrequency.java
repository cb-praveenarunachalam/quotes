package com.vilai.quote.enums;

public enum BillingFrequency {
    MONTHLY(1),
    QUARTERLY(3),
    SEMI_ANNUAL(6),
    ANNUAL(12);

    private final int months;

    BillingFrequency(int months) {
        this.months = months;
    }

    public int getMonths() {
        return months;
    }

    public static int getMonthsByName(String name) {
        try {
            return BillingFrequency.valueOf(name.toUpperCase()).getMonths();
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid billing cycle: " + name);
        }
    }
}
