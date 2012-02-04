package com.jumpercake.tab;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class ResultsTabLayoutActivity extends TabActivity{
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_tab);
        
        Bundle b = getIntent().getExtras();
        
        TabHost tabHost = getTabHost();
        
        TabSpec resultspec = tabHost.newTabSpec("RESULTS");
        // setting Title and Icon for the Tab
        resultspec.setIndicator("RESULTS", getResources().getDrawable(R.drawable.ic_tab_results));
        Intent resultIntent = new Intent(this, ResultsActivity.class);
        resultIntent.putExtras(b);
        resultspec.setContent(resultIntent);
     
        TabSpec instructionspec = tabHost.newTabSpec("INSTRUCTIONS");
        // setting Title and Icon for the Tab
        instructionspec.setIndicator("INSTRUCTIONS", getResources().getDrawable(R.drawable.ic_tab_instructions));
        Intent instructionIntent = new Intent(this, InstructionsActivity.class);
        instructionspec.setContent(instructionIntent);
        
        tabHost.addTab(resultspec);
        tabHost.addTab(instructionspec);
    }
}
