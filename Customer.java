import java.util.InputMismatchException;
/**
* Team #5 Assignment 3
* Rough Draft by Dayan Jayasuriya, Nicki Lindstrom and Riley Schaaf
* Last updated 7/FEB/2018 09:17 by Dayan.
*
*
* Class Representing a customer
*/
public class Customer {
  private String name;
  private int customerID;

  /**
  * Constructor for no input
  */
  public Customer() {
  }

  /**
  * Constructor for name and ID input
  */
  public Customer(String newName, int newCustomerID) {
      name = newName;
      customerID = newCustomerID;
  }

  /**
  * Constructor for name only
  */
  public Customer(String newName){
    name = newName;
  }
  /**
  * Constructor for ID input only
  */
  public Customer(int newCustomerID){
    customerID = newCustomerID;
  }

  /**
  * Copy constructor for the Customer class.
  */
  public Customer (Customer oldCustomer){
    name = oldCustomer.getName();
    customerID = oldCustomer.getID();
  }



  /**
  * Setter and Getter methods for name
  */
  public String getName() {
    return name;
  }

  public void setName(String newName) {
    try {
      name = newName;
    }

    catch(InputMismatchException e) {
      System.out.println("You did not enter a String. Try again.");
    }
  }

  /**
  * Setter and Getter methods for customerID
  */
  public int getID() {
    return customerID;
  }

  public void setCustomerID(int newCustomerID) {
    try {
      customerID = newCustomerID;
    }

    catch(InputMismatchException e) {
      System.out.println("You did not enter an integer. Try again.");
    }
  }

  /**
  * Convert instance variables to a combined string
  */
  public String toString() {
    String varString = ("Customer name: " + name + "; "
                      + "Customer ID: " + customerID);
    return varString;
  }
}
