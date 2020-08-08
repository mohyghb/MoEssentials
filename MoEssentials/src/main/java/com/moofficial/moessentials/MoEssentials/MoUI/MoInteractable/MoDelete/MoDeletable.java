package com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoDelete;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoDelete.MoDeletableInterface.MoListDeletable;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoDelete.MoDeletableInterface.MoOnDeleteChanged;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoDelete.MoDeletableInterface.MoOnDeleteFinished;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoDelete.MoDeletableInterface.MoOnDeletePressed;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectable;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectableInterface.MoSelectableItem;


// this class is used to make a recycler view or a list view's items deletable
// uses MoAnimation
public class MoDeletable<T extends MoSelectableItem> extends MoSelectable<T> {


    private static final String DELETE_VIEW_FAILED = "Sorry, you can not delete right now";
    private static final String DELETE_SUCCESSFUL = "Delete was successful";


    //progress bar for visual purposes (indeterminute)
    private ProgressBar progressBar;
    private MoOnDeletePressed onDeletePressed = ()->{};
    private MoOnDeleteFinished onDeleteFinished = ()->{};
    private MoOnDeleteChanged onDeleteChanged = isInDeleteMode -> {};
    // mutual class
    private MoListDeletable<T> listAdapter;


    private String deleteMessage = DELETE_SUCCESSFUL;



    public MoDeletable(Context c, @NonNull ViewGroup parent, @NonNull MoListDeletable<T> listDeletable){
        super(c,parent,listDeletable);
        this.listAdapter = listDeletable;
        this.listAdapter.setMoDelete(this);
    }





    @Override
    public MoDeletable<T> addUnNormalViews(int... views) {
        super.addUnNormalViews(views);
        return this;
    }

    @Override
    public MoDeletable<T> addUnNormalViews(View... views) {
        super.addUnNormalViews(views);
        return this;
    }

    @Override
    public MoDeletable<T> addNormalViews(int... views) {
        super.addNormalViews(views);
        return this;
    }

    @Override
    public MoDeletable<T> addNormalViews(View... views) {
        super.addNormalViews(views);
        return this;
    }



    @Override
    public MoDeletable<T> setCounterView(int ctv) {
        super.setCounterView(ctv);
        return this;
    }

    @Override
    public MoDeletable<T> setCounterView(TextView ctv) {
        super.setCounterView(ctv);
        return this;
    }

    @Override
    public MoDeletable<T> setCounterView(int ctv, String message) {
        super.setCounterView(ctv, message);
        return this;
    }

    @Override
    public MoDeletable<T> setCounterView(TextView ctv, String message) {
        super.setCounterView(ctv, message);
        return this;
    }

    @Override
    public MoDeletable<T> setCancelButton(int cancelButton) {
        super.setCancelButton(cancelButton);
        return this;
    }

    @Override
    public MoDeletable<T> setConfirmButton(int deleteButton) {
        super.setConfirmButton(deleteButton);
        return this;
    }

    @Override
    public MoDeletable<T> setSelectAllCheckBox(int selectAll) {
        super.setSelectAllCheckBox(selectAll);
        return this;
    }

    public MoDeletable<T> setProgressBar(int progressBar){
        this.progressBar = parentView.findViewById(progressBar);
        this.progressBar.setIndeterminate(false);
        return this;
    }

    public MoDeletable<T> setOnDeletePressed(MoOnDeletePressed r){
        this.onDeletePressed = r;
        return this;
    }

    public MoDeletable<T> showOnlyOneActionAtTime(boolean b){
        this.showOneActionAtTime = b;
        return this;
    }


    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public MoDeletable setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
        return this;
    }

    public MoOnDeletePressed getOnDeletePressed() {
        return onDeletePressed;
    }

    public MoListDeletable<T> getListAdapter() {
        return listAdapter;
    }

    public MoDeletable<T> setListAdapter(MoListDeletable<T> listAdapter) {
        this.listAdapter = listAdapter;
        return this;
    }

    public String getDeleteMessage() {
        return deleteMessage;
    }

    public MoDeletable<T> setDeleteMessage(String deleteMessage) {
        this.deleteMessage = deleteMessage;
        return this;
    }

    public MoOnDeleteFinished getOnDeleteFinished() {
        return onDeleteFinished;
    }

    public MoDeletable<T> setOnDeleteFinished(MoOnDeleteFinished onDeleteFinished) {
        this.onDeleteFinished = onDeleteFinished;
        return this;
    }

    public MoOnDeleteChanged getOnDeleteChanged() {
        return onDeleteChanged;
    }

    public MoDeletable<T> setOnDeleteChanged(MoOnDeleteChanged onDeleteChanged) {
        this.onDeleteChanged = onDeleteChanged;
        return this;
    }

    @Override
    public MoDeletable<T> updateTitle(boolean updateTitleAfter) {
        super.updateTitle(updateTitleAfter);
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
        deselectAll(false);
        updateTitle();
    }


    /**
     * activates the delete mode if it is in the delete mode
     * and deactivates it if it is not in the delete mode
     * @param isInDeleteMode
     */
    public void setDeleteMode(boolean isInDeleteMode){
        // change the boolean
        this.isInActionMode = isInDeleteMode;
        this.onDeleteChanged.onChange(isInDeleteMode);
        // do other work to activate or deactivate the situation
        if(isInDeleteMode){
            activateDeleteMode();
        }else{
            deactivateDeleteMode();
        }
        // let the list know what to do when you are done
        this.listAdapter.notifyDataSetChanged();
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
        listAdapter.notifyDataSetChanged();
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
        activateProgressBar();
        this.onDeletePressed.onDeletePressed();
        // delete
        Handler h = new Handler();
        h.postDelayed(() -> {
            listAdapter.deleteSelected();
            onDeleteFinished.onDeleteFinished();
            deactivateProgressBar();
            onCancel();

            Toast.makeText(context, deleteMessage, Toast.LENGTH_SHORT).show();
        },100);
    }



    /**
     * updates the title after deletion was complete
     * (this is used if the counter is your title of app bar)
     */
    private void updateTitle(){
        if(this.counterTextView!=null && isUpdateTitleAfter()){
            counterTextView.setText(getSavedTitle());
        }
    }

    public void activateProgressBar(){
        if(this.progressBar!=null){
            progressBar.setIndeterminate(true);
        }
    }

    public void deactivateProgressBar(){
        if(this.progressBar!=null){
            progressBar.setIndeterminate(false);
        }
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
