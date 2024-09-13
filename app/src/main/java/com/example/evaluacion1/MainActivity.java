package com.example.evaluacion1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonIMC = findViewById(R.id.button_imc);
        Button buttonRandom = findViewById(R.id.button_random);

        buttonIMC.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, IMCActivity.class);
            startActivity(intent);
        });

        buttonRandom.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RandomActivity.class);
            startActivity(intent);
        });
    }
}
