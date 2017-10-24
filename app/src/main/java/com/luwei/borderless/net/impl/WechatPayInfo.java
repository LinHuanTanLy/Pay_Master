package com.luwei.borderless.net.impl;

import com.luwei.borderless.net.BaseBean;

/**
 * Created by Ly on 2017/10/24.
 * 微信支付订单信息
 */

public class WechatPayInfo extends BaseBean {


    /**
     * data : {"appid":"wx7dcabbfab57ab288","noncestr":"5yRrzkzuJTTMpulno1Kqn1U4HH3EnuxY","package":"Sign=WXPay","partnerid":"1417267902","paySign":"BD71CAD9CE452D3E86BFE9F6681F6121","prepayid":"wx20161215154540ad989756090126555847","timestamp":"1481787940"}
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
         * appid : wx7dcabbfab57ab288
         * noncestr : 5yRrzkzuJTTMpulno1Kqn1U4HH3EnuxY
         * package : Sign=WXPay
         * partnerid : 1417267902
         * paySign : BD71CAD9CE452D3E86BFE9F6681F6121
         * prepayid : wx20161215154540ad989756090126555847
         * timestamp : 1481787940
         */

        private String appid;
        private String noncestr;
        private String packageX;
        private String partnerid;
        private String paySign;
        private String prepayid;
        private String timestamp;


        @Override
        public String toString() {
            return "DataBean{" +
                    "appid='" + appid + '\'' +
                    ", noncestr='" + noncestr + '\'' +
                    ", packageX='" + packageX + '\'' +
                    ", partnerid='" + partnerid + '\'' +
                    ", paySign='" + paySign + '\'' +
                    ", prepayid='" + prepayid + '\'' +
                    ", timestamp='" + timestamp + '\'' +
                    '}';
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getNoncestr() {
            return noncestr;
        }

        public void setNoncestr(String noncestr) {
            this.noncestr = noncestr;
        }

        public String getPackageX() {
            return packageX;
        }

        public void setPackageX(String packageX) {
            this.packageX = packageX;
        }

        public String getPartnerid() {
            return partnerid;
        }

        public void setPartnerid(String partnerid) {
            this.partnerid = partnerid;
        }

        public String getPaySign() {
            return paySign;
        }

        public void setPaySign(String paySign) {
            this.paySign = paySign;
        }

        public String getPrepayid() {
            return prepayid;
        }

        public void setPrepayid(String prepayid) {
            this.prepayid = prepayid;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }
    }
}
