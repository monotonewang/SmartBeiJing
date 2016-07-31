package com.example.jizha.zhbj.pager.base;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.jizha.zhbj.R;
import com.example.jizha.zhbj.activity.MainActivity;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * desc：TODO <br/>
 * time: 2016/7/24 16:41 <br/>
 * author：傅晴望 <br/>
 * since：V TODO <br/>
 */
public  class BasePager {
    public Activity mActivity;
    public View mRootView;

    public TextView tvTitle;
    public FrameLayout flcontent;
    public BasePager(Activity activity){
        this.mActivity=activity;
        initView();
    }

    private void initView() {
        mRootView = LayoutInflater.from(mActivity).inflate(R.layout.fragment_pager,null,false);
        tvTitle= (TextView) mRootView.findViewById(R.id.tv_title);
        flcontent= (FrameLayout) mRootView.findViewById(R.id.fl_content);
    }


    public  void initDatas(){

    };

    /**
     * 设置侧边栏的开启与关闭
     * @param enable
     * @return
     */
    public void setSlidingMenuVisiable(boolean enable){
        MainActivity mainActivity= (MainActivity) mActivity;
        SlidingMenu slidingMenu = mainActivity.getSlidingMenu();
        if(enable){
            slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        }else {
            slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        }
    }


}
