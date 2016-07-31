package com.example.jizha.zhbj.pager.bottom;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.example.jizha.zhbj.activity.MainActivity;
import com.example.jizha.zhbj.bean.NewsBean;
import com.example.jizha.zhbj.fragment.LeftMenuFragment;
import com.example.jizha.zhbj.global.Constants;
import com.example.jizha.zhbj.pager.news.InteractMenuPager;
import com.example.jizha.zhbj.pager.news.NewsDetailPager;
import com.example.jizha.zhbj.pager.base.BaseMenuPager;
import com.example.jizha.zhbj.pager.base.BasePager;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.ArrayList;

/**
 * desc：TODO <br/>
 * time: 2016/7/24 17:09 <br/>
 * author：傅晴望 <br/>
 * since：V TODO <br/>
 */
public class NewsPager extends BasePager {
    public final String TAG = NewsPager.class.getSimpleName();
    private ArrayList<BaseMenuPager> mPagers;
    public NewsPager (Activity activity) {
        super(activity);
    }

    @Override
    public void initDatas() {
        super.initDatas();
        tvTitle.setText("智慧北京");
        setSlidingMenuVisiable(true);
//        TextView textView = new TextView(mActivity);
//        textView.setText("新闻");
//        textView.setGravity(Gravity.CENTER);
//        flcontent.addView(textView);
        getDataFromServer();

    }
    
    private void getDataFromServer(){
        HttpUtils httpUtils=new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET, Constants.CATEGPORIES_URL, null, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String result = responseInfo.result;
                parseData(result);
            }

            @Override
            public void onFailure(HttpException e, String s) {
                Toast.makeText(mActivity, "访问失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected void parseData(String result){
        Gson gson=new Gson();
        NewsBean newsBean = gson.fromJson(result, NewsBean.class);
        int retcode = newsBean.getRetcode();
//            Toast.makeText(mActivity, newsBean.toString(), Toast.LENGTH_SHORT).show();
            MainActivity mainActivity= (MainActivity) mActivity;
            LeftMenuFragment leftMenuFragment = (LeftMenuFragment) mainActivity.getLeftMenuFragment();
            leftMenuFragment.setMenuData(newsBean);
            Log.e(TAG, "parseData: " + newsBean.toString());
        mPagers =new ArrayList<>();
        mPagers.add(new NewsDetailPager(mActivity,newsBean.getData().get(0).getChildren()));
        mPagers.add(new InteractMenuPager(mActivity));
        setCurrentPager(0);//设置当前页为0
    }

    /**
     * 设置当前菜单详情页
     */
    public void setCurrentPager(int position){
        BaseMenuPager baseMenuPager = mPagers.get(position);
        flcontent.removeAllViews();//清除之前的布局
        flcontent.addView(baseMenuPager.mRootView) ;

        baseMenuPager.initDatas();
    }

}