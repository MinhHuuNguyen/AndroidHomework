package com.example.minh.testbmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etWeight;
    private EditText etHeight;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLayoutReference();
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float weight = Float.parseFloat(etWeight.getText().toString());
                float height = Float.parseFloat(etHeight.getText().toString());
                height /= 100;
                float ibm = weight / (height * height);
                tvResult.setText(result(ibm));
            }
        });
    }
    String result(float ibm){
        String result;
        if (ibm < 16){
            result = " Suy dinh duong";
        }else if (ibm < 18.5){
            result = " Thieu can";
        }else if (ibm < 25){
            result = " Binh thuong";
        }else if (ibm < 30){
            result = " Thua can";
        }else {
            result = " Beo phi";
        }
        return result;
    }
    void getLayoutReference(){
        etWeight = (EditText) findViewById(R.id.et_weight);
        etHeight = (EditText) findViewById(R.id.et_height);
        btnCalculate = (Button) findViewById(R.id.btn_calculate);
        tvResult = (TextView) findViewById(R.id.tv_result);
    }
}
