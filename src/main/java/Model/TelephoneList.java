/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anaoliveira
 */
public final class TelephoneList {

    public static List<TelephonicContact> fromFiles(File[] files) {
        List<TelephonicContact> contacts = new ArrayList<>();
        for (File file : files) {
            TelephonicContact contact = fromFile(file);
            if (contact != null) {
                contacts.add(contact);
            }
        }
        return contacts;
    }

    private static TelephonicContact fromFile(File file) {
        try {
            FileInputStream contactFile = new FileInputStream(file);
            ObjectInputStream contactInput = new ObjectInputStream(contactFile);

            try {
                TelephonicContact contact = (TelephonicContact) contactInput.readObject();
                return new TelephonicContact(contact.getName(), contact.getNumber());

            } finally {
                contactFile.close();
                contactInput.close();
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TelephoneList.class.getName()).log(Level.SEVERE, null, ex);

        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(TelephoneList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void toFile(String filepath, List<TelephonicContact> contacts) {
        try {
            FileOutputStream contactsFile = new FileOutputStream(filepath + "/telefonic_list.bin");
            ObjectOutputStream contactOutput = new ObjectOutputStream(contactsFile);

            try {
                for (TelephonicContact contact : contacts) {
                    contactOutput.writeObject(contact);
                }

            } finally {
                contactsFile.close();
                contactOutput.close();
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TelephoneList.class.getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(TelephoneList.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
