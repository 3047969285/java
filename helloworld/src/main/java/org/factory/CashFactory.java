package org.factory;

public class CashFactory {
    public static CashSuper createCashSuper(String type){
        return switch (type) {
            case "正常收费" -> new CashNormal();
            case "满300返100" -> new CashReturn(300,100);
            case "打8折" -> new CashRebate("0.8");
            default -> null;
        };

    }






}
