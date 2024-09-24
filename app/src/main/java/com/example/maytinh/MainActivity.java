package com.example.maytinh;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.maytinh.R;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private double firstNumber = 0;
    private double secondNumber = 0;
    private String operator = "";
    private boolean isNewOperation = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        setNumberButtonClickListener(R.id.btn0, "0");
        setNumberButtonClickListener(R.id.btn1, "1");
        setNumberButtonClickListener(R.id.btn2, "2");
        setNumberButtonClickListener(R.id.btn3, "3");
        setNumberButtonClickListener(R.id.btn4, "4");
        setNumberButtonClickListener(R.id.btn5, "5");
        setNumberButtonClickListener(R.id.btn6, "6");
        setNumberButtonClickListener(R.id.btn7, "7");
        setNumberButtonClickListener(R.id.btn8, "8");
        setNumberButtonClickListener(R.id.btn9, "9");

        setOperatorButtonClickListener(R.id.btnAdd, "+");
        setOperatorButtonClickListener(R.id.btnSubtract, "-");
        setOperatorButtonClickListener(R.id.btnMultiply, "*");
        setOperatorButtonClickListener(R.id.btnDivide, "/");

        Button btnEquals = findViewById(R.id.btnEquals);
        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });
    }

    private void setNumberButtonClickListener(int buttonId, final String number) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNewOperation) {
                    display.setText(number);
                    isNewOperation = false;
                } else {
                    display.append(number);
                }
            }
        });
    }

    private void setOperatorButtonClickListener(int buttonId, final String selectedOperator) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Double.parseDouble(display.getText().toString());
                operator = selectedOperator;
                isNewOperation = true;
            }
        });
    }

    private void calculateResult() {
        secondNumber = Double.parseDouble(display.getText().toString());

        double result = 0;
        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    display.setText("Error");
                    return;
                }
                break;
        }

        display.setText(String.valueOf(result));
        isNewOperation = true;
    }
}
