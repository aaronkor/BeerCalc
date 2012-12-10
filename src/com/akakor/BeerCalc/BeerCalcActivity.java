package com.akakor.BeerCalc;

import com.akakor.BeerCalc.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BeerCalcActivity extends Activity {
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void calculateABV(View view){
    	Intent intent = new Intent(BeerCalcActivity.this, ABVCalculatorActivity.class);
    	BeerCalcActivity.this.startActivity(intent);
    }
    
    public void showAbout(View view) {
    	
    }
}