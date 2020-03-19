package Polynomial;

import java.util.*;



public class Polynomial {
	
	public String polynomString;
	public ArrayList<Monomial> pol = new ArrayList<Monomial>();
	
	public Polynomial(String polynomString, ArrayList<Monomial> pol)
	{
		this.polynomString = polynomString;
		this.pol = pol;
	}
	
	public static void createPolynom(String polynom, ArrayList<Monomial> poly)
	{
		String[] prt = polynom.split("\\+");
		for(String x : prt)	{	
			if(x != null)
			{	Monomial mon = new Monomial(1, 1, 'x');
				mon.setCharacter('x');
				x = x.replaceAll("\\s", "");
				int posx = x.indexOf('x');
				int pospow = x.indexOf('^');
				if(posx < 0)	{mon.setDegree(0); mon.setCoeff(Integer.parseInt(x, 10));	mon.setDCoeff(Integer.parseInt(x, 10));}
				else if(posx == 0){
					if(pospow < 0)	mon.setDegree(1);
					else	mon.setDegree(Integer.parseInt(x, pospow + 1, x.length(), 10));
				}
				else if(posx > 0)
				{	if(x.charAt(0) == '-')	{			
					String[] nrcoef = x.split("\\-|x"); nrcoef[1].replaceAll("\\s", "");
					mon.setCoeff(-1 * Integer.parseInt(nrcoef[1],10));	mon.setDCoeff(-1 * Integer.parseInt(nrcoef[1], 10));
					} 
					else	{ 
					String[] nrcoef = x.split("x"); nrcoef[0].replaceAll("\\s", "");
					mon.setCoeff(Integer.parseInt(nrcoef[0],10));	mon.setDCoeff(Integer.parseInt(nrcoef[0], 10));
					}
					if(pospow < 0)	mon.setDegree(1);
					else	mon.setDegree(Integer.parseInt(x, pospow+1, x.length(), 10));
					}	poly.add(mon);	
			}else	break;}
		}
	
	public static void printPolynom(ArrayList<Monomial> pol)
	{
		for(Monomial fmon : pol)
			{
			
				if(fmon != null)
					{
					if(fmon.getDCoeff() != 0 && fmon.getCoeff() != 0) {
						fmon.printMonom(fmon);
						if(pol.indexOf(fmon) != pol.size() - 1 )	System.out.print(" + ");
					}
						
					}
				else
					break;
			}
		System.out.println();
	}
	
	public static Monomial getMonWithPow(int power, ArrayList<Monomial> pol)
	{
		for(Monomial x : pol)
		{
			if(x.getDegree() == power)
				
				return x;
		}
		return null;
	}
	public static ArrayList<Monomial> addition(ArrayList<Monomial> poly1, ArrayList<Monomial> poly2)
	{
		
		ArrayList<Monomial> polRes = new ArrayList<Monomial>();
		
		for(Monomial x : poly1)
		{
			int p1 = x.getDegree();
			double c1 = x.getDCoeff();
			
			if(getMonWithPow(p1, poly2) == null)	polRes.add(new Monomial(c1,p1,'x'));
			else
			{
				int p2 = getMonWithPow(p1, poly2).getDegree();
				double c2 = getMonWithPow(p1, poly2).getDCoeff();
				polRes.add(new Monomial(c1+c2, p2, 'x'));
				poly2.remove(getMonWithPow(p1, poly2));
			}

		}
		
		for(Monomial x : poly2)	polRes.add(new Monomial(x.getDCoeff(),x.getDegree(),'x'));
		
		return (ArrayList<Monomial>) polRes;
		
	}
	
	public static ArrayList<Monomial> substraction(ArrayList<Monomial> poly1, ArrayList<Monomial> poly2) 
	{
		ArrayList<Monomial> polRes = new ArrayList<Monomial>();
		
		for(Monomial x : poly1)
		{
			int p1 = x.getDegree();
			double c1 = x.getDCoeff();
			
			if(getMonWithPow(p1, poly2) == null)
			{
				polRes.add(new Monomial(c1,p1,'x'));
			}
			else
			{
				int p2 = getMonWithPow(p1, poly2).getDegree();
				double c2 = getMonWithPow(p1, poly2).getDCoeff();
				
				polRes.add(new Monomial(c1-c2, p2, 'x'));
				
				poly2.remove(getMonWithPow(p1, poly2));
			}

		}
		
		for(Monomial x : poly2)		polRes.add(new Monomial(-x.getDCoeff(),x.getDegree(),'x'));
		
		return (ArrayList<Monomial>) polRes;
	}
	public static ArrayList<Monomial> polyMultiply(ArrayList<Monomial> poly1, ArrayList<Monomial> poly2)
	{
		ArrayList<Monomial> result = new ArrayList<Monomial>();
		for(Monomial m1 : poly1)
		{
			for(Monomial m2 : poly2)
			{
				Monomial res = m1.monomMultiply(m1, m2);
				result.add(res);
			}
		}		
		
		return result;
	}
	public static ArrayList<Monomial> polyDivide(ArrayList<Monomial> deImp, ArrayList<Monomial> imp){
			Monomial mon = new Monomial(0,0,'x');
			ArrayList<Monomial> cat = new ArrayList<Monomial>();
			ArrayList<Monomial> rest = new ArrayList<Monomial>();
			Polynomial restPol = new Polynomial("",rest);
			Polynomial impPol = new Polynomial("",imp);
			ArrayList<Monomial> p = new ArrayList<Monomial>();
			ArrayList<Monomial> result = new ArrayList<Monomial>();
			ArrayList<Monomial> toRem = new ArrayList<Monomial>();
			
			rest = deImp;
			if(deImp.containsAll(imp)) {result.add(new Monomial(1,0,'x'));return result;}
			while(!rest.contains(mon) && restPol.getMax(rest).getDegree() >= impPol.getMax(imp).getDegree() &&  restPol.getMax(rest).getDCoeff() > 0)
			{
				Monomial t = restPol.getMax(rest).monomDivide(restPol.getMax(rest), impPol.getMax(imp));
				cat.add(t);
				p.add(t);
				rest = substraction(rest, polyMultiply(p,imp));
				if(restPol.getMax(rest).getDCoeff() <= 0)	{rest.remove(restPol.getMax(rest));}
				for(Monomial x : rest) {toRem.add(x);}
				rest.removeAll(toRem);				
			}
			if(rest.isEmpty()) rest.add(new Monomial(0,0,'x'));
			for(Monomial x : cat) {result.add(x);}
			for(Monomial x : rest) {result.add(x);}
			return result;}
	
	public Monomial getMax(ArrayList<Monomial> pol)
	{
		Monomial max = new Monomial(0,0,'x');
		for(Monomial x : pol)
		{
			if(x.getDegree() > max.getDegree())
			{
				max = x;
			}
		}
		return max;
	}
	
	public static String toString(ArrayList<Monomial> pol)
	{
		String r = "";
		for(Monomial x : pol)
		{
			r += x.getDCoeff();
			if(x.getDegree() > 0)
			{
				r += "x^" + x.getDegree();
			}
			
			if(pol.indexOf(x) != pol.size() - 1)
			{
				r += " + ";
			}
			
		}
		
		return r;
		
	}
	public static ArrayList<Monomial> polynomialIntegration(ArrayList<Monomial> pol)
	{
		ArrayList<Monomial> res = new ArrayList<Monomial>();
		for(Monomial x : pol)
		{
			
			if(x.getDCoeff() == 0) {x.setDegree(0);x.setCoeff(0);x.setDCoeff(0);res.add(x);}
			else{x.integration();res.add(x);}
		}
		return res;
	}
	public static ArrayList<Monomial> polynomialDerivation(ArrayList<Monomial> pol)
	{
		ArrayList<Monomial> res = new ArrayList<Monomial>();
		for(Monomial x : pol)
		{
			if(x.getDegree() <= 0) {x.setDegree(0);x.setCoeff(0);x.setDCoeff(0);res.add(x);}
			else{x.derivation();res.add(x);}
			
		}
		return res;
	}
	
 }
	
	

