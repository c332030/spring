package c332030.ddns.model;

import c332030.utils.data.model.interfaces.C;

public class Record implements C {

    private static final long serialVersionUID = -9069382667138324127L;

    /**
     * 记录ID编号
     */
    private String id;

    /**
     * 子域名(主机记录)
     */
    private String name;

    /**
     * 解析记录的线路, 详见 Record.Line 接口
     */
    private String line;

    /**
     * 解析记录的线路ID，详见 Record.Line 接口
     */
    private String line_id;

    /**
     * 记录类型, 详见 Record.Type 接口
     */
    private String type;

    /**
     * 记录的 TTL 值
     */
    private String ttl;

    /**
     * 记录值
     */
    private String value;
    private String weight;

    /**
     * 记录的 MX 记录值, 非 MX 记录类型，默认为 0
     */
    private String mx;

    /**
     * 记录状态
     * “0”: 禁用
     * “1”: 启用
     */
    private String enabled;

    /**
     * 系统内部标识状态, 开发者可忽略
     */
    private String status;

    /**
     * 该记录的D监控状态
     * “Ok”: 服务器正常
     * “Warn”: 该记录有报警, 服务器返回 4XX
     * “Down”: 服务器宕机
     * “”: 该记录未开启D监控
     */
    private String monitor_status;

    /**
     * 记录备注
     */
    private String remark;

    /**
     * 记录最后更新时间
     */
    private String updated_on;

    /**
     * 是否开通网站安全中心
     * “yes”: 已经开启
     * “no”: 未开启
     */
    private String use_aqb;

    @Override
    public boolean isEmpty() {
        return false;
    }

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

    public String getLine() {
        return line;
    }
    public void setLine(String line) {
        this.line = line;
    }

    public String getLine_id() {
        return line_id;
    }
    public void setLine_id(String line_id) {
        this.line_id = line_id;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getTtl() {
        return ttl;
    }
    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    public String getWeight() {
        return weight;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getMx() {
        return mx;
    }
    public void setMx(String mx) {
        this.mx = mx;
    }

    public String getEnabled() {
        return enabled;
    }
    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getMonitor_status() {
        return monitor_status;
    }
    public void setMonitor_status(String monitor_status) {
        this.monitor_status = monitor_status;
    }

    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUpdated_on() {
        return updated_on;
    }
    public void setUpdated_on(String updated_on) {
        this.updated_on = updated_on;
    }

    public String getUse_aqb() {
        return use_aqb;
    }
    public void setUse_aqb(String use_aqb) {
        this.use_aqb = use_aqb;
    }
}
