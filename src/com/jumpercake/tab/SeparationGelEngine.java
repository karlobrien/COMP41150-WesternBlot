package com.jumpercake.tab;

import java.text.DecimalFormat;

public class SeparationGelEngine implements IFormula{

	private Elements resultSet = null;
	
	@Override
	public Elements calculateFormula(InputParams values) {
		
		resultSet = new Elements();
		
		Double acry = CalculateAcryLamide(values.getNumGel(),values.getPercentGel(), values.getPercentArcy());
		
		resultSet.setAcrylamide(acry);
		
		Double ddH2O = Calculate_ddH20(values.getNumGel());
		
		resultSet.setdH20(ddH2O);
		
		Double tris_1 = Calculate_Tris_1(values.getNumGel());
		
		resultSet.setTris_1(tris_1);
		
		Double SDS = Calculate_SDS(values.getNumGel());
		
		resultSet.setSDS(SDS);
		
		Double APS = Calculate_APS(values.getNumGel());
		
		resultSet.setAPS(APS);
		
		Double TEMED = Calculate_TEMED(values.getNumGel());
		
		resultSet.setTEMED(TEMED);
		
		Double TV = Calculate_Total_Volume(values.getNumGel());
		
		resultSet.setTotalVolume(TV);
				
		return resultSet;
		
	}
	
	public Double CalculateAcryLamide(Double numGel, Double percentGel, Double percentArcy)
	{
		Double result = 0.0;
		Double temp = 0.0;
		Double temp2 = 0.0;
		
		if (percentArcy == 40)
		{
			result = (0.25 * percentGel) * numGel;
			result = roundTwoDecimals(result);
		}
		else
		{
			temp = (0.25 * percentGel) * numGel;
			temp2 = (temp / 100) * 33.3;
			result = temp + temp2;
			result = roundTwoDecimals(result);
 		}
				
		return result;
		
	}

	public Double Calculate_ddH20(Double numGel)
	{
		Double result = 0.0;
		
		result = (7.35 * numGel) - resultSet.getAcrylamide();
		
		result = roundTwoDecimals(result);
		
		return result;
		
	}
	
	public Double Calculate_Tris_1(Double numGel)
	{
		Double result = 0.0;
		
		result = 2.5 * numGel;
		
		return result;
		
	}
	
	public Double Calculate_Tris_2(Double numGel)
	{
		Double result = 0.0;
		
		return result;
		
	}
	
	public Double Calculate_SDS(Double numGel)
	{
		Double result = 0.0;
		
		result = 100 * numGel;
		
		return result;
		
	}
	
	public Double Calculate_APS(Double numGel)
	{
		Double result = 0.0;
		
		result = 50 * numGel;
		
		return result;
		
	}
	
	public Double Calculate_TEMED(Double numGel)
	{
		Double result = 0.0;
		
		result = 5 * numGel;
		
		return result;
		
	}
	
	public Double Calculate_Total_Volume(Double numGel)
	{
		Double result = 0.0;
		
		result = resultSet.getdH20() + resultSet.getAcrylamide() + resultSet.getTris_1() + (0.155 * numGel);
		result = roundTwoDecimals(result);
		
		return result;
		
	}
	
    double roundTwoDecimals(double d) 
    {
        DecimalFormat twoDForm = new DecimalFormat("#.###");
        return Double.valueOf(twoDForm.format(d));
    }
	
}
