package com.kh.companyfood.ui.signUp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kh.companyfood.R;
import com.kh.companyfood.define.Define;
import com.kh.companyfood.presenter.login.LoginPresenter;
import com.kh.companyfood.presenter.login.LoginPresenterImpl;
import com.kh.companyfood.presenter.signUp.SignUpPresenter;
import com.kh.companyfood.presenter.signUp.SignUpPresenterImpl;
import com.kh.companyfood.ui.login.LoginActivity;
import com.kh.companyfood.vo.User;

public class SignUpActivity extends AppCompatActivity implements SignUpPresenter.View, View.OnClickListener{

    private SignUpPresenterImpl signUpPresenterImpl;
    private Button buttonSignup;
    private EditText editTextId;
    private EditText editTextPw;
    private EditText editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        
        init();
        signUpPresenterImpl = new SignUpPresenterImpl(this, this);
    }

    private void init() {
        buttonSignup = (Button)findViewById(R.id.button_signup);
        editTextId = (EditText)findViewById(R.id.editText_signup_id);
        editTextPw = (EditText)findViewById(R.id.editText_signup_pw);
        editTextEmail = (EditText)findViewById(R.id.editText_signup_email);

        buttonSignup.setOnClickListener(this);
    }

    @Override
    public void moveMainActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_signup:
                User user = new User(editTextId.getText().toString(),
                        editTextPw.getText().toString(),
                        editTextEmail.getText().toString());

                signUpPresenterImpl.actionJoinUser(user);
                break;
        }
    }
}
