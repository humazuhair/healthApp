package com.example.planetetp5;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MonRecyclerViewAdapterPatient extends RecyclerView.Adapter<com.example.planetetp5.MonRecyclerViewAdapterPatient.ConteneurDeDonnee> {
    private ArrayList<com.example.planetetp5.Donnee> donnees;
    private DetecteurDeClicSurRecycler detecteurDeClicSurRecycler;

    public MonRecyclerViewAdapterPatient(ArrayList<com.example.planetetp5.Donnee> donnees) {
        this.donnees = donnees;
    }

    @Override
    public ConteneurDeDonnee onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_liste_patient, parent, false);
        return new ConteneurDeDonnee(view);
    }

    @Override
    public void onBindViewHolder(ConteneurDeDonnee conteneur, int position) {
        conteneur.nom.setText(donnees.get(position).getPlanete());
        conteneur.prenom.setText(donnees.get(position).getTailles());
        conteneur.pathologie.setText(donnees.get(position).getImages());
    }

    @Override
    public int getItemCount() {
        return donnees.size();
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
