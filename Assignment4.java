import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.Scanner;


/**
* Graphical user interface for Banking application
*
* Created by Dayan & Nicki
* Last Updated: 12.Feb.2018 21:43
*/
public class Assignment4 extends Application {
  private Customer accountHolder;
  private BankAccount bankAccount = new BankAccount(accountHolder);
  private double newDeposit = 0;
  private double newWithdrawl = 0;
  private double accountBalance = bankAccount.getBalance();


  //Added a setCustomer method - Dayan -- changed it to setAccountHolder since it seemed a bit clearer than UserCustomer (nicki)
  public void setAccountHolder() {
    String name;
    int id;
    System.out.println("Enter a customer Name: ");
    Scanner keyName = new Scanner(System.in);
    name = keyName.next();

    System.out.println("Enter a customer ID number: ");
    Scanner keyID = new Scanner(System.in);
    id = keyID.nextInt();

    accountHolder = new Customer(name, id);
  }
  //Main method
  public static void main(String[] args) {
    launch(args);
  }
  //Start method for the JavaFX application
  public void start(Stage primaryStage) {
    setAccountHolder();

    //Create a new group to hold the buttons and boxes. -- dont need StackPane
    Group root = new Group();

    //Vbox containing all hboxes
    VBox vBox = new VBox(30);

    //Hbox containing the balance and a label for it
    HBox balanceBox = new HBox(10);
    Label statBalance = new Label("Balance: " + accountBalance);
    balanceBox.getChildren().add(statBalance);

    //Hbox containing Customer info
    HBox accountHolderBox = new HBox(10);
    Label accountHolderName = new Label("Account Holder Name: " + accountHolder.getName());
    Label accountHolderID = new Label("Account ID: " + accountHolder.getID());
    accountHolderBox.getChildren().addAll(accountHolderName, accountHolderID);

    //HBox Containing Buttons for withdrawl and deposit
    HBox buttons = new HBox();
    Button withdrawal = new Button("Withdraw");
    Button deposit = new Button("Deposit");


    //Vbox Containing the user input area
    VBox changeInMoney = new VBox();
    TextField entry = new TextField("Enter Withdrawal or Deposit Amount");
    entry.setPrefWidth(100);
    changeInMoney.getChildren().add(entry);

    //Create actions for buttons
    HandleButtonClick depositAction = new HandleButtonClick(statBalance, entry,
                                                            bankAccount, 1);
    deposit.setOnAction(depositAction);


    HandleButtonClick withdrawalAction = new HandleButtonClick(statBalance, entry,
                                                              bankAccount, -1);
    withdrawal.setOnAction(withdrawalAction);


    buttons.getChildren().addAll(withdrawl, deposit);

    vBox.getChildren().addAll(accountHolderBox, balanceBox, buttons, changeInMoney);
    root.getChildren().add(vBox);
    Scene scene = new Scene(root, 500, 300);

    primaryStage.setTitle("BankAccount");
    primaryStage.setScene(scene);
    primaryStage.show();

  }
}
