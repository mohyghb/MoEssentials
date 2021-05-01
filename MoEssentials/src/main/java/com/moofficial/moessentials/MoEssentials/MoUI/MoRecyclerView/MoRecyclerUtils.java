package com.moofficial.moessentials.MoEssentials.MoUI.MoRecyclerView;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moofficial.moessentials.MoEssentials.MoUI.MoDynamicUnit.MoDynamicUnit;
import com.moofficial.moessentials.MoEssentials.MoUI.MoRecyclerView.MoBuilders.MoLLMBuilder;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewInterfaces.MoOnConfigurationChanged;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewInterfaces.MoOnSizeChanged;

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



    /**
     * sends a payload to all the items inside the
     * adapter, that are within [0,item count]
     * then inside the adapter on bind listener
     * we should do something with the payload
     * @param adapter to notify its items
     * @param payload the data we wanna pass
     */
    public static void sendPayloadToAll(RecyclerView.Adapter adapter,Object payload){
        adapter.notifyItemRangeChanged(0,adapter.getItemCount(), payload);
    }

    /**
     * sends the MoOnSizeChanged.ON_SIZE_CHANGED
     * payload to all the elements inside the adapter
     * so they know that they need to change their sizes
     * @param adapter to notify its items
     */
    public static void sendSizeChangedPayloadToAll(RecyclerView.Adapter adapter){
        sendPayloadToAll(adapter, MoOnSizeChanged.ON_SIZE_CHANGED);
    }


    /**
     * sends the MoOnConfigurationChanged.ON_CONFIG_CHANGED
     * payload to all the elements inside the adapter
     * so they know that they need to change their sizes
     * @param adapter to notify its items
     */
    public static void sendNewConfigPayloadToAll(RecyclerView.Adapter adapter){
        sendPayloadToAll(adapter, MoOnConfigurationChanged.ON_CONFIG_CHANGED);
    }

    /**
     * get column count dynamically using this method,
     * this is only used for the recycler views that are extending the width of phone's screen
     * @param context
     * @param minWidthDp
     * @return
     */
    public static int getDynamicNumberOfColumns(Context context, float minWidthDp) {
        int minWidthPx = MoDynamicUnit.convertDpToPixels(context, minWidthDp);
        int screenWidth = context.getResources().getDisplayMetrics().widthPixels;
        return screenWidth / minWidthPx;
    }





}
