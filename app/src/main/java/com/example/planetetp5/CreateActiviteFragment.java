package com.example.planetetp5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class CreateActiviteFragment extends DialogFragment {

    FragmentManager fragmentManager;
    EditText titreActivite, dureeActivite, descriptionActivite, structureActivite;
    Button creerActivite;

    public CreateActiviteFragment(){

    }

    public static CreateActiviteFragment newInstance(FragmentManager fragmentManager){
        CreateActiviteFragment createActiviteFragment = new CreateActiviteFragment();
        createActiviteFragment.fragmentManager = fragmentManager;
        return createActiviteFragment;
    }


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.create_activite, container, false);

        titreActivite = view.findViewById(R.id.activite_titre);
        dureeActivite = view.findViewById(R.id.activite_duree);
        descriptionActivite = view.findViewById(R.id.activite_description);
        structureActivite = view.findViewById(R.id.activite_structure);
        creerActivite = view.findViewById(R.id.ajouterActiviteBtn);

        structureActivite.setOnClickListener( v -> {
            ListeStructure listeStructure = ListeStructure.newInstance(fragmentManager);
            listeStructure.show(fragmentManager, "listeStructure");
        });

        creerActivite.setOnClickListener( v -> {
           getDialog().dismiss();
        });

        return view;
    }
}
