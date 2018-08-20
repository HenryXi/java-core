package com.henryxi.core.misc;

public class Result {
    private int win;
    private int tie;
    private int lost;
    private Company winCompany;
    private Company tieCompany;
    private Company lostCompany;

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getTie() {
        return tie;
    }

    public void setTie(int tie) {
        this.tie = tie;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public Company getWinCompany() {
        return winCompany;
    }

    public void setWinCompany(Company winCompany) {
        this.winCompany = winCompany;
    }

    public Company getTieCompany() {
        return tieCompany;
    }

    public void setTieCompany(Company tieCompany) {
        this.tieCompany = tieCompany;
    }

    public Company getLostCompany() {
        return lostCompany;
    }

    public void setLostCompany(Company lostCompany) {
        this.lostCompany = lostCompany;
    }

    public int total() {
        return 0;
    }

    @Override
    public String toString() {
        return "购买";
    }
}
