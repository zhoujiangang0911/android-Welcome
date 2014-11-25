package com.zhoujg77.viewpager;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.util.logging.LogRecord;

/**
 * Created by 建刚 on 2014/11/24.
 */
public class Welcome extends Activity {
    private static final int TIME =2000;
    private static final int GOHOME = 1000;
    private static final int GOGUIDE = 1001;
    private boolean isFirstIn = false;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case GOHOME:
                     goHome();
                    break;
                case GOGUIDE:
                     goGuide();

                    break;


            }
        };
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcoem);
        init();
    }

    private void init(){
        SharedPreferences preferences = getSharedPreferences("flag",MODE_PRIVATE);
        isFirstIn = preferences.getBoolean("isFirstIn",true);
        if (!isFirstIn){
            handler.sendEmptyMessageDelayed(GOHOME,TIME);
        }else {
            handler.sendEmptyMessageDelayed(GOGUIDE,TIME);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("isFirstIn",false);
            editor.commit();
        }


    }

    private void goHome(){
        Intent intent = new Intent(Welcome.this,MainActivity.class);
        startActivity(intent);
        finish();

    }


    private void goGuide(){
        Intent intent = new Intent(Welcome.this,Guide.class);
        startActivity(intent);
        finish();

    }

}
