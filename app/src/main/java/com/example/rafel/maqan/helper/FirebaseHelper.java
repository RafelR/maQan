package com.example.rafel.maqan.helper;

import com.example.rafel.maqan.model.Food;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseHelper {

    public FirebaseUser getUser() {
        return user;
    }

    public void setUser() {
        this.user = FirebaseAuth.getInstance().getCurrentUser();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId() {
        this.userId = user.getUid();
    }

    private FirebaseUser user;
    private String userId;
    private FirebaseDatabase database;

    public void AddEat(Food food, String date, String key, String eat){
        database = database.getInstance();
        DatabaseReference refDate = database.getReference().child("history").child(userId).child(key);
        DatabaseReference ref = database.getReference().child("history").child(userId).child(key).child(eat);
        refDate.child("tanggal").setValue(date);
        ref.child("name").setValue(food.getName());
        ref.child("jenis").setValue(food.getJenis());
        ref.child("karbohidrat").setValue(food.getKarbohidrat());
        ref.child("protein").setValue(food.getProtein());
        ref.child("lemak").setValue(food.getLemak());
        ref.child("kalori").setValue(food.getKalori());
        ref.child("image").setValue(food.getImage());
    }

    public void AddUser(String name, String username){
        database = database.getInstance();
        DatabaseReference ref = database.getReference().child("users").child(userId);
        ref.child("Name").setValue(name);
        ref.child("E-mail").setValue(username);
    }
}
