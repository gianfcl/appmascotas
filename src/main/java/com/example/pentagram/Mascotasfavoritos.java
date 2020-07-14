package com.example.pentagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Mascotasfavoritos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotasfavoritos);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);

        View rlstar = miActionBar.findViewById(R.id.rlestrella);
        rlstar.setVisibility(View.GONE);

        View nombarra = miActionBar.findViewById(R.id.nombrebarra);
        TextView nombreb = (TextView) nombarra;
        nombreb.setText(getResources().getString(R.string.app_favoritos));
        //nombarra.setAutofillHints(getResources().getString(R.string.app_favoritos));

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}