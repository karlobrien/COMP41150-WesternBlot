package com.jumpercake.tab;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class InstructionsActivity extends ListActivity{

	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        
	  	  String[] before_recipe = getResources().getStringArray(R.array.before_protocol_array);
		  
		  setListAdapter(new ArrayAdapter<String>(this, R.layout.instructions_layout, before_recipe));
	  
		  ListView lv = getListView();
		  lv.setTextFilterEnabled(true);

	    }
}
