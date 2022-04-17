package com.k.arief;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    String[] arrayType = new String[] {"Speed", "Volume"};
    String[] arrayDari = new String[] {"km/h","Liter"};
    String[] arrayKe = new String[] {"mile/h","Mililiter"};
    AutoCompleteTextView type,dari,ke;
    Toolbar toolbar;
    EditText value;
    Button convert;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        type = findViewById(R.id.type);
        ArrayAdapter<String> adapterType = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1, arrayType);
        type.setAdapter(adapterType);

        dari = findViewById(R.id.dari);
        ke = findViewById(R.id.ke);
        convert = findViewById(R.id.convert);
        value = findViewById(R.id.value);
        result = findViewById(R.id.result);

        ArrayAdapter<String> adapterDari = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1, arrayDari);
        dari.setAdapter(adapterDari);

        ArrayAdapter<String> adapterKe = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1, arrayKe);
        ke.setAdapter(adapterKe);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type.getText().toString().equals("Speed") && dari.getText().toString().equals("km/h") && ke.getText().toString().equals("mile/h")){
                    double hasil = Integer.parseInt(value.getText().toString()) * 0.62137;
                    result.setText(value.getText().toString() + " " + dari.getText().toString() + " Sama Dengan " + String.valueOf(hasil) + " " + ke.getText().toString());
                } else if (type.getText().toString().equals("Volume") && dari.getText().toString().equals("Liter") && ke.getText().toString().equals("Mililiter")){
                    int hasil = Integer.parseInt(value.getText().toString()) * 1000;
                    result.setText(value.getText().toString() + " " + dari.getText().toString() + " Sama Dengan " + String.valueOf(hasil) + " " + ke.getText().toString());
                } else {
                    result.setText("Pemilihan tidak valid");
                }
            }
        });
    }
}