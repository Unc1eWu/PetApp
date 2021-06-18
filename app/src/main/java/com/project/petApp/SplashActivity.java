package com.project.petApp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.project.petApp.util.TypefaceUtil;

public class SplashActivity extends AppCompatActivity {
    protected Handler mHandler=new Handler();
    protected TextView tv1,tv2;
    protected Context mContext= SplashActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        tv1=findViewById(R.id.text1);
        tv2=findViewById(R.id.text2);

//        FontsUtils.setAppTypeface(mContext);

        TypefaceUtil tfUtil = new TypefaceUtil(mContext, "fonts/aa.ttf");
        tfUtil.setTypeface(tv1,false);
        tfUtil.setTypeface(tv2,false);
//        TextView tv = findViewById(R.id.text1);
//        Typeface typeface = Typeface.createFromAsset(mContext.getAssets(), "fonts/simkai.ttf");  // mContext为上下文
//        tv.setTypeface(typeface );

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        },4000);//2秒钟之后进入闪屏页
    }
}
