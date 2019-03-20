package com.example.administrator.movieonline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class RegisterActivity extends BaseActivity {
    private EditText re_password1;
    private EditText re_password2;
    private EditText user_id;
    private EditText validate;
    private String validate_code="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        re_password1= (EditText) findViewById(R.id.re_password1);
        re_password2= (EditText) findViewById(R.id.re_password2);
        user_id = (EditText) findViewById(R.id.re_user_id);
        validate = (EditText) findViewById(R.id.validate);
        Button send_validate = (Button) findViewById(R.id.send_validate);
        Button complete = (Button) findViewById(R.id.complete_register);

        send_validate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //generate validate code
                Random random = new Random();
                for (int i=0;i<6;i++)
                {
                    validate_code+=random.nextInt(10);
                }

                //send code for validate

            }
        });

        complete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                build_account();
            }
        });
    }

    private void build_account(){
        boolean success_validate = true;
        // Store values at the time of the login attempt.
        String email =user_id.getText().toString();
        String pw1 = re_password1.getText().toString();
        String pw2 = re_password2.getText().toString();
        String code_validate = validate.getText().toString();

        //Data validation
        if(email.isEmpty()){
            user_id.setError("请输入邮箱地址！");
            user_id.setFocusable(true);
            success_validate = false;
        }else if(pw1.isEmpty()){
            re_password1.setError("请输入密码！");
            re_password1.setFocusable(true);
            success_validate = false;
        }else if(pw2.isEmpty()){
            re_password2.setError("请输入密码！");
            re_password2.setFocusable(true);
            success_validate = false;
        }else if(!pw1.equals(pw2)){
            Toast.makeText(RegisterActivity.this, "密码不一致，请重新输入！", Toast.LENGTH_SHORT).show();
            re_password2.setText("");
            re_password2.setFocusable(true);
            success_validate = false;
        }else if (!isEmailValid(email)) {
            user_id.setError("输入不是有效的邮箱地址，请重新输入！");
            user_id.setText("");
            user_id.setFocusable(true);
            success_validate = false;
        }else if(!code_validate.equals(validate_code)){
            validate.setError("验证码输入错误！");
            validate.setText("");
            validate.setFocusable(true);
            success_validate = false;
        }
        //Process data in database


        if(success_validate){
            Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }
}
