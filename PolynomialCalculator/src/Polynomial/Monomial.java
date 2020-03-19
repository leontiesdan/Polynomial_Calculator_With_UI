package Polynomial;

import java.text.DecimalFormat;
import java.util.regex.Pattern;

public class Monomial {

	private int degree;
	private double coeff;
	private double dcoeff;
	private boolean isNeg = false;
	private char character;
	private String monom;

	public Monomial(String monom)
	{
		if(validation(monom) == true)
		{
			this.monom = monom;
		}
		dcoeff = (double) coeff;
	}
	
	public Monomial(double coeff, int degree, char character) {
		this.coeff = coeff;
		this.degree = degree;
		this.character = character;
		this.dcoeff = coeff;
		this.isNeg = false;
	}
	
	public void setDegree(int degree)
	{
		this.degree = degree;
	}
	
	public void setCoeff(double coeff)
	{
		this.coeff = coeff;
	}
	
	public void setDCoeff(double dcoeff)
	{
		this.dcoeff = dcoeff;
	}
	
	public void setCharacter(char character)
	{
		this.character = character;
	}

	public void integration() {
	
		if(isNeg == false)
		{
		degree++;
		dcoeff = dcoeff / degree;
		
		coeff = (int) dcoeff;
		}

			
	}

	public boolean validation(String monom)
	{
		
		if(monom.matches("([+-]?[^-+]+)"))
		{
			return true;
		}
		return false;
	}
	public void derivation() {
		if (degree > 0) {

			dcoeff = dcoeff * degree;
			coeff = (int) dcoeff;
			degree--;
		}
		else
			if(degree == 0 && isNeg == false)
		{
			degree--;
			isNeg = true;
		}
	}
	
	public Monomial monomMultiply(Monomial m1, Monomial m2)
	{
		
		Monomial result = new Monomial(m1.getDCoeff() * m2.getDCoeff(), m1.getDegree() + m2.getDegree(), 'x');
		return result;
	}

	public Monomial monomDivide(Monomial m1, Monomial m2)
	{
		Monomial result = new Monomial(m1.getDCoeff() / m2.getDCoeff(), m1.getDegree() - m2.getDegree(), 'x');
		return result;
	}
	public Integer getDegree() {
		return degree;
	}

	public double getDCoeff()
	{
		return dcoeff;
	}
	public double getCoeff() {
		return coeff;
	}

	public char getChar() {
		return character;
	}
	
	public boolean getIsNeg() {
		return isNeg;
	}
	
	public String toString(Monomial mon)
	{
		String r = "";
		r += mon.getCoeff() + "x^" + mon.getDegree();
		
		return r;
	}

	public void printMonom(Monomial monom) {
		
		if(isNeg == true)
		{
			this.coeff = 0;
			this.degree = 0;
			this.dcoeff = 0;
			//System.out.println(0);
		}
		else
		{
			DecimalFormat df = new DecimalFormat("#.##"); //simpler output 	
			
			if(monom.degree == 0)
			{
				System.out.print(df.format(monom.getDCoeff()));
			}
			else
			{
				System.out.print(df.format(monom.getDCoeff()) + monom.getChar() + "^" + monom.getDegree());
			}
		}
	}

}
