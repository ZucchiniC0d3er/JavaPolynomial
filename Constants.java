/**
 * @author Eric Pacheco
 *
 * CS-3340
 * HW2
 */

public class Constants {
	private double delta = 0.00001;
	private int maxCoeffs = 10;
	
	public Constants() {
		// TODO Auto-generated constructor stub
	}
	public void setDelta(double delta) {
		this.delta = delta;
	}
	public void setMaxCoeffs(int maxCoeffs) {
		this.maxCoeffs = maxCoeffs;
	}
	public int getMaxCoeffs() {
		return maxCoeffs;
	}
	public double getDelta() {
		return delta;
	}
}
