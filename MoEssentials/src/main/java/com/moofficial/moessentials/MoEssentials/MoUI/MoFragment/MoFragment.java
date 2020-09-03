package com.moofficial.moessentials.MoEssentials.MoUI.MoFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoLayoutId;

public abstract class MoFragment extends Fragment implements MoLayoutId,MoOnBackPressed {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutResId(),null);
    }



}
