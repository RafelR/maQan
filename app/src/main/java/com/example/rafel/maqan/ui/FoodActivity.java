package com.example.rafel.maqan.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.rafel.maqan.helper.FirebaseHelper;
import com.example.rafel.maqan.util.CustomOnItemClickListener;
import com.example.rafel.maqan.model.Food;
import com.example.rafel.maqan.R;
import com.example.rafel.maqan.ui.viewholder.FoodViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FoodActivity extends AppCompatActivity {

    private RecyclerView rvCategory;
    private FirebaseDatabase database;
    private DatabaseReference db;
    public static String EXTRA_EAT = "Makan";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        String eat = getIntent().getStringExtra(EXTRA_EAT);
        setTitle(eat);

        FirebaseHelper helper = new FirebaseHelper();
        db = database.getInstance().getReference().child("food-items");
        db.keepSynced(true);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        rvCategory.setLayoutManager(new GridLayoutManager(this,2));
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Food,FoodViewHolder>firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Food, FoodViewHolder>
                (Food.class,R.layout.item_cardview_food,FoodViewHolder.class,db) {
            @Override
            protected void populateViewHolder(FoodViewHolder viewHolder, final Food model, int position) {
                viewHolder.setImage(getApplicationContext(),model.getImage());
                viewHolder.setName(model.getName());
                viewHolder.setLemak(model.getLemak());
                viewHolder.setKarbohidrat(model.getKarbohidrat());
                viewHolder.setProtein(model.getProtein());
                viewHolder.setKalori(model.getKalori());
                viewHolder.setJenis(model.getJenis()+" Food");

                viewHolder.btnAdd.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
                    @Override
                    public void onItemClicked(View view, int position) {
                        FirebaseHelper helper = new FirebaseHelper();
                        helper.setUser();

                        if(helper.getUser()!=null) {
                            helper.setUserId();

                            Calendar c = Calendar.getInstance();
                            SimpleDateFormat df = new SimpleDateFormat("EEEE, dd MMM yyyy");
                            String date = df.format(c.getTime());

                            SimpleDateFormat df2 = new SimpleDateFormat("ddMMyyyy");
                            String key = df2.format(c.getTime());

                            String eat = getIntent().getStringExtra(EXTRA_EAT);

                            helper.AddEat(model, date, key, eat);
                            Toast.makeText(FoodActivity.this,"Success updating food",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(FoodActivity.this,"Please login first. :)",Toast.LENGTH_SHORT).show();
                        }
                    }
                }));
            }
        };
        rvCategory.setAdapter(firebaseRecyclerAdapter);
    }
}
