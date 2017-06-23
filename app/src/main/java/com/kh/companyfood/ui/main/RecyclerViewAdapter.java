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

import java.util.ArrayList;


/**
 * Created by KIM on 2017-06-22.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements AdapterContract {

    private ItemClick itemClick;

    private ArrayList<RecyclerViewData> mDataList;

    private Context mContext;

    /**
     * 각 데이터 항목을 포함한 뷰 참조를 제공합니다.
     * 뷰 홀더에서 데이터 항목을 포함한 뷰에 접근할 권한을 제공합니다.
     */
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

    /**
     * 레이아웃 매니저에 의해 호출되며 새로운 뷰를 생성합니다.
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 새로운 뷰 생성
        View view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.content_cardview, parent, false);

        // 뷰의 size, margin, padding 등 레이아웃 세팅

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    /**
     * 레이아웃 메니저에 의해 호출되며 뷰의 내용을 교체합니다.
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        // 아이템 클릭하면 뷰에게 보냄
        final int Position = position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( itemClick != null ) {
                    itemClick.onClick(v, Position);
                }
            }
        });

        // 이미지 로딩을 구현할때 HTTP 통신을 안정되게 구현하고, 비트맵으로 디코딩하면서
        // 메모리가 넘치거나 새지 않도록 주의를 해야함. 네트워크 호출과 디코딩은 단순히 백그라운드
        // 스레드에서 동작하는 것만으로 충분하지 않고 병렬성을 활용해야된다.
        // 화면회전, 전환, 스크롤때 반복적인 요청이 가지 않도록 이미지를 캐시하고, 불필요해진 요청은
        // 빠른 시점에 취소해서 더 나은 UI 반응을 제공하면서 자원을 절약해야되는데
        // 이런 것들을 해결해둔 대표적인 라이브러리중 하나인 Glide를 사용함
        Glide.with(mContext).load(mDataList.get(position).mImage).into(holder.mImageView);
        holder.mTextView.setText(mDataList.get(position).mText);
    }

    /**
     * 뷰의 사이즈를 리턴
     */
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

interface ItemClick {
    void onClick(View view,int position);
}