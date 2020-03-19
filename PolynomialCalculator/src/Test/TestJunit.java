package Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import Polynomial.*;



public class TestJunit {
	
	
	  @Test 
	  public void testMonomial() 
	  { 
		
		  Monomial testMonomial = new Monomial(-3,3,'x'); 
		  assertEquals("-3.0x^3", testMonomial.toString(testMonomial));
		  
	  }
	  
	  @Test
	  public void testMonomialDerivationAndIntegration()
	  {
		
		Monomial test1 = new Monomial(2,3,'x');
		Monomial test2 = new Monomial(6,5,'x');
		
		test1.derivation();
		assertEquals("6.0x^2",test1.toString(test1));
		test2.integration();
		assertEquals("1.0x^6",test2.toString(test2));
		  
	  }
	  
	  @Test
	  public void testMonomialOperations()
	  {
		 
		  Monomial test1 = new Monomial(8,5,'x');
		  Monomial test2 = new Monomial(2,5,'x');
		  
		  Monomial resultAdd = (new Monomial(10,5,'x'));
		  Monomial resultSubs = (new Monomial(6,5,'x'));
		  Monomial resultMult = test1.monomMultiply(test1, test2);
		  Monomial resultDiv = test1.monomDivide(test1, test2);
		  
		  assertEquals("10.0x^5", resultAdd.toString(resultAdd));
		  assertEquals("6.0x^5", resultSubs.toString(resultSubs));
		  assertEquals("16.0x^10", resultMult.toString(resultMult));
		  assertEquals("4.0x^0", resultDiv.toString(resultDiv));
		  
	  }
	  
	  @Test
	  public void testPolynom()
	  {
		  ArrayList<Monomial> pol1 = new ArrayList<Monomial>();
		  ArrayList<Monomial> pol2 = new ArrayList<Monomial>();
		  Polynomial polynom1 = new Polynomial("8x + -1",pol1);
		  Polynomial polynom2 = new Polynomial("6x^5 + 4x^3 + 20", pol2);
		  Polynomial.createPolynom(polynom1.polynomString, polynom1.pol);
		  Polynomial.createPolynom(polynom2.polynomString, polynom2.pol);
		  
		  String test1 = Polynomial.toString(Polynomial.polynomialDerivation(pol1));
		  String test2 = Polynomial.toString(Polynomial.polynomialIntegration(pol2));
		  
		  assertEquals("8.0 + 0.0", test1);
		  assertEquals("1.0x^6 + 1.0x^4 + 20.0x^1", test2);
	  }
	  
	  @Test
	  public void testPolynomOperations()
	  {
		  ArrayList<Monomial> pol1 = new ArrayList<Monomial>();
		  ArrayList<Monomial> pol2 = new ArrayList<Monomial>();
		  ArrayList<Monomial> pol3 = new ArrayList<Monomial>();
		  ArrayList<Monomial> pol4 = new ArrayList<Monomial>();
		  ArrayList<Monomial> pol5 = new ArrayList<Monomial>();
		  ArrayList<Monomial> pol6 = new ArrayList<Monomial>();
		  
		  
		  Polynomial polynom1 = new Polynomial("8x^5 + -1x^2 + 20",pol1);
		  Polynomial polynom2 = new Polynomial("20x^2 + x + -20", pol2);
		  
		  Polynomial.createPolynom(polynom1.polynomString, polynom1.pol);
		  Polynomial.createPolynom(polynom2.polynomString, polynom2.pol);
		  
		  Polynomial polynom3 = new Polynomial("8x^5 + -1x^2 + 20",pol3);
		  Polynomial polynom4 = new Polynomial("20x^2 + x + -20", pol4);
		  
		  Polynomial.createPolynom(polynom3.polynomString, polynom3.pol);
		  Polynomial.createPolynom(polynom4.polynomString, polynom4.pol);
		  
		  Polynomial polynom5 = new Polynomial("x + 1", pol5);
		  Polynomial polynom6 = new Polynomial("x + 1", pol6);
			
		  Polynomial.createPolynom(polynom5.polynomString, polynom5.pol);
		  Polynomial.createPolynom(polynom6.polynomString, polynom6.pol);
		  
		  String res1 = Polynomial.toString(Polynomial.addition(pol1, pol2));
		  String res2 = Polynomial.toString(Polynomial.substraction(pol3, pol4));
		  String res3 = Polynomial.toString(Polynomial.polyMultiply(pol5, pol6));;
		  String res4 = Polynomial.toString(Polynomial.polyDivide(pol5, pol6));
		  
		  
		  assertEquals("8.0x^5 + 19.0x^2 + 0.0 + 1.0x^1",res1); 		//ADDITION
		  assertEquals("8.0x^5 + -21.0x^2 + 40.0 + -1.0x^1",res2);		//SUBSTRACTION
		  assertEquals("1.0x^2 + 1.0x^1 + 1.0x^1 + 1.0", res3);			//MULTIPLICATION
		  assertEquals("1.0 + 0.0", res4);								//DIVISION
		  																
		  
		  
	  }
	  
	 
	
}
