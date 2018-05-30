package ru.stqa.pft.mantis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mantis_user_table")
public class UserData {
    @Id
    @Column (name = "id")
    private int id;
    @Column(name = "username")
    private String name;
    @Column(name = "email")
    private String email;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public UserData withId(int id) {
        this.id = id;
        return this;
    }

    public UserData setName(String name) {
        this.name = name;
        return this;
    }

    public UserData setEmail(String email) {
        this.email = email;
        return this;
    }
}
