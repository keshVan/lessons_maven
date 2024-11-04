import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private int balance;
    private List<Operation> operationHistory = new ArrayList<>();

    public BankAccount(int balance) {
        if (balance < 0) balance = 0;
        this.balance = balance;
        operationHistory.add(new Operation("Открытие", 0));

        if (balance > 0)
            operationHistory.add(new Operation("Пополение", balance));

    }

    public BankAccount() {
        this(0);
    }

    public void deposit(int value) {
        balance += value;
        operationHistory.add(new Operation("Пополнение", value));
    }

    public int withdraw(int value) {
        if (value < 0 || value > balance)
            throw new IllegalArgumentException();
        balance -= value;
        operationHistory.add(new Operation("Снятие", value));
        return value;
    }

    public List<Operation> getOperationHistory() {
        return new ArrayList<>(operationHistory);
    }
}
