package com.company.web.domain;

import javax.persistence.*;
import java.io.Serializable;
@Table(name = "zth_user")
@Entity
public class User implements Serializable{
    private static final long serialVersionUID = 100007152668882L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String loginName;
    private String mobile;
    private String password;
    /**
     * oauth2认证的clientId
     */
    private String clientId;

    public User() {
        super();
    }


    public User(User user){
        this.id = user.getId();
        this.mobile = user.getMobile();
        this.loginName = user.getLoginName();
        this.password = user.getPassword();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
