package testing;

import java.util.Arrays;

public class testings {



    private static double getClosest(double[] a, double t) {
        int index = 0;

        for (int i = 1; i < a.length; i++) {
            if (Math.abs(a[i] - t) < Math.abs(a[index] - t)) {
                double diff = Math.abs(a[i] - t);
            }
        }
        return 0.0;
    }

    private static double[] closestPair(double[] a) {
        double[] r = new double[2];
        r[0] = a[0];
        r[1] = a[1];
        for(int i = 0; i < a.length; i++) {
            for(int j = i+1; j < a.length; j++) {
                if(Math.abs(a[i] - a[j]) < Math.abs(r[0] - r[1])) {
                    r[0] = a[i];
                    r[1] = a[j];
                }
            }
        }
        return r;
    }


    public static void main(String[] args) {
        double[] a = {1.2,2.3,1.1,2.5,8.9,2.9};
        double t = -2;
        System.out.println(Arrays.toString(closestPair(a)));
    }
}
