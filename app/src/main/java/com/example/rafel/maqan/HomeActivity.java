package com.example.rafel.maqan;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    Button btnBreakfast, btnLunch, btnDinner;
    FirebaseAuth firebaseAuth;
    TextView tvTanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        onNavigationDrawerPressed();
        setDate();

        btnBreakfast = (Button) findViewById(R.id.btn_breakfast);
        btnLunch = (Button) findViewById(R.id.btn_lunch);
        btnDinner = (Button) findViewById(R.id.btn_dinner);
        btnBreakfast.setOnClickListener(this);
        btnLunch.setOnClickListener(this);
        btnDinner.setOnClickListener(this);
    }

    private void setDate() {
        tvTanggal = (TextView) findViewById(R.id.tv_tanggal);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("EEEE\ndd MMM yyyy");
        String date = df.format(c.getTime());
        tvTanggal.setText(date);
    }

    public void onNavigationDrawerPressed() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_add_food) {
        } else if (id == R.id.nav_history) {

        } else if (id == R.id.nav_logout) {
            firebaseAuth.getInstance().signOut();
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_breakfast:
                Intent intentBreakfast = new Intent(HomeActivity.this, FoodActivity.class);
                intentBreakfast.putExtra(FoodActivity.EXTRA_EAT, "Breakfast");
                startActivity(intentBreakfast);
                break;
            case R.id.btn_lunch:
                Intent intentLunch = new Intent(HomeActivity.this, FoodActivity.class);
                intentLunch.putExtra(FoodActivity.EXTRA_EAT, "Lunch");
                startActivity(intentLunch);
                break;
            case R.id.btn_dinner:
                Intent intentDinner = new Intent(HomeActivity.this, FoodActivity.class);
                intentDinner.putExtra(FoodActivity.EXTRA_EAT, "Dinner");
                startActivity(intentDinner);
                break;
        }
    }
}