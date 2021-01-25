package com.example.ivatax;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class Dashboard extends AppCompatActivity {
     EditText amountEditText ,percentageEditText;
     TextView percent, grand_total;
    private static final NumberFormat CURRENCY_FORMAT = NumberFormat.getCurrencyInstance();
    private static final NumberFormat PERCENT_FORMAT = NumberFormat.getPercentInstance();

    private double mBillAmount = 0.0;
    private double mPercent = 0.0;

    private void calculate() {


       // percent.setText(PERCENT_FORMAT.format(mPercent));



        double tax = mBillAmount * mPercent / 100;
        double total = mBillAmount + tax ;


        percent.setText(CURRENCY_FORMAT.format(tax));
        grand_total.setText(CURRENCY_FORMAT.format(total));
    }

    private TextWatcher amountEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {

                mBillAmount = Double.parseDouble(s.toString());
                grand_total.setText(CURRENCY_FORMAT.format(mBillAmount));
       } catch (NumberFormatException ex) {
                grand_total.setText("");
                mBillAmount = 0.0;

            }
            calculate();
        }
 @Override
        public void afterTextChanged(Editable s) {}
    };
    private TextWatcher mpercentageEditText = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                mPercent=Double.parseDouble(s.toString());
               percent.setText(PERCENT_FORMAT.format(mPercent));
             } catch (NumberFormatException ex) {

                percent.setText("");
                mPercent=0.0;
            }
            calculate();
        }



        @Override
        public void afterTextChanged(Editable s) {}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        amountEditText = (EditText) findViewById(R.id.amountEditText);
        percentageEditText=(EditText)findViewById(R.id.percentageEditText);

        percent=(TextView) findViewById(R.id.percent);
        grand_total=(TextView) findViewById(R.id.grand_total);

        percent.setText(CURRENCY_FORMAT.format(0.0));
        grand_total.setText(CURRENCY_FORMAT.format(0.0));

        amountEditText.addTextChangedListener(amountEditTextWatcher);
        percentageEditText.addTextChangedListener(mpercentageEditText);
    }


}