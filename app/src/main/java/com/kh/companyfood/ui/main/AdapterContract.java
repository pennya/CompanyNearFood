package com.kh.companyfood.ui.main;

import java.util.ArrayList;

/**
 * Created by KIM on 2017-06-23.
 */

public interface AdapterContract {

    void notifyAdapter();

    void setItems(ArrayList<RecyclerViewData> dataList);

}
