package ru.stqa.krug.addressbook.generators;

import ru.stqa.krug.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    public static void main (String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);

        List<ContactData> contacts = generateContacts(count);
        save(contacts, file);

    }

    private static void save(List<ContactData> contacts, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        Writer writer = new FileWriter(file);
        for (ContactData contact: contacts) {
            writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getName(), contact.getMiddlename()
                    , contact.getLastname(),contact.getNickname(),contact.getAddress(),
                    contact.getHome(), contact.getMobile(),contact.getWork(),  contact.getEmail()
                    , contact.getEmail2(), contact.getEmail3(), contact.getGroup()
            ));
        }
        writer.close();

    }

    private static List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i=0; i<count; i++) {
            contacts.add(new ContactData().withName(String.format("Konstantin %s", i))
                    .withMiddlename(String.format("Nikolaevich %s", i))
                    .withLastname(String.format("Kruglov %s", i))
                    .withNickname(String.format("Krug %s", i))
                    .withAddress(String.format("21 High st. apt. 11, Hudson, MA, USA %s", i))
                    .withHome(String.format("6176718890 %s", i))
                    .withMobile(String.format("6176718890 %s", i))
                    .withWork(String.format("6176718890 %s", i))
                    .withEmail(String.format("kruglovkn90@gmail.com %s", i))
                    .withEmail2(String.format("kruglovkn90@gmail.com %s", i))
                    .withEmail3(String.format("kruglovkn90@gmail.com %s", i))
                    .withGroup(String.format("test %s", i)));
        }
        return contacts;
    }
}
