package com.example.planetetp5;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedHashMap;


public class MonRecyclerViewAdapterActivite extends RecyclerView.Adapter<com.example.planetetp5.MonRecyclerViewAdapterActivite.ConteneurDeDonnee> {
    private Context context;
    private ArrayList<LinkedHashMap<String, String>> activites;

    public MonRecyclerViewAdapterActivite(Context context, ArrayList<LinkedHashMap<String, String>> activites) {
        this.context = context;
        this.activites = activites;
    }

    @Override
    public ConteneurDeDonnee onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_liste_activite, parent, false);
        return new ConteneurDeDonnee(view);
    }

    @Override
    public void onBindViewHolder(ConteneurDeDonnee conteneur, int position) {
        conteneur.titre.setText(activites.get(position).get("titre"));
        conteneur.duree.setText(activites.get(position).get("duree") + " " + context.getString(R.string.heures));
    }

    @Override
    public int getItemCount() {
        return activites.size();
    }

    public void setDetecteurDeClicSurRecycler(DetecteurDeClicSurRecycler detecteurDeClicSurRecycler) {
        ConteneurDeDonnee.detecteurDeClicSurRecycler = detecteurDeClicSurRecycler;
    }

    public static class ConteneurDeDonnee extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titre;
        TextView duree;
        private static DetecteurDeClicSurRecycler detecteurDeClicSurRecycler;

        public ConteneurDeDonnee(View itemView) {
            super(itemView);
            titre = (TextView) itemView.findViewById(R.id.activite_titre);
            duree = (TextView) itemView.findViewById(R.id.activite_duree);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            ((CardView)v).setCardBackgroundColor(Color.rgb(175,238,238));
            detecteurDeClicSurRecycler.clicSurRecyclerItem(getAdapterPosition(), v);
        }

    }



}
