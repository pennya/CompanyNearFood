package com.kh.companyfood.ui.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kh.companyfood.R;
import com.kh.companyfood.presenter.main.SettingContract;
import com.kh.companyfood.presenter.main.SettingPresenterImpl;

public class SettingFragment extends Fragment implements SettingContract.View{

    private SettingPresenterImpl mPresenter;

    private TextView mTextView;

    private Button mButton;

    public SettingFragment() {
        // Required empty public constructor
    }

    public static SettingFragment newInstance() {
        return new SettingFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.setting_frag, container, false);
        mTextView = (TextView)root.findViewById(R.id.text_sample);
        mButton = (Button)root.findViewById(R.id.btn_sample);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mPresenter = new SettingPresenterImpl(this);

        return root;
    }

    @Override
    public void ShowToast(String text) {
        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
    }
}
