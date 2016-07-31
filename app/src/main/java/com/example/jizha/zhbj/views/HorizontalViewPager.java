package com.example.jizha.zhbj.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * desc：TODO <br/>
 * time: 2016/7/31 20:38 <br/>
 * author：傅晴望 <br/>
 * since：V TODO <br/>
 */
public class HorizontalViewPager extends ViewPager {
    public HorizontalViewPager(Context context) {
        super(context);
    }

    public HorizontalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(getCurrentItem()!=0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }else{
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(ev);

    }
}
