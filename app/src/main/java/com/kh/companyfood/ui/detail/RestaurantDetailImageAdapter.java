package com.kh.companyfood.ui.detail;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kh.companyfood.R;
import com.kh.companyfood.vo.Image;

/**
 * Created by KIM on 2017-08-21.
 */

public class RestaurantDetailImageAdapter extends PagerAdapter {

    private LayoutInflater layoutInflater;
    private Context context;
    private Image[] images;

    public RestaurantDetailImageAdapter(Context context, Image[] images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.content_restaurant_detail_images, container, false);
        ImageView imageViewPreview = (ImageView) view.findViewById(R.id.image_preview);

        Image image = images[position];
        Glide.with(context)
                .load(image.getPath())
                .into(imageViewPreview);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
