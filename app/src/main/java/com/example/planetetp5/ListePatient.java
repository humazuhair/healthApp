package com.example.planetetp5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ListePatient extends DialogFragment implements DetecteurDeClicSurRecycler{

    FragmentManager fragmentManager;

    private RecyclerView mRecyclerView;
    private MonRecyclerViewAdapterPatient mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    CoordinatorLayout mcoordinatorLayout;

    public ListePatient(){

    }

    public static ListePatient newInstance(FragmentManager fragmentManager){
        ListePatient listePatient = new ListePatient();
        listePatient.fragmentManager = fragmentManager;
        return listePatient;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.liste_patient, container, false);

        // Add the following lines to create RecyclerView
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        //Exercice 1 on remplace la ligne créant le LayoutManager
        //mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        //mLayoutManager=new LinearLayoutManager(this,GridLayoutManager.VERTICAL, false);

        //mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MonRecyclerViewAdapterPatient(getContext(), getDataSource());
        mRecyclerView.setAdapter(mAdapter);

        mcoordinatorLayout = view.findViewById(R.id.coordinatorLayout);
        //RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, R.drawable.divider);
        //mRecyclerView.addItemDecoration(itemDecoration);

        int position = 0;
        mcoordinatorLayout = view.findViewById(R.id.coordinatorLayout);
        return view;
    }

    private ArrayList<LinkedHashMap<String, String>> getDataSource(){

        ArrayList<LinkedHashMap<String, String>> patients = new ArrayList<>();

        LinkedHashMap<String, String> patient1 = new LinkedHashMap<>();
        patient1.put("nom", "Juw");
        patient1.put("prenom", "Alex");
        patient1.put("pathologie", "CTR");
        patients.add(patient1);

        LinkedHashMap<String, String> patient2 = new LinkedHashMap<>();
        patient2.put("nom", "Lopier");
        patient2.put("prenom", "Jean");
        patient2.put("pathologie", "ADHD");
        patients.add(patient2);



        return patients;

    }

    @Override
    public void onResume() {
        super.onResume();
        mAdapter.setDetecteurDeClicSurRecycler(this);
    }

    @Override
    public void clicSurRecyclerItem(int position, View v) {

    }
}
