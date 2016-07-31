package com.example.jizha.zhbj.utils;

import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/**
 * desc：TODO <br/>
 * time: 2016/7/25 10:05 <br/>
 * author：傅晴望 <br/>
 * since：V TODO <br/>
 */
public class OkioUtils {

    public static String getString() {
        Source source;
        BufferedSource bufferedSource = null;
        String gbk = null;
        String path = Environment.getExternalStorageDirectory().getPath();
        File file = new File(path, "a.txt");
        try {
            source = Okio.source(file);
            bufferedSource = Okio.buffer(source);
            gbk = bufferedSource.readString(Charset.forName("GBK"));
            return gbk;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedSource != null) {
                try {
                    bufferedSource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "aa";
    }

    public static void setString() {
        boolean isCreate = false;
        Sink sink;
        BufferedSink bufferedSink = null;

        String path = Environment.getExternalStorageDirectory().getPath();
        try {

            File file = new File(path, "a.txt");
            if (!file.exists()) {
                isCreate = file.createNewFile();
            } else {
                isCreate = true;
            }

            if (isCreate) {
                sink = Okio.sink(file);
                bufferedSink = Okio.buffer(sink);
                bufferedSink.writeInt(90002);
                bufferedSink.writeString("aaa12352345234523452233asdfasdasdfas大家可能觉得我举的例子有些太简单了，好吧，我来说一个难的。让byte变量b等于-1。",
                        Charset.forName("GBK"));

                bufferedSink.flush();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != bufferedSink) {
                    bufferedSink.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
