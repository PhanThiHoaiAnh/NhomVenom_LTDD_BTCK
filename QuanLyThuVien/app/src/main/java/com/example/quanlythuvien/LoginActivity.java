package com.example.quanlythuvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private Button register,back;
    private EditText password;
    private CheckBox showpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register=findViewById(R.id.btn_register);
        password=findViewById(R.id.edt_Lg_Password);
        showpass=findViewById(R.id.cb_LG_showpassword);
        back=findViewById(R.id.btn_LG_back);

        //chuyển qua form đang ký
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(i);
            }
        });
        //hiển thị mật khẩu
        showpass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        //thoát
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(LoginActivity.this,IntroActivity.class);
                startActivity(intent);
            }
        });
    }
}