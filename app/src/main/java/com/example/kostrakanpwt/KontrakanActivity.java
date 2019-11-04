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
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.kostrakanpwt.Adapters.KontrakanCardAdapter;
import com.example.kostrakanpwt.Adapters.PutraCardAdapter;
import com.example.kostrakanpwt.Models.KontrakanCardModel;
import com.example.kostrakanpwt.Models.PutraCardModel;

import java.util.ArrayList;

public class KontrakanActivity extends AppCompatActivity implements KontrakanCardAdapter.OnItemClickListener {

    public static final String EXTRA_CATEGORY = "kostCategory";
    public static final String EXTRA_NAME = "kostName";
    public static final String EXTRA_ADDRESS = "kostAddress";
    public static final String EXTRA_PRICE = "kostPrice";

    private ImageView buttonNav;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private RecyclerView recyclerView;
    private KontrakanCardAdapter adapter;
    private ArrayList<KontrakanCardModel> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontrakan);

        buttonNav = (ImageView) findViewById(R.id.nav_button);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation);

        addData();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_kontrakan);
        adapter = new KontrakanCardAdapter(dataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(KontrakanActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(KontrakanActivity.this);

        buttonNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.START);
            }
        });
        setDrawerContent(navigationView);

    }

    private void addData() {
        dataList = new ArrayList<>();
        dataList.add(new KontrakanCardModel("KONTRAKAN", "Rp.5.000.000/bulan", "Rumah 2 Kamar", "Jalan DI Pandjaitan Gg Karangbaru no 63,\nPurwokerto Selatan"));
        dataList.add(new KontrakanCardModel("KONTRAKAN", "Rp.25.000.000/bulan", "Rumah 6 Kamar", "Jalan Overste Isdiman no 20,\nPurwokerto Timur"));
        dataList.add(new KontrakanCardModel("KONTRAKAN", "Rp.1.000.000/bulan", "Rumah 5x5", "Fakultas Peternakan,\nUNSOED"));
        dataList.add(new KontrakanCardModel("KONTRAKAN", "Rp.2.000.000/bulan", "Rumah 1 Kamar", "Tempat yang aman,\nTenggara"));
    }

    private void setDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                setDrawerItem(menuItem);
                return true;
            }
        });
    }

    private void setDrawerItem(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navBeranda:
                startActivity(new Intent(KontrakanActivity.this, MenuActivity.class));
                break;
            case R.id.navFavorit:
                break;
            case R.id.navKosPutra:
                startActivity(new Intent(KontrakanActivity.this, KostPutraActivity.class));
                break;
            case R.id.navKosPutri:
                startActivity(new Intent(KontrakanActivity.this, KostPutriActivity.class));
                break;
            case R.id.navKosCampur:
                startActivity(new Intent(KontrakanActivity.this, KostCampurActivity.class));
                break;
            case R.id.navKontrakan:
                break;
            case R.id.navTentangKami:
                break;
        }
        drawerLayout.closeDrawers();
    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        KontrakanCardModel clickedItem = dataList.get(position);

        detailIntent.putExtra(EXTRA_CATEGORY, clickedItem.getCategory());
        detailIntent.putExtra(EXTRA_NAME, clickedItem.getName());
        detailIntent.putExtra(EXTRA_ADDRESS, clickedItem.getDesc());
        detailIntent.putExtra(EXTRA_PRICE, clickedItem.getPrice());

        startActivity(detailIntent);
    }
}
