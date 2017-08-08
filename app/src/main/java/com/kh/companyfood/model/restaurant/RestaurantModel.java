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
        mDataList.add(new RecyclerViewData(3, "http://cfs12.blog.daum.net/image/3/blog/2008/09/28/22/44/48df88026332d&filename=IMGP2487.JPG",
                                            "음식점1",
                                            "설명1", 5, 3));

        mDataList.add(new RecyclerViewData(0, "http://www.kfoodtimes.com/news/photo/201505/473_792_2546.jpg",
                                            "음식점2",
                                            "설명2", 4, 2));
        mDataList.add(new RecyclerViewData(2, "http://cfile201.uf.daum.net/image/1753B0584E074D3D281323",
                                            "음식점3",
                                            "설명3", 2, 10));
        mDataList.add(new RecyclerViewData(1, "http://mblogthumb1.phinf.naver.net/20160523_4/smilethai_1464010395021NvgXa_JPEG/%C5%A9%B1%E2%BA%AF%C8%AF_IMG_2543.JPG?type=w800",
                                            "음식점4",
                                            "설명4", 4, 15));
        mDataList.add(new RecyclerViewData(5, "http://mblogthumb3.phinf.naver.net/20161002_22/thornof0_1475391044674itSXw_JPEG/image_7911355511475389614492.jpg?type=w800",
                                            "음식점5",
                                            "설명5", 1, 1));
        mDataList.add(new RecyclerViewData(4, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsaHKcV4yonYsbhW9pj8kPXfEFzY5fL6A1yCXNdhltZF-9LHRi",
                                            "음식점6",
                                            "설명6",3 , 30));

        restaurantCallback.getNetworkResponse(mDataList, 200);
    }
}
