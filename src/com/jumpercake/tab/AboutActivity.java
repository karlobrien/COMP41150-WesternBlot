package com.jumpercake.tab;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AboutActivity extends ListActivity {
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        
		  	  String[] about = getResources().getStringArray(R.array.About_array);
			  
			  setListAdapter(new ArrayAdapter<String>(this, R.layout.about_layout, about));
		  
			  ListView lv = getListView();
			  lv.setTextFilterEnabled(true);      
	        
	    }

}
