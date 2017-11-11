
import java.text.DecimalFormat;
import java.text.NumberFormat;


import java.util.ArrayList;


/**
 * @author Eric Pacheco
 *
 * CS-3340
 * HW2
 */

public class Polynomial implements Continuous {

	/**
	 * 
	 */
	ArrayList<Double> coeffs;
	public Polynomial() {
		
	}
	public Polynomial(ArrayList<Double> coeffs) {
		this.coeffs = coeffs;
	}
	public void setCoeffs(ArrayList<Double> coeffs) {
		this.coeffs = coeffs;
	}
	/**
	 * populates and array of doubles
	 * then converts them into an array of object Double
	 * then adds each Double to a list;
	 */
	public Polynomial derivative(double[] poly){
		int numCoeffs = poly.length;
        double[] dirArr = new double[numCoeffs]; 
        Double[] dbArr = new Double[numCoeffs];
        dirArr[0] = 0;
        dbArr[0] = new Double(dirArr[0]);
        coeffs = new ArrayList<Double>();
        coeffs.add(dbArr[0]);
        
        for (int i = 1; i < numCoeffs; i++) {
            dirArr[i] = poly[i -1] * (numCoeffs - i);
            dbArr[i] = new Double(dirArr[i]);
            coeffs.add(dbArr[i]);
        }
        Polynomial derPoly = new Polynomial(coeffs);
        return derPoly;

	}
	/**
	 * Overriding the ToString method;
	 * outboxes the coeffs list and convets passes the array
	 * to the polyToString Method to get a String representation 
	 * of our obj
	 */
	@Override
	public String toString() {
		//call polyToString()
		//String listStr = coeffs.toString();
		double[] dToStr = new double[coeffs.size()];
		for (int i = 0; i < dToStr.length; i++) {
			dToStr[i] = coeffs.get(i);
		}
		String listStr = polyToString(dToStr);
		return listStr;
	}
	/**
	 * compares two polynomials by there coefficients .
	 */
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		if (arg0 == null) {
	        return false;
	    }
		 if (!Polynomial.class.isAssignableFrom(arg0.getClass())) {
		        return false;
		    }
		    final Polynomial other = (Polynomial) arg0;
		   
		    if (this.coeffs != other.coeffs) {
		        return false;
		    }
		    return true;
	}
	/**
	 *
	 * polyToString Method:
	 * takes in an array of doubles 
	 *formats and concatenates the array with powers and symbols 
	 *the final result is a polynomial string
	 */
	public  String polyToString(double[] poly){
		//the number formater makes it easier to get rid of the
		// '.0' at the end of a number
		NumberFormat nf = new DecimalFormat("#.####");
		boolean first = true;
		String polyStr = "";
		int numCoeffs = poly.length;
		//declaring our constant obj to get our delta value
		Constants con = new Constants();
		double delta = con.getDelta();
		
		for (int i = 0; i < numCoeffs; i++) {
			double coeff = poly[i];
			//Using the Math class to find the absolute value
			if (Math.abs(coeff) < delta) {
				continue;
			}
			if (!first) {
				if (coeff < 0) {
					polyStr = polyStr.concat(" - ");
				} else {
					polyStr = polyStr.concat(" + ");
				}
				coeff = Math.abs(coeff);
			}else if(coeff < 0){
				polyStr = polyStr.concat(" - ");
				coeff = Math.abs(coeff); 
			}
			if (!(Math.abs(coeff-1.0) < delta)) {
				polyStr = polyStr.concat(nf.format(coeff)); 
			}
			int power = (numCoeffs - i) - 1;
			polyStr = polyStr.concat("x^" + power);
			first = false;
		}
		return polyStr;
	}
	/**
	 * IDE Generated hashTo function
	 */
	private void hashTo() {
		// TODO Auto-generated method stub

	}
	@Override
	public Object apply(double value) {
		// TODO Auto-generated method stub
		return null;
	}

}
