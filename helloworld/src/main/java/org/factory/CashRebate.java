package org.factory;

public class CashRebate extends CashSuper{

    private  double moneyRebate = 0.8;
    public CashRebate(String moneyRebate) {
        this.moneyRebate = Double.parseDouble(moneyRebate);
    }
    /**
     * @return
     */
    @Override
    double acceptCash(double cash) {
        return cash* moneyRebate;
    }
}
