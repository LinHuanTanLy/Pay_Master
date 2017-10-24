package com.luwei.borderless;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.luwei.borderless.conf.AppConf;
import com.luwei.borderless.net.impl.WechatPayInfo;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mm.opensdk.utils.Log;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * @author Ly
 * @date 2017/10/24
 * 微信支付界面
 */

public class WeChatPayActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView mTvWechatPay, mTvWechatIsSupport;


    /**
     * 微信支付
     */
    private IWXAPI api;

    private String token;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wechat_pay);
        Bundle bundle = getIntent().getBundleExtra("extra");
        if (bundle != null) {
            token = bundle.getString("token");
        }
        initView();
    }

    private void initView() {
        mTvWechatPay = (TextView) findViewById(R.id.tv_wechat_pay);
        mTvWechatIsSupport = (TextView) findViewById(R.id.tv_wechat_is_support);
        mTvWechatPay.setOnClickListener(this);
        mTvWechatIsSupport.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_wechat_pay:
                doGetWechatPayInfo();
                break;
            case R.id.tv_wechat_is_support:
                isPaySupported();
                break;
            default:
                break;
        }
    }

    /**
     * 获取微信订单
     */
    private void doGetWechatPayInfo() {
        OkHttpUtils.post()
                .url(AppConf.NetConf.WECHAT_PAY_INFO)
                .addParams("accessToken", token)
                .addParams("wRechargeMoney", "0.01")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        WechatPayInfo wechatPayInfo = new Gson().fromJson(response, WechatPayInfo.class);
                        Log.e("xxx", wechatPayInfo.toString());
                        WXPay(wechatPayInfo.getData().getAppid(),
                                wechatPayInfo.getData().getPartnerid(),
                                wechatPayInfo.getData().getPrepayid(),
                                wechatPayInfo.getData().getTimestamp(),
                                wechatPayInfo.getData().getNoncestr(),
                                wechatPayInfo.getData().getPaySign());
                    }
                });
    }

    /**
     * 微信支付
     */
    private void WXPay(String appId, String partnerId, String prepayId, String timeStamp, String nonceStr, String paySign) {
        api = WXAPIFactory.createWXAPI(this, null);
        api.registerApp(AppConf.WechatConf.APP_ID);
        PayReq req = new PayReq();
        req.appId = appId;
        req.partnerId = partnerId;
        req.prepayId = prepayId;
        req.nonceStr = nonceStr;
        req.timeStamp = timeStamp;
        req.packageValue = "Sign=WXPay";
        req.sign = paySign;
        api.sendReq(req);
    }

    /**
     * 检测微信版本是否支持支付
     */
    private boolean isPaySupported() {
        if (api == null) {
            api = WXAPIFactory.createWXAPI(this, null);
            api.registerApp(AppConf.WechatConf.APP_ID);
        }
        boolean isPaySupported;
        isPaySupported = api.getWXAppSupportAPI() >= Build.PAY_SUPPORTED_SDK_INT;
        if (!isPaySupported) {
            Toast.makeText(this, "您的微信版本不支持支付", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "您的微信版本支持支付", Toast.LENGTH_SHORT).show();
        }
        return isPaySupported;
    }

    public static void toWechatActivity(Activity activity, String token) {
        Intent intent = new Intent(activity, WeChatPayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("token", token);
        intent.putExtra("extra", bundle);
        activity.startActivity(intent);
    }
}
