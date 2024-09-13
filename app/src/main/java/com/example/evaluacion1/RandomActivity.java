package com.example.evaluacion1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class RandomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        EditText editTextRangoMenor = findViewById(R.id.editTextRangoMenor);
        EditText editTextRangoMayor = findViewById(R.id.editTextRangoMayor);
        Button buttonSortear = findViewById(R.id.buttonSortear);
        TextView textViewResultadoRandom = findViewById(R.id.textViewResultadoRandom);

        buttonSortear.setOnClickListener(v -> {
            String menorStr = editTextRangoMenor.getText().toString();
            String mayorStr = editTextRangoMayor.getText().toString();

            if (!menorStr.isEmpty() && !mayorStr.isEmpty()) {
                int menor = Integer.parseInt(menorStr);
                int mayor = Integer.parseInt(mayorStr);

                if (menor < mayor) {
                    Random random = new Random();
                    int resultado = random.nextInt((mayor - menor) + 1) + menor;
                    textViewResultadoRandom.setText(String.valueOf(resultado));
                }
            }
        });
    }
}
