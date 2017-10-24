package com.luwei.borderless.net.impl;

import com.luwei.borderless.net.BaseBean;

/**
 *
 * @author Ly
 * @date 2017/10/24
 * 支付宝支付信息的bean
 */

public class AliPayInfo extends BaseBean {
    /**
     * data : {"orderStr":"app_id=2016090801870812&biz_content=%7B%22total_amount%22%3A%220.01%22%2C%22body%22%3A%22Andy%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E6%B5%8B%E8%AF%95%E6%94%AF%E4%BB%98%22%2C%22out_trade_no%22%3A%221000001665483717%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay¬ify_url=http%3A%2F%2Fwx.talkmoney.cn%2Fborderless%2Fpay%2FreceiveAlipayMsg.do&sign_type=RSA×tamp=2016-12-13%2010%3A44%3A17&version=1.0&sign=sWx9aTpLe63E4%2FeYHpRyoB485RpXcMe%2FOCvVS4hY0%2BXOK33BFQ%2FSEfUOhfCxKsHwGnsDxUlSxXUk8TGDMmKRRMPl43H36rw9z9sXc%2F2u1GKS7r078WqclFQJQx2im0IJFw8ZtFD2x24KteaQPE51oEnvKEziRtKxbYY62yWgt0o%3D"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * orderStr : app_id=2016090801870812&biz_content=%7B%22total_amount%22%3A%220.01%22%2C%22body%22%3A%22Andy%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E6%B5%8B%E8%AF%95%E6%94%AF%E4%BB%98%22%2C%22out_trade_no%22%3A%221000001665483717%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay¬ify_url=http%3A%2F%2Fwx.talkmoney.cn%2Fborderless%2Fpay%2FreceiveAlipayMsg.do&sign_type=RSA×tamp=2016-12-13%2010%3A44%3A17&version=1.0&sign=sWx9aTpLe63E4%2FeYHpRyoB485RpXcMe%2FOCvVS4hY0%2BXOK33BFQ%2FSEfUOhfCxKsHwGnsDxUlSxXUk8TGDMmKRRMPl43H36rw9z9sXc%2F2u1GKS7r078WqclFQJQx2im0IJFw8ZtFD2x24KteaQPE51oEnvKEziRtKxbYY62yWgt0o%3D
         */

        private String orderStr;

        public String getOrderStr() {
            return orderStr;
        }

        public void setOrderStr(String orderStr) {
            this.orderStr = orderStr;
        }
    }
}
