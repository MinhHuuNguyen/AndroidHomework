package com.example.minh.contact;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactDetailFragment extends Fragment {

    private Contact contact;
    private TextView tvName;
    private TextView tvMobile;
    private TextView tvWebsite;

    public ContactDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_contact_detail, container, false);
        getReferences(view);
        setupUI();
        addListeners();
        return view;
    }

    private void addListeners() {
        tvWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(contact.getWebsite()));
                startActivity(intent);
            }
        });
        tvMobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + contact.getMobile()));
                startActivity(intent);
            }
        });
    }

    private void setupUI() {
        tvName.setText(contact.getName());
        tvMobile.setText(contact.getMobile());
        tvWebsite.setText(contact.getWebsite());
    }

    private void getReferences(View view) {
        tvName = (TextView) view.findViewById(R.id.tv_name);
        tvMobile = (TextView) view.findViewById(R.id.tv_mobile);
        tvWebsite = (TextView) view.findViewById(R.id.tv_website);
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}

