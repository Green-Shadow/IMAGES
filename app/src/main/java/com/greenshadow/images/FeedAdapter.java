package com.greenshadow.images;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kamte on 12/15/2017.
 */

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {
    private String[] mDataset;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView user_type,user_name,date_posted,post_text;
        public ImageView profilePic;
        public ViewHolder(View v) {
            super(v);
            user_name = v.findViewById(R.id.posterName);
            user_type = v.findViewById(R.id.postUserPrivType);
            date_posted = v.findViewById(R.id.Date_posted_text_view);
            post_text = v.findViewById(R.id.post_text_view);
            profilePic = v.findViewById(R.id.userProfilePic);
        }
    }

    public FeedAdapter(String[] data){
        this.mDataset = data;
    }

    @Override
    public FeedAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View thisItemsView = LayoutInflater.from(parent.getContext()).inflate(R.layout.experience_card_view,
                parent, false);
        FeedAdapter.ViewHolder v = new FeedAdapter.ViewHolder(thisItemsView);
        return v;
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
