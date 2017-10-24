package com.luwei.borderless.conf;

import com.luwei.borderless.net.impl.WechatPayInfo;

/**
 * @author Ly
 * @date 2017/10/24
 * 配置类
 */

public class AppConf {
    /**
     * BaseUrl
     */
    private static final String BASE_URL = "https://app.globalxxx.com";

    /**
     * 微信配置文件
     */
    public interface WechatConf {
        String APP_ID = "xxxxxxxab57ab288";
        String APP_SECRET = "xxxxxxxx1269874371fc75a79a";
    }

    /**
     * 贝宝的配置文件
     */
    public interface PayPalConf {
        /**
         * 沙盒环境
         */
        String CONFIG_CLIENT_ID_SANDBOX = "xxxxlZPMz2PN3C8akROwHZjDnzmRDGdxt965BkkvVfF8cUlzRU8a2AALVYCPMSc9uwqyJY5";
        /**
         * 正式环境
         */
        String CONFIG_CLIENT_ID_LIVE = "xxxxEiCmYlq83H73jHejGw8r-hyaiL0WbueHIUbOLtSEV_Vfh8rkU4aawFknGQZhA";
    }

    /**
     * 银行卡配置环境
     */
    public interface CardConf {
        /**
         * 银联支付 配置信息
         *
         * @return 01 沙盒环境 00 正式环境
         */
        String SANDBOX = "01", FORMAL = "00";

    }

    /**
     * 接口配置文件
     */
    public interface NetConf {
        /**
         * 登录信息
         */
        String LOGIN = BASE_URL + "/user/login.do";
        /**
         * 微信支付信息
         */
        String WECHAT_PAY_INFO = BASE_URL + "/user/pay/weChatRecharge.do";
        /**
         * 支付宝支付信息
         */
        String ALI_PAY_INFO = BASE_URL + "/user/pay/alipayRecharge.do";

        /**
         * 贝宝支付信息
         */
        String PAYPAL_PAY_INFO = BASE_URL + "/user/pay/getPayPalOrderId.do";
        /**
         * 验证paypal支付状态
         */
        String PAYPAL_SYN_ORDER = BASE_URL + "/user/pay/synPaypalOrder.do";
        /**
         * 银联支付 获取tn
         */
        String CARD_PAY_INFO = "http://101.231.204.84:8091/sim/getacptn";
    }
}
