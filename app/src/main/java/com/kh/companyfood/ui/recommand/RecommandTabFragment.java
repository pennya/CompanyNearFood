package com.kh.companyfood.ui.recommand;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kh.companyfood.R;
import com.kh.companyfood.presenter.recommand.RecommandPresenter;
import com.kh.companyfood.presenter.recommand.RecommandPresenterImpl;

public class RecommandTabFragment extends Fragment implements RecommandPresenter.View, View.OnClickListener{

    private static final String TAG = "KJH";

    private RecommandPresenterImpl mPresenter;

    private TextView mTextView;

    private Button mButton;

    public RecommandTabFragment() {

    }

    public static RecommandTabFragment newInstance() {
        return new RecommandTabFragment();
    }

    @Nullable
    @Override
    public android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_recommand, container, false);
        mTextView = (TextView)root.findViewById(R.id.text_sample);
        mButton = (Button)root.findViewById(R.id.button_sample);
        mButton.setOnClickListener(this);
        mPresenter = new RecommandPresenterImpl(this);

        return root;
    }

    @Override
    public void ShowToast(String text) {
        mTextView.setText(text);
        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button_sample:
                // UI Checkbox Values
                int[] category = new int[] {1,3};
                int[] weather = new int[] {1,3};
                int[] distance = new int[] {1,2};

                mPresenter.buttonClickAction(category, weather, distance);
                break;
        }
    }
}