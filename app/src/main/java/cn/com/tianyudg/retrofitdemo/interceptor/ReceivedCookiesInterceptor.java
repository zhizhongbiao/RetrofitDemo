package cn.com.tianyudg.retrofitdemo.interceptor;

import android.content.Context;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Author : WaterFlower.
 * Created on 2018/3/19.
 * Desc :
 */


/**
 * This Interceptor add all received Cookies to the app DefaultPreferences.
 * Your implementation on how to save the Cookies on the Preferences MAY VARY.
 * <p>
 * Created by tsuharesu on 4/1/15.
 */

public class ReceivedCookiesInterceptor implements Interceptor {

    private static final String SP_NAME_COOKIE = "sp_name_cookie";
    private static final String SP_KEY_COOKIE = "key_name_cookie";
    private Context mContext;

    public ReceivedCookiesInterceptor(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());

        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            HashSet<String> cookies = new HashSet<>();

            for (String header : originalResponse.headers("Set-Cookie")) {
                cookies.add(header);
            }

            mContext
                    .getSharedPreferences(SP_NAME_COOKIE,Context.MODE_PRIVATE)
                    .edit()
                    .putStringSet(SP_KEY_COOKIE, cookies)
                    .apply();
        }

        return originalResponse;
    }
}
