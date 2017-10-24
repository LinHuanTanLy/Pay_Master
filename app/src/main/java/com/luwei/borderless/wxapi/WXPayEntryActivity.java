package com.luwei.borderless.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.luwei.borderless.conf.AppConf;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


/**
 * @author Ly
 *         支付回调页面
 */
public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {

    private static final String TAG = "MicroMsg.SDKSample.WXPayEntryActivity";

    private IWXAPI api;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api = WXAPIFactory.createWXAPI(this, AppConf.WechatConf.APP_ID);
        api.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
    }

    @Override
    public void onResp(BaseResp resp) {
        Log.e("", "onPayFinish, errCode = " + resp.errCode);
        int code = resp.errCode;
        switch (code) {
            case 0://支付成功后的界面
                Toast.makeText(this, "支付成功", Toast.LENGTH_SHORT).show();
                finish();
                break;
            case -1:
                Toast.makeText(this, "签名错误、未注册APPID、项目设置APPID不正确、注册的APPID与设置的不匹配、您的微信账号异常等", Toast.LENGTH_SHORT).show();
                finish();
                break;
            case -2://用户取消支付后的界面
                Toast.makeText(this, "用户取消", Toast.LENGTH_SHORT).show();
                finish();
                break;
            default:
                break;
        }
    }

}