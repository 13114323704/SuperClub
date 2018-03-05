package com.competition.superclub.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.competition.superclub.R;


/**
 * Created by 黄庆 on 2018/2/5.
 */

public class LoginActivity extends AppCompatActivity{

    private EditText editText_username,editText_password;
    private Button btn_login;
    private TextView textView_register;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        //editText_username=this.findViewById(R.id.edittext_username);
        //editText_password=this.findViewById(R.id.edittext_password);
        btn_login=this.findViewById(R.id.btn_login);
        textView_register=this.findViewById(R.id.textview_register);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if(editText_username.getText().toString().equals("admin")&&editText_password.getText().toString().equals("123")){
                    Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(intent);
                //}else{
                //    Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_LONG).show();
                //}
            }
        });
        textView_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.ACTION_DOWN){

        }
        return super.onKeyDown(keyCode, event);

    }
}
