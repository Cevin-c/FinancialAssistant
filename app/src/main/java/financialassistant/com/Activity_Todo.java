package financialassistant.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity_Todo extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private EditText mDescription;
    private EditText mDate;

    private Button mSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__todo);

        mDescription = (EditText)findViewById(R.id.editText7);
        mDate = (EditText)findViewById(R.id.editText8);

        mSubmit = (Button)findViewById(R.id.button8);

        mDatabase = FirebaseDatabase.getInstance().getReference();


        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String description = mDescription.getText().toString();
                String date = mDate.getText().toString();


                Todoclass newuser = new Todoclass(description,date);

                mDatabase.child("Todo(Budget)").push().setValue(newuser);
            }
        });
    }
}
