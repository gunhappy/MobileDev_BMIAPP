package com.example.gun.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText height_editText = findViewById(R.id.input_height);
        final EditText weight_editText = findViewById(R.id.input_weight);
        Button calculate_btn = findViewById(R.id.calculate_btn);
        final TextView result_text = findViewById(R.id.result_text);
        final ImageView bmi_image = findViewById(R.id.result_image);

        calculate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int height = Integer.parseInt(height_editText.getText().toString());
                int weight = Integer.parseInt(weight_editText.getText().toString());
                double result = weight/Math.pow(height*0.01,2);
                String text = "";
                if(result<18.5) {
                    bmi_image.setImageResource(R.drawable.underweight);
                    text = "underweight";
                } else if(result<23) {
                    bmi_image.setImageResource(R.drawable.healthy);
                    text = "healthy";
                } else if(result<27.5) {
                    bmi_image.setImageResource(R.drawable.overweight);
                    text = "overweight";
                } else {
                    bmi_image.setImageResource(R.drawable.obese);
                    text = "obese";
                }
                result_text.setText(String.format("%s : Your BMI is %.2f",text,result));
                bmi_image.setVisibility(View.VISIBLE);
            }
        });
    }
}
