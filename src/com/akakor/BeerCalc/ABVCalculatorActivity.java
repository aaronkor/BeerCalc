package com.akakor.BeerCalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

public class ABVCalculatorActivity extends Activity{
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alcohol_by_volume);
        setNumberPickers();
    }
    
    private void setNumberPickers() {
    	NumberPicker ogPicker = (NumberPicker) findViewById(R.id.og_picker);
    	NumberPicker fgPicker = (NumberPicker) findViewById(R.id.fg_picker);
    	
    	setValuesForNumberPicker(ogPicker, 45);
    	setValuesForNumberPicker(fgPicker, 10);
	}
    
    
    
    private void setValuesForNumberPicker(NumberPicker picker, int defaultValue) {
    	picker.setMinValue(0);
    	picker.setMaxValue(99);
    	picker.setValue(defaultValue);
    	String[] displayedValues = new String[100];
    	for(int i=0; i<100;i++){
    		String prefix = "1.0";
    		if(i<10)
    		{
    			prefix += "0";
    		}
    		displayedValues[i] = prefix + String.valueOf(i); 
    	}
		picker.setDisplayedValues(displayedValues);
    }
    
    public float Round(float Rval, int Rpl) {
    	  float p = (float)Math.pow(10,Rpl);
    	  Rval = Rval * p;
    	  float tmp = Math.round(Rval);
    	  return (float)tmp/p;
    }

	public void calculateABV(View view) {
		NumberPicker ogPicker = (NumberPicker) findViewById(R.id.og_picker);
    	NumberPicker fgPicker = (NumberPicker) findViewById(R.id.fg_picker);
    	
    	
    	String sOgVal = ogPicker.getDisplayedValues()[ogPicker.getValue()];
    	float og = new Float(sOgVal);
    	String sFgVal = ogPicker.getDisplayedValues()[fgPicker.getValue()];
    	float fg = new Float(sFgVal);
    	
    	
    	float delta = og - fg;
    	float abv = Round(((1.05f * delta) / fg) / 0.79f * 100f, 2);
    	
    	TextView textAbv = (TextView) findViewById(R.id.textABV);
    	textAbv.setText("ABV = " + String.valueOf(abv) + "%");
    }
}
