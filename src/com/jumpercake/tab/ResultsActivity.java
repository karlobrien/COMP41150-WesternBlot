package com.jumpercake.tab;

import com.jumpercake.tab.Elements;
import com.jumpercake.tab.FormulaContext;
import com.jumpercake.tab.InputParams;
import com.jumpercake.tab.R;
import com.jumpercake.tab.SeparationGelEngine;
import com.jumpercake.tab.StackingGelEngine;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultsActivity extends Activity{

	private InputParams inputValues;
	
	private FormulaContext context;
	private Elements formulaResult;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_layout);
        
        Bundle b = getIntent().getExtras();
        
        inputValues = new InputParams();
        
        //Log.v("TAB", Double.toString(b.getDouble("numGel")));
        inputValues.setNumGel(b.getDouble("numGel"));
        inputValues.setPercentGel(b.getDouble("percentGel"));
        inputValues.setPercentArcy(b.getDouble("percentArcy"));

        context = new FormulaContext();
        context.setFormula(new SeparationGelEngine());
        formulaResult = context.calculate(inputValues);
        
        TextView vw1 = (TextView) findViewById(R.id.SepG_ddH20);
        TextView vw2 = (TextView) findViewById(R.id.SepG_Acry);
        TextView vw3 = (TextView) findViewById(R.id.SepG_Tris_1);
        TextView vw4 = (TextView) findViewById(R.id.SepG_Tris_2);
        TextView vw5 = (TextView) findViewById(R.id.SepG_SDS);
        TextView vw6 = (TextView) findViewById(R.id.SepG_APS);
        TextView vw7 = (TextView) findViewById(R.id.SepG_TEMED);
        TextView vw8 = (TextView) findViewById(R.id.SepG_TotalVolume);
        
        vw1.setText(Double.toString(formulaResult.getdH20()));
        vw2.setText(Double.toString(formulaResult.getAcrylamide()));
        vw3.setText(Double.toString(formulaResult.getTris_1()));
        vw4.setText(Double.toString(formulaResult.getTris_2()));
        vw5.setText(Double.toString(formulaResult.getSDS()));
        vw6.setText(Double.toString(formulaResult.getAPS()));
        vw7.setText(Double.toString(formulaResult.getTEMED()));
        vw8.setText(Double.toString(formulaResult.getTotalVolume()));
        

        context.setFormula(new StackingGelEngine());
        formulaResult = context.calculate(inputValues);
        
        TextView vw9 = (TextView) findViewById(R.id.Stack_ddH20);
        TextView vw10 = (TextView) findViewById(R.id.Stack_Acry);
        TextView vw11 = (TextView) findViewById(R.id.Stack_Tris_1);
        TextView vw12 = (TextView) findViewById(R.id.Stack_Tris_2);
        TextView vw13 = (TextView) findViewById(R.id.Stack_SDS);
        TextView vw14 = (TextView) findViewById(R.id.Stack_APS);
        TextView vw15 = (TextView) findViewById(R.id.Stack_TEMED);
        TextView vw16 = (TextView) findViewById(R.id.Stack_TV);
        
        vw9.setText(Double.toString(formulaResult.getdH20()));
        vw10.setText(Double.toString(formulaResult.getAcrylamide()));
        vw11.setText(Double.toString(formulaResult.getTris_1()));
        vw12.setText(Double.toString(formulaResult.getTris_2()));
        vw13.setText(Double.toString(formulaResult.getSDS()));
        vw14.setText(Double.toString(formulaResult.getAPS()));
        vw15.setText(Double.toString(formulaResult.getTEMED()));
        vw16.setText(Double.toString(formulaResult.getTotalVolume()));
        
    }
}
