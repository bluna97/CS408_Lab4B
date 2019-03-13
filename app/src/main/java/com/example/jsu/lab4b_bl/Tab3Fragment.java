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
public class Tab3Fragment extends Fragment implements View.OnClickListener{


    public Tab3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_tab3, container, false);
        Button b = (Button)v.findViewById(R.id.convertTempButton);
        b.setOnClickListener(this);

        return v;
    }

    public void onClick(View v) {
        String f = ((EditText) getView().findViewById(R.id.fahrenheitInput)).getText().toString();
        String c = ((EditText) getView().findViewById(R.id.celsiusInput)).getText().toString();

        if(f.isEmpty()) {

            if(!c.isEmpty()) {
                double celsius = Double.parseDouble(c);
                double fahrenheit = ((celsius * 9/5) +32);

                ((EditText) getView().findViewById(R.id.fahrenheitInput)).setText(String.valueOf(fahrenheit));
            }
        }

        else {
            double fahrenheit = Double.parseDouble(f);
            double celsius = ((fahrenheit - 32) * 5/9);

            ((EditText) getView().findViewById(R.id.celsiusInput)).setText(String.valueOf(celsius));
        }
    }

}
