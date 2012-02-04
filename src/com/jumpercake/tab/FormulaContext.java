package com.jumpercake.tab;

public class FormulaContext {
	
	private IFormula formula = null;
	private Elements formulaResult;
	
	public Elements calculate(InputParams list)
	{
		formulaResult = formula.calculateFormula(list);
		return formulaResult;
	}

	public IFormula getFormula()
	{
		return formula;
	}
	
	public void setFormula(IFormula inputFormula)
	{
		this.formula = inputFormula;
	}
	
	
}
