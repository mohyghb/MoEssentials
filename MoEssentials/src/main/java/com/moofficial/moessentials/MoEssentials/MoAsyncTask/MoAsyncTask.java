package com.moofficial.moessentials.MoEssentials.MoAsyncTask;

import android.os.AsyncTask;

public class MoAsyncTask extends AsyncTask<Object,Object,Object> {

    private MoAsyncDoInBackground asyncDoInBackground = objects -> {};
    private MoAsyncOnTaskFinished asyncOnTaskFinished = o -> {};
    private MoAsyncPreTaskExecute asyncPreTaskExecute = ()->{};
    private MoAsyncOnTaskCancelled asyncOnTaskCancelled = ()->{};
    private MoAsyncProgressUpdate asyncProgressUpdate = objects->{};


    public MoAsyncTask setAsyncDoInBackground(MoAsyncDoInBackground asyncDoInBackground) {
        this.asyncDoInBackground = asyncDoInBackground;
        return this;
    }

    public MoAsyncTask setAsyncOnTaskFinished(MoAsyncOnTaskFinished asyncOnTaskFinished) {
        this.asyncOnTaskFinished = asyncOnTaskFinished;
        return this;
    }

    public MoAsyncTask setAsyncPreTaskExecute(MoAsyncPreTaskExecute asyncPreTaskExecute) {
        this.asyncPreTaskExecute = asyncPreTaskExecute;
        return this;
    }

    public MoAsyncTask setAsyncOnTaskCancelled(MoAsyncOnTaskCancelled asyncOnTaskCancelled) {
        this.asyncOnTaskCancelled = asyncOnTaskCancelled;
        return this;
    }

    public MoAsyncTask setAsyncProgressUpdate(MoAsyncProgressUpdate asyncProgressUpdate) {
        this.asyncProgressUpdate = asyncProgressUpdate;
        return this;
    }

    @Override
    protected void onCancelled(Object o) {
        super.onCancelled(o);
        asyncOnTaskCancelled.onTaskCancelled();
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        asyncOnTaskCancelled.onTaskCancelled();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        asyncPreTaskExecute.preTaskExecute();
    }

    @Override
    protected Object doInBackground(Object... objects) {
        asyncDoInBackground.doInBackground(objects);
        return null;
    }

    @Override
    protected void onProgressUpdate(Object... values) {
        super.onProgressUpdate(values);
        asyncProgressUpdate.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        asyncOnTaskFinished.onTaskFinished(o);
    }
}
