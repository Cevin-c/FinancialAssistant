package financialassistant.com;

import android.content.Context;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Backgroundclass {
    private Context mContext;
    public FirebaseDatabase mFirebaseDatabase;
    public DatabaseReference mref;
    public FirebaseAuth mAuth;

    public static final String writeMoneyOwed = "Moneyowed";
    public static final String writeDebts = "Debts";
    public static final String writeExpense = "Expense";
    public static final String writeIncome = "Income";
    public  static final String writeRecurrentexpenses = "Recurrent Expenses";
    public static final String writeTodo_Budget = "Todo_Budget";

    public Backgroundclass(Context context){
    this.mContext = context;

}
public void wirte (Moneyowedclass moneyowedclass)

{
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mref = firebaseDatabase.getReference();

    mref.child("Money_owed").push().setValue(moneyowedclass);

}

public void writedebts (Debtclass debtclass){
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mref = firebaseDatabase.getReference();

    mref.child("Debts").push().setValue(debtclass);
}
public void writeExpense (Expenseclass expenseclass){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference mref = firebaseDatabase.getReference();

        mref.child("Expense").push().setValue(expenseclass);

}
public void writeIncome (Incomeclass incomeclass){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference mref = firebaseDatabase.getReference();

        mref.child("Income").push().setValue(incomeclass);
}
public void writeRecurrentexpenses (Reccurentexpensesclass reccurentexpensesclass){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference mref = firebaseDatabase.getReference();

        mref.child("Recurrent Expenses").push().setValue(reccurentexpensesclass);
}
public void WriteTodo_Budget (Todoclass todoclass){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference mref = firebaseDatabase.getReference();


        mref.child("Todo_Budget").push().setValue(todoclass);
}
}