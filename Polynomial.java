package lab1;

import java.lang.Math;

public class Polynomial {
	double[] coeff;
	
	public Polynomial() {
		coeff = new double[1];
		this.coeff[0] = 0;
	}
	
	public Polynomial(double[] c) {
		this.coeff = c;
	}
	
	public Polynomial add(Polynomial poly) {
		if (this.coeff.length >= poly.coeff.length) {
			for (int i = 0; i < poly.coeff.length; i++) {
				this.coeff[i] = this.coeff[i] + poly.coeff[i];
			}
			return this;
		}
		else {
			for (int i = 0; i < this.coeff.length; i++) {
				poly.coeff[i] = poly.coeff[i] + this.coeff[i];
			}
			return poly;
		}
	}
	
	public double evaluate(double x) {
		double result = 0;
		for (int i = 0; i < this.coeff.length; i++) {
			result = result + this.coeff[i]*Math.pow(x, i);
		}
		return result;
	}
	
	public boolean hasRoot(double x) {
		if (this.evaluate(x) == 0) {
			return true;
		}
		else {
			return false;
		}
	}
}