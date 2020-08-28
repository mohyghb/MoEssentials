package com.moofficial.moessentials.MoEssentials.MoUI.MoRecyclerView;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moofficial.moessentials.MoEssentials.MoUI.MoRecyclerView.MoBuilders.MoLLMBuilder;

@SuppressWarnings("rawtypes")
public class MoRecyclerUtils {


    public static MoRecyclerView getDefault(Context context,RecyclerView.Adapter adapter){
        return new MoRecyclerView.Builder(context).setAdapter(adapter).build();
    }


    /**
     * @param context of app
     * @param s stack from end
     * @param r reverse layout
     * @param o orientation
     * @return returns a linear layout manager
     *         for a recycler view based on the params
     *         that are passed in
     */
    public static LinearLayoutManager
            getLinearManager(Context context, boolean s, boolean r, @RecyclerView.Orientation int o){
        return new MoLLMBuilder(context).setOrientation(o).setReverseLayout(r).setStackFromEnd(s).build();
    }

    /**
     * @return the default linear layout manager
     * for a recycler view by setting everything to false,
     * and making the view vertical
     * @param context of the app
     */
    public static LinearLayoutManager getDefaultLinearManager(Context context){
        return getLinearManager(context,false,false,RecyclerView.VERTICAL);
    }


    /**
     *
     * @param root view that includes the recycler view
     * @param res resource id of
     * @param adapter recycler adapter
     * @return mo recycler view that is inside the root
     *         view with id [res]
     */
    public static MoRecyclerView get(View root, @IdRes int res, RecyclerView.Adapter adapter){
        MoRecyclerView r = root.findViewById(res);
        r.setAdapter(adapter);
        return r;
    }

    /**
     *
     * @param r mo recycler view
     * @param adapter recycler adapter
     * @return sets the adapter of the recycler view
     *         and returns the mo recycler view
     */
    public static MoRecyclerView get(MoRecyclerView r,RecyclerView.Adapter adapter){
        r.setAdapter(adapter);
        return r;
    }



}
