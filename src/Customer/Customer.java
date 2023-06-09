package Customer;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import Exception.EmailFormatException;

public abstract class Customer implements CustomerInput, Serializable {
    @Serial
    private static final long serialVersionUID = 3007123713864203242L;
    protected CustomerKind kind = CustomerKind.DepartmentStore;
    protected String name;
    protected int id;
    protected String email;
    protected String phone;

    public Customer() {
    }

    public Customer(CustomerKind kind) {
        this.kind = kind;
    }

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Customer(String name, int id, String email, String phone) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.phone = phone;
    }

    public Customer(CustomerKind kind, String name, int id, String email, String phone) {
        this.kind = kind;
        this.name = name;
        this.id = id;
        this.email = email;
        this.phone = phone;
    }

    public CustomerKind getKind() {
        return kind;
    }

    public void setKind(CustomerKind kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws EmailFormatException {
        if (!email.contains("@") && !email.equals("")) {
            throw new EmailFormatException();
        }

        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public abstract void printInfo();

    public void setCustomerID(Scanner input) {
        System.out.println("Customer ID:");
        int id = input.nextInt();
        this.setId(id);
    }

    public void setCustomerName(Scanner input) {
        System.out.println("Customer name:");
        String name = input.next();
        this.setName(name);
    }

    public void setCustomerEmail(Scanner input) {
        String email = "";
        while (!email.contains("@")) {
            System.out.println("Email address:");
            email = input.next();
            try {
                this.setEmail(email);
            } catch (EmailFormatException e) {
                System.out.println("Incorrect Email Format. Put the e-mail adress that contains @");
            }
        }
    }

    public void setCustomerPhone(Scanner input) {
        System.out.println("Phone number:");
        String phone = input.next();
        this.setPhone(phone);
    }

    public String getKindString() {
        String skind = "none";
        switch (this.kind) {
            case DepartmentStore:
                skind = "Dep.Store";
                break;
            case FoodStore:
                skind = "FoodStore";
                break;
            case ElectronicStore:
                skind = "EStore";
                break;
            case ConvenientStore:
                skind = "Conv.Store";
                break;
            default:
        }
        return skind;
    }
}
