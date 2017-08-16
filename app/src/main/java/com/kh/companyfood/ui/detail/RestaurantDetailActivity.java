package com.kh.companyfood.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.kh.companyfood.R;
import com.kh.companyfood.presenter.detail.RestaurantDetailPresnter;
import com.kh.companyfood.presenter.detail.RestaurantDetailPresnterImpl;
import com.kh.companyfood.vo.RestaurantDetail;

/**
 * Created by KIM on 2017-08-08.
 */

public class RestaurantDetailActivity extends AppCompatActivity implements RestaurantDetailPresnter.View {

    private RestaurantDetailPresnter mRestaurantDetailPresnter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);

        Intent intent = getIntent();
        int id = intent.getIntExtra("position", -1);
        Toast.makeText(this, "id : " + id, Toast.LENGTH_SHORT).show();

        mRestaurantDetailPresnter = new RestaurantDetailPresnterImpl(this, this);
        mRestaurantDetailPresnter.loadDetails(id);
    }

    @Override
    public void setRestaurantDetail(RestaurantDetail detail) {

    }
}
