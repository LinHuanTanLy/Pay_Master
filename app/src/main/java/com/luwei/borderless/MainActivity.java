package com.luwei.borderless;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.luwei.borderless.conf.AppConf;
import com.luwei.borderless.net.impl.LoginUserInfoBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * @author Ly
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvMainWechat, mTvMainAli, mTvMainCard, mTvMainPaypal;

    private String token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doLogin();
        initView();
    }

    private void initView() {
        mTvMainAli = (TextView) findViewById(R.id.tv_main_pay_ali);
        mTvMainCard = (TextView) findViewById(R.id.tv_main_pay_card);
        mTvMainWechat = (TextView) findViewById(R.id.tv_main_pay_wechat);
        mTvMainPaypal = (TextView) findViewById(R.id.tv_main_pay_paypal);

        mTvMainAli.setOnClickListener(this);
        mTvMainCard.setOnClickListener(this);
        mTvMainWechat.setOnClickListener(this);
        mTvMainPaypal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_main_pay_ali:
                AliPayActivity.toAliPayAcitivity(this, token);
                break;
            case R.id.tv_main_pay_wechat:
                WeChatPayActivity.toWechatActivity(this, token);
                break;
            case R.id.tv_main_pay_card:
                CardPayActivity.toCardPayActivity(this);
                break;
            case R.id.tv_main_pay_paypal:
                PayPalPayActivity.toPayPalPayActivity(this,token);
                break;
            default:
                break;
        }
    }

    /**
     * 登录信息
     */
    private void doLogin() {
        OkHttpUtils.post()
                .url(AppConf.NetConf.LOGIN)
                .addParams("userPhone", "ly137544897@outlook.com")
                .addParams("userPassword", "123456")
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(String response, int id) {
                LoginUserInfoBean loginUserInfoBean = new Gson().fromJson(response, LoginUserInfoBean.class);
                token = loginUserInfoBean.getData().getAccessToken();
            }
        });
    }


}
