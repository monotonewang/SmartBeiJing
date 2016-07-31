package com.example.jizha.zhbj.pager.bottom;

import android.app.Activity;
import android.view.Gravity;
import android.widget.TextView;

import com.example.jizha.zhbj.pager.base.BasePager;

/**
 * desc：TODO <br/>
 * time: 2016/7/24 17:09 <br/>
 * author：傅晴望 <br/>
 * since：V TODO <br/>
 */
public class SettingPager extends BasePager {
    public SettingPager (Activity activity) {
        super(activity);
    }

    @Override
    public void initDatas() {
        super.initDatas();
        setSlidingMenuVisiable(false);
        tvTitle.setText("智慧北京");

        TextView textView = new TextView(mActivity);
        textView.setText("设置");
        textView.setGravity(Gravity.CENTER);
        flcontent.addView(textView);
    }
}