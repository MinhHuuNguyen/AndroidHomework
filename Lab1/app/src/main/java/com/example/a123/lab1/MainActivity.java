package com.example.a123.lab1;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);
        btnAddToCart = (Button) findViewById(R.id.btn_add_to_cart);
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                BlankFragment blankFragment = new BlankFragment();
//                blankFragment.show(fragmentManager, "fragment_edit_name");
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                BlankFragment blankFragment = new BlankFragment();

                fragmentTransaction.replace(R.id.frame_layout, blankFragment);

                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
            }
        });
    }
}
