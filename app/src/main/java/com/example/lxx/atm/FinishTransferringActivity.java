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

public class FinishTransferringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_transfer);
        Button con = (Button)findViewById(R.id.btn_continue);
        Button exit = (Button)findViewById(R.id.btn_exit);

        //点击继续回到操作界面
        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinishTransferringActivity.this,ActionActivity.class);
                startActivity(intent);
            }
        });

        //点击退卡
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinishTransferringActivity.this,ExitActivity.class);
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
