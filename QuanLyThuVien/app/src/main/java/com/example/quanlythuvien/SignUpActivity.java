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

public class SignUpActivity extends AppCompatActivity {
    private EditText password;
    private CheckBox showpass;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        password=findViewById(R.id.edt_SU_Password);
        showpass=findViewById(R.id.cb_SU_showpassword);
        back =findViewById(R.id.btn_SU_back);
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
        // về intro
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignUpActivity.this,IntroActivity.class);
                startActivity(intent);
            }
        });
    }
}