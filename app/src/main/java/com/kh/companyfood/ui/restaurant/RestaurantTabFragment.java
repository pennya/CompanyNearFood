package com.kh.companyfood.ui.restaurant;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kh.companyfood.R;
import com.kh.companyfood.presenter.restaurant.RestaurantPresenter;
import com.kh.companyfood.presenter.restaurant.RestaurantPresenterImpl;
import com.kh.companyfood.ui.main.ItemClick;
import com.kh.companyfood.ui.main.RecyclerViewAdapter;

/**
 * Created by KIM on 2017-06-21.
 */

public class RestaurantTabFragment extends Fragment implements RestaurantPresenter.View, ItemClick{

    private static final String TAG = "KJH";

    private RestaurantPresenterImpl mPresenter;

    private RecyclerView mRecyclerView;

    private RecyclerViewAdapter mAdapter;

    private RecyclerView.LayoutManager mLayoutManager;

   public RestaurantTabFragment() {

    }

    public static RestaurantTabFragment newInstance() {
        return new RestaurantTabFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_restaurant, container, false);

        mRecyclerView = (RecyclerView)root.findViewById(R.id.recycler_view);

        // 내용의 변경으로 인해 RecyclerView의 레이아웃 크기가 변경되지 않는다면
        // 성능을 향상시키기 위해 이 설정을 사용하면된다.
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecyclerViewAdapter(getActivity());
        mAdapter.setItemClick(this);
        mRecyclerView.setAdapter(mAdapter);

        mPresenter = new RestaurantPresenterImpl(this, mAdapter);
        mPresenter.loadItems();

        return root;
    }

    @Override
    public void ShowToast(String text) {
        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view, int position) {
        mPresenter.onRecyclerItemClick(position);
    }

    @Override
    public void onLongClick(View view, int position) {
        mPresenter.onRecyclerItemLongClick(position);
    }
}
