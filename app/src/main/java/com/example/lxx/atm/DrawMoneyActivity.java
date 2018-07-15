package com.example.lxx.atm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import org.litepal.crud.DataSupport;

/**
 * Created by lxx on 2017/8/14.
 */

public class DrawMoneyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_money);
        //获取id，balance
        int id = UserManager.getCurrentUserId();
        final User user = DataSupport.find(User.class,id);
        final double balance = user.getBalance();

        Button btn100,btn200,btn300,btn400,btn500,others,back,exit;
        btn100=(Button)findViewById(R.id.btn_100yuan);
        btn200=(Button)findViewById(R.id.btn_200yuan);
        btn300=(Button)findViewById(R.id.btn_300yuan);
        btn400=(Button)findViewById(R.id.btn_400yuan);
        btn500=(Button)findViewById(R.id.btn_500yuan);
        others=(Button)findViewById(R.id.btn_others);
        back=(Button)findViewById(R.id.btn_back);
        exit=(Button)findViewById(R.id.btn_exit);

        //点击取款100元
        btn100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断余额是否充足
                if (balance >= 100) {
                    user.setBalance(balance-100);
                    user.save();
                    Intent intent = new Intent(DrawMoneyActivity.this, FinishDrawingActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(DrawMoneyActivity.this, BeyondBalanceActivity.class);
                    startActivity(intent);
                }
            }
        });
        //点击取款200元
        btn200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断余额是否充足
                if (balance >= 200) {
                    user.setBalance(balance-200);
                    user.save();
                    Intent intent = new Intent(DrawMoneyActivity.this, FinishDrawingActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(DrawMoneyActivity.this, BeyondBalanceActivity.class);
                    startActivity(intent);
                }
            }
        });
        //点击取款300元
        btn300.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断余额是否充足
                if (balance >= 300) {
                    user.setBalance(balance-300);
                    user.save();
                    Intent intent = new Intent(DrawMoneyActivity.this, FinishDrawingActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(DrawMoneyActivity.this, BeyondBalanceActivity.class);
                    startActivity(intent);
                }
            }
        });
        //点击取款400元
        btn400.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断余额是否充足
                if (balance >= 400) {
                    user.setBalance(balance-400);
                    user.save();
                    Intent intent = new Intent(DrawMoneyActivity.this, FinishDrawingActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(DrawMoneyActivity.this, BeyondBalanceActivity.class);
                    startActivity(intent);
                }
            }
        });
        //点击取款500元
        btn500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断余额是否充足
                if (balance >= 500) {
                    user.setBalance(balance-500);
                    user.save();
                    Intent intent = new Intent(DrawMoneyActivity.this, FinishDrawingActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(DrawMoneyActivity.this, BeyondBalanceActivity.class);
                    startActivity(intent);
                }
            }
        });
        //点击其他面额
        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DrawMoneyActivity.this,InputMoneyActivity.class);
                startActivity(intent);
            }
        });

        //点击返回
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DrawMoneyActivity.this,ActionActivity.class);
                startActivity(intent);
            }
        });
        //点击退卡
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DrawMoneyActivity.this,ExitActivity.class);
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