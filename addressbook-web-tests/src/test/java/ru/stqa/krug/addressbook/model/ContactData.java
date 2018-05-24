package ru.stqa.krug.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
    @Table (name = "addressbook")
public class ContactData {
     @Id
     @Column(name = "id")
    private int id = Integer.MAX_VALUE;

    @Expose
    @Column (name = "firstname")
    private String name;
    @Expose
    @Column (name = "middlename")
    private String middlename;
    @Expose
    @Column (name = "lastname")
    private String lastname;
    @Expose
    @Column (name = "nickname")
    private String nickname;
    @Expose
    @Column (name = "address")
    @Type(type = "text")
    private String address;
    @Expose
    @Column (name = "mobile")
    @Type(type = "text")
    private String mobile;
    @Expose
    @Column (name = "home")
    @Type(type = "text")
    private String home;
    @Expose
    @Column (name = "work")
    @Type(type = "text")
    private String work;
    @Expose
    @Column (name = "email")
    @Type(type = "text")
    private String email;
    @Expose
    @Column (name = "email2")
    @Type(type = "text")
    private String email2;
    @Expose
    @Column (name = "email3")
    @Type(type = "text")
    private String email3;
    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable (name = "address_in_groups",
            joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupData> groups = new HashSet<GroupData>();
    @Expose
    @Column (name = "photo")
    @Type(type = "text")
    private String photo;


    @Transient
    private String allEmails;
    @Transient
    private String allPhones;
    public File getPhoto() {
        if (photo == null) {
            return null;
        } else {
            return new File(photo);
        }
    }

        @Override
        public String toString() {
            return "ContactData{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", middlename='" + middlename + '\'' +
                    ", lastname='" + lastname + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", address='" + address + '\'' +
                    ", mobile='" + mobile + '\'' +
                    ", home='" + home + '\'' +
                    ", work='" + work + '\'' +
                    ", email='" + email + '\'' +
                    ", email2='" + email2 + '\'' +
                    ", email3='" + email3 + '\'' +
                    ", photo='" + photo + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ContactData that = (ContactData) o;
            return id == that.id &&
                    Objects.equals(name, that.name) &&
                    Objects.equals(middlename, that.middlename) &&
                    Objects.equals(lastname, that.lastname) &&
                    Objects.equals(nickname, that.nickname) &&
                    Objects.equals(address, that.address) &&
                    Objects.equals(mobile, that.mobile) &&
                    Objects.equals(home, that.home) &&
                    Objects.equals(work, that.work) &&
                    Objects.equals(email, that.email) &&
                    Objects.equals(email2, that.email2) &&
                    Objects.equals(email3, that.email3);
        }

        @Override
        public int hashCode() {

            return Objects.hash(id, name, middlename, lastname, nickname, address, mobile, home, work, email, email2, email3);
        }

        public ContactData withPhoto(File photo) {
            this.photo = photo.getPath();
            return this;
        }
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

    public String getAllEmails() {
        return allEmails;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
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

    public Groups getGroups() {
        return new Groups(groups);
    }

    public ContactData withMobile(String mobile) {
        this.mobile = mobile;

        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }
   public ContactData withGroup(GroupData group) {
        groups.add(group);
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

    }
