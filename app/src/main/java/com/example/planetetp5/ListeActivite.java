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

public class ListeActivite extends DialogFragment{

    FragmentManager fragmentManager;

    private RecyclerView mRecyclerView;
    private MonRecyclerViewAdapterActivite mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public ListeActivite(){

    }

    public static ListeActivite newInstance(FragmentManager fragmentManager){
        ListeActivite listeActivite = new ListeActivite();
        listeActivite.fragmentManager = fragmentManager;
        return listeActivite;
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
        View view = inflater.inflate(R.layout.liste_activite, container, false);

        // Add the following lines to create RecyclerView
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(false);

        //Exercice 1 on remplace la ligne créant le LayoutManager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        //mLayoutManager=new LinearLayoutManager(this,GridLayoutManager.VERTICAL, false);

        //mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MonRecyclerViewAdapterActivite(getContext(), getDataSource());
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    private ArrayList<LinkedHashMap<String, String>> getDataSource(){

        ArrayList<LinkedHashMap<String, String>> activites = new ArrayList<>();

        LinkedHashMap<String, String> activite1 = new LinkedHashMap<>();
        activite1.put("titre", "Natation");
        activite1.put("duree", "1");
        activite1.put("description", "Swim Swim");
        activites.add(activite1);

        LinkedHashMap<String, String> activite2 = new LinkedHashMap<>();
        activite2.put("titre", "Course");
        activite2.put("duree", "2");
        activite2.put("description", "Run Run");
        activites.add(activite2);

        LinkedHashMap<String, String> activite3 = new LinkedHashMap<>();
        activite3.put("titre", "Marche");
        activite3.put("duree", "3");
        activite3.put("description", "Walk Walk");
        activites.add(activite3);

        return activites;

    }

}