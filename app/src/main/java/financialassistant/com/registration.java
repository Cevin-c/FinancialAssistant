package financialassistant.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void gotoindividual(View view) {
        Intent Intent = new Intent(this, individual.class);
        startActivity(Intent);
    }

    public void gotocompany(View view) {
        Intent Intent = new Intent(this, company.class);
        startActivity(Intent);
    }


}