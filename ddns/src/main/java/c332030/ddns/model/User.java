package c332030.ddns.model;

import c332030.utils.data.model.interfaces.C;

public class User implements C {

    private static final long serialVersionUID = -5376563682882728300L;

    /**
     * 用户名称, 企业用户对应为公司名称
     */
    private String real_name;

    /**
     * 账号类型：[“personal”,”enterprise”]，分别对应个人用户和企业用户
     */
    private String user_type;

    /**
     * 电话号码
     */
    private String telephone;

    /**
     * 用户 IM (已废弃)
     */
    private String im;

    /**
     * 用户昵称
     */
    private String nick;

    /**
     * 用户 ID, 即为 user_id
     */
    private String id;

    /**
     * 用户账号, 邮箱格式
     */
    private String email;

    /**
     * 账号状态：”enabled”: 正常；”disabled”: 被封禁
     */
    private String status;

    /**
     * 邮箱是否通过验证：”yes”: 通过；”no”: 未通过
     */
    private String email_verified;

    /**
     * 手机是否通过验证：”yes”: 通过；”no”: 未通过
     */
    private String telephone_verified;

    /**
     * 是否绑定微信：”yes”: 通过；”no”: 未通过
     */
    private String weixin_binded;

    /**
     * 是否正在申请成为代理：true: 是；false: 否
     */
    private Boolean agent_pending;

    /**
     * 账号余额
     */
    private String balance;

    /**
     * 剩余短信条数
     */
    private String smsbalance;

    /**
     * 账号等级, 按照用户账号下域名等级排序, 选取一个最高等级为账号等级, 具体对应情况参见域名等级
     */
    private String user_grade;

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIm() {
        return im;
    }

    public void setIm(String im) {
        this.im = im;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail_verified() {
        return email_verified;
    }

    public void setEmail_verified(String email_verified) {
        this.email_verified = email_verified;
    }

    public String getTelephone_verified() {
        return telephone_verified;
    }

    public void setTelephone_verified(String telephone_verified) {
        this.telephone_verified = telephone_verified;
    }

    public String getWeixin_binded() {
        return weixin_binded;
    }

    public void setWeixin_binded(String weixin_binded) {
        this.weixin_binded = weixin_binded;
    }

    public Boolean getAgent_pending() {
        return agent_pending;
    }

    public void setAgent_pending(Boolean agent_pending) {
        this.agent_pending = agent_pending;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getSmsbalance() {
        return smsbalance;
    }

    public void setSmsbalance(String smsbalance) {
        this.smsbalance = smsbalance;
    }

    public String getUser_grade() {
        return user_grade;
    }

    public void setUser_grade(String user_grade) {
        this.user_grade = user_grade;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
