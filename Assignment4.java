import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.Scanner;


/**
* Graphical user interface for Banking application
*
* Created by Dayan
* Last Updated: 12.Feb.2018
*/
public class Assignment4 extends Application {
  private Customer customer;
  private BankAccount bankAccount = new BankAccount(customer);
  private double newDeposit = 0;
  private double newWithdrawl = 0;
  private double accountBalance = bankAccount.getBalance();
  private final int HBOXWIDTH = 10;
  private final int HBOXWIDTH = 30;
  private final int SCREENHEIGHT = 300;
  private final int SCREENWIDTH = 500;
  private final int TEXTFIELDWIDTH = 100;
  private final int MATHSIGN = 1;


  //Added a setCustomer method - Dayan
  public void setUserCustomer() {
    String name;
    int id;
    System.out.println("Enter a customer Name: ");
    Scanner keyName = new Scanner(System.in);
    name = keyName.next();

    System.out.println("Enter a customer ID number: ");
    Scanner keyID = new Scanner(System.in);
    id = keyID.nextInt();

    customer = new Customer(name, id);
  }
  //Main method
  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage primaryStage) {
    setUserCustomer();

    StackPane root = new StackPane();

    //Vbox containing all hboxes
    VBox vBox = new VBox(VBOXWIDTH);

    //Hbox containing the balance and a label for it
    HBox balanceBox = new HBox(HBOXWIDTH);
    Label statBalance = new Label("Balance: " + accountBalance);
    balanceBox.getChildren().add(statBalance);

    //Hbox containing Customer info
    HBox accountHolderBox = new HBox(HBOXWIDTH);
    Label accountHolderName = new Label("Account Holder Name: " + customer.getName());
    Label accountHolderID = new Label("Account ID: " + customer.getID());
    accountHolderBox.getChildren().addAll(accountHolderName, accountHolderID);

    //HBox Containing Buttons for withdrawl and deposit
    HBox buttons = new HBox();
    Button withdrawl = new Button("Withdrawl");
    Button deposit = new Button("Deposit");


    //Vbox Containing the user input area
    VBox changeInMoney = new VBox();
    TextField entry = new TextField("Enter Withdrawl or Deposit Amount");
    entry.setPrefWidth(TEXTFIELDWIDTH);
    changeInMoney.getChildren().add(entry);

    //Create actions for buttons
    HandleButtonClick depositAction = new HandleButtonClick(statBalance, entry,
                                                            bankAccount, MATHSIGN);
    deposit.setOnAction(depositAction);


    HandleButtonClick withdrawlAction = new HandleButtonClick(statBalance, entry,
                                                              bankAccount, -MATHSIGN);
    withdrawl.setOnAction(withdrawlAction);


    buttons.getChildren().addAll(withdrawl, deposit);

    vBox.getChildren().addAll(accountHolderBox, balanceBox, buttons, changeInMoney);
    root.getChildren().add(vBox);
    Scene scene = new Scene(root, SCREENWIDTH, SCREENHEIGHT);

    primaryStage.setTitle("BankAccount");
    primaryStage.setScene(scene);
    primaryStage.show();

  }
}

