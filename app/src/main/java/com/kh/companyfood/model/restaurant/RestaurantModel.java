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
                                            "음식점1",
                                            "Yoshinoya is in business to create the structure and systems needed to allow our customers access\n" +
                                                    "to the majority of their away-from-home daily meal requirements on a one-stop-shop basis. \n" + "" +
                                                    "All our products shall be of the highest quality and value, be healthy, \n" + "" +
                                                    "nutritious and provided with outstanding personal services at the lowest possible \n" +
                                                    "prices consistent with a fair return on investment for our shareholders, \n" + "" +
                                                    "job enhancement/security for our employees and a level of community involvement by \n" + "" +
                                                    "everyone connected with our business. \n" + "" +
                                                    "All of our products and services shall be delivered consistently \n" + "" +
                                                    "and measured one satisfied customer at a time, \n" + "" +
                                                    "whether by company-owned or franchised operations, in superior, clean, convenient, \n"+ "" +
                                                    " fun and friendly neighborhood environments.", 5, 3));

        mDataList.add(new RecyclerViewData("http://www.kfoodtimes.com/news/photo/201505/473_792_2546.jpg",
                                            "음식점2",
                                            "설명2", 4, 2));
        mDataList.add(new RecyclerViewData("http://cfile201.uf.daum.net/image/1753B0584E074D3D281323",
                                            "음식점3",
                                            "설명3", 2, 10));
        mDataList.add(new RecyclerViewData("http://mblogthumb1.phinf.naver.net/20160523_4/smilethai_1464010395021NvgXa_JPEG/%C5%A9%B1%E2%BA%AF%C8%AF_IMG_2543.JPG?type=w800",
                                            "음식점4",
                                            "설명4", 4, 15));
        mDataList.add(new RecyclerViewData("http://mblogthumb3.phinf.naver.net/20161002_22/thornof0_1475391044674itSXw_JPEG/image_7911355511475389614492.jpg?type=w800",
                                            "음식점5",
                                            "설명5", 1, 1));
        mDataList.add(new RecyclerViewData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsaHKcV4yonYsbhW9pj8kPXfEFzY5fL6A1yCXNdhltZF-9LHRi",
                                            "음식점6",
                                            "설명6",3 , 30));

        restaurantCallback.getNetworkResponse(mDataList, 200);
    }
}
