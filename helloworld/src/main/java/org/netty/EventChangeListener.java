package org.netty;

/**
 * 事件变化监听器接口
 */
public interface EventChangeListener {
    /**
     * 当有新事件添加时调用
     *
     * @param event 事件对象
     */
    void onEventAdded(Event event);
}