package ru.stqa.krug.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stqa.krug.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter (names = "-f", description = "Target file")
    public String file;

    public static void main (String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        save(contacts, new File(file));
    }

    private void save(List<ContactData> contacts, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        Writer writer = new FileWriter(file);
        for (ContactData contact: contacts) {
            writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getName(), contact.getMiddlename()
                    , contact.getLastname(),contact.getNickname(),contact.getAddress(),
                    contact.getHome(), contact.getMobile(),contact.getWork(),  contact.getEmail()
                    , contact.getEmail2(), contact.getEmail3(), contact.getGroup()));
        }
        writer.close();

    }

    private List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i=0; i<count; i++) {
            contacts.add(new ContactData().withName(String.format("Konstantin %s", i))
                    .withMiddlename(String.format("Nikolaevich %s", i))
                    .withLastname(String.format("Kruglov %s", i))
                    .withNickname(String.format("Krug %s", i))
                    .withAddress(String.format("21 High st. apt. 11, Hudson, MA, USA", i))
                    .withHome(String.format("6176718890" , i))
                    .withMobile(String.format("6176718890", i))
                    .withWork(String.format("6176718890", i))
                    .withEmail(String.format("kruglovkn90@gmail.com", i))
                    .withEmail2(String.format("kruglovkn90@gmail.com", i))
                    .withEmail3(String.format("kruglovkn90@gmail.com", i))
                    .withGroup(String.format("test1", i)));
        }
        return contacts;
    }
}
