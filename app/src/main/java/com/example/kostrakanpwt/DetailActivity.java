package com.example.kostrakanpwt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static com.example.kostrakanpwt.MenuActivity.EXTRA_ADDRESS;
import static com.example.kostrakanpwt.MenuActivity.EXTRA_CATEGORY;
import static com.example.kostrakanpwt.MenuActivity.EXTRA_NAME;
import static com.example.kostrakanpwt.MenuActivity.EXTRA_PRICE;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getContent();

        LinearLayout buttonDirection = findViewById(R.id.detail_direction);
        LinearLayout buttonWhatsapp = findViewById(R.id.detail_whatsapp);


        buttonDirection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailActivity.this, "Menunjukkan Arah Via Google Maps", Toast.LENGTH_SHORT).show();
            }
        });
        buttonWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailActivity.this, "Menghubungi Via Whatsapp", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getContent() {
        Intent intent = getIntent();
        String kostCategory = intent.getStringExtra(EXTRA_CATEGORY);
        String kostName = intent.getStringExtra(EXTRA_NAME);
        String kostAddress = intent.getStringExtra(EXTRA_ADDRESS);
        String kostPrice = intent.getStringExtra(EXTRA_PRICE);

        TextView textViewCategory = findViewById(R.id.detail_category);
        TextView textViewName = findViewById(R.id.detail_name);
        TextView textViewPrice = findViewById(R.id.detail_price);
        TextView textViewAddress = findViewById(R.id.detail_address);

        textViewCategory.setText(kostCategory);
        textViewName.setText(kostName);
        textViewPrice.setText(kostPrice);
        textViewAddress.setText(kostAddress);
    }
}
