package org.dcj;

public class test_01 {
    public static void main(String[] args) {
        // 创建金卡
        GoldenCard goldenCard = new GoldenCard("G001");
        System.out.println("金卡卡号: " + goldenCard.getId());
        System.out.println("金卡初始余额: " + goldenCard.getNum());
        
        // 创建银卡
        SilverCard silverCard = new SilverCard("S001");
        System.out.println("银卡卡号: " + silverCard.getId());
        System.out.println("银卡初始余额: " + silverCard.getNum());
        
        // 测试金卡支付
        System.out.println("\n=== 金卡支付测试 ===");
        System.out.println("加油费用100元，享受8折优惠，实际支付: " + (100 * 0.8) + "元");
        int result = goldenCard.pay(100);
        if (result != -1) {
            System.out.println("支付成功，剩余余额: " + goldenCard.getNum() + "元");
        } else {
            System.out.println("支付失败，余额不足");
        }
        
        // 测试银卡支付
        System.out.println("\n=== 银卡支付测试 ===");
        System.out.println("加油费用100元，享受8.5折优惠，实际支付: " + (100 * 0.85) + "元");
        result = silverCard.pay(100);
        if (result != -1) {
            System.out.println("支付成功，剩余余额: " + silverCard.getNum() + "元");
        } else {
            System.out.println("支付失败，余额不足");
        }
        
        // 测试余额不足的情况
        System.out.println("\n=== 余额不足测试 ===");
        SilverCard silverCard2 = new SilverCard("S002");
        System.out.println("银卡初始余额: " + silverCard2.getNum() + "元");
        // 尝试支付大额费用
        result = silverCard2.pay(10000);
        if (result != -1) {
            System.out.println("支付成功，剩余余额: " + silverCard2.getNum() + "元");
        } else {
            System.out.println("支付失败，余额不足");
        }
    }
}