package com.kh.companyfood.adapter.restaurant;

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
import com.kh.companyfood.presenter.restaurant.RestaurantPresenter;

import java.util.ArrayList;


/**
 * Created by KIM on 2017-06-22.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements AdapterPresenter {


    private ArrayList<RecyclerViewData> mDataList = new ArrayList<>();


    private Context mContext;
    private RestaurantPresenter restaurantPresenter;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;

        public TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView)itemView.findViewById(R.id.image_sample);
            mTextView = (TextView)itemView.findViewById(R.id.text_sample);
        }
    }

    public RecyclerViewAdapter(Context context, RestaurantPresenter restaurantPresenter) {
        mContext = context;
        this.restaurantPresenter = restaurantPresenter;
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

        

        final int ItemPosition = position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                restaurantPresenter.onRecyclerItemClick(ItemPosition);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                restaurantPresenter.onRecyclerItemLongClick(ItemPosition);

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