package Polynomial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Polynomial.Polynomial;

import Window.GUI;

public class Interpreter implements ActionListener {

	GUI window;
	String poly1;
	String poly2;
	String poly;
	
	public Interpreter(GUI window)
	{
		this.window = window;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		
		if(command.equals("+"))
		{
			poly1 = window.textField.getText();
			poly2 = window.textField_1.getText();
			ArrayList<Monomial> pol1 = new ArrayList<Monomial>();
			ArrayList<Monomial> pol2 = new ArrayList<Monomial>();
			Polynomial polynom1 = new Polynomial(poly1, pol1);
			Polynomial polynom2 = new Polynomial(poly2, pol2);
			Polynomial.createPolynom(polynom1.polynomString,polynom1.pol);
			Polynomial.createPolynom(polynom2.polynomString,polynom2.pol);
			window.textField_2.setText(Polynomial.toString(Polynomial.addition(pol1,pol2)));
		}
		else if(command.equals("-"))
		{
			poly1 = window.textField.getText();
			poly2 = window.textField_1.getText();
			ArrayList<Monomial> pol1 = new ArrayList<Monomial>();
			ArrayList<Monomial> pol2 = new ArrayList<Monomial>();
			Polynomial polynom1 = new Polynomial(poly1, pol1);
			Polynomial polynom2 = new Polynomial(poly2, pol2);
			Polynomial.createPolynom(polynom1.polynomString,polynom1.pol);
			Polynomial.createPolynom(polynom2.polynomString,polynom2.pol);
			window.textField_2.setText(Polynomial.toString(Polynomial.substraction(pol1,pol2)));
		}
		else if(command.equals("x"))
		{
			poly1 = window.textField.getText();
			poly2 = window.textField_1.getText();
			ArrayList<Monomial> pol1 = new ArrayList<Monomial>();
			ArrayList<Monomial> pol2 = new ArrayList<Monomial>();
			Polynomial polynom1 = new Polynomial(poly1, pol1);
			Polynomial polynom2 = new Polynomial(poly2, pol2);
			Polynomial.createPolynom(polynom1.polynomString,polynom1.pol);
			Polynomial.createPolynom(polynom2.polynomString,polynom2.pol);
			window.textField_2.setText(Polynomial.toString(Polynomial.polyMultiply(pol1,pol2)));
		}
		else if(command.equals("/"))
		{
			poly1 = window.textField.getText();
			poly2 = window.textField_1.getText();
			ArrayList<Monomial> pol1 = new ArrayList<Monomial>();
			ArrayList<Monomial> pol2 = new ArrayList<Monomial>();
			Polynomial polynom1 = new Polynomial(poly1, pol1);
			Polynomial polynom2 = new Polynomial(poly2, pol2);
			Polynomial.createPolynom(polynom1.polynomString,polynom1.pol);
			Polynomial.createPolynom(polynom2.polynomString,polynom2.pol);
			window.textField_2.setText(Polynomial.toString(Polynomial.polyDivide(pol1,pol2)));
		}
		else if(command.equals("Derivation"))
		{
			poly = window.textField_3.getText();
			ArrayList<Monomial> pol = new ArrayList<Monomial>();
			Polynomial.createPolynom(poly,pol);
			pol = Polynomial.polynomialDerivation(pol);
			window.textField_4.setText(Polynomial.toString(pol));
		}
		else if(command.equals("Integration"))
		{
			poly = window.textField_3.getText();
			ArrayList<Monomial> pol = new ArrayList<Monomial>();
			Polynomial.createPolynom(poly,pol);
			pol = Polynomial.polynomialIntegration(pol);
			window.textField_4.setText(Polynomial.toString(pol));
		}
		
	}
	
	

}
