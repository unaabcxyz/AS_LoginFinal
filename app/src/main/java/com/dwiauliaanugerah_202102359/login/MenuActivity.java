package com.dwiauliaanugerah_202102359.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity 
{
    public static final String CALL_ID = "call_id";
    private Button _tampilMahasiswaButton, _tampilForexButton, _tampilCuacaButton, _tampilImplicitButton;
    private Intent _tampilMahasiswaIntent, _tampilForexIntent, _tampilCuacaIntent, _tampilImplicitIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        String name = getIntent().getStringExtra(CALL_ID);
        setTitle("Menu - " + name);

        setContentView(R.layout.activity_menu);
        initTampilMahasiswaButton();
        initTampilForexButton();
        initTampilCuacaButton();
        initTampilImplicitButton();
    }

    private void initTampilImplicitButton() {
        _tampilImplicitButton = findViewById(R.id.tampilImplicitButton);

        _tampilImplicitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _tampilImplicitIntent = new Intent(getApplicationContext(), ImplicitIntentMainActivity.class);
                startActivity(_tampilImplicitIntent);
            }
        });
    }

    private void initTampilCuacaButton()
    {
        _tampilCuacaButton = findViewById(R.id.tampilCuacaButton);

        _tampilCuacaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _tampilCuacaIntent = new Intent(getApplicationContext(), CuacaMainActivity.class);
                startActivity(_tampilCuacaIntent);
            }
        });
    }

    private void initTampilForexButton()
    {
        _tampilForexButton = (Button) findViewById(R.id.tampilForexButton);
        _tampilForexButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                _tampilForexIntent = new  Intent(getApplicationContext(), ForexMainActivity.class);
                startActivity(_tampilForexIntent);
            }
        });

    }

    private void initTampilMahasiswaButton()
    {
        _tampilMahasiswaButton = (Button) findViewById(R.id.tampilMahasiswaButton);

        _tampilMahasiswaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _tampilMahasiswaIntent = new Intent(getApplicationContext(), TampilMahasiswaActivity.class);
                startActivity(_tampilMahasiswaIntent);
            }
        });
    }
}