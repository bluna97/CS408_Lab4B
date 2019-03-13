package com.example.jsu.lab4b_bl;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.text.DecimalFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1Fragment extends Fragment implements View.OnClickListener {


    public Tab1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_tab1, container, false);
        Button b = (Button)v.findViewById(R.id.calculateTipButton);
        b.setOnClickListener(this);

        return v;
    }


    public void onClick(View v) {

        String b = ((EditText) getView().findViewById(R.id.totalBillInput)).getText().toString();
        String t = ((EditText) getView().findViewById(R.id.tipPercentInput)).getText().toString();
        String p = ((EditText) getView().findViewById(R.id.peopleInput)).getText().toString();

        if(!b.isEmpty() && !t.isEmpty() && !p.isEmpty()) {
            double totalBill = Double.parseDouble(b);
            double tipPercentage = Double.parseDouble(t);
            int people = Integer.parseInt(p);
            double tip = 0;
            double individualCost = 0;

            if(people < 1) people = 1;

            tip = (totalBill * tipPercentage) / 100;
            individualCost = (totalBill + tip) / people;
            individualCost = (double)(Math.round(individualCost * 100)) / 100;

            DecimalFormat d = new DecimalFormat("#.00");

            ((TextView) getView().findViewById(R.id.resultLabel)).setText("Approximate individual cost: $" + String.valueOf(d.format(individualCost)));

        }
    }
}
