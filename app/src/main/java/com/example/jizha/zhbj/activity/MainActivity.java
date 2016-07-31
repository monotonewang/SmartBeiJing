package com.example.jizha.zhbj.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;

import com.example.jizha.zhbj.R;
import com.example.jizha.zhbj.fragment.ContentFragment;
import com.example.jizha.zhbj.fragment.LeftMenuFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

/**
 * desc：TODO <br/>
 * time: 2016/7/24 11:34 <br/>
 * author：傅晴望 <br/>
 * since：V TODO <br/>
 */
public class MainActivity extends SlidingFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_mainfirst);
        setBehindContentView(R.layout.left_menu);

        SlidingMenu slidingMenu = getSlidingMenu();

        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        float density = getResources().getDisplayMetrics().density;
        int v = (int) (200 * density + 0.5f);
        slidingMenu.setBehindOffset(v);

        initFragment();
    }

    /**
     * 将Fragment的数据填充到数据中
     */
    private void initFragment(){
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
//        if()
        fragmentTransaction.replace(R.id.fl_left_menu,new LeftMenuFragment(),"left");
        fragmentTransaction.add(R.id.ll_main_content, new ContentFragment(), "content");
        fragmentTransaction.commit();
    }

    public Fragment getLeftMenuFragment(){
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment left = supportFragmentManager.findFragmentByTag("left");
        return  left;
    }
    public Fragment getContentFragment(){
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment left = supportFragmentManager.findFragmentByTag("content");
        return  left;
    }
}
