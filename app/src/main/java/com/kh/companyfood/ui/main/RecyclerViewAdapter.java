package com.kh.companyfood.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kh.companyfood.R;
import com.kh.companyfood.presenter.main.AdapterPresenter;

import java.util.ArrayList;


/**
 * Created by KIM on 2017-06-22.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements AdapterPresenter {

    private ItemClick itemClick;

    private ArrayList<RecyclerViewData> mDataList;

    private Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;

        public TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView)itemView.findViewById(R.id.image_sample);
            mTextView = (TextView)itemView.findViewById(R.id.text_sample);
        }
    }

    public RecyclerViewAdapter(Context context) {
        mContext = context;
    }

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.content_cardview, parent, false);

        // 뷰의 size, margin, padding 등 레이아웃 세팅

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        
        final int Position = position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( itemClick != null ) {
                    itemClick.onClick(v, Position);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if( itemClick != null ) {
                    itemClick.onLongClick(v, Position);
                    return true;
                }
                return false;
            }
        });

        Glide.with(mContext)
                .load(mDataList.get(position).mImage)
                .into(holder.mImageView);

        holder.mTextView.setText(mDataList.get(position).mText);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    @Override
    public void setItems(ArrayList<RecyclerViewData> dataList) {
        mDataList = dataList;
    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }
}