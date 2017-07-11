package com.kh.companyfood.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kh.companyfood.R;
import com.kh.companyfood.define.Define;
import com.kh.companyfood.presenter.login.LoginPresenter;
import com.kh.companyfood.presenter.login.LoginPresenterImpl;
import com.kh.companyfood.ui.main.MainActivity;
import com.kh.companyfood.ui.signUp.SignUpActivity;

public class LoginActivity extends AppCompatActivity implements LoginPresenter.View, View.OnClickListener{

    LoginPresenterImpl loginPresenter;
    private Button button;
    private EditText editTextId;
    private EditText editTextPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        editTextId = (EditText)findViewById(R.id.editText_id);
        editTextPw = (EditText)findViewById(R.id.editText_pw);

        button = (Button) findViewById(R.id.button_login);
        button.setOnClickListener(this);

        loginPresenter = new LoginPresenterImpl(this, this);
    }

    @Override
    public void moveMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
        Log.d("test1", "LoginActivity showToast");
    }

    @Override
    public void actionResult(int loginSuccess) {
        Intent intent = null;
        switch(loginSuccess) {
            case Define.LOGIN_SUCCESS:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_login:
                loginPresenter.actionLogin(editTextId.getText().toString(), editTextPw.getText().toString());
                break;
            case R.id.fab:
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
