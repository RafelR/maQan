package com.example.rafel.maqan.ui.viewholder;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rafel.maqan.R;
import com.squareup.picasso.Picasso;

public class FoodViewHolder extends RecyclerView.ViewHolder {

    View view;
    public Button btnAdd;
    public FoodViewHolder(View itemView) {
        super(itemView);
        view = itemView;
        btnAdd = itemView.findViewById(R.id.btn_add);

    }
    public void setImage(Context context, String image){
        ImageView imageView = view.findViewById(R.id.img_item_photo);
        Picasso.with(context).load(image).into(imageView);
    }
    public void setName (String name){
        TextView tvName = view.findViewById(R.id.tv_name);
        tvName.setText(name);
    }
    public void setKarbohidrat (double karbohidrat){
        TextView tvName = view.findViewById(R.id.tv_karbohidrat);
        String strKarbohidrat = "Karbohidrat : "+Double.toString(karbohidrat);
        tvName.setText(strKarbohidrat);
    }
    public void setLemak (double lemak){
        TextView tvName = view.findViewById(R.id.tv_lemak);
        String strLemak = "Lemak : "+Double.toString(lemak);
        tvName.setText(strLemak);
    }
    public void setProtein (double protein){
        TextView tvName = view.findViewById(R.id.tv_protein);
        String strProtein = "Protein : "+Double.toString(protein);
        tvName.setText(strProtein);
    }

    public void setKalori (double kalori){
        TextView tvName = view.findViewById(R.id.tv_kalori);
        String strKalori = "Kalori : "+Double.toString(kalori);
        tvName.setText(strKalori);
    }

    public void setJenis (String jenis){
        TextView tvName = view.findViewById(R.id.tv_jenis);
        tvName.setText(jenis);
    }
}