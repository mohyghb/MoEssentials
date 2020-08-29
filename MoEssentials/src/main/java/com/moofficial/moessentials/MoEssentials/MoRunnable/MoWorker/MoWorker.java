package com.moofficial.moessentials.MoEssentials.MoRunnable.MoWorker;

/**  a class to avoid doing things multiple times
     for example if you want to dim the view
     and you call the dim view multiple times
     the view will get dimmer and dimmer,
     so we only need to do it once
     or allow multiple dim stages by setting a limit
     to allow the class to do it multiple times
     (do/undo)
 */
public class MoWorker {

    private int track = 0;
    private int limit = 1;
    private MoWorkerTask task = () -> {};
    private MoWorkerTask undoTask = () -> {};


    public MoWorker setTrack(int track) {
        this.track = track;
        return this;
    }

    public MoWorker setLimit(int limit) {
        this.limit = limit;
        return this;
    }

    public MoWorker setTask(MoWorkerTask task) {
        this.task = task;
        return this;
    }

    public MoWorker setUndoTask(MoWorkerTask undoTask) {
        this.undoTask = undoTask;
        return this;
    }

    /**
     * we make sure that we can perform a
     * task before we actually do it
     */
    public synchronized void perform() {
        if(canPerform()){
            task.run();
            track++;
        }
    }

    /**
     * runs the undo worker task that is
     * passed in if we can undo
     */
    public synchronized void undo() {
        if(canUndo()) {
            undoTask.run();
            track--;
        }
    }

    /**
     *
     * @return true if we have not reached the
     * limit
     */
    public boolean canPerform() {
        return track<limit;
    }

    /**
     *
     * @return true if we have done at least
     * one perform operation
     */
    public boolean canUndo() {
        return track > 0;
    }

}
