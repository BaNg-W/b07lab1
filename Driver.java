package lab1; 

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Driver { 
	public static void main(String [] args) throws IOException{ 
            Polynomial p = new Polynomial(); 
            System.out.println(p.evaluate(3));

            double[] c1 = {-8,-1,3,1};
            int[] e1 = {0,1,3,5};
            Polynomial p1 = new Polynomial(c1, e1); 
            double [] c2 = {12,3,-5,2};
            int[] e2 = {0,2,3,4};
            Polynomial p2 = new Polynomial(c2, e2); 
            Polynomial s = p2.add(p1);
            System.out.println("(+) Correct Answer: \nNew polynomial s = coeff: [4.0, -1.0, 3.0, -2.0, 2.0, 1.0] + exp: [0, 1, 2, 3, 4, 5]");
            System.out.println("(+) Your Answer: \nNew polynomial s = coeff: " + Arrays.toString(s.coeff) + " + exp: " + Arrays.toString(s.exp) + "\n");
            s = p2.multiply(p1);
            System.out.println("(x) Correct Answer: \nNew polynomial s = coeff: [-96.0, -12.0, -24.0, 73.0, -11.0, 19.0, -15.0, 9.0, -5.0, 2.0] + exp: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]");
            System.out.println("(x) Your Answer: \nNew polynomial s = coeff: " + Arrays.toString(s.coeff) + " + exp: " + Arrays.toString(s.exp) + "\n");
            System.out.println("check p2 after multi: coeff: " + Arrays.toString(p2.coeff) + " + exp: " + Arrays.toString(p2.exp));
            System.out.println("check p1 after multi: coeff: " + Arrays.toString(p1.coeff) + " + exp: " + Arrays.toString(p1.exp) + "\n");

            double[] c5 = {-8,3,-1,1};
            int[] e5 = {0,3,1,5};
            Polynomial p5 = new Polynomial(c5, e5); 
            double [] c6 = {12,3,2,-5};
            int[] e6 = {0,2,4,3};
            Polynomial p6 = new Polynomial(c6, e6); 
            Polynomial t = p6.add(p5);
            System.out.println("Gigachad test (not for marks)");
            System.out.println("(+) Correct Answer: \nNew polynomial t = coeff: [4.0, -1.0, 3.0, -2.0, 2.0, 1.0] + exp: [0, 1, 2, 3, 4, 5]");
            System.out.println("(+) Your Answer: \nNew polynomial t = coeff: " + Arrays.toString(t.coeff) + " + exp: " + Arrays.toString(t.exp) + "\n");

            double[] c3 = {-3,5,3};
            int[] e3 = {0,1,2};
            Polynomial p3 = new Polynomial(c3, e3); 
            double [] c4 = {3,-5,1,2};
            int[] e4 = {0,1,2,3};
            Polynomial p4 = new Polynomial(c4, e4); 
            Polynomial y = p4.add(p3);
            System.out.println("(+) Correct Answer: \nNew polynomial y = coeff: [0.0, 0.0, 4.0, 2.0] + exp: [0, 1, 2, 3]");
            System.out.println("(+) Your Answer: \nNew polynomial y = coeff: " + Arrays.toString(y.coeff) + " + exp: " + Arrays.toString(y.exp) + "\n");
            y = p4.multiply(p3);
            System.out.println("(x) Correct Answer: \nNew polynomial y = coeff: [-9.0, 30.0, -19.0, -16.0, 13.0, 6.0] + exp: [0, 1, 2, 3, 4, 5]");
            System.out.println("(x) Your Answer: \nNew polynomial y = coeff: " + Arrays.toString(y.coeff) + " + exp: " + Arrays.toString(y.exp) + "\n");

            double[] c7 = {-3,5,3};
            int[] e7 = {0,1,2};
            Polynomial p7 = new Polynomial(c7, e7); 
            double [] c8 = {};
            int[] e8 = {};
            Polynomial p8 = new Polynomial(c8, e8); 
            Polynomial w = p8.add(p7);
            System.out.println("(+) Correct Answer: \nNew polynomial w = coeff: [-3.0, 5.0, 3.0] + exp: [0, 1, 2]");
            System.out.println("(+) Your Answer: \nNew polynomial w = coeff: " + Arrays.toString(w.coeff) + " + exp: " + Arrays.toString(w.exp) + "\n");

            double[] c9 = {-3,5,3};
            int[] e9 = {0,1,2};
            Polynomial p9 = new Polynomial(c9, e9); 
            Polynomial p0 = new Polynomial(); 
            Polynomial x = p9.add(p0);
            System.out.println("(+) Correct Answer: \nNew polynomial x = coeff: [-3.0, 5.0, 3.0] + exp: [0, 1, 2]");
            System.out.println("(+) Your Answer: \nNew polynomial x = coeff: " + Arrays.toString(x.coeff) + " + exp: " + Arrays.toString(x.exp) + "\n");

            Polynomial z = p0.add(p9);
            System.out.println("(+) Correct Answer: \nNew polynomial z = coeff: [-3.0, 5.0, 3.0] + exp: [0, 1, 2]");
            System.out.println("(+) Your Answer: \nNew polynomial z = coeff: " + Arrays.toString(z.coeff) + " + exp: " + Arrays.toString(z.exp) + "\n");
            
            System.out.println("s(0.1) = " + s.evaluate(0.1));
            System.out.println("s(0.1 should be -97.36792...");
            if(s.hasRoot(1)) 
                    System.out.println("1 is a root of s"); 
            else
                    System.out.println("1 is not a root of s");
            
            // textfile contains: -5-3x2+7x8+1x21
            File f = new File("C:\\Users\\bang3\\Desktop\\readFrom.txt");
            Polynomial b = new Polynomial(f);
            System.out.println("Correct Read: \nNew polynomial b = coeff: [-5.0, -3.0, 7.0, 1.0] + exp: [0, 2, 8, 21]");
            System.out.println("Your Read: \nNew polynomial b = coeff: " + Arrays.toString(b.coeff) + " + exp: " + Arrays.toString(b.exp) + "\n");
            
            b.saveToFile("C:\\Users\\bang3\\Desktop\\writeTo.txt");
	} 
}