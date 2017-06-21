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

public class LoginActivity extends AppCompatActivity implements LoginPresenter.View{

    LoginPresenterImpl loginPresenter;
    private Button button;
    private EditText editText_id;
    private EditText editText_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

        editText_id = (EditText)findViewById(R.id.editText_id);
        editText_pw = (EditText)findViewById(R.id.editText_pw);

        button = (Button) findViewById(R.id.button_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("test1", "LoginActivity onClick");
                loginPresenter.actionLogin(editText_id.getText().toString(), editText_pw.getText().toString());
            }
        });

        loginPresenter = new LoginPresenterImpl(this, this);
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
}
