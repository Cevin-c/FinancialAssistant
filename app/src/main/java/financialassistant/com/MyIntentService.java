package financialassistant.com;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        Log.d("OnHandleIntent","The method has been called");
    Backgroundclass backgroundclass = new Backgroundclass(this);

    String action = intent.getAction();
    if(Backgroundclass.writeMoneyOwed.equals(action))
    {
        Backgroundclass bc = new Backgroundclass(this);
        Moneyowedclass myMoney = intent.getParcelableExtra("MoneyOwed");
        bc.wirte(myMoney);
    }
    if(Backgroundclass.writeDebts.equals(action))
    {
        Backgroundclass bc = new Backgroundclass(this);
        Debtclass debt = intent.getParcelableExtra("Debts");
        bc.writedebts (debt);
    }
    if(Backgroundclass.writeExpense.equals(action)) {
        Backgroundclass bc = new Backgroundclass(this);
        Expenseclass expense = intent.getParcelableExtra("Expense");
        bc.writeExpense(expense);
    }
    if (Backgroundclass.writeIncome.equals(action)){
        Backgroundclass bc = new Backgroundclass(this);
        Incomeclass income = intent.getParcelableExtra("Income");
        bc.writeIncome(income);
    }
    if (Backgroundclass.writeRecurrentexpenses.equals(action)){
        Backgroundclass bc = new Backgroundclass(this);
        Reccurentexpensesclass reccurent = intent.getParcelableExtra("Recurrent Expenses");
        bc.writeRecurrentexpenses(reccurent);
    }
    if (Backgroundclass.writeTodo_Budget.equals(action))
    {
    Backgroundclass bc = new Backgroundclass(this);
    Todoclass todo =intent.getParcelableExtra("Todo_Budget");
    bc.WriteTodo_Budget(todo);
      }
    }
}



