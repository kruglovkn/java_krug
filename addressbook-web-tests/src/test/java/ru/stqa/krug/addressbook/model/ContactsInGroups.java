package ru.stqa.krug.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ContactsInGroups extends ForwardingSet<ContactsInGroupsData> {

    private Set<ContactsInGroupsData> delegate;

    public ContactsInGroups (ContactsInGroups contactsInGroups) {
        this.delegate = new HashSet<ContactsInGroupsData>(contactsInGroups.delegate);
    }

   // public ContactsInGroups() {
    //    this.delegate = new HashSet<ContactsInGroupsData>();
   // }

    public ContactsInGroups(Collection<ContactsInGroupsData> contactsInGroups) {
        this.delegate = new HashSet<ContactsInGroupsData>(contactsInGroups);
    }

    public ContactsInGroups withMoved(ContactsInGroupsData contactInGroup) {
        ContactsInGroups contactsInGroups = new ContactsInGroups(this);
        contactsInGroups.add(contactInGroup);
        return contactsInGroups;
    }
    public ContactsInGroups withOut(ContactsInGroupsData contactInGroup) {
        ContactsInGroups contactsInGroups = new ContactsInGroups(this);
        contactsInGroups.remove(contactInGroup);
        return contactsInGroups;
    }
    @Override
    protected Set<ContactsInGroupsData> delegate() {
        return delegate;
    }
}
