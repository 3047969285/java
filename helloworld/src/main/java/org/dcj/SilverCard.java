package org.dcj;

// 银卡类
public class SilverCard extends dcj_01 {
    public SilverCard(String id) {
        super(id, 5000); // 预存5000
    }
    
    @Override
    public int pay(int amount) {
        // 8.5折优惠
        int discountedAmount = (int) (amount * 0.85);
        if (num >= discountedAmount) {
            num -= discountedAmount;
            return num;
        }
        return -1; // 余额不足
    }
}