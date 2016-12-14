package com.company.web.fileter;

import javax.persistence.*;

@Table(name = "zth_user")
@Entity
//@EntityListeners(EntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
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
        this.userName = user.getUserName();
        this.password = user.getPassword();

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
