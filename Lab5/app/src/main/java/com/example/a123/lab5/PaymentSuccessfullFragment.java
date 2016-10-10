package com.example.a123.lab5;


import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentSuccessfullFragment extends Fragment {

    private static final String TAG = PaymentSuccessfullFragment.class.toString();
    private Button btnSuccessful;

    public PaymentSuccessfullFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment_successful, container, false);
        btnSuccessful = (Button) view.findViewById(R.id.btn_successful);
        btnSuccessful.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).showActionBar(true);
                getFragmentManager().popBackStack();
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) getActivity()).showActionBar(false);
    }
}
