package com.example.kostrakanpwt;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.kostrakanpwt.Adapters.PutriCardAdapter;
import com.example.kostrakanpwt.Models.PutriCardModel;

import java.util.ArrayList;

public class KostPutriActivity extends AppCompatActivity implements PutriCardAdapter.OnItemClickListener {

    public static final String EXTRA_CATEGORY = "kostCategory";
    public static final String EXTRA_NAME = "kostName";
    public static final String EXTRA_ADDRESS = "kostAddress";
    public static final String EXTRA_PRICE = "kostPrice";

    private ImageView navButton;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private RecyclerView recyclerView;
    private PutriCardAdapter adapter;
    private ArrayList<PutriCardModel> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kost_putri);

        navButton = (ImageView) findViewById(R.id.nav_button);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation);

        addData();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_kosPutri);
        adapter = new PutriCardAdapter(dataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(KostPutriActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(KostPutriActivity.this);

        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.START);
            }
        });
        setDrawerContent(navigationView);

    }

    private void addData() {
        dataList = new ArrayList<>();
        dataList.add(new PutriCardModel("KOST PUTRI","Rp. 8.000.000,-","Teratai","Sebelah Lensa"));
        dataList.add(new PutriCardModel("KOST PUTRI","Rp. 8.000.000,-","Teratai","Sebelah Lensa"));
        dataList.add(new PutriCardModel("KOST PUTRI","Rp. 8.000.000,-","Teratai","Sebelah Lensa"));
        dataList.add(new PutriCardModel("KOST PUTRI","Rp. 8.000.000,-","Teratai","Sebelah Lensa"));
        dataList.add(new PutriCardModel("KOST PUTRI","Rp. 8.000.000,-","Teratai","Sebelah Lensa"));
    }

    private void setDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        setDrawerItem(menuItem);
                        return true;
                    }
                }
        );
    }

    private void setDrawerItem(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navBeranda:
                Intent intent = new Intent(KostPutriActivity.this, MenuActivity.class);
                startActivity(intent);
                break;
            case R.id.navFavorit:
                break;
            case R.id.navKosPutra:
                startActivity(new Intent(KostPutriActivity.this, KostPutraActivity.class));
                break;
            case R.id.navKosPutri:
                break;
            case R.id.navKosCampur:
                startActivity(new Intent(KostPutriActivity.this, KostCampurActivity.class));
                break;
            case R.id.navKontrakan:
                startActivity(new Intent(KostPutriActivity.this, KontrakanActivity.class));
                break;
            case R.id.navTentangKami:
                break;
        }
        drawerLayout.closeDrawers();
    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        PutriCardModel clickedItem = dataList.get(position);

        detailIntent.putExtra(EXTRA_CATEGORY, clickedItem.getCategory());
        detailIntent.putExtra(EXTRA_NAME, clickedItem.getName());
        detailIntent.putExtra(EXTRA_ADDRESS, clickedItem.getDesc());
        detailIntent.putExtra(EXTRA_PRICE, clickedItem.getPrice());

        startActivity(detailIntent);
    }
}

