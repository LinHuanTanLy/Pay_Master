package com.luwei.borderless.net.impl;

import com.luwei.borderless.net.BaseBean;

/**
 * Created by Ly on 2017/10/24.
 * 贝宝的订单信息
 */

public class PaypalInfoBean extends BaseBean {
    @Override
    public String toString() {
        return "PaypalInfoBean{" +
                "data=" + data +
                '}';
    }

    /**
     * data : {"rechangeUSD":10,"orderId":"1000000416675012"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "rechangeUSD='" + rechangeUSD + '\'' +
                    ", orderId='" + orderId + '\'' +
                    '}';
        }

        /**
         * rechangeUSD : 10
         * orderId : 1000000416675012
         */

        private String rechangeUSD;
        private String orderId;

        public String getRechangeUSD() {
            return rechangeUSD;
        }

        public void setRechangeUSD(String rechangeUSD) {
            this.rechangeUSD = rechangeUSD;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }
    }
}
