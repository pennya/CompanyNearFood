package com.kh.companyfood.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kh.companyfood.ui.recommand.RecommandTabFragment;
import com.kh.companyfood.ui.restaurant.RestaurantTabFragment;
import com.kh.companyfood.ui.setting.SettingTabFragment;

/**
 * Created by KIM on 2017-06-21.
 */

public class TabPagerAdapter extends FragmentPagerAdapter {

    private static final int PAGE_NUMBER = 3;

    public TabPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch ( position ) {
            case 0: {
                RestaurantTabFragment restaurantTabFragment = RestaurantTabFragment.newInstance();
                return restaurantTabFragment;
            }

            case 1: {
                RecommandTabFragment recommandTabFragment = RecommandTabFragment.newInstance();
                return recommandTabFragment;
            }
            case 2: {
                SettingTabFragment settingTabFragment = SettingTabFragment.newInstance();
                return settingTabFragment;
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
