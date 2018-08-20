package com.henryxi.core.misc;

import java.math.BigDecimal;

public class Company {
    private String name;
    private BigDecimal win;
    private BigDecimal tie;
    private BigDecimal lost;

    public Company(String companyName, double win, double tie, double lost) {
        this.name = companyName;
        this.win = BigDecimal.valueOf(win);
        this.tie = BigDecimal.valueOf(tie);
        this.lost = BigDecimal.valueOf(lost);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getWin() {
        return win;
    }

    public void setWin(BigDecimal win) {
        this.win = win;
    }

    public BigDecimal getTie() {
        return tie;
    }

    public void setTie(BigDecimal tie) {
        this.tie = tie;
    }

    public BigDecimal getLost() {
        return lost;
    }

    public void setLost(BigDecimal lost) {
        this.lost = lost;
    }
}
