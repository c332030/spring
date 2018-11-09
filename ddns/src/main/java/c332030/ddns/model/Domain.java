package c332030.ddns.model;

import c332030.utils.data.model.interfaces.C;

public class Domain implements C {

    private static final long serialVersionUID = -4302920554869866913L;

    /**
     * 域名 ID, 即为 domain_id
     */
    private String id;

    /**
     * 域名
     */
    private String name;

    /**
     * 使用 punycode 转码之后的域名
     */
    private String punycode;

    /**
     * 域名等级
     * “D_Free”: 旧免费套餐 (旧套餐)
     * “D_Plus”: 个人豪华套餐 (旧套餐)
     * “D_Extra”: 企业Ⅰ (旧套餐)
     * “D_Expert” 企业Ⅱ (旧套餐)
     * “D_Ultra”: 企业Ⅲ (旧套餐)
     * “DP_Free” 免费套餐
     * “DP_Plus”: 个人专业版
     * “DP_Extra”: 企业创业版
     * “DP_Expert”: 企业标准版
     * “DP_Ultra”: 企业旗舰版
     */
    private String grade;

    /**
     * 域名等级(中文说明)
     */
    private String grade_title;

    /**
     * 域名状态
     * “enable”: 正常
     * “pause”: 已暂停解析
     * “spam”: 已被封禁
     * “lock”: 已被锁定
     */
    private String status;

    /**
     * 域名扩展的状态
     * “notexist”: 域名没有注册
     * “dnserror”: DNS 设置错误
     * “”: 正常
     */
    private String ext_status;

    /**
     * 域名下记录总条数
     */
    private String records;

    /**
     * 域名分组 ID
     */
    private String group_id;

    /**
     * 是否开启搜索引擎推送功能
     * “yes”: 已开启
     * “no”: 未开启
     */
    private String searchengine_push;

    /**
     *  是否设置域名星标
     * “yes”: 已设置
     * “no”: 未设置
     */
    private String is_mark;

    /**
     * 域名备注
     */
    private String remark;

    /**
     * 是否是VIP 等级
     * “yes”: 是 VIP
     * “no”: 不是 VIP
     */
    private Boolean is_vip;

    /**
     * 用户id
     */
    private String user_id;

    /**
     * 添加域名的时间
     */
    private String created_on;

    /**
     * 域名最后修改时间
     */
    private String updated_on;

    /**
     * 域名默认的 TTL 值
     */
    private String ttl;

    /**
     * CNAME 加速状态
     * “enable”: 已启用
     * “disable”: 已禁用
     */
    private String cname_speedup;

    /**
     * 域名所有者
     */
    private String owner;

    /**
     * 解析套餐的开始时间，格式为 yyyy-mm-dd（该字段仅当 is_vip 为“yes”时才存在）
     */
    private String vip_start_at;

    /**
     * 解析套餐的到期时间，格式为 yyyy-mm-dd（该字段仅当 is_vip 为“yes”时才存在）
     */
    private String vip_end_at;

    /**
     * 解析套餐是否会自动续费，“yes”或“no”（该字段仅当 is_vip 为“yes”时才存在）
     */
    private String vip_auto_renew;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPunycode() {
        return punycode;
    }

    public void setPunycode(String punycode) {
        this.punycode = punycode;
    }

    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade_title() {
        return grade_title;
    }
    public void setGrade_title(String grade_title) {
        this.grade_title = grade_title;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getExt_status() {
        return ext_status;
    }
    public void setExt_status(String ext_status) {
        this.ext_status = ext_status;
    }

    public String getRecords() {
        return records;
    }
    public void setRecords(String records) {
        this.records = records;
    }

    public String getGroup_id() {
        return group_id;
    }
    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getIs_mark() {
        return is_mark;
    }
    public void setIs_mark(String is_mark) {
        this.is_mark = is_mark;
    }

    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getIs_vip() {
        return is_vip;
    }
    public void setIs_vip(Boolean is_vip) {
        this.is_vip = is_vip;
    }

    public String getSearchengine_push() {
        return searchengine_push;
    }
    public void setSearchengine_push(String searchengine_push) {
        this.searchengine_push = searchengine_push;
    }

    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCreated_on() {
        return created_on;
    }
    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public String getUpdated_on() {
        return updated_on;
    }
    public void setUpdated_on(String updated_on) {
        this.updated_on = updated_on;
    }

    public String getTtl() {
        return ttl;
    }
    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getCname_speedup() {
        return cname_speedup;
    }
    public void setCname_speedup(String cname_speedup) {
        this.cname_speedup = cname_speedup;
    }

    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getVip_start_at() {
        return vip_start_at;
    }
    public void setVip_start_at(String vip_start_at) {
        this.vip_start_at = vip_start_at;
    }

    public String getVip_end_at() {
        return vip_end_at;
    }
    public void setVip_end_at(String vip_end_at) {
        this.vip_end_at = vip_end_at;
    }

    public String getVip_auto_renew() {
        return vip_auto_renew;
    }
    public void setVip_auto_renew(String vip_auto_renew) {
        this.vip_auto_renew = vip_auto_renew;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
