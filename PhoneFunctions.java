import java.util.Scanner;


public class PhoneFunctions {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("555");

    public static void main(String[] args){

        boolean quit = false;
        startPhone();
        menuOption();

        while(!quit){
            System.out.println("Press number 6 to see options");
            System.out.print("Select your option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();


            switch(choice){
                case 0:
                    System.out.println("Shutting down");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    System.out.print("Enter name of contact to remove: ");
                    String name = scanner.nextLine();
                    mobilePhone.removeContact(name);
                    break;
                case 5:
                    System.out.print("Enter contact name to check: ");
                    String contactCheck = scanner.nextLine();
                    mobilePhone.checkContact(contactCheck);
                    //checkContact();
                    break;
                case 6:
                    menuOption();
                    break;
            }
        }

    }
    private static void addContact(){
        System.out.print("\nEnter contact name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact number: ");
        String phoneNumber = scanner.nextLine();
        Contacts contact = Contacts.createContact(name, phoneNumber);
        if(mobilePhone.addContact(contact)){
            System.out.println("\nContact: " + contact.getName() + " \nPhone number: " + contact.getPhoneNumber()
            + " \nHas been added \n");
        } else {
            System.out.println("Contact already exists");
        }
    }
    public static void startPhone(){
        System.out.println("Starting phone");
    }
    public static void menuOption(){
        System.out.println("Press button to select your option: \n" +
                "0 - Shutdown\n" +
                "1 - Print contacts\n" +
                "2 - Add new contact\n" +
                "3 - Update existing contact\n" +
                "4 - Remove contact\n" +
                "5 - Check if contact exists\n" +
                "6 - Print actions\n");
    }
    public static void updateContact(){
        System.out.print("Enter contact name: ");
        String name = scanner.nextLine();
        if(mobilePhone.findContact(name) >= 0){
            Contacts oldContact = mobilePhone.queryContact(name);
            System.out.print("Enter new contact name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new contact phone number: ");
            String phoneNumber = scanner.nextLine();
            Contacts newContact = Contacts.createContact(newName, phoneNumber);
            mobilePhone.updateContact(oldContact, newContact);
        } else {
            System.out.println("Contact was not found");
        }
    }
}



import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contacts> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();

    }
    public boolean addContact(Contacts contacts){
        if ( findContact(contacts.getName()) >= 0 ){
            return false;
        } else {
            myContacts.add(contacts);
            return true;
        }

    }
    public int findContact(Contacts contacts) {
        return this.myContacts.indexOf(contacts);
    }

    public int findContact(String name){
        for ( int i = 0; i < myContacts.size(); i++){
            String contactName = myContacts.get(i).getName();
            if(contactName.equals(name)){
                return i;
            }
        }
        return -1;
    }
    public void printContacts(){
        System.out.println("Contact List");
        for ( int i = 0; i < this.myContacts.size(); i++){
            System.out.println(i+1 + ". " + this.myContacts.get(i).getName() + " --> " + this.myContacts.get(i).getPhoneNumber());
        }
    }
    public boolean updateContact(Contacts oldContact, Contacts newContact){
        if(findContact(oldContact) >= 0){
            myContacts.set(findContact(oldContact), newContact);
            System.out.println("Contact was successfully updated");
            return true;
        } else {
            System.out.println("Contact was not found");
            return false;
        }
    }
    public Contacts queryContact(String name){
        int position = findContact(name);
        if(position >= 0){
            return this.myContacts.get(position);
        } else {
            return null;
        }
    }
    public boolean removeContact(String name){
        if(findContact(name) >= 0){
            Contacts removable = queryContact(name);
            myContacts.remove(removable);
            System.out.println("Contact " + name + " was removed");
            return true;
        } else {
            System.out.println("Contact doesn't exist");
            return false;
        }
    }
    public boolean checkContact(String name){
        int position = findContact(name);
        if (position >= 0){
            Contacts check = queryContact(name);
            System.out.println("Contact exists\nName - " + check.getName() + "\nPhone number - " + check.getPhoneNumber());
            return true;
        } else {
            System.out.println("Contact doesn't exist");
            return false;
        }
    }
}
public class Contacts {
    private String name;
    private String phoneNumber;

    public Contacts (String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public static Contacts createContact(String name, String phoneNumber){
        return new Contacts(name, phoneNumber);
    }
}
