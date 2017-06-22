package com.kh.companyfood.ui.main;

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
import com.kh.companyfood.presenter.main.RecommandContract;

public class RecommandTabFragment extends Fragment implements RecommandContract.View {

    private static final String TAG = "KJH";

    private RecommandContract.Presenter mPresenter;

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
        View root = inflater.inflate(R.layout.recommand_frag, container, false);
        mTextView = (TextView)root.findViewById(R.id.text_sample);
        mButton = (Button)root.findViewById(R.id.btn_sample);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.buttonClickAction();
            }
        });
        return root;
    }

    @Override
    public void setPresenter(RecommandContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void ShowToast(String text) {
        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
    }
}
