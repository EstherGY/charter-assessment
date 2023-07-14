package com.example.rewardprogram.model;

public class Reward {
    private long customerId;
    private long previousMonth;
    private long previousTwoMonth;
    private long previousThreeMonth;
    private long total;

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getCustomerId(){
        return customerId;
    }

    public void setPreviousMonth(long previousMonth) {
        this.previousMonth = previousMonth;
    }

    public long getPreviousMonth(){
        return previousMonth;
    }

    public long getPreviousTwoMonth() {
        return previousTwoMonth;
    }

    public void setPreviousTwoMonth(long previousTwoMonth) {
        this.previousTwoMonth = previousTwoMonth;
    }

    public long getPreviousThreeMonth() {
        return previousThreeMonth;
    }

    public void setPreviousThreeMonth(long previousThreeMonth) {
        this.previousThreeMonth = previousThreeMonth;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
