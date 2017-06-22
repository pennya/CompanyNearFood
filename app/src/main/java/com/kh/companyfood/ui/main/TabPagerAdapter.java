package com.kh.companyfood.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kh.companyfood.presenter.main.RecommandPresenterImpl;
import com.kh.companyfood.presenter.main.RestaurantPresenterImpl;
import com.kh.companyfood.presenter.main.SettingPresenterImpl;

/**
 * Created by KIM on 2017-06-21.
 */

public class TabPagerAdapter extends FragmentPagerAdapter {

    private static final int PAGE_NUMBER = 3;

    private RestaurantPresenterImpl mRestaurantPresenter;

    private RecommandPresenterImpl mRecommandPresenter;

    private SettingPresenterImpl mSettingPresenter;

    public TabPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch ( position ) {
            case 0: {
                RestaurantTabFragment restaurantTabFragment = RestaurantTabFragment.newInstance();
                mRestaurantPresenter = new RestaurantPresenterImpl(restaurantTabFragment);

                return restaurantTabFragment;
            }

            case 1: {
                RecommandTabFragment recommandTabFragment = RecommandTabFragment.newInstance();
                mRecommandPresenter = new RecommandPresenterImpl(recommandTabFragment);

                return recommandTabFragment;
            }
            case 2: {
                SettingFragment settingFragment = SettingFragment.newInstance();
                mSettingPresenter = new SettingPresenterImpl(settingFragment);

                return settingFragment;
            }
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_NUMBER;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch ( position ) {
            case 0:
                return "음식점리스트";
            case 1:
                return "추천이력";
            case 2:
                return "환경설정";
            default:
                return "Default";
        }
    }
}
