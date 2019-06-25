package financialassistant.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity_Recurrent_expenses extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private EditText mDescription;
    private EditText mAmount;

    private Button mSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__recurrent_expenses);

        mDescription = (EditText)findViewById(R.id.editText7);
        mAmount = (EditText)findViewById(R.id.editText8);

        mSubmit = (Button)findViewById(R.id.button8);

        mDatabase = FirebaseDatabase.getInstance().getReference();


        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String description = mDescription.getText().toString();
                String amount = mAmount.getText().toString();


                Reccurentexpensesclass newuser = new Reccurentexpensesclass(description,amount);

                mDatabase.child("Recurrent Expenses").push().setValue(newuser);
            }
        });
    }
}
