package ru.stqa.krug.addressbook.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;

@Entity
    @Table (name = "address_in_groups")
public class ContactsInGroupsData {
    @Id
    @Column(name = "id")
    public int contactId;

    @Column (name = "group_id")
    public int groupId;

    public int getContactId() {
        return contactId;
    }

    public ContactsInGroupsData withContactId(int contactId) {
        this.contactId = contactId;
        return this;
    }

    public int getGroupId() {
        return groupId;
    }

    public ContactsInGroupsData withGroupId(int groupId) {
        this.groupId = groupId;
        return this;

    }

    @Override
    public String toString() {
        return "ContactsInGroupsData{" +
                "contactId=" + contactId +
                ", groupId=" + groupId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactsInGroupsData that = (ContactsInGroupsData) o;
        return contactId == that.contactId &&
                groupId == that.groupId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(contactId, groupId);
    }
}
