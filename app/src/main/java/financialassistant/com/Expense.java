package financialassistant.com;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Expense extends Fragment implements LoaderManager.LoaderCallbacks<List<Expenseclass>> {

    private FloatingActionButton floatingActionButton;
    private View rootView;
    private RecyclerView myRecyclerView;
    private ExpenseAdapter expenseAdapter;
    public Expense() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle expensebundle = new Bundle();
        LoaderManager loaderManager = getLoaderManager();
        Loader<List<Expenseclass>> loader = loaderManager.getLoader(3);

        if (loader == null){
            loaderManager.initLoader(2,expensebundle,this).forceLoad();
            Log.d("LoaderInitializing","Initializing loaders ");
        }

//        getActivity().getActionBar().setTitle("Expense page");
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_expense, container, false);
        floatingActionButton = rootView.findViewById(R.id.fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            gotoactivityexpense();
        }
    });
        myRecyclerView = rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        myRecyclerView.setLayoutManager(linearLayoutManager);
        expenseAdapter = new ExpenseAdapter(getActivity().getApplicationContext());
        myRecyclerView.setAdapter(expenseAdapter);

        return rootView;
    }
    public void gotoactivityexpense() {
        Intent Intent = new Intent(getActivity().getApplicationContext(), Activity_Expense.class);
        startActivity(Intent);
    }

    @NonNull
    @Override
    public Loader<List<Expenseclass>> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new AsyncTaskLoader<List<Expenseclass>>(getActivity().getApplicationContext()) {
            @Nullable
            @Override
            public List<Expenseclass> loadInBackground() {
                final List<Expenseclass> listExpense = new ArrayList<>();
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference = firebaseDatabase.getReference().child("Expense");

                databaseReference.addValueEventListener(new ValueEventListener()
                {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot)
                    {
                        Iterable<DataSnapshot> expenseList = dataSnapshot.getChildren();
                        for (DataSnapshot oneExpense : expenseList)
                        {
                            Expenseclass myExpense = new Expenseclass();
                            myExpense = oneExpense.getValue(Expenseclass.class);
                            listExpense.add(myExpense);
                        }
                        expenseAdapter.setExpenseclassArrayList(listExpense);
                        myRecyclerView.setAdapter(expenseAdapter);
                        Log.d("Read","All details read" + listExpense.size());
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        System.out.println("The read failed: " + databaseError.getCode());

                    }
                });
                return listExpense;


            }
        };
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Expenseclass>> loader, List<Expenseclass> expenseclasses) {

    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Expenseclass>> loader) {

    }
}
