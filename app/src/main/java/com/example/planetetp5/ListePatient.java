package com.example.planetetp5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListePatient extends Fragment implements DetecteurDeClicSurRecycler{

    private RecyclerView mRecyclerView;
    private MonRecyclerViewAdapterPatient mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    CoordinatorLayout mcoordinatorLayout;
    Donnee donnee = new Donnee(this);

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
        mAdapter = new MonRecyclerViewAdapterPatient(getDataSource());
        mRecyclerView.setAdapter(mAdapter);

        mcoordinatorLayout = view.findViewById(R.id.coordinatorLayout);
        //RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, R.drawable.divider);
        //mRecyclerView.addItemDecoration(itemDecoration);

        int position = 0;
        mcoordinatorLayout = view.findViewById(R.id.coordinatorLayout);
        return view;
    }

    private ArrayList<Donnee> getDataSource() {
        ArrayList results = new ArrayList<Donnee>();
        for (int index = 0; index < donnee.taillePlanetes.length; index++) {
            Donnee obj = new Donnee(donnee.planet[index] ,donnee.taillePlanetes[index], donnee.image[index]);
            results.add(index, obj);
        }
        return results;
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
