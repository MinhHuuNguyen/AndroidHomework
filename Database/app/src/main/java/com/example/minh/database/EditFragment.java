package com.example.minh.database;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class EditFragment extends Fragment {

    @BindView(R.id.btn_save)
    Button btnSave;

    @BindView(R.id.edt_title1)
    EditText edtTitle;
    @BindView(R.id.edt_content1)
    EditText edtContent;
    @BindView(R.id.edt_date1)
    EditText edtDate;


    public EditFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false);
    }

    private void setupUI() {
        Note tempNote = ((MainActivity) getActivity()).getNote();
        edtTitle.setText(tempNote.getTitle());
        edtContent.setText(tempNote.getContent());
        edtDate.setText(tempNote.getDate());
    }


    private void addListeners() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Note note = new Note(((MainActivity) getActivity()).getNote().getId(), edtTitle.getText().toString(), edtContent.getText().toString(), edtDate.getText().toString());
                DbHelper.getInstance().update(note);
                ((MainActivity) getActivity()).reset();
                getFragmentManager().popBackStack();
            }
        });

    }
}
