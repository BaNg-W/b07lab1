package lab1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Polynomial {
    double[] coeff;
    int[] exp;
	
    public Polynomial() {
        coeff = new double[1];
        this.coeff[0] = 0;
	exp = new int[1];
	this.exp[0] = 0;
    }
	
    public Polynomial(double[] coeff, int[] exp) {
	this.coeff = coeff;
	this.exp = exp;
    }
    
    public Polynomial(File file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader textReader = new BufferedReader(fr);
        String textData = textReader.readLine();
        String[] splitData = textData.split("[+]|(?=-)");
        
        double returnCoeff[] = new double[splitData.length];
        int returnExp[] = new int[splitData.length];
        int i = 0;
        for (String str: splitData) {
            if (str.contains("x")) {
                String[] tempSplit = str.split("x");
                returnCoeff[i] = Double.parseDouble(tempSplit[0]);
                returnExp[i] = Integer.parseInt(tempSplit[1]);
            }
            else {
                returnCoeff[i] = Double.parseDouble(str);
                returnExp[i] = 0;
            }
            i++;
        }
        this.coeff = returnCoeff;
        this.exp = returnExp;
    }
    
    public boolean inArray(int[] arr, int check) {
        for (int element: arr) {
            if (element == check) {
                return true;
            }
        }
        return false;
    }
    
    public int arrayIndex(int[] arr, int check) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == check) {
                return i;
            }
        }
        return -1;
    }
    
	
    public Polynomial add(Polynomial poly) {
        ArrayList<Integer> combinedExp = new ArrayList<>();
        ArrayList<Double> combinedCoeff = new ArrayList<>();
        for (int exps: this.exp) {
            if (!combinedExp.contains(exps)) {
                combinedExp.add(exps);
            }
        }
        for (int exps: poly.exp) {
            if (!combinedExp.contains(exps)) {
                combinedExp.add(exps);
            }
        }
        Collections.sort(combinedExp);
	
        for (int exps: combinedExp) {
            if (inArray(poly.exp, exps) && inArray(this.exp, exps)) {
                combinedCoeff.add(this.coeff[arrayIndex(this.exp, exps)] + poly.coeff[arrayIndex(poly.exp, exps)]);
            }
            else if (inArray(this.exp, exps)) {
                combinedCoeff.add(this.coeff[arrayIndex(this.exp, exps)]);
            }
            else if (inArray(poly.exp, exps)) {
                combinedCoeff.add(poly.coeff[arrayIndex(poly.exp, exps)]);
            }
        }
        
        double[] returnCoeff = combinedCoeff.stream().mapToDouble(i->i).toArray();
        int[] returnExp = combinedExp.stream().mapToInt(i->i).toArray();
        
        return (new Polynomial(returnCoeff,returnExp));
    }
    
    public Polynomial multiply(Polynomial poly) {
        double[] empty1 = {};
        int[] empty2 = {};
        Polynomial returnPoly = new Polynomial(empty1, empty2);
        
        for (int i = 0; i < poly.coeff.length; i++) {
            Polynomial tempPoly = new Polynomial(Arrays.copyOf(this.coeff, this.coeff.length), Arrays.copyOf(this.exp, this.exp.length));
            for (int n = 0; n < this.coeff.length; n++) {
                tempPoly.coeff[n] = tempPoly.coeff[n] * poly.coeff[i];
                tempPoly.exp[n] = tempPoly.exp[n] + poly.exp[i];
            }
            returnPoly = returnPoly.add(tempPoly);
        }
        return returnPoly;
    }
	
    public double evaluate(double x) {
	double result = 0;
        for (int i = 0; i < this.coeff.length; i++) {
            result = result + this.coeff[i]*Math.pow(x, this.exp[i]);
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
    
    public void saveToFile(String path) {
        String str;
        if (this.exp[0] == 0) {
            str = Double.toString(this.coeff[0]);
        }
        else {
            str = Double.toString(this.coeff[0]) + "x" + Integer.toString(this.exp[0]);
        }
        
        for (int i = 1; i < this.coeff.length; i++) {
            if (this.exp[i] == 0) {
                if (this.coeff[i] >= 0) {
                    str = str + "+" + Double.toString(this.coeff[i]);
                }
                else {
                    str = str + Double.toString(this.coeff[i]);
                }
            }
            else {
                if (this.coeff[i] >= 0) {
                    str = str + "+" + Double.toString(this.coeff[i]) + "x" + Integer.toString(this.exp[i]);
                }
                else {
                    str = str + Double.toString(this.coeff[i]) + "x" + Integer.toString(this.exp[i]);
                }
            }
        }
        
        try {
            FileWriter writer = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(str);
            bw.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}