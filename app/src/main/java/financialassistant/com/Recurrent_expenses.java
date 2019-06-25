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
public class Recurrent_expenses extends Fragment implements LoaderManager.LoaderCallbacks<List<Reccurentexpensesclass>> {

    private FloatingActionButton floatingActionButton;
    private View rootView;
    private RecyclerView myRecyclerView;
    private RecurrentexpensesAdapter recurrentexpensesAdapter;


    public Recurrent_expenses() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle recurrentexpensesbundle = new Bundle();
        LoaderManager loaderManager = getLoaderManager();
        Loader<List<Reccurentexpensesclass>> loader = loaderManager.getLoader(4);

        if (loader == null){
            loaderManager.initLoader(2,recurrentexpensesbundle,this).forceLoad();
            Log.d("LoaderInitializing","Initializing loaders ");
        }

        getActivity().getActionBar().setTitle("Recurrent_expenses page");
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_expense, container, false);
        floatingActionButton = rootView.findViewById(R.id.fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gotoactivityrecurrentexpenses();
            }
        });
        myRecyclerView = rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL,false);
        myRecyclerView.setLayoutManager(linearLayoutManager);
        recurrentexpensesAdapter = new RecurrentexpensesAdapter(getActivity().getApplicationContext());
        myRecyclerView.setAdapter(recurrentexpensesAdapter);

        return rootView;
    }
    public void gotoactivityrecurrentexpenses() {
        Intent Intent = new Intent(getActivity().getApplicationContext(), Activity_Recurrent_expenses.class);
        startActivity(Intent);
    }

    @NonNull
    @Override
    public Loader<List<Reccurentexpensesclass>> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new AsyncTaskLoader<List<Reccurentexpensesclass>>(getActivity().getApplicationContext()) {
            @Nullable
            @Override
            public List<Reccurentexpensesclass> loadInBackground()
            {
                final List<Reccurentexpensesclass> listRecurrentexpenses = new ArrayList<>();
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference = firebaseDatabase.getReference().child("Recurrent Expenses");

                databaseReference.addValueEventListener(new ValueEventListener()
                {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot)
                    {
                        Iterable<DataSnapshot> recurrentexpenseList = dataSnapshot.getChildren();
                        for (DataSnapshot oneRecurrentexpens : recurrentexpenseList)
                        {
                            Reccurentexpensesclass myRecurrentexpense = new Reccurentexpensesclass();
                            myRecurrentexpense = oneRecurrentexpens.getValue(Reccurentexpensesclass.class);
                            listRecurrentexpenses.add(myRecurrentexpense);
                        }
                        recurrentexpensesAdapter.setReccurentexpensesclassArrayList(listRecurrentexpenses);
                        myRecyclerView.setAdapter(recurrentexpensesAdapter);
                        Log.d("Read","All details read" + listRecurrentexpenses.size());
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        System.out.println("The read failed: " + databaseError.getCode());
                    }
                });

                return listRecurrentexpenses;
            }
        };
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Reccurentexpensesclass>> loader, List<Reccurentexpensesclass> reccurentexpensesclasses) {

    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Reccurentexpensesclass>> loader) {

    }
}
