package com.example.lxx.atm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

/**
 * Created by lxx on 2017/8/14.
 */

public class TransferActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        final EditText id,checkId,money;
        Button ok,cancel;
        id=(EditText)findViewById(R.id.id);
        checkId=(EditText)findViewById(R.id.checkId);
        money=(EditText)findViewById(R.id.money);
        ok=(Button)findViewById(R.id.btn_ok);
        cancel=(Button)findViewById(R.id.btn_cancel);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id1 = id.getText().toString();
                String id2 = checkId.getText().toString();
                //先判断两次输入的帐号一致否，接着判断帐号存在否，再判断余额足否,通过Toast提示
                if(id1.equals(id2)) {//帐号一致否
                    int tId = Integer.parseInt(id1);
                    User user1 = DataSupport.find(User.class, tId);
                    User user2 = DataSupport.find(User.class, UserManager.getCurrentUserId());
                    double transferMoney = Double.parseDouble(money.getText().toString());
                    if (user2.getBalance() >= transferMoney) { //余额是否充足
                        user2.setBalance(user2.getBalance() - transferMoney);
                        user2.save();
                        user1.setBalance(user1.getBalance() + transferMoney);
                        user1.save();
                        Intent intent = new Intent(TransferActivity.this, FinishTransferringActivity.class);
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(TransferActivity.this, BeyondBalanceActivity.class);
                        startActivity(intent);
                        }
                    }else{
                        Toast.makeText(getApplicationContext(),"两次输入的帐号不一致！",Toast.LENGTH_SHORT).show();
                    }

            }
        });

        //点击取消回到操作界面
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TransferActivity.this,ActionActivity.class);
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
