package com.greenshadow.images;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by kamte on 12/15/2017.
 */

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {
    private String[] mDataset;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ViewHolder(TextView v) {
            super(v);
            //TODO:Instantiate instances of layout elements
        }
    }

    @Override
    public FeedAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //TODO:Add layout inflation logic
    }

    @Override
    public void onBindViewHolder(FeedAdapter.ViewHolder holder, int position) {
        //TODO: Add text population logic
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

}
