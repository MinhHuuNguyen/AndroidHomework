package com.example.a123.lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PaymentSuccessfullActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_payment_successfull);
    }
}
