package com.example.lxx.atm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by lxx on 2017/8/14.
 */

public class LoginActivity extends AppCompatActivity {
    private EditText id;
    private EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LitePal.getDatabase();  //创建数据库
        //初始化数据库
        User user1=new User();
        user1.setId(1);
        user1.setName("Wangyi");
        user1.setPassword("1");
        user1.setBalance(5000);
        user1.save();

        User user2=new User();
        user2.setId(2);
        user2.setName("xianger");
        user2.setPassword("2");
        user2.setBalance(5000);
        user2.save();

        User user3=new User();
        user3.setId(3);
        user3.setName("Zhangsan");
        user3.setPassword("3");
        user3.setBalance(5000);
        user3.save();

        Button ok = (Button)findViewById(R.id.btn_ok);
        Button cancel =(Button)findViewById(R.id.btn_cancel);
        id = (EditText)findViewById(R.id.id) ;
        password = (EditText)findViewById(R.id.password);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int enterId = Integer.parseInt(id.getText().toString());
                String enterPassword =password.getText().toString();
                //判断密码是否正确
                User user = DataSupport.find(User.class,enterId);
                if(enterPassword.equals(user.getPassword())){
                    UserManager.setCurrentUserId(enterId); //设置当前用户id
                    Intent intent = new Intent(LoginActivity.this,ActionActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"密码错误！",Toast.LENGTH_SHORT).show();
                }

            }
        });

        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(LoginActivity.this,ExitActivity.class);
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