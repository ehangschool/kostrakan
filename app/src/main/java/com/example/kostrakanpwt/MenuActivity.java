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
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.kostrakanpwt.Adapters.RecommendedCardAdapter;
import com.example.kostrakanpwt.Models.RecommendedCardModel;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity implements RecommendedCardAdapter.OnItemClickListener {

    public static final String EXTRA_CATEGORY = "kostCategory";
    public static final String EXTRA_NAME = "kostName";
    public static final String EXTRA_ADDRESS = "kostAddress";
    public static final String EXTRA_PRICE = "kostPrice";

    private RecyclerView recyclerView;
    private RecommendedCardAdapter adapter;
    private ArrayList<RecommendedCardModel> recommendedList;

    private ImageView buttonNav;
    private DrawerLayout mDrawerLayout;
    //    private ListView mDrawerList;
    private NavigationView navigationView;

    private RelativeLayout kostPutra, kostPutri, kostCampur, kontrakan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //biar waktu pindah activity edittext ga ngeluarin keyboard secara otomatis
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);

        initViews();

        kostPutra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, KostPutraActivity.class));
            }
        });
        kostPutri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, KostPutriActivity.class));
            }
        });
        kostCampur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, KostCampurActivity.class));
            }
        });
        kontrakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, KontrakanActivity.class));
            }
        });

        addData();

        buttonNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.START);
            }
        });
        setDrawerContent(navigationView);

        recyclerView = findViewById(R.id.recycler_recommended);
        adapter = new RecommendedCardAdapter(recommendedList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MenuActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(MenuActivity.this);

    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        RecommendedCardModel clickedItem = recommendedList.get(position);

        detailIntent.putExtra(EXTRA_CATEGORY, clickedItem.getCategory());
        detailIntent.putExtra(EXTRA_NAME, clickedItem.getName());
        detailIntent.putExtra(EXTRA_ADDRESS, clickedItem.getDesc());
        detailIntent.putExtra(EXTRA_PRICE, clickedItem.getPrice());

        startActivity(detailIntent);
    }

    private void initViews() {
        buttonNav = (ImageView) findViewById(R.id.nav_button);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        mDrawerList = (ListView) findViewById(R.id.navigation);
        navigationView = (NavigationView) findViewById(R.id.navigation);
        kostPutra = (RelativeLayout) findViewById(R.id.kostPutra);
        kostPutri = (RelativeLayout) findViewById(R.id.kostPutri);
        kostCampur = (RelativeLayout) findViewById(R.id.kostCampur);
        kontrakan = (RelativeLayout) findViewById(R.id.kontrakan);
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
                break;
            case R.id.navFavorit:
                break;
            case R.id.navKosPutra:
                startActivity(new Intent(MenuActivity.this, KostPutraActivity.class));
                break;
            case R.id.navKosPutri:
                startActivity(new Intent(MenuActivity.this, KostPutriActivity.class));
                break;
            case R.id.navKosCampur:
                startActivity(new Intent(MenuActivity.this, KostCampurActivity.class));
                break;
            case R.id.navKontrakan:
                startActivity(new Intent(MenuActivity.this, KontrakanActivity.class));
                break;
            case R.id.navTentangKami:
                break;
        }
        mDrawerLayout.closeDrawers();
    }

    private void addData() {
        recommendedList = new ArrayList<>();
        recommendedList.add(new RecommendedCardModel("KOST PUTRA", "Rp.500.000/bulan", "Kost Beruang", "Jalan DI Pandjaitan Gg Karangbaru no 63,\nPurwokerto Selatan"));
        recommendedList.add(new RecommendedCardModel("KOST WANITA", "Rp.25.000.000/bulan", "Rumah Ehang", "Jalan Overste Isdiman no 20,\nPurwokerto Timur"));
        recommendedList.add(new RecommendedCardModel("KOST CAMPUR", "Rp.1.000.000/bulan", "Kandang Sapi", "Fakultas Peternakan,\nUNSOED"));
        recommendedList.add(new RecommendedCardModel("KONTRAKAN", "Rp.200.000/bulan", "Tujuan Awang", "Tempat yang aman,\nTenggara"));
    }

}
