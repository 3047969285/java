package org.dcj;

// 金卡类
public class GoldenCard extends dcj_01 {
    public GoldenCard(String id) {
        super(id, 10000); // 预存10000
    }
    
    @Override
    public int pay(int amount) {
        // 8折优惠
        int discountedAmount = (int) (amount * 0.8);
        if (num >= discountedAmount) {
            num -= discountedAmount;
            return num;
        }
        return -1; // 余额不足
    }
}