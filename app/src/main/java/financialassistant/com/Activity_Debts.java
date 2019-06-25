package financialassistant.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity_Debts extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private EditText mDescription;
    private EditText mDateborrowed;
    private EditText mDuedate;
    private Button mSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__debts);

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

                Userclass newuser = new Userclass(description,duedate,dateborrowed);

                Intent intent = new Intent(Activity_Debts.this,MyIntentService.class);
                intent.setAction(Backgroundclass.writeDebts);
                intent.putExtra("Debts",newuser);
                startService(intent);
            }
        });
            }
    }

