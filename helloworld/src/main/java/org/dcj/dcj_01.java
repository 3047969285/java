package org.dcj;

// 抽象卡片类
 public abstract class dcj_01 {
    String id;
    int num;
    
    public dcj_01(String id, int num) {
        this.id = id;
        this.num = num;
    }
    
    public String getId() {
        return id;
    }
    
    public int getNum() {
        return num;
    }
    
    // 抽象支付方法
    public abstract int pay(int amount);
}

