import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
/**
This class handles a button click and outputs a message.
The handle method is invoked when the button is clicked.
*/
public class HandleButtonClick implements EventHandler<ActionEvent>
{
	private TextField amountEntered;
	private double amount;
	private BankAccount bankAccount;
	private Label alteredLabel;
	private int mathSign;

	//initiate by assigning values to the instance variables
	public HandleButtonClick(Label labelToAlter, TextField newAmountEntered,
														BankAccount existingBankAccount, int newMathSign) {
		amountEntered = newAmountEntered;
		bankAccount = existingBankAccount;
		alteredLabel = labelToAlter;
		mathSign = newMathSign;
	}

	//handle the changes in the labeleling 
	@Override
	public void handle(ActionEvent event) {
		//get value of deposit
		amount = (Double.parseDouble(amountEntered.getText()));
		//alter the label to match new balance
		if (mathSign > 0) {
			bankAccount.deposit(amount);
		}

		else {
			bankAccount.withdraw(amount);
		}
		double bankAccountBalance = bankAccount.getBalance();
		alteredLabel.setText("Balance: " + Double.toString(bankAccountBalance));
  }
}
