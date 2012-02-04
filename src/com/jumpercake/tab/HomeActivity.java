package com.jumpercake.tab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class HomeActivity extends Activity{
	
	 private EditText gelField;
 	 private EditText percentGelField;
 	 private Spinner percentAcryField;
 	
 	 private Double numGel = 0.0;
 	 private Double percentGel = 0.0;
 	 private Double percentArcy = 0.0;
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.home_layout);
	        
	    }

	 public void sendValues(View button) {  
	    			
	    	try {
	    		gelField = (EditText) findViewById(R.id.editNumGels);
	        	numGel = Double.parseDouble(gelField.getText().toString());
	        	
	        	percentGelField = (EditText) findViewById(R.id.editPercentGel);
	        	percentGel = Double.parseDouble(percentGelField.getText().toString());
	        	
	        	percentAcryField = (Spinner) findViewById(R.id.SpinnerFeedbackType);
	        	percentArcy = Double.parseDouble(percentAcryField.getSelectedItem().toString());
	        	
	    	} 
	    	catch(NumberFormatException nfe) {
	    	    System.out.println("Could not parse " + nfe);
	    	}  	 	
	    	
	    	if ((numGel > 0) & (percentGel > 0))
	    	{
		    	Intent myIntent = new Intent(button.getContext(), ResultsTabLayoutActivity.class);
				Bundle b = new Bundle();
				b.putDouble("numGel", numGel);
				b.putDouble("percentGel", percentGel);
				b.putDouble("percentArcy", percentArcy);
				
				myIntent.putExtras(b);
				startActivityForResult(myIntent, 0);
	    	}
	    	else if ((numGel == 0) && (percentGel == 0))
	    	{
	    		makeToast("Please input values for number of gels and gel percentage");
	    	}
	    	else if (numGel == 0)
	    	{
	    		makeToast("Please input the number of gels required");
	    	}
	    	else if(percentGel == 0)
	    	{
	    		makeToast("Please input values for the percentage of gels required");
	    	}
	          
	    } 
	 
	 public void clearValues(View button) {
		
		try{
			gelField = (EditText) findViewById(R.id.editNumGels);
	     	gelField.setText("");
	     	
	     	percentGelField = (EditText) findViewById(R.id.editPercentGel);
	     	percentGelField.setText("");

	     	numGel = 0.0;
	     	percentGel = 0.0;
	     	percentArcy = 0.0;
		 }
		catch (NumberFormatException nfe) {
	    	    System.out.println("Could not parse " + nfe);
	    	}
	 }
	 
	 public void makeToast(CharSequence message)
	 {
 		Context context = getApplicationContext();
 		CharSequence text = message;
 		int duration = Toast.LENGTH_SHORT;
 		
 		Toast toast = Toast.makeText(context, text, duration);
 		toast.show();
	 }
}
