package com.moofficial.moessentials.MoEssentials.MoUI.MoFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoLayoutId;

public abstract class MoFragment extends Fragment implements MoLayoutId,MoOnBackPressed {


    protected View root;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(getLayoutResId(),null);
        return root;
    }

    /**
     * finds the view with id
     * inside the root layout
     * @param id of the view to find
     * @return found view with id
     */
    public <T extends View> T findViewById(@IdRes int id){
        return root.findViewById(id);
    }


    /**
     * @return the casted view group
     * to the root view
     */
    public ViewGroup getRootGroupView() {
        return (ViewGroup) root;
    }

}
