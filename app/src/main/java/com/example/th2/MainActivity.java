package com.example.th2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.th2.R;

public class MainActivity extends AppCompatActivity {

    EditText etFahrenheit, etCelsius;
    Button btnToCelsius, btnToFahrenheit, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFahrenheit = findViewById(R.id.et_fahrenheit);
        etCelsius = findViewById(R.id.et_celsius);
        btnToCelsius = findViewById(R.id.btn_toCelsius);
        btnToFahrenheit = findViewById(R.id.btn_toFahrenheit);
        btnClear = findViewById(R.id.btn_clear);

        // Convert Fahrenheit to Celsius
        btnToCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etFahrenheit.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập Fahrenheit", Toast.LENGTH_SHORT).show();
                    return;
                }
                double fahrenheit = Double.parseDouble(etFahrenheit.getText().toString());
                double celsius = (fahrenheit - 32) * 5 / 9;
                etCelsius.setText(String.format("%.2f", celsius));
            }
        });

        // Convert Celsius to Fahrenheit
        btnToFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etCelsius.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập Celsius", Toast.LENGTH_SHORT).show();
                    return;
                }
                double celsius = Double.parseDouble(etCelsius.getText().toString());
                double fahrenheit = (celsius * 9 / 5) + 32;
                etFahrenheit.setText(String.format("%.2f", fahrenheit));
            }
        });

        // Clear all inputs
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etFahrenheit.setText("");
                etCelsius.setText("");
            }
        });
    }
}
