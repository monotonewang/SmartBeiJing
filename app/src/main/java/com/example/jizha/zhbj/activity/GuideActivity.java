package com.example.jizha.zhbj.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.jizha.zhbj.R;
import com.example.jizha.zhbj.utils.ShareUtils;

import java.util.ArrayList;

/**
 * desc：TODO <br/>
 * time: 2016/7/24 8:26 <br/>
 * author：季扎 <br/>
 * since：V TODO <br/>
 */
public class GuideActivity extends Activity {

    private final int[] mImageIds = new int[]{R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};
    private ViewPager viewPager;
    private ArrayList<ImageView> imageViews;
    private LinearLayout llPoint;
    private int pointDis;
    private View viewRedPoint;
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        llPoint = (LinearLayout) findViewById(R.id.ll_point);
        viewRedPoint = findViewById(R.id.viewRedPoint);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareUtils.setBoolean(GuideActivity.this,"in",true);

                Intent intent=new Intent(GuideActivity.this,WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        initViews();
        viewPager.setAdapter(new GuidePager());
        viewPager.addOnPageChangeListener(new GuideListener());
    }




    /**
     * 初始化界面
     */
    private void initViews() {
        imageViews = new ArrayList<>();
        for (int i = 0; i < mImageIds.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(mImageIds[i]);
            imageViews.add(imageView);
        }

        //初始化小圆点
        for (int i = 0; i < mImageIds.length; i++) {
            View imageView = new View(this);
            imageView.setBackgroundResource(R.drawable.shape_point_gray);
            float density = this.getResources().getDisplayMetrics().density;
            int v = (int) (10 * density + 0.5f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(v, v);
            if (i > 0) {
                layoutParams.leftMargin = 20;
            }
            imageView.setLayoutParams(layoutParams);
            llPoint.addView(imageView);
            final ViewTreeObserver viewTreeObserver = llPoint.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    pointDis = llPoint.getChildAt(1).getLeft() - llPoint.getChildAt(0).getLeft();
                    llPoint.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        }
    }

    class GuidePager extends PagerAdapter {

        @Override
        public int getCount() {
            return mImageIds.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageViews.get(position));
            return imageViews.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    /**
     * 监听ViewPager
     */
    class GuideListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewRedPoint.getLayoutParams();
            layoutParams.leftMargin = ((int) (pointDis * positionOffset)) + position * pointDis;
            viewRedPoint.setLayoutParams(layoutParams);
        }

        @Override
        public void onPageSelected(int position) {
            if (position == mImageIds.length - 1) {
                btnStart.setVisibility(View.VISIBLE);
            }else{
                btnStart.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
