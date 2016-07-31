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
public class GovPager extends BasePager {
    public GovPager (Activity activity) {
        super(activity);
    }

    @Override
    public void initDatas() {
        super.initDatas();
        tvTitle.setText("智慧北京");
        setSlidingMenuVisiable(false);
        TextView textView = new TextView(mActivity);
        textView.setText("政务");
        textView.setGravity(Gravity.CENTER);
        flcontent.addView(textView);
    }
}
