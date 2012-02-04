package com.jumpercake.tab;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class TabLayoutActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TabHost tabHost = getTabHost();
        
        // Tab for Photos
        TabSpec homespec = tabHost.newTabSpec("Home");

        homespec.setIndicator("Home", getResources().getDrawable(R.drawable.ic_tab_home_selected));
        Intent photosIntent = new Intent(this, HomeActivity.class);
        homespec.setContent(photosIntent);
 
        //Tab for About
        TabSpec aboutspec = tabHost.newTabSpec("About");
        aboutspec.setIndicator("About", getResources().getDrawable(R.drawable.ic_tab_instructions));
        Intent aboutIntent = new Intent(this, AboutActivity.class);
        aboutspec.setContent(aboutIntent);
 
        // Adding all TabSpec to TabHost
        tabHost.addTab(homespec); // Adding photos tab
        tabHost.addTab(aboutspec); // Adding songs tab
        
        
    }

}