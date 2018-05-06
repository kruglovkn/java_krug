package ru.stqa.krug.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id = Integer.MAX_VALUE;;
    private String name;
    private String middlename;
    private String lastname;
    private String nickname;
    private String address;
    private String mobile;
    private String home;
    private String work;
    private String email;
    private String email2;
    private String email3;
    private String group;

    public int getId() {
        return id;
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

    public String getHome() { return home;  }

    public String getWork() { return work; }

    public String getEmail2() { return email2; }

    public String getEmail3() { return email3; }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public String getGroup() {
        return group;
    }
    public ContactData withName(String name) {
        this.name = name;
        return this;
    }

    public ContactData withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }
    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }
    public ContactData withHome (String home){
        this.home = home;
        return this;
    }
    public ContactData withWork (String work){
        this.work = work;
        return this;
    }
    public ContactData withEmail2 (String email2){
        this.email2 = email2;
        return this;
    }
    public ContactData withEmail3 (String email3){
        this.email3 = email3;
        return this;
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
