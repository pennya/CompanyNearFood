package com.kh.companyfood.model.restaurant;

import com.kh.companyfood.adapter.restaurant.RecyclerViewData;

import java.util.ArrayList;

/**
 * Created by teruten on 2017-07-10.
 */

public class RestaurantModel {

    private ArrayList<RecyclerViewData> mDataList;
    private RestaurantCallback restaurantCallback;

    public RestaurantModel(RestaurantCallback restaurantCallback){
        this.restaurantCallback = restaurantCallback;
    }

    public void requestRestaurantList(){
        mDataList = new ArrayList<>();
        // Model에게 데이터 요청 및 응답
        mDataList.add(new RecyclerViewData("http://cfs12.blog.daum.net/image/3/blog/2008/09/28/22/44/48df88026332d&filename=IMGP2487.JPG",
                "음식점1"));
        mDataList.add(new RecyclerViewData("http://www.kfoodtimes.com/news/photo/201505/473_792_2546.jpg",
                "음식점2"));
        mDataList.add(new RecyclerViewData("http://cfile201.uf.daum.net/image/1753B0584E074D3D281323",
                "음식점3"));
        mDataList.add(new RecyclerViewData("http://mblogthumb1.phinf.naver.net/20160523_4/smilethai_1464010395021NvgXa_JPEG/%C5%A9%B1%E2%BA%AF%C8%AF_IMG_2543.JPG?type=w800",
                "음식점4"));
        mDataList.add(new RecyclerViewData("http://mblogthumb3.phinf.naver.net/20161002_22/thornof0_1475391044674itSXw_JPEG/image_7911355511475389614492.jpg?type=w800",
                "음식점5"));
        mDataList.add(new RecyclerViewData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsaHKcV4yonYsbhW9pj8kPXfEFzY5fL6A1yCXNdhltZF-9LHRi",
                "음식점6"));

        restaurantCallback.getNetworkResponse(mDataList, 200);
    }
}
