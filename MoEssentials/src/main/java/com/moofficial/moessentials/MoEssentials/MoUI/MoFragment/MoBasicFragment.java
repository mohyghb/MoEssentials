package com.moofficial.moessentials.MoEssentials.MoUI.MoFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoBasicLayout;
import com.moofficial.moessentials.R;

public abstract class MoBasicFragment extends MoFragment {

    protected MoBasicLayout layout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        layout = new MoBasicLayout(getContext());
        return layout;
    }


    @Override
    public int getLayoutResId() {
        return R.layout.mo_basic_layout;
    }



}
