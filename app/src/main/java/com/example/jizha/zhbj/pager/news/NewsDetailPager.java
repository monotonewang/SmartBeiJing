package com.example.jizha.zhbj.pager.news;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jizha.zhbj.R;
import com.example.jizha.zhbj.bean.NewsBean;
import com.example.jizha.zhbj.pager.base.BaseMenuPager;
import com.example.jizha.zhbj.pager.news.child.NewsTabDetailPager;
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
    private ArrayList<NewsBean.DataBean.ChildrenBean> childrenBeans;
    private ViewPager viewPager;
    private TabPageIndicator tabPageIndicator;

    public NewsDetailPager(Activity activity, List<NewsBean.DataBean.ChildrenBean> childrenBeans) {
        super(activity);
        this.childrenBeans = (ArrayList<NewsBean.DataBean.ChildrenBean>) childrenBeans;
    }

    @Override
    public View initView() {
        View view = LayoutInflater.from(activity).inflate(R.layout.fragment_news_vp, null, false);
        viewPager =
                (ViewPager) view.findViewById(R.id.newsVp);
        tabPageIndicator = (TabPageIndicator) view.findViewById(R.id.indicator);

        return view;
    }

    @Override
    public void initDatas() {
        super.initDatas();
        newsTabDetailPagers = new ArrayList<>();
        for (int i = 0; i < childrenBeans.size(); i++) {
            NewsTabDetailPager newsTabDetailPager = new NewsTabDetailPager(activity,childrenBeans.get(i));
            newsTabDetailPagers.add(newsTabDetailPager);
        }
        viewPager.setAdapter(new NewsVpAdapter());
        tabPageIndicator.setViewPager(viewPager);//必须在设置完Adapter之后才能设置ViewPager
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
