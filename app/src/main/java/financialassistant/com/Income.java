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
public class Income extends Fragment implements LoaderManager.LoaderCallbacks<List<Incomeclass>> {


    private FloatingActionButton floatingActionButton;
    private View rootView;
    private RecyclerView myRecyclerView;
    private IncomeAdapter incomeAdapter;
    public Income() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle incomebundle = new Bundle();
        LoaderManager loaderManager = getLoaderManager();
        Loader<List<Incomeclass>> loader = loaderManager.getLoader(2);

        if (loader == null){
            loaderManager.initLoader(2,incomebundle,this).forceLoad();
            Log.d("LoaderInitializing","Initializing loaders ");
        }

//        getActivity().getActionBar().setTitle("Income page");
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_income, container, false);
        floatingActionButton = rootView.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gotoactivityincome();
            }
        });

        myRecyclerView = rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        myRecyclerView.setLayoutManager(linearLayoutManager);
        incomeAdapter = new IncomeAdapter(getActivity().getApplicationContext());
        myRecyclerView.setAdapter(incomeAdapter);


        return rootView;
    }
    public void gotoactivityincome() {
        Intent Intent = new Intent(getActivity().getApplicationContext(), Activity_Income.class);
        startActivity(Intent);
    }

    @NonNull
    @Override
    public Loader<List<Incomeclass>> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new AsyncTaskLoader<List<Incomeclass>>(getActivity().getApplicationContext()) {
            @Nullable
            @Override
            public List<Incomeclass> loadInBackground()
            {
                final List<Incomeclass> listIncome = new ArrayList<>();
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference = firebaseDatabase.getReference().child("Income");

                databaseReference.addValueEventListener(new ValueEventListener()
                {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot)
                    {
                        Iterable<DataSnapshot> incomeList = dataSnapshot.getChildren();
                        for (DataSnapshot oneIncome : incomeList)
                        {
                            Incomeclass myIncome = new Incomeclass();
                            myIncome = oneIncome.getValue(Incomeclass.class);
                            listIncome.add(myIncome);
                        }
                          incomeAdapter.setIncomeclassArrayList(listIncome);
                          myRecyclerView.setAdapter(incomeAdapter);
                          Log.d("Read","All details read" + listIncome.size());
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        System.out.println("The read failed: " + databaseError.getCode());
                    }
                });

               return listIncome;
            }
        };

        }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Incomeclass>> loader, List<Incomeclass> incomeclasses) {

    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Incomeclass>> loader) {

    }
}
