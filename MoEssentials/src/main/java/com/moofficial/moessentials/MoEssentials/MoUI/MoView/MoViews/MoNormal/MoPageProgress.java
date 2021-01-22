package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews.MoNormal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.R;

// a full page progress indicator for when we are loading something
public class MoPageProgress extends MoConstraint {


    private ProgressBar bar;


    public MoPageProgress(Context context) {
        super(context);
    }

    public MoPageProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoPageProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int getLayoutId() {
        return R.layout.mo_page_progress;
    }

    @Override
    public void initViews() {
        this.bar = findViewById(R.id.page_progress_progressbar);
        this.bar.setIndeterminate(true);
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }
}
