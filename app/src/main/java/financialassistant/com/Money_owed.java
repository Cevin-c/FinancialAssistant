package financialassistant.com;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Money_owed extends Fragment {


    private FloatingActionButton floatingActionButton;
    private View rootView;
    public Money_owed() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getActivity().getActionBar().setTitle("Money_Owed page");
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_money_owed, container, false);
        floatingActionButton = rootView.findViewById(R.id.fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gotoactivitymoneyowed();
            }
        });
        return rootView;
    }
    public void gotoactivitymoneyowed() {
        Intent Intent = new Intent(getActivity().getApplicationContext(), Activity_Money_owed.class);
        startActivity(Intent);
    }
}