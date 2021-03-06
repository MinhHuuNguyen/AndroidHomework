package com.example.minh.dailyquote.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.minh.dailyquote.Managers.Preferences;
import com.example.minh.dailyquote.Models.FragmentEvent;
import com.example.minh.dailyquote.R;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    @BindView(R.id.et_username)
    EditText edtUserName;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);

        return view;
    }
    @OnClick(R.id.btn_save)
    public void onClick(View view){
        String username = edtUserName.getText().toString();
        Preferences.getInstance().putUsername(username);
        EventBus.getDefault().post(new FragmentEvent(new QuoteFragment(), false));
    }

}
