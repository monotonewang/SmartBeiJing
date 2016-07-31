package com.example.jizha.zhbj.fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jizha.zhbj.R;
import com.example.jizha.zhbj.activity.MainActivity;
import com.example.jizha.zhbj.bean.NewsBean;
import com.example.jizha.zhbj.pager.bottom.NewsPager;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * desc：TODO <br/>
 * time: 2016/7/24 13:20 <br/>
 * author：傅晴望 <br/>
 * since：V TODO <br/>
 */
public class LeftMenuFragment extends BaseFragment {

    @ViewInject(R.id.lv_list)
    private ListView listView;
    public final String TAG = LeftMenuFragment.class.getSimpleName();
    private MenuAdapter menuAdapter;
    private List<NewsBean.DataBean> data;

    @Override
    public int initView() {

        return R.layout.fragment_left_menu;
    }

    @Override
    protected void bindId(View inflate) {
        ViewUtils.inject(this, inflate);
    }

    @Override
    public void initData() {

    }


    public void setMenuData(NewsBean newsBean) {
        if(listView!=null) {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    setCurrentPager(position);
                    toggleSlidingMenu(false);//隐藏slidingMenu
                }
            });
        }else{
            Toast.makeText(getContext(), "Null listVIew", Toast.LENGTH_SHORT).show();
        }
        data = newsBean.getData();
        Log.e(TAG, data.toString());
        menuAdapter = new MenuAdapter();
        listView.setAdapter(menuAdapter);
    }

    /**
     * 显示和隐藏slidingMenu
     * @param b
     */
    private void toggleSlidingMenu(boolean b) {
        MainActivity activity = (MainActivity) getActivity();
        SlidingMenu slidingMenu = activity.getSlidingMenu();
        slidingMenu.toggle(false);
    }

    /**
     * 设置页面号码
     * @param position
     */
    private void setCurrentPager(int position) {
        MainActivity activity = (MainActivity) getActivity();
        ContentFragment contentFragment = (ContentFragment) activity.getContentFragment();
        NewsPager newsDetailPager = contentFragment.getNewsDetailPager();
        newsDetailPager.setCurrentPager(position);
    }

    class MenuAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(getActivity()).inflate( R.layout.list_menu,parent,false);
            TextView viewById = (TextView) view.findViewById(R.id.tv_menu);
            viewById.setText(data.get(position).getTitle());
            return viewById;
        }

    }
}
