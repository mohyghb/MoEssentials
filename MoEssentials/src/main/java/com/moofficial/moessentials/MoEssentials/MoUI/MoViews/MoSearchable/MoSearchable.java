package com.moofficial.moessentials.MoEssentials.MoUI.MoViews.MoSearchable;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.moofficial.moessentials.MoEssentials.MoKeyboardUtils.MoKeyboardUtils;
import com.moofficial.moessentials.MoEssentials.MoState.MoOnScrollToPosition;
import com.moofficial.moessentials.MoEssentials.MoUI.MoViews.MoListViews;

import java.util.ArrayList;
import java.util.List;

public class MoSearchable extends MoListViews {


    // activity is needed for multi-threading computation
    // and then we can call run on ui thread using the activity
    private Activity activity;
    private TextView searchTextView;
    private MoSearchableList searchableList;
    private MoOnSearchFinished onSearchFinished = foundItems -> {};
    private MoOnSearchCanceled onSearchCanceled = () -> {};
    private MoOnSearchListener onSearchListener = search -> {};
    private MoOnScrollToPosition onScrollToPosition = position -> {};
    private ImageButton searchButton,cancelSearch,clearSearch;
    private LinearLayout searchLayout;
    private AppBarLayout appBarLayout;
    // for finding a searchable item
    private List<Integer> searchedIndices = new ArrayList<>();
    private int findIndex;
    private ImageButton upFind,downFind;
    private boolean searchOnTextChanged = false;
    private boolean showNothingWhenSearchEmpty = false;
    private boolean runOnAnotherThread = false;
    private boolean deactivateFindOperations =  false;
    private boolean deactivateSearchOperations =  false;
    private boolean clearSearchTextAfterDone = true;


    // change it so that searchable list is not mandatory

    public MoSearchable(Context c,View parent, MoSearchableList searchableList) {
        super(c,parent);
        this.searchableList = searchableList;
    }


    @Override
    public MoSearchable setSyncActions(MoListViews ... syncActions) {
        super.setSyncActions(syncActions);
        return this;
    }

    public MoSearchable setSearchTextView(int s) {
        this.searchTextView = parentView.findViewById(s);
        addTextWatcherToSearchText();
        this.searchTextView.setOnEditorActionListener((textView, actionId, event) -> {
            if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) ||
                    (actionId == EditorInfo.IME_ACTION_GO) || actionId == EditorInfo.IME_ACTION_DONE
                    || actionId == EditorInfo.IME_ACTION_SEARCH) {
                // hide keyboard
                MoKeyboardUtils.hideSoftKeyboard(textView);
                // we should search the char sequence here
                performSearch(textView);
            }
            return false;
        });

        return this;
    }

    private void addTextWatcherToSearchText() {
        if(this.searchOnTextChanged){
            this.searchTextView.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    // we should search the char sequence here
                    if(searchTextView.hasFocus()){
                        new Thread(){
                            @Override
                            public void run() {
                                performSearch(searchTextView);
                            }
                        }.start();
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
    }

    public MoSearchable setSearchOnTextChanged(boolean searchOnTextChanged) {
        this.searchOnTextChanged = searchOnTextChanged;
        if(searchTextView!=null){
            addTextWatcherToSearchText();
        }
        return this;
    }

    public MoSearchable setUpFind(int upFind) {
        this.upFind = parentView.findViewById(upFind);
        this.upFind.setOnClickListener(view -> {
            onUpFindPressed();
        });
        return this;
    }

    public MoSearchable setDownFind(int downFind) {
        this.downFind = parentView.findViewById(downFind);
        this.downFind.setOnClickListener(view -> {
            onDownFindPressed();
        });
        return this;
    }

    public MoSearchable setOnSearchCanceled(MoOnSearchCanceled onSearchCanceled) {
        this.onSearchCanceled = onSearchCanceled;
        return this;
    }

    public MoSearchable setSearchableList(MoSearchableList searchableList) {
        this.searchableList = searchableList;
        return this;
    }

    public MoSearchable setOnSearchFinished(MoOnSearchFinished onSearchFinished) {
        this.onSearchFinished = onSearchFinished;
        return this;
    }

    public MoSearchable setSearchTextView(TextView searchTextView) {
        this.searchTextView = searchTextView;
        return this;
    }

    public MoSearchable setOnSearchListener(MoOnSearchListener onSearchListener) {
        this.onSearchListener = onSearchListener;
        return this;
    }

    public MoSearchable setSearchButton(ImageButton searchButton) {
        this.searchButton = searchButton;
        this.searchButton.setOnClickListener(view -> {
            collapseAppbarIfNotNull();
            MoKeyboardUtils.showKeyboard(this.searchTextView,this.context);
            activateSpecialMode();
        });
        return this;
    }

    public MoSearchable setCancelSearch(ImageButton cancelSearch) {
        this.cancelSearch = cancelSearch;
        this.cancelSearch.setOnClickListener(view -> onCancel());
        return this;
    }

    public MoSearchable setClearSearch(ImageButton clearSearch) {
        this.clearSearch = clearSearch;
        return this;
    }

    public MoSearchable setSearchLayout(LinearLayout searchLayout) {
        this.searchLayout = searchLayout;
        return this;
    }

    public MoSearchable setSearchedIndices(List<Integer> searchedIndices) {
        this.searchedIndices = searchedIndices;
        return this;
    }

    public MoSearchable setFindIndex(int findIndex) {
        this.findIndex = findIndex;
        return this;
    }

    public MoSearchable setUpFind(ImageButton upFind) {
        this.upFind = upFind;
        return this;
    }

    public MoSearchable setDownFind(ImageButton downFind) {
        this.downFind = downFind;
        return this;
    }

    public AppBarLayout getAppBarLayout() {
        return appBarLayout;
    }

    public MoSearchable setAppBarLayout(AppBarLayout appBarLayout) {
        this.appBarLayout = appBarLayout;
        return this;
    }

    public boolean isClearSearchTextAfterDone() {
        return clearSearchTextAfterDone;
    }

    public MoSearchable setClearSearchTextAfterDone(boolean clearSearchTextAfterDone) {
        this.clearSearchTextAfterDone = clearSearchTextAfterDone;
        return this;
    }

    public boolean isRunOnAnotherThread() {
        return runOnAnotherThread;
    }

    public MoSearchable setRunOnAnotherThread(boolean runOnAnotherThread) {
        this.runOnAnotherThread = runOnAnotherThread;
        return this;
    }

    public MoSearchable setDeactivateFindOperations(boolean deactivateFindOperations) {
        this.deactivateFindOperations = deactivateFindOperations;
        return this;
    }

    public MoSearchable setDeactivateSearchOperations(boolean deactivateSearchOperations) {
        this.deactivateSearchOperations = deactivateSearchOperations;
        return this;
    }

    public MoSearchable setOnScrollToPosition(MoOnScrollToPosition onScrollToPosition) {
        this.onScrollToPosition = onScrollToPosition;
        return this;
    }

    public Activity getActivity() {
        return activity;
    }

    public TextView getSearchTextView() {
        return searchTextView;
    }

    public MoSearchableList getSearchableList() {
        return searchableList;
    }

    public MoOnSearchFinished getOnSearchFinished() {
        return onSearchFinished;
    }

    public MoOnSearchCanceled getOnSearchCanceled() {
        return onSearchCanceled;
    }

    public MoOnSearchListener getOnSearchListener() {
        return onSearchListener;
    }

    public MoOnScrollToPosition getOnScrollToPosition() {
        return onScrollToPosition;
    }

    public ImageButton getSearchButton() {
        return searchButton;
    }

    public ImageButton getCancelSearch() {
        return cancelSearch;
    }

    public ImageButton getClearSearch() {
        return clearSearch;
    }

    public LinearLayout getSearchLayout() {
        return searchLayout;
    }

    public List<Integer> getSearchedIndices() {
        return searchedIndices;
    }

    public int getFindIndex() {
        return findIndex;
    }

    public ImageButton getUpFind() {
        return upFind;
    }

    public ImageButton getDownFind() {
        return downFind;
    }

    public boolean isSearchOnTextChanged() {
        return searchOnTextChanged;
    }

    public boolean isShowNothingWhenSearchEmpty() {
        return showNothingWhenSearchEmpty;
    }

    public boolean isDeactivateFindOperations() {
        return deactivateFindOperations;
    }

    public boolean isDeactivateSearchOperations() {
        return deactivateSearchOperations;
    }


    @Override
    public MoSearchable addUnNormalViews(int... views) {
        super.addUnNormalViews(views);
        return this;
    }

    @Override
    public MoSearchable addUnNormalViews(View... views) {
        super.addUnNormalViews(views);
        return this;
    }

    @Override
    public MoSearchable addNormalViews(int... views) {
        super.addNormalViews(views);
        return this;
    }

    @Override
    public MoSearchable addNormalViews(View... views) {
        super.addNormalViews(views);
        return this;
    }

    @Override
    public MoSearchable setCancelButton(int cancelButton) {
        return setCancelSearch(parentView.findViewById(cancelButton));
    }

    public MoSearchable setClearSearch(int c) {
        this.clearSearch = parentView.findViewById(c);
        this.clearSearch.setOnClickListener(view -> clearSearch());
        return this;
    }

    public MoSearchable setClearSearch(int c, int drawable, View.OnClickListener onClearClickListener) {
        this.clearSearch = parentView.findViewById(c);
        this.clearSearch.setImageResource(drawable);
        this.clearSearch.setOnClickListener(onClearClickListener);
        return this;
    }

    public MoSearchable setShowNothingWhenSearchEmpty(boolean showNothingWhenSearchEmpty) {
        this.showNothingWhenSearchEmpty = showNothingWhenSearchEmpty;
        return this;
    }


    /**
     * very important if they are trying to use the find functionality
     * @param activity
     * @return
     */
    public MoSearchable setActivity(Activity activity) {
        this.activity = activity;
        return this;
    }

    /**
     * clears the current search
     */
    public void clearSearch(){
        searchTextView.setText("");
    }

    public MoSearchable setSearchButton(int searchButton) {
        return setSearchButton(parentView.findViewById(searchButton));
    }

    public void collapseAppbarIfNotNull() {
        if(appBarLayout!=null){
            // if the app bar layout is defined
            // when the user wants to search, we collapse the toolbar
            // and also focus on the text view
            appBarLayout.setExpanded(false,true);
        }
    }

    public MoSearchable setSearchLayout(int searchLayout) {
        this.searchLayout = parentView.findViewById(searchLayout);
        return this;
    }


    /**
     * when user is not trying to do this anymore
     */
    @Override
    public void onCancel() {
        // they do what they want on finish
        onSearchCanceled.onSearchCanceled();
        deactivateSpecialMode();
        MoSearchableUtils.cancelSearch(searchableList.getSearchableItems());
        searchableList.notifyDataSetChanged();
        clearSearchText();
        MoKeyboardUtils.hideSoftKeyboard(searchTextView);
    }

    public void clearSearchText() {
        if(clearSearchTextAfterDone){
            this.searchTextView.clearFocus();
            this.searchTextView.setText("");
        }
    }

    /**
     * when user gave us permission do
     * an operation that required one
     */
    @Override
    public void onConfirm() {

    }




    private void performSearch(TextView textView){
        onSearchListener.onSearchListener(textView.getText().toString());
        if(this.searchableList!=null){
            // search key word (always lower case)
            if(runOnAnotherThread){
                new Thread(){
                    @Override
                    public void run() {
                        performSearch();
                    }
                }.start();
            }else{
                performSearch();
            }
        }

    }

    public void performSearch(){
        String search = searchTextView.getText().toString().toLowerCase();
        if(!search.isEmpty()){
            // indexes of where the items match the search
            searchedIndices = MoSearchableUtils.search(searchableList.getSearchableItems(),search);
        }
        // perform actions for search
        finishSearch(search);
        // perform actions for find
        finishFind(search);
    }


    /**
     * performs different operations on the
     * searched text
     * and calls onSearchFinished with all the items
     * that we found based on [search]
     * @param search
     */
    public void finishSearch(String search){
        if(deactivateSearchOperations)
            return;
        // when search is not null
        // call on search finished with a
        // list of found items
        //if (onSearchFinished != null) {
            if(search.isEmpty()){
                if(this.showNothingWhenSearchEmpty){
                    // show empty because search is empty
                    this.onSearchFinished.onSearchFinished(new ArrayList<>());
                }else{
                    // show all the items when search is empty
                    this.onSearchFinished.onSearchFinished(this.searchableList.getSearchableItems());
                }
            }else{
                // search is not empty
                // so show the results
                this.onSearchFinished.onSearchFinished(MoSearchableUtils.getSearchableItems(
                        this.searchableList.getSearchableItems(),this.searchedIndices
                ));
            }
        //}
    }

    /**
     * finishing find and going to the index
     * that contains search
     * @param search
     */
    public void finishFind(String search){
        if(deactivateFindOperations)
            return;
        if(search.isEmpty())
            return;
        this.findIndex = 0;
        this.goToFind(0);
    }

    /**
     * scrolls to the position inside the
     * searched list based on i
     * @param i a number of elements up or down
     *          if i is positive we are going to the end of the list (down)
     *          and if i is negative we are going to start of the list (up)
     *          also it is important that the index we are going to
     *          is not illegal
     *          therefore we need to check whether it is legal or not
     *          and also disable the correct buttons for it
     */
    public void goToFind(int i){
        int newIndex = this.findIndex + i;
        if(this.upFind == null || this.downFind == null)
            return;
        if(newIndex < 0 || newIndex >= searchedIndices.size())
            return;
        // set the new index
        this.findIndex = newIndex;
        updateFindUI();
        // then check whether or not you can go up or down
        updateUpDownFindButtons(this.findIndex,this.searchedIndices.size());
    }

    public void updateFindUI() {
        if(activity!=null){
            activity.runOnUiThread(() -> {
                // notify that this item is searchable and change its view
                searchableList.notifyItemChanged(getFindPosition());
                // then scroll to the position on the item list
                onScrollToPosition.scrollTo(getFindPosition());
            });
        }
    }


    public int getFindPosition(){
        return this.searchedIndices.get(findIndex);
    }

    /**
     * both find down and up need to be
     * defined for this function to work
     */
    public void updateUpDownFindButtons(int index,int size){
        if(size==0){
            enableDisableUpDown(false,false);
            return;
        }if(index == 0){
            // we can't go upper or to the start
            // because we are at it right now
            enableDisableUpDown(false,true);
        }else if(index == size - 1){
            // we can't go lower or to the end
            enableDisableUpDown(true,false);
        }else{
            // we can go both ways
            enableDisableUpDown(true,true);
        }
    }


    public void enableDisableUpDown(boolean up, boolean down){
        this.downFind.setEnabled(down);
        this.upFind.setEnabled(up);
    }


    /**
     * when the user presses the down find button
     */
    public void onDownFindPressed(){
        goToFind(1);
    }

    /**
     * when the user presses the up find button
     */
    public void onUpFindPressed(){
        goToFind(-1);
    }





}
