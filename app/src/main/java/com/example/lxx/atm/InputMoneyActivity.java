package com.example.lxx.atm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.litepal.crud.DataSupport;

/**
 * Created by lxx on 2017/8/14.
 */

public class InputMoneyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_money);
        final EditText money = (EditText)findViewById(R.id.money);
        Button ok =(Button)findViewById(R.id.btn_ok);
        Button cancel =(Button)findViewById(R.id.btn_cancel);


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Double drawMoney = Double.parseDouble(money.getText().toString());
                //判断余额是否充足
                User user = DataSupport.find(User.class,UserManager.getCurrentUserId());
                if (user.getBalance() >= drawMoney) {
                    user.setBalance(user.getBalance()-drawMoney);
                    user.save();
                    Intent intent = new Intent(InputMoneyActivity.this, FinishDrawingActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(InputMoneyActivity.this, BeyondBalanceActivity.class);
                    startActivity(intent);
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InputMoneyActivity.this,ActionActivity.class);
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
