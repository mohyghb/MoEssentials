package com.moofficial.moessentials.MoEssentials.MoMultiThread.MoThread;

// t is the result that we get when the thread finishes
public class MoThread<T> extends Thread {

    private MoAfterThreadFinished<T> afterThreadFinished = result -> {};
    private MoOnThreadRun<T> onThreadRun = () -> null;

    public MoThread<T> after(MoAfterThreadFinished<T> afterThreadFinished) {
        this.afterThreadFinished = afterThreadFinished;
        return this;
    }

    public MoThread<T> doBackground(MoOnThreadRun<T> onThreadRun) {
        this.onThreadRun = onThreadRun;
        return this;
    }

    public MoThread<T> begin() {
        start();
        return this;
    }


    @Override
    public synchronized void run() {
        super.run();
        afterThreadFinished.finished(onThreadRun.run());
    }


}
