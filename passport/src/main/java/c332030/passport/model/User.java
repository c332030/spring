package c332030.passport.model;

import c332030.utils.data.model.interfaces.C;
import c332030.utils.tools.Tools;

public class User implements C {

    private static final long serialVersionUID = -6125998326478365880L;

    private Integer id;
    private String username;
    private String password;

    private String phone;
    private String email;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean isEmpty() {

        return Tools.isEmpty(username);

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
