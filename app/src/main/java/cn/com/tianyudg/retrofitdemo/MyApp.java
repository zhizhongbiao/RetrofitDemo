package cn.com.tianyudg.retrofitdemo;

import android.app.Application;

import cn.com.tianyudg.retrofitdemo.manager.NetworkManager;

/**
 * Author : WaterFlower.
 * Created on 2018/3/19.
 * Desc :
 */

public class MyApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        NetworkManager.init(this);

    }

}
