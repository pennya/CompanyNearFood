package com.kh.companyfood.ui.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kh.companyfood.R;
import com.kh.companyfood.define.Define;
import com.kh.companyfood.presenter.login.LoginPresenter;
import com.kh.companyfood.presenter.login.LoginPresenterImpl;
import com.kh.companyfood.ui.main.MainActivity;

public class SignUpActivity extends AppCompatActivity implements LoginPresenter.View{

    private LoginPresenterImpl loginPresenter;
    private Button button_signup;
    private EditText editText_id;
    private EditText editText_pw;
    private EditText editText_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        
        init();
        loginPresenter = new LoginPresenterImpl(this, this);
    }

    Button.OnClickListener mButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            loginPresenter.actionJoinUser(editText_id.getText().toString(),
                    editText_pw.getText().toString(),
                    editText_email.getText().toString());
        }
    };

    private void init() {
        button_signup = (Button)findViewById(R.id.button_signup);
        editText_id = (EditText)findViewById(R.id.editText_signup_id);
        editText_pw = (EditText)findViewById(R.id.editText_signup_pw);
        editText_email = (EditText)findViewById(R.id.editText_signup_email);

        button_signup.setOnClickListener(mButtonClickListener);
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void actionResult(int loginSuccess) {
        Intent intent = null;
        switch(loginSuccess) {
            case Define.SIGNUP_SUCCESS:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
