package com.example.inchestometers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText inchesEditText;
    private Button calculateButton;
    private TextView metersTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupButtonClickListener();
    }

    private void findViews() {
        inchesEditText = findViewById(R.id.edit_text_inches);
        calculateButton = findViewById(R.id.button_calculate);
        metersTextView = findViewById(R.id.text_view_meters);
    }

    private void setupButtonClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double meters = convertToMeters();
                displayResult(meters);
            }
        });
    }

    private void displayResult(double meters) {
        DecimalFormat decimalFormatter = new DecimalFormat("0.00");
        String metersTextValue = decimalFormatter.format(meters);
        metersTextView.setText(metersTextValue);
    }

    private double convertToMeters() {
        String inchesTextValue = inchesEditText.getText().toString();
        if (inchesTextValue.isEmpty()) {
            Toast.makeText(MainActivity.this,"Field is empty", Toast.LENGTH_LONG);
            return 0;
        } else {
            Integer inches = Integer.parseInt(inchesTextValue);
            return inches * 0.0254;
        }
    }
}