package com.example.rafel.maqan.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.rafel.maqan.model.Food;
import com.example.rafel.maqan.R;


public class HistoryViewHolder extends RecyclerView.ViewHolder {

    private String strKarbohidrat, strLemak, strProtein, strKalori;
    private View view;
    private Food breakfast, lunch, dinner;
    public HistoryViewHolder(View itemView) {
        super(itemView);
        view = itemView;
    }

    public void setTanggal (String tanggal){
        TextView tvTanggal = view.findViewById(R.id.tv_history_tanngal);
        tvTanggal.setText(tanggal);
    }

    public void setBreakfast (Food breakfast){
        TextView tvName = view.findViewById(R.id.tv_name_breakfast);
        tvName.setText(breakfast.getName());

        TextView tvKarbohidrat = view.findViewById(R.id.tv_karbohidrat_breakfast);
        strKarbohidrat = "Karbohidrat : "+Double.toString(breakfast.getKarbohidrat());
        tvKarbohidrat.setText(strKarbohidrat);

        TextView tvLemak = view.findViewById(R.id.tv_lemak_breakfast);
        strLemak = "Lemak : "+Double.toString(breakfast.getLemak());
        tvLemak.setText(strLemak);

        TextView tvProtein = view.findViewById(R.id.tv_protein_breakfast);
        strProtein = "Protein : "+Double.toString(breakfast.getProtein());
        tvProtein.setText(strProtein);

        TextView tvKalori = view.findViewById(R.id.tv_kalori_breakfast);
        strKalori = "Kalori : "+Double.toString(breakfast.getKalori());
        tvKalori.setText(strKalori);

        this.breakfast = breakfast;
    }



    public void setLunch (Food lunch){
        TextView tvName = view.findViewById(R.id.tv_name_lunch);
        tvName.setText(lunch.getName());

        TextView tvKarbohidrat = view.findViewById(R.id.tv_karbohidrat_lunch);
        strKarbohidrat = "Karbohidrat : "+Double.toString(lunch.getKarbohidrat());
        tvKarbohidrat.setText(strKarbohidrat);

        TextView tvLemak = view.findViewById(R.id.tv_lemak_lunch);
        strLemak = "Lemak : "+Double.toString(lunch.getLemak());
        tvLemak.setText(strLemak);

        TextView tvProtein = view.findViewById(R.id.tv_protein_lunch);
        strProtein = "Protein : "+Double.toString(lunch.getProtein());
        tvProtein.setText(strProtein);

        TextView tvKalori = view.findViewById(R.id.tv_kalori_lunch);
        strKalori = "Kalori : "+Double.toString(lunch.getKalori());
        tvKalori.setText(strKalori);

        this.lunch = lunch;
    }

    public void setDinner (Food dinner){
        TextView tvName = view.findViewById(R.id.tv_name_dinner);
        tvName.setText(dinner.getName());

        TextView tvKarbohidrat = view.findViewById(R.id.tv_karbohidrat_dinner);
        strKarbohidrat = "Karbohidrat : "+Double.toString(dinner.getKarbohidrat());
        tvKarbohidrat.setText(strKarbohidrat);

        TextView tvLemak = view.findViewById(R.id.tv_lemak_dinner);
        strLemak = "Lemak : "+Double.toString(dinner.getLemak());
        tvLemak.setText(strLemak);

        TextView tvProtein = view.findViewById(R.id.tv_protein_dinner);
        strProtein = "Protein : "+Double.toString(dinner.getProtein());
        tvProtein.setText(strProtein);

        TextView tvKalori = view.findViewById(R.id.tv_kalori_dinner);
        strKalori = "Kalori : "+Double.toString(dinner.getKalori());
        tvKalori.setText(strKalori);

        this.dinner = dinner;
    }

    public void HitungTotal (){
        TextView tvKarbohidrat = view.findViewById(R.id.tv_karbohidrat_total);
        strKarbohidrat = "Karbohidrat : "+Double.toString(breakfast.getKarbohidrat()+lunch.getKarbohidrat()+dinner.getKarbohidrat());
        tvKarbohidrat.setText(strKarbohidrat);

        TextView tvLemak = view.findViewById(R.id.tv_lemak_total);
        strLemak = "Lemak : "+Double.toString(breakfast.getLemak()+lunch.getLemak()+dinner.getLemak());
        tvLemak.setText(strLemak);

        TextView tvProtein = view.findViewById(R.id.tv_protein_total);
        strProtein = "Protein : "+Double.toString(breakfast.getProtein()+lunch.getProtein()+dinner.getProtein());
        tvProtein.setText(strProtein);

        TextView tvKalori = view.findViewById(R.id.tv_kalori_total);
        strKalori = "Kalori : "+Double.toString(breakfast.getKalori()+lunch.getKalori()+dinner.getKalori());
        tvKalori.setText(strKalori);
    }


}
