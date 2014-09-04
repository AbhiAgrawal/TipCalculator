package com.yahoo.abhisheka.tipcalculator;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {

	private static final DecimalFormat df = new DecimalFormat("#0.00");

	private double tipPc = 0.00;

	EditText etAmt;
	TextView tvTipValue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		etAmt = (EditText) findViewById(R.id.etAmt);
		tvTipValue = (TextView) findViewById(R.id.tvTipValue);
		setUpEditTextChange();

	}

	private void setUpEditTextChange() {
		etAmt.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				calculateTipWith(tipPc);
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});

		final EditText etCustomTip = (EditText) findViewById(R.id.etCustomTip);
		etCustomTip.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				double tip = 0.00;
				try {
					tip = Double.valueOf(etCustomTip.getText().toString());
				} catch (NumberFormatException nfe) {
					calculateTipWith(0.00);
				}
				calculateTipWith(tip);
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});

	}

	public void calc10pcTip(View v) {
		calculateTipWith(10);
	}

	private void calculateTipWith(double tipPc) {
		Double amount = 0.00;
		this.tipPc = tipPc;
		try {
			amount = Double.valueOf(etAmt.getText().toString());
		} catch (NumberFormatException nfe) {
			amount = 0.00;
		}
		tvTipValue.setText(df.format((tipPc * amount) / 100.0));
	}

	public void calc15pcTip(View v) {
		calculateTipWith(15);
	}

	public void calc20pcTip(View v) {
		calculateTipWith(20);
	}
}
