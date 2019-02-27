package com.dsyu.hilo;

public class TotalValue {

    private String totalValue = "0";

    public String getTotalValue() {
        return totalValue;
    }

    public void addToTotalValue (int valueToAdd) {
        int total = Integer.parseInt(totalValue) + valueToAdd;
        totalValue = String.valueOf(total);
    }

    public void resetTotalValue() {
        totalValue = "0";
    }
}
