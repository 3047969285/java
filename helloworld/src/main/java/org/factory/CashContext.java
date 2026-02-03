package org.factory;

public class CashContext {
     private  CashSuper cs;
     public CashContext(String type){
         this.cs = switch (type) {
             case "正常收费" -> cs = new CashNormal();
             case "满300返100" -> cs = new CashReturn(300, 100);
             case "打8折" -> cs = new CashRebate("0.8");
             default -> cs = null;
         };
     }
     public double getResult(double money){
         return cs.acceptCash(money);
     }

}
