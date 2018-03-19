package cn.com.tianyudg.retrofitdemo.interceptor;

import android.content.Context;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Author : WaterFlower.
 * Created on 2018/3/19.
 * Desc :
 */


/**
 * This interceptor put all the Cookies in Preferences in the Request.
 * Your implementation on how to get the Preferences MAY VARY.
 * <p>
 * Created by tsuharesu on 4/1/15.
 */

public class AddCookiesInterceptor implements Interceptor{

    private static final String SP_NAME_COOKIE = "sp_name_cookie";
    private static final String SP_KEY_COOKIE = "key_name_cookie";

    private Context mContext;

    public AddCookiesInterceptor(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();


        HashSet<String> preferences = (HashSet) mContext
                .getSharedPreferences(SP_NAME_COOKIE, Context.MODE_PRIVATE)
                .getStringSet(SP_KEY_COOKIE, new HashSet<String>());
        ;
        for (String cookie : preferences) {
            builder.addHeader("Cookie", cookie);

        }

        return chain.proceed(builder.build());
    }
}
