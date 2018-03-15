package cn.com.tianyudg.retrofitdemo.config;

import cn.com.tianyudg.retrofitdemo.bean.LoginBean;
import cn.com.tianyudg.retrofitdemo.bean.NewListBean;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Author : WaterFlower.
 * Created on 2018/3/15.
 * Desc :
 */

public interface ApiService {

    @FormUrlEncoded
    @Headers("X-Requested-With: XMLHttpRequest")
    @POST("Dealer_userLogin")
    Call<LoginBean> login(@Field("username") String userName, @Field("password") String psw);


    @POST("D{ealer_estateLis}t")
    Call<NewListBean> newList(@Path("ealer_estateLis")String replaceableUrl);


}
