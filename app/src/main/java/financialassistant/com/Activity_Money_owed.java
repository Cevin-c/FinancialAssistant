package financialassistant.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity_Money_owed extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private EditText mDescription;
    private EditText mDateborrowed;
    private EditText mDuedate;
    private Button mSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__money_owed);

        mDescription = (EditText)findViewById(R.id.editText7);
        mDateborrowed = (EditText)findViewById(R.id.editText8);
        mDuedate = (EditText)findViewById(R.id.editText9);
        mSubmit = (Button)findViewById(R.id.button8);

        mDatabase = FirebaseDatabase.getInstance().getReference();


        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String description = mDescription.getText().toString();
                String dateborrowed = mDateborrowed.getText().toString();
                String duedate = mDuedate.getText().toString();

                Moneyowedclass newuser = new Moneyowedclass(description,dateborrowed,duedate);

                Intent intent = new Intent(Activity_Money_owed.this,MyIntentService.class);
                intent.setAction(Backgroundclass.writeMoneyOwed);
                intent.putExtra("MoneyOwed",newuser);
                startService(intent);
            }
        });
    }
}
