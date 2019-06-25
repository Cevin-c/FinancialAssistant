package financialassistant.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity_Income extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private EditText mDescription;
    private EditText mDate;
    private EditText mAmount;
    private Button mSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__income);

        mDescription = (EditText)findViewById(R.id.editText7);
        mDate = (EditText)findViewById(R.id.editText8);
        mAmount = (EditText)findViewById(R.id.editText9);
        mSubmit = (Button)findViewById(R.id.button8);

        mDatabase = FirebaseDatabase.getInstance().getReference();


        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String description = mDescription.getText().toString();
                String date = mDate.getText().toString();
                String amount = mAmount.getText().toString();

                Incomeclass newuser = new Incomeclass(description,amount,date);

                Intent intent = new Intent(Activity_Income.this,MyIntentService.class);
                intent.setAction(Backgroundclass.writeIncome);
                intent.putExtra("Income",newuser);
                startService(intent);
            }
        });
    }
}
