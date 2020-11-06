package com.and.demo.webappall.member.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class AppRole {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(name ="role_short_name")
    String name;

    @NotNull
    String description;




    /*
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "app_role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "app_user_id", referencedColumnName = "id"))
    private Set<AppUser> appUsers;
    */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
