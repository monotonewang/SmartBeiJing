package com.example.jizha.zhbj.pager.news.child;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.jizha.zhbj.R;
import com.example.jizha.zhbj.bean.NewsBean;
import com.example.jizha.zhbj.pager.base.BaseMenuPager;

/**
 * desc：TODO <br/>
 * time: 2016/7/31 16:37 <br/>
 * author：傅晴望 <br/>
 * since：V TODO <br/>
 */
public class NewsTabDetailPager  extends BaseMenuPager {
    private NewsBean.DataBean.ChildrenBean childrenBean;
    private TextView textView;

    public NewsTabDetailPager(Activity activity,NewsBean.DataBean.ChildrenBean childrenBean) {
        super(activity);
        this.childrenBean=childrenBean;
    }

    @Override
    public View initView() {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.fragment_news_vp_child, null, false);
        textView = (TextView) inflate.findViewById(R.id.newsChildTV);

        return inflate;
    }

    @Override
    public void initDatas() {
        super.initDatas();
        textView.setText(childrenBean.getTitle());
    }
}
