package com.example.administrator.movieonline;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.database.Cursor;

public class LoginActivity extends BaseActivity {
    private EditText user_id;
    String us_id;
    private EditText password;
    String passwd;
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        TextView tv = (TextView) findViewById(R.id.title);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "wryh.ttf");
        tv.setTypeface(typeface);
        user_id = (EditText) findViewById(R.id.user_id);
        password = (EditText) findViewById(R.id.password);

        us_id = user_id.getText().toString();
        passwd = password.getText().toString();

        dbHelper = new MyDatabaseHelper(this, "Cinema.db", null, 1);
        Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String u_id = null;
                String pwd = null;
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.query("Account", new String[] { "a_id", "password" }, "a_id = user_id",
                        null, null, null, null);
                if (cursor.moveToFirst()) {

                    do {
                        u_id = cursor.getString(cursor.getColumnIndex("a_id"));
                        //passwd = cursor.getString(cursor.getColumnIndex("password"));
                    } while (cursor.moveToNext());
                }
                cursor.close();
                if (u_id == us_id) {

                }
                //if (passwd == password) {

                //}
            }
        });
        Button register = (Button) findViewById(R.id.register);



        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                login();
            }
        });
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void login(){
        boolean success_validate = true;
        // Store values at the time of the login attempt.
        String email = user_id.getText().toString();
        String pw = password.getText().toString();

        //simple validation
        if(email.isEmpty()){
            user_id.setError("请输入邮箱地址！");
            success_validate = false;
        }else if(pw.isEmpty()){
            password.setError("请输入密码！");
            success_validate = false;
        } else if (!isEmailValid(email)) {
            user_id.setError("输入不是有效的邮箱地址，请重新输入！");
            user_id.setText("");
            user_id.setFocusable(true);
            success_validate = false;
        }

        //Database validation

        //login
        if(success_validate){
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

}
