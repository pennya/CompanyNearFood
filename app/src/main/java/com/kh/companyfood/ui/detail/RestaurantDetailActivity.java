package com.kh.companyfood.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.kh.companyfood.R;
import com.kh.companyfood.presenter.detail.RestaurantDetailPresnter;
import com.kh.companyfood.presenter.detail.RestaurantDetailPresnterImpl;
import com.kh.companyfood.vo.RestaurantDetail;

import java.util.ArrayList;

/**
 * Created by KIM on 2017-08-08.
 */

public class RestaurantDetailActivity extends AppCompatActivity implements RestaurantDetailPresnter.View {

    private RestaurantDetailPresnter mRestaurantDetailPresnter;
    private RestaurantDetail mRestaurantDetail;
    private TextView mTitle;
    private TextView mAddress;
    private TextView mCategory;
    private TextView mDescription;
    private TextView mStar;
    private TextView mComment;
    private ArrayList<RestaurantDetail> restaurantDetailList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);

        initLayout();

        Intent intent = getIntent();
        int id = intent.getIntExtra("position", -1);

        mRestaurantDetailPresnter = new RestaurantDetailPresnterImpl(this, this);
        mRestaurantDetailPresnter.loadDetails(id);
    }

    @Override
    public void setRestaurantDetail(RestaurantDetail detail) {
        // 레이아웃 설정
        mRestaurantDetail = detail;
        restaurantDetailList.add(mRestaurantDetail);
        ViewPager viewPager = (ViewPager)findViewById(R.id.view_pager_images);
        RestaurantDetailImageAdapter restaurantDetailImageAdapter
                = new RestaurantDetailImageAdapter(this, mRestaurantDetail.getRestaurant()[0].getRestaurantimage_set() );
        viewPager.setAdapter(restaurantDetailImageAdapter);

        setLayout(mRestaurantDetail);
        setNaverMapInit();
    }

    private void initLayout() {
        mTitle = (TextView) findViewById(R.id.text_view_title);
        mAddress = (TextView) findViewById(R.id.text_view_address);
        mCategory = (TextView) findViewById(R.id.text_view_category);
        mDescription = (TextView) findViewById(R.id.text_view_description);
        mStar = (TextView) findViewById(R.id.text_view_star);
        mComment = (TextView) findViewById(R.id.text_view_comment);

    }

    private void setLayout(RestaurantDetail restaurantDetail) {
        mTitle.setText(restaurantDetail.getRestaurant()[0].getName());
        mAddress.setText(restaurantDetail.getRestaurant()[0].getAddress());
        mCategory.setText(restaurantDetail.getRestaurant()[0].getCategory().getName());
        mDescription.setText(restaurantDetail.getRestaurant()[0].getDescription());
        mStar.setText(String.format("%.1f", restaurantDetail.getRestaurant()[0].getRatingAverage()));
        mComment.setText("comment count : " + restaurantDetail.getCommentCount()
                + ", latitue/longitude : " +  restaurantDetail.getMap()[0].getLatitude() + "/" + restaurantDetail.getMap()[0].getLongitude());
    }

    private void setNaverMapInit() {
        Bundle mapBundle = new Bundle();
        mapBundle.putSerializable("MapData", restaurantDetailList);

        NaverMapFragment naverMapFragment = new NaverMapFragment();
        naverMapFragment.setArguments(mapBundle);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.fragmentHere, naverMapFragment);
        fragmentTransaction.commit();
    }
}
