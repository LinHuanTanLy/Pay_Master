package com.luwei.borderless.net.impl;

import com.luwei.borderless.net.BaseBean;

/**
 *
 * @author Ly
 * @date 2017/10/24
 * 用户信息
 */

public class LoginUserInfoBean extends BaseBean {

    /**
     * data : {"timeZoneNameZh":"中国标准时间 (北京)","alipayUsername":"","easemobPwd":"ac271303037b20f6360427e8e61142a4","teacherCount":0,"registrationId":"","appLanguage":2,"accessToken":"6c541a66c2df140aeda732c30cd32122","switchStatus":"0","timeZoneNameEn":"Shanghai","userPassword":"b51d5af6c801ff4bfd31a4a154f35d35","timeZone":64,"balance":"0.00","languageUrl":"http://of13wt6if.bkt.clouddn.com/china.png","userId":319,"totalHarvestValue":0,"teacherRoleId":0,"alipayAccount":"","userPhone":"0086 15622715239","payPalAccount":"","studentCount":0,"userAvatarUrl":"https://app.globalborderless.com/images/userAvatar/d8756e25-b990-409a-88d2-c09c05c76c0d.png","currencyType":1,"userNickname":"ly","rechangeValue":0,"motherLanguage":1,"userMail":"","studentTalkTotalTime":0,"flag":1,"weChatAccount":"","userSex":1,"subUserId":1,"timeZoneName":"Shanghai","teacher":{},"coinRate":6.8515}
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
         * timeZoneNameZh : 中国标准时间 (北京)
         * alipayUsername :
         * easemobPwd : ac271303037b20f6360427e8e61142a4
         * teacherCount : 0
         * registrationId :
         * appLanguage : 2
         * accessToken : 6c541a66c2df140aeda732c30cd32122
         * switchStatus : 0
         * timeZoneNameEn : Shanghai
         * userPassword : b51d5af6c801ff4bfd31a4a154f35d35
         * timeZone : 64
         * balance : 0.00
         * languageUrl : http://of13wt6if.bkt.clouddn.com/china.png
         * userId : 319
         * totalHarvestValue : 0.0
         * teacherRoleId : 0
         * alipayAccount :
         * userPhone : 0086 15622715239
         * payPalAccount :
         * studentCount : 0
         * userAvatarUrl : https://app.globalborderless.com/images/userAvatar/d8756e25-b990-409a-88d2-c09c05c76c0d.png
         * currencyType : 1
         * userNickname : ly
         * rechangeValue : 0.0
         * motherLanguage : 1
         * userMail :
         * studentTalkTotalTime : 0
         * flag : 1
         * weChatAccount :
         * userSex : 1
         * subUserId : 1
         * timeZoneName : Shanghai
         * teacher : {}
         * coinRate : 6.8515
         */

        private String timeZoneNameZh;
        private String alipayUsername;
        private String easemobPwd;
        private int teacherCount;
        private String registrationId;
        private int appLanguage;
        private String accessToken;
        private String switchStatus;
        private String timeZoneNameEn;
        private String userPassword;
        private int timeZone;
        private String balance;
        private String languageUrl;
        private int userId;
        private double totalHarvestValue;
        private int teacherRoleId;
        private String alipayAccount;
        private String userPhone;
        private String payPalAccount;
        private int studentCount;
        private String userAvatarUrl;
        private int currencyType;
        private String userNickname;
        private double rechangeValue;
        private int motherLanguage;
        private String userMail;
        private int studentTalkTotalTime;
        private int flag;
        private String weChatAccount;
        private int userSex;
        private int subUserId;
        private String timeZoneName;
        private TeacherBean teacher;
        private double coinRate;

        public String getTimeZoneNameZh() {
            return timeZoneNameZh;
        }

        public void setTimeZoneNameZh(String timeZoneNameZh) {
            this.timeZoneNameZh = timeZoneNameZh;
        }

        public String getAlipayUsername() {
            return alipayUsername;
        }

        public void setAlipayUsername(String alipayUsername) {
            this.alipayUsername = alipayUsername;
        }

        public String getEasemobPwd() {
            return easemobPwd;
        }

        public void setEasemobPwd(String easemobPwd) {
            this.easemobPwd = easemobPwd;
        }

        public int getTeacherCount() {
            return teacherCount;
        }

        public void setTeacherCount(int teacherCount) {
            this.teacherCount = teacherCount;
        }

        public String getRegistrationId() {
            return registrationId;
        }

        public void setRegistrationId(String registrationId) {
            this.registrationId = registrationId;
        }

        public int getAppLanguage() {
            return appLanguage;
        }

        public void setAppLanguage(int appLanguage) {
            this.appLanguage = appLanguage;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getSwitchStatus() {
            return switchStatus;
        }

        public void setSwitchStatus(String switchStatus) {
            this.switchStatus = switchStatus;
        }

        public String getTimeZoneNameEn() {
            return timeZoneNameEn;
        }

        public void setTimeZoneNameEn(String timeZoneNameEn) {
            this.timeZoneNameEn = timeZoneNameEn;
        }

        public String getUserPassword() {
            return userPassword;
        }

        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }

        public int getTimeZone() {
            return timeZone;
        }

        public void setTimeZone(int timeZone) {
            this.timeZone = timeZone;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public String getLanguageUrl() {
            return languageUrl;
        }

        public void setLanguageUrl(String languageUrl) {
            this.languageUrl = languageUrl;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public double getTotalHarvestValue() {
            return totalHarvestValue;
        }

        public void setTotalHarvestValue(double totalHarvestValue) {
            this.totalHarvestValue = totalHarvestValue;
        }

        public int getTeacherRoleId() {
            return teacherRoleId;
        }

        public void setTeacherRoleId(int teacherRoleId) {
            this.teacherRoleId = teacherRoleId;
        }

        public String getAlipayAccount() {
            return alipayAccount;
        }

        public void setAlipayAccount(String alipayAccount) {
            this.alipayAccount = alipayAccount;
        }

        public String getUserPhone() {
            return userPhone;
        }

        public void setUserPhone(String userPhone) {
            this.userPhone = userPhone;
        }

        public String getPayPalAccount() {
            return payPalAccount;
        }

        public void setPayPalAccount(String payPalAccount) {
            this.payPalAccount = payPalAccount;
        }

        public int getStudentCount() {
            return studentCount;
        }

        public void setStudentCount(int studentCount) {
            this.studentCount = studentCount;
        }

        public String getUserAvatarUrl() {
            return userAvatarUrl;
        }

        public void setUserAvatarUrl(String userAvatarUrl) {
            this.userAvatarUrl = userAvatarUrl;
        }

        public int getCurrencyType() {
            return currencyType;
        }

        public void setCurrencyType(int currencyType) {
            this.currencyType = currencyType;
        }

        public String getUserNickname() {
            return userNickname;
        }

        public void setUserNickname(String userNickname) {
            this.userNickname = userNickname;
        }

        public double getRechangeValue() {
            return rechangeValue;
        }

        public void setRechangeValue(double rechangeValue) {
            this.rechangeValue = rechangeValue;
        }

        public int getMotherLanguage() {
            return motherLanguage;
        }

        public void setMotherLanguage(int motherLanguage) {
            this.motherLanguage = motherLanguage;
        }

        public String getUserMail() {
            return userMail;
        }

        public void setUserMail(String userMail) {
            this.userMail = userMail;
        }

        public int getStudentTalkTotalTime() {
            return studentTalkTotalTime;
        }

        public void setStudentTalkTotalTime(int studentTalkTotalTime) {
            this.studentTalkTotalTime = studentTalkTotalTime;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public String getWeChatAccount() {
            return weChatAccount;
        }

        public void setWeChatAccount(String weChatAccount) {
            this.weChatAccount = weChatAccount;
        }

        public int getUserSex() {
            return userSex;
        }

        public void setUserSex(int userSex) {
            this.userSex = userSex;
        }

        public int getSubUserId() {
            return subUserId;
        }

        public void setSubUserId(int subUserId) {
            this.subUserId = subUserId;
        }

        public String getTimeZoneName() {
            return timeZoneName;
        }

        public void setTimeZoneName(String timeZoneName) {
            this.timeZoneName = timeZoneName;
        }

        public TeacherBean getTeacher() {
            return teacher;
        }

        public void setTeacher(TeacherBean teacher) {
            this.teacher = teacher;
        }

        public double getCoinRate() {
            return coinRate;
        }

        public void setCoinRate(double coinRate) {
            this.coinRate = coinRate;
        }

        public static class TeacherBean {
        }
    }
}
