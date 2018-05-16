package com.example.rafel.maqan;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class FoodViewHolder extends RecyclerView.ViewHolder {

    View view;
    Button btnAdd;
    public FoodViewHolder(View itemView) {
        super(itemView);
        view = itemView;
        btnAdd = (Button)itemView.findViewById(R.id.btn_add);

    }
    public void setImage(Context context, String image){
        ImageView imageView = (ImageView)view.findViewById(R.id.img_item_photo);
        Picasso.with(context).load(image).into(imageView);
    }
    public void setName (String name){
        TextView tvName = (TextView)view.findViewById(R.id.tv_name);
        tvName.setText(name);
    }
    public void setKarbohidrat (String karbohidrat){
        TextView tvName = (TextView)view.findViewById(R.id.tv_karbohidrat);
        tvName.setText(karbohidrat);
    }
    public void setLemak (String lemak){
        TextView tvName = (TextView)view.findViewById(R.id.tv_lemak);
        tvName.setText(lemak);
    }
    public void setProtein (String protein){
        TextView tvName = (TextView)view.findViewById(R.id.tv_protein);
        tvName.setText(protein);
    }
    public void setJenis (String jenis){
        TextView tvName = (TextView)view.findViewById(R.id.tv_jenis);
        tvName.setText(jenis);
    }
}