package org.threadpoolExcutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class threadpool extends ThreadPoolExecutor{
    public threadpool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public threadpool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public threadpool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public threadpool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    // 重写beforeExecute方法，任务执行前的操作
    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        System.out.println("线程 " + t.getName() + " 准备执行任务");
    }

    // 重写afterExecute方法，任务执行后的操作
    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        if (t != null) {
            System.err.println("任务执行出现异常: " + t.getMessage());
            t.printStackTrace();
        } else {
            System.out.println("任务执行完成");
        }
    }

    // 重写terminated方法，线程池关闭时的操作
    @Override
    protected void terminated() {
        super.terminated();
        System.out.println("线程池已关闭");
    }

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,
                10,
                1000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(10),
                new NamedThreadFactory("MyThreadPool"),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        // 提交任务到线程池
        for (int i = 0; i < 20; i++) {
            final int taskId = i;
            threadPoolExecutor.execute(new Task(taskId));
        }

        // 关闭线程池
        threadPoolExecutor.shutdown();
        try {
            // 等待所有任务完成，最多等待1分钟
            if (!threadPoolExecutor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.err.println("线程池任务未在规定时间内完成，强制关闭");
                threadPoolExecutor.shutdownNow();
            } else {
                System.out.println("所有任务已完成");
            }
        } catch (InterruptedException e) {
            System.err.println("等待任务完成时被中断: " + e.getMessage());
            threadPoolExecutor.shutdownNow();
        }
    }

    // 自定义任务类
    static class Task implements Runnable {
        private final int taskId;

        public Task(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            System.out.println("任务 " + taskId + " 开始执行，由线程 " + Thread.currentThread().getName() + " 处理");
            try {
                // 模拟任务执行时间
                Thread.sleep(1000);
                System.out.println("任务 " + taskId + " 执行完毕");
            } catch (InterruptedException e) {
                System.err.println("任务 " + taskId + " 被中断");
                Thread.currentThread().interrupt();
            }
        }
    }

    // 自定义线程工厂，为线程命名
    static class NamedThreadFactory implements ThreadFactory {
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        public NamedThreadFactory(String namePrefix) {
            this.namePrefix = namePrefix;
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, namePrefix + "-thread-" + threadNumber.getAndIncrement());
            return t;
        }
    }
}