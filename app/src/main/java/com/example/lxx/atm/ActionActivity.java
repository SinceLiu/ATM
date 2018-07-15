package com.example.lxx.atm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

/**
 * Created by lxx on 2017/8/14.
 */

public class ActionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);
        Button checkBalance,drawMoney,saveMoney,transfer,changePassword,exit;
        checkBalance=(Button)findViewById(R.id.checkBalance);
        drawMoney=(Button)findViewById(R.id.drawMoney);
        saveMoney=(Button)findViewById(R.id.saveMoney);
        transfer=(Button)findViewById(R.id.transfer);
        changePassword=(Button)findViewById(R.id.changePassword);
        exit=(Button)findViewById(R.id.exit);

        //点击查询余额
        checkBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActionActivity.this,CheckBalanceActivity.class);
                startActivity(intent);
            }
        });

        //点击取款
        drawMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActionActivity.this,DrawMoneyActivity.class);
                startActivity(intent);
            }
        });

        //点击存款
        saveMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActionActivity.this,SaveMoneyActivity.class);
                startActivity(intent);
            }
        });

        //点击转账
        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActionActivity.this,TransferActivity.class);
                startActivity(intent);
            }
        });

        //点击修改密码
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActionActivity.this,ChangePasswordActivity.class);
                startActivity(intent);
            }
        });

        //点击退卡
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActionActivity.this,ExitActivity.class);
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