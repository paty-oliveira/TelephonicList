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

//    public static void main() {
//        PizzaFactory factory = new NapolitanaFactory();
//        PizzaController controller = new DefaultPizzaController(factory);
//        new Gui(controller).show();
//    }
//
//    static class Gui {
//        
//        private PizzaController controller;
//
//        public Gui(PizzaController controller) {
//            this.controller = controller;
//        }
//
//        void show() {
//            // ...
//            // ..
//            Pizza newPizza = this.controller.newPizza("input");
//            System.out.println(newPizza);
//        }
//    }
//
//    // ASL
//    interface PizzaController {
//
//        Pizza newPizza(String name);
//    }
//
//    static class DefaultPizzaController implements PizzaController {
//        
//        private PizzaFactory factory;
//
//        public DefaultPizzaController(PizzaFactory factory) {
//            this.factory = factory;
//        }
//
//        @Override
//        public Pizza newPizza(String name, boolean withOlives) {
//            return this.factory.newPizzaByName("napolitana");
//        }
//    }
//    
//    static class V2PizzaController implements PizzaController {
//        
//        private PizzaFactory factory;
//
//        public V2PizzaController(PizzaFactory factory) {
//            this.factory = factory;
//        }
//
//        @Override
//        public Pizza newPizza(String name) {
//            return this.factory.newPizzaByName("napolitana");
//        }
//    }
//    
//    
//    interface PizzaFactory {
//        Pizza newPizzaByName(String name);
//    }
//    
//    static class NapolitanaFactory implements PizzaFactory {
//
//        @Override
//        public Pizza newPizzaByName(String name) {
//            try {
//                return new PizzaNapolitana();
//            } catch (Exception ex) {
//                Logger.getLogger(TelephoneList.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            return null;
//        }
//        
//    }
//
//    // Domain
//    class Ingredient {
//
//        private String name;
//
//        public Ingredient(String name) {
//            this.name = name;
//        }
//
//        public String getName() {
//            return name;
//        }
//    }
//
//    static abstract class Pizza {
//
//        private List<Ingredient> ingredients;
//        private String name;
//       
//        public Pizza(List<Ingredient> ingredients, String name) throws Exception {
//            if (!isValid(ingredients)) {
//                this.ingredients.stream().filter(x -> x.name.contains("cheese"));
//                throw new Exception("esta pizza não ....");
//            }
//            this.ingredients = ingredients;
//            this.name = name;
//        }
//
//        public List<Ingredient> getIngredients() {
//            return ingredients;
//        }
//
//        public String getName() {
//            return this.name;
//        }
//
//        protected abstract boolean isValid(List<Ingredient> ingredients);
//
//    }
//
//    static class PizzaNapolitana extends Pizza {
//
//        public PizzaNapolitana(List<Ingredient> ingredients) throws Exception {
//            super(ingredients, "napolitana");
//        }
//
//        public PizzaNapolitana() throws Exception {
//            super(null, null);
//        }
//
//        @Override
//        protected boolean isValid(List<Ingredient> ingredients) {
//            return true;
//        }
//
//    }
//
//    static class EmptyPizza extends Pizza {
//
//        public EmptyPizza(List<Ingredient> ingredients, String name) throws Exception {
//            super(ingredients, name);
//        }
//
//        public EmptyPizza() throws Exception {
//            super(null, null);
//        }
//
//        @Override
//        protected boolean isValid(List<Ingredient> ingredients) {
//            return true;
//
//        }
//
//    }
//
//    protected List<TelephonicContact> telephonicContacts;
//
//    private TelephoneList(List<TelephonicContact> telephonicContacts) {
//        this.telephonicContacts = telephonicContacts;
//    }
//
//    private TelephoneList() {
//        this(new ArrayList<TelephonicContact>());
//    }
//
//    public void addContact(TelephonicContact contact) {
//        this.telephonicContacts.add(contact);
//    }
//
//    public List<TelephonicContact> getTelephonicList() {
//        return this.telephonicContacts;
//    }
//
//    public void removeContact(TelephonicContact contact) {
//        this.telephonicContacts.remove(contact);
//    }
}
