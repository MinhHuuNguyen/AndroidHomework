package com.example.minh.database;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment {

    @BindView(R.id.btn_add1)
    Button btnAdd;

    @BindView(R.id.edt_title)
    EditText edtTitle;
    @BindView(R.id.edt_content)
    EditText edtContent;
    @BindView(R.id.edt_date)
    EditText edtDate;

    public AddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add, container, false);
        ButterKnife.bind(this, v);
        addListeners();
        return v;
    }

    private void addListeners() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Note note = new Note(
                        edtTitle.getText().toString(),
                        edtContent.getText().toString(),
                        edtDate.getText().toString()
                );
                DBHepler.getInstance().insert(tempNote);
                ListModel.list.add(new ListModel(tempNote.getTitle()));
                ((MainActivity)getActivity()).notifiDataSetchange();
                ((MainActivity)getActivity()).reset();

                getFragmentManager().popBackStack();
            }
        });
    }

}