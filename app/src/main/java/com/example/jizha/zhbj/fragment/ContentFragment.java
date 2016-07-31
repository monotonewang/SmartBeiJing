package com.example.jizha.zhbj.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.jizha.zhbj.R;
import com.example.jizha.zhbj.activity.MainActivity;
import com.example.jizha.zhbj.pager.base.BasePager;
import com.example.jizha.zhbj.pager.bottom.GovPager;
import com.example.jizha.zhbj.pager.bottom.HomePager;
import com.example.jizha.zhbj.pager.bottom.NewsPager;
import com.example.jizha.zhbj.pager.bottom.SettingPager;
import com.example.jizha.zhbj.pager.bottom.SmartPager;

import java.util.ArrayList;

/**
 * desc：TODO <br/>
 * time: 2016/7/24 15:09 <br/>
 * author：傅晴望 <br/>
 * since：V TODO <br/>
 */
public class ContentFragment extends BaseFragment {
    private RadioGroup rgBottom;

    private ViewPager mViewPager;
    private ArrayList<BasePager> mPagerLists;

    @Override
    protected int initView() {
        return R.layout.fragment_content;
    }

    @Override
    protected void bindId(View inflate) {
//        ViewUtils.inject(this, inflate);
        rgBottom = (RadioGroup) inflate.findViewById(R.id.rg_bottom);
        mViewPager = (ViewPager) inflate.findViewById(R.id.vp_content);


    }

    @Override
    protected void initData() {
        rgBottom.check(R.id.rb_home);

        mPagerLists = new ArrayList<>();

        mPagerLists.add(new HomePager(this.getActivity()));
        mPagerLists.add(new NewsPager(this.getActivity()));
        mPagerLists.add(new GovPager(this.getActivity()));
        mPagerLists.add(new SmartPager(this.getActivity()));
        mPagerLists.add(new SettingPager(this.getActivity()));

        mViewPager.setAdapter(new ContentAdapter());

        rgBottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        mViewPager.setCurrentItem(0, false);
                        break;
                    case R.id.rb_news:
                        mViewPager.setCurrentItem(1, false);
                        break;
                    case R.id.rb_gov:
                        mViewPager.setCurrentItem(2, false);
                        break;
                    case R.id.rb_service:
                        mViewPager.setCurrentItem(3, false);
                        break;
                    case R.id.rb_set:
                        mViewPager.setCurrentItem(4, false);
                        break;
                }
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mPagerLists.get(position).initDatas();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mPagerLists.get(0).initDatas();//手动初始化第一页
    }

    /**
     * 设置当前菜单详情页面
     *
     * @return
     */
    public NewsPager getNewsDetailPager() {
        return (NewsPager) mPagerLists.get(1);
    }

    class ContentAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mPagerLists.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager pager = mPagerLists.get(position);
            container.addView(pager.mRootView);
            return pager.mRootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
