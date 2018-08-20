package com.henryxi.core.misc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LotteryClient {
    //Pinnbet	2.90	3.30	2.40
    //Leon      2.52	3.17	2.38
    /**
     * win:	168 Pinnbet	4.2	27                  //从Pinnbet下注 27%的资金押胜 (其中168是公司id，Pinnbet是公司名称，4.2是赔率，27是押27%的资金)
     * draw:	168 Pinnbet	3.5	32                  //从Pinnbet下注 32%的资金押平
     * lose:	26 Leon	2.68	41
     */
    private static Company companyA = new Company("companyA", 2.62, 3.20, 2.80);
    private static Company companyB = new Company("companyB", 2.74, 3.20, 2.86);

    public static void main(String[] args) {

        int total = 100;
        for (int win = 0; win <= 100; win++) {
            for (int tie = 0; tie <= 100 - win; tie++) {
                int lost = total - win - tie;
                if (lost < 0) {
                    System.out.println("****************");
                    break;
                }
                getNum(win, tie, lost);
            }
        }
    }

    private static void getNum(int win, int tie, int lost) {
        List<BigDecimal> wins = Arrays.asList(companyA.getWin(), companyB.getWin());
        List<BigDecimal> ties = Arrays.asList(companyA.getTie(), companyB.getTie());
        List<BigDecimal> losts = Arrays.asList(companyA.getLost(), companyB.getLost());

        for (BigDecimal winRate : wins) {
            for (BigDecimal tieRate : ties) {
                for (BigDecimal lostRate : losts) {
                    BigDecimal totalForWin = winRate.multiply(BigDecimal.valueOf(win)).subtract(BigDecimal.valueOf(tie)).subtract(BigDecimal.valueOf(lost));
                    BigDecimal totalForTie = tieRate.multiply(BigDecimal.valueOf(tie)).subtract(BigDecimal.valueOf(win)).subtract(BigDecimal.valueOf(lost));
                    BigDecimal totalForLost = lostRate.multiply(BigDecimal.valueOf(lost)).subtract(BigDecimal.valueOf(tie)).subtract(BigDecimal.valueOf(win));
                    if (totalForWin.compareTo(BigDecimal.ZERO) < 0 || totalForLost.compareTo(BigDecimal.ZERO) < 0 || totalForTie.compareTo(BigDecimal.ZERO) < 0) {
                        continue;
                    }
                    BigDecimal min = Collections.min(Arrays.asList(totalForWin, totalForLost, totalForTie));
                    Company buyWinCompany = getWinCompanyName(winRate);
                    Company buyTieCompany = getTieCompanyName(tieRate);
                    Company buyLostCompany = getLostCompanyName(lostRate);
                    System.out.println("赢的资金占比:" + win + ",购买公司:" + buyWinCompany.getName() + ",赔率:" + buyWinCompany.getWin());
                    System.out.println("平的资金占比:" + tie + ",购买公司:" + buyTieCompany.getName() + ",赔率:" + buyTieCompany.getTie());
                    System.out.println("输的资金占比:" + lost + ",购买公司:" + buyLostCompany.getName() + ",赔率:" + buyLostCompany.getLost());
                    System.out.println("至少赚取:" + (min.subtract(BigDecimal.valueOf(100))));
                    System.out.println();
                    System.out.println();
                    System.out.println();
//                    System.out.println("winRate:" + winRate + ",win:" + win);
//                    System.out.println("tieRate:" + tieRate + ",tie:" + tie);
//                    System.out.println("lostRate:" + lostRate + ",lost:" + lost);
                }
            }
        }
    }

    public static Company getWinCompanyName(BigDecimal winNum) {
        if (companyA.getWin().equals(winNum)) {
            return companyA;
        }
        return companyB;
    }

    public static Company getTieCompanyName(BigDecimal tieNum) {
        if (companyA.getTie().equals(tieNum)) {
            return companyA;
        }
        return companyB;
    }

    public static Company getLostCompanyName(BigDecimal lostNum) {
        if (companyA.getLost().equals(lostNum)) {
            return companyA;
        }
        return companyB;
    }
}
