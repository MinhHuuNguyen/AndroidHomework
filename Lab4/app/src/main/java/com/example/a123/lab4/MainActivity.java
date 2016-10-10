package com.example.a123.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
public class MainActivity extends AppCompatActivity {

    private final String[] MENU_LIST = new String[] {"07.02", "08.02", "09.01", "09.02", "09.03"};

    private ArrayList<String> menuArrayList = new ArrayList<>(Arrays.asList(MENU_LIST));

    private ListView lvMenu;
    private ArrayAdapter<String> menuListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getReferences();
        setupUIProperties();
        addListeners();
    }

    private void setupUIProperties() {
        menuListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, menuArrayList);
        lvMenu.setAdapter(menuListAdapter);
    }

    private void getReferences() {
        lvMenu = (ListView) findViewById(R.id.lv_menu);
    }

    private void addListeners() {
        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(MainActivity.this, NewsItemActivity.class);
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(MainActivity.this, NewPaymentActivity.class);
                    startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(MainActivity.this, PaymentSuccessfullActivity.class);
                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(MainActivity.this, Setting1Activity.class);
                    startActivity(intent);
                }
                if (position == 4) {
                    Intent intent = new Intent(MainActivity.this, Setting2Activity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
