package com.zhoujg77.viewpager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 建刚 on 2014/11/24.
 */
public class Guide extends Activity implements ViewPager.OnPageChangeListener{
    private ViewPager vp;
    private ViewPagerAdapter vpAdapterr;
    private List<View> views;
    private ImageView [] dots;
    private int [] ids ={R.id.iv1,R.id.iv2,R.id.iv3};

    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);

        initView();
        initDots();

    }


    private void initView(){
        final LayoutInflater inflater = LayoutInflater.from(this);

        views = new ArrayList<View>();
        views.add(inflater.inflate(R.layout.one,null));
        views.add(inflater.inflate(R.layout.two,null));
        views.add(inflater.inflate(R.layout.three,null));

        vpAdapterr = new ViewPagerAdapter(views,this);

        vp= (ViewPager) findViewById(R.id.viewpage);
        vp.setAdapter(vpAdapterr);
        vp.setOnPageChangeListener(this);
        button = (Button) views.get(2).findViewById(R.id.btn_start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Guide.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void initDots(){
        dots = new ImageView[views.size()];
        for (int i =0;i<views.size();i++){
            dots[i] = (ImageView) findViewById(ids[i]);
        }

    }


    @Override
    public void onPageScrolled(int i, float v, int i2) {

    }

    @Override
    public void onPageSelected(int arg0) {
            for (int i=0;i<ids.length;i++){
                    if (arg0==i){
                        dots[i].setImageResource(R.drawable.login_point_selected
                        );
                    }else {
                        dots[i].setImageResource(R.drawable.login_point);
                    }
            }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
