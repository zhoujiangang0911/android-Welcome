package com.zhoujg77.viewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by 建刚 on 2014/11/24.
 */
public class ViewPagerAdapter extends PagerAdapter {
    private List<View> views;
    private Context context;

    public ViewPagerAdapter(List<View> views,Context context){
        this.views = views;
        this.context = context;

    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager)container).removeView(views.get(position));

    }


    @Override
    public Object instantiateItem(View container, int position) {
        ((ViewPager)container).addView(views.get(position));

        return views.get(position);
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return (view == o);
    }
}
