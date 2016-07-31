package com.example.jizha.zhbj.pager.news;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jizha.zhbj.R;
import com.example.jizha.zhbj.activity.MainActivity;
import com.example.jizha.zhbj.bean.NewsBean;
import com.example.jizha.zhbj.pager.base.BaseMenuPager;
import com.example.jizha.zhbj.pager.news.child.NewsTabDetailPager;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * desc：TODO <br/>
 * time: 2016/7/31 13:57 <br/>
 * author：傅晴望 <br/>
 * since：V TODO <br/>
 */
public class NewsDetailPager extends BaseMenuPager {

    private ArrayList<NewsTabDetailPager> newsTabDetailPagers;
    private ArrayList<NewsBean.DataBean.ChildrenBean> childrenBeans;//data 数据
    private ViewPager viewPager;
    private TabPageIndicator tabPageIndicator;
    private MainActivity mainActivity;

    public NewsDetailPager(Activity activity, List<NewsBean.DataBean.ChildrenBean> childrenBeans) {
        super(activity);
        this.childrenBeans = (ArrayList<NewsBean.DataBean.ChildrenBean>) childrenBeans;
    }

    @Override
    public View initView() {
        View view = LayoutInflater.from(activity).inflate(R.layout.fragment_news_vp, null, false);
        ViewUtils.inject(this, view);
        viewPager = (ViewPager) view.findViewById(R.id.newsVp);
        tabPageIndicator = (TabPageIndicator) view.findViewById(R.id.indicator);

        //解决冲突
//        http://blog.csdn.net/u011131296/article/details/40681383
//        mainActivity = (MainActivity) activity.getParent();
//        if (viewPager.getCurrentItem() != 0) {
//            mainActivity.getSlidingMenu().addIgnoredView(viewPager);
//        }
        return view;
    }

    @Override
    public void initDatas() {
        super.initDatas();
        newsTabDetailPagers = new ArrayList<>();
        for (int i = 0; i < childrenBeans.size(); i++) {
            NewsTabDetailPager newsTabDetailPager = new NewsTabDetailPager(activity, childrenBeans.get(i));
            newsTabDetailPagers.add(newsTabDetailPager);


        }
        viewPager.setAdapter(new NewsVpAdapter());



        tabPageIndicator.setViewPager(viewPager);//必须在设置完Adapter之后才能设置ViewPager
    }

    //跳转到下一个页面
    @OnClick(R.id.ibNext)
    public void nextPager(View view) {
        int currentItem = viewPager.getCurrentItem();
        viewPager.setCurrentItem(++currentItem);
    }

    class NewsVpAdapter extends PagerAdapter {

        @Override
        public CharSequence getPageTitle(int position) {
            return childrenBeans.get(position).getTitle();
        }

        @Override
        public int getCount() {
            return newsTabDetailPagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            NewsTabDetailPager newsTabDetailPager = newsTabDetailPagers.get(position);
            container.addView(newsTabDetailPager.mRootView);
            newsTabDetailPager.initDatas();


            return newsTabDetailPager.mRootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
