package com.example.jizha.zhbj.pager.base;

import android.app.Activity;
import android.view.View;

/**
 * desc：TODO <br/>
 * time: 2016/7/31 13:51 <br/>
 * author：傅晴望 <br/>
 * since：V TODO <br/>
 */
public abstract class BaseMenuPager {
    public Activity activity;
    public View mRootView;

    public BaseMenuPager(Activity activity) {
        this.activity = activity;
        mRootView = initView();
    }

    public abstract View initView();

    public  void initDatas() {

    }

    ;
}
