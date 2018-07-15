package com.example.lxx.atm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.litepal.crud.DataSupport;


import java.util.List;

/**
 * Created by lxx on 2017/8/14.
 */

public class CheckBalanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_balance);
        TextView balance =(TextView)findViewById(R.id.balance);
        Button con,exit;

        con = (Button)findViewById(R.id.btn_continue);
        exit = (Button)findViewById(R.id.btn_exit);
        //显示余额
        User user1 = DataSupport.find(User.class,UserManager.getCurrentUserId());
        balance.setText(String.valueOf(user1.getBalance()));



        //点击继续回到操作界面
        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckBalanceActivity.this,ActionActivity.class);
                startActivity(intent);
            }
        });

        //点击退卡
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckBalanceActivity.this,ExitActivity.class);
                startActivity(intent);
            }
        });
    }
    //禁用手机自带返回键
    public boolean onKeyDown(int keyCode,KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK){
            return true;
        }
        return false;
    }
}