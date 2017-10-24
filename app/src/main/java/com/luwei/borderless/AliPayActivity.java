package com.luwei.borderless;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.google.gson.Gson;
import com.luwei.borderless.conf.AppConf;
import com.luwei.borderless.net.impl.AliPayInfo;
import com.luwei.borderless.net.impl.AliPayResult;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * @author Ly
 * @date 2017/10/24
 * 支付宝支付
 */

public class AliPayActivity extends AppCompatActivity {
    private Button mBtAliPay;

    private String token;
    /**
     * 支付宝支付
     */
    private static final int SDK_PAY_FLAG = 1;


    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    AliPayResult payResult = new AliPayResult((String) msg.obj);
                    /**
                     * 同步返回的结果必须放置到服务端进行验证（验证的规则请看https://doc.open.alipay.com/doc2/
                     * detail.htm?spm=0.0.0.0.xdvAU6&treeId=59&articleId=103665&
                     * docType=1) 建议商户依赖异步通知
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                    if (TextUtils.equals(resultStatus, "9000")) {
                        Toast.makeText(AliPayActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
                    } else {
                        // 判断resultStatus 为非"9000"则代表可能支付失败
                        // "8000"代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            Toast.makeText(AliPayActivity.this, "支付结果确认中", Toast.LENGTH_SHORT).show();

                        } else {
                            // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                            Toast.makeText(AliPayActivity.this, "支付失败", Toast.LENGTH_SHORT).show();

                        }
                    }
                    break;
                }
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ali_pay);
        Bundle bundle = getIntent().getBundleExtra("extra");
        if (bundle != null) {
            token = bundle.getString("token");
        }
        initView();
    }

    private void initView() {
        mBtAliPay = (Button) findViewById(R.id.bt_ali_pay);
        mBtAliPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doGetAliPayInfo();
            }
        });
    }


    /**
     * 获取支付宝信息
     */
    private void doGetAliPayInfo() {
        OkHttpUtils.post().url(AppConf.NetConf.ALI_PAY_INFO)
                .addParams("accessToken", token)
                .addParams("aRechargeMoney", "0.01")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        AliPayInfo aliPayInfo = new Gson().fromJson(response, AliPayInfo.class);
                        aliPay(aliPayInfo.getData().getOrderStr());
                    }
                });
    }

    /**
     * 调用SDK支付
     */
    public void aliPay(final String payInfo) {
        Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                // 构造PayTask 对象
                PayTask alipay = new PayTask(AliPayActivity.this);
                // 调用支付接口，获取支付结果
                String result = alipay.pay(payInfo, true);
                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    public static void toAliPayAcitivity(Activity activity, String token) {
        Intent intent = new Intent(activity, AliPayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("token", token);
        intent.putExtra("extra", bundle);
        activity.startActivity(intent);
    }
}
