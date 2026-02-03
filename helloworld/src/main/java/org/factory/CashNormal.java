package org.factory;

public class CashNormal extends CashSuper{

    /**
     * @return
     */
    @Override
    double acceptCash(double  cash) {
        return cash;
    }
}
