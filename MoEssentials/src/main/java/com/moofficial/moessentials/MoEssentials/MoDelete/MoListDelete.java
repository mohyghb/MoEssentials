package com.moofficial.moessentials.MoEssentials.MoDelete;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.moofficial.moessentials.MoEssentials.MoRunnable.MoRunnableUtils;
import com.moofficial.moessentials.MoEssentials.MoSelectable.MoListSelectable;
import com.moofficial.moessentials.MoEssentials.MoViews.MoListViews;


// this class is used to make a recycler view or a list view's items deletable
// uses MoAnimation
public class MoListDelete extends MoListSelectable {


    private static final String DELETE_VIEW_FAILED = "Sorry, you can not delete right now";
    private static final String DELETE_SUCCESSFUL = "Delete was successful";


    //progress bar for visual purposes (indeterminute)
    private ProgressBar progressBar;
    private Runnable onDeletePressed;
    // mutual class
    private MoListDeletable listAdapter;


    private String deleteMessage = DELETE_SUCCESSFUL;



    public MoListDelete(Context c, View parent, @NonNull MoListDeletable listDeletable){
        super(c,parent,listDeletable);
        this.listAdapter = listDeletable;
        this.listAdapter.setMoDelete(this);
    }


    @Override
    public MoListDelete setSyncActions(MoListViews... syncActions) {
        super.setSyncActions(syncActions);
        return this;
    }

    @Override
    public MoListDelete setUnNormalViews(int... views) {
        super.setUnNormalViews(views);
        return this;
    }

    @Override
    public MoListDelete setNormalViews(int... views) {
        super.setNormalViews(views);
        return this;
    }

    @Override
    public MoListDelete setVisibleAnimation(int a) {
        super.setVisibleAnimation(a);
        return this;
    }

    @Override
    public MoListDelete setGoneAnimation(int a) {
        super.setGoneAnimation(a);
        return this;
    }

    @Override
    public MoListDelete setCounterView(int ctv, String message) {
        super.setCounterView(ctv, message);
        return this;
    }


    @Override
    public MoListDelete setCancelButton(int cancelButton) {
        super.setCancelButton(cancelButton);
        return this;
    }

    @Override
    public MoListDelete setConfirmButton(int deleteButton) {
        super.setConfirmButton(deleteButton);
        return this;
    }

    @Override
    public MoListDelete setSelectAllCheckBox(int selectAll) {
        super.setSelectAllCheckBox(selectAll);
        return this;
    }

    public MoListDelete setProgressBar(int progressBar){
        this.progressBar = parentView.findViewById(progressBar);
        this.progressBar.setIndeterminate(false);
        return this;
    }

    public MoListDelete setOnDeletePressed(Runnable r){
        this.onDeletePressed = r;
        return this;
    }

    public MoListDelete showOnlyOneActionAtTime(boolean b){
        this.showOneActionAtTime = b;
        return this;
    }


    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public MoListDelete setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
        return this;
    }

    public Runnable getOnDeletePressed() {
        return onDeletePressed;
    }

    public MoListDeletable getListAdapter() {
        return listAdapter;
    }

    public MoListDelete setListAdapter(MoListDeletable listAdapter) {
        this.listAdapter = listAdapter;
        return this;
    }

    public String getDeleteMessage() {
        return deleteMessage;
    }

    public MoListDelete setDeleteMessage(String deleteMessage) {
        this.deleteMessage = deleteMessage;
        return this;
    }

    /**
     * shows the delete views and hides the normal views
     */
    private void activateDeleteMode(){
        activateSpecialMode();
        updateCounter();
    }


    /**
     * shows the normal views and hides the delete views
     */
    private void deactivateDeleteMode(){
        deactivateSpecialMode();
        // every time we get out of it
        // we need to deselect all elements
        listAdapter.deselectAllElements();
    }


    /**
     * activates the delete mode if it is in the delete mode
     * and deactivates it if it is not in the delete mode
     * @param isInDeleteMode
     */
    public void setDeleteMode(boolean isInDeleteMode){
        // change the boolean
        this.isInActionMode = isInDeleteMode;
        // do other work to activate or deactivate the situation
        if(isInDeleteMode){
            activateDeleteMode();
        }else{
            deactivateDeleteMode();
        }
        // let the list know what to do when you are done
        this.listAdapter.notifySituationChanged();
    }





    @Override
    public void selectAll(){
        this.listAdapter.selectAllElements();
    }

    @Override
    public void deselectAll(){
        this.listAdapter.deselectAllElements();
    }





    /**
     * used when the activity is rebuilt causing the
     * delete mode to not show
     */
    public void onResume(){
        if(isInActionMode){
            setDeleteMode(true);
        }else{
            setDeleteMode(false);
        }
    }





    /**
     * updates all the aspects of the delete mode
     */
    @Override
    public void update(){
        super.update();
        updateCounter();
        updateSelectAll();
        listAdapter.notifySituationChanged();
    }

    /**
     * when user is not trying to do this anymore
     */
    @Override
    public void onCancel() {
        setDeleteMode(false);
    }

    /**
     * when user gave us permission do
     * an operation that required one
     */
    @Override
    public void onConfirm() {
        progressBar.setIndeterminate(true);
        // delete
        Handler h = new Handler();
        h.postDelayed(() -> {
            listAdapter.deleteSelected();
            progressBar.setIndeterminate(false);
            onCancel();
            MoRunnableUtils.runIfNotNull(onDeletePressed);
            Toast.makeText(context, deleteMessage, Toast.LENGTH_SHORT).show();
        },100);
    }


    // for select all button
    private void updateSelectAll(){
        if(this.selectAllCheckBox!=null){
            if(this.selectedSize == listAdapter.size()){
                // then it should be turned on
                this.selectAllCheckBox.setChecked(true);
            }else{
                this.selectAllCheckBox.setChecked(false);
            }
        }
    }



    public static void deleteIsNotSpecifiedInThisContext(Context context){
        Toast.makeText(context,DELETE_VIEW_FAILED,Toast.LENGTH_SHORT).show();
    }


}
