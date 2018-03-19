package cn.com.tianyudg.retrofitdemo.manager;

import android.content.Context;

import java.io.IOException;

import cn.com.tianyudg.retrofitdemo.config.ApiService;
import cn.com.tianyudg.retrofitdemo.interceptor.AddCookiesInterceptor;
import cn.com.tianyudg.retrofitdemo.interceptor.ReceivedCookiesInterceptor;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author : WaterFlower.
 * Created on 2018/3/15.
 * Desc :
 */

public class NetworkManager {

    private static Context mContext;

    private static NetworkManager instance;

    private NetworkManager() {

    }


    public static void init(Context context) {
        mContext = context;
    }

    public static NetworkManager getInstance() {
        if (instance == null) {
            synchronized (NetworkManager.class) {
                if (instance == null) {
                    instance = new NetworkManager();
                }
            }
        }

        return instance;
    }


    //    不知道为何该方法添加Header无效
    Interceptor mInterceptor = new Interceptor() {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request oldRequest = chain.request();
            Request newRequest = oldRequest.newBuilder()
                    .header("X-Requested-With", "XMLHttpRequest")
                    .header("Accept-Language", "zh-CN,zh;q=0.8")
                    .build();

            return chain.proceed(newRequest);
        }
    };

    public Retrofit getRetrofit() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new ReceivedCookiesInterceptor(mContext))
                .addInterceptor(new AddCookiesInterceptor(mContext))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dongguan.huifang.cn/api/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }


    public ApiService getApiService() {
        return getRetrofit().create(ApiService.class);
    }

    ;


}
