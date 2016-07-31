package com.example.jizha.zhbj.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * desc：TODO <br/>
 * time: 2016/7/24 13:15 <br/>
 * author：傅晴望 <br/>
 * since：V TODO <br/>
 */
public abstract class BaseFragment extends Fragment {

    protected FragmentActivity activity;
    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        context = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int i = initView();
        View inflate = inflater.inflate(i, container, false);
        bindId(inflate);
        return inflate;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract int initView();

    protected abstract void bindId(View inflate);

    protected abstract void initData();


}
