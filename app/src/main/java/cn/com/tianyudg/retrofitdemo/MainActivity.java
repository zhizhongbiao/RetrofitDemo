package cn.com.tianyudg.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

import cn.com.tianyudg.retrofitdemo.bean.LoginBean;
import cn.com.tianyudg.retrofitdemo.bean.NewListBean;
import cn.com.tianyudg.retrofitdemo.bean.SecondHandListBean;
import cn.com.tianyudg.retrofitdemo.config.ApiService;
import cn.com.tianyudg.retrofitdemo.manager.NetworkManager;
import cn.com.tianyudg.retrofitdemo.util.LogUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tvText);

    }


    //     etLoginPhone.setText("13511111111");
//        etLoginPsw.setText("888888");
    public void loginClick(View view) {

        ApiService apiService = NetworkManager.getInstance().getRetrofit().create(ApiService.class);

        Call<LoginBean> loginCall = apiService.login("13511111111", "888888");
        LogUtils.e("Request  - - -  " + loginCall.request().toString());
        LogUtils.e("Response headers  -    " + loginCall.request().headers().toString());
        loginCall.enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {

                String msg = response.body().msg;
                textView.setText(msg);

                LogUtils.e("Response headers  - - - - -   " + response.headers().toString());
            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {
                LogUtils.e("onFailure - - -" + t.getMessage());
            }
        });

    }

    public void newListClick(View view) {
        ApiService apiService = NetworkManager.getInstance().getApiService();
        apiService.newList("ealer_estateLis")
                .enqueue(new Callback<NewListBean>() {
                    @Override
                    public void onResponse(Call<NewListBean> call, Response<NewListBean> response) {
                        textView.setText(response.body().msg);
                    }

                    @Override
                    public void onFailure(Call<NewListBean> call, Throwable t) {
                        textView.setText("onFailure - - -" + t.getMessage());
                    }
                });
    }

    public void secondListClick(View view) {


        Observable.create(new Observable.OnSubscribe<SecondHandListBean>() {
            @Override
            public void call(Subscriber<? super SecondHandListBean> subscriber) {
                try {
                    SecondHandListBean secondHandListBean = NetworkManager
                            .getInstance()
                            .getApiService()
                            .getSecondList("4905!!QiHpYNRM6H")
                            .execute()
                            .body();
                    subscriber.onNext(secondHandListBean);
                    subscriber.onCompleted();
                    LogUtils.e("- - - call - - -thread="+Thread.currentThread().getName());

                } catch (IOException e) {

                    LogUtils.e("- - - call - - -IOException  ="+e.getMessage());
                }

            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SecondHandListBean>() {


            @Override
            public void onCompleted() {
                LogUtils.e("onCompleted - - -");
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e("onError - - -e.getMessage()=" + e.getMessage());
            }

            @Override
            public void onNext(SecondHandListBean secondHandListBean) {
                LogUtils.e("onNext - - -thread="+Thread.currentThread().getName());
                textView.setText(secondHandListBean.msg);
            }
        });
    }
}

