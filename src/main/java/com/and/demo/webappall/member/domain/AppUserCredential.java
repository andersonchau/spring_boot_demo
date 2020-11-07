package com.and.demo.webappall.member.domain;

import javax.persistence.*;
import java.io.Serializable;

/*
CREATE TABLE ansontestdb.app_user_credential (
	id int NOT NULL AUTO_INCREMENT,
	user_id int NOT NULL,
	status int NOT NULL,
	username varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
	FOREIGN KEY(user_id) REFERENCES app_user(id),
	PRIMARY KEY (ID)
);

 */

@Entity
@Table(name = "app_user_credential")
public class AppUserCredential  implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    int status;

    String username;

    String password;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    // this means app_user_credential.user_id (FK) -> app_user.id
    private AppUser appUser;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
