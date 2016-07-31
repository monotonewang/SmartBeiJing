package com.example.jizha.zhbj.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * desc：TODO <br/>
 * time: 2016/7/24 11:49 <br/>
 * author：傅晴望 <br/>
 * since：V TODO <br/>
 */
public class ShareUtils {

    private static final String FILE_NAME="config";

    public static boolean getBoolean(Context context,String key,boolean value){
        SharedPreferences config = context.getSharedPreferences(FILE_NAME,context.MODE_PRIVATE);
        return  config.getBoolean(key, value);
    }
    public static void setBoolean(Context context,String key,boolean value){

        SharedPreferences config =context.getSharedPreferences(FILE_NAME, context.MODE_PRIVATE);
         config.edit().putBoolean(key, value).commit();

    }
}
