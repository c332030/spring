package c332030.passport.model;

import c332030.utils.data.model.interfaces.C;
import c332030.utils.tools.Tools;

public class User implements C {

    private static final long serialVersionUID = 4812643396452439919L;

    private Integer userid;
    private String username;
    private String password;

    private String name;

    private Integer idtp;
    private String idno;

    private String phone;
    private String email;

    private Integer type;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", idtp=" + idtp +
                ", idno='" + idno + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean isEmpty() {
        return Tools.isEmpty(username)
                && Tools.isEmpty(phone)
                && Tools.isEmpty(email);
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdtp() {
        return idtp;
    }

    public void setIdtp(Integer idtp) {
        this.idtp = idtp;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
