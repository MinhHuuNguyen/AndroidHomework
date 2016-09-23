package com.example.minh.contact;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ContactListActivity extends AppCompatActivity {
    public static final String CONTACT_EXTRA = "Contact";
    private List<Contact> contactList;
    private ListView lvContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        initData();
        getReferences();
        setupUI();
        addListeners();
    }

    private void initData() {
        contactList = Contact.getContactList();
    }

    private void addListeners() {
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact contact = contactList.get(position);
                ContactDetailFragment contactDetailFragment = new ContactDetailFragment();
                contactDetailFragment.setContact(contact);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                if (findViewById(R.id.fl_container) == null){
                    fragmentTransaction.replace(R.id.fl_contact_detail, contactDetailFragment);
                }else{
                    fragmentTransaction.replace(R.id.fl_container, contactDetailFragment);
                }
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

    }

    private void setupUI() {
        ArrayAdapter<Contact> contactAdapter = new ArrayAdapter<Contact>(this, android.R.layout.simple_list_item_1, contactList);
        lvContact.setAdapter(contactAdapter);
    }

    private void getReferences() {
        lvContact = (ListView) findViewById(R.id.lv_contact);
    }
}
