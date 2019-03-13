package com.example.jsu.lab4b_bl;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.*;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab2Fragment extends Fragment implements View.OnClickListener {


    public Tab2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_tab2, container, false);
        Button b = (Button)v.findViewById(R.id.convertDistButton);
        b.setOnClickListener(this);

        return v;
    }

    public void onClick(View v) {
        String m = ((EditText) getView().findViewById(R.id.milesInput)).getText().toString();
        String k = ((EditText) getView().findViewById(R.id.kilometersInput)).getText().toString();

        if(m.isEmpty()) {

            if(!k.isEmpty()) {
                double kilometers = Double.parseDouble(k);
                double miles = kilometers / 1.609344;

                ((EditText) getView().findViewById(R.id.milesInput)).setText(String.valueOf(miles));
            }
        }

        else {
            double miles = Double.parseDouble(m);
            double kilometers = miles * 1.609344;

            ((EditText) getView().findViewById(R.id.kilometersInput)).setText(String.valueOf(kilometers));
        }
    }

}
