package com.adventofcode2020.dto;

public class PasswordDto {
    private int lowestCount;
    private int highestCount;
    private String symbol;
    private String password;

    public int getLowestCount() {
        return lowestCount;
    }

    public void setLowestCount(int lowestCount) {
        this.lowestCount = lowestCount;
    }

    public int getHighestCount() {
        return highestCount;
    }

    public void setHighestCount(int highestCount) {
        this.highestCount = highestCount;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PasswordDto{" +
                "lowestCount=" + lowestCount +
                ", highestCount=" + highestCount +
                ", symbol='" + symbol + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
