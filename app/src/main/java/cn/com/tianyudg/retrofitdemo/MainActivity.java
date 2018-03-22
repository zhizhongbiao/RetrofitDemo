package cn.com.tianyudg.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ArrayList<List<String>> outList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tvText);
        outList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            ArrayList<String> inList = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                inList.add("inList - " + j);
            }
            outList.add(inList);
        }

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
                    LogUtils.e("- - - call - - -thread=" + Thread.currentThread().getName());

                } catch (IOException e) {
                    LogUtils.e("- - - call - - -IOException  =" + e.getMessage());
                }

            }
        })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
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
                        LogUtils.e("onNext - - -thread=" + Thread.currentThread().getName());
                        textView.setText(secondHandListBean.msg);
                    }
                });
    }

    public void mapTestClick(View view) {
        Observable.just(1, 4, 1, 3)
                .subscribeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        LogUtils.e("doOnSubscribe() 和Subscriber.onStart()方法一样运行在流程的前面" +
                                "，但是doOnSubscribe()执行的线程跟随在其后距离最近的调用的subscribeOn()设置的线程" +
                                "，如果其后没有调用subscribeOn()设置的线程，则默认执行在 subscribe() 发生的线程");

                        LogUtils.e("doOnSubscribe -thread=" + Thread.currentThread().getName());
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        LogUtils.e("doOnSubscribe - - 此处应该默认执行在 subscribe() 发生的线程 - - thread=" + Thread.currentThread().getName());

                    }
                })
                .observeOn(Schedulers.io())
                .map(new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        LogUtils.e("- - - call - - -thread=" + Thread.currentThread().getName());
                        return integer + "";
                    }
                })

                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onCompleted() {
                        LogUtils.e("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("onError  msg=" + e.getMessage());
                    }

                    @Override
                    public void onNext(String s) {
                        LogUtils.e("onNext - - -thread=" + Thread.currentThread().getName());
                        LogUtils.e("onNext  s=" + s);
                    }
                });
    }

    public void flatMapTestClick(View view) {
        Observable.from(outList)
                .flatMap(new Func1<List<String>, Observable<String>>() {
                    @Override
                    public Observable<String> call(List<String> strings) {
                        return Observable.from(strings);
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        LogUtils.e("s = " + s);
                    }
                });

    }
}

