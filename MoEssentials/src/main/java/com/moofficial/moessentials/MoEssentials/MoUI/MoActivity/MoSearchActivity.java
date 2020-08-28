package com.moofficial.moessentials.MoEssentials.MoUI.MoActivity;

import androidx.recyclerview.widget.RecyclerView;

import com.moofficial.moessentials.MoEssentials.MoUI.MoActivity.MoWindow.MoSoftInputBuilder;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoBars.MoSearchBar;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoNormal.MoCardRecyclerView;
import com.moofficial.moessentials.MoEssentials.MoUI.MoRecyclerView.MoRecyclerView;
import com.moofficial.moessentials.R;

@Deprecated
public abstract class MoSearchActivity extends MoOriginalActivity {


//    private MoSearchBar searchBar;
//    private MoCardRecyclerView searchCardRecycler;
//    private MoRecyclerView searchRecyclerView;
//    private RecyclerView.Adapter searchAdapter;
//
//
//    @Override
//    protected void onCreate() {
//        super.onCreate();
//        setTitle(R.string.search);
//        setSearchHint(R.string.search_hint);
//        this.searchAdapter = getAdapter();
//        initSearchBar();
//        initSearchRecycler();
//
//        // soft input mode
//        bringKeyboardAndFocus();
//
//    }
//
//    /**
//     * makes the activity to show the keyboard and
//     * let the user type in from the start
//     */
//    private void bringKeyboardAndFocus() {
//        new MoSoftInputBuilder(this).adjustResizeSoftInput().softInputAlwaysVisible().build();
//        searchBar.getEditText().requestFocus();
//    }
//
//    private void initSearchRecycler() {
//        searchCardRecycler = new MoCardRecyclerView(this);
//        searchRecyclerView = new MoRecyclerView(this, searchCardRecycler.getRecyclerView(),this.searchAdapter);
//        searchRecyclerView.show();
//    }
//
//    private void initSearchBar(){
//        this.searchBar = new MoSearchBar(this);
//    }
//
//
//    public void setSearchHint(int h){
//        this.searchBar.setSearchHint(h);
//    }
//
//    public void setSearchHint(String h){
//        this.searchBar.setSearchHint(h);
//    }
//
//
//
//    public abstract RecyclerView.Adapter getAdapter();

}
