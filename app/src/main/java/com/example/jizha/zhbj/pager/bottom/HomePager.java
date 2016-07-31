package com.example.jizha.zhbj.pager.bottom;

import android.app.Activity;
import android.view.Gravity;
import android.widget.TextView;

import com.example.jizha.zhbj.pager.base.BasePager;
import com.example.jizha.zhbj.utils.OkioUtils;

/**
 * desc：TODO <br/>
 * time: 2016/7/24 16:41 <br/>
 * author：傅晴望 <br/>
 * since：V TODO <br/>
 */
public class HomePager extends BasePager {
    private Activity mActivity;

    public HomePager(Activity activity) {
        super(activity);
        this.mActivity=activity;
    }

    @Override
    public void initDatas() {
        super.initDatas();
        setSlidingMenuVisiable(false);
        tvTitle.setText("智慧北京");

        TextView textView = new TextView(mActivity);
        OkioUtils.setString();
        String string = OkioUtils.getString();
        textView.setText("首页");
        textView.setText(string);
        textView.setGravity(Gravity.CENTER);
        flcontent.addView(textView);
    }


}
