package com.example.planetetp5;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedHashMap;


public class MonRecyclerViewAdapterPatient extends RecyclerView.Adapter<MonRecyclerViewAdapterPatient.ConteneurDeDonnee> {
    private Context context;
    private ArrayList<LinkedHashMap<String, String>> patients;

    public MonRecyclerViewAdapterPatient(Context context, ArrayList<LinkedHashMap<String, String>> activites) {
        this.context = context;
        this.patients = activites;
    }

    @NonNull
    @Override
    public MonRecyclerViewAdapterPatient.ConteneurDeDonnee onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_liste_activite, parent, false);
        return new ConteneurDeDonnee(view);
    }

    @Override
    public void onBindViewHolder(ConteneurDeDonnee conteneur, int position) {

        conteneur.nom.setText(patients.get(position).get("nom"));
        conteneur.prenom.setText(patients.get(position).get("prenom"));
        conteneur.pathologie.setText(patients.get(position).get("pathologie"));
    }

    @Override
    public int getItemCount() {
        return patients.size();
    }

    public void setDetecteurDeClicSurRecycler(DetecteurDeClicSurRecycler detecteurDeClicSurRecycler) {
        ConteneurDeDonnee.detecteurDeClicSurRecycler = detecteurDeClicSurRecycler;
    }

    public static class ConteneurDeDonnee extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nom;
        TextView prenom;
        TextView pathologie;
        private static DetecteurDeClicSurRecycler detecteurDeClicSurRecycler;

        public ConteneurDeDonnee(View itemView) {
            super(itemView);
            nom = (TextView) itemView.findViewById(R.id.patient_nom);
            prenom = (TextView) itemView.findViewById(R.id.patient_prenom);
            pathologie = (TextView) itemView.findViewById(R.id.patient_pathologie);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            ((CardView)v).setCardBackgroundColor(Color.rgb(175,238,238));
            detecteurDeClicSurRecycler.clicSurRecyclerItem(getAdapterPosition(), v);
        }

    }



}
