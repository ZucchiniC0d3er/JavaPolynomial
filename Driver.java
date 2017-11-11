
/**
 * @author Eric Pacheco
 *
 * CS-3340
 * HW2
 */

public class Driver {

	
	public static void main(String[] args) {
		double[] input = {1, 2, 3, 4};
		String originalPoly;


		Polynomial nomial = new Polynomial();
		Polynomial derNomial; 
		originalPoly = nomial.polyToString(input);
		System.out.println(originalPoly);
		
		System.out.println("the Dirivative");
		derNomial = nomial.derivative(input);
		System.out.println(derNomial.toString());
		
		
	}

}
