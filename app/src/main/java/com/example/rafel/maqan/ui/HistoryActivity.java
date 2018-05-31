package com.example.rafel.maqan.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rafel.maqan.helper.FirebaseHelper;
import com.example.rafel.maqan.model.History;
import com.example.rafel.maqan.ui.viewholder.HistoryViewHolder;
import com.example.rafel.maqan.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class HistoryActivity extends AppCompatActivity {

    RecyclerView rvHistory;
    private DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        setTitle("History");

        FirebaseHelper helper = new FirebaseHelper();
        helper.setUser();
        helper.setUserId();

        db = FirebaseDatabase.getInstance().getReference().child("history").child(helper.getUserId());
        db.keepSynced(true);

        rvHistory = (RecyclerView)findViewById(R.id.rv_history);
        rvHistory.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(true);
        rvHistory.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<History,HistoryViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<History, HistoryViewHolder>
                (History.class,R.layout.item_cardview_history,HistoryViewHolder.class,db) {
            @Override
            protected void populateViewHolder(HistoryViewHolder viewHolder, History model, int position) {
                viewHolder.setTanggal(model.getTanggal());
                viewHolder.setBreakfast(model.getBreakfast());
                viewHolder.setLunch(model.getLunch());
                viewHolder.setDinner(model.getDinner());
                viewHolder.HitungTotal();
            }
        };
        rvHistory.setAdapter(firebaseRecyclerAdapter);

    }
}
