package org.netty;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 事件观察者模式实现，用于监控事件实体类的变化
 */
public class EventObserver {
    // 使用线程安全的列表存储观察者
    private static final List<EventChangeListener> listeners = new CopyOnWriteArrayList<>();
    private static long eventIdCounter = 0;

    /**
     * 添加事件变化监听器
     *
     * @param listener 监听器
     */
    public static void addListener(EventChangeListener listener) {
        listeners.add(listener);
    }

    /**
     * 移除事件变化监听器
     *
     * @param listener 监听器
     */
    public static void removeListener(EventChangeListener listener) {
        listeners.remove(listener);
    }

    /**
     * 当有新事件添加时调用此方法
     *
     * @param event 事件对象
     */
    public static void onEventAdded(Event event) {
        // 通知所有监听器
        for (EventChangeListener listener : listeners) {
            listener.onEventAdded(event);
        }
    }

    /**
     * 模拟添加新事件的方法
     */
    public static void addNewEvent(String time, String location, String incident) {
        Event event = new Event(++eventIdCounter, time, location, incident);
        onEventAdded(event);
    }
}