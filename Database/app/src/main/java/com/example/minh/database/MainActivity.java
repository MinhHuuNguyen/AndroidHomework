package com.example.minh.database;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    @BindView(R.id.rv_note)
    public RecyclerView rvNote;

    @BindView(R.id.btn_add)
    public Button btnAdd;

    private NoteAdapter noteAdapter;
    private List<Note> noteList;
    public static int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
        addListeners();
    }

    private void setupUI() {
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, 1);
        rvNote.setLayoutManager(layoutManager);
        noteAdapter = new NoteAdapter();
        rvNote.setAdapter(noteAdapter);

    }

    private void addListeners() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(new AddFragment(), true);
            }
        });

        rvNote.addOnItemTouchListener(new RecyclerItemClickListener(this, rvNote, new RecyclerItemClickListener.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {
                pos = position;
                changeFragment(new EditFragment(), true);
            }

            @Override
            public void onLongItemClick(View view, int position) {
                DbHelper.getInstance().delete(noteList.get(position));
                noteList = DbHelper.getInstance().selectAll();
                noteAdapter.notifyDataSetChanged();
                Log.d(TAG, "Long Click");
            }
        }));
    }

    private void changeFragment(Fragment fragment, Boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_main, fragment);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }
}
