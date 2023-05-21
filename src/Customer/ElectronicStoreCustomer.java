package Customer;

import java.util.Scanner;

public class ElectronicStoreCustomer extends ConvenienceStoreCustomer {

    protected String securedEmail;

    public ElectronicStoreCustomer(CustomerKind kind) {
        super(kind);
    }

    public void getUserInput(Scanner input) {
        setCustomerID(input);
        setCustomerName(input);
        setCustomerEmailwithYN(input);
        setSecuredCustomerEmailwithYN(input);
        setCustomerPhone(input);
    }

    public void setSecuredCustomerEmailwithYN(Scanner input) {
        char answer = 'x';
        while (answer != 'Y' && answer != 'N') {
            System.out.print("Do you have a secured email address? (Y/N)");
            answer = input.next().charAt(0);
            answer = Character.toUpperCase(answer);

            if (answer == 'Y') {
                setCustomerEmail(input);
                break;
            } else if (answer == 'N') {
                this.setEmail("");
                break;
            } else {
            }
        }
    }

    public void printInfo() {
        String skind = getKindString();
        System.out.println("kind:" + skind + " name:" + name + " id:" + id + " email:" + email + " phone:" + phone);
    }
}
