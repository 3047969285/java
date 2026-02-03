package org.factory;

public class CashReturn extends  CashSuper{

    private  double moneyCondition;
    private  double moneyReturn;
    public CashReturn(double moneyCondition,double moneyReturn){
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }



    /**
     * @return
     */
    @Override
    double acceptCash(double cash) {
        double result = cash;
        if (cash >= moneyCondition) {
            result = cash - Math.floor(cash / moneyCondition) * moneyReturn;
        }
        return result;
    }
}
