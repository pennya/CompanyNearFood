package com.kh.companyfood.ui.intro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.kh.companyfood.R;
import com.kh.companyfood.Share.SharedUtils;
import com.kh.companyfood.define.Define;
import com.kh.companyfood.presenter.intro.IntroPresenter;
import com.kh.companyfood.presenter.intro.IntroPresenterImpl;
import com.kh.companyfood.ui.login.LoginActivity;
import com.kh.companyfood.ui.main.MainActivity;
import com.kh.companyfood.ui.setting.SettingTabFragment;

public class IntroActivity extends Activity implements IntroPresenter.View{

    private IntroPresenterImpl introPresenterImpl;
    private DelayRunnable delayRunnable;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        introPresenterImpl = new IntroPresenterImpl(getApplicationContext(), this);
        delayRunnable = new DelayRunnable();
        handler = new Handler();
        handler.postDelayed(delayRunnable, 1500);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(delayRunnable);
    }

    @Override
    public void moveMainActivity() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void moveLoginActivity() {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void showToast() {
        Toast.makeText(this, "need to update", Toast.LENGTH_SHORT).show();
        finish();
    }

    public class DelayRunnable implements Runnable {

        @Override
        public void run() {
            introPresenterImpl.onVersionCheck();
        }
    }
}
