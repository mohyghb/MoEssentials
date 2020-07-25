package com.moofficial.molib;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moofficial.moessentials.MoEssentials.MoUI.MoActivity.MoBasicActivity;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInflatorView.MoInflaterView;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoBars.MoAddBar;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoBars.MoInputBar;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoBars.MoToolBar;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewBuilder.MoImageButtonBuilder;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewBuilder.MoPaddingBuilder;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewBuilder.MoTextViewBuilder;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoCardRecyclerView;
import com.moofficial.moessentials.MoEssentials.MoUI.MoPreviewable.MoPreviewAdapter;
import com.moofficial.moessentials.MoEssentials.MoUI.MoRecyclerView.MoRecyclerView;

import java.util.Arrays;

public class MainActivity extends MoBasicActivity {


    @Override
    protected void onCreate() {
       // addToolbar(R.layout.mo_tool_bar);
        MoToolBar t = new MoToolBar(this);
        t.customize(new MoImageButtonBuilder(this).setVisibility(View.GONE),t.LId())
         .customize(new MoTextViewBuilder(this).setText("Customization")
                 .setContentPadding(new MoPaddingBuilder(20)),t.TVId());

        addToolbar(t);


        MoCardRecyclerView cardRecyclerView = new MoCardRecyclerView(this);

        MoRecyclerView moRecyclerView = new MoRecyclerView(this, cardRecyclerView.RVId(), new MoPreviewAdapter(
                Arrays.asList("hello","how","are","you")) {
            @Override
            protected void onBindViewHolderDifferentVersion(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                ((TextView)(viewHolder.itemView.findViewById(R.id.input_bar_edit_text))).setText(dataSet.get(i).toString());
            }

            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new RecyclerView.ViewHolder(MoInflaterView.inflate(R.layout.mo_input_bar,MainActivity.this)) {

                };
            }
        });

        addToNestedLinearLayout(new MoInputBar(this));
        addToNestedLinearLayout(new MoInputBar(this));
        addToNestedLinearLayout(new MoInputBar(this));
        addToNestedLinearLayout(new MoInputBar(this));
        linearTop.addView(new MoInputBar(this));
        addToBottomLinearLayout(new MoInputBar(this));
    }


}