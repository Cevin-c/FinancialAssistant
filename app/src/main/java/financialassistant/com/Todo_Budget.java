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
public class Todo_Budget extends Fragment {


    private FloatingActionButton floatingActionButton;
    private View rootView;
    public Todo_Budget() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        getActivity().getActionBar().setTitle("Todo(Budget) page");
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_todo__budget, container, false);
        floatingActionButton = rootView.findViewById(R.id.fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gotoactivitytodo();
            }
        });
        return rootView;
    }
    public void gotoactivitytodo() {
        Intent Intent = new Intent(getActivity().getApplicationContext(), Activity_Todo.class);
        startActivity(Intent);
    }
}