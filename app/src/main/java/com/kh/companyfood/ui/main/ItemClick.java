package com.kh.companyfood.ui.main;

import android.view.View;

/**
 * Created by KIM on 2017-07-06.
 */

public interface ItemClick {

    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
