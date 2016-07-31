package com.example.jizha.zhbj.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * desc：TODO <br/>
 * time: 2016/7/24 17:19 <br/>
 * author：傅晴望 <br/>
 * since：V TODO <br/>
 */
public class NoScollViewPager extends ViewPager {


    public NoScollViewPager(Context context) {
        super(context);
    }

    public NoScollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    /**
     * 返回false表示不拦截
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
