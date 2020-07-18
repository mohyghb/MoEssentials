package com.moofficial.moessentials.MoEssentials.MoPreviewable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


// acts like a recycler adapter but it can also show only a subset of
// the data set
// IMPORTANT: you need to remove getItemCount and onBindViewHolder methods from your adapters
//            we can handle it inside this class
public abstract class MoPreviewAdapter<T extends RecyclerView.ViewHolder,I> extends RecyclerView.Adapter<T> {

    public static final int NORMAL_PREVIEW_SIZE = 10;


    protected boolean canPreview;
    protected boolean previewFromEnd = true;
    protected int previewSize;
    protected List<I> dataSet;


    public MoPreviewAdapter(List<I> dataSet){
        this.dataSet = dataSet;
    }

    /**
     * sets the preview size of this adapter to the
     * parameter that is passed
     * @param previewSize
     * @return
     */
    public MoPreviewAdapter<T, I> setPreviewSize(int previewSize) {
        if(previewSize!=0){
            this.previewSize = previewSize;
            this.canPreview = true;
        }
        return this;
    }

    /**
     * makes the preview from bottom or top
     * basically should we show the 10 top items
     * or 10 bottom items
     * @param previewFromEnd
     * @return
     */
    public MoPreviewAdapter<T, I> setPreviewFromEnd(boolean previewFromEnd) {
        this.previewFromEnd = previewFromEnd;
        return this;
    }

    /**
     * a builder method which makes this adapter previewable by setting
     * the preview size to NORMAL_PREVIEW_SIZE
     * @return
     */
    public MoPreviewAdapter<T, I> makeItAPreviewable(){
        this.canPreview = true;
        this.previewSize = NORMAL_PREVIEW_SIZE;
        return this;
    }

    /**
     * returns the correct position when we are showing a preview
     * if it is a preview and we are showing from bottom, then
     * we need to use this formula
     * @param p
     * @return
     */
    public int getCorrectPosition(int p){
        if(this.canPreview && previewFromEnd){
            return this.dataSet.size() - getItemCount() + p;
        }
        return p;
    }

    /**
     * returns the item count of this recycler adapter
     * by considering if this is set to be preview
     * @return
     */
    @Override
    public int getItemCount() {
        return canPreview? Math.min(previewSize, dataSet.size()): dataSet.size();
    }


    @Override
    public void onBindViewHolder(@NonNull T holder, int position) {
        onBindViewHolderDifferentVersion(holder,getCorrectPosition(position));
    }


    /**
     * same method as onBindViewHolder but we pass the correct position to this
     * method
     * @param holder
     * @param position
     */
    protected abstract void onBindViewHolderDifferentVersion(@NonNull T holder, int position);


    /**
     * making sure that the item id is unique
     * other users can override this method
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * making sure that view type is unique
     * other users can override this method
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        return position;
    }


    public void notifyAdapterItemChanged(int position){
        notifyItemChanged(getCorrectPosition(position));
    }


}
