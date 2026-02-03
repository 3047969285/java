package org.Proxy;

public class Proxy implements Base {
    private Base base;
    
    /**
     * 唱歌
     * @param name 歌曲名称
     * @return 演唱结果
     */
    @Override
    public String sing(String name) {
        if (base == null) {
            base = new BigStar();
        }
        return base .sing(name);
    }

    /**
     * 跳舞
     */
    @Override
    public void dance() {
        if (base == null)
            base = new BigStar();
        base.dance();
    }
}