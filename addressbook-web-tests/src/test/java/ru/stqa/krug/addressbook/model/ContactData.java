package ru.stqa.krug.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id;
    private final String name;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String address;
    private final String mobile;
    private final String email;
    private String group;



    public ContactData(String name, String middlename, String lastname, String nickname, String address, String mobile,
                       String email, String group) {
        this.id = 0;
        this.name = name;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.group = group;
    }


    public ContactData(int id, String name, String middlename, String lastname, String nickname, String address, String mobile,
                       String email, String group) {
        this.id = id;
        this.name = name;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.group = group;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }


    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                "lastname='" + lastname + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, lastname);
    }

}
