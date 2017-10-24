package com.luwei.borderless;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.luwei.borderless.conf.AppConf;
import com.luwei.borderless.net.impl.PaypalInfoBean;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalItem;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalPaymentDetails;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;

import java.math.BigDecimal;

import okhttp3.Call;

import static android.R.attr.data;

/**
 * @author Ly
 * @date 2017/10/24
 */

public class PayPalPayActivity extends AppCompatActivity {

    private Button mBtPaypalPay;


    private String token;

    /**
     * 你在PalPay创建的测试应用客户端ID
     */
    private static final String CONFIG_CLIENT_ID = AppConf.PayPalConf.CONFIG_CLIENT_ID_LIVE;
    /**
     * 沙盒测试(ENVIRONMENT_SANDBOX)，生产环境(ENVIRONMENT_PRODUCTION)
     */
    private static PayPalConfiguration config = new PayPalConfiguration()
            .environment(PayPalConfiguration.ENVIRONMENT_PRODUCTION)
            .clientId(CONFIG_CLIENT_ID);
    /**
     * 用于后台检验的paymentId
     */
    private String paymentId = null;

    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paypal);
        startPayPalSer();
        Bundle bundle = getIntent().getBundleExtra("extra");
        if (bundle != null) {
            token = bundle.getString("token");
        }
        initView();
    }

    private void initView() {
        mBtPaypalPay = (Button) findViewById(R.id.bt_paypal_pay);
        mBtPaypalPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doGetPaypalPayInfo();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //停止PayPalService服务
        stopService(new Intent(this, PayPalService.class));
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            PaymentConfirmation confirm1 = data
                    .getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
            String paymentId;
            try {
                paymentId = confirm1.toJSONObject().getJSONObject("response")
                        .getString("id");
                String paymentClient = confirm1.getPayment().toJSONObject()
                        .toString();
                doSynPaypalOrderStatus(paymentId);
                Log.e("onActivityResult-----", "paymentId: " + paymentId + ", payment_json: "
                        + paymentClient);
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if (resultCode == Activity.RESULT_CANCELED) {
            Log.i("paymentExample", "The user canceled.");
        } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
            Log.i("paymentExample", "An invalid Payment or PayPalConfiguration was submitted. Please see the docs.");
        }
    }

    /**
     * 启动paypal服务
     */
    private void startPayPalSer() {
        //启动PayPalService服务
        Intent intent = new Intent(this, PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        startService(intent);
    }

    /**
     * 获取贝宝的支付信息
     */
    private void doGetPaypalPayInfo() {
        OkHttpUtils.post()
                .url(AppConf.NetConf.PAYPAL_PAY_INFO)
                .addParams("accessToken", token)
                .addParams("rechangeUSD", "0.01")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        PaypalInfoBean paypalInfoBean = new Gson().fromJson(response, PaypalInfoBean.class);
                        Log.e("xxx", paypalInfoBean.toString());
                        paymentId = paypalInfoBean.getData().getOrderId();
                        // PAYMENT_INTENT_SALE 意思是支付立即完成
                        // 修改 PAYMENT_INTENT_SALE 为 PAYMENT_INTENT_AUTHORIZE to only authorize payment and
                        // capture funds later.
                        PayPalPayment payment = new PayPalPayment(new BigDecimal(paypalInfoBean.getData().getRechangeUSD()), "USD", "充值支付",
                                PayPalPayment.PAYMENT_INTENT_SALE);
                        com.paypal.android.sdk.payments.PayPalItem[] payPalItems =
                                {new PayPalItem(paymentId,
                                        1,
                                        new BigDecimal(paypalInfoBean.getData().getRechangeUSD()),
                                        "USD",
                                        paymentId)};
                        // Total amount
                        BigDecimal subtotal = PayPalItem.getItemTotal(payPalItems);
                        // If you have shipping cost, add it here
                        BigDecimal shipping = new BigDecimal("0.0");
                        // If you have tax, add it here
                        BigDecimal tax = new BigDecimal("0.0");
                        PayPalPaymentDetails paymentDetails = new PayPalPaymentDetails(
                                shipping, subtotal, tax);
                        payment.items(payPalItems).paymentDetails(paymentDetails);
                        Intent intent = new Intent(PayPalPayActivity.this, PaymentActivity.class);
                        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);
                        startActivityForResult(intent, 0);
                    }
                });
    }

    /**
     * 校验贝宝
     *
     * @param paymentId
     */
    private void doSynPaypalOrderStatus(String paymentId) {
        OkHttpUtils.post()
                .url(AppConf.NetConf.PAYPAL_SYN_ORDER)
                .addParams("accessToken", token)
                .addParams("paymentId", paymentId)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("贝宝校验---", response);
                    }
                });
    }

    public static void toPayPalPayActivity(Activity activity, String token) {
        Intent intent = new Intent(activity, PayPalPayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("token", token);
        intent.putExtra("extra", bundle);
        activity.startActivity(intent);
    }
}
