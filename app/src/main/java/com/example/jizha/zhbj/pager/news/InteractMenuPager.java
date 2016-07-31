package com.example.jizha.zhbj.pager.news;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.jizha.zhbj.pager.base.BaseMenuPager;

/**
 * desc：TODO <br/>
 * time: 2016/7/31 14:00 <br/>
 * author：傅晴望 <br/>
 * since：V TODO <br/>
 */
public class InteractMenuPager extends BaseMenuPager {


    public InteractMenuPager(Activity activity) {
        super(activity);
    }

    @Override
    public View initView() {
        TextView textView = new TextView(activity);
//        OkioUtils.setString();
//        String string = OkioUtils.getString();
        textView.setText("新闻详情-互动");
//        textView.setText(string);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }
}
