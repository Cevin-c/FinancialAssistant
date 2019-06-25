package financialassistant.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity_Expense extends AppCompatActivity {
    private EditText mdescription_edittext;
    private DatabaseReference mDatabase;


   AutoCompleteTextView mperiod_textview;

   private EditText mamount_edittext;
   private Button msubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__expense);

                String[] period = {"Annually", "Monthly"};
                System.out.println(period[0]);


                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_singlechoice, period);
                mperiod_textview = (AutoCompleteTextView) findViewById(R.id.editText8);
                mperiod_textview.setThreshold(1);
                mperiod_textview.setAdapter(adapter);

                mperiod_textview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                    {
                      String period = String.valueOf(parent.getItemAtPosition(position));
                      Log.d("selected" , "item selected");
                    }
                });


                mdescription_edittext = (EditText)findViewById(R.id.editText7);
                mamount_edittext = (EditText)findViewById(R.id.editText9);
                msubmit = (Button)findViewById(R.id.button8);

        mDatabase = FirebaseDatabase.getInstance().getReference();


        msubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String description_edittext = mdescription_edittext.getText().toString();
                String period = mperiod_textview.getText().toString();
                String amount = mamount_edittext.getText().toString();

                Expenseclass newuser = new Expenseclass(description_edittext,period,amount);

                Intent intent = new Intent(Activity_Expense.this,MyIntentService.class);
                intent.setAction(Backgroundclass.writeExpense);
                intent.putExtra("Expense",newuser);
                startService(intent);
            }
        });
    }
}



