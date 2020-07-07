package com.example.grocerylog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OptionsActivity extends AppCompatActivity implements View.OnClickListener {

    TextView N;
    TextView V;
    TextView S;
    TextView M;
    TextView F;
    TextView H;
    TextView P;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        N = findViewById(R.id.nonveg);
        V = findViewById(R.id.veg);
        M = findViewById(R.id.masalla);
        S = findViewById(R.id.snacks);
        F = findViewById(R.id.fruits);
        H = findViewById(R.id.homecare);
        P = findViewById(R.id.personalcare);
        N.setOnClickListener(this);
        V.setOnClickListener(this);
        M.setOnClickListener(this);
        S.setOnClickListener(this);
        F.setOnClickListener(this);
        H.setOnClickListener(this);
        P.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        int id = view.getId();
        switch (id){
            case R.id.nonveg:
                intent = new Intent(OptionsActivity.this,Non_VegActivity.class);
                startActivity(intent);
                break;
            case R.id.veg:
                intent = new Intent(OptionsActivity.this,VegetablesActivity.class);
                startActivity(intent);
                break;
            case R.id.fruits:
                intent = new Intent(OptionsActivity.this,FruitsActivity.class);
                startActivity(intent);
                break;
            case R.id.snacks:
                intent = new Intent(OptionsActivity.this,SnacksActivity.class);
                startActivity(intent);
                break;
            case R.id.masalla:
                intent = new Intent(OptionsActivity.this,MasallaActivity.class);
                startActivity(intent);
                break;
            case R.id.homecare:
                intent = new Intent(OptionsActivity.this,Home_CareActivity.class);
                startActivity(intent);
                break;
            case R.id.personalcare:
                intent = new Intent(OptionsActivity.this,Personal_CareActivity.class);
                startActivity(intent);
                break;
        }
    }
}