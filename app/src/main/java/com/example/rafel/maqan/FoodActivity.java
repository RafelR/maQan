package com.example.rafel.maqan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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
        db = database.getInstance().getReference().child("food-items");
        db.keepSynced(true);

        rvCategory = (RecyclerView)findViewById(R.id.rv_category);
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
                viewHolder.setLemak("Lemak : "+model.getLemak());
                viewHolder.setKarbohidrat("Karbohidrat : "+model.getKarbohidrat());
                viewHolder.setProtein("Protein : "+ model.getProtein());
                viewHolder.setJenis(model.getJenis()+" Food");

                viewHolder.btnAdd.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
                    @Override
                    public void onItemClicked(View view, int position) {
                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        if(user!=null) {
                            Calendar c = Calendar.getInstance();
                            SimpleDateFormat df = new SimpleDateFormat("EEEE, dd MMM yyyy");
                            String date = df.format(c.getTime());

                            String userId = user.getUid();

                            String eat = getIntent().getStringExtra(EXTRA_EAT);

                            database = database.getInstance();
                            DatabaseReference ref = database.getReference().child("history").child(userId).child(date).child(eat);
                            ref.child("name").setValue(model.getName());
                            ref.child("jenis").setValue(model.getJenis());
                            ref.child("karbohidrat").setValue(model.getKarbohidrat());
                            ref.child("protein").setValue(model.getProtein());
                            ref.child("lemak").setValue(model.getLemak());

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
