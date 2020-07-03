package com.example.grocerylog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OptionsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        int id = view.getId();
        switch (id){
            case R.id.nonveg:
                intent = new Intent(OptionsActivity.this,Non_VegActivity.class);
                break;
            case R.id.veg:
                break;
            case R.id.fruits:
                break;
            case R.id.snacks:
                break;
            case R.id.masalla:
                break;
            case R.id.homecare:
                break;
            case R.id.personalcare:
                break;
        }
    }
}